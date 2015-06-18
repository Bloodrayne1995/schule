package databases;
import java.sql.*;
import java.util.ArrayList;

public abstract class DatabaseInterface {

	private Connection dbConnection = null;
	
	private String dbHost = "";
	private String dbName = "";
	private String dbPass = "";
	private String dbUser = "";
	private boolean opened = false;
	private ArrayList<Exception> fehler = new ArrayList<Exception>(); 
	
	/**
	 * Gibt den Namen dieses Interfaces zurück
	 * @return
	 */
	public abstract String getDBInterfaceName();
	
	/**
	 * Gibt den Connection-String zum Verbinden zur DB zurück
	 * @return
	 */
	public abstract String getConnectionString();
	
	/**
	 * Gibt die Klasse der Datenbank zurück
	 * @return
	 */
	public abstract String getDBClass();
	
	/**
	 * Führt ein SELECT-Befehl aus
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(String sql) throws Exception{
		if(!isOpened() || dbConnection == null){
			throw new Exception("DB nicht geöffnet");
		}else{
			if(dbConnection.isClosed()){
				throw new Exception("DB nicht geöffnet");
			}else{
				return dbConnection.createStatement().executeQuery(sql);
			}
		}
	}
	
	/**
	 * Führt einen Update/Delete oder DDL-Befehle aus
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public boolean execute(String sql) throws Exception{
		if(!isOpened() || dbConnection == null){
			throw new Exception("DB nicht geöffnet");
		}else{
			if(dbConnection.isClosed()){
				throw new Exception("DB nicht geöffnet");
			}else{
				return dbConnection.createStatement().execute(sql);
			}
		}
	}
	
	/**
	 * Öffnet die DB
	 * @return true = funktioniert, false = nicht funktioniert
	 */
	public boolean open(){
		try{
			Class.forName(getDBClass());
			dbConnection = DriverManager.getConnection(getConnectionString());
			return true;
		}catch(Exception e){
			fehler.add(e);
			return false;
		}
	}

	/**
	 * Gibt die abgefangene Fehler als Text
	 * @return
	 */
	public String getFehlerSammlung(){
		String f = "";
		for(Exception e:fehler){
			f += e.getMessage() + "\n";
			for(StackTraceElement x:e.getStackTrace()){
				f += x.getFileName() + "| " +x.getClassName() + "-->" + x.getMethodName() + ":" + x.getLineNumber() + "\n";
			}
			f += "----------------------\n";
		}
		return f;
	}

	/**
	 * @return the dbHost
	 */
	public String getDbHost() {
		return dbHost;
	}

	/**
	 * @param dbHost the dbHost to set
	 */
	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}

	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}

	/**
	 * @param dbName the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * @return the dbPass
	 */
	public String getDbPass() {
		return dbPass;
	}

	/**
	 * @param dbPass the dbPass to set
	 */
	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}

	/**
	 * @return the dbUser
	 */
	public String getDbUser() {
		return dbUser;
	}

	/**
	 * @param dbUser the dbUser to set
	 */
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	/**
	 * @return the opened
	 */
	public boolean isOpened() {
		return opened;
	}
}
