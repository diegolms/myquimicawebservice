package br.com.myquimica.database;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConexaoBD {
 
    private String connectionString;
    private String driverName = "com.mysql.jdbc.Driver"; //driver do MySQL
    
    //OPENSHIFT
    private String database = "myquimicaweb";
    private String user = "adminj8GhHku";
    private String password = "GE1pj36d9g9h";
    private String host = "OPENSHIFT_MYSQL_DB_HOST";
    private String port = "OPENSHIFT_MYSQL_DB_PORT";
    private Connection connection = null;
    
    //BANCO LOCAL
//    private String database = "pibid";
//    private String user = "root";
//    private String password = "diegosepa";
//    private String host = "localhost";
//    private String port = "3306";
//    private Connection connection = null;
 
    //construtor
    public ConexaoBD() {
    	//openshift
        String host = System.getenv(this.host);
        String port = System.getenv(this.port);
        connectionString = String.format("jdbc:mysql://%s:%s/myquimicaweb", host, port); 
    	
        //teste
       // connectionString = "jdbc:mysql://" + host + ":3306/" + database;
    }
 
    //conectar no banco
    public Connection connect() throws SQLException {
        try {
            Class.forName(this.driverName);
            //faz a conexao e retorna
            this.connection = DriverManager.getConnection(connectionString, this.user, this.password);
            return this.connection;
        }
        catch (ClassNotFoundException ex){
            throw new SQLException(ex.getMessage());
        }
        catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }
 
    //fecha conexao
    public void close() throws SQLException{
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new SQLException(ex.getMessage());
        }
    }
    
    
 
}//fim conexao