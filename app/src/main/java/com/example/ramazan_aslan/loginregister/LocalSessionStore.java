package com.example.ramazan_aslan.loginregister;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ramazan_aslan on 30/08/15.
 */
public class LocalSessionStore {

    public static final String SESSION_STORE = "session" ;

    public static final String FLAG_IS_LOGGED_IN = "loggedIn" ;

    SharedPreferences localSessionStore;

    public LocalSessionStore(Context context) {
        localSessionStore = context.getSharedPreferences(SESSION_STORE, Context.MODE_PRIVATE);
    }

    public boolean isLoggedIn()
    {
        return localSessionStore.getBoolean(FLAG_IS_LOGGED_IN, false);
    }

    public void login()
    {
        setBooleanValue(FLAG_IS_LOGGED_IN, true);
    }

    public void logout()
    {
        setBooleanValue(FLAG_IS_LOGGED_IN, false);
    }

    private void setBooleanValue(String key, boolean val)
    {
        SharedPreferences.Editor edit = localSessionStore.edit();
        edit.putBoolean(key, val);
        edit.commit();
    }

}
