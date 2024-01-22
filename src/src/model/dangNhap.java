package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import view.signInView;

public class dangNhap extends DAO{
	
	public boolean checkAccount(signInView dn)
	{
		String sql = "SELECT * FROM UserInformation WHERE phoneNumber=? AND password=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, dn.getPhoneNumber());
			ps.setString(2, dn.getPassword());
			
			try(ResultSet rs = ps.executeQuery())
			{
				return rs.next();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} 
	
	public String getUserID(signInView dn) {
    String sql = "SELECT userID FROM UserInformation WHERE phoneNumber=? AND password=?";
    try {
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, dn.getPhoneNumber());
		ps.setString(2, dn.getPassword());
		try(ResultSet rs = ps.executeQuery()){
			if(rs.next()) {
				return rs.getString("userID");
			}
		}
	} catch (SQLException e) {
	   e.printStackTrace();
	}
		return null;
	}
}
