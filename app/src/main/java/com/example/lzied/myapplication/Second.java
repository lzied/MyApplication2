package com.example.lzied.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Second extends AppCompatActivity {
TextView v;
ListView listview,lst;
EditText t1,t2;
Button btn;
HashMap<String,String> map;
DB_SQlite myDB;
ArrayAdapter<String> adapter;
    ArrayList<HashMap<String,String>> values=new ArrayList<HashMap<String, String>>();
    ArrayList<String> listItems=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent i =getIntent();
        v=findViewById(R.id.txt);
        myDB=new DB_SQlite(this);


        v.setText("Bonjour : "+i.getStringExtra("login"));
        listview=findViewById(R.id.lst);
        lst=findViewById(R.id.lst);
        t1=findViewById(R.id.data1);
        t2=findViewById(R.id.data2);
        btn=findViewById(R.id.btn_data);
        String[]names={};
        //listItems=new ArrayList<>(Arrays.asList(names));
        adapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names);
        listview.setAdapter(adapter);
        final Toast t =Toast.makeText(this,"No DATA",Toast.LENGTH_SHORT);
        final SimpleAdapter adapter1=new SimpleAdapter(Second.this,values,R.layout.item,
                new String[]{"img", "user", "password"},new int[]{R.id.img,R.id.tt1,R.id.tt2});
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if(!t1.getText().toString().isEmpty())
//                {
//                listItems.add(t1.getText().toString());
//                adapter.notifyDataSetChanged();
//                t1.setText("");}
//                else {
//                    t.show();
//                }
                if(!t1.getText().toString().isEmpty() && !t2.getText().toString().isEmpty())
                {
                    map=new HashMap<String, String>();
                    map.put("img",String.valueOf(R.mipmap.ic_launcher));
                    map.put("user",t1.getText().toString());
                    map.put("password",t2.getText().toString());
                    values.add(map);
                    lst.setAdapter(adapter1);
                    adapter1.notifyDataSetChanged();
                    t1.setText("");
                    t2.setText("");

                }

            }
        });
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

addData();
    }
    public void addData()
    {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res=myDB.insertData(t1.getText().toString(),t2.getText().toString());
                if(res=true)
                    Toast.makeText(Second.this,"data inserted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Second.this,"data not inserted",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
