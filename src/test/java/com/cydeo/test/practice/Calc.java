package com.cydeo.test.practice;

import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        int n=0;
        Scanner in = new Scanner(System.in);
        String word = in.nextLine();
        String letter = in.nextLine();
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i)==letter.charAt(0)){
                n++;
            }
        }
        System.out.print(n);
    }
}
