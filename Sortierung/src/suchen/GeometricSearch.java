package suchen;

import java.util.ArrayList;

public class GeometricSearch implements SuchInterfaceInteger {

	@Override
	public boolean suche(int[] liste, int suchWert) {
		return suche(liste,suchWert,0);
	}
	
	private boolean suche(int[] liste, int suchWert, int i){
		int n = liste.length;
		if(n < Math.pow(2, i)){
			ArrayList<int> y = new ArrayList<int>();
		}
	}

	@Override
	public String getName() {
		return "Geometrische Suche";
	}

}
