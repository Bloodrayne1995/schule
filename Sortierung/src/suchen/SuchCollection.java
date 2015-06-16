package suchen;

import java.util.ArrayList;

public class SuchCollection {

	public static ArrayList<SuchInterfaceInteger> getSuchCollection(){
		ArrayList<SuchInterfaceInteger> x = new ArrayList<SuchInterfaceInteger >();
		x.add(new BinarySearch());
		x.add(new NaivSearch());
		x.add(new InterpolarSearch());
		return x;
	}
	
}
