package com.decode.alzaid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Aditya on 2/11/2017.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder> {
    private List<String> ItemList;
    Context mcontext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Button button;
        //Bitmap bmp;

        public MyViewHolder(View view) {
            super(view);
            button = (Button)view.findViewById(R.id.home_item_button);
        }
    }


    public HomeAdapter(List<String> ItemList, Context context) {
        this.ItemList = ItemList;
        mcontext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.home_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //Movie movie = ItemList.get(position);
        holder.button.setText(ItemList.get(position));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ItemList.get(position) == "New Question") {
                    Intent intent = new Intent();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

}

