package com.example.classparty;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignInFragment extends Fragment implements View.OnClickListener, HelperInterface {

    private EditText edtEmail, edtPass;
    private TextInputLayout inputEmail, inputPass;
    private Button btnSignIn;
    private ImageView imgBack;
    private TextView txtSignUp;
    private boolean isLoding = false;
    private boolean isFound = false;


    public static Fragment newInstance() {
        return new SignInFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        imgBack = view.findViewById(R.id.img_back);
        imgBack.setOnClickListener(this);
        btnSignIn = view.findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(this);
        txtSignUp = view.findViewById(R.id.txt_sign_up);
        txtSignUp.setOnClickListener(this);

        edtEmail = view.findViewById(R.id.edt_email);
        edtPass = view.findViewById(R.id.edt_pass);
        inputEmail = view.findViewById(R.id.input_email);
        inputPass = view.findViewById(R.id.input_pass);

        return view;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.btn_sign_in:

                break;
            case R.id.img_back:
                ((SignInActivity) getActivity()).onBack();
                break;
            case R.id.txt_sign_up:
                signUp();
                break;
        }
    }

    @Override
    public ApplicationHelper getHelper() {
        return ApplicationHelper.getInstance();
    }

    public void signUp() {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        Fragment fragment = SignInFragment.newInstance();
        fragmentTransaction.add(R.id.frame_sign_in, fragment, AppConstants.FRAGMENT_SIGN_UP);
        fragmentTransaction.addToBackStack(AppConstants.FRAGMENT_SIGN_UP);
        fragmentTransaction.commit();
    }


}
