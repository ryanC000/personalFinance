package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Budget extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);

        /* Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance("https://personal-finance-app-fa1c1-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Testing firebase storage -Ryan");*/
    }

    public void backToHome(View v){
        Intent i = new Intent(getApplication(), MainActivity.class);
        startActivity(i);
        finish();

    }

    public void launchInputBudget(View v) {
        Intent i = new Intent(getApplication(), InputBudget.class);
        startActivity(i);
        finish();
    }
}