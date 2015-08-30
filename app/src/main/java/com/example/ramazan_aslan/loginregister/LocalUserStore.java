package com.example.ramazan_aslan.loginregister;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ramazan_aslan on 30/08/15.
 */
public class LocalUserStore {

    // session
    private static final String SP_NAME = "userDetails";

    // fields
    private static final String FIELD_AGE = "age";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_USERNAME = "username";
    private static final String FIELD_PASSWORD = "password";

    SharedPreferences userLocalDatabase;

    public LocalUserStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public void save(User user) {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();

        spEditor.putInt(FIELD_AGE, user.getAge());
        spEditor.putString(FIELD_NAME, user.getName());
        spEditor.putString(FIELD_USERNAME, user.getUsername());
        spEditor.putString(FIELD_PASSWORD, user.getPassword());

        spEditor.commit();
    }

    public User getLoggedInUser()
    {
        String nameSurname = userLocalDatabase.getString(FIELD_NAME, "");
        String username = userLocalDatabase.getString(FIELD_USERNAME, "");
        String password = userLocalDatabase.getString(FIELD_PASSWORD, "");
        Integer age = userLocalDatabase.getInt(FIELD_AGE, -1);

        return new User(nameSurname,age,username, password);
    }

    public void clearUserdata()
    {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
}
