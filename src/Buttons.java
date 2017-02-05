import javax.swing.*;
import java.awt.*;




public class Buttons   {
	private JLabel halfHalf, anzahl;
	private int tAnzahl= 0;
	private KundeListener buttonListener;
	private JFrame kunde;
	private Boolean half = false, extraToppings = false;
	private JRadioButton  ma, sa ,th, klein, mittel,gross;
	private ButtonGroup bGHalf, gp, bp ;
	private JRadioButton margherita, thunfisch, salami;
	private JTextField adresse, telefonnummer, name;
	private JToggleButton abholen, bestellButton;
	private JButton extra, deleteExtra, bestaetigen, weitereBestellung;
	private IDataFactory datafactory;
	
	
	public Buttons (IDataFactory datafactory, JFrame kunde){
		this.kunde = kunde;
		this.datafactory = datafactory;
		buttonListener = new KundeListener(datafactory,this,kunde);
		JLabel toppLabel = new JLabel("Topping Anzahl:");
		toppLabel.setBounds(100,200,100,100);
		kunde.add(toppLabel);
		
	}
	

	public void pizzaSize(){
		
		gp = new ButtonGroup();
		klein = new JRadioButton("Klein");
		mittel = new JRadioButton("Mittel");
		gross  = new JRadioButton("Gross") ;
		gp.add(klein);
		gp.add(mittel);
		gp.add(gross);
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
		
		bp = new ButtonGroup();
		margherita = new JRadioButton("Margherita");
		thunfisch = new JRadioButton("Thunfisch");
		salami  = new JRadioButton("Salami") ;
		bp.add(margherita);
		bp.add(thunfisch);
		bp.add(salami);

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
	

	public boolean bestellungAbholen(){
		if(abholen.isSelected()){
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
	
	public void addWeitereBestellung () {
		weitereBestellung = new JButton("Weitere Bestellung hinzufuegen");
		weitereBestellung.setBounds(430, 450, 250, 20);
		weitereBestellung.setBackground(Color.yellow);
		weitereBestellung.addActionListener(buttonListener);
		kunde.add(weitereBestellung);
	}
	
	public void setAllNotSelected(){
		gp.clearSelection();
		if(bGHalf != null){
			bGHalf.clearSelection();	
		}
		
		bp.clearSelection();
	}

	public void setEverythingNotSelected(){
		setAllNotSelected();
		adresse.setText("");
		telefonnummer.setText("");
		name.setText("");
		abholen.setSelected(false);
//		bestellButton.setSelected(false);
		tAnzahl = 0;
		anzahl.setText("0");
		
	}
	public void creatHalfHalf(){
		if(half == false){
		halfHalf = new JLabel("Zusatzoption: Belegung der anderen Healfte");
		halfHalf.setBounds(180,85,300,100);
		half = true;
		kunde.add(halfHalf);
		JButton loeschen = new JButton("Loeschen");
		loeschen.setBounds(130, 150, 100, 50);
		loeschen.setBackground(Color.yellow);
		loeschen.addActionListener(buttonListener);
		bGHalf = new ButtonGroup();
		ma = new JRadioButton("Margherita");
		th = new JRadioButton("Thunfisch");
		sa  = new JRadioButton("Salami") ;
		ma.setActionCommand("ma");
		sa.setActionCommand("sa");
		th.setActionCommand("th");
		
		
		bGHalf.add(ma);
		bGHalf.add(th);
		bGHalf.add(sa);

		ma.setBackground(Color.red);
		th.setBackground(Color.red);
		sa.setBackground(Color.red);
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
	public int isSelectedHalf() {
		if(ma!=null && th!=null && sa != null){
			if(ma.isSelected() == true){
				return 1;
			}
			else if(th.isSelected() == true){
				return 2;
			}
			else if(sa.isSelected() == true){
				return 3;	
			}
			else{
				return 0;
			}
		
		}
		else{
			return 0;
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
		extra = new JButton("Toppings");
		extra.setToolTipText("Klein 2, Mittel 3 und Gross 5 Toppings umsonst, danach kostet jedes Topping extra");
		extra.addActionListener(buttonListener);
		extra.setBounds(100, 450-80, 120, 30);
		deleteExtra = new JButton("Loeschen T");
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
		bestaetigen = new JButton("Bestellung bestaetigen");
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
