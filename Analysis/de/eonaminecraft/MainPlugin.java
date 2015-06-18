package eonaminecraft;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;


import databases.MySQLDB;

public class MainPlugin extends JavaPlugin {

	private Logger l = null;
	private MySQLDB db = new MySQLDB();
	
	public void onEnable(){
		l = this.getLogger();
		db.setDbHost("bsit13serr-gateway");
		db.setDbUser("eona");
		db.setDbName("eona");
		db.setDbPass("eona");
		
		writeInfo("Enable EonaAnalysis");
		writeInfo("Logger wurde erfolgreich eingehängt");
		writeInfo("MySQL wird angebunden");
		writeInfo("Host: " + db.getDbHost());
		writeInfo("Name: " + db.getDbName());
		writeInfo("User: " + db.getDbUser());
		writeInfo("Pass: " + db.getDbPass());
		writeInfo("Versuche MySQL zu verbinden");
		if(db.open()){
			writeInfo("Erfolgreich");
		}else{
			writeInfo("Nicht erfolgreich. Fehler:");
			writeInfo(db.getFehlerSammlung());
		}
		
	}
	
	
	public void writeInfo(String x){
		l.info(x);
	}
	
	
	
	
}
