
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// import BestellProdukt.Topping;



public class KundeListener implements ActionListener, ChangeListener {
	
	private List<BestellProdukt.Topping> toppingList = new ArrayList<BestellProdukt.Topping>();
	private Buttons buttons;
	private JFrame kunde;
	private final int ANZAHL = 1;
	private int produktId, andereHealfteId, groesse;
	private IDataFactory datafactory;
	private BestellProdukt pizza;
	
	
	public KundeListener(IDataFactory datafactory, Buttons buttons,JFrame kunde) {
		this.buttons = buttons; 
		this.kunde = kunde;
		this.datafactory = datafactory;
	
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		

		if(e.getActionCommand().equals("Mittel")){
			buttons.creatHalfHalf();
		}
		else if( e.getActionCommand().equals("Gross")){
			buttons.creatHalfHalf();
		}
		else if(e.getActionCommand().equals("Klein")){
			buttons.deleteHalfHalf();
		}
		else {
			
		}
		
		
		//Diese IF-Verzweigung dient den extra toppings:
		if(e.getActionCommand().equals("Loeschen")){
			buttons.deleteAuswahl();
		}
		if(e.getActionCommand().equals("Toppings")){
			buttons.erhoeheToppings();
			kunde.repaint();
		}
		else if(e.getActionCommand().equals("Loeschen T")){
			buttons.loescheToppings();
			kunde.repaint();
		}
		
		
		/*
		 * Hier beginnt die Logik der Bestellung 
		 */
		
		
			if(e.getActionCommand().equals("Bestellung bestaetigen")){
				
				mehrereBestellung();
				
				
			}
		
		
	}
	@Override
	//Listener fuer den Slicer 
	public void stateChanged(ChangeEvent a) {

	}	

	public void mehrereBestellung(){
		//Bestell Button muss besteatigt sein
		
			//Wenn weder Sorte noch Groesse gewaehlt wurde
			if(buttons.isSelectecGeschmack() !=0 && buttons.isSelectedSize() !=0){
				produktId = buttons.isSelectecGeschmack();
				groesse = buttons.isSelectecGeschmack();
				andereHealfteId = buttons.isSelectedHalf();
				addToppings(buttons.getExtraToppingAnzahl());
//				System.out.println(buttons.getExtraToppingAnzahl());
//				System.out.println(toppingList.size());
				if(andereHealfteId != 0 && andereHealfteId != produktId){
					addPizza(new BestellProdukt(datafactory, produktId,andereHealfteId, ANZAHL, pizzaGroesse(groesse), getToppings() ));
					bestellVorgang();
				}
				//Nicht vergessen pizza list und topping list nach einer Bestellung zu loeschen und neu zu machen
				else{
					
					addPizza(new BestellProdukt(datafactory, produktId, ANZAHL, pizzaGroesse(groesse), getToppings() ));
					bestellVorgang();
				}
			}
			else{
				warningButtons();
				
			}
		
	
	}
	
	private void bestellVorgang(){
		Date date = new Date();
		Bestellung order = new Bestellung(datafactory,buttons.bestellungAbholen(), buttons.getStringAdresse(), date, pizza);
		buttons.setEverythingNotSelected();
		KochButtons.addBestellung(order);
		toppingList = new ArrayList<BestellProdukt.Topping>();
		order.addBestellungToDB();
		
	}
	
	private void addToppings(int n){
		for(int i = 0; i < n; i++){
			toppingList.add(BestellProdukt.Topping.KAESE);
		}
		
		
	}

	private List<BestellProdukt.Topping> getToppings(){
		return toppingList;
	}
	
	private BestellProdukt.Groesse pizzaGroesse (int n){
		if(n == 1){
			return BestellProdukt.Groesse.S;
		}
		else if(n == 2){
			return BestellProdukt.Groesse.L;
		}
		else if(n == 3){
			return BestellProdukt.Groesse.XL;
		}
		else{
			return null;
		}
	}
	
	private void addPizza(BestellProdukt pizza){
		this.pizza = pizza;
	}


	private void warningBestellen(){
		JOptionPane.showMessageDialog(kunde, "Der Bestell-Knopf muss bestaetigt sein");
	}
	
	private void warningButtons(){
		JOptionPane.showMessageDialog(kunde, "Geschmack, oder Groesse wurde nicht angegeben");
	}
	
	
	

}
