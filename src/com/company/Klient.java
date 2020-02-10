package com.company;
import java.io.*;
import java.net.Socket;
import java.net.SocketException;

public class Klient {
    //initerer variablene
    private Socket socket;
    private PrintWriter utput;
    private BufferedReader in = null;
    private BufferedReader ut = null;

    public Klient(String adresse, int portnummer) {

        try {
            //lager en tilkopling
            socket = new Socket(adresse,portnummer);

            //Denne skal hente inn verdi/string
            in = new BufferedReader(new InputStreamReader(System.in));

            //Hent string fra Serveren
            ut  = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //brukes for å sende til server
            utput = new PrintWriter(socket.getOutputStream(), true);


            System.out.println("Velkommen til E-mail søkeren");
            //initialiserer meld
            String meld;
            //henter innput fra bruker
            String innput = in.readLine();
            while (!innput.equalsIgnoreCase("Takk") && !innput.equalsIgnoreCase("stopp server")){
                //sender innputen til serveren
                utput.println(innput);
                //henter Stringen fra serveren
                 meld = ut.readLine();
                 //dekoder koden vi får fra serveren
                System.out.println(Dekode_email.dekodeemail(meld));
                //ny innput
                innput = in.readLine();
            }
            if (innput.equalsIgnoreCase("stopp server")){
                utput.println(innput);  socket.close();}
            if (innput.equalsIgnoreCase("takk")) utput.println(innput);

            socket.shutdownOutput();
            socket.close();

            //socket.shutdownInput();

        } catch (SocketException e){
            System.out.println("Serveren er lukket og dermed lukkes koplingen");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Klenten har stoppet koplingen med serveren");
        }

    }
    }


