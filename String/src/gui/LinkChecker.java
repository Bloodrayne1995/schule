package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;



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
			
			HttpClient x = new HttpClient();
			x.getHttpConnectionManager().getParams().setConnectionTimeout(30000);
			
			x.getHostConfiguration().setProxy("10.0.0.1", 8080);
						
			HttpMethod m = new GetMethod(link);
			
			int result = x.executeMethod(m);
			
			raiseEvents(String.valueOf(result));
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
