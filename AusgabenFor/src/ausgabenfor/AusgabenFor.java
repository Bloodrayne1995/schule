package ausgabenfor;

public class AusgabenFor {
	
	private String zeichen = "*";
	
	
	public void ausgebenLinie(int anzahlIkse){
		for(int i = 0; i < anzahlIkse; i++){
			System.out.print(zeichen);
		}
		System.out.println("");
	}
	
	
	public void ausgebenBand(int anzahlIkse){
		ausgebenLinie(anzahlIkse);
		for(int i = 0; i < anzahlIkse; i++){
			if(i % 2 == 0){
				System.out.print(zeichen);
			}else{
				System.out.print(" ");
			}
		}
		System.out.println();
		ausgebenLinie(anzahlIkse);
		System.out.println("");
	}
	
	public void ausgebenBlock(int anzahlIkse, int zeilen){
		for(int i = 0;i < zeilen; i++){
			ausgebenLinie(anzahlIkse);
		}
	}
	
	
	public void ausgebenDreieckLinks(int anzahlIkse){
		for(int i = 0; i < anzahlIkse; i++){
			ausgebenLinie(i + 1);
		}
	}
	
	public void gebePTripelaus(int obergrenze){
		int anzahlVergleiche = 0;
		int anzahlTripel = 0;
		for(int a = 1; a < obergrenze; a++){
			for(int b = 1; b < obergrenze; b++){
				for(int c = 1; c < obergrenze; c++){
					anzahlVergleiche ++;
					if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)){
						System.out.println("A = " + a + " | B = " + b + " | C = " + c);
						anzahlTripel++;
					}
				}
			}
		}
		System.out.println("");
		System.out.println("Anzahl Tripel: " + anzahlTripel );
		System.out.println("Anzahl Vergleiche: " + anzahlVergleiche);
	}
}
