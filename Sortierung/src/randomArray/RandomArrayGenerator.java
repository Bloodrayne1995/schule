package randomArray;

import java.util.Random;

public class RandomArrayGenerator {

	/**
	 * Gibt ein Array mit zufällig angeordnete Zahlen
	 * @param obergrenze Größe des Feldes
	 * @return
	 */
	public int[] getRandomArray(int obergrenze){
		int arr[] = new int[obergrenze];
		
		for(int i = 0; i < arr.length;i++){
			arr[i] = i + 1;
		}
		
		Random d = new Random();
		int anzahlTausche = d.nextInt(obergrenze - 1);
		int pos1,pos2,save;
		for(int j = 0; j < anzahlTausche;j++){
			pos1 = d.nextInt(obergrenze);
			pos2 = d.nextInt(obergrenze);
			save = arr[pos1];
			arr[pos1] = arr[pos2];
			arr[pos2] = save;
		}
		
		return arr;
	}
	
	
}
