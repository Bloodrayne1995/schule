package ausgabenfor;

public class Tripel {

	private int anzahlVergleiche = 0;
	private int anzahlTripel = 0;
	private boolean fertig = false;

	
	private void gebePTripelausSimple(int obergrenze){
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
	}
	
	private void gebePTripleAusMulti(int obergrenze){
		int diff = -1;
		int anzahl = 0;
		if (obergrenze % 10 == 0){
			diff = obergrenze / 10;
			anzahl = 10;
		}else if(obergrenze % 5 == 0){
			diff = obergrenze / 5;
			anzahl = 5;
		}else{
			diff = -1;
		}
		
		if(diff == -1){
			gebePTripelausSimple(obergrenze);
		}else{
			for(int i = 1; i <= anzahl; i++){
				myThread x = null;
				if(i == 1){
					x = new myThread(i, diff * i);
				}else{
					x = new myThread((i-1) + diff, diff * i);
				}
				new Thread(x).start();
			}
			
		}
	}
	
	
	public void gebeTripelAus(int obergrenze){
		if(obergrenze > 200){
			gebePTripleAusMulti(obergrenze);
			
		}else{
			gebePTripelausSimple(obergrenze);
		}
		while(!fertig){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		gebeEpilogAus();
	}
	
	private void gebeEpilogAus(){
		System.out.println("");
		System.out.println("Anzahl Tripel: " + anzahlTripel );
		System.out.println("Anzahl Vergleiche: " + anzahlVergleiche);
	}

	
	private class myThread implements Runnable{

		private int start = -1;
		private int ende = -1;
		
		public myThread(int start, int ende){
			this.start = start;
			this.ende = ende;
		}
		
		
		@Override
		public void run() {
			for(int a = start; a < ende; a++){
				for(int b = start; b < ende; b++){
					for(int c = start; c < ende; c++){
						anzahlVergleiche ++;
						fertig = false;
						if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)){
							System.out.println("A = " + a + " | B = " + b + " | C = " + c);
							anzahlTripel++;
						}
					}	
				}
			}
			fertig = true;
		}
		
	}

}
