package util;

public class Zeitklasse {

	private long _start = 0;
	
	public Zeitklasse(){
		_start = System.nanoTime();
	}
	
	
	public long getDifference(){
		return System.nanoTime() - _start;
	}
	
	
}
