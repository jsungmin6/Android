package com.example.memoapp;

public class Memo {

    String maintext;
    String subtext;
    int isdone;

    public Memo(String maintext, String subtext, int isdone) {
        this.maintext = maintext;
        this.subtext = subtext;
        this.isdone = isdone;
    }

    public String getMaintext() {
        return maintext;
    }

    public void setMaintext(String maintext) {
        this.maintext = maintext;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public int getIsdone() {
        return isdone;
    }

    public void setIsdone(int isdone) {
        this.isdone = isdone;
    }
}
