package de.se.PizzaService;

import de.se.PizzaService.interfaces.IDataFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BestellProdukt implements Serializable{

    private int aufpreis = 0;

    public enum Groesse {
        S, L, XL
    }
    private Groesse groesse = Groesse.S;

    public enum Topping {
        KAESE, OLIVEN, SCHAFSKAESE, PEPERONI, RUCOLA, SCHINKEN, ARTISCHOCKE, SALAMI, CHAMPIGNONS
    }

    private List<Topping> toppingList = new ArrayList<Topping>();
    private int produktId = 0;
    private int andereHaelfteId = 0;
    private int anzahl = 1;
    private final IDataFactory dataFactory;

    public BestellProdukt(IDataFactory datafactory, int produktId, int anzahl) {
        this.dataFactory = datafactory;
        this.produktId = produktId;
        this.anzahl = anzahl;
    }
    
    public BestellProdukt(IDataFactory datafactory, int produktId, int anzahl, Groesse groesse, List<Topping> toppingList) {
        this.dataFactory = datafactory;
        this.produktId = produktId;
        this.anzahl = anzahl;
        this.groesse = groesse;
        this.toppingList = toppingList;
    }
    
    public BestellProdukt(IDataFactory datafactory, int produktId, int andereHaelfteId, int anzahl, Groesse groesse, List<Topping> toppingList) {
        this.dataFactory = datafactory;
        this.produktId = produktId;
        this.andereHaelfteId = andereHaelfteId;
        this.anzahl = anzahl;
        this.groesse = groesse;
        this.toppingList = toppingList;
    }

    public int getAufpreis() {
        int aufpreis = 0;
        aufpreis = toppingList.size();
        if (groesse == Groesse.L) {
            aufpreis += 2;
        } else if (groesse == Groesse.XL) {
            aufpreis += 3;
        }
        return aufpreis;
    }

    public double calcPreis() {
        double preis = dataFactory.getProduktById(getProduktId()).getPreis();
        if (andereHaelfteId != 0) {
            double preisAndereHaelfte = dataFactory.getProduktById(getAndereHaelfteId()).getPreis();
            if (preisAndereHaelfte > preis) {
                preis = preisAndereHaelfte;
            }
        }
        preis = anzahl * preis + getAufpreis();
        return preis;
    }

    public Groesse getGroesse() {
        return groesse;
    }

    public void setGroesse(Groesse groesse) {
        this.groesse = groesse;
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public void addTopping(Topping topping) {
        toppingList.add(topping);
    }
    
    public String getProduktName() {
        if(getProduktId() != 0){
            return dataFactory.getProduktById(getProduktId()).getName();
        } else {
            return "";
        }
    }

    public int getProduktId() {
        return produktId;
    }

    public void setProduktId(int id) {
        produktId = id;
    }

    public int getAndereHaelfteId() {
        return andereHaelfteId;
    }

    public void setAndereHaelfteId(int id) {
        andereHaelfteId = id;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAzahl(int id) {
        anzahl = id;
    }
}
