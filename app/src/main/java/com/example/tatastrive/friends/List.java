package com.example.tatastrive.friends;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView l1;
    Cursor c;
    Customadapter customadapter;
    databse frnds1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        l1=(ListView)findViewById(R.id.listView);
        l1.setOnItemClickListener(this);
        frnds1=new databse(this,"Connect1",null,100);
        c=frnds1.view();
        customadapter=new Customadapter(this,c);
        l1.setAdapter(customadapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
    {
        int id1=c.getInt(0);

        Intent i=new Intent(this,Frnd_info.class);
        i.putExtra("id",id1+"");
        startActivity(i);

    }
}


class Customadapter extends CursorAdapter
{

    public Customadapter(Context context, Cursor c) {
        super(context, c,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent)
    {
        LayoutInflater inflater=LayoutInflater.from(context);
       View onerow= inflater.inflate(R.layout.row,parent,false);
        return onerow;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor)
    {
        TextView name=(TextView)view.findViewById(R.id.rtvName);
        String name1=cursor.getString(cursor.getColumnIndex("name"));
        name.setText(name1);

    }
}
