package com.company;

public class Dekode_email {
    public static String dekodeemail(String kode){
        //dersom 1 så finner vi ikke emailen
        if(kode.equals("1")){
            return "Ingen email ble funnet på nettsiden";
        }
        //Dersom 2 så finner vi ikke nettsiden
        else if(kode.equals("2")){
            return "Nettsiden eksisterer ikke / nettsiden er ikke lesbar";
        }
        else if(kode.startsWith("0")){
            //dersom 0 så fant vi minst en email
            kode = kode.replace(" ","\n");
            kode = kode.replaceFirst("0","Disse emailene ble funnet på nettsiden : " + "\n");
            return kode;
        }
        //403 koder og slikt vil havne her
        return "Nettsiden er ikke lesbar";
    }
}
