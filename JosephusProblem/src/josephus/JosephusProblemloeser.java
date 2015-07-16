package josephus;

public class JosephusProblemloeser {
	
	private int feld[];
	private int sw;
	
	
	public JosephusProblemloeser(int groeseFeld, int schrittweite){
		this.sw = schrittweite;
		initFeld(groeseFeld);
	}
	
	
	private void initFeld(int n){
		feld = new int[n];
		for(int i = 0; i < n; i++){
			feld[i] = i + 1;
		}
		feld[feld.length - 1] = 0;
	}
	
	
	public int getLastManStanding(){
		int index = 0;
		int vorindex = 0;
		int actSchrittweite = 0;
		while(index != feld[index]){
			if(actSchrittweite == sw){
				feld[vorindex] = feld[index];
				actSchrittweite = 0;
			}else{
				actSchrittweite++;
			}
			vorindex = index;
			index = feld[index];
		}
		return index;
	}
	
}
