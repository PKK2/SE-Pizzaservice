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
public class Produkt implements IProduktMitarbeiter {
	private int id;
	private String name;
	private int preis;
	private Rezept rezept;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPreis() {
		return preis;
	}

	public void setPreis(int preis) {
		this.preis = preis;
	}

	public Rezept getRezept() {
		return rezept;
	}

	public void setRezept(Rezept rezept) {
		this.rezept = rezept;
	}

	public int getId() {
		return id;
	}

}
