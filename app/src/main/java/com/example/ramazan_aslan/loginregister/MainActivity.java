package com.example.ramazan_aslan.loginregister;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText etNameSurname, etUsername, etAge;
    Button bLogout;

    LocalSessionStore localSessionStore;
    LocalUserStore localUserStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNameSurname = (EditText) findViewById(R.id.etNameSurname);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etAge = (EditText) findViewById(R.id.etAge);
        bLogout = (Button) findViewById(R.id.bLogout);

        bLogout.setOnClickListener(this);

        // check login
        localSessionStore = new LocalSessionStore(this);
        localUserStore = new LocalUserStore(this);
        if (!localSessionStore.isLoggedIn()) {
            startActivity(new Intent(this, Login.class));
        }
        else
        {
            User loggedInUser = localUserStore.getLoggedInUser();
            etNameSurname.setText(loggedInUser.getName());
            etAge.setText(loggedInUser.getAge());
            etUsername.setText(loggedInUser.getUsername());
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bLogout:
                localSessionStore.logout();
                startActivity(new Intent(this, Login.class));
                break;
        }
    }

}
