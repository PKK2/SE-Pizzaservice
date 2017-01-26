package de.se.PizzaService;


import de.se.PizzaService.interfaces.IDataFactory;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Malte Lundschien
 * @version 0.1, 25.01.2017
 */
public class DataFactory implements Serializable, IDataFactory{
    private HashMap<Integer, Bestellung> bestellMap = new HashMap<>();
    private int maxBestellId = 0;
    private HashMap<Integer, Produkt> produktMap = new HashMap<>(); 
    private int maxProduktId = 0;

    @Override
    public List<Produkt> getAllProdukte() {
        return new ArrayList<>(produktMap.values());
    }

    @Override
    public Produkt getProduktById(int id) {
        return produktMap.get(id);
    }

    @Override
    public void addProdukt(Produkt produkt) {
        produktMap.put(getNewProduktId(), produkt);
    }

    @Override
    public void editProdukt(int id, Produkt produkt) {
        produktMap.put(id, produkt);
    }

    @Override
    public void deleteProdukt(int id) {
        produktMap.remove(id);
    }

    @Override
    public List<Bestellung> getAllBestellungen() {
        return new ArrayList<>(bestellMap.values());
    }

    @Override
    public Bestellung getBestellungById(int id) {
        return bestellMap.get(id);
    }

    @Override
    public void addBestellung(Bestellung bestellung) {
        bestellMap.put(getNewBestellId(), bestellung);
    }

    @Override
    public void editBestellung(int id, Bestellung bestellung) {
        bestellMap.put(id, bestellung);
    }

    @Override
    public void deleteBestellung(int id) {
        bestellMap.remove(id);
    }

    private Integer getNewProduktId() {
        maxProduktId += 1;
        return maxProduktId;
    }
    
    private Integer getNewBestellId() {
        maxBestellId += 1;
        return maxBestellId;
    }
}
