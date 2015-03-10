package tankbeleg;

/**
 * Testklasse für die Auswertung
 * @author bsit13serr
 *
 */
public class TestAuswertung {

	/**
	 * Einsprungspunkt
	 * @param args Argumente
	 */
	public static void main(String[] args) {
		Auswertung x = new Auswertung();
		x.initTabelle();
		x.erfasseBelege();
		x.zeigeTabelle();
	}

}
