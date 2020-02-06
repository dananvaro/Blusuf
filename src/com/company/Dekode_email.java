package com.company;

public class Dekode_email {
    public static String dekodeemail(String kode){
        if(kode.equals("1")){
            return "Ingen email ble funnet på nettsiden";
        }
        else if(kode.equals("2")){
            return "Nettsiden eksisterer ikke / nettsiden er ikke lesbar";
        }
        else if(kode.startsWith("0")){
            kode = kode.replace(" ","\n");
            kode = kode.replaceFirst("0","Disse emailene ble funnet på nettsiden : " + "\n");
            return kode;
        }
        //403 koder og slikt vil havne her
        System.out.println(kode.toUpperCase());
        return "Nettsiden er ikke lesbar";
    }
}
