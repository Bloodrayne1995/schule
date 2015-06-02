package vergleich;

import quicksort.*;
import randomArray.RandomArrayGenerator;
import shellsort.ShellSort;

public class Vergleich {

	public static void main(String args[]){
		long timeStartQS, timeStartShS, timeEndQS, timeEndShs;
		int feld[] = RandomArrayGenerator.getRandomArray(40000000);
		int feld2[] = feld.clone();
		ShellSort a = new ShellSort();
		QuickSort x = new QuickSort();
		int schritte[] = { 4 , 2 , 1 };

		
		//System.out.println("Feld das sortiert wird:");
		//a.showArray(feld);
		System.out.println("");
		System.out.println("");
		
		System.out.println("QuickSort: ");
		x.setListe(feld);
		timeStartQS = System.nanoTime();
		x.sortiere();
		timeEndQS = System.nanoTime();
		//x.ausgabeListe();
		System.out.println("Sortiert: " + x.isSorted());
		System.out.println("Zeit in Nano-Sekunden: " + (timeEndQS - timeStartQS));
		
		
		System.out.println("");
		System.out.println("");
		System.out.println("ShellSort: ");
		timeStartShS = System.nanoTime();
		int sortfeld[] = a.sort(feld2, schritte);
		timeEndShs = System.nanoTime();
		//a.showArray(sortfeld);
		System.out.println("Sortiert: " + a.isSorted(sortfeld));
		System.out.println("Zeit in Nano-Sekunden: " + (timeEndShs - timeStartShS));
		
	}
	
	
	
	
	
	
}
