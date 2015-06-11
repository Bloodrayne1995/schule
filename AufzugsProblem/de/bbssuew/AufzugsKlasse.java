package bbssuew;

public class AufzugsKlasse {

	private int u;
	private double d;
	private double t;
	private double s;
	private double v;
	
	public void werteEinlesen(){
		System.out.println("Bitte geben Sie folgende Werte ein:");
		System.out.print("Umdrehungszahl in U/min: ");
		u = Konsole.leseInteger();
		d = Konsole.leseFloat("Seilrollendurchmesser in m: ");
		t = Konsole.leseFloat("Laufzeit in Minuten: ");
	}
	
	
	public void werteBerechnen(){
		double umfang = Math.PI * d;
		s = umfang * u * t;
		v = s / (t *60);
	}
	
	
	public void werteAusgeben(){
		System.out.println("Die Strecke beträgt: " + s + " Meter");
		System.out.println("Die Geschwindigket beträgt: " + v+ " Meter/Sekunde");
	}

}
