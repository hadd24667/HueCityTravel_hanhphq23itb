package model;

import java.sql.SQLException;

public class closeConnect extends DAO{
	public void closeConnect()
	{
		try {
			if(conn!=null) {
				if(!conn.getAutoCommit())
				{
					 conn.commit();
		             conn.setAutoCommit(true);
				}
				conn.close();
			}
		} catch (SQLException e ) {
			e.printStackTrace();
			System.out.println("SQL Error Code: " + e.getErrorCode());
		}
	}

}
