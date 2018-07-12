package com.everis.example.baasandroidsample.navigator;

import android.support.v7.app.AppCompatActivity;

import com.everis.example.baasandroidsample.R;
import com.everis.example.baasandroidsample.fragment.LoginFragment;

public class Navigator {

    public static void navigatoToLoginFragment(AppCompatActivity activity){
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.welcome_container, LoginFragment.newInstance()).commit();
    }

}
