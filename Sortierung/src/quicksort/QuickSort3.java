package quicksort;

public class QuickSort3 {

	int liste[] = { 1, 2, 4, 0, 10};
	
	
	public void quicksort(int links, int rechts){
		int mittIndex, mitte, vorLinks, vorRechts, hilfe;
		
		mittIndex = (links + rechts) / 2;
		mitte = liste[mittIndex];
		vorLinks = links;
		vorRechts = rechts;
		
		do{
			
			while (liste[vorLinks] < mitte){
				vorLinks++;
			}
			
			while (liste[vorRechts ] > mitte){
				vorRechts--;
			}
			
			if(vorLinks <= vorRechts){
				hilfe = liste[vorLinks];
				liste[vorLinks] = liste[vorRechts];
				liste[vorRechts] = hilfe;
			}
			
		}while(vorLinks <= vorRechts);
		
		if(links < vorRechts){
			quicksort(links, vorRechts);
		}
		
		if (vorLinks > rechts){
			quicksort(vorLinks, rechts);
		}
	}
	
}
