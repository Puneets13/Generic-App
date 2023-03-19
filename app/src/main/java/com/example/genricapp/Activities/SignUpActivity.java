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
    ProgressDialog progressDialog ;
    TextView signInLink;
    Switch Switch;
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
                String username = name.getText().toString();
                String useremail = email.getText().toString();
                String userpassword = password.getText().toString();
                String userConfirm = confirmPassword.getText().toString();
                String userPhoneNumber = phoneNumber.getText().toString();


                if(!userpassword.equals(userConfirm)){
                    Toast.makeText(SignUpActivity.this, "Password Do not match", Toast.LENGTH_SHORT).show();
                    return;
                }

//                RegisterResponse  registerResponse = new RegisterResponse(username,useremail,userPhoneNumber,userpassword);
//                String request = new Gson().toJson(registerResponse);


//        RegisterResponse registerResponse = new RegisterResponse(username,useremail,userPhoneNumber,userpassword);
//                Map<String,String> params = new HashMap<String, String>();
//                params.put("username", username);
//                params.put("email", useremail);
//                params.put("phone", userPhoneNumber);
//                params.put("password", userpassword);


                RequestBody name = RequestBody.create(MediaType.parse("multipart/form-data"), username);
                RequestBody email = RequestBody.create(MediaType.parse("multipart/form-data"), useremail);
                RequestBody phone = RequestBody.create(MediaType.parse("multipart/form-data"), userPhoneNumber);
                RequestBody password = RequestBody.create(MediaType.parse("multipart/form-data"), userpassword);


//        //        uploading the data using Multipart-Form
//        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"),file);
//        MultipartBody.Part body = MultipartBody.Part.createFormData("photo", file.getName(),requestFile);
//

                Call<RegisterResponse> call = RetrofitClient.getInstance().getApi()
                        .Register(name,email,phone,password);

        call.enqueue(new Callback<RegisterResponse>() {

            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                RegisterResponse responseFromAPi = response.body();

                if (response.body().getSuccess().equals("1")) {
                    if (response.body().getMessage().equals("Registration Done")) {
                    Intent intent=new Intent(SignUpActivity.this, OTPActivity.class);
                    startActivity(intent);
                        Toast.makeText(SignUpActivity.this, "response received", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(SignUpActivity.this, "Registeraion not doone", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(SignUpActivity.this, "error", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(SignUpActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

            }
        });
    }
}