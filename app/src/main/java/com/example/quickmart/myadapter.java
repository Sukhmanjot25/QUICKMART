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

/**
 * passing model class and myviewholder class
 */

public class myadapter extends FirebaseRecyclerAdapter<model,myadapter.myviewholder> {
    public myadapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    /**
     * @author ripenpreet
     * onCreateViewHolder method used to pass singlerow.xml format of data and convert to view
     * onBind ,bind the data passed by onCreate (view) and model class
     * @param holder
     * @param position
     * @param model
     */

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
//take reference of singlerow.xml
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
