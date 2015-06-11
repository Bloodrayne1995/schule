package main;

public class MagicQuadrat {

	private int quadrat[][] = null;
	private int kantenlaenge = -1;
	
	public void initFeld() throws Exception{
		if(kantenlaenge < 3){
			throw new Exception("Kanten-Länge muss größer oder gleich 3 sein");
		}else{
			quadrat = new int[kantenlaenge][kantenlaenge];
			for(int i = 0; i < kantenlaenge; i++){
				for(int j = 0; j < kantenlaenge;j++){
					quadrat[i][j] = -1;
				}
			}
		}
	}
	
	public int getKantenLaenge(){
		return kantenlaenge;
	}
	
	public void setKantenlaenge(int k) throws Exception{
		if(k < 3){
			throw new Exception("Kanten-Länge muss größer oder gleich 3 sein");
		}
		if(k % 2 == 0){
			throw new Exception("Kanten-Länge muss ungerade sein");
		}
		kantenlaenge = k;
		initFeld();
	}
	
	private void schreibeZahlInFeld(int x, int y, int z){
		quadrat[x][y] = z;
	}
	
	private boolean isZahlinZelle(int x, int y){
		return (quadrat [x][y] != -1) ;
	}
	
	private int checkX(int x){
		return (x > kantenlaenge - 1) ? 0 : x;
	}
	
	private int checkY(int y){
		return (y < 0) ? kantenlaenge - 1 : y;
	}
	
	public void erstelleQuadrat(){
		int zahl = 2;
		int x = kantenlaenge / 2;
		int y = 0;
		int oldX;
		int oldY;
		schreibeZahlInFeld(x, y, 1);
		while(zahl < Math.pow(kantenlaenge, 2) + 1){
			oldX = x;
			oldY = y;
			x = checkX(x + 1);
			y = checkY(y -1);
			if(isZahlinZelle(x, y)){
				x = oldX;
				y = oldY + 1;
			}
			schreibeZahlInFeld(x, y, zahl);
			zahl++;
		}
	}
	
	public int getZahl(int x, int y){
		return quadrat[x][y];
	}
	
	
	public void gebeQuadratAus(){
		for(int i = 0; i < kantenlaenge; i++){
			for(int y = 0; y < kantenlaenge; y++){
				System.out.print(getZahl(y,i) + "\t\t");
			}
			System.out.println("");
		}
	}

}
