package com.example.tatastrive.friends;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tata Strive on 9/26/2017.
 */
public class databse extends SQLiteOpenHelper
{

    public databse(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists Frnds_list (_id integer primary key autoincrement,name text,nickname text,type text,age text,description text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insert(String Name,String Nickname,String Type,String Age,String Descrptn)
    {
        SQLiteDatabase db=getWritableDatabase();
        ContentValues emptyrow=new ContentValues();
        emptyrow.put("name",Name);
        emptyrow.put("type",Type);
        emptyrow.put("nickname",Nickname);
        emptyrow.put("age",Age);
        emptyrow.put("description", Descrptn);
        db.insert("Frnds_list",null,emptyrow);
        return true;
    }
    public Cursor view()
    {
        SQLiteDatabase db=getReadableDatabase();
        String[] columns={"_id","name","nickname","type","age","description"};
       Cursor c= db.query("Frnds_list", columns, null, null, null, null, "name asc");
        c.moveToFirst();
        return  c;
    }
    public Cursor viewbyid(String id)
    {
        SQLiteDatabase db=getReadableDatabase();
        //String[] columns={"_id","name","nickname","type","age","description"};
        String [] abc={id};
        Cursor c= db.query("Frnds_list", null,"_id=?",abc, null, null, "name asc");
        c.moveToFirst();
        return  c;
    }

}
