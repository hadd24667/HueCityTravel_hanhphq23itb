package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.myTicketController;
import model.ticketModel;

public class myTicketView extends JFrame{
  private JLabel title;
  private JLabel relicsName;
  private JLabel userName;
  private JLabel personQuantity;
  private JLabel tourID;
  private JLabel visitDate;
  private JList<JPanel> ticketList;
  
  public myTicketView()
  {
	  setMainFrame();
	  setTitel();
	  createTicketList();
	  setVisible(true);
  }
  private void setMainFrame() {
	  setSize(1200, 700);
	  setLocationRelativeTo(null);
	  setAlwaysOnTop(true);
	  setResizable(false);
	  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	  getContentPane().setBackground(new Color(3, 8, 30));
	//setLogo
	URL url_logo = myTicketView.class.getResource("LogoTPHue (1).png");
	Image img = Toolkit.getDefaultToolkit().createImage(url_logo);
	this.setIconImage(img);
  }
	public void setTitel()
	{
		title = new JLabel("Vé tham quan đã đặt");
	    try {
			File fontFile = new File("DejaVuSerifCondensed-Italic.ttf");
	        Font DejaVuSerif = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	        DejaVuSerif = DejaVuSerif.deriveFont(Font.BOLD, 45);
	        title.setForeground(new Color(255, 214, 124));
	        title.setFont(DejaVuSerif);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    title.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		add(title, BorderLayout.NORTH);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setVerticalAlignment(JLabel.CENTER);
	}
	private void createTicketList() {
		 Box ticketPanelContainer = Box.createVerticalBox();
		 
		myTicketController mtc = new myTicketController();
		List<ticketModel> ticketListData = mtc.ticketData();
		
		for(ticketModel ticket : ticketListData) {
			JPanel ticketPanel = createTicketPanel(ticket);
			ticketPanelContainer.add(ticketPanel);
		}	
		JScrollPane scrollPane = new JScrollPane(ticketPanelContainer);
		add(scrollPane, BorderLayout.CENTER);
	}
	private JPanel createTicketPanel(ticketModel ticket) {
		JPanel ticketPanel = new JPanel(new GridLayout(3, 2));
		ticketPanel.setBorder(BorderFactory.createEmptyBorder());
		
		userName = new JLabel("Họ và Tên: " + ticket.getUserName());
		relicsName = new JLabel("Tên di tích: " + ticket.getRelicsName());
		personQuantity = new JLabel("Số lượng người: " + ticket.getPersonQuantity());
		visitDate = new JLabel("Ngày tham quan: " + ticket.getVisitDate());
		tourID = new JLabel("Mã vé: " + ticket.getTourID());
		 
		 
		try {
			File fontFile = new File("NotoSans_Condensed-Medium.ttf");
	        Font NotoSans = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	        NotoSans = NotoSans.deriveFont(Font.BOLD, 27);
	        userName.setFont(NotoSans);
	        relicsName.setFont(NotoSans);
	        personQuantity.setFont(NotoSans);
	        visitDate.setFont(NotoSans);
	        tourID.setFont(NotoSans);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ticketPanel.add(userName);
		ticketPanel.add(visitDate);
		ticketPanel.add(relicsName);
		ticketPanel.add(tourID);
		ticketPanel.add(personQuantity);
		
		return ticketPanel;
	}
}
