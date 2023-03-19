package com.example.genricapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.genricapp.Model.OTP_Response;
import com.example.genricapp.Model.RegisterResponse;
import com.example.genricapp.R;
import com.example.genricapp.RetrofitClient;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    EditText name, email, password,phoneNumber,confirmPassword;
    Button register;
    TextView signInLink;
    Switch Switch;

    String username, useremail,userpassword,userPhoneNumber,  userConfirm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        name = findViewById(R.id.etuserName);
        email=findViewById(R.id.etemail);
        password=findViewById(R.id.etpassword);
        confirmPassword=findViewById(R.id.etconfirmPass);
        phoneNumber=findViewById(R.id.etNumber);
        register=findViewById(R.id.btnSignUp);
        signInLink=findViewById(R.id.SignInLink);
//getActionBar().hide();
getSupportActionBar().hide();

signInLink.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(SignUpActivity.this, SignInActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
});
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 username = name.getText().toString();
                 useremail = email.getText().toString();
                 userpassword = password.getText().toString();
                 userConfirm = confirmPassword.getText().toString();
                 userPhoneNumber = phoneNumber.getText().toString();

                if(username.isEmpty()){
                    name.setFocusable(true);
                    name.setError("Enter UserName");
                    return ;
                }
                if(useremail.isEmpty()){
                    name.setFocusable(true);
                    name.setError("Enter Email");
                    return ;
                }
                if(userpassword.isEmpty()){
                    name.setFocusable(true);
                    name.setError("Enter password");
                    return ;
                }
                if(userConfirm.isEmpty()){
                    name.setFocusable(true);
                    name.setError("Enter password");
                    return ;
                }

                if(userPhoneNumber.isEmpty()){
                    name.setFocusable(true);
                    name.setError("Enter Phone");
                    return ;
                }
                if(!userpassword.equals(userConfirm)){
                    Toast.makeText(SignUpActivity.this, "Password do not match", Toast.LENGTH_SHORT).show();
                    return;
                }


                RequestBody name = RequestBody.create(MediaType.parse("multipart/form-data"), username);
                RequestBody email = RequestBody.create(MediaType.parse("multipart/form-data"), useremail);
                RequestBody phone = RequestBody.create(MediaType.parse("multipart/form-data"), userPhoneNumber);
                RequestBody password = RequestBody.create(MediaType.parse("multipart/form-data"), userpassword);
                RequestBody reg_id = RequestBody.create(MediaType.parse("multipart/form-data"), "");
                RequestBody device_id = RequestBody.create(MediaType.parse("multipart/form-data"), "");
                RequestBody login_type = RequestBody.create(MediaType.parse("multipart/form-data"), "");
                RequestBody latitude = RequestBody.create(MediaType.parse("multipart/form-data"), "");
                RequestBody longitude = RequestBody.create(MediaType.parse("multipart/form-data"), "");
                RequestBody chatId = RequestBody.create(MediaType.parse("multipart/form-data"), "");



                Call<RegisterResponse> call = RetrofitClient.getInstance().getApi()
                        .Register(name,email,phone,password,reg_id,device_id,login_type,latitude,longitude,chatId);

        call.enqueue(new Callback<RegisterResponse>() {

            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                if (response.body().getSuccess().equals("1")) {
                    if (response.body().getMessage().equals("Registration Done")) {
//                        otpsent(useremail,userPhoneNumber); //to send the otp to user
                        Toast.makeText(SignUpActivity.this, response.body().getDetails().getUsername()+" Registerd", Toast.LENGTH_SHORT).show();
                        otpSent();

                    }else{
                        Toast.makeText(SignUpActivity.this, "some thing went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(SignUpActivity.this, "some thing went wrong", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

            }

//            to send the OTP (uniqueAPI)
            private void otpSent() {

                RequestBody email = RequestBody.create(MediaType.parse("multipart/form-data"), useremail);
                RequestBody phone = RequestBody.create(MediaType.parse("multipart/form-data"), userPhoneNumber);

                Call<OTP_Response> call = RetrofitClient.getInstance().getApi().sent_OTP(email,phone);
                call.enqueue(new Callback<OTP_Response>() {
                    @Override
                    public void onResponse(Call<OTP_Response> call, Response<OTP_Response> response) {
                        Toast.makeText(SignUpActivity.this, "response", Toast.LENGTH_SHORT).show();
                        if(response.body().getMessage().equals("OTP Sent")){
                                String otp = response.body().getOtp();
                                Intent intent=new Intent(SignUpActivity.this, OTPActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                        }else{
                                Toast.makeText(SignUpActivity.this, "User Already Exist", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<OTP_Response> call, Throwable t) {
                        Toast.makeText(SignUpActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}