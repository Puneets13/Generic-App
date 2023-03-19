package com.example.genricapp.Model;

public class OTP_Response {
    String success,message,otp;
String email,phone;
//
//    public OTP_Response(String email, String phone) {
//        this.email = email;
//        this.phone = phone;
//    }

    public OTP_Response(String success, String message, String otp) {
        this.success = success;
        this.message = message;
        this.otp = otp;
    }

    public String getSuccess() {
        return success;
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

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
