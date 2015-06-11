package portscanner;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;


public class Portscanner {

	private ArrayList<String> openports = new ArrayList<String>();
	
	
	private String adresse = "";
	
	
	public void test(String adresse, int start, int ende){
		for(int i = start; i < ende;i++){
			PortScannerAsync x = new PortScannerAsync();
			x.port = i;
			new Thread(x).start();
		}
	}
	
	private void out(String x){
		System.out.println(x);
	}
	
	
	
	public ArrayList<String> getOpenports() {
		return openports;
	}

	public void setOpenports(ArrayList<String> openports) {
		this.openports = openports;
	}



	public class PortScannerAsync implements Runnable{

		public int port = 1;
		
		
		@Override
		public void run() {
			try(Socket x = new Socket(adresse,port)){
				out("Port " + port + " ist offen");
			}catch(UnknownHostException e){
				out("Host wurde nicht gefunden!");
			}catch (IOException e) {
				out("Port " + port + " nicht offen");
			}catch (Exception e){
				out("Sonstiger Fehler");
				e.printStackTrace();
			}
		}
		
	}
}
