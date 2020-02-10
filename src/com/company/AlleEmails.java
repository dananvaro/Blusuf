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

            //retunerer denne stringen
            StringBuilder returner = new StringBuilder();
            //dersom du kommer hit så finnes nettsiden
            returner.append("0");
            String tekstIURL;
            //https://no.godaddy.com/email/professional-business-email
            //den emailen har 4 mails. kan ikke kjør modulus2 siden en av disse fjernes
            while ((tekstIURL = url.readLine()) != null) {
                //komplierer dette som blir en mail
                Pattern email = Pattern.compile("[a-åA-Å0-9_.+-]+@[a-ÅA-Å0-9-]+\\.[a-åA-Å0-9-.]+");
                Matcher emailfinner = email.matcher(tekstIURL);
                //legger til dersom vi finner noe som likner en mail
                while (emailfinner.find() == true) {
                    returner.append(emailfinner.group() + " ");
                }
            }
            if(returner.toString().equals("0")){
                return "1";
            }else {
                return returner.toString();
            }
        }catch (IOException e){
            //hvis url kræsjer så kommer vi hit
            //403 feilen oppstår ofte
            return "2";

        }

    }
}
