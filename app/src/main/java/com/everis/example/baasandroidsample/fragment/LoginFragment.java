package com.everis.example.baasandroidsample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.everis.example.baasandroidsample.R;
import com.everis.example.baasandroidsample.activity.WelcomeActivity;
import com.everis.example.baasandroidsample.navigator.Navigator;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends Fragment implements OnSuccessListener<AuthResult>, OnFailureListener {

    @BindView(R.id.tiet_login_email)
    TextInputEditText etEmail;

    @BindView(R.id.tiet_login_password)
    TextInputEditText etPassword;

    @BindView(R.id.login_button)
    Button btnLogin;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    private WelcomeActivity activity;

    private FirebaseAuth firebaseAuth;


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
        firebaseAuth = FirebaseAuth.getInstance();
    }

    @OnClick(R.id.login_button)
    void onLogin() {
        hideKeyboard();
        if (isValidEmail() && isValidPassword()) {
            showLoading(btnLogin);
            firebaseAuth.signInWithEmailAndPassword(getEmail(), getPassword())
                    .addOnSuccessListener(this)
                    .addOnFailureListener(this);
        }
    }

    private boolean isValidEmail() {
        if (getEmail().isEmpty()) {
            showToast("Field required");
            return false;
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()) {
            showToast("invalid email");
            return false;
        }
        return true;
    }

    private boolean isValidPassword() {
        if (getPassword().isEmpty()) {
            showToast("Field required");
            return false;
        }
        else if(getPassword().length()<6){
            showToast("Invalid password");
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

    private void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    private void showLoading(View view) {
        progressBar.setVisibility(View.VISIBLE);
        view.setVisibility(View.INVISIBLE);
    }

    private void hideLoading(View view) {
        progressBar.setVisibility(View.GONE);
        view.setVisibility(View.VISIBLE);
    }

    public void hideKeyboard() {
        View view = activity.findViewById(android.R.id.content);
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @OnClick(R.id.register_button)
    public void onRegisterButton() {
        Navigator.navigatorToSignUpFragment(activity);
    }

    @Override
    public void onSuccess(AuthResult authResult) {
        Navigator.navigateToHomeActivity(activity);
        activity.finish();
    }

    @Override
    public void onFailure(@NonNull Exception e) {
        hideLoading(btnLogin);
        showToast("Ups! has been an error");
    }
}
