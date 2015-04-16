package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import datei.HTMLDatei;

public class LinkCheckerGUI extends JFrame {

	private HTMLDatei html = new HTMLDatei();
	private JTable tabelle = new JTable();
	private ArrayList<LinkChecker> checker =new ArrayList<LinkChecker>(); 

	public static void main(String[] args) {
		LinkCheckerGUI x = new LinkCheckerGUI();
		x.createGUI();
	}
	
	
	public void createGUI(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Link-Checker");
		setLayout(new BorderLayout());
		setSize(1280, 720);
		
		add(getControlPanel(),BorderLayout.NORTH);
		add(getMainPanel(), BorderLayout.CENTER);
	
		setVisible(true);
	}
	
	
	private JPanel getControlPanel(){
		JPanel x = new JPanel();
		x.setBackground(new Color(50, 50, 50));
		x.add(getFileChooser());
		return x;
	}
	
	private JButton getFileChooser(){
		JButton x = new JButton("Lade HTML-Datei");
		x.addActionListener(new WennLadenButtonPressed());
		return x;
		
	}
	
	private JPanel getMainPanel(){
		JPanel x = new JPanel(new BorderLayout());
		x.setBackground(Color.gray);
		tabelle = getTable();
		x.add(getScrollPane(tabelle),BorderLayout.CENTER);
		
		return x;
	}
	
	private void setDatei(){
		JFileChooser x = new JFileChooser();
		x.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return "HTML-Dateien (html,htm)";
			}
			
			@Override
			public boolean accept(File f) {
				if(f.getAbsolutePath().endsWith(".htm") || f.getAbsolutePath().endsWith(".html") || f.isDirectory()){
					return true;
				}else{
					return false;
				}
			}
		});
		x.setDialogTitle("HTML-Datei wählen");
		x.showOpenDialog(this);
		x.setMultiSelectionEnabled(false);
		tabelle = getTable();
		DefaultTableModel dm = (DefaultTableModel) tabelle.getModel();
		if(x.getSelectedFile() != null){
			checker.clear();
			html.setDateiName(x.getSelectedFile().getAbsolutePath());
			html.leseDatei();
			ArrayList<String> links = html.getHyperLinksInDocument();
			for(int i = 0;i < links.size();i++){
				LinkChecker d = new LinkChecker(links.get(i), i);
				d.addActionListener(new WennCheckCompleted());
				String txt[] = new String[2];
				txt[0] = links.get(i);
				txt[1] = "";
				dm.addRow(txt);
				checker.add(d);
			}
			tabelle = getTable(dm);
			repaint();
			for(LinkChecker c:checker){
				new Thread(c).start();
			}
		}
	}
	
	public JScrollPane getScrollPane(JComponent x){
		JScrollPane a = new JScrollPane(x);
		return a;
	}
	
	private JTable getTable(){
		JTable x =new JTable(0, 0);
		TableColumn a = new TableColumn();
		a.setHeaderValue("Link");
		x.addColumn(a);
		a = new TableColumn();
		a.setHeaderValue("status");
		x.addColumn(a);
		return x;
	}
	
	private JTable getTable(DefaultTableModel d){
		JTable x =new JTable(d);
		return x;
	}
	
	
	public class WennLadenButtonPressed implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			setDatei();
		}
		
	}
	
	private void setStatus(int rowId, int status){
		try{
			tabelle.setValueAt(status, rowId, 1);
			repaint();
		}catch(Exception e){
			
		}
	}
	
	public class WennCheckCompleted implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	


}
