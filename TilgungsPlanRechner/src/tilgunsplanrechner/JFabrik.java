package tilgunsplanrechner;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JFabrik {

	public static JLabel getLabel(String txt){
		return new JLabel(txt);
	}
	
	public static JTextField getTextBox(String name){
		JTextField d = new JTextField();
		d.setName(name);
		d.setText("");
		//d.setSize(250, d.getSize().height);
		d.setPreferredSize(new Dimension(250, 20));
		//d.setMinimumSize(new Dimension(250, d.getSize().height));
		return d;
	}
	
	public static JButton getButton(String name, String text, ActionListener d){
		JButton x = new JButton(text);
		x.setName(name);
		x.addActionListener(d);
		return x;
	}
	
	
}
