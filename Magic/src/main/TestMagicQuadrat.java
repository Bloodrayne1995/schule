package main;

public class TestMagicQuadrat {

	
	
	public static void main(String[] args) {
		MagicQuadrat x = new MagicQuadrat();
		try {
			x.setKantenlaenge(99);
			x.erstelleQuadrat();
			x.gebeQuadratAus();

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
