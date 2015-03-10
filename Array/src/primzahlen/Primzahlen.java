package primzahlen;


public class Primzahlen {

	private boolean daten[] = null;
	private int obergrenze = 0;
	
	
	public void initFeld(){
		if(daten == null){
			daten = new boolean[obergrenze + 1];
		}
		for(int i = 0; i < daten.length;i++){
			daten[i] = true;
		}
	}
	
	public void setObergrenze(int o){
		this.obergrenze = o;
	}
	
	public void berechnePrimzahlenClassic(){
		for(int i = 2; i < daten.length;i++){
			for(int j = 2; j < i;j++){
				if(i%j == 0){
					daten[i] = false;
				}
			}
		}
	}
	
	public void berechnePrimzahlenModern(){
		int p = 2;
		while(p <= Math.sqrt(obergrenze)){
			streicheVielfache(p);
			p = getNextP(p);
		}
	}
	
	
	private void streicheVielfache(int p){
		for(int i = (int) Math.pow(p,2); i < obergrenze;i += p){
			daten[i] = false;
		}
	}
	
	private int getNextP(int oldP){
		int i = oldP + 1;
		try{
			while(!daten[i] && i <= Math.sqrt(obergrenze)){
				i++;
			}
		}catch(Exception e){
			
		}
		return i;
	}
	
	public void ausgabe(){
		for(int i = 2; i < daten.length;i++){
			System.out.println(i + "\t" + daten[i]);
		}
	}
	
	
}
