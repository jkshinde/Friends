package com.example.tatastrive.friends;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Add_new extends AppCompatActivity {
EditText name,nickname,age,descrptn;
    Spinner type;
   String Name,Nickname,Age,Descrptn,Type1;
    databse frnds;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);
        name=(EditText)findViewById(R.id.etname);
        nickname=(EditText)findViewById(R.id.etnickname);
        age=(EditText)findViewById(R.id.editText);
        descrptn=(EditText)findViewById(R.id.editText2);
        type=(Spinner)findViewById(R.id.spinner);
        frnds=new databse(this,"Connect1",null,100);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(1,1,1,"Add Friend");
        menu.add(1,2,2,"View Friends");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Name=name.getText().toString();
        Nickname=nickname.getText().toString();
        Type1=type.getSelectedItem().toString();
        Age=age.getText().toString();
        Descrptn=descrptn.getText().toString();
        if(item.getItemId()==1)
        {
            if(Name.equals("") || Nickname.equals("") || Type1.equals("") || Age.equals("") || Descrptn.equals(""))
            {
                Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
            }
            else
            {
                boolean a = false;
                a = frnds.insert(Name, Nickname, Type1, Age, Descrptn);
                if (a) {
                    Toast.makeText(this,Name+"Added", Toast.LENGTH_SHORT).show();
                }
                name.setText("");
                nickname.setText("");
                age.setText("");
                descrptn.setText("");
            }
        }
        else
        {
            Intent i=new Intent(this,List.class);
            startActivity(i);


        }

        return super.onOptionsItemSelected(item);
    }
}
