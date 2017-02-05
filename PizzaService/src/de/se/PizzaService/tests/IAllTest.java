package de.se.PizzaService.interfaces;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import de.se.PizzaService.BestellProdukt;
import de.se.PizzaService.BestellProdukt.Groesse;
import de.se.PizzaService.Bestellung;
import de.se.PizzaService.Bestellung.Bestellstatus;
import de.se.PizzaService.DataFactory;
import de.se.PizzaService.PizzaService;
import de.se.PizzaService.Produkt;

public class IAllTest {
	
	DataFactory datafactory = PizzaService.getDFTestData();
	public Bestellung testBestellung = new Bestellung(datafactory);
	public IBestellungKoch testKoch = testBestellung;
	public IBestellungKunde testKunde = testBestellung;
	public IDataFactory testDataFactory = datafactory;
	List<BestellProdukt> bestellList = new ArrayList<BestellProdukt>();
	List<Produkt> produktliste = testDataFactory.getAllProdukte();
	
	@Test
	public void testKunde(){
		testKunde.getId();
		testKunde.setLiefern(false);
		assertFalse(testKunde.getLiefern());
		testKunde.setLiefern(true);
		assertTrue(testKunde.getLiefern());
		testKunde.setLieferadr("s");
		assertEquals("s",testKunde.getLieferadr());
		
		BestellProdukt neuesProdukt = new BestellProdukt(testDataFactory, 2, 2);
		bestellList.add(neuesProdukt);
		neuesProdukt = new BestellProdukt(testDataFactory, 1, 1, Groesse.L, null);
		bestellList.add(neuesProdukt);
		
		testKunde.setBestellList(bestellList);
		assertTrue(testKunde.getBestellList().equals(bestellList));
		
		neuesProdukt = new BestellProdukt(testDataFactory, 3, 2, Groesse.XL, null);
		testKunde.addToBestellList(neuesProdukt);
		bestellList.add(neuesProdukt);
		assertTrue(testKunde.getBestellList().equals(bestellList));
		
		Date date = new Date();
		testKunde.setBestellzeit(date);
		assertTrue(testKunde.getBestellzeit().equals(date));
		assertFalse(testKunde.isVerspaetet());
		
		date = new Date(date.getTime()-3600005);
		testKunde.setBestellzeit(date);
		assertTrue(testKunde.getBestellzeit().equals(date));
		assertTrue(testKunde.isVerspaetet());
		
		testKunde.addBestellungToDB();
	}
	
	@Test
	public void testKoch(){
		assertTrue(testKoch.getBestellstatus().equals(Bestellstatus.NEU));
		assertEquals(0, testKoch.getId());
		assertTrue(testKoch.getBestellList().equals(bestellList));
		testKoch.setBestellstatus(Bestellstatus.BACKEND);
		assertTrue(testKoch.getBestellstatus().equals(Bestellstatus.BACKEND));
		assertFalse(testKoch.isVerspaetet());
	}
	

	
	@Test
	public void testDataFactory(){
		testKunde.addBestellungToDB();
		
		Produkt produkt = new Produkt();
		
		int id = produktliste.size();
		testDataFactory.getProduktById(id);
		
		produkt = new Produkt();
		produkt.setName("BBQ Puzza");
		produkt.setPreis(7.99);		
		testDataFactory.addProdukt(produkt);
		assertTrue(testDataFactory.getProduktById(id+1).equals(produkt));
		
		
		produkt = new Produkt();
		produkt.setName("BBQ Pizza");
		produkt.setPreis(7.99);	
		testDataFactory.editProdukt(id+1, produkt);
		assertTrue(testDataFactory.getProduktById(id+1).equals(produkt));		
		testDataFactory.deleteProdukt(id+1);
		
		
		id = 1;
		assertFalse(testDataFactory.getAllBestellungen().isEmpty());
		assertTrue(testDataFactory.getBestellungById(id).equals(testBestellung));
		
		Bestellung testBestellung2 = testBestellung;
		testBestellung2.addToBestellList(new BestellProdukt(testDataFactory, 4, 3));
		
		testDataFactory.addBestellung(testBestellung2);
		id++;
		assertTrue(testDataFactory.getBestellungById(id).equals(testBestellung2));
		
		testDataFactory.editBestellung(id, testBestellung);
		assertTrue(testDataFactory.getBestellungById(id).equals(testBestellung));
		
		testDataFactory.deleteBestellung(id);
		id--;
	}
	
	@Test(expected=NullPointerException.class)
	public void testDeleteNonExistableProdukt(){
		int id = produktliste.size();
		testDataFactory.getProduktById(id+1).equals(null);
	}
	
	@Test(expected=NullPointerException.class)
	public void testDeleteNonExistableBestellung(){
		testDataFactory.getBestellungById(1).equals(null);
	}

}
