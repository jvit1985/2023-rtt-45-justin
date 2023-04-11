package springexamples.formbeans;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import springexamples.validation.EmailUnique;


@Getter
@Setter
@ToString
public class EmployeeFormBean {

    private Integer id;

    @NotEmpty(message = "Email address is required.")
    @Length(max = 20, message = "Email can not be longer than 20 characters")
    @Pattern(regexp = ".+@.+\\.[a-z]+", message = "Invalid email format")
    @EmailUnique(message = "Email already exists in database")
    private String email;

    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    private String lastName;

    private String jobTitle;

    private String profileImage;

    private String extension;

    @Max(value = 100, message = "You cannot have more than 100 vacation hours")
    @Min(value = 0, message = "You cannot have less than 0 vacation hours")
    private Integer vacationHours;

    private Integer officeId;
}
