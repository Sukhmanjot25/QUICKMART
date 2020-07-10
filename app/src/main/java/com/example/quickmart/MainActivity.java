package com.example.quickmart;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mNavDrawer;
    private Button button;
    private  Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

            mNavDrawer=findViewById(R.id.drawer_layout);
            NavigationView navigationView=findViewById(R.id.navigation_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mNavDrawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
                    mNavDrawer.addDrawerListener(toggle);
                            toggle.syncState();
                            navigationView.setNavigationItemSelectedListener(this);
        button =(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openItemsPage();
            }
        });

    }
    public void  openItemsPage(){
         Intent intent = new Intent(this,itemspage.class );
         startActivity(intent);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);


        return true;
    }

    @Override
    public void onBackPressed() {
        if(mNavDrawer.isDrawerOpen(GravityCompat.START)){
            mNavDrawer.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.icon:
                Toast.makeText(this, "Icon Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.settings:
                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.Contact_Us:
                Toast.makeText(this, "Contact Us Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public void btn_signup(View view) {
        startActivity(new Intent(getApplicationContext(), Signup.class));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.nav_help:
                Toast.makeText(this, "This is the help option", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_inbox:
                Toast.makeText(this, "This is the inbox option", Toast.LENGTH_SHORT).show();
                break;

            case R.id.nav_message:
                Toast.makeText(this, "This is the message option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_send:
                Toast.makeText(this, "This is the send option", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_share:
                Toast.makeText(this, "This is the share option", Toast.LENGTH_SHORT).show();
                break;

        }
        mNavDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
