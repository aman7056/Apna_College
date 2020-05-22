    package com.amati.apnacollege;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

    public class infoTab extends AppCompatActivity {
    private EditText name, roll, branch, sem, phone;
    private Button saveInfo;
    private MaterialToolbar materialToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_tab);

        materialToolbar = findViewById(R.id.mytoolbar);
        setSupportActionBar(materialToolbar);
        setTitle("Edit Personal Info.");

        name = findViewById(R.id.editName);
        roll = findViewById(R.id.editRollNumber);
        branch = findViewById(R.id.editBranch);
        sem = findViewById(R.id.editSem);
        phone = findViewById(R.id.editPhone);

        saveInfo = findViewById(R.id.saveInfo);

        final ParseUser parseUser = ParseUser.getCurrentUser();

        saveInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().equals("") || roll.getText().toString().equals("") ||
                        branch.getText().toString().equals("") ||
                        sem.getText().toString().equals("") ||
                        phone.getText().toString().equals("") )
                {
                    Toast.makeText(infoTab.this, "Details are required", Toast.LENGTH_SHORT).show();
                }else {
                    parseUser.put("name", name.getText().toString());
                    parseUser.put("rollno", roll.getText().toString());
                    parseUser.put("branch", branch.getText().toString());
                    parseUser.put("sem", sem.getText().toString());
                    parseUser.put("phone", phone.getText().toString());


                    final ProgressDialog progressDialog = new ProgressDialog(infoTab.this);
                    progressDialog.setMessage("Saving your Details");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    parseUser.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (e == null){
                                Toast.makeText(infoTab.this, "Sucessfully Saved Your details", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(infoTab.this, MainActivity.class));
                                finish();
                            }else {
                                Toast.makeText(infoTab.this, e.getMessage() + "", Toast.LENGTH_SHORT).show();
                            }

                            progressDialog.dismiss();
                        }
                    });




                }
            }
        });
    }

    public void rootTapped (View view){
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }catch (Exception e){
            e.printStackTrace();

        }

    }
}
