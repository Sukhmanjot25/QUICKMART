package com.example.quickmart;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull model model) {
        holder.name.setText(model.getProduct_name());
        holder.desc.setText(model.getProduct_description());
        holder.price.setText(model.getProduct_price());
        Glide.with(holder.img.getContext()).load(model.getProduct_image()).into(holder.img);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow,parent,false);
        return new myviewholder(view);
    }

    public void stopListening() {
    }

    class myviewholder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name,desc,price;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img =(ImageView)itemView.findViewById(R.id.product_image);
            name=(TextView)itemView.findViewById(R.id.product_name);
            desc=(TextView)itemView.findViewById(R.id.product_desc);
            price=(TextView)itemView.findViewById(R.id.product_price);




        }
    }
}
