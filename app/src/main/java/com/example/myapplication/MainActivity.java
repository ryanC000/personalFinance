package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchRecords(View v) {
        Intent i = new Intent(this, RecordsActivity.class);
        startActivity(i);
    }

    public void textHandler(View v) {
        View source = findViewById(R.id.editTextText);
        String message = source.toString();
        Log.d("success", message);

    }

    public void alert(View v){
        Toast.makeText(this, "Successfully pressed button!", Toast.LENGTH_LONG).show();
    }
}