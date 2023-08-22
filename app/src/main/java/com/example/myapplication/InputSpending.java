package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

public class InputSpending extends AppCompatActivity {

    EditText spendingAmount;
    Button button_submit;

    FirebaseAuth mAuth;

    DatabaseReference rootDatabaseRef;

    String[] item = {"Food & Drinks", "Accommodation", "Entertainment", "Transportation", "Services", "Education", "Shopping", "Other"};

    AutoCompleteTextView autoCompleteTextView;

    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_spending);

        autoCompleteTextView = findViewById(R.id.auto_complete_text);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, item);

        autoCompleteTextView.setAdapter(adapterItems);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(InputSpending.this, "Item "+ item, Toast.LENGTH_SHORT).show();
            }
        });

        spendingAmount = findViewById(R.id.Amount);
        button_submit = findViewById(R.id.submit);
        rootDatabaseRef = FirebaseDatabase.getInstance("https://personal-finance-app-fa1c1-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        //.getReference - references the root node in database
        //.child - extension of the root

        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}