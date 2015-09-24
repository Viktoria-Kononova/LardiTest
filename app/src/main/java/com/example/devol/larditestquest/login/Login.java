package com.example.devol.larditestquest.login;

import com.example.devol.larditestquest.login.ILogin;

public class Login implements ILogin {
    @Override
    public boolean logIn(String loginText, String passwordText) {
        String test = "test";
        if (loginText.equals(test) & passwordText.equals(test)){
            return true;
        }
        if (!loginText.equals(test) & !passwordText.equals(test)){
            return false;
        }
        return false;
    }

    /*if (loginText.equals(test) & passwordText.equals(test)) {
        Toast.makeText(getContext(), getResources().getString(R.string.successful_log_in), Toast.LENGTH_SHORT).show();
    }else if (!loginText.equals(test) & !loginText.equals("")){
        mLogin.setError(getResources().getString(R.string.wrong_login));
    }else if (!passwordText.equals(test) & !passwordText.equals("")){
        mPassword.setError(getResources().getString(R.string.wrong_password));
    }else*/

}
