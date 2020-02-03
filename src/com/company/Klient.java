package com.company;
import java.io.*;
import java.net.Socket;

public class Klient {
    //initerer
    private Socket socket;
    private PrintWriter utput;
    private DataInputStream in;
    private DataInputStream ut;

    public Klient(String adresse, int portnummer) {

        try {
            //lager en tilkopling
            socket = new Socket(adresse,portnummer);

            //Denne skal hente inn verdi/string
            in = (new DataInputStream (System.in));

            //Hent string fra Serveren
            ut = new DataInputStream(socket.getInputStream());

            //brukes for å sende til server
            utput = new PrintWriter(socket.getOutputStream(), true);


            System.out.println("har havner her");
            //initialiserer meld
            String meld;
            //henter innput fra bruker
            String innput = in.readLine();
            while (!innput.equals("H")) {
                //sender innputen til serveren
                utput.println(innput);
                //henter Stringen fra serveren
                 meld = ut.readLine();
                System.out.println(meld);
                //ny innput
                innput = in.readLine();
            }
            socket.shutdownOutput();
            socket.shutdownInput();

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("Klienten har ikke en connetion lenger");
        }

    }
    }


