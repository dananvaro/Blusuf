package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Multi implements Runnable {

    Socket nysocket;
    PrintWriter ut;
    //DataInputStream inn;
    BufferedReader inn;


    public Multi(Socket nysocket){
        this.nysocket = nysocket;
    }

    @Override
    public void run() {

        try {
            //printer de vi skriver som så sendes tilbake til klient
            ut = new PrintWriter(nysocket.getOutputStream(), true);

            //tar inn innput
            inn = new BufferedReader(new InputStreamReader(nysocket.getInputStream()));
            //inn = new DataInputStream(nysocket.getInputStream());


            String hentInnput = inn.readLine();
            String melding;
            while (hentInnput!=null) {
                if (hentInnput.equalsIgnoreCase("stopp server")){
                    ut.println("server har stoppa");
                    System.exit(0);
                }
                melding = (AlleEmails.Alleemail(hentInnput));
                ut.println(melding);
                hentInnput = inn.readLine();

        }

        //nysocket.shutdownOutput();
        //serversocket.shutdownInput();
    } catch (IOException e) {

            e.getMessage();
    }

    }
}
