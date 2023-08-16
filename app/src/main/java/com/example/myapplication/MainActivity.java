package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.ktx.Firebase;

public class MainActivity extends AppCompatActivity {
    TextView userDetails;
    Button button_logout;
    FirebaseAuth auth;
    FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        button_logout = findViewById(R.id.logout);
        userDetails = findViewById(R.id.user_details);

        user = auth.getCurrentUser();
        //if hte user is null then, open login page
        if (user == null) {
            Intent i = new Intent(getApplication(), Login.class);
            startActivity(i);
            finish();
        }
        else {
            userDetails.setText(user.getEmail());
        }

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(getApplication(), Login.class);
                startActivity(i);
                finish();
            }
        });
    }

}