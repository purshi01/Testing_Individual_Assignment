package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
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

        if (goodString(string)) {
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
        else {
            return -1;
        }

    }


    public static String readFileAsString(String fileName) throws Exception {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(fileName)));
        return data;
    }

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir");

        File fw = new File(path.concat("/src/DataBase/rule.txt"));

        File file = new File(path.concat("/src/DataBase/urinal.dat"));
        FileWriter fileWriter;
        Scanner scnr = new Scanner(file);
        Scanner strInt = new Scanner(System.in);
        Scanner strStr = new Scanner(System.in);
        int i=1;

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

                HashSet<String> h = new HashSet<>();String filename;
                if(fw.createNewFile()){
                }
                else{
                    filename = fw.getName();
                    String f = filename.replace(".txt","");

                    while (fw.exists()){
                        f += i;
                        fw = new File(path.concat("/src/DataBase/"+f+".txt"));
                    }
                }
                fileWriter = new FileWriter(fw);
                while (scnr.hasNextLine()) {

                    String line = scnr.nextLine();

                        if (goodString(line)) {
                            fileWriter.write(countUrinals(line)+"\n");
                        } else {
                            System.out.println("Bad String re enter again");
                        }


                }
                fileWriter.flush();
                fileWriter.close();
            } else if (input == 2) {
                break;
            }


        }


    }
}
