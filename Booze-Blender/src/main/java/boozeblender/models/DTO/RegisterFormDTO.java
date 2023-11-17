package boozeblender.models.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class RegisterFormDTO extends LoginFormDTO{

    @NotNull(message = "Passwords do not match")
    @NotBlank(message = "Field required!")
    private String verifyPassword;

    @NotNull
    @NotBlank(message = "Birthday is required!")
    private String birthday;
    @NotNull
    @NotBlank(message = "Email is required!")
    @Email(message = "Please enter a valid email.")
    private String email;



    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
