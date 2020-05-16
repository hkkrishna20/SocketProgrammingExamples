package kr.co.redbrush.webapp.security;

import kr.co.redbrush.webapp.domain.Account;
import kr.co.redbrush.webapp.domain.Role;
import kr.co.redbrush.webapp.domain.SecureAccount;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.mockito.Mockito.when;

@Slf4j
public class DefaultAuthenticationProviderTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    public DefaultAuthenticationProvider defaultAuthenticationProvider = new DefaultAuthenticationProvider();

    @Mock
    private UserDetailsService userDetailsService;

    @Mock
    private UsernamePasswordAuthenticationToken token;

    private String username = "user";
    private String password = "password";
    private String invalidUsername = "invalid";
    private SecureAccount userDetails;
    private List<Role> roles;

    @Before
    public void before() {
        Role role = new Role();
        role.setRoleName("ADMIN");

        roles = new ArrayList<Role>();
        roles.add(role);

        Account account = new Account();
        account.setUserId(username);
        account.setPassword(password);
        account.setRoles(roles);

        userDetails = new SecureAccount(account);

        when(userDetailsService.loadUserByUsername(username)).thenReturn(userDetails);
        when(userDetailsService.loadUserByUsername(invalidUsername)).thenReturn(null);
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testAuthenticateShouldReturnUsernameNotFoundException() throws Exception {
        when(token.getName()).thenReturn(null);

        defaultAuthenticationProvider.authenticate(token);
    }

    @Test(expected = BadCredentialsException.class)
    public void testAuthenticateShouldReturnBadCredentialsException() throws Exception {
        when(token.getName()).thenReturn(username);
        when(token.getCredentials()).thenReturn(null);

        defaultAuthenticationProvider.authenticate(token);
    }

    @Test
    public void testAuthenticate() throws Exception {
        when(token.getName()).thenReturn(username);
        when(token.getCredentials()).thenReturn(password);

        Authentication authentication = defaultAuthenticationProvider.authenticate(token);

        LOGGER.debug("authentication : {}", authentication);

        assertThat("Unexpected value.", authentication, notNullValue());
        assertThat("Unexpected value.", authentication.getPrincipal(), is(username));
        assertThat("Unexpected value.", authentication.getCredentials(), is(password));
    }

    @Test
    public void testSupports() throws Exception {
        boolean positiveResult = defaultAuthenticationProvider.supports(UsernamePasswordAuthenticationToken.class);

        assertThat("Unexpected value.", positiveResult, is(true));

        boolean negativeResult = defaultAuthenticationProvider.supports(TestingAuthenticationToken.class);

        assertThat("Unexpected value.", negativeResult, is(false));
    }
}