package de.htwberlin.webtech.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    private int aid;
    private String aname;
    @Autowired
    private Laptop laptop;

    public Alien() {
        super();
        System.out.println("alien created");

    }



    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    void show(){
        System.out.println("What'up youtube");
        laptop.info();
    }
}
