package com.example.tatastrive.friends;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class Frnd_info extends AppCompatActivity {
TextView name,nickname,type,age,about;
    Cursor c;
    databse db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frnd_info);
        name=(TextView)findViewById(R.id.infoName);
        nickname=(TextView)findViewById(R.id.info_nickname);
        type=(TextView)findViewById(R.id.info_type);
        age=(TextView)findViewById(R.id.info_age);
        about=(TextView)findViewById(R.id.info_descptn);
        db=new databse(this,"Connect1",null,100);
        Intent i1=getIntent();
        String id1= i1.getStringExtra("id");
        c=db.viewbyid(id1);
        name.setText(c.getString(c.getColumnIndex("name")));
        nickname.setText(c.getString(c.getColumnIndex("nickname")));
        type.setText(c.getString(c.getColumnIndex("type")));
        age.setText(c.getString(c.getColumnIndex("age")));
        about.setText(c.getString(c.getColumnIndex("description")));

    }
}
