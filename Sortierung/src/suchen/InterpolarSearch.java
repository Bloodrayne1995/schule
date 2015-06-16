package suchen;

public class InterpolarSearch implements SuchInterfaceInteger {

	@Override
	public boolean suche(int[] liste, int suchWert) {
		int links, rechts, versch, pos;
		links = 0;
		rechts = liste.length - 1;
		
		while(suchWert >= liste[links] && suchWert <= liste[rechts]){
			versch = liste[rechts] - liste[links];
			pos =  links + (int)(((double) rechts - links)* (suchWert -liste[links]) / versch);
			
			if(suchWert > liste[pos]){
				links += 1;
			}else if(suchWert < liste[pos]){
				rechts -= 1;
			}else{
				return true;
			}
		}
		return false;
	}

	@Override
	public String getName() {
		return "Interpoliertes Suchen";
	}

}
