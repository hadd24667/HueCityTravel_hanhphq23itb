package model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import view.signUpView;

public class dangKy extends DAO {
	public boolean dangKy(signUpView dk)
	{ 

		String sql = "INSERT INTO UserInformation(userName, phoneNumber, nickName, password)"
				+ "VALUES (?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, dk.getNameF());
			ps.setString(2, dk.getPhoneNumberF());
			ps.setString(3, dk.getUserNameF());
            ps.setString(4, dk.getPassWordF());
            
            return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL Error Code: " + e.getErrorCode());
		}finally {
			closeConnect();
        }
		return false;
	}
    
}
