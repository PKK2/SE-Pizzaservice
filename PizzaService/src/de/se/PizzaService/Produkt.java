package de.se.PizzaService;

import java.io.Serializable;

public class Produkt implements Serializable{

    private int id;
    private String name = "";
    private double preis = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
