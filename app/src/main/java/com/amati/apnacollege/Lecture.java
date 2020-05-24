package com.amati.apnacollege;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.appbar.MaterialToolbar;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import libs.mjn.prettydialog.PrettyDialog;
import libs.mjn.prettydialog.PrettyDialogCallback;

public class Lecture extends AppCompatActivity {
    private ListView listView;
    private ArrayList arrayList;
    private ArrayAdapter arrayAdapter;
    private MaterialToolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);

        materialToolbar = findViewById(R.id.mtoolbar2);
        setSupportActionBar(materialToolbar);
        setTitle("Lecture");

        listView = findViewById(R.id.listView);
        arrayList = new ArrayList();
        arrayAdapter = new ArrayAdapter<String>(Lecture.this, android.R.layout.simple_list_item_1, arrayList);


        ParseQuery<ParseObject> parseQuery = new ParseQuery<ParseObject>("Lecture");
        parseQuery.orderByDescending("createdAt");

        final ProgressDialog progressDialog = new ProgressDialog(Lecture.this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading");
        progressDialog.show();

        parseQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (objects.size()>0){
                    for (ParseObject topic : objects){
                        arrayList.add(topic.get("topic"));
                    }

                    listView.setAdapter(arrayAdapter);
                    progressDialog.dismiss();
                }
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ParseQuery<ParseObject> parseQuery1 = new ParseQuery<ParseObject>("Lecture");
                parseQuery1.getFirstInBackground(new GetCallback<ParseObject>() {
                    @Override
                    public void done(final ParseObject object, ParseException e) {
                        if (object != null && e == null){
                            final PrettyDialog prettyDialog = new PrettyDialog(Lecture.this);
                            prettyDialog.setTitle(object.get("topic").toString());
                            prettyDialog.setIcon(R.drawable.info);
                            prettyDialog.setMessage(object.get("link").toString());
                            prettyDialog.addButton("Open", R.color.pdlg_color_white, R.color.pdlg_color_blue, new PrettyDialogCallback() {
                                @Override
                                public void onClick() {
                                    Uri uri = Uri.parse(object.get("link").toString());
                                    startActivity(new Intent(Intent.ACTION_VIEW, uri));
                                }
                            }).show();
                        }
                    }
                });
             }
        });


    }
}
