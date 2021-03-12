package com.example.networktest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String returnValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendenKlick(View view){
        textView = findViewById(R.id.editTextNumber);

        Runnable runnable = new Runnable(textView.getText().toString());
        new Thread(runnable).start();
        returnValue = runnable.Eingabe;

        AlertDialog.Builder popFenster = new AlertDialog.Builder(this);
        popFenster.setTitle("Antwort vom Server");
        popFenster.setMessage(returnValue);
        popFenster.setCancelable(true);

        AlertDialog showFenster = popFenster.show();
        showFenster.show();
    }
    public void BerechnungKlick(View view){

    }
}