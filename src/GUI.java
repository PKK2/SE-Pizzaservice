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
	
	public GUI () {
		
		 kunde = new JFrame();
		 koch = new JFrame();
		 buttons = new Buttons(kunde);
		 // TODO
		 pizzaSymbol = new ImageIcon("C:/Users/Nado/workspace/Pizzaservice/src/resources/pizza.png");
		 
		 createKundeFrame();
		 createKochFrame();
		 
		 koch.pack();
		 kunde.pack();
		 
		// koch.setVisible(true);
		 kunde.setVisible(true);
		 
	}
	private void createKochFrame(){
		 koch.setTitle("Koch");
		 koch.setPreferredSize(new Dimension(670,700));
		
		 koch.setLocation(670, 0);
		 
		 koch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 koch.setIconImage(pizzaSymbol.getImage());
		 koch.setLayout(new BorderLayout());
		 
		 
		
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
				 PanelKundeOben(kunde);
				 
//				 kunde.setLayout(new BorderLayout());
//				 kunde.getContentPane().add(PanelKundeOben(), BorderLayout.PAGE_START);
//				 kunde.getContentPane().add(PanelKundeMitte(), BorderLayout.CENTER);
		//		 PanelKundeUnten();
	}
	
	private void PanelKundeOben(JFrame kunde){
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
		buttons.pizzaGeschmack(kunde);
		buttons.addBestellButton(kunde);
		buttons.pizzaSize(kunde);
		buttons.addTextFieldKunde(kunde);
		buttons.extraToppings();
		buttons.addAbholButton();
		
	}
	
	private void PanelKundeMitte(){
//		kundePanelMitte = new JPanel( new BorderLayout(0,20));
//		
//		buttons.pizzaGeschmack(kundePanelMitte);
//		return kundePanelMitte;	
		
	}
	private void PanelKundeUnten(){
//		JTextField adresse = new JTextField(20);
//		JLabel adresseLabel = new JLabel("Adresse");
//		
//		adresse.setBounds(240, 200, 200, 20);
//		adresseLabel.setBounds(190,200,200,20);
//		kunde.add(adresseLabel);
//		kunde.add(adresse);
//		
		
	}
	private void PanelKoch(){
	

	
	
	}
	
}

