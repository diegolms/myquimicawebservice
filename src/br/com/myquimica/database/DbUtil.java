package br.com.myquimica.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbUtil {
	
	private static String connectionString;
	private static String driverName = "com.mysql.jdbc.Driver"; //driver do MySQL

	//OPENSHIFT
	private static String database = "myquimicaweb";
	private static String user = "adminj8GhHku";
	private static String password = "GE1pj36d9g9h";
	private static String host = "OPENSHIFT_MYSQL_DB_HOST";
	private static String port = "OPENSHIFT_MYSQL_DB_PORT";

	//BANCO LOCAL
//	private static String database = "pibid";
//	private static String user = "root";
//	private static String password = "diegosepa";
//	private static String host = "localhost";
//	private static String port = "3306";

	private static Connection connection = null;
	
	
	public static Connection getConnection() {
		if (connection != null)
			return connection;
		else {
			try {
				
				String hostAux = System.getenv(host);
		        String portAux = System.getenv(port);
		        connectionString = String.format("jdbc:mysql://%s:%s/myquimicaweb", hostAux, portAux);
		        
		        //connectionString = "jdbc:mysql://" + host + ":3306/" + database;
		        
		        Class.forName(driverName);
	            connection = DriverManager.getConnection(connectionString, user, password);
	            
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}
}
