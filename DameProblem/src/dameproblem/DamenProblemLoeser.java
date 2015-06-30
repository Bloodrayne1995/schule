package dameproblem;

import java.util.Random;

public class DamenProblemLoeser {
	
	private int feld[] = null;
	private int laenge = 4;
	
	
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
		return false;
	}
	
	
	
	
	
	
	
}
