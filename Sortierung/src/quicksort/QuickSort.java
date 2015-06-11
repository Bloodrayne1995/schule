package quicksort;

public class QuickSort{

	int liste[] = { 5, 4, 7, 8, 1, 2, 9, 6, 3, 0 };
	int anzahl = 1;
	int anzahl_vergleiche = 0;
	boolean multithreaded = false; 
	boolean fertig = false;
	int lastThread = 0;

	public static void main(String[] args) {
		QuickSort meinSort = new QuickSort();
		meinSort.ausgabeListe();
		meinSort.quickSort(0, 9);
		meinSort.ausgabeListe();
		meinSort.showAnzahlVergleiche();
		
	}
	
	
	public void setListe(int arr[]){
		liste = arr;
	}
	
	public void showAnzahlVergleiche(){
		System.out.println("Anzahl Vergleiche: "  + anzahl_vergleiche);
	}

	public void setMT(boolean x){
		multithreaded = x;
	}
	
	public void quickSort(int links, int rechts) {
		int vorLinks, vorRechts, mitte, mittIndex, hilfe;
		
		mittIndex = (links + rechts) / 2;
		mitte = liste[mittIndex];
		vorLinks = links;
		vorRechts = rechts;

		do {
			while (liste[vorLinks] < mitte) {
				vorLinks++;
				anzahl_vergleiche++;
			}

			while (liste[vorRechts] > mitte) {
				vorRechts--;
				anzahl_vergleiche++;
			}

			if (vorLinks <= vorRechts) {
				//System.out.println("VL: " + vorLinks + " | VR: " + vorRechts);
				hilfe = liste[vorLinks];
				liste[vorLinks] = liste[vorRechts];
				liste[vorRechts] = hilfe;
				vorLinks++;
				vorRechts--;
				//ausgabeListe();
			}
		} while (vorLinks <= vorRechts);
		//ausgabeListe();
		if(links < vorRechts){
			if(multithreaded){
				SortMulti d = new SortMulti();
				d.setDaten(links, vorRechts,lastThread );
				new Thread(d).start();
				lastThread ++;
			}else{
				quickSort(links, vorRechts);
			}
		}
		//ausgabeListe();
		if(vorLinks < rechts){
			if(multithreaded){
				SortMulti d = new SortMulti();
				d.setDaten(vorLinks, rechts,lastThread );
				new Thread(d).start();
				lastThread++;
			}else{
				quickSort(vorLinks, rechts);
			}
		}
	}

	public void ausgabeListe() {
		//System.out.print(anzahl +" ==> ");
		for (int i = 0; i < liste.length; i++) {
			System.out.print(liste[i]);
			if(i < liste.length - 1){
				System.out.print(" ");
			}
		}
		System.out.print("\n");
		//System.out.print("\n");
		anzahl++;
	}
	
	
	public void sortiere(){
		quickSort(0, liste.length - 1);
	}
	
	
	public boolean isSorted(){
		boolean erg = true;
		int zahlV = liste[0];
		for(int i = 1; i < liste.length; i++){
			if(zahlV > liste[i]){
				erg = false;
				i = liste.length;
			}else{
				zahlV = liste[i];
			}
		}
		return erg;
		
	}

	
	private class SortMulti implements Runnable{

		private int links;
		private int rechts;
		private int id;
		
		public void setDaten(int l, int r, int i){
			links = l;
			rechts = r;
			id = i;
		}
		
		@Override
		public void run() {
			
			quickSort(links, rechts);
			
			if(id == lastThread - 1){
				fertig = true;
			}
		}
		
	}

}
