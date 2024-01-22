package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import model.DAO;
import model.sessionManager;
import view.bookingView;

public class tourBookingController extends DAO {
 
  public boolean tourBookingController(bookingView bk) {
	  
	  String userID = sessionManager.getUserID();
	  
	  // Kiểm tra xem userID có null hay không trước khi thực hiện truy vấn
	    if (userID == null) {
	        JOptionPane.showMessageDialog(bk, "Người dùng chưa đăng nhập.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	  String sql = "INSERT INTO TourBooking (tourDate, personQuantity, relicsName, userID) VALUES (?, ?, ?, ?)";
	  try {
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setDate(1, bk.getVisitDay());
		ps.setString(2, bk.getPersonQuantity());
		ps.setString(3, bk.getRelicsName());
		ps.setString(4, userID);
		
		int rowsAffected = ps.executeUpdate();
		return rowsAffected > 0;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
  }
  private boolean isValidDateFormat(String dateText) {
	  try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        dateFormat.setLenient(false);
	        dateFormat.parse(dateText);
	        return true;
	    } catch (ParseException e) {
	        return false;
	    }
	}
  public int getTicketPrice (String relicsName) {
	  String sql = "SELECT relicsTicketPrice FROM Relics WHERE relicsName = ?";
	  try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, relicsName);
		
		try(ResultSet rs = ps.executeQuery()){
			if(rs.next()) {
				return rs.getInt("relicsTicketPrice");
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	  return 0;
  }
}