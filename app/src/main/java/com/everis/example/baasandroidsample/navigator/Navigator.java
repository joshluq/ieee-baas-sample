package com.everis.example.baasandroidsample.navigator;

import android.support.v7.app.AppCompatActivity;

import com.everis.example.baasandroidsample.R;
import com.everis.example.baasandroidsample.activity.HomeActivity;
import com.everis.example.baasandroidsample.fragment.LoginFragment;
import com.everis.example.baasandroidsample.fragment.SignUpFragment;

public class Navigator {

    private Navigator() {
        //empty constructor
    }

    public static void navigatorToLoginFragment(AppCompatActivity activity){
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.welcome_container, LoginFragment.newInstance())
                .commit();
    }

    public static void navigatorToSignUpFragment(AppCompatActivity activity){
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.welcome_container, SignUpFragment.newInstance())
                .addToBackStack(SignUpFragment.class.getSimpleName())
                .commit();
    }

    public static void navigateToHomeActivity(AppCompatActivity activity){
        activity.startActivity(HomeActivity.getCallingIntent(activity));
    }

}
