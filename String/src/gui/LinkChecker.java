package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class LinkChecker implements Runnable {

	private String link = "";
	private int id = 0;
	private ArrayList<ActionListener> ac = new ArrayList<ActionListener>();
	
	/**
	 * 
	 * @param x
	 * @param id
	 */
	public LinkChecker(String x,int id) {
		link = x;
		this.id = id;
	}
	
	private void raiseEvents(String text){
		for(ActionListener d: ac){
			d.actionPerformed(new ActionEvent(this, id, text));
		}
	}
	
	public void addActionListener(ActionListener e){
		ac.add(e);
	}
	
	
	@Override
	public void run() {
		try{
			URL x = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) x.openConnection();
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connection.setRequestProperty("Content-Language", "en-US"); 
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
