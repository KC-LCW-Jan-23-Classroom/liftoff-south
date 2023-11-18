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
    private String username;

    @NotBlank
    //private String password;
    private String pwHash;
    @Email
    private String email;


    private String birthday;

    private String verifyPassword;



    public User() {
    }


    public User(String username,  String password) {
        this.username = username;
        this.pwHash = encoder.encode(password);
    }

    public User(String username, String password,  String email, String birthday){
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.email = email;
        this.birthday = birthday;
    }



    public String getBirthday() {
        return birthday;
    }



    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;

        }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }



}

