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
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

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

                ParseQuery<ParseUser> parseQuery = ParseUser.getQuery();
                parseQuery.whereEqualTo("username", arrayList.get(position));
                parseQuery.getFirstInBackground(new GetCallback<ParseUser>() {
                    @Override
                    public void done(ParseUser object, ParseException e) {
                        if (object != null && e == null){


                            final PrettyDialog prettyDialog = new PrettyDialog(UsersTab.this);
                            prettyDialog.setTitle(object.getUsername() + " 's Info.");
                            prettyDialog.setMessage(object.get("name") + "\n"
                                    + object.get("rollno") + "\n" +
                                    object.get("branch") + "\n" +
                                    object.get("sem") + "\n" +
                                    object.get("phone"))
                            .setIcon(R.drawable.ic_account_circle_black_24dp)
                                    .addButton("OK",
                                            R.color.pdlg_color_white,
                                            R.color.pdlg_color_blue,
                                            new PrettyDialogCallback() {
                                                @Override
                                                public void onClick() {
                                                    prettyDialog.dismiss();
                                                }
                                            }
                                    ).show();


                        }
                    }
                });



            }
        });

    }
}