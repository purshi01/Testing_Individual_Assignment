package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Urinals {
    // Author Purushothama Shanthappa
    static Boolean goodString(String str) {
        // checks to see if valid string
        if (str.matches("^[01]+$")) {
            if (!(1 <= str.length()) || !(str.length() <= 20))
                return false;
            return true;
        } else {
            return false;
        }
    }

    static int countUrinals(String string) {

        int n = string.length();
        int Count = 0;

        if (string.charAt(0) == '0' && string.charAt(1) == '0') {
            Count++;
            StringBuffer string0 = new StringBuffer(string);
            string0.setCharAt(0, '1');
            string = String.valueOf(string0);
        }


        {
            for (int i = 1; i < n - 1; i++) {
                if (string.charAt(i - 1) == '0' && string.charAt(i + 1) == '0' && string.charAt(i) == '0') {
                    Count++;
                    StringBuffer string0 = new StringBuffer(string);
                    string0.setCharAt(i, '1');
                    string = String.valueOf(string0);
                }
            }
            if (string.charAt(n - 1) == '0' && string.charAt(n - 2) == '0') {
                Count++;
                StringBuffer string0 = new StringBuffer(string);
                string0.setCharAt(n - 1, '1');
                string = String.valueOf(string0);
            }
        }
        return Count;

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
                          System.out.println(countUrinals(str));
                } else {
                    System.out.println("Bad String re enter again");
                }

            } else if (input == 1) {
                while (scnr.hasNextLine()) {
                    String line = scnr.nextLine();
                    if (goodString(line)) {
                               System.out.println(countUrinals(line));
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
