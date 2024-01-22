package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import model.DAO;
import model.relicsModel;
import view.relicsView;

public class insertInforRelics extends DAO{
    private JList<relicsModel> relicsList;
    private relicsView cacDiTichView;
	public insertInforRelics(JList<relicsModel> relicsList, relicsView cacDiTichView) {
		 this.relicsList = relicsList;
		this.cacDiTichView = cacDiTichView;
	}
    public List<relicsModel> searchRelics(String searchText)
    {
    	List<relicsModel> relicsData = new ArrayList<>();
    	try {
			String sql = "SELECT Relics.relicsName, relicsDescribe, relicsLocation, relicsRate, relicsTicketPrice, imageData "
					+ "FROM Relics JOIN relicsImage "
					+ "ON Relics.relicsName = RelicsImage.relicsName "
					+ "WHERE Relics.RelicsName LIKE ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + searchText + "%");
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				String relicsName = result.getString("relicsName");
				String relicsDescribe = result.getString("relicsDescribe");
				String relicsLocation = result.getString("relicsLocation");
				int relicsRate = result.getInt("relicsRate");
				float relicsTicketPrice = result.getFloat("relicsTicketPrice");
				byte[] imageBytes = result.getBytes("imageData");
				
				//Thêm vào danh sách
				relicsModel relics = new relicsModel(relicsName, relicsLocation, relicsDescribe, relicsTicketPrice, relicsRate, imageBytes);
				relicsData.add(relics);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return relicsData;
    }
}
