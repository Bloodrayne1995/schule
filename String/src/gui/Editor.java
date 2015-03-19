package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

import datei.HTMLDatei;
import datei.StringFileIO;

public class Editor extends JFrame {

	private StringFileIO  datei = new StringFileIO();
	private JTextPane txtEditor = null;
	private JRadioButton rdbNormal = null;
	private JRadioButton rdbRegex = null;
	private String suche;
	private boolean sucheOn = false;
	private boolean loaded = false;
	
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
		setTextFeld();
		this.add(getScrollPane(),BorderLayout.CENTER);
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
	
	private void setTextFeld(){
		txtEditor = new JTextPane();
	}
	
	private JScrollPane getScrollPane(){
		JScrollPane x = new JScrollPane(txtEditor);
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
		x.add(getControlItem("Suche", getTextField("txtSuche",50)));
		x.add(getSuchPanel());
		return x;
	}
	
	private JPanel getControlItem(String label, JComponent elem){
		JPanel x = new JPanel(new FlowLayout());
		x.add(new JLabel(label));
		x.add(elem);
		return x;
	}
	
	private JTextField getTextField(String name, int laenge){
		JTextField x = new JTextField();
		x.setName(name);
		x.setColumns(laenge);
		x.addActionListener(new ChangeTextField());
		return x;
	}

	private JPanel getSuchPanel(){
		JPanel x = new JPanel();
		x.setLayout(new FlowLayout());
		rdbNormal = new JRadioButton("Normal");
		rdbNormal.setSelected(true);
		rdbRegex = new JRadioButton("Regulärer Ausdruck");
		ButtonGroup d = getRadioGroup();
		
		JPanel a = new JPanel();
		a.setLayout(new BoxLayout(a, BoxLayout.Y_AXIS));
		a.add(rdbNormal);
		a.add(rdbRegex);
		
		x.add(a);
		x.add(getControlItem("", getButton("cmdStartSuche", "Suche starten", "startSuche")));
		return x;
	}
	
	private ButtonGroup getRadioGroup(){
		ButtonGroup d = new ButtonGroup();
		d.add(rdbNormal);
		d.add(rdbRegex);
		return d;
	}
	
	private JButton getButton(String name, String text, String actionC){
		JButton d = new JButton(text);
		d.setName(name);
		d.setActionCommand(actionC);
		d.addActionListener(new WennButtonGedrueckt());
		return d;
	}
	
	public void openFile(){
		JFileChooser x = new JFileChooser();
		x.showOpenDialog(this);
		x.setMultiSelectionEnabled(false);
		datei.setDateiName(x.getSelectedFile().getAbsolutePath());
		if(datei.isValidFile()){
			datei.setAc(new WennDateiGeladen());
			new Thread(datei).start();
		}
	}
	
	public void closeFrame(){
		System.exit(0);
	}
	
	public void zeigeDatei(){
		if(!loaded){
			txtEditor.setText(datei.getTextAsString());
			loaded = true;
			txtEditor.setCaretPosition(50);
		}
	}

	
	public class ChangeTextField implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			suche = ((JTextField) e.getSource()).getText();
		}

		
	}
		
	public class MenuListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch(e.getActionCommand()){
			case "open":
				loaded = false;
				openFile();
				break;
			case "close":
				closeFrame();
				break;
			}
		}
	}
		
	public class WennDateiGeladen implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			zeigeDatei();
		}
		
	}

	public class WennButtonGedrueckt implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton d = (JButton) e.getSource();
			switch(d.getActionCommand()){
			default:
				System.out.println("Test");
			}
		}
		
	}
	
	


}
