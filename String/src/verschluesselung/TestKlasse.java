package verschluesselung;

public class TestKlasse {

	
	public static void main(String args[]){
		String pw = "";
		if(args.length >0){
			pw = args[0];
		}
		
		Passwort t = new Passwort();
		t.setPasswort("Ab$10hallo");
		
		t.login();
		
	}
	
}
