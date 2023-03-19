package com.example.genricapp.Model;

public class details {
    String id,wallet,username,fathername,dob,otp,phone,email,password,gender,address;
    String image,
            regId ,
            deviceType,loginType,
            social_id,
            latitude,
            longitude,
            online_status,
            notificationType,
            created, updated ,
            verifyPhoneStatus,
            active_status,
            block_unblock_status,
            device_id;

    public details(String id, String wallet, String username, String fathername, String dob, String otp, String phone, String email, String password, String gender, String address, String image, String regId, String deviceType, String loginType, String social_id, String latitude, String longitude, String online_status, String notificationType, String created, String updated, String verifyPhoneStatus, String active_status, String block_unblock_status, String device_id) {
        this.id = id;
        this.wallet = wallet;
        this.username = username;
        this.fathername = fathername;
        this.dob = dob;
        this.otp = otp;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.image = image;
        this.regId = regId;
        this.deviceType = deviceType;
        this.loginType = loginType;
        this.social_id = social_id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.online_status = online_status;
        this.notificationType = notificationType;
        this.created = created;
        this.updated = updated;
        this.verifyPhoneStatus = verifyPhoneStatus;
        this.active_status = active_status;
        this.block_unblock_status = block_unblock_status;
        this.device_id = device_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getSocial_id() {
        return social_id;
    }

    public void setSocial_id(String social_id) {
        this.social_id = social_id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getOnline_status() {
        return online_status;
    }

    public void setOnline_status(String online_status) {
        this.online_status = online_status;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getVerifyPhoneStatus() {
        return verifyPhoneStatus;
    }

    public void setVerifyPhoneStatus(String verifyPhoneStatus) {
        this.verifyPhoneStatus = verifyPhoneStatus;
    }

    public String getActive_status() {
        return active_status;
    }

    public void setActive_status(String active_status) {
        this.active_status = active_status;
    }

    public String getBlock_unblock_status() {
        return block_unblock_status;
    }

    public void setBlock_unblock_status(String block_unblock_status) {
        this.block_unblock_status = block_unblock_status;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
