import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class KochButtons implements ActionListener {
	JFrame koch;
	JComboBox <TestKlasse>pizzen; // JComboBox <BestellProdukt>pizzen;
	Bestellung bestellung;
	TestKlasse help;
	JButton backend, fertig;
	JLabel ueberschrift;
	final String BACKEND = "backend";
	final String FERTIG  =  "fertig";
	public KochButtons(JFrame koch){
		this.koch = koch; 
		
		
		
	}
	
	public void makeFrame(){
		ueberschrift = new JLabel("Koch");
		ueberschrift.setFont(new Font(null,Font.BOLD,30));
		backend = new JButton(BACKEND);
		fertig = new JButton(FERTIG);
		backend.setBounds(350, 250, 100, 50);
		fertig.setBounds(450, 250, 100, 50);
		ueberschrift.setBounds(240, 10, 200, 60);
		pizzen = new JComboBox<TestKlasse>();
		pizzen.setBounds(100, 250, 250, 50);
		 // pizzen.addItem(new Bestellung());
		addBestellung(new TestKlasse("HaltdeineFresse"));
		
		
		koch.add(pizzen);
		koch.add(backend);
		koch.add(fertig);
		koch.add(ueberschrift);
		
		fertig.addActionListener(this);
		backend.addActionListener(this);
		pizzen.addActionListener(this);
		
		
//		pizzen.addItem(new TestKlasse("Käse"));
//		pizzen.addItem(new TestKlasse("Knecht"));
//		addBestellung(new TestKlasse("lol"));
	}
		
	
	
	public void addBestellung(TestKlasse Pizza) {
		pizzen.addItem(Pizza);
		koch.repaint();
	}
	
	public void deleteBestellung() {
		
	}
	
	public void setStatus() {
		//TODO
	}
	
	public void getStatus() {
		//TODO
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JComboBox){
			JComboBox cb = (JComboBox)e.getSource();
			TestKlasse haha =(TestKlasse)cb.getSelectedItem();
			setSelectedItem(haha);
			System.out.println(haha.getName().equals("lol"));
		}
		else{
			if(e.getActionCommand().equals("fertig")){
				//TODO entfernen
				addBestellung(new TestKlasse("halllooooo"));}
				else{
					System.out.println("lolllllll");
				}
			
		}
	
		
		
		
	
		
	}
	
	public void setSelectedItem(TestKlasse help){
		this.help=help;
		System.out.println("wasgehtab");
		
	}
	public TestKlasse getSelectedItem(){
		
		return help;
	}
	
	
	
}