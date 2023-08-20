package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class InputBudget extends AppCompatActivity {

    EditText budgetTotalInput, budgetNameInput;
    Button button_submit;
    FirebaseAuth mAuth;
    DatabaseReference rootDatabaseRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_budget);

        //FirebaseUser currentUser = mAuth.getCurrentUser();
        //String currentUserString = currentUser.getEmail().toString();
        budgetTotalInput = findViewById(R.id.budgetTotal);
        budgetNameInput = findViewById(R.id.budgetName);
        button_submit = findViewById(R.id.submit);
        rootDatabaseRef = FirebaseDatabase.getInstance("https://personal-finance-app-fa1c1-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        //.getReference - references the root node in database
        //.child - extension of the root
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalValue = Integer.parseInt(budgetTotalInput.getText().toString()) ;
                String nameString = budgetNameInput.getText().toString();

                HashMap budgetHashMap = new HashMap();
                budgetHashMap.put("budgetTotal", totalValue);
                budgetHashMap.put("budgetName", nameString);

                rootDatabaseRef.child("users").child("user").child("budget").setValue(budgetHashMap);

                Intent i = new Intent(getApplication(), Budget.class);
                startActivity(i);
                finish();

                Toast.makeText(InputBudget.this, "Budget successfully added.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void backToHome(View v){
        Intent i = new Intent(getApplication(), Budget.class);
        startActivity(i);
        finish();
    }
}