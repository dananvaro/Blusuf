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
    int tall = 0;


    public Server(int portnummer) {
        System.out.println("Velkommen til Serveren o2");

        try {
            server = new ServerSocket(portnummer);
        } catch (IOException e) {
            //Lager en server med gitt portnummer
            e.printStackTrace();
        }

        while(true) {
            try {
                //når en klient kjører så aksepterer serveren tilkoplingen

                serversocket = server.accept();
                System.out.println("klient nummer "+tall++);
                Multi trad = new Multi(serversocket);
                trad.start();
                System.out.println("Maaaa");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
