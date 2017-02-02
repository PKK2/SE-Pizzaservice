package de.se.PizzaService;

import de.se.PizzaService.interfaces.IBestellungKunde;
import de.se.PizzaService.interfaces.IBestellungKoch;
import de.se.PizzaService.interfaces.IDataFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bestellung implements IBestellungKunde, IBestellungKoch, Serializable{

    private int id;
    private boolean liefern = false;
    private String lieferadr = "";
    private List<BestellProdukt> bestellList = new ArrayList<BestellProdukt>();
    private Date bestellzeit = new Date();
    private final IDataFactory datafactory;

    public Bestellung(IDataFactory dataFactory){
        this.datafactory = dataFactory;
    }
    
    public enum Bestellstatus{
    NEU, BACKEND, INZUSTELLUNG, ABGESCHLOSSEN, ABGEBROCHEN 
    };
    private Bestellstatus bestellstatus = Bestellstatus.NEU;
    
    @Override
    public Boolean getLiefern() {
        return liefern;
    }

    @Override
    public void setLiefern(Boolean b) {
        liefern = b;
    }

    @Override
    public String getLieferadr() {
        return lieferadr;
    }

    @Override
    public void setLieferadr(String s) {
        lieferadr = s;
    }

    @Override
    public List<BestellProdukt> getBestellList() {
        return bestellList;
    }
    
    @Override
    public void setBestellList(List<BestellProdukt> produktList) {
        bestellList = produktList;
    }

    @Override
    public void addToBestellList(BestellProdukt produkt) {
        bestellList.add(produkt);
    }
    
    @Override
    public Date getBestellzeit(){
        return bestellzeit;
    }
    
    @Override
    public void setBestellzeit(Date d){
        bestellzeit = new Date(d.getTime());
    }
    
    @Override
    public Boolean isVerspaetet(){
        //1 hour = 3600000 ms
        if(new Date().getTime()-bestellzeit.getTime() > 3600000){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public Bestellstatus getBestellstatus(){
        return bestellstatus;
    }
    
    @Override
    public void setBestellstatus(Bestellstatus bestellstatus){
        this.bestellstatus = bestellstatus;
    }
    
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public void addBestellungToDB(){
        datafactory.addBestellung(this);
    }
    
    @Override
    public void delBestellung(){
        datafactory.deleteBestellung(getId());
    }
}
