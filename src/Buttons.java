import javax.swing.*;
import java.awt.*;


public class Buttons {
	JPanel button;
	JRadioButton rb[] = new JRadioButton[3];
	
	
	public Buttons (){

		button = new JPanel();
		button.setLayout(null);
		
	}
	
	public void pizzaSize(JPanel kundePanel){
		JLabel pizzaGroesse = new JLabel("Pizzagroesse");
		ButtonGroup gp = new ButtonGroup();
		JRadioButton klein = new JRadioButton("Klein");
		JRadioButton mittel = new JRadioButton("Mittel");
		JRadioButton gross  = new JRadioButton("Gross") ;
		gp.add(klein);
		gp.add(mittel);
		gp.add(gross);
		pizzaGroesse.setHorizontalAlignment(JLabel.CENTER);
		
		
		JPanel buttonPanel;
		
		kundePanel.add(buttonPanel = new JPanel(new FlowLayout()), BorderLayout.PAGE_END);
		buttonPanel.setBackground(new Color(23,23,32));
		kundePanel.add(pizzaGroesse, BorderLayout.CENTER);
		buttonPanel.add(klein);
		buttonPanel.add(mittel);
		buttonPanel.add(gross);
	//	kundePanel.add(new JLabel("Geschmack"), BorderLayout.PAGE_END);
	//	addBestellButton(buttonPanel);
	}
	
	public void pizzaGeschmack(JPanel panelKundeMitte){
		JPanel hilfe = new JPanel( new FlowLayout());
		panelKundeMitte.add(hilfe, BorderLayout.CENTER);
		
		ButtonGroup gp = new ButtonGroup();
		JRadioButton margherita = new JRadioButton("Margherita");
		JRadioButton thunfisch = new JRadioButton("Thunfisch");
		JRadioButton salami  = new JRadioButton("Samali") ;
		gp.add(margherita);
		gp.add(thunfisch);
		gp.add(salami);
		hilfe.add(margherita);
		hilfe.add(thunfisch);
		hilfe.add(salami);
		
		
		JLabel pizzaGeschmack = new JLabel("Pizzageschmack");
		pizzaGeschmack.setHorizontalAlignment(JLabel.CENTER);
		panelKundeMitte.add(pizzaGeschmack ,BorderLayout.PAGE_START);
		
		
	}
	//ADDET AUCH DEN TOPPING BUTTON
	public JToggleButton addBestellButton() {
		JToggleButton bestellButton = new JToggleButton("Bestellen");
		bestellButton.setBounds(500, 20, 100, 50);
		bestellButton.setBackground(Color.RED);
		return bestellButton;
		
	}
	
	public JToggleButton addToppingButton() {
		JToggleButton toppingButton = new JToggleButton("Toppings");
		toppingButton.setBounds(500, 160, 100, 50);
		toppingButton.setBackground(Color.red);
		return toppingButton;
	}
	
}
