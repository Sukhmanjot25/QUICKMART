package com.example.quickmart;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class recyclerview extends AppCompatActivity {
    private RecyclerView recyclerView;
    private int[] images={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4};
    private RecyclerAdapter adapter;

    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        layoutManager=new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new RecyclerAdapter(images);
        recyclerView.setAdapter(adapter);

    }
}

