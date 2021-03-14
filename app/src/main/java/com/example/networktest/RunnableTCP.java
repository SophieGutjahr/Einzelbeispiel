package com.example.networktest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

class RunnableTCP implements Runnable {

    String Eingabe;
    String NutzerVariable;

    RunnableTCP (String Eingabe){
        this.Eingabe = Eingabe;
    }

    @Override
    public void run() {
        try {
            //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            Socket clientSocket = new Socket("se2-isys.aau.at",53212);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            //Eingabe = inFromUser.readLine();

            outToServer.writeBytes(String.valueOf(Integer.parseInt(Eingabe+'\n')));

            NutzerVariable = inFromServer.readLine();

            //System.out.println("From Server:"+ NutzerVariable);

            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
