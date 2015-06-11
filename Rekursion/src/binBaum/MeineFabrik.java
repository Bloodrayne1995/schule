package binBaum;

import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeListener;


public class MeineFabrik {

	public static JSlider getSlider(int min, int max, int def, String name){
		JSlider d = new JSlider(min, max, def);
		d.setName(name);
		d.setPaintLabels(true);
		d.setPaintTrack(true);
		return d;
	}
	
	
	public static JLabel getLabel(String txt){
		JLabel d = new JLabel(txt);
		return d;
	}
	
	
	public static JPanel getControl(String desc, String name, int max, int min, int def){
		JPanel d = new JPanel();
		d.setLayout(new BoxLayout(d, BoxLayout.Y_AXIS));
		d.add(getLabel(desc));
		d.add(getSlider(min, max, def,name));
		return d;
	}
	
	
	public static JPanel getControl(String desc, String name, int max, int min, int def,ChangeListener list){
		JPanel d = new JPanel();
		d.setLayout(new BoxLayout(d, BoxLayout.Y_AXIS));
		d.add(getLabel(desc));
		JSlider x = getSlider(min, max, def,name);
		x.addChangeListener(list);
		d.add(x);
		return d;
	}
	
	
	public static JButton getButton(String name, String txt, ActionListener a){
		JButton d = new JButton();
		d.setName(name);
		d.setText(txt);
		d.addActionListener(a);
		return d;
	}
	
	
	
}
