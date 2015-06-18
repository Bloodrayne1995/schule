package databases;

public class MySQLDB extends DatabaseInterface {

	@Override
	public String getDBInterfaceName() {
		return "MySQL-Datenbank";
	}

	@Override
	public String getConnectionString() {
		return "jdbc:mysql://" + getDbHost() + "/" + getDbName() + "?user=" + getDbUser() + "&password=" + getDbPass();
	}

	@Override
	public String getDBClass() {
		return "com.mysql.jdbc.Driver";
	}

}
