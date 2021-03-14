package com.example.networktest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    String returnValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendenKlick(View view) throws InterruptedException {
        textView = findViewById(R.id.editTextNumber);

        RunnableTCP runnable = new RunnableTCP(textView.getText().toString());

        new Thread(runnable).start();
        Thread.sleep(500);

        AlertDialog.Builder popFenster = new AlertDialog.Builder(this);
        returnValue = runnable.NutzerVariable;


        popFenster.setTitle("Antwort vom Server");
        popFenster.setMessage(returnValue);
        popFenster.setCancelable(true);

        AlertDialog showFenster = popFenster.show();
        showFenster.show();
    }


    public void Berechnung(View view){

    textView = findViewById(R.id.editTextNumber);

    String BerechnungsWert = textView.getText().toString();
    char [] BerechnungsArray = BerechnungsWert.toCharArray();



        char [] ErgebnisArray = new char [7];


        if (BerechnungsArray[0]=='2'|| BerechnungsArray[0]=='3' || BerechnungsArray[0]=='5'|| BerechnungsArray[0]=='7' ){
            ErgebnisArray [0] = BerechnungsArray [0];
        }
        if (BerechnungsArray [1] =='2'||BerechnungsArray [1] == '3'||BerechnungsArray [1] == '5'||BerechnungsArray [1] == '7'){
            ErgebnisArray[1]= BerechnungsArray [1];
        }
        if (BerechnungsArray[2]=='2'|| BerechnungsArray[2]=='3' || BerechnungsArray[2]=='5'|| BerechnungsArray[2]=='7' ){
            ErgebnisArray[2]=BerechnungsArray[2];
        }
        if (BerechnungsArray[3]=='2'|| BerechnungsArray[3]=='3' || BerechnungsArray[3]=='5'|| BerechnungsArray[3]=='7' ){
            ErgebnisArray[3]=BerechnungsArray[3];
        }
        if (BerechnungsArray[4]=='2'|| BerechnungsArray[4]=='3' || BerechnungsArray[4]=='5'|| BerechnungsArray[4]=='7' ){
            ErgebnisArray[4]=BerechnungsArray[4];
        }
        if (BerechnungsArray[5]=='2'|| BerechnungsArray[5]=='3' || BerechnungsArray[5]=='5'|| BerechnungsArray[5]=='7' ){
            ErgebnisArray[5]=BerechnungsArray[5];
        }
        if (BerechnungsArray[6]=='2'|| BerechnungsArray[6]=='3' || BerechnungsArray[6]=='5'|| BerechnungsArray[6]=='7' ){
            ErgebnisArray[6]=BerechnungsArray[6];
        }
        if (BerechnungsArray[7]=='2'|| BerechnungsArray[7]=='3' || BerechnungsArray[7]=='5'|| BerechnungsArray[7]=='7' ){
            ErgebnisArray[7]=BerechnungsArray[7];
        }
        for(int i = 0; i<ErgebnisArray.length; i++){
            if (ErgebnisArray[i]!= '0'){

            }
        }

        String rueckgabewert = new String (ErgebnisArray);


     AlertDialog.Builder popFenster = new AlertDialog.Builder(this);
    popFenster.setTitle("Antwort vom Server" );
    popFenster.setMessage(rueckgabewert);
       popFenster.setCancelable(true);
       AlertDialog showFenster = popFenster.show();
       showFenster.show();
    }
}