package com.everis.example.baasandroidsample.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.everis.example.baasandroidsample.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUpFragment extends Fragment {

    @BindView(R.id.tiet_register_email)
    TextInputEditText etEmail;

    @BindView(R.id.tiet_register_password)
    TextInputEditText etPassword;

    @BindView(R.id.tiet_register_confirm_password)
    TextInputEditText etConfirmPassword;

    public SignUpFragment() {
        // Required empty public constructor
    }

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    private boolean isValidPassword() {
        if (getPassword().isEmpty() || getConfirmPassword().isEmpty()) {
            showToast("Field required");
            return false;
        } else if (!getPassword().equals(getConfirmPassword())) {
            showToast("the password should be the same");
            return false;
        }
        return true;
    }

    private boolean isValidEmail() {
        if (getEmail().isEmpty()) {
            showToast("Field required");
            return false;
        }else if(android.util.Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
            showToast("Email required");
            return false;
        }
        return true;
    }

    private String getPassword() {
        return etPassword.getText() != null ? etPassword.getText().toString() : "";
    }

    private String getEmail() {
        return etEmail.getText() != null ? etEmail.getText().toString() : "";
    }

    private String getConfirmPassword() {
        return etConfirmPassword.getText() != null ? etConfirmPassword.getText().toString() : "";
    }


    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

}
