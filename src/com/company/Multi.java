package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class Multi extends Thread {

    Socket nysocket;
    PrintWriter ut;
    DataInputStream inn;
    DataInputStream stoppServer;


    public Multi(Socket nysocket){

        this.nysocket = nysocket;

    }

    @Override
    public void run() {

        try {
            ut = new PrintWriter(nysocket.getOutputStream(), true);

            inn = new DataInputStream(nysocket.getInputStream());


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
