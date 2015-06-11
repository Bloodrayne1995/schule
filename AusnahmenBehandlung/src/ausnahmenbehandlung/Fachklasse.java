package ausnahmenbehandlung;

import java.io.FileInputStream;
import java.io.InputStream;

public class Fachklasse {

	
	
	public void methodeDieAusnahmeBehandelt(){
		try(InputStream x = new FileInputStream("/home/bsit13serr/test.txt")){
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
