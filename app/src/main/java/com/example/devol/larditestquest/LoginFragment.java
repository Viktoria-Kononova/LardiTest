package com.example.devol.larditestquest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginFragment extends Fragment implements View.OnClickListener {
    private TextView mForgotPassword;
    private TextView mSignUp;
    private Button mSignUpButton;
    private EditText mLogin;
    private EditText mPassword;
    private CheckBox mShowPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        mForgotPassword = (TextView)view.findViewById(R.id.textViewForgotPassword);
        String forgotPasswordText = mForgotPassword.getText().toString();
        SpannableString forgotPasswordSpannableString = new SpannableString(forgotPasswordText);
        forgotPasswordSpannableString.setSpan(new UnderlineSpan(), 0, forgotPasswordText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mForgotPassword.setText(forgotPasswordSpannableString);

        mSignUp = (TextView)view.findViewById(R.id.textViewSignUp);
        String signUpText = mSignUp.getText().toString();
        SpannableString signUpSpannableString = new SpannableString(signUpText);
        signUpSpannableString.setSpan(new UnderlineSpan(), 0, signUpText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mSignUp.setText(signUpSpannableString);

        mSignUpButton = (Button)view.findViewById(R.id.buttonSignUp);
        mLogin = (EditText)view.findViewById(R.id.editTextLogin);
        mPassword = (EditText)view.findViewById(R.id.editTextPassword);
        mShowPassword = (CheckBox)view.findViewById(R.id.checkboxShowPassword);

        mForgotPassword.setOnClickListener(this);
        mSignUp.setOnClickListener(this);
        mSignUpButton.setOnClickListener(this);
        mShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }else {
                    mPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
            }
        });

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textViewForgotPassword:
                Toast.makeText(getContext(), getResources().getString(R.string.forgot_password_message), Toast.LENGTH_SHORT).show();
                break;
            case R.id.textViewSignUp:
                Toast.makeText(getContext(),getResources().getString(R.string.sign_up_message), Toast.LENGTH_SHORT).show();
                break;
            case R.id.buttonSignUp:
                String loginText = mLogin.getText().toString();
                String passwordText = mPassword.getText().toString();
                String test = "test";
                Utils.hideKeyboard(getContext(), view);
                if (loginText.equals(test) & passwordText.equals(test)) {
                    Toast.makeText(getContext(), getResources().getString(R.string.successful_log_in), Toast.LENGTH_SHORT).show();
                }else if (!loginText.equals(test) & !loginText.equals("")){
                    mLogin.setError(getResources().getString(R.string.wrong_login));
                }else if (!passwordText.equals(test) & !passwordText.equals("")){
                    mPassword.setError(getResources().getString(R.string.wrong_password));
                }else if (loginText.equals("")){
                    mLogin.setError(getResources().getString(R.string.empty_login));
                }else if (passwordText.equals("")){
                    mPassword.setError(getResources().getString(R.string.empty_password));
                }
                break;
        }
    }
}
