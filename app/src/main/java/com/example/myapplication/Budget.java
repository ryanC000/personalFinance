package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Budget extends AppCompatActivity {
    DatabaseReference rootDatabaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView budgetValue, budgetName;

        String budgetNameString;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        rootDatabaseRef = FirebaseDatabase.getInstance("https://personal-finance-app-fa1c1-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("users").child("user").child("budget");
        budgetValue = findViewById(R.id.budgetValue);
        budgetName = findViewById(R.id.budgetName);
        rootDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String budgetValueInt;
                BudgetReader budgetInfo = snapshot.getValue(BudgetReader.class);
                budgetValueInt = Integer.toString(budgetInfo.getBudgetTotal());
                budgetValue.setText(budgetValueInt);
                budgetName.setText(budgetInfo.getBudgetName());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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