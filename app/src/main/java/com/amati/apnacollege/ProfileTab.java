package com.amati.apnacollege;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.parse.ParseUser;

public class ProfileTab extends AppCompatActivity {

    private TextView txtName,  txtRoll, txtBranch, txtSem, txtPhone;
    private Button editBtn;
    private MaterialToolbar materialToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_tab);

        materialToolbar = findViewById(R.id.mtoolbar2);

        txtName = findViewById(R.id.txtName);
        txtBranch = findViewById(R.id.txtName3);
        txtRoll = findViewById(R.id.txtName2);
        txtSem = findViewById(R.id.txtName4);
        txtPhone = findViewById(R.id.txtName5);

        editBtn = findViewById(R.id.edtbtn);

        final ParseUser parseUser = ParseUser.getCurrentUser();

        setSupportActionBar(materialToolbar);
        setTitle(parseUser.getUsername().toString());

        txtName.setText(parseUser.get("name") + "");
        txtPhone.setText(parseUser.get("phone") + "") ;
        txtSem.setText( parseUser.get("sem") + "" );
        txtRoll.setText(parseUser.get("rollno") + "" );
        txtBranch.setText(parseUser.get("branch") + "");


        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileTab.this, infoTab.class));
                finish();
            }
        });




    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
