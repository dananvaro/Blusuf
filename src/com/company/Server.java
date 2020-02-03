package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket server;
    Socket serversocket;
    PrintWriter ut;
    DataInputStream inn;
    DataInputStream stopp;


    public Server(int portnummer) {
        System.out.println("Velkommen til Serveren o2");

            try {
                //Lager en server med gitt portnummer
                server = new ServerSocket(portnummer);
                //når en klient kjører så aksepterer serveren tilkoplingen
                serversocket = server.accept();
                ut = new PrintWriter(serversocket.getOutputStream(), true);
                inn = new DataInputStream(serversocket.getInputStream());


                String hentInnput = inn.readLine();
                while (!hentInnput.equals("H")) {
                    ut.println(hentInnput.toUpperCase());
                    hentInnput = inn.readLine();
                    System.out.println(hentInnput);
                    if(hentInnput==null){
                        break;
                    }

                }

                System.out.println("linje 40");
                serversocket.shutdownInput();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


}
