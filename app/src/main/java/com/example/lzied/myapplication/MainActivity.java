package com.example.lzied.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button conx,reset;
    RadioGroup g;
    RadioButton yes;
    EditText lo,pa;
    Toast t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conx=findViewById(R.id.conx);
        reset=findViewById(R.id.btncancel);
        lo=findViewById(R.id.log);
        pa=findViewById(R.id.pas);
        g=findViewById(R.id.rg);

        conx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (lo.getText().toString().equals("admin") && pa.getText().toString().equals("admin")) {

                    t.makeText(MainActivity.this, "Connexion cours", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, Second.class);
                    i.putExtra("login", lo.getText().toString());
                    i.putExtra("pass", pa.getText().toString());
                    startActivity(i);
                }}




            }
        );
    reset.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            view.showContextMenu();
            return false;
        }
    });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,0,"site web");
        menu.add(0,2,0,"a propos");

        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId())
        {case 1:{
            Intent s=new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com"));
            break;
        }
            case 2:{
                Intent s3=new Intent(MainActivity.this,infoActivity.class);
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"A propos");
        menu.add(0,2,0,"Quitter");

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case 1:
            {
                Intent info=new Intent(MainActivity.this,infoActivity.class);
                startActivity(info);
                break;
            }
            case 2:
            {
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
