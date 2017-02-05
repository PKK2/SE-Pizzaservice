import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
@author Nadime B.
*/
public class GUI {
	private	JFrame kunde, koch;  	
	private ImageIcon pizzaSymbol;
	private Buttons buttons;
	private KochButtons kochbuttons;
	private IDataFactory datafactory;
	
	public GUI (IDataFactory datafactory) {
		 this.datafactory = datafactory;
		 kunde = new JFrame();
		 koch = new JFrame();
		 buttons = new Buttons(datafactory, kunde);
		 kochbuttons = new KochButtons(koch);
		
		 pizzaSymbol = new ImageIcon("pizza.png");
		 
		 createKundeFrame();
		 createKochFrame();
		 
		 koch.pack();
		 kunde.pack();
		 
		 koch.setVisible(true);
		 kunde.setVisible(true);
		 
	}
	private void createKochFrame(){
		 koch.setTitle("Koch");
		 koch.setPreferredSize(new Dimension(670,600));
		 koch.getContentPane().setBackground(Color.RED);
		 koch.setLocation(670, 0);
		 
		 koch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 koch.setIconImage(pizzaSymbol.getImage());
		 koch.setLayout(new BorderLayout());
		 koch.setResizable(false);
		 koch.setLayout(null);
		 PanelKoch();
		
	}
	
	private void createKundeFrame() {
		
				 kunde.setTitle("Kunde");
				 kunde.setPreferredSize(new Dimension(670,600));
				 kunde.setResizable(false);
				 kunde.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 kunde.getContentPane().setBackground(Color.RED);
				 kunde.setIconImage(pizzaSymbol.getImage());
				 kunde.setLayout(null);
				 PanelKunde();
				 
	}
	
	private void PanelKunde(){
		Font standart = new Font(null,Font.BOLD,15);
		JLabel ueberschrift = new JLabel("Pizza Service");
		JLabel geschmack = new JLabel("Sorten:");
		JLabel groesse = new JLabel("Groesse:");
		
		ueberschrift.setFont(new Font(null,Font.BOLD,30));
		ueberschrift.setBounds(230,10,200,30);
		geschmack.setBounds(200,70,100,30);
		geschmack.setFont(standart);
		groesse.setFont(new Font(null,Font.BOLD,14));
		groesse.setBounds(187,90,100,30);
		kunde.add(ueberschrift);
		kunde.add(geschmack);
		kunde.add(groesse);
		
		//Kein guter Programmierstill, hätte man auch alles im Konstruktor von Buttons machen koennen.... siehe PanelKoch()
		buttons.pizzaGeschmack();
		
		buttons.pizzaSize();
		buttons.addTextFieldKunde();
		buttons.extraToppings();
		buttons.addAbholButton();
		buttons.addBestellungBeastigenButton();
		buttons.addWeitereBestellung();
	}
	
	
	private void PanelKoch(){
		kochbuttons.makeFrame();
		
	}
	
	public String toString() {
		return "Gui fuer Kunde und Koch";
	}
	
}


