package farben;

import java.awt.Color;
import java.awt.Component;
import java.util.*;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

public class FarbenArray extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Farbe> data = new ArrayList<Farbe>();
	private JTable tabelle = null;
	
	
	public FarbenArray(){
		addFarbe(Color.BLACK,"Schwarz");
		addFarbe(Color.WHITE,"Weiß");
		addFarbe(Color.RED,"Rot");
		addFarbe(Color.GREEN,"Grün");
		addFarbe(Color.BLUE,"Blau");
		addFarbe(Color.YELLOW,"Gelb");
		addFarbe(Color.CYAN,"Cyan");
		this.createPanel();
	}
	
	public Farbe getFarbe(int index){
		if(index < 0){
			index = 0;
		}
		if(index > getAnzahl()){
			index = getAnzahl();
		}
		return data.get(index);
	}
	
	public void addFarbe(Farbe x){
		data.add(x);
	}
	
	public void addFarbe(Color f, String name){
		Farbe x = new Farbe();
		x.setFarbe(f);
		x.setName(name);
		data.add(x);
	}
	
	public void removeFarbe(int index){
		data.remove(index);
	}
	
	
	public int getAnzahl(){
		return data.size();
	}
	
	
	//PANEL
	
	private void createPanel(){
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		genTable();
		add(tabelle);
	}
	
	private void genTable(){
		tabelle = new JTable(getAnzahl(),1);
		for(int i=0; i < getAnzahl(); i++){
			tabelle.setValueAt(data.get(i).getName(),i,0);
			//tabelle.setDefaultRenderer(tabelle.getColumn(1).getClass(), new MeinCellRenderer());
		}
	}
	
	
	public class MeinCellRenderer implements TableCellRenderer{

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
