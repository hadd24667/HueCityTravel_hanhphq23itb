package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;

import view.relicsView;

public class findList extends DAO {
	private DefaultListModel<String> listModel;

    public DefaultListModel<String> findRelics(relicsView fc)
    {
    	String sql = "SELECT relicsName FROM Relics WHERE relicsName like?";
    	try {
			listModel = new DefaultListModel<>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+fc.getSearchText()+"%");
			ResultSet result = ps.executeQuery();
			
            while (result.next()) {
            	String relicsName = result.getString("relicsName");
            	listModel.addElement(relicsName);
            }
            return listModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
     return listModel;
    }
}
