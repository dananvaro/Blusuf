package com.company;

public class Dekode_email {
    public static String dekodeemail(String kode){
        if(kode.startsWith("1")){
            return "Ingen email ble funnet på nettsiden";
        }
        else if(kode.startsWith("2")){
            return "Nettsiden eksisterer ikke din mongo";
        }
        else if(kode.startsWith("0")){
            kode = kode.replaceFirst("0","Disse emailene ble funnet på nettsiden" + "\n");
            return kode;
        }
        //havner aldri her
        return "Det du skrev ble ikke akseptert";
    }
}
