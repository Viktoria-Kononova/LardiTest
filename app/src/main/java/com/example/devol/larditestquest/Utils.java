package com.example.devol.larditestquest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.net.ConnectivityManagerCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

public class Utils {
    public static void hideKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void underlineText(TextView textView){
        String text = textView.getText().toString();
        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new UnderlineSpan(), 0, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(spannableString);
        //return spannableString;
    }

    public static boolean isConnection(Context context){
        String connection = Context.CONNECTIVITY_SERVICE;
        ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(connection);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo == null)
            return false;
        if (!networkInfo.isConnected())
            return false;
        if (!networkInfo.isAvailable())
            return false;
        return true;
    }
}