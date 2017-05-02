import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.microsoft.sqlserver.jdbc.*;

public class ConnessioneSql {
	
	
	public static void main(String[] args) {
		
		ConnectToDatabase();
		
		
	}
	
	public static final String connectionUrl = "jdbc:sqlserver://localhost:1433;istance=SQLEXPRESS;databaseName=Prova;integratedSecurity=true;";
    public static Connection con;
    
    public static void ConnectToDatabase() {

        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl, "", "");
            if (con!=null)
            System.out.println("CONNESSIONE");
        }
        // Handle any errors that may have occurred.
        catch (Exception e) {
        	e.printStackTrace();
        }
        
    }
    
    
    
    public static void grabRisultato() {
    	  String SQL = "SELECT nome FROM Table_1 WHERE id = 1";
          
    	  try {
	    	  
    		  Statement stmt = con.createStatement();
	          ResultSet rs = stmt.executeQuery(SQL);
	          System.out.println(rs.getString(0));
    	  
    	  } catch (Exception e) {
    		  e.printStackTrace();
    	  }
    }

}
	

