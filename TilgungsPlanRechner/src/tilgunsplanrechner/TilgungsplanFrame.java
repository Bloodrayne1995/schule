package tilgunsplanrechner;

import java.awt.FlowLayout;
import java.awt.Rectangle;

import javax.swing.*;

public class TilgungsplanFrame extends JFrame {

	private static final long serialVersionUID = -4321394243996189471L;
	
	private JTextField txtKreditVolumen = null;
	private JTextField txtZinssatz = null;
	private JTextField txtRate = null;
	
	
	public static void main(String args[]){
		TilgungsplanFrame d = new TilgungsplanFrame();
		d.createGUI();
	}
	
	public void createGUI(){
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(640, 480);
		this.setMaximizedBounds(new Rectangle(640, 480));
		this.setTitle("Tilgungsplan-Rechner");
		this.add(getMainPanel());
		this.setVisible(true);
	}
	
	
	private JPanel getMainPanel(){
		JPanel d = new JPanel();
		d.setLayout(null);
		JPanel t = getTopPanel();
		t.setLocation(0, 0);
		d.add(t);
		return d;
	}
	
	private JPanel getTopPanel(){
		JPanel t = new JPanel();
		t.setLayout(new BoxLayout(t, BoxLayout.Y_AXIS ));
		t.setSize(640, 100);
		
		
		//KreditVolumen
		JLabel d = JFabrik.getLabel("Kreditvolumen in Euro: ");
		txtKreditVolumen = JFabrik.getTextBox("txtKreditVolumen");
		t.add(getFlowPanel(d, txtKreditVolumen));
		
		//Zinssatz
		d = JFabrik.getLabel("Zinssatz: ");
		txtZinssatz = JFabrik.getTextBox("txtZinsatz");
		t.add(getFlowPanel(d, txtZinssatz));
		
		//monatliche Rate
		d = JFabrik.getLabel("monatliche Rate: ");
		txtRate = JFabrik.getTextBox("txtRate");
		t.add(getFlowPanel(d, txtRate));
		return t;	
	}
	
	private JPanel getFlowPanel(JLabel d, JTextField x){
		JPanel a = new JPanel();
		a.setLayout(new FlowLayout(FlowLayout.LEFT ));
		a.setSize(640, 60);
		a.add(d);
		a.add(x);
		return a;
	}
	
	
	
	
	
	
	
	
	
}
