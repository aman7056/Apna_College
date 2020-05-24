package com.amati.apnacollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView item1, item2, item3, item4, item5, item6, item7, item8;
    private MaterialToolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.mtoolbar);
        setSupportActionBar(mToolbar);
        setTitle("Apna College");

        Toast.makeText(this, "This App is Developed by Aman Tiwari", Toast.LENGTH_SHORT).show();

        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);
        item5 = findViewById(R.id.item5);
        item6 = findViewById(R.id.item6);
        item7 = findViewById(R.id.item7);
        item8 = findViewById(R.id.item8);

        item1.setOnClickListener(this);
        item2.setOnClickListener(this);
        item3.setOnClickListener(this);
        item4.setOnClickListener(this);
        item5.setOnClickListener(this);
        item6.setOnClickListener(this);
        item7.setOnClickListener(this);
        item8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.item1:
               startActivity(new Intent(MainActivity.this, Lecture.class));
                break;

            case R.id.item2:
                Uri uri3 = Uri.parse("http://hsbte.org.in/pdf/Stream_info/COMPUTER%20ENGG/Detailed%20Content%20Sem%204.pdf");
                Intent syllabusLink = new Intent(Intent.ACTION_VIEW, uri3);
                startActivity(syllabusLink);
                break;

            case R.id.item3:
               startActivity(new Intent(MainActivity.this, UsersTab.class));
                break;

            case R.id.item4:
               startActivity(new Intent(MainActivity.this, ProfileTab.class));
                break;

            case R.id.item5:
                Uri uri = Uri.parse("http://gpjhajjar.ac.in/");
                Intent collegeLink = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(collegeLink);
                break;

            case R.id.item6:
                Uri uri1 = Uri.parse("http://result.hsbte.com/");
                Intent resultLink = new Intent(Intent.ACTION_VIEW, uri1);
                startActivity(resultLink);
                break;

            case R.id.item7:
                Uri uri2 = Uri.parse("http://hsbte.org.in/");
                Intent newsLink = new Intent(Intent.ACTION_VIEW, uri2);
                startActivity(newsLink);
                break;
            case R.id.item8:
               startActivity(new Intent(MainActivity.this, Devloper.class));
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                ParseUser.logOut();
                startActivity(new Intent(MainActivity.this, LoginPage.class));
                finish();
                break;

            case R.id.editInfo:
                startActivity(new Intent(MainActivity.this, infoTab.class));
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

