package com.teksystems.formbeans;

import com.teksystems.validation.EmailUnique;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;


@Getter
@Setter
@ToString
public class CreateUserFormBean {

    @NotEmpty(message = "Email address is required")
    @Length(max = 100, message = "Email can not be longer than 100 characters")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid email format")
    @EmailUnique(message = "Email already exists in database")
    private String email;

    @NotEmpty(message = "Password is required")
    @Length(max = 100, message = "Password cannot be longer than 100 characters")
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{7,20}$", message = "Invalid password format")
    private String password;

    private String confirmPassword;

    @NotEmpty(message = "First name is required")
    @Length(max = 45, message = "First name cannot be longer than 45 characters")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    @Length(max = 45, message = "Last name cannot be longer than 45 characters")
    private String lastName;
}
