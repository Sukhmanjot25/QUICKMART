package com.example.quickmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CheckoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }



    /**
     * @author sukhmanjot
     * dropdown menu items
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.drodown_menu,menu);
        return true;
    }


    /**
     * @author sukhmanjot
     * to navigate between activityes when clicking options in options menu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         //handle actionbar clicks here.

        int id =item.getItemId();
         if(id==R.id.item1){

             Intent intent=new Intent(this,ContactUs.class);
             startActivity(intent);
             return true;
         }
         else  if(id==R.id.item2){
             Intent intent=new Intent(this,Feedback.class);
             startActivity(intent);
             return true;
         }



        return super.onOptionsItemSelected(item);
    }
}