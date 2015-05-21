package verschluesselung;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.Formatter;

import org.omg.CORBA_2_3.portable.InputStream;

public class Passwort {

	private String md5_pw = "";
	
	/**
	 * Prüft ein Passwort 
	 * @param pw
	 * @return
	 */
	public boolean check(String pw){
		boolean laenge = false;
		boolean buchstaben = false;
		boolean ziffern = false;
		boolean kleinbuchstaben = false;
		boolean grossbuchstaben = false;
		boolean sonderzeichen = false;
		
		
		if(pw.length() >= 8){
			laenge = true;
		}
		
		int anzahl_buchstaben = 0;
		int anzahl_ziffern = 0;
		int anzahl_sonderzeichen = 0;
		int anzahl_gross = 0;
		int anzahl_klein = 0;
		for(int i = 0; i < pw.length(); i++){
			if(Character.isLetter(pw.charAt(i))){
				anzahl_buchstaben++;
				if(Character.isLowerCase(pw.charAt(i))){
					anzahl_klein++;
				}else{
					anzahl_gross++;
				}
			}
			if(Character.isDigit(pw.charAt(i))){
				anzahl_ziffern++;
			}
			if(!Character.isLetter(pw.charAt(i)) && !Character.isDigit(pw.charAt(i))){
				anzahl_sonderzeichen++;
			}
		}
		
		buchstaben = (anzahl_buchstaben >= 2);
		ziffern = (anzahl_ziffern >= 2);
		sonderzeichen = (anzahl_sonderzeichen >= 1);
		kleinbuchstaben = (anzahl_klein >= 1);
		grossbuchstaben = (anzahl_gross >= 1);

		return laenge && buchstaben && ziffern && kleinbuchstaben && grossbuchstaben && sonderzeichen;
	}
	
	/**
	 * Gibt einen MD5-Wert eines Strings zurück
	 * @param pw
	 * @return
	 */
	public String getMD5(String pw){
		String erg = "";
		StringBuffer buffer = new StringBuffer();
		Formatter f = new Formatter(buffer);
		try{
			
			MessageDigest x = MessageDigest.getInstance("MD5");
			x.reset();
			x.update(pw.getBytes());
			byte a[] = x.digest();
			
			for(byte s:a){
				f.format("%02x", s);
			}
		}catch(Exception e){
			
		}
		
		erg = buffer.toString();
		return erg;
	}
	
	public void setPasswort(String x){
		if(check(x)){
			md5_pw = getMD5(x);
		}else{
			System.out.println("Passwort erfüllt nicht die Vorraussetzungen");
		}
	}
	
	public boolean isPasswordCorrect(String pw){
		return getMD5(pw).equals(md5_pw); 
	}
	
	public void login(){
		try(InputStreamReader x = new InputStreamReader(System.in); BufferedReader r = new BufferedReader(x)){
			String eingabe = "";
			do{
				System.out.println("Eingabe:");
				eingabe = r.readLine();
			}while(isPasswordCorrect(eingabe) == false);
			
			System.out.println("Erfolgreich eingeloggt.");
			System.out.println("MD5: " + md5_pw);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
