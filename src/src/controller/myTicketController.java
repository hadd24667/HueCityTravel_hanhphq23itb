package controller;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.DAO;
import model.sessionManager;
import model.ticketModel;

public class myTicketController extends DAO{
   public List<ticketModel> ticketData()
   {
	   String userID = sessionManager.getUserID();
	   List<ticketModel> ticketList = new ArrayList<>();
	   String sql = "SELECT tourID, tourDate, personQuantity, relicsName, userName "
	   		+ "FROM TourBooking JOIN UserInformation "
	   		+ "ON TourBooking.userID = UserInformation.userID "
	   		+ "WHERE UserInformation.userID = ?";
	   try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, userID);
		ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			String tourID = rs.getString("tourID");
			LocalDate tourDate = rs.getDate("tourDate").toLocalDate();
			int personQuantity = rs.getInt("personQuantity");
			String relicsName = rs.getString("relicsName");
			String userName = rs.getString("userName");
			
			ticketModel tm = new ticketModel(relicsName, userName, personQuantity, tourDate, tourID);
			ticketList.add(tm);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
   
	return ticketList;   
   }
}
