package com.canaday.loth.albumoftheday1;


import android.content.Context;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

public class AppHelper {

    private static AppHelper helper;

    private static GoogleSignInAccount acct;

    //Data fields
    private static final int RC_SIGN_IN = 9001;
    private static final String CLIENT_ID = "640935202291-jvia02p3tgnqrj6lgt8j792c3d72eqhq.apps.googleusercontent.com";

    public static void init(){

        if (helper != null){
            return;
        } else {
            helper = new AppHelper();
        }
    }

    //GETTERS

    public static void setAccount(GoogleSignInAccount a){
        acct = a;
    }

    public static GoogleSignInAccount getAcct() {
        return acct;
    }

    //SETTERS

    public static int getRcSignIn() {
        return RC_SIGN_IN;
    }

    public static String getClientId() {
        return CLIENT_ID;
    }
}
