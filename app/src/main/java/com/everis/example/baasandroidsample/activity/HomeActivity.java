package com.everis.example.baasandroidsample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.everis.example.baasandroidsample.R;

public class HomeActivity extends AppCompatActivity {

    public static Intent getCallingIntent(AppCompatActivity activity) {
        return new Intent(activity, HomeActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}
