package com.amati.apnacollege;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class UsersTab extends AppCompatActivity {
    private MaterialToolbar materialToolbar;
    private ListView listView;
    private ArrayList arrayList;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_tab);

        materialToolbar = findViewById(R.id.mtoolbar1);
        setSupportActionBar(materialToolbar);
        setTitle("Users");

        listView = findViewById(R.id.lv);
        arrayList = new ArrayList();
        arrayAdapter = new ArrayAdapter(UsersTab.this, android.R.layout.simple_list_item_1, arrayList);


        ParseQuery<ParseUser> parseQuery = ParseUser.getQuery();
        parseQuery.whereNotEqualTo("username", ParseUser.getCurrentUser().getUsername());

        final ProgressDialog progressDialog = new ProgressDialog(UsersTab.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Downloading User's Data");
        progressDialog.show();

        parseQuery.findInBackground(new FindCallback<ParseUser>() {
            @Override
            public void done(List<ParseUser> objects, ParseException e) {
                if (objects.size()>0){
                    for (ParseUser user : objects){
                        arrayList.add(user.getUsername());
                    }

                    listView.setAdapter(arrayAdapter);
                    progressDialog.dismiss();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(UsersTab.this, arrayList.get(position)  + "", Toast.LENGTH_SHORT).show();
            }
        });

    }
}