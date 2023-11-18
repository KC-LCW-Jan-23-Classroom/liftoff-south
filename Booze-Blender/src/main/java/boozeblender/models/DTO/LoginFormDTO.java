package boozeblender.models.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginFormDTO {


    @NotNull
    @Size(min = 5, max = 12, message = "Invalid username. Must be between 5 and 12 characters long!")
    private String username;

    @NotNull
    @Size(min = 8, max = 12, message = "Invalid. Password must be between 8 and 12 characters long!")
    private String password;
//    @NotNull
//    private Date birthday;
//    @NotNull
//    private String email;
//    @NotNull
//    private String address;
//
//
//    public Date getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(Date birthday) {
//        this.birthday = birthday;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
