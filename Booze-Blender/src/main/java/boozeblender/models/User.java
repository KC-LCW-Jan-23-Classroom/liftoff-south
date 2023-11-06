package boozeblender.models;


import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User extends AbstractEntity {


    @NotBlank(message = "Please enter a valid user name. It cannot be blank.")
    @Size(min = 5, max = 20)
    private String username;
    @NotBlank(message = "Please enter your birth date. It cannot be blank.")
    private int birthday;

    private String email;

    private String address;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 8 characters long!")
    private String password;

    @NotNull(message = "Passwords do not match!")
    private String verifyPassword;

    public User() {
    }


    public User(String username, int birthday, String email, String address, String password, String verifyPassword) {
        this.username = username;
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        this.password = password;
        this.verifyPassword = verifyPassword;
    }

    public int getBirthday() {
        return birthday;
    }



    public void setBirthday(int birthday) {
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
