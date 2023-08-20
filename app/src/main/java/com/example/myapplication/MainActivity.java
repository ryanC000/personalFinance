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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    //added comment
    TextView userDetails;
    Button button_logout;
    Button button_profile;
    FirebaseAuth auth;
    FirebaseUser user;

    DatabaseReference rootDatabaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth = FirebaseAuth.getInstance();
        button_logout = findViewById(R.id.logout);
        userDetails = findViewById(R.id.user_details);

        user = auth.getCurrentUser();


        String currentUserString = user.getEmail().toString();
        //if hte user is null then, open login page
        if (user == null) {
            Intent i = new Intent(getApplication(), Login.class);
            startActivity(i);
            finish();
        }
        else {
            userDetails.setText(user.getEmail());

            /*String userEmail = user.getEmail().toString();
            rootDatabaseRef = FirebaseDatabase.getInstance("https://personal-finance-app-fa1c1-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
            rootDatabaseRef.child("users").setValue(userEmail);*/
        }
// yh add comment
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
    public void launchProfile(View v) {
        Intent i = new Intent(getApplicationContext(), Profile.class);
        startActivity(i);
        finish();
    }

    public void launchBudget(View v) {
        Intent i = new Intent(getApplicationContext(), Budget.class);
        startActivity(i);
        finish();
    }
}