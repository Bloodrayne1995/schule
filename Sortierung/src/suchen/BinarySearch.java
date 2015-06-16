package suchen;

public class BinarySearch implements SuchInterfaceInteger {

	@Override
	public boolean suche(int[] liste, int suchWert) {
		int mitte = (0 + liste.length) / 2;
		if(liste[mitte] == suchWert){
			return true;
		}else{
			int liste2[];
			if(liste[mitte] > suchWert){
				liste2 = new int[mitte];
				for(int i = 0; i < mitte; i++){
					liste2[i] = liste[i];
				}
			}else{
				liste2 = new int[mitte + 1];
				for(int i = mitte; i < liste.length; i++){
					int pos = i - mitte;
					liste2[pos] = liste[i];
				}
			}
			if(liste2.length > 0){
				return suche(liste2, suchWert);
			}else{
				return false;
			}
		}
	}

	
	
	@Override
	public String getName() {
		return "Binäres Suchen";
	}

}
