/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.se.PizzaService;

/**
 *
 * @author Malte
 */
public class Bestellung {
	private int id;
	private Kunde kunde;
	private boolean liefern;
	private String lieferadr;
	private ArrayList<Produkt> bestellliste = new ArrayList<Produkt>();
	private String bestellzeit;
	private Bestellstatus bestellstatus;
	private boolean verspaetet;

	public Kunde getKunde() {
		return kunde;
	}

	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}

	public int getId() {
		return id;
	}

}
