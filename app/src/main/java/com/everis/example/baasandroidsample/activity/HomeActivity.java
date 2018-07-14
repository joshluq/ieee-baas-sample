package com.everis.example.baasandroidsample.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.everis.example.baasandroidsample.R;
import com.everis.example.baasandroidsample.model.DogEntity;
import com.everis.example.baasandroidsample.viewholders.DogsViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    RecyclerView rvDogs;
    FirebaseRecyclerAdapter<DogEntity, DogsViewHolder> adapter;

    public static Intent getCallingIntent(AppCompatActivity activity) {
        return new Intent(activity, HomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupDogsList();
    }

    private void setupDogsList() {
        rvDogs = findViewById(R.id.rv_dogs);
        rvDogs.setLayoutManager(new LinearLayoutManager(this));

        DatabaseReference dogsReference = FirebaseDatabase.getInstance().getReference().child("puppies");

        FirebaseRecyclerOptions<DogEntity> options = new FirebaseRecyclerOptions.Builder<DogEntity>().setQuery(dogsReference, DogEntity.class).build();

        adapter = new FirebaseRecyclerAdapter<DogEntity, DogsViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull DogsViewHolder holder, int position, @NonNull DogEntity model) {
                holder.dogAge.setText(String.valueOf(model.getAge()));
                holder.dogName.setText(model.getName());
                Picasso.get().load(model.getPicture()).into(holder.dogImage);
            }

            @NonNull
            @Override
            public DogsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.dog_item, viewGroup, false);
                return new DogsViewHolder(view);
            }
        };
        rvDogs.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
