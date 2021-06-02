package com.example.lab.models;

public class mainModel implements Comparable<mainModel>{
    private String str1, decstr;

    public String getStr1() {
        return str1;
    }
    public void setStr1(String str1) {
        this.str1 = str1;
    }
    public void setDecstr(String decstr) {
        this.decstr = decstr ;
    }
    public String getDecstr() {
        return decstr;
    }

    @Override
    public String toString() {
        return "number=" + str1; }

    @Override
    public int compareTo(mainModel o) {
        return this.str1.length()-o.getStr1().length();
    }

}

