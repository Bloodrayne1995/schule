package test;

import java.util.ArrayList;
import java.util.Random;

import randomArray.RandomArrayGenerator;
import shellsort.ShellSort;
import suchen.BinarySearch;
import suchen.InterpolarSearch;
import suchen.NaivSearch;
import suchen.SuchCollection;
import suchen.SuchInterfaceInteger;

public class TestKlasse {

	public static void main(String[] args) {
		
		int feld[] = RandomArrayGenerator.getRandomArray(2000);
		int random = new Random().nextInt(feld.length - 1);
		ShellSort s = new ShellSort();
		int sw[] = {4,2,1};
		feld = s.sort(feld, sw);
		
		System.out.println("Feld-Länge:\t" + feld.length);
		System.out.println("Zahl die gesucht wurde:\t" + random);
		ArrayList<SuchInterfaceInteger> suchAlgorithmen = SuchCollection.getSuchCollection();
		
		long start = 0;
		long ende = 0;

		for(SuchInterfaceInteger x:suchAlgorithmen){
			start = System.nanoTime();
			boolean b = x.suche(feld, random);
			ende = System.nanoTime();
			System.out.println(x.getName() + ": gefunden=" + b + " Zeit (ns)=" + (ende - start));
		}
		
	}

}
