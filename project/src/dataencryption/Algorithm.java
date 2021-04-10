/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataencryption;

import java.util.Scanner;

/**
 *
 * @author WIKTOR
 */
public class Algorithm {

    public static String inputFromUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your text to encrypt: ");
        String result = sc.nextLine();
        sc.close();
        return result;
    }

    public static String encrypt(String message) {
        StringBuilder sb = new StringBuilder(message);
        int distance = 5;
        for (int i = 0; i < sb.length(); i++) {
            int c = (int) sb.charAt(i);

            if (c + distance > 122) {
                c = c - 122 + distance + 31;
            } else {
                c += distance;
            }
            sb.setCharAt(i, (char) c);
        }
        return sb.toString();
    }

    public static String decrypt(String message) {
        StringBuilder sb = new StringBuilder(message);
        int distance = 5;
        for (int i = 0; i < sb.length(); i++) {
            int c = (int) sb.charAt(i);
            if (c - distance < 32) {
                //c = 123 - (distance - (c - 32));
                c = c + 123 - distance - 32;
            } else {
                c -= distance;
            }
            sb.setCharAt(i, (char) c);
        }
        return sb.toString();

    }


}
