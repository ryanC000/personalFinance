package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseAuth auth;
        FirebaseUser user;
        TextView username_text;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        auth = FirebaseAuth.getInstance();
        username_text = findViewById(R.id.usernameProfile);

        user = auth.getCurrentUser();
        username_text.setText(user.getEmail());

    }

    public void backToHome(View v){
        Intent i = new Intent(getApplication(), MainActivity.class);
        startActivity(i);
        finish();

    }
}