package dameproblem;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class DamenProblemLoeser {
	
	private int feld[] = null;
	private int laenge = 4;
	private ArrayList<ActionListener > arr = new ArrayList<ActionListener >();
	
	
	public DamenProblemLoeser(int l){
		laenge = l ;
	}
	
	public void belegeFeld(){
		feld = new int[laenge];
		for(int i = 0; i < laenge; i++){
			feld[i] = -1;
		}
		
	}
	
	public void belegeTestFeld(){
		belegeFeld();
		Random x = new Random();
		for(int i=0;i < laenge; i++){
			feld[i] = x.nextInt(laenge - 1);
		}
	}
	
	public boolean isInitialized(){
		return (feld != null);
	}
	
	public int getZeile(int spalte){
		if(isInitialized() && spalte < laenge){
			return feld[spalte];
		}else{
			return -1;
		}
	}
	
	public boolean setzeDame(int spalte){
		feld[spalte] = 0;
		while(feld[spalte] < feld.length){
			fireEvent();
			if(isDameInGefahr(spalte)){
				
			}else{
				if(spalte == feld.length - 1){
					return true;
				}else{
					if(setzeDame(spalte + 1)){
						
						return true;
					}
				}
			}
			feld[spalte]++;
		}
		return false;
	}
	
	private boolean isDameInGefahr(int n){
		for(int i = 0; i < n ; i++){
			if(feld[i] == feld[n]){
				return true;
			}
		}
		
		for(int i = n - 1 ; i >= 0; i--){
			if(feld[i] == (feld[n] - (n - i)) || feld[i] == feld[n] + (n - i)){
				return true;
			}
		}
		
		return false;
	}
	
	public void addActionListener(ActionListener x){
		arr.add(x);
	}
	
	
	public void fireEvent(){
		for(ActionListener x:arr){
			x.actionPerformed(null);
		}
	}

	/**
	 * @return the laenge
	 */
	public int getLaenge() {
		return laenge;
	}
	
	
	
	
	
}
