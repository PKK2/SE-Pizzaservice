import javax.swing.*;
import java.awt.*;
import java.io.*;

public class GUI {
	JFrame kunde, koch;  	
	JPanel kochPanel, kundePanel, kundePanelMitte;
	ImageIcon pizzaSymbol;
	Buttons buttons = new Buttons();
	
	public GUI () {
		 kunde = new JFrame();
		 koch = new JFrame();
		
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
		 koch.setPreferredSize(new Dimension(670,700));
		
		 koch.setLocation(670, 0);
		 
		 koch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 koch.setIconImage(pizzaSymbol.getImage());
		 koch.setLayout(new BorderLayout());
		 
		 
		 koch.getContentPane().add(PanelKoch(), BorderLayout.PAGE_END);
		
	}
	
	private void createKundeFrame() {
		
				 // Setze den Titel des Fensters
				 kunde.setTitle("Kunde");
				 // Setze die Groesse des Fensters
				 kunde.setPreferredSize(new Dimension(670,600));
				
				 kunde.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 kunde.getContentPane().setBackground(Color.RED);
				 //System.out.println( new File("C:/Users/Nado/workspace/Pizzaservice/src/resources/hallo.jpg").exists());
				 //Hier ist wichtig, natürlich den richtigen Pfad anzugeben. + dateiformat //am bestem my myclass suchen + dateiname :)
				
				 kunde.setIconImage(pizzaSymbol.getImage());
				 kunde.setLayout(new BorderLayout());
				 kunde.getContentPane().add(PanelKundeOben(), BorderLayout.PAGE_START);
				 kunde.getContentPane().add(PanelKundeMitte(), BorderLayout.CENTER);
		//		 PanelKundeUnten();
	}
	
	private JPanel PanelKundeOben(){
		kundePanel = new JPanel( new BorderLayout(0,20));
	//	JPanel obenPanel = new JPanel(new FlowLayout());
		kundePanel.setBackground(new Color(150,220,0));
		
		JLabel bestellen = new JLabel("Pizza Bestellen");
		bestellen.setFont(new Font("Hallo",Font.BOLD, 20));
		bestellen.setHorizontalAlignment(JLabel.CENTER);
	
		kundePanel.add(bestellen, BorderLayout.PAGE_START);
		
		buttons.pizzaSize(kundePanel);
		kunde.add(buttons.addBestellButton());
		kunde.add(buttons.addToppingButton());
//		PanelKundeUnten();
//		Component [] haha = kunde.getComponents();
//		for(int i = 0; i< haha.length; i++){
//			System.out.println(haha.toString());
//			System.out.println(haha.getClass());
//			System.out.println(haha[i] instanceof JPanel);
//		}
		return kundePanel;
	}
	
	private JPanel PanelKundeMitte(){
		kundePanelMitte = new JPanel( new BorderLayout(0,20));
		
		buttons.pizzaGeschmack(kundePanelMitte);
		return kundePanelMitte;	
		
	}
	private void PanelKundeUnten(){
		JTextField adresse = new JTextField(20);
		JLabel adresseLabel = new JLabel("Adresse");
		
		adresse.setBounds(240, 200, 200, 20);
		adresseLabel.setBounds(190,200,200,20);
		kunde.add(adresseLabel);
		kunde.add(adresse);
		
		
	}
	private JPanel PanelKoch(){
		kochPanel = new JPanel( new BorderLayout());
		kochPanel.setBackground(new Color(150,220,0));
		
		JLabel uno = new JLabel(pizzaSymbol);
		
		JLabel dos = new JLabel(pizzaSymbol);
		// dos.setHorizontalAlignmeanyfacfacout.CENTER);
		
		
		kochPanel.add(new JLabel("lolol"), BorderLayout.PAGE_END);
		
		
		return kochPanel;
		

	
	
	}

}

