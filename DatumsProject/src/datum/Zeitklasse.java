package datum;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Zeitklasse{

	private int stunde = 0;
	private int minute = 0;
	private int sekunde = 0;
	private boolean gesetzt = false;
	private ArrayList<ActionListener> actionHandler = new ArrayList<ActionListener>();
	
	
	/**
	 * @return the stunde
	 */
	public int getStunde() {
		return stunde;
	}
	
	/**
	 * @param stunde the stunde to set
	 */
	public void setStunde(int stunde) {
		if(stunde >= 1 && stunde <= 23){
			this.stunde = stunde;
			gesetzt = true;
		}else{
			System.out.println("Stunde ist nicht im Wertebereich!");
		}
	}
	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}
	
	/**
	 * @param minute the minute to set
	 */
	public void setMinute(int minute) {
		if(minute >= 0 && minute <= 59){
			this.minute = minute;
			gesetzt = true;
		}else{
			System.out.println("Minute ist nicht im Wertebereich!");
		}
	}
	
	/**
	 * @return the sekunde
	 */
	public int getSekunde() {
		return sekunde;
	}
	
	/**
	 * @param sekunde the sekunde to set
	 */
	public void setSekunde(int sekunde) {
		if(sekunde >= 0 && sekunde <= 59){
			this.sekunde = sekunde;
			gesetzt = true;
		}else{
			System.out.println("Sekunde ist nicht im Wertebereich!");
		}
	}
	
	public void addActionListener(ActionListener d){
		actionHandler.add(d);
	}
	
	public boolean isSet(){
		return gesetzt;
	}
	
	/**
	 * Setzt die Zeit dieses Objekts auf die Systemzeit
	 */
	public void setSystemTime(){
		int sek, min, std;
		Calendar d = new GregorianCalendar();
		
		sek = d.get(Calendar.SECOND);
		min = d.get(Calendar.MINUTE);
		std = d.get(Calendar.HOUR_OF_DAY);
		
		this.setStunde(std);
		this.setMinute(min);
		this.setSekunde(sek);
	}
	
	/**
	 * Setzt die Zeit direkt
	 * @param std
	 * @param min
	 * @param sek
	 */
	public void setZeit(int std, int min, int sek){
		this.setStunde(std);
		this.setMinute(min);
		this.setSekunde(sek);
	}
	
	/**
	 * Prüft die Zeit mit einem anderen Zeitobjekt
	 * @param d
	 * @return
	 */
	public boolean compareWithOtherTime(Zeitklasse d){
		if(this.stunde == d.getStunde()){
			if(this.minute == d.getMinute()){
				if(this.sekunde == d.getSekunde()){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public boolean tick(){
		sekunde++;
		if(sekunde == 60){
			sekunde=0;
			minute++;
		}
		if(minute == 60){
			sekunde = 0;
			minute = 0;
			stunde++;
		}
		if(stunde == 24){
			sekunde = 0;
			minute = 0;
			stunde = 0;
//			raiseEvent();
//			return false;
		}
		raiseEvent();
		return true;
	}
	
	@Override
	public String toString(){
		return stunde + ":" + minute + ":" +  sekunde;
	}
	

	private void raiseEvent(){
		if(!actionHandler.isEmpty()){
			ActionEvent d = new ActionEvent(this, 20, "tick");
			for(int i = 0; i < actionHandler.size(); i++){
				actionHandler.get(i).actionPerformed(d);
			}
		}
	}
}
