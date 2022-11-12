package com.example.navberheader;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    TextView sTv,hTv,cTv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sTv= findViewById(R.id.settingstv);
        hTv= findViewById(R.id.hometv);
        cTv= findViewById(R.id.contacttv);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        nav = findViewById(R.id.navmenu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.menu_home:
                        Toast.makeText(getApplicationContext(),"Home is Open",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        hTv.setVisibility(View.VISIBLE);
                        sTv.setVisibility(View.GONE);
                        cTv.setVisibility(View.GONE);

                        break;
                    case R.id.menu_set:
                        Toast.makeText(getApplicationContext(),"Settings is Open",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        hTv.setVisibility(View.GONE);
                        sTv.setVisibility(View.VISIBLE);
                        cTv.setVisibility(View.GONE);
                        break;
                    case R.id.menu_contact:
                        Toast.makeText(getApplicationContext(),"Contacts is Open",Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        hTv.setVisibility(View.GONE);
                        sTv.setVisibility(View.GONE);
                        cTv.setVisibility(View.VISIBLE);
                        break;

                }


                return true;
            }
        });
    }

}