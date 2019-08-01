package com.huske.sharedexample;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class Nav extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CSITfrag()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.csit:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CSITfrag()).commit();
                break;
            case R.id.bim:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BimFrag()).commit();
                break;
            case R.id.bba:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new BbaFrag()).commit();
                break;
            case R.id.share:{
                startActivity(new Intent(this, View_pdf_files.class));
            }

        }
        return true;

    }
}
