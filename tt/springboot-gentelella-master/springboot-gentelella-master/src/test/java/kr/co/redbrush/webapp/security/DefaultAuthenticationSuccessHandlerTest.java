package kr.co.redbrush.webapp.security;

import kr.co.redbrush.webapp.domain.Account;
import kr.co.redbrush.webapp.domain.Role;
import kr.co.redbrush.webapp.domain.SecureAccount;
import kr.co.redbrush.webapp.service.AccessHistoryService;
import kr.co.redbrush.webapp.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Slf4j
public class DefaultAuthenticationSuccessHandlerTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    public DefaultAuthenticationSuccessHandler defaultAuthenticationSuccessHandler = new DefaultAuthenticationSuccessHandler();

    @Mock
    private AccountService accountService;

    @Mock
    private AccessHistoryService accessHistoryService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private Authentication authentication;

    private String username = "user";
    private String password = "password";
    private String invalidUsername = "invalid";
    private SecureAccount userDetails;
    private List<Role> roles;

    @Before
    public void before() {
        Role role = new Role();
        role.setRoleName("ADMIN");

        roles = new ArrayList<>();
        roles.add(role);

        Account account = new Account();
        account.setUserId(username);
        account.setPassword(password);
        account.setRoles(roles);

        userDetails = new SecureAccount(account);

        when(authentication.getPrincipal()).thenReturn(userDetails);
    }

    @Test
    public void onAuthenticationSuccess() throws Exception {
        defaultAuthenticationSuccessHandler.onAuthenticationSuccess(request, response, authentication);

        verify(accountService).processLoginSuccess(userDetails.getAccount());
    }
}