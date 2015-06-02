package quicksort;

public class QuickSort{

	int liste[] = { 5, 4, 7, 8, 1, 2, 9, 6, 3, 0 };
	int anzahl = 1;
	int anzahl_vergleiche = 0;

	public static void main(String[] args) {
		QuickSort meinSort = new QuickSort();
		meinSort.ausgabeListe();
		meinSort.quickSort(0, 9);
		meinSort.ausgabeListe();
		meinSort.showAnzahlVergleiche();
		
	}
	
	public void showAnzahlVergleiche(){
		System.out.println("Anzahl Vergleiche: "  + anzahl_vergleiche);
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
				System.out.println("VL: " + vorLinks + " | VR: " + vorRechts);
				hilfe = liste[vorLinks];
				liste[vorLinks] = liste[vorRechts];
				liste[vorRechts] = hilfe;
				vorLinks++;
				vorRechts--;
				ausgabeListe();
			}
		} while (vorLinks <= vorRechts);
		//ausgabeListe();
		if(links < vorRechts){
			quickSort(links, vorRechts);
		}
		//ausgabeListe();
		if(vorLinks < rechts){
			quickSort(vorLinks, rechts);
		}
	}

	public void ausgabeListe() {
		//System.out.print(anzahl +" ==> ");
		for (int i = 0; i < liste.length; i++) {
			System.out.print(liste[i]);
			if(i < liste.length - 1){
				System.out.print(", ");
			}
		}
		System.out.print("\n");
		//System.out.print("\n");
		anzahl++;
	}


}
