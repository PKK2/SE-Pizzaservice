package de.se.PizzaService;

import de.se.PizzaService.interfaces.IDataFactory;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Malte Lundschien
 * @version 1.0, 25.01.2017
 */
public class PizzaService {

    /**
     * @param args the command line arguments
     */
    private static final String FILENAME = "data.ser";

    public static void main(String[] args) {
        InputStream fis = null;
        DataFactory dataFactory = null;
        try {
            fis = new FileInputStream(FILENAME);
            ObjectInputStream o = new ObjectInputStream(fis);
            dataFactory = (DataFactory) o.readObject();
            fis.close();
        } catch (IOException e) {
            //System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
        
        if(dataFactory == null){
            dataFactory = getDFTestData();
        }

      //  for (Produkt p : dataFactory.getAllProdukte()) {
      //      System.out.println("Pizzaname: " + p.getName() + " Preis: " + p.getPreis());
      //  }

        //TODO application Logic, that uses variable dataFactory via IDataFactory
        OutputStream fos = null;
        try {
            fos = new FileOutputStream(FILENAME);
            ObjectOutputStream o = new ObjectOutputStream(fos);
            o.writeObject(dataFactory);
            fos.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    
    private static DataFactory getDFTestData() {
        DataFactory dataFactory = new DataFactory();
        Produkt produkt = new Produkt();
        produkt.setName("Margherita");
        produkt.setPreis(5.99);
        dataFactory.addProdukt(produkt);

        produkt = new Produkt();
        produkt.setName("Thunfisch");
        produkt.setPreis(6.99);
        dataFactory.addProdukt(produkt);

        produkt = new Produkt();
        produkt.setName("Salami");
        produkt.setPreis(6.99);
        dataFactory.addProdukt(produkt);
        
        return dataFactory;
    }

}
