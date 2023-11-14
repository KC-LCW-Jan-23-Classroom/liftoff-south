package boozeblender.models.DTO;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class RegisterFormDTO extends LoginFormDTO{

    private String verifyPassword;
    @NotNull
    private Date birthday;
    @NotNull
    private String email;
    @NotNull
    private String address;


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
