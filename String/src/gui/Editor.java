package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import datei.StringFileIO;

public class Editor extends JFrame {

	private StringFileIO datei = new StringFileIO();
	private JFormattedTextField txtEditor = null;
	private String search = "";
	
	public static void main(String[] args) {
		Editor x = new Editor();
		x.createGUI();
	}
	
	
	public void createGUI(){
		this.setSize(1280, 720);
		this.setTitle("Editor");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setJMenuBar(getMainMenu());
		this.add(getControlPanel(), BorderLayout.NORTH); 
		this.setVisible(true);
	}
	
	private JMenuBar getMainMenu(){
		JMenuBar x = new JMenuBar();
		JMenu d = new JMenu();
		d.setText("Datei");
		d.add(getItem("Öffnen", "open"));
		d.add(getItem("Schließen", "close"));
		x.add(d);
		return x;
	}
	
	private JMenuItem getItem(String name, String tag){
		JMenuItem x = new JMenuItem(name);
		x.setActionCommand(tag);
		x.addActionListener(new MenuListener());
		return x;
	}
	
	
	private JPanel getControlPanel(){
		JPanel x = new JPanel();
		x.setLayout(new BoxLayout(x, BoxLayout.Y_AXIS));
		x.add(getControlItem("Suche", getTextField("txtSuche")));
		return x;
	}
	
	private JPanel getControlItem(String label, JComponent elem){
		JPanel x = new JPanel(new FlowLayout());
		x.add(new JLabel(label));
		x.add(elem);
		return x;
	}
	
	private JTextField getTextField(String name){
		JTextField x = new JTextField();
		x.setName(name);
		return x;
	}
	
	public void openFile(){
		
	}
	
	public class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
		}
		
	}
}
