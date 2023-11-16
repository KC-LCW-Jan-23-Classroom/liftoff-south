package boozeblender.models.DTO;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class RegisterFormDTO extends LoginFormDTO{

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;
    @NotNull
    private Date birthday;
    @NotNull
    @Email
    private String email;
//    @NotNull
//    private String address;


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }



    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
