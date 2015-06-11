package mathe;

public class Mathe {

	private double iA = -3;
	private double iB = 4;
	private double iC = 5;
	
	public void out(String x){
		System.out.println(x);
	}
	
	
	public void rechneE1(){
		out("ERGEBNIS 1");
		double erg = iA / iB;
		out("1: " + erg);
	}
	
	public void rechneE2(){
		out("ERGEBNIS 2");
		double erg = Math.cbrt(iB);
		out("2: " + erg);
	}
	
	public void rechneE3(){
		out("ERGEBNIS 3");
		double erg = Math.pow(iC, 3);
		out("3: " + erg);
	}
	
	public void rechneE4(){
		out("ERGEBNIS 4");
		double erg = Math.sqrt(Math.pow(iB, 2) + Math.pow(iC, 2));
		out("4: " + erg);
	}
	
	public void rechneE5(){
		out("ERGEBNIS 5");
		double erg = (Math.sqrt(Math.pow(iB, 2) + Math.pow(iC, 2)) + 3 * iA) / (Math.abs(iA) + 2);
		out("5: " + erg);
	}
	
	public void rechneE6(){
		out("ERGEBNIS 6");
		double erg = Math.sin((3* iA * Math.PI) / iC);
		out("6: " + erg);
	}
	
	public void rechneE7(){
		out("ERGEBNIS 7");
		double erg = ((iA * iB + Math.pow(iC, iA))/3) + (iB / (2+(5 / iB)));
		out("7: " + erg);
	}
	
	public void go(){
		rechneE1();
		rechneE2();
		rechneE3();
		rechneE4();
		rechneE5();
		rechneE6();
		rechneE7();
	}
	
	

}
