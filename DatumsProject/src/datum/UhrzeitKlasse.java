package datum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class UhrzeitKlasse {

	
	private Zeitklasse akt = new Zeitklasse();
	private Zeitklasse start = new Zeitklasse();
	private Zeitklasse stopp = new Zeitklasse();
	private ArrayList<ActionListener> actionHandler = new ArrayList<ActionListener>();
	
	
	/**
	 * @return the stunde
	 */
	public int getStunde() {
		return akt.getStunde();
	}
	
	/**
	 * @return the minute
	 */
	public int getMinute() {
		return akt.getMinute();
	}
	
	/**
	 * @return the sekunde
	 */
	public int getSekunde() {
		return akt.getSekunde();
	}
	
	public void addActionListener(ActionListener d){
		actionHandler.add(d);
	}
	
	public void setStartzeitAsSystemZeit(){
		start.setSystemTime();
	}
	
	public void setStartZeit(int std, int min, int sek){
		start.setSekunde(sek);
		start.setStunde(std);
		start.setMinute(min);
	}
	
	public void setStoppZeit(int std, int min, int sek){
		stopp.setSekunde(sek);
		stopp.setStunde(std);
		stopp.setMinute(min);
	}
	
	
	
	public void zeigeUhrzeit(){
		akt.setStunde(start.getStunde());
		akt.setSekunde(start.getSekunde());
		akt.setMinute(start.getMinute());
		akt.addActionListener(new Test());
		while(akt.tick()){
			System.out.println(akt);
			if(stopp.isSet()){
				if(akt.compareWithOtherTime(stopp)){
					break;
				}
			}
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("Stoppzeit wurde erreicht!");
	}
	
	
	private class Test implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!actionHandler.isEmpty()){
				ActionEvent d = new ActionEvent(this, 20, "tick");
				for(ActionListener a : actionHandler){
					a.actionPerformed(d);
				}
			}
		}
		
	}
	
	
}
