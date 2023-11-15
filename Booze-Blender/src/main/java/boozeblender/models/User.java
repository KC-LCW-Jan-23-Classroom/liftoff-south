package boozeblender.models;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;

@Entity
public class User extends AbstractEntity {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    @NotBlank
    @Size(min = 3, max = 20, message = "Invalid username. Must be between 3 and 20 characters.")
    private String username;


    private Date birthday;


    @Email
    private String email;

    private String address;
    @NotBlank
    //private String password;
    private String pwHash;

//    @NotNull(message="Passwords do not match")
//    @Transient
//    private String verifyPassword;

    public User() {
    }


    public User(String username,  String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);



    }

    public User(Date birthday, String email, String address, String verifyPassword){
        this.birthday = birthday;
        this.email = email;
        this.address = address;
        //this.verifyPassword = verifyPassword;

    }



    public Date getBirthday() {
        return birthday;
    }



    public void setBirthday(Date birthday) {
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

//    public void setUsername(String username) {
//        this.username = username;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public String getPassword() {
//        return this.pwHash;
//    }

//    public void setPassword(String password) {
//        this.password = password;
//    }

//    public String getVerifyPassword() {
//        return verifyPassword;
//    }

//    public void setVerifyPassword(String verifyPassword) {
//        this.verifyPassword = verifyPassword;
//        if (password != null && !password.equals(verifyPassword)) {
//            this.verifyPassword = null;
//        }
//    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }



}

