package com.everis.example.baasandroidsample.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.everis.example.baasandroidsample.R;

public class DogsViewHolder extends RecyclerView.ViewHolder{

    public ImageView dogImage;
    public TextView dogName;
    public TextView dogAge;

    public DogsViewHolder(@NonNull View itemView) {
        super(itemView);
        dogImage = itemView.findViewById(R.id.iv_dog);
        dogName = itemView.findViewById(R.id.tv_dog_name);
        dogAge = itemView.findViewById(R.id.tv_dog_age);
    }
}
