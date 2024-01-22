package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import controller.insertFindResult;
import controller.insertInforRelics;
import model.FindDocumentListener;
import model.relicsModel;

public class relicsView extends JFrame{
 private ImageIcon orgImage;
 private JTextField searchField;
 private JButton findButton;
 private JList<String> suggestionList;
 private JScrollPane suggestionScrollPane;
 private insertFindResult insertFindResult;
 private insertInforRelics insertInforRelics;
 private JPanel inforPanel;
 private JList<relicsModel> relicsList;
 private JLabel nameLabel, locationLabel, describeLabel, priceLabel, rateLabel, imageLabel;
 public relicsView()
 {
	setImage();
	relicsList = new JList<>();
	setRightPanel();
	setMainFrame();
	insertFindResult = new insertFindResult(this);
	this.insertInforRelics = new insertInforRelics(relicsList, this);
	setupRelicsListSelectionListener();
 }
 //set hình ảnh ở bên trái
 public void setImage()
 {
	 orgImage = new ImageIcon(relicsView.class.getResource("TravelTimeHue.png"));
	 imageLabel = new JLabel(orgImage);
	 imageLabel.setBackground(new Color(3, 8, 30));
	 imageLabel.setPreferredSize(new Dimension(600, 700));
	 imageLabel.setOpaque(true);
	 add(imageLabel, BorderLayout.WEST);
 }
 public void updateImageIcon(ImageIcon newIcon)
 {
	 imageLabel.setIcon(newIcon);
 }
 //set frame chính
 public void setMainFrame() {
	 setSize(1200, 700);
	 setLocationRelativeTo(null);
	 setAlwaysOnTop(true);
	 setResizable(false);
	 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 setVisible(true);
	//setLogo
	 	URL url_logo = relicsView.class.getResource("LogoTPHue (1).png");
	 	Image img = Toolkit.getDefaultToolkit().createImage(url_logo);
	 	this.setIconImage(img);
 }
 //set frame bên phải
 public void setRightPanel()
 {
	 JPanel rightPanel = new JPanel();
	 rightPanel.setLayout(new BorderLayout());
	 //SearchBar
	 JPanel searchPanel = new JPanel(new FlowLayout());
	 searchField = new JTextField(30);
	 searchField.setSize(200, 50);
	 findButton = new JButton("Tìm kiếm");
	 findButton.setForeground(new Color(3, 8, 30));
	 findButton.setBackground(new Color(196, 231, 255));
	 
     findButton.addActionListener( e -> {
     String searchText = getSearchText();
     displayRelicsInforForSearch(searchText);
     });
     
  // Gán sự kiện cho JTextField để cập nhật danh sách gợi ý khi nhập
     searchField.getDocument().addDocumentListener(new FindDocumentListener(this));
	 
  // Thêm JScrollPane để chứa JList
     suggestionList = new JList<>();
     suggestionList.setVisibleRowCount(2);
     suggestionScrollPane = new JScrollPane(suggestionList);
     suggestionScrollPane.setBackground(new Color(3, 8, 30));
     
     
     searchPanel.add(searchField);
     searchPanel.add(findButton);
     searchPanel.setBackground(new Color(3, 8, 30));
     JPanel searchAndSuggPanel = new JPanel(new BorderLayout());
     searchAndSuggPanel.add(searchPanel, BorderLayout.NORTH);
     searchAndSuggPanel.add(suggestionScrollPane, BorderLayout.CENTER);
     rightPanel.add(searchAndSuggPanel, BorderLayout.NORTH);
     
     //InforPanel
     inforPanel = new JPanel(new GridLayout(5, 1));
     inforPanel.setBackground(new Color(3, 8, 30));
     
     nameLabel = new JLabel();
     locationLabel = new JLabel();
     describeLabel = new JLabel();
     priceLabel = new JLabel();
     rateLabel = new JLabel();
     
     nameLabel.setForeground(new Color(196, 231, 255));
     locationLabel.setForeground(new Color(196, 231, 255));
     describeLabel.setForeground(new Color(196, 231, 255));
     priceLabel.setForeground(new Color(196, 231, 255));
     rateLabel.setForeground(new Color(196, 231, 255));
     
     describeLabel.setVerticalAlignment(JLabel.TOP);
     nameLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
     describeLabel.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
     rateLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
     
     try {
		 File fontFile = new File("JosefinSans-SemiBold.ttf");
         Font JosefinSans = Font.createFont(Font.TRUETYPE_FONT, fontFile);
         JosefinSans = JosefinSans.deriveFont(Font.PLAIN, 18);
         
         nameLabel.setFont(JosefinSans);
         locationLabel.setFont(JosefinSans);
         describeLabel.setFont(JosefinSans);
         priceLabel.setFont(JosefinSans);
         rateLabel.setFont(JosefinSans);
         
	} catch (FontFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
     
     inforPanel.add(nameLabel);
     inforPanel.add(locationLabel);
     
     
     inforPanel.add(describeLabel);
     inforPanel.add(priceLabel);
     inforPanel.add(rateLabel);
     relicsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
     
     rightPanel.add(inforPanel, BorderLayout.CENTER);
     add(rightPanel, BorderLayout.CENTER);
 }
 public void displayRelicsInforForSearch(String searchText) {
	 if (searchText.isEmpty()) {
	        JOptionPane.showMessageDialog(relicsView.this, "Vui lòng nhập tên di tích!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        return;
	 }
	 List<relicsModel> searchResult = insertInforRelics.searchRelics(searchText);
	 relicsList.setListData(searchResult.toArray(new relicsModel[0]));
	 
	 if(!searchResult.isEmpty()) {
		relicsModel firstResult = searchResult.get(0);
		displayRelics(firstResult);
		
		byte[] imnageBytes = firstResult.getImage();
		ImageIcon img = new ImageIcon(imnageBytes);
		updateImageIcon(img);

	 } else {
		 JOptionPane.showMessageDialog(relicsView.this, "Không tìm thấy di tích!", "Lỗi", JOptionPane.ERROR_MESSAGE);
	 }
 }
 
 public void displayRelics(relicsModel relics) {
	if(relics != null) {
			//Hiển thị thông tin
		 System.out.println("Displaying relics information: " + relics.getName() + " - " + relics.getLocation());
		 
			 nameLabel.setText("TÊN DI TÍCH: " + relics.getName());
			 locationLabel.setText("ĐỊA CHỈ: " + relics.getLocation());
			 describeLabel.setText("<html><b>GIỚI THIỆU:</b> " + relics.getDescribe() + "</html>");
			// Định dạng và hiển thị giá vé
		      double price = relics.getPrice();
		      DecimalFormat decimalFormat = new DecimalFormat("#,##0");
		      String formattedPrice = decimalFormat.format(price) + " VND";

		      priceLabel.setText("GIÁ VÉ: " + formattedPrice);
			  rateLabel.setText("ĐÁNH GIÁ: " + relics.getRate()+"/10");
			 
			 //Hiển thị hình ảnh
			 byte[] imageBytes = relics.getImage();
			 ImageIcon img = new ImageIcon(imageBytes);
			 imageLabel.setIcon(img);
			 
	} else{
		System.out.println("relicsModel is Null");
	}
 }
 
public String getSearchText()
{
	return searchField.getText();
}
public JTextField getSearchTextField()
{
	return searchField;
}
public JList<String> getSuggestionList()
{
	return suggestionList;
}
private void setupRelicsListSelectionListener() {
    relicsList.addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            int selectedIndex = relicsList.getSelectedIndex();
            if (selectedIndex >= 0) {
                relicsModel selectedRelics = relicsList.getModel().getElementAt(selectedIndex);
                displayRelics(selectedRelics);
            }
        }
    });
}
}