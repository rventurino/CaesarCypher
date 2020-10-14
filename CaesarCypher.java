package LabAssignment3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*

 */

public class Venturino_Lab_3 {
    public static void main(String[] args) {
        String listDecryptedPW = "";
        Scanner scan;
        try{
            File pw = new File("src/passwords.txt");
            scan = new Scanner(pw);
            while(scan.hasNext()){
                listDecryptedPW += " " + decrypt(scan.nextLine(), 5);
            }
        } catch(IOException e){
            System.out.println("Better luck next time");
        }

    }

    public static String decrypt(String pass, int shift) {
        pass = pass.toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String decryptedPW = "";
        char[] alphabetAsArray = alphabet.toCharArray();
        char[] passwordAsArray = pass.toCharArray();
        int letterPosition = 0;
        int sub = 0;

        for (int i = 0; i < passwordAsArray.length; i++) {
            letterPosition = alphabet.indexOf(passwordAsArray[i]);
            sub = letterPosition-shift;
            if(sub>-1) {
                decryptedPW += alphabetAsArray[sub];
            } else {
                decryptedPW += alphabetAsArray[sub + 26];
            }
        }
        return decryptedPW;
    }
}
