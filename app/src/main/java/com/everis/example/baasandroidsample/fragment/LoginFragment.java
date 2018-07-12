package com.everis.example.baasandroidsample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.everis.example.baasandroidsample.R;

import butterknife.BindView;

public class LoginFragment extends Fragment {

    @BindView(R.id.tiet_login_email)
    TextInputEditText etEmail;
    @BindView(R.id.tiet_login_password)
    TextInputEditText etPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,container,false);
    }
}
