package de.se.PizzaService.interfaces;

import de.se.PizzaService.Bestellung;
import de.se.PizzaService.BestellProdukt;
import java.util.List;

public interface IBestellungKoch {
    public int getId();
    public List<BestellProdukt> getBestellList();
    public void setBestellstatus(Bestellung.Bestellstatus bestellstatus);
    public Bestellung.Bestellstatus getBestellstatus();
    public Boolean isVerspaetet();
    public void delBestellung();
}
