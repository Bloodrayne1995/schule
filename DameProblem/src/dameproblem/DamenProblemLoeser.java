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
		if(spalte > laenge - 1){
			return true;
		}else{
			for(int i=0; i < laenge - 1;i++){
				if(pruefeDame(spalte, i)){
					setzeDatenImFeld(spalte, i);
					return setzeDame(spalte + 1);
				}
			}
			return false;
		}
	}
	
	private boolean pruefeDame(int spalte, int zeile){
//		return true;
		//1-Dimensionales Feld in ein 2-Dimensionales Feld umsetzen
		boolean arr[][] = new boolean[laenge][laenge];
		for(int i = 0; i < laenge; i++){
			for(int j = 0; j < laenge;j++){
				arr[j][i] = false;
			}
		}
		
		for(int i = 0; i < laenge; i++){
			arr[i][feld[i]] = true;
		}
		
		//Prüfen
		//Waagerecht
		
		boolean ergebnis = true;
		for(int i = 0; i < laenge; i++){
			if(arr[i][zeile] == true){
				ergebnis = false;
			}
		}
		if(ergebnis == false){
			return ergebnis;
		}
		//Diagonal
		
		for(int i = 0; i < laenge; i++){
			
		}
		
	}
	
	
	private void setzeDatenImFeld(int s, int z){
		feld[s] = z;
	}
	
	
	
	
	
}
