package com.example.quickmart;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    /*


   @author sukhmanjot
   variable for button
   @author ripenpreet
   creating recycler view(recview) and adapter

     */
    private Button button;

    RecyclerView recview;
    myadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button= (Button) findViewById(R.id.CreateShoppingList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreateShoppingList();
            }
        });

        recview=(RecyclerView)findViewById(R.id.recview);
/**
 *
 * Grid Layout formation with 2 coulmns
 */
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recview.setLayoutManager(gridLayoutManager);

        /**
         * Used to  fetch data from firebase  ..
         * model is type of data
         * model class is used to fetch
         * Men is a child of firebase
         * data fetched
         */
        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Men"), model.class)
                        .build();
        //use myadapter constructor

        adapter=new myadapter(options);
        recview.setAdapter(adapter);

    }
    //when myadapter starts , it starts listening the data from database

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
//when myadapter stops,then it stops listening data from database
    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
    /**
     * @author sukhmanjot
     * method to call the button to go to checkout page
     */
public void openCreateShoppingList(){
    Intent intent=new Intent(this,CheckoutActivity.class);
    startActivity(intent);
}

    /**
     *
     * @author ripenpreet
     * method to call logout button to signout and go to login activity
     */

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

}