package com.example.lab.services;

import com.example.lab.models.mainModel;

public class Service {
    public static void numberOperation(String string, mainModel number) {
        switch (string) {
            case "Code":
                int i, j=number.getStr1().length();
                char [] newest = number.getStr1().toCharArray();
                for( i=0; i<j; i++) {
                    newest[i] = number.getStr1().charAt(i);
                    newest[i] += 3;
                }
                number.setDecstr(String.valueOf(newest));
                break;
            case "Decode":
                int i2, j2=number.getDecstr().length();
                char [] newest2 = number.getDecstr().toCharArray();
                for( i2=0; i2<j2; i2++) {
                    newest2[i2] = number.getDecstr().charAt(i2);
                    newest2[i2] -= 3;
                }
                number.setStr1(String.valueOf(newest2));
                break;
        }
    }
}