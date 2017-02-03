import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BListener implements ActionListener, ChangeListener {
	
	int StateSlicer = 0;
	Buttons buttons;
	JRadioButton kl, mi,gr;
	JFrame kunde;
	
	public BListener(Buttons buttons,JFrame kunde) {
		this.buttons = buttons; 
		this.kunde = kunde;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		/**Diese IF-Verzweigung dient der Groessenauswahl
		*fuegt ausserdem auch den richtigen schieberegel entsprechend
		*der ausgeweahlten groesse hinzu.
		*
		*
		*/
		if(e.getActionCommand().equals("Mittel")){
			buttons.creatHalfHalf();
//			buttons.addSlider(3);
		}
		else if( e.getActionCommand().equals("Gross")){
			buttons.creatHalfHalf();
//			buttons.addSlider(5);
			
			
		}
		else if(e.getActionCommand().equals("Klein")){
			
			buttons.deleteHalfHalf();
//			buttons.addSlider(2);
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
		//	System.out.println(buttons.getStringName());
		}
		
		
		//Falls Bestellung abholen Button gedrueckt wird
		if(e.getActionCommand().equals("Bestellung abholen?")){
		//	System.out.println("nmm");
		}
		
		
		
		
		
		
		/*
		 * Hier beginnt die Logik der Bestellung 
		 */
		
		if(e.getActionCommand().equals("Bestellung bestaetigen")){
			if(buttons.bestellButtonisSelected()==true){
				if(buttons.isSelectecGeschmack() !=0 && buttons.isSelectedSize() !=0){
					
				
				}
				else{
					warningButtons();
					
				}
			}
			else{ 
				warningBestellen();
			}
		}
		
		
		
	}
	@Override
	//Listener fuer den Slicer 
	public void stateChanged(ChangeEvent a) {
		//TODO CHeck Pizzasize und Topping	
//		JSlider source = (JSlider)a.getSource();
//			if(source.getValue() == 0)
//				 setCurrentState(source.getValue());
				 
//				 if(buttons.isSelectedSize()!= 0){
//						if(buttons.isSelectecGeschmack() == 1){
//							if(getCurrentState() == 2){
//								buttons.extraToppings();
//								System.out.println("Wasgehtab");
//								kunde.repaint();
//							}
//							else {
//								if(buttons.getExtrastate() == true){
//								buttons.deleteExtra();
//								kunde.repaint();}
//								else{
//									
//								}
//							}
//						}
//						else if(buttons.isSelectecGeschmack() == 2){
//							if(getCurrentState() == 3){
//								buttons.extraToppings();
//								kunde.repaint();
//							}
//							else {
//								if(buttons.getExtrastate() == true){
//								buttons.deleteExtra();
//								kunde.repaint();}
//								else{
//									
//								}
//							}
//							
//						}
//						else if(buttons.isSelectecGeschmack() == 3){
//							if(getCurrentState() == 5){
//								buttons.extraToppings();
//								kunde.repaint();
//							}
//							else {
//								if(buttons.getExtrastate() == true){
//								buttons.deleteExtra();
//								kunde.repaint();}
//								else{
//									
//								}
//							}
//						}
//						
//					}
//					else{
//						System.out.println("sdds"); 
						}
					
				 
//	}
//	public void setCurrentState(int i){
//		StateSlicer = i;
//	}
//	
//	public int getCurrentState(){
//		
//		return StateSlicer;
//	}
	public void setButtons(JRadioButton kl, JRadioButton mi, JRadioButton gr){
		
	}
	
	private void warningBestellen(){
		JOptionPane.showMessageDialog(kunde, "Der Bestell-Knopf muss bestaetigt sein");
	}
	
	private void warningButtons(){
		JOptionPane.showMessageDialog(kunde, "Geschmack, oder Groesse wurde nicht angegeben");
	}
	
	

}
