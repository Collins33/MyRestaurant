package com.epicodus.myrestaurants.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.epicodus.myrestaurants.R;

import butterknife.Bind;

public class LoginActivity extends AppCompatActivity {
@Bind(R.id.registerTextView)
    TextView mRegisteraccount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void registerAccount (View view){
        Intent intent=new Intent(this,CreateAccountActivity.class);
        startActivity(intent);
    }
}
