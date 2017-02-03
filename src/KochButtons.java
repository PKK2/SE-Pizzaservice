import java.awt.*;
import javax.swing.*;


public class KochButtons {
	JFrame koch;
	JComboBox <String>pizzen;
	Bestellung bestellung;
	final String BACKEND = "backend";
	final String FERTIG  =  "fertig";
	public KochButtons(JFrame koch){
		this.koch = koch; 
		
		bestellung = new Bestellung();
		
	}
	
	public void makeFrame(){
		
		
		pizzen = new JComboBox();
		pizzen.addItem("wasgehtab");
		pizzen.addItem("wasgehtab");
		pizzen.setBounds(100, 250, 250, 50);
		koch.add(pizzen);
		
	}
	
	public void addBestellung(Bestellung Bestellung) {
		
		
			
		
	}
	
	public void deleteBestellung() {
		
	}
	
	public void setStatus() {
		
	}
	
	public void getStatus() {
		
	}
	
}