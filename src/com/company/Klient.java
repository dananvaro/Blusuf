package com.company;

import java.io.*;
import java.net.Socket;

public class Klient {
    //initerer
    private Socket socket;
    private InputStreamReader innput;
    private DataOutputStream utput;

    public Klient(String adresse, int portnummer){
        try {
            socket = new Socket(adresse, portnummer);

            PrintWriter ut = new PrintWriter(socket.getOutputStream());

            
            innput = new InputStreamReader(socket.getInputStream());
            BufferedReader inn = new BufferedReader(innput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
