package de.se.PizzaService.interfaces;



import de.se.PizzaService.Produkt;
import de.se.PizzaService.Bestellung;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Malte Lundschien
 * @version 0.1, 25.01.2017
 */
public interface IDataFactory {
    //Produkte
    public List<Produkt> getAllProdukte();
    public Produkt getProduktById(int id);
    public void addProdukt(Produkt produkt);
    public void editProdukt(int id, Produkt produkt);
    public void deleteProdukt(int id);
    //Bestellungen
    public List<Bestellung> getAllBestellungen();
    public Bestellung getBestellungById(int id);
    public void addBestellung(Bestellung bestellung);
    public void editBestellung(int id, Bestellung bestellung);
    public void deleteBestellung(int id);
}
