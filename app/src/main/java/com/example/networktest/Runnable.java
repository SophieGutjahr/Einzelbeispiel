package com.example.networktest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Runnable implements java.lang.Runnable {

    String Eingabe = null;

    Runnable (String Eingabe){
        this.Eingabe = Eingabe;
    }

    @Override
    public void run() {

        Socket clientSocket = null;

        try {
            clientSocket = new Socket("se2-isys.aau.at",53212);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DataOutputStream outToServer = null;
        try {
            outToServer = new DataOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader inFromServer = null;
        try {
            inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //schicken an Server
        try {
            outToServer.writeBytes(Eingabe + '\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Antwort vom  Server
        try {
            Eingabe = inFromServer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
