import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
@author Nadime B.
*/
public class GUI {
	JFrame kunde, koch;  	
	JPanel kochPanel, kundePanel, kundePanelMitte;
	ImageIcon pizzaSymbol;
	Buttons buttons;
	KochButtons kochbuttons;
	public GUI () {
		
		 kunde = new JFrame();
		 koch = new JFrame();
		 buttons = new Buttons(kunde);
		 kochbuttons = new KochButtons(koch);
		 // TODO
		 pizzaSymbol = new ImageIcon("C:/Users/Nado/workspace/Pizzaservice/src/resources/pizza.png");
		 
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
	//	 koch.setResizable(false);
		 koch.setLayout(null);
		 PanelKoch();
		
	}
	
	private void createKundeFrame() {
		
				 // Setze den Titel des Fensters
				 kunde.setTitle("Kunde");
				 // Setze die Groesse des Fensters
				 kunde.setPreferredSize(new Dimension(670,600));
				 kunde.setResizable(false);
				 kunde.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 kunde.getContentPane().setBackground(Color.RED);
				 //System.out.println( new File("C:/Users/Nado/workspace/Pizzaservice/src/resources/hallo.jpg").exists());
				 //Hier ist wichtig, natürlich den richtigen Pfad anzugeben. + dateiformat //am bestem my myclass suchen + dateiname :)
				
				 kunde.setIconImage(pizzaSymbol.getImage());
				 kunde.setLayout(null);
				 PanelKunde();
				 
	}
	
	private void PanelKunde(){
		Font standart = new Font(null,Font.BOLD,15);
		JLabel ueberschrift = new JLabel("Pizza Service");
		JLabel geschmack = new JLabel("Sorten:");
		JLabel groesse = new JLabel("Groesse:");
		JLabel adresse = new JLabel("Adresse:");
		
		ueberschrift.setFont(new Font(null,Font.BOLD,30));
		ueberschrift.setBounds(230,10,200,30);
		geschmack.setBounds(200,70,100,30);
		geschmack.setFont(standart);
		groesse.setFont(new Font(null,Font.BOLD,14));
		groesse.setBounds(187,90,100,30);
		kunde.add(ueberschrift);
		kunde.add(geschmack);
		kunde.add(groesse);
		
		//Kein guter Programmierstill, hätte man auch alles im Konstruktor von Buttons machen koennen....
		buttons.pizzaGeschmack();
		buttons.addBestellButton();
		buttons.pizzaSize();
		buttons.addTextFieldKunde();
		buttons.extraToppings();
		buttons.addAbholButton();
		buttons.addBestellungBeastigenButton();
	}
	
	
	private void PanelKoch(){
		kochbuttons.makeFrame();
		
	}
	
}


