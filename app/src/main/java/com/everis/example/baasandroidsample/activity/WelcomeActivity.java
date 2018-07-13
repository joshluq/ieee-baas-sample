package com.everis.example.baasandroidsample.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.everis.example.baasandroidsample.R;
import com.everis.example.baasandroidsample.navigator.Navigator;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Navigator.navigatoToLoginFragment(this);
    }
}
