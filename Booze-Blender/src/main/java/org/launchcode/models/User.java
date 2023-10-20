package org.launchcode.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {


    @NotBlank(message = "Please enter a valid user name. It cannot be blank.")
    @Size(min = 5, max = 20)
    private String username;

    @Email(message = "Please enter a valid email address.")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 8 characters long!")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    public User() {
    }

    public User(String username, String email, String password, String verifyPassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.verifyPassword = verifyPassword;
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
        return password;
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
