package com.amati.apnacollege;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView item1, item2, item3, item4, item5, item6, item7, item8;
    private MaterialToolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.mtoolbar);
        setSupportActionBar(mToolbar);
        setTitle("");

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
                Toast.makeText(this, "Lecture", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item2:
                Toast.makeText(this, "Syllabus", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item3:
                Toast.makeText(this, "Users", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item4:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item5:
                Toast.makeText(this, "College", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item6:
                Toast.makeText(this, "Result", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item7:
                Toast.makeText(this, "News", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item8:
                Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

