package com.company;

import java.io.*;
import java.net.Socket;

public class Multi implements Runnable {

    Socket nysocket;
    PrintWriter ut;
    //DataInputStream inn;
    BufferedReader inn;
    DataInputStream stoppServer;


    public Multi(Socket nysocket){

        this.nysocket = nysocket;

    }

    @Override
    public void run() {

        try {
            ut = new PrintWriter(nysocket.getOutputStream(), true);

            inn = new BufferedReader(new InputStreamReader(nysocket.getInputStream()));
            //inn = new DataInputStream(nysocket.getInputStream());


            String hentInnput = inn.readLine();
            while (hentInnput != null ) {
                ut.println((AlleEmails.Alleemail(hentInnput)));
                hentInnput = inn.readLine();

        }

        //nysocket.shutdownOutput();
        //serversocket.shutdownInput();
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}
