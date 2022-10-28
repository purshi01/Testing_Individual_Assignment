package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Urinals {
    // Author Purushothama Shanthappa
    static Boolean goodString(String str) {
        // checks to see if valid string
       if (1 <= str.length() || str.length() <= 20 ){
           for (int i = 0; i < str.length(); i++) {
               if (!(str.charAt(i) == '1') || !(str.charAt(i) == '0')) {
                   return false;
               }
           }
           return true;
       }

        return false;
    }




    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");

        DataOutputStream output = new DataOutputStream(new FileOutputStream(
                path.concat("/src/DataBase/rule.text")));
        File file = new File(path.concat("/src/DataBase/urinal.dat"));
        Scanner scnr = new Scanner(file);
        Scanner strInt = new Scanner(System.in);
        Scanner strStr = new Scanner(System.in);


        while (true) {

            System.out.println("Enter 0 for to keyboard output or 1 for file output and 2 for exit ");
            int input = strInt.nextInt();
            if (input == 0) {
                System.out.println("Enter string to get the number of person can pee at a time in public toilet");
                String str = strStr.nextLine();
                if (goodString(str)) {
              //      System.out.println(countUrinals(str));
                } else {
                    System.out.println("Bad String re enter again");
                }

            } else if (input == 1) {
                while (scnr.hasNextLine()) {
                    String line = scnr.nextLine();
                    System.out.println(line);
                    if (goodString(line)) {
                //        System.out.println(countUrinals(line));
                    } else {
                        System.out.println("Bad String re enter again");
                    }
                }
            } else if (input == 2) {
                break;
            }


        }


    }
}
