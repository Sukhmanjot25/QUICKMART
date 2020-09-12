 package com.example.quickmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class CreateShoppingList extends AppCompatActivity {

public Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_shopping_list);

        button = (Button) findViewById(R.id.CheckoutActivity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateShoppingList.this,CheckoutActivity.class);
                startActivity(intent);
            }
        });
    }
}