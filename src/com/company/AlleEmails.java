package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlleEmails {
    public static String Alleemail(String nettadresse){

        try {
            URL net = new URL(nettadresse);
            BufferedReader url = new BufferedReader(new InputStreamReader(net.openStream()));

            StringBuilder returner = new StringBuilder();
            returner.append("0");
            String tekstIURL;
            //https://no.godaddy.com/email/professional-business-email
            //den emailen har 4 mails. kan ikke kjør modulus2 siden en av disse fjernes
            while ((tekstIURL = url.readLine()) != null) {
                Matcher m = Pattern.compile("[a-åA-Å0-9_.+-]+@[a-ÅA-Å0-9-]+\\.[a-åA-Å0-9-.]+").matcher(tekstIURL);
                while (m.find() == true) {
                    returner.append(m.group() + " ");
                }
            }
            if(returner.toString().equals("0")){
                return "1";
            }else {
                return returner.toString();
            }
        }catch (IOException e){
            return "2";

        }

    }
}
