package com.proglobby.innovpost;

public class Agency {
    private String name;
    private int zip;
    private int crowd;

    public Agency(String name, int zip, int crowd) {
        this.name = name;
        this.zip = zip;
        this.crowd = crowd;
    }

    public String getName() {
        return name;
    }

    public int getZip() {
        return zip;
    }

    public int getCrowd() {
        return crowd;
    }
}
