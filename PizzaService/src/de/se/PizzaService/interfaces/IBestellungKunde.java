package de.se.PizzaService.interfaces;

import de.se.PizzaService.BestellProdukt;
import java.util.Date;
import java.util.List;

public interface IBestellungKunde {
    public int getId();
    public Boolean getLiefern();
    public void setLiefern(Boolean b);
    public String getLieferadr();
    public void setLieferadr(String s);
    public List<BestellProdukt> getBestellList();
    public void setBestellList(List<BestellProdukt> produktList);
    public void addToBestellList(BestellProdukt produkt);
    public Date getBestellzeit();
    public void setBestellzeit(Date d);
    public Boolean isVerspaetet();
    public void addBestellungToDB();   
}
