package com.example.genricapp.Model;

public class RegisterResponse {
    String username , email , phone,password;
    String success , message ;
details details;

    public String getSuccess() {
        return success;
    }

    public com.example.genricapp.Model.details getDetails() {
        return details;
    }

    public void setDetails(com.example.genricapp.Model.details details) {
        this.details = details;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

//    public RegisterResponse(String username, String email, String phone, String password) {
//        this.username = username;
//        this.email = email;
//        this.phone = phone;
//        this.password = password;
//    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
