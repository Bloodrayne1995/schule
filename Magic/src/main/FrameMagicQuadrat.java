package main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FrameMagicQuadrat extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MagicQuadrat mq = new MagicQuadrat();
	private JTable table = null;
	private JPanel tblPanel = null;
	private JSpinner numKantenL = null;
	private  int kantenL = 3;
	
	public static void main(String[] args) {
		FrameMagicQuadrat x = new FrameMagicQuadrat();
		x.createGUI();
		
	}
	
	
	public void createGUI(){
		this.setLayout(new BorderLayout());
		this.setSize(700, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Magisches Quadrat");
		this.add(getControlP(),BorderLayout.EAST);
		generateTPanel();
		this.add(tblPanel,BorderLayout.CENTER);
		this.setVisible(true);
		
		
	}
	
	private JPanel getSpinnerEingabe(JSpinner spinFeld,String beschriftung){
		JPanel d = new JPanel(new FlowLayout(FlowLayout.LEFT));
		d.add(getLabel(beschriftung));
		d.add(spinFeld);
		return d;
	}
	
	private JLabel getLabel(String txt){
		return new JLabel(txt);
	}
	
	private JSpinner  getSpinner (int start,int stepSize){
		JSpinner d = new JSpinner();
		d.setValue(start);
		d.addChangeListener(new SpinnerStep(stepSize, start));
		return d;
	}
	
	private JPanel getControlP(){
		JPanel x = new JPanel();
		x.setLayout(new BoxLayout(x, BoxLayout.Y_AXIS));
		x.add(getLabel("Steuerung"));
		
		numKantenL = getSpinner(3, 2);
		x.add(getSpinnerEingabe(numKantenL, "Feld-Größe:"));
		return x;
	}
	
	private void generateTPanel(){
		tblPanel = new JPanel(new BorderLayout());
		generateTable();
		tblPanel.add(table,BorderLayout.CENTER);
	}
	
	public void updateTable(){
		System.out.println("[START] Generiere Tabelle mit " + kantenL);
		generateTPanel();
		repaint();
		System.out.println("[END] Generiere Tabelle mit " + kantenL);
	}
	
	public void generateTable(){
		try{
			mq.setKantenlaenge(kantenL);
			mq.erstelleQuadrat();
			table  = new JTable(kantenL, kantenL);
			for(int i = 0; i < kantenL; i++){
				for(int j = 0; j < kantenL; j++){
					table.setValueAt(mq.getZahl(j, i), i, j); 
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public class SpinnerStep implements ChangeListener{
		
		private int stepSize = 1;
		private int value = -1;
		private boolean doUpdate = true;
		
		public SpinnerStep(int stepSize, int value){
			this.stepSize = stepSize;
			this.value = value;
		}
		
		@Override
		public void stateChanged(ChangeEvent e) {
			if(doUpdate){
				JSpinner d = (JSpinner) e.getSource();
				if(value < (int) d.getValue()){
					doUpdate = false;
					d.setValue(value + stepSize);
				}else{
					doUpdate = false;
					d.setValue(value - stepSize);
				}
				value = (int) d.getValue();
				kantenL = value; 
				updateTable();
				doUpdate = true;
			}
		}
		
	}
	

}
