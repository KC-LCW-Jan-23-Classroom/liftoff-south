package boozeblender.models;


import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.sql.Date;

@Entity
public class User extends AbstractEntity {


    @NotBlank(message = "Username required!")
    @Size(min = 5, max = 20, message = "Invalid. Username must be between 5 and 12 characters long!")
    private String username;

    @NotBlank(message = "Birthday is required!")

    private String birthday;


    @NotBlank(message = "Email is required!")
    @Email(message = "Please enter a valid email.")
    private String email;

    private String address;
    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 12, message = "Invalid. Password must be between 8 and 12 characters long!")
    private String password;

    @NotNull(message = " Invalid. Passwords do not match!")
    private String verifyPassword;

    public User() {
    }


    public User(String username, String birthday, String email, String address, String password, String verifyPassword) {
        this.username = username;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public String getBirthday() {
        return birthday;
    }



    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        if (password != null && !password.equals(verifyPassword)) {
            this.verifyPassword = null;
        }
    }



}
