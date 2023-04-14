package springexamples.formbeans;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CreateUserFormBean {

    @NotEmpty(message = "Email cannot be empty")
    private String email;

    @NotEmpty(message = "Full Name cannot be empty")
    private String fullName;

    @NotEmpty(message = "Password cannot be empty")
    private String password;

    @NotEmpty(message = "Confirm password cannot be empty")
    private String confirmPassword;
}
