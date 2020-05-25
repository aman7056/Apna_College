package com.amati.apnacollege;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;

public class Devloper extends AppCompatActivity  {
    private MaterialToolbar materialToolbar;
    private TextView txt1, txt2;
    private ImageView insta, company, pay, whatsapp, mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devloper);

        materialToolbar = findViewById(R.id.mtoolbar2);
        setSupportActionBar(materialToolbar);
        setTitle("Developer");

        txt1 = findViewById(R.id.txtdvname);
        txt2 = findViewById(R.id.txtcompany);

        insta = findViewById(R.id.insta);
        company = findViewById(R.id.company);
        pay = findViewById(R.id.pay);
        whatsapp = findViewById(R.id.whatsapp);
        mail = findViewById(R.id.mail);


        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/a_tiwariji/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("https://www.instagram.com/amati_offical/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));

            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/a_tiwariji/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        company.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com/amati_offical/");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://paytm.me/K2wd-T9");
                startActivity(new Intent(Intent.ACTION_VIEW, uri));
            }
        });

        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String body = "https://www.mediafire.com/#f7e605sl33ch4";
                String sub = "Download Apna Amati Apps";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,sub);
                myIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(Intent.createChooser(myIntent, "Share Using"));
            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context;
                AlertDialog alertDialog = new AlertDialog.Builder(Devloper.this).create();
                alertDialog.setMessage("apnaamati@gmail.com" + "\nat7056222557@gmail.com");
                alertDialog.setTitle("Gmail ID");
                alertDialog.setIcon(R.drawable.info);
                alertDialog.setCancelable(true);
                alertDialog.show();
            }
        });



    }
}
