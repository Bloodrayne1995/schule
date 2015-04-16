package verschluesselung;

public class TestKlasse {

	
	public static void main(String args[]){
		CaesarVerschluesselung x = new CaesarVerschluesselung(3);
		
		String o = "APFEL";
		String g = "GDV-ZDU-JHKHLP";
		
		System.out.println(x.verschluessele(o));
		System.out.println(x.entschluessele(g));
	}
	
}
