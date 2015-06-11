package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import bmirechner.BMIRechner;



/**
 * Erstellt ein Frame für den BMI-Rechner
 * @author Marcel Serr (bsit13serr)
 * @version 1.0 / 22.07.2014
 */
public class MainFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BMIRechner d = new BMIRechner();
	private boolean isInputGenerated = false;
	private boolean isTitleGenerated = false;
	private boolean isSubmitGenerated = false;
	
	
	/**
	 * Hauptmethode
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame x = new MainFrame();
		x.createGUI();
	}
	
	/**
	 * Erstellt eine GUI, die Elemente werden dabei in verschiedene Threads erstellt
	 */
	public void createGUI(){
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("BMI-Rechner");
		this.setLayout(new BorderLayout());
		new Thread(new MyRenderer()).start();
		new Thread(new generateInput()).start() ;
		new Thread(new GenerateDesignLabels()).start();
		new Thread(new GenerateSubmitButton()).start();
		this.setVisible(true);
		d.initTabelle();
	}
	
	/**
	 * Wartet in einem separaten Thread bis alle Elemente erstellt wurden und zeichnet
	 * das Frame neu
	 * @author bsit13serr
	 *
	 */
	public class MyRenderer implements Runnable{

		@Override
		public void run() {
			while(!(isInputGenerated && isTitleGenerated && isSubmitGenerated)){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			revalidate();
		}
		
	}
	
	/**
	 * Handlet das Ereignis wenn ein RadioButton gedrückt wird.
	 * @author bsit13serr
	 *
	 */
	public class RadioInput implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JRadioButton x = (JRadioButton) arg0.getSource();
			if(x.getText() == "Männlich"){
				d.setGeschlecht(0);
			}else{
				d.setGeschlecht(1);
			}
		}
		
	}
	
	/**
	 * Handled das Ereignis, wenn ein Spinner-Field sein Wert ändert
	 * @author bsit13serr
	 *
	 */
	public class SpinnerChanged implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent arg0) {
			JSpinner x = (JSpinner) arg0.getSource();
			switch(x.getName()){
			case "gewicht":
				d.setKg((int)x.getValue());
				break;
			case "groesse":
				d.setGroesse((int) x.getValue());
				break;
			}
		}
		
	}
	
	/**
	 * Handled das Ereignis wenn ein Button gedrückt wird.
	 * @author bsit13serr
	 *
	 */
	public class ButtonClickListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			d.bmiBerechnen();
			JOptionPane.showMessageDialog(null, d.getBmiAusgeben());
		}
		
	}
	
	/**
	 * Genereiert die Titel-Schrift
	 * @author bsit13serr
	 *
	 */
	public class GenerateDesignLabels implements Runnable{
		@Override
		public void run() {
			JLabel x = new JLabel("BMI-RECHNER");
			x.setFont(new Font("Arial", Font.BOLD, 20));
			add(x,BorderLayout.NORTH);
			isTitleGenerated = true;
		}
	}
	
	/**
	 * Erstellt der Submit-Button
	 * @author bsit13serr
	 *
	 */
	public class GenerateSubmitButton implements Runnable{

		@Override
		public void run() {
			JButton x = new JButton("Submit");
			x.addActionListener(new ButtonClickListener());
			add(x,BorderLayout.SOUTH );
			isSubmitGenerated = true;
		}
		
	}
	
	/**
	 * Erstellt die Input-Felder
	 * @author bsit13serr
	 *
	 */
	public class generateInput implements Runnable{

		@Override
		public void run() {
			JPanel x = new JPanel(new GridLayout(3, 2));
			x.add(getNewLabel("Geschlecht: "));
			x.add(getOptionGeschlecht());
			x.add(getNewLabel("Gewicht in KG: "));
			x.add(getSpinnerField("gewicht"));
			x.add(getNewLabel("Größe in CM: "));
			x.add(getSpinnerField("groesse"));
			add(x,BorderLayout.CENTER);
			isInputGenerated = true;
		}
		

		public JLabel getNewLabel(String txt){
			return new JLabel(txt);
		}
		
		public JSpinner getSpinnerField(String name){
			JSpinner d = new JSpinner();
			d.setName(name);
			d.addChangeListener(new SpinnerChanged());
			return d;
		}
		
		public JPanel getOptionGeschlecht(){
			ButtonGroup bg = new ButtonGroup();
			JPanel x = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JRadioButton d = new JRadioButton("Männlich");
			d.addActionListener(new RadioInput());
			bg.add(d);
			x.add(d);
			d = new JRadioButton("Weiblich");
			d.addActionListener(new RadioInput());
			bg.add(d);
			x.add(d);
			return x;
		}
		
	}
}
