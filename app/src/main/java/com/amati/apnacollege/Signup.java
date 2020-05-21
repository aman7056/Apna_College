package com.amati.apnacollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity implements View.OnClickListener {
    private EditText username, email, password, phone;
    private Button signup, loginPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.username);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        phone = findViewById(R.id.Phone);

        signup = findViewById(R.id.SignUp);
        loginPage = findViewById(R.id.LoginPage);

        signup.setOnClickListener(this);
        loginPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SignUp:
                startActivity(new Intent(Signup.this, MainActivity.class));
                Toast.makeText(this, "Please Wait SigingUp", Toast.LENGTH_SHORT).show();
                break;
            case R.id.LoginPage:
                Toast.makeText(this, "Taking you to Login Page", Toast.LENGTH_SHORT).show();
                break;


        }

    }
}
