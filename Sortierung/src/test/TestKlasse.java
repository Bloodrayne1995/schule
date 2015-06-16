package test;

import java.util.Random;

import randomArray.RandomArrayGenerator;
import shellsort.ShellSort;
import suchen.Suchen;

public class TestKlasse {

	public static void main(String[] args) {
		
		int feld[] = RandomArrayGenerator.getRandomArray(2000);
		int random = new Random().nextInt(feld.length - 1);
		ShellSort s = new ShellSort();
		int sw[] = {4,2,1};
		feld = s.sort(feld, sw);
		Suchen x = new Suchen();
		
		long startBin = 0;
		long startNaiv = 0;
		long endBin = 0;
		long endNaiv = 0;
		boolean ergBin = false;
		boolean ergNaiv = false;
		
		startBin = System.nanoTime();
		ergBin = x.bin(feld, random);
		endBin = System.nanoTime();
		
		
		startNaiv = System.nanoTime();
		ergNaiv = x.naiv(feld, random);
		endNaiv = System.nanoTime();

		
		System.out.println("Feld-Länge:\t" + feld.length);
		System.out.println("Zahl die gesucht wurde:\t" + random);
		System.out.println("Binäres Suchen: gefunden=" + ergBin + " Zeit (ns)=" + (endBin - startBin));
		System.out.println("Naives Suchen: gefunden=" + ergNaiv + " Zeit (ns)=" + (endNaiv - startNaiv));
		
		
		
		
		
	}

}
