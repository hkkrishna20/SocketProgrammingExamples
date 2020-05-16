package kr.co.redbrush.webapp.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupForm {
    @NotEmpty(message = "{validation.userId.NotEmpty}")
    @Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z0-9_]{3,20}$", message = "{validation.userId.Pattern}")
    private String userId;

    @NotEmpty(message = "{validation.name.NotEmpty}")
    private String name;

    @NotEmpty(message = "{validation.email.NotEmpty}")
    @Email(message = "{validation.email.Email}")
    private String email;

    @NotEmpty(message = "{validation.password.NotEmpty}")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=])(?=\\S+$).{8,20}$", message = "{validation.password.Pattern}")
    private String password;
}
