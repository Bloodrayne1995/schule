package quicksort;

public class QuickSort2 {

	private int liste[] = {1,2,5,7,0,-1};
	
	public void quicksort(int links, int rechts){
		int mittIndex, mitte, vorLinks, vorRechts;
		
		mittIndex = (links + rechts ) / 2;
		mitte = liste[mittIndex];
		vorLinks = links;
		vorRechts = rechts;
		
		do{
			while(liste[vorLinks] < mitte){
				vorLinks++;
			}
			
			while(liste[vorRechts] > mitte){
				vorRechts--;
			}
			
			if(vorLinks <= vorRechts){
				int hilfe = liste[vorLinks];
				liste[vorLinks] = liste[vorRechts];
				liste[vorRechts] = hilfe;
				vorLinks++;
				vorRechts--;
			}
		}while (vorLinks <= vorRechts);
		
		if(links < vorRechts){
			quicksort(links, vorRechts);
		}
		
		if (vorLinks < rechts){
			quicksort(vorLinks, rechts);
		}
		
	
	}
	
}
