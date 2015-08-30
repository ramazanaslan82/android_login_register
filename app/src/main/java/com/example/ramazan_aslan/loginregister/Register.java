package com.example.ramazan_aslan.loginregister;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends Activity implements View.OnClickListener {



    EditText etNameSurname, etUsername, etPassword, etPasswordRetry, etAge;
    Button bRegister;
    TextView tvLoginLink;

    LocalUserStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNameSurname = (EditText) findViewById(R.id.etNameSurname);
        etUsername = (EditText) findViewById(R.id.etUsername);
        etAge = (EditText) findViewById(R.id.etAge);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPasswordRetry = (EditText) findViewById(R.id.etPasswordRetry);
        bRegister = (Button) findViewById(R.id.bRegister);
        tvLoginLink = (TextView) findViewById(R.id.tvLoginLink);

        bRegister.setOnClickListener(this);
        tvLoginLink.setOnClickListener(this);

        userLocalStore = new LocalUserStore(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.tvLoginLink:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.bRegister:
                register();
                startActivity(new Intent(this, Login.class));
                break;
        }
    }

    private void register()
    {
        User user = new User(etNameSurname.getText().toString(), Integer.parseInt(etAge.getText().toString()) , etUsername.getText().toString(), etPassword.getText().toString() );
        userLocalStore.save(user);
    }


}
