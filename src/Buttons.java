import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Buttons   {
	private JLabel halfHalf, anzahl;
	private int tAnzahl= 0;
	private JPanel button;
	private BListener buttonListener;
	private JFrame kunde;
	private Boolean half = false;
	private JRadioButton  ma, sa ,th, klein, mittel,gross;
	private ButtonGroup bGHalf;
	private JSlider toppings;
	private JRadioButton margherita, thunfisch, salami;
	private JTextField adresse, telefonnummer, name;
	private JToggleButton abholen;
	public Buttons (JFrame kunde){
		this.kunde = kunde;
		buttonListener = new BListener(this,kunde);
		button = new JPanel();
		button.setLayout(null);
		JLabel toppLabel = new JLabel("Topping Anzahl:");
		toppLabel.setBounds(100,200,100,100);
		kunde.add(toppLabel);
		
	}
	
	public void addSlider(int i) {
		//toppings = new JSlider(0,5);
		if(i == 2){
			toppings = new JSlider(0,2);
		}
		else if( i == 3){
			toppings = new JSlider(0,3);
		}
		else{
			toppings = new JSlider(0,5);
		}
		
		toppings.setBounds(250, 235, 140, 50);
		toppings.setMajorTickSpacing(1);
		toppings.setMinorTickSpacing(1);
		toppings.setPaintLabels(true);
		toppings.setPaintLabels(true);
		toppings.setFont(new Font(null,Font.BOLD,10));
		toppings.setBackground(Color.red);
		toppings.addChangeListener(buttonListener);
		toppings.setValue(0);
		kunde.add(toppings);
		
	}
	public void pizzaSize(JFrame kunde){
		
		ButtonGroup gp = new ButtonGroup();
		klein = new JRadioButton("Klein");
		mittel = new JRadioButton("Mittel");
		gross  = new JRadioButton("Gross") ;
		gp.add(klein);
		gp.add(mittel);
		gp.add(gross);
	//	klein.setActionCommand("Klein");
		klein.setBackground(Color.red);
		mittel.setBackground(Color.red);
		gross.setBackground(Color.red);
		klein.addActionListener(buttonListener);
		mittel.addActionListener(buttonListener);
		gross.addActionListener(buttonListener);
		
		
		klein.setBounds(255,90,100,30);
		mittel.setBounds(350,90,100,20);
		gross.setBounds(445,90,100,20);
		kunde.add(klein);
		kunde.add(mittel);
		kunde.add(gross);
	}
	
	public void pizzaGeschmack(JFrame kunde){
		
		ButtonGroup gp = new ButtonGroup();
		margherita = new JRadioButton("Margherita");
		thunfisch = new JRadioButton("Thunfisch");
		salami  = new JRadioButton("Samali") ;
		gp.add(margherita);
		gp.add(thunfisch);
		gp.add(salami);

		margherita.setBackground(Color.red);
		thunfisch.setBackground(Color.red);
		salami.setBackground(Color.red);
		//theoretisch noch margherita.setActionCommant("LOL") ---> ermöglicht abfrage bei BListener auf LOL
		margherita.addActionListener(buttonListener);
		thunfisch.addActionListener(buttonListener);
		salami.addActionListener(buttonListener);
		
		margherita.setBounds(255, 75, 100, 20);
		thunfisch.setBounds(350,75,100,20);
		salami.setBounds(445, 75, 100, 20);
		kunde.add(margherita);
		kunde.add(thunfisch);
		kunde.add(salami);
		
		
	}
	//ADDET AUCH DEN TOPPING BUTTON
	public void addBestellButton(JFrame kunde) {
		JToggleButton bestellButton = new JToggleButton("Bestellen");
		bestellButton.setToolTipText("Falls Sie bestellen moechten, bitte vorher Button bestaetigen");
		bestellButton.setBounds(500, 20, 100, 50);
		bestellButton.setForeground(Color.black);
		bestellButton.setBackground(Color.yellow);
		kunde.add(bestellButton);
		
	}
	
	public JToggleButton addToppingButton() {
		JToggleButton toppingButton = new JToggleButton("Toppings");
		toppingButton.setBounds(500, 160, 100, 50);
		toppingButton.setBackground(Color.red);
		return toppingButton;
	}
	
	public void addTextFieldKunde(JFrame kunde) {
		JLabel Adresse = new JLabel("Adresse:");
		JLabel Telefonnummer = new JLabel("Telefon:");
		JLabel Name = new JLabel("Name:");
		Name.setBounds(240,475,100,70);
		Adresse.setBounds(240,500,100,70);
		Telefonnummer.setBounds(240,525,100,70);
		//TODO Textfield listener einbauen
		adresse = new JTextField();
		telefonnummer = new JTextField();
		name = new JTextField();
		name.setBounds(300, 500, 105, 20);
		adresse.setBounds(300, 525, 105, 20);
		telefonnummer.setBounds(300, 550, 105, 20);
		kunde.add(adresse);
		kunde.add(name);
		kunde.add(telefonnummer);
		kunde.add(Adresse);
		kunde.add(Name);
		kunde.add(Telefonnummer);
	}


	public void creatHalfHalf(){
		if(half == false){
		halfHalf = new JLabel("Zusatzoption: Belegung der anderen Healfte");
		halfHalf.setBounds(180,85,300,100);
		half = true;
		kunde.add(halfHalf);
		JToggleButton loeschen = new JToggleButton("Loeschen");
		loeschen.setBounds(130, 150, 100, 50);
		loeschen.setBackground(Color.yellow);
		loeschen.addActionListener(buttonListener);
		bGHalf = new ButtonGroup();
		ma = new JRadioButton("Margherita");
		th = new JRadioButton("Thunfisch");
		sa  = new JRadioButton("Samali") ;
//		ma.setActionCommand("ma");
//		th.setActionCommand("th");
//		sa.setActionCommand("sa");
//		
		
		
		bGHalf.add(ma);
		bGHalf.add(th);
		bGHalf.add(sa);

		ma.setBackground(Color.red);
		th.setBackground(Color.red);
		sa.setBackground(Color.red);
		//theoretisch noch margherita.setActionCommant("LOL") ---> ermöglicht abfrage bei BListener auf LOL
		ma.addActionListener(buttonListener);
		th.addActionListener(buttonListener);
		sa.addActionListener(buttonListener);
		
		ma.setBounds(255, 140, 100, 20);
		th.setBounds(350,140,100,20);
		sa.setBounds(445, 140, 100, 20);
		kunde.add(ma);
		kunde.add(th);
		kunde.add(sa);
		kunde.add(loeschen);
		
		
		
		
		
		
		kunde.repaint();
		}
		else{
			
		}
		
	}
	
	public void deleteHalfHalf(){
		if(half == true) {
			kunde.remove(halfHalf);
			kunde.remove(ma);
			kunde.remove(sa);
			kunde.remove(th);
		// 	kunde.remove(loe);
			half = false;
			kunde.repaint();
		}
		else{
			
		}
	}
	
	public void deleteAuswahl(){
		bGHalf.clearSelection();
	}
	
	public void extraToppings(){
		JToggleButton extra = new JToggleButton("Extra Toppings");
		extra.addActionListener(buttonListener);
		extra.setBounds(100, 450-80, 120, 30);
		JToggleButton deleteExtra = new JToggleButton("Loeschen T");
		deleteExtra.addActionListener(buttonListener);
		deleteExtra.setBounds(100, 410-80, 120, 30);
		 anzahl = new JLabel("0");
		anzahl.setBounds(100,490-80,120,30);
		kunde.add(extra);
		kunde.add(deleteExtra);
		kunde.add(anzahl);
		
	}
	
	public void addAbholButton(){
		abholen = new JToggleButton("Bestellung abholen?");
		abholen.setBounds(60,520, 150, 30);
		abholen.setBackground(Color.yellow);
		abholen.addActionListener(buttonListener);
		abholen.setToolTipText("Falls Bestellung abholen, bitte Button bestaetigen");
		kunde.add(abholen);
	}
	public void erhoeheToppings(){
		tAnzahl ++;
		anzahl.setText(Integer.toString(tAnzahl));
	}
	public void loescheToppings() {
		anzahl.setText("0");
		tAnzahl = 0;
	}
	public String getStringAdresse(){
		
		return adresse.getText();
	}
	
	public String getStringName(){
		
		return name.getText();
	}
	public String getStringTelefon(){
	
	return telefonnummer.getText();
	}
}
