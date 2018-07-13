package com.everis.example.baasandroidsample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.everis.example.baasandroidsample.R;
import com.everis.example.baasandroidsample.activity.WelcomeActivity;
import com.everis.example.baasandroidsample.navigator.Navigator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment {

    @BindView(R.id.tiet_login_email)
    TextInputEditText etEmail;

    @BindView(R.id.tiet_login_password)
    TextInputEditText etPassword;

    private WelcomeActivity activity;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        activity = (WelcomeActivity)getActivity();
    }

    @OnClick(R.id.login_button)
    void onLogin() {

    }

    @OnClick(R.id.register_button)
    public void onRegisterButton() {
        Navigator.navigatorToSignUpFragment(activity);
    }


}
