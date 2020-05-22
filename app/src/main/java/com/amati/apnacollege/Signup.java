package com.amati.apnacollege;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class Signup extends AppCompatActivity implements View.OnClickListener {
    private EditText username, email, password;
    private Button signup, loginPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        username = findViewById(R.id.username);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        signup = findViewById(R.id.SignUp);
        loginPage = findViewById(R.id.LoginPage);

        signup.setOnClickListener(this);
        loginPage.setOnClickListener(this);

        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    onClick(signup);
                }


                return false;
            }
        });

        if (ParseUser.getCurrentUser() != null){
            gotoHome();
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SignUp:
                if (username.getText().toString().equals("") || password.getText().toString().equals("") || email.getText().toString().equals("")){
                    Toast.makeText(this, "Please Fill Your Details", Toast.LENGTH_SHORT).show();
                }else {
                    ParseUser college = new ParseUser();
                    college.setUsername(username.getText().toString());
                    college.setPassword(password.getText().toString());
                    college.setEmail(email.getText().toString());

                    final ProgressDialog progressDialog = new ProgressDialog(Signup.this);
                    progressDialog.setMessage("Making Your New Account");
                    progressDialog.setCancelable(false);
                    progressDialog.show();
                    college.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null) {
                                progressDialog.dismiss();
                                startActivity(new Intent(Signup.this, infoTab.class));
                                finish();


                            } else {
                                Toast.makeText(Signup.this, e.getMessage() + "", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });
                }

                break;
            case R.id.LoginPage:
                Toast.makeText(this, "Taking you to Login Page", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void rootTapped (View view){
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);

        }catch (Exception e){

            e.printStackTrace();
        }
    }

    public void gotoHome () {
        Intent intent = new Intent(Signup.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
