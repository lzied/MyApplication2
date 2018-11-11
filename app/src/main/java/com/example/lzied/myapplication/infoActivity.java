package com.example.lzied.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class infoActivity extends AppCompatActivity {
    BottomNavigationView button_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setTitle("A propos");
        //Navigation Buttom Added here
        button_nav=findViewById(R.id.navigation_bottom);
        button_nav.setSelectedItemId(R.id.navigation_store);
        button_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_add:
                    finish();
                        return true;
                }
                return false;
            }
        });
    }
}
