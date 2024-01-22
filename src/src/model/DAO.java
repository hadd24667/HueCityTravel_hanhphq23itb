package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DAO {
	public DAO getInstance()
	{
		return new DAO();
	}
	protected Connection conn;
	public DAO()
	{
		try {
   		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   		    conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=HueCityTravel;user=sa;password=123456789;"
   		+"encrypt=true;trustServerCertificate=true");
   		    System.out.println("Connected");
   		} catch (ClassNotFoundException e) {
   		    e.printStackTrace();
   		    System.out.println("Error");
   		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error Code: " + e.getErrorCode());
		}
	}
	 public void closeConnect() {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (SQLException e) {
	        	System.out.println("SQL Error Code: " + e.getErrorCode());
	        }
	    }
}

