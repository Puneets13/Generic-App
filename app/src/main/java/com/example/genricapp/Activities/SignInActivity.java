package com.example.genricapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.genricapp.R;

public class SignInActivity extends AppCompatActivity {
    EditText  email, password;
    Button signIn;
    TextView signUpLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getSupportActionBar().hide();
        email = findViewById(R.id.etemail);
        password=findViewById(R.id.etpassword);
        signIn=findViewById(R.id.btnSignIn);
        signUpLink=findViewById(R.id.SignUpLink);
        getSupportActionBar().hide();

        signUpLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignInActivity.this, SignUpActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SignInActivity.this, "Move to DashBoard Activity", Toast.LENGTH_SHORT).show();

            }
        });

    }
}