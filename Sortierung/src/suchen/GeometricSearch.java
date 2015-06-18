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
			int arr[] = getSubArray(liste, (int) Math.pow(2, i - 1) + 1, n);
			BinarySearch x = new BinarySearch();
			return x.suche(arr, suchWert);
		}else if(suchWert <= liste[(int) Math.pow(2, i)]){
			int arr[] = getSubArray(liste, (int) Math.pow(2, i - 1) + 1, (int) Math.pow(2, i));
			BinarySearch x = new BinarySearch();
			return x.suche(arr, suchWert);
		}else{
			return suche(liste,suchWert, i + 1);
		}
	}

	@Override
	public String getName() {
		return "Geometrische Suche";
	}

	
	private int[] getSubArray(int[] liste, int links, int rechts){
		ArrayList<Integer> d = new ArrayList<Integer>();
		int x[] = null;
		for(int i = links; i < rechts; i++){
			d.add(liste[i]);
		}
		x = new int[d.size()];
		for(int i = 0; i < x.length; i++){
			x[i] = d.get(i);
		}
		return x;
	}
}
