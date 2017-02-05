import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class KochButtons implements ActionListener {
	private JFrame koch;
	private static JComboBox <Bestellung>pizzen; // JComboBox <BestellProdukt>pizzen;
	private Bestellung help;
	private JButton backend, fertig;
	private JLabel ueberschrift, Preis;
	final String BACKEND = "backend";
	final String FERTIG  =  "fertig";
	
	public KochButtons(JFrame koch){
		this.koch = koch; 
	}
	
	public KochButtons() {
		
	}
	
	public void makeFrame(){
		ueberschrift = new JLabel("Koch");
		ueberschrift.setFont(new Font(null,Font.BOLD,30));
		backend = new JButton(BACKEND);
		fertig = new JButton(FERTIG);
		backend.setBounds(350, 250, 100, 50);
		fertig.setBounds(450, 250, 100, 50);
		ueberschrift.setBounds(250, 0, 200, 60);
		pizzen = new JComboBox<Bestellung>();
		pizzen.setBounds(100, 250, 250, 50);
		Preis = new JLabel("Preis: ");
		Preis.setFont(new Font("",Font.BOLD,20));
		Preis.setBounds(370, 350, 200, 20);
		
		koch.add(Preis);
		koch.add(pizzen);
		koch.add(backend);
		koch.add(fertig);
		koch.add(ueberschrift);
		
		fertig.addActionListener(this);
		backend.addActionListener(this);
		pizzen.addActionListener(this);
		
		
	}
		
	
	
	public static void addBestellung(Bestellung Pizza) {
		pizzen.addItem(Pizza);
	}
	
	public void deleteBestellung() {
		
		if(getSelectedItem() != null)
		{
			 pizzen.removeItemAt(pizzen.getSelectedIndex());
			 Preis.setText("Preis: ");
			 koch.repaint();
		}
		else{
				
			}
	}
	

	public void statusBackend(){
		
		if(getSelectedItem() != null){
			getSelectedItem().setBestellstatus(Bestellung.Bestellstatus.BACKEND);
	
			koch.repaint();
		}
		else{
			
		} 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JComboBox){
			JComboBox cb = (JComboBox)e.getSource();
			Bestellung haha =(Bestellung)cb.getSelectedItem();
			 setSelectedItem(haha);
			
			 if(getSelectedItem() != null){
			 double d = haha.getBestellList().get(0).calcPreis();
			preis(d);
			}
			else{
				
			}
		}
		else{
			if(e.getActionCommand().equals("fertig")){
				deleteBestellung();
					}
			else if(e.getActionCommand().equals("backend")){
				statusBackend();
			}
			
		}
	
		
		
}
	
	
	public void preis(double d) {
		Preis.setText("Preis: " + Double.toString(d));
		}
	public void setSelectedItem(Bestellung help){
		this.help=help;
		
		
	}
	public Bestellung getSelectedItem(){
		
		return help;
	}
	
	
	
}