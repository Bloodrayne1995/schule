package datum;

public class TestZeitklasse {

	
	public static void main(String[] args) {
		Zeitklasse x = new Zeitklasse();
		x.setZeit(1, 2, 59);
		System.out.println(x);
		x.tick();
		System.out.println(x);
	}

}
