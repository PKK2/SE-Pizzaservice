import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class BListener implements ActionListener, ChangeListener {
	Buttons buttons;
	JRadioButton kl, mi,gr;
	JFrame kunde;
	public BListener(Buttons buttons,JFrame kunde) {
		this.buttons = buttons; 
		this.kunde = kunde;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Mittel")){
			buttons.creatHalfHalf();
			buttons.addSlider(3);
			
			
		}
		else if( e.getActionCommand().equals("Gross")){
			buttons.addSlider(5);
			buttons.creatHalfHalf();
		}
		else if(e.getActionCommand().equals("Klein")){
			buttons.addSlider(2);
			buttons.deleteHalfHalf();
		}
		else {
			
		}
		
		
		if(e.getActionCommand().equals("Loeschen")){
			buttons.deleteAuswahl();
		}
		
		if(e.getActionCommand().equals("Extra Toppings")){
			buttons.erhoeheToppings();
			kunde.repaint();
		}
		else if(e.getActionCommand().equals("Loeschen T")){
			buttons.loescheToppings();
			kunde.repaint();
		}
		
	}
	@Override
	public void stateChanged(ChangeEvent a) {
		//TODO CHeck Pizzasize und Topping	
		JSlider source = (JSlider)a.getSource();
			if(source.getValue() == 0){
				
			}
	}
	
	public void setButtons(JRadioButton kl, JRadioButton mi, JRadioButton gr){
		
	}

}
