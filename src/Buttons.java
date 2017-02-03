import javax.swing.*;
import java.awt.*;




public class Buttons   {
	private JLabel halfHalf, anzahl;
	private int tAnzahl= 0;
	private JPanel button;
	private BListener buttonListener;
	private JFrame kunde;
	private Boolean half = false, extraToppings = false, slider=false;
	private JRadioButton  ma, sa ,th, klein, mittel,gross;
	private ButtonGroup bGHalf, gp;
	private JRadioButton margherita, thunfisch, salami;
	private JTextField adresse, telefonnummer, name;
	private JToggleButton abholen, bestaetigen,bestellButton, deleteExtra, extra;
	
	/*
	 * Die Klasse heisst zwar Buttons, soll aber dient den Aufbau und hilft bei der Logik der Pizzabestellung
	 * 
	 */
	
	public Buttons (JFrame kunde){
		this.kunde = kunde;
		buttonListener = new BListener(this,kunde);
//		button = new JPanel();
//		button.setLayout(null);
		JLabel toppLabel = new JLabel("Topping Anzahl:");
		toppLabel.setBounds(100,200,100,100);
		kunde.add(toppLabel);
		
	}
	
//	public void addSlider(int i) {
//		//toppings = new JSlider(0,5);
//		if(i == 2){
//			toppings = new JSlider(0,2);
//		}
//		else if( i == 3){
//			toppings = new JSlider(0,3);
//		}
//		else{
//			toppings = new JSlider(0,5);
//		}
//		
//		toppings.setBounds(250, 235, 140, 50);
//		toppings.setMajorTickSpacing(1);
//		toppings.setMinorTickSpacing(1);
//		toppings.setPaintLabels(true);
//		toppings.setFont(new Font(null,Font.BOLD,10));
//		toppings.setBackground(Color.red);
//		toppings.addChangeListener(buttonListener);
//		toppings.setValue(0);
//		
//		kunde.add(toppings);
//		
//		
//		
//		
//	}
	public void pizzaSize(){
		
		gp = new ButtonGroup();
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
	
	public int isSelectedSize(){
		if(klein.isSelected()){
			return 1;
		}
		else if(mittel.isSelected()){
			return 2;
		}
		else if(gross.isSelected()){
			return 3;
		}
		else{
			
		return 0;
		
		}
	}
	public void pizzaGeschmack(){
		
		ButtonGroup gp = new ButtonGroup();
		margherita = new JRadioButton("Margherita");
		thunfisch = new JRadioButton("Thunfisch");
		salami  = new JRadioButton("Salami") ;
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
	
	public int isSelectecGeschmack(){
		if(margherita.isSelected()){
			return 1;
		}
		else if (thunfisch.isSelected()){
			return 2;
		}
		else if(salami.isSelected()){
			return 3;
		}
		else{
			return 0;
		}
	
	}
	//ADDET AUCH DEN TOPPING BUTTON
	public void addBestellButton() {
		 bestellButton = new JToggleButton("Bestellen");
		bestellButton.setToolTipText("Falls Sie bestellen moechten, bitte vorher Button bestaetigen");
		bestellButton.setBounds(500, 20, 100, 50);
		bestellButton.setForeground(Color.black);
		bestellButton.setBackground(Color.yellow);
		kunde.add(bestellButton);
		
	}
	
	public boolean bestellButtonisSelected() {
		if(bestellButton.isSelected() == true){
			return true;
			
		}
		else{
			return false;
		}
	}
	
	public JToggleButton addToppingButton() {
		JToggleButton toppingButton = new JToggleButton("Toppings");
		toppingButton.setBounds(500, 160, 100, 50);
		toppingButton.setBackground(Color.red);
		return toppingButton;
	}
	
	public void addTextFieldKunde() {
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
		sa  = new JRadioButton("Salami") ;
		
		
		
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
		extra = new JToggleButton("Toppings");
		extra.setToolTipText("Klein 2, Mittel 3 und Gross 5 Toppings umsonst, danach kostet jedes Topping extra");
		extra.addActionListener(buttonListener);
		extra.setBounds(100, 450-80, 120, 30);
		deleteExtra = new JToggleButton("Loeschen T");
		deleteExtra.addActionListener(buttonListener);
		deleteExtra.setBounds(100, 410-80, 120, 30);
		 anzahl = new JLabel("0");
		anzahl.setBounds(100,490-80,120,30);
		kunde.add(extra);
		kunde.add(deleteExtra);
		kunde.add(anzahl);
		extraToppings = true;
		
	}
	
	public boolean getExtrastate(){
		return extraToppings;
	}
	public void deleteExtra(){
		kunde.remove(extra);
		kunde.remove(deleteExtra);
		kunde.remove(anzahl);
		kunde.repaint();
		extraToppings = false;
	}
	
	
	public void addBestellungBeastigenButton(){
		bestaetigen = new JToggleButton("Bestellung bestaetigen");
		bestaetigen.setBounds(450,500,200,30);
		bestaetigen.setBackground(Color.yellow);
		bestaetigen.addActionListener(buttonListener);
		bestaetigen.setToolTipText("Bestellung bitte bestaetigen");
		kunde.add(bestaetigen);
		
	}
	public boolean beastigenButtonIsSelected(){
		if(bestaetigen.isSelected()){
			return true;
		}
		else{
			return false;
		}
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
	
	public int getExtraToppingAnzahl(){
		return tAnzahl;
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
