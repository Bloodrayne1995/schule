package bmirechner;

public class BMIRechner {
	
	private int kg =0 ;
	private int groesse =0 ;
	private double bmi =0 ;
	private int geschlecht =0 ;
	
	private String table[][] ;
	
	
	public void initTabelle(){
		table = new String[2][31];
		for(int i = 0;i < 18;i++){
			table[1][i] = "Untergewicht";
			table[0][i] = "Untergewicht";
		}
		table[0][19] = "Untergewicht";
		table[1][19] = "Normalgewicht";
		for(int i = 20;i < 24;i++){
			table[1][i] = "Normalgewicht";
			table[0][i] = "Normalgewicht";
		}
		table[0][25] = "Normalgewicht";
		table[1][25] = "Übergewicht";
		for(int i = 26;i < 30;i++){
			table[1][i] = "Übergewicht";
			table[0][i] = "Übergewicht";
		}
	}
	
	public void werteEinlesen(){
		initTabelle();
		kg = BBSKonsole.leseInteger("Gewicht in KG: ");
		groesse = BBSKonsole.leseInteger("Größe in cm: ");
		geschlecht = BBSKonsole.leseInteger("Männlich (0) oder Weiblich (1): ");
		
	}
	
	public void bmiBerechnen(){
		bmi =((double)(kg * 10000)) / Math.pow(groesse, 2);
	}
	
	public void bmiAusgeben(){
		if(geschlecht == 0){
			System.out.print("Sehr geehrter Herr");
		}else{
			System.out.print("Sehr geehrte Dame");
		}
		
		try{
			System.out.println(", ihr BMI ist: " + table[geschlecht][(int)Math.round(bmi)]);
		}catch(IndexOutOfBoundsException e){
			System.out.println(", ihr BMI ist: behandlungsbedürftiges Übergewicht");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@SuppressWarnings("finally")
	public String getBmiAusgeben(){
		String x = "";
		if(geschlecht == 0){
			x += "Sehr geehrter Herr";
		}else{
			x += "Sehr geehrte Dame";
		}
		
		try{
			x += ", ihr BMI ist: " + table[geschlecht][(int)Math.round(bmi)];
		}catch(IndexOutOfBoundsException e){
			x += ", ihr BMI ist: behandlungsbedürftiges Übergewicht";
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			return x;
		}
	}

	public int getKg() {
		return kg;
	}

	public void setKg(int kg) {
		this.kg = kg;
	}

	public int getGroesse() {
		return groesse;
	}

	public void setGroesse(int groesse) {
		this.groesse = groesse;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public int getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(int geschlecht) {
		this.geschlecht = geschlecht;
	}

	public String[][] getTable() {
		return table;
	}

	public void setTable(String[][] table) {
		this.table = table;
	}
	
	
	
}
