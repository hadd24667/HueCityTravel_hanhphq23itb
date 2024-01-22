package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.tourBookingController;
import model.ticketModel;

public class bookingView extends JFrame{
	  private JLabel title;
	  private JLabel relicsNameLabel;
	  private JTextField relicsNameTextField;
	  private JLabel visitDayLabel;
	  private JTextField visitDayTextField;
	  private JLabel personQuantityLabel;
	  private JTextField personQuantityTextField;
	  private JLabel totalTicketPriceLabel;
	  private JTextField totalTicketPriceTextField;
	  private JButton pay;
	    public bookingView()
	    {
	    	setMainFrame();
	    	setTitel();
	    	setLabelAndTextField();
	    	addDocumentListener();
	    	setVisible(true);
	    }
	public void setMainFrame()
	{
	   setSize(1200, 750);
	   setLayout(new BorderLayout());
	   setLocationRelativeTo(null);
	   setAlwaysOnTop(true);
	   setResizable(false);
	   setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	   getContentPane().setBackground(new Color(3, 8, 30));
		
	 //setLogo
		URL url_logo = bookingView.class.getResource("LogoTPHue (1).png");
		Image img = Toolkit.getDefaultToolkit().createImage(url_logo);
		this.setIconImage(img);
	}
	public void setTitel()
	{
		title = new JLabel("Đặt vé tham quan");
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
	public void setLabelAndTextField()
	{
		relicsNameLabel = new JLabel("Tên di tích:");
		relicsNameTextField = new JTextField();
		visitDayLabel = new JLabel("Ngày tham quan:");
		visitDayTextField = new JTextField();
		personQuantityLabel = new JLabel("Số người tham quan:");
		personQuantityTextField = new JTextField();
		totalTicketPriceLabel = new JLabel("Tổng tiền thanh toán:");
		totalTicketPriceTextField = new JTextField();
		totalTicketPriceTextField.setPreferredSize(new Dimension(70, 35));
		totalTicketPriceTextField.setEditable(false);
		pay = new JButton("Thanh toán");
		pay.setBackground(new Color(255, 214, 124));
		pay.setForeground(new Color(3, 8, 30));
		pay.setPreferredSize(new Dimension(70, 50));
		
		relicsNameLabel.setForeground(new Color(196, 231, 255));
	    visitDayLabel.setForeground(new Color(196, 231, 255));
	    personQuantityLabel.setForeground(new Color(196, 231, 255));
	    totalTicketPriceLabel.setForeground(new Color(196, 231, 255));
	    
		try {
			File fontFile = new File("NotoSans_Condensed-Medium.ttf");
	        Font NotoSans = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	        NotoSans = NotoSans.deriveFont(Font.BOLD, 27);
	        relicsNameLabel.setFont(NotoSans);
	        visitDayLabel.setFont(NotoSans);
	        personQuantityLabel.setFont(NotoSans);
	        totalTicketPriceLabel.setFont(NotoSans);
	        pay.setFont(NotoSans);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			File fontFile = new File("NotoSans_Condensed-Medium.ttf");
	        Font NotoSans = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	        NotoSans = NotoSans.deriveFont(Font.BOLD, 22);
	        relicsNameTextField.setFont(NotoSans);
	        visitDayTextField.setFont(NotoSans);
	        personQuantityTextField.setFont(NotoSans);
	        totalTicketPriceTextField.setFont(NotoSans);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JPanel mainPanel = new JPanel(new FlowLayout());
		//set LeftPanel
		JPanel leftPanel = new JPanel(new GridLayout(6, 1));
		leftPanel.add(personQuantityLabel);
		leftPanel.add(personQuantityTextField);
		leftPanel.add(relicsNameLabel);
		leftPanel.add(relicsNameTextField);
		leftPanel.add(visitDayLabel);
		leftPanel.add(visitDayTextField);
		leftPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 100));
		leftPanel.setBackground(new Color(3, 8, 30));
		mainPanel.add(leftPanel);
		//set RightPanel
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.add(totalTicketPriceLabel);
		rightPanel.add(totalTicketPriceTextField);
		rightPanel.add(pay);
		rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0));
		rightPanel.setBackground(new Color(3, 8, 30));
		mainPanel.add(rightPanel);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		mainPanel.setBackground(new Color(3, 8, 30));
		
		 // Tăng kích thước của các nhãn và ô văn bản trong mainPanel
	    Dimension labelTextFieldSize = new Dimension(350, 50);

	    for (Component component : leftPanel.getComponents()) {
	        if (component instanceof JLabel || component instanceof JTextField) {
	            component.setPreferredSize(labelTextFieldSize);
	            component.setMinimumSize(labelTextFieldSize);
	        }
	    }

	    for (Component component : rightPanel.getComponents()) {
	        if (component instanceof JLabel || component instanceof JTextField && component != totalTicketPriceTextField) {
	            component.setPreferredSize(labelTextFieldSize);
	            component.setMinimumSize(labelTextFieldSize);
	        }
	    }
		add(mainPanel, BorderLayout.CENTER);
		pay.addActionListener(e -> {
	        boolean success = new tourBookingController().tourBookingController(this);
	        if (success) {	            
	            JOptionPane.showMessageDialog(this, "Đặt vé thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        } else {	           
	            JOptionPane.showMessageDialog(this, "Đặt vé không thành công. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
	        }
	    });
	}
	private void addDocumentListener() {
		relicsNameTextField.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        updateTotalPrice();
		    }

		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        updateTotalPrice();
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        updateTotalPrice();
		    }
		});


		personQuantityTextField.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        SwingUtilities.invokeLater(() -> updateTotalPrice());
		    }

		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        SwingUtilities.invokeLater(() -> updateTotalPrice());
		    }

		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        // Not used
		    }
		});
	}
	private void updateTotalPrice()
	{
		 SwingUtilities.invokeLater(() -> {
		        try {
		            String personQuantityText = personQuantityTextField.getText().trim();
		            if (personQuantityText.isEmpty()) {
		                JOptionPane.showMessageDialog(this, "Trường số người tham quan rỗng. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
		            } else {
		                int personQuantity = Integer.parseInt(personQuantityText);
		                String reliscName = relicsNameTextField.getText();
		                // Gọi phương thức từ tourBookingController để lấy giá vé từ CSDL
		                int relicsTicketPrice = new tourBookingController().getTicketPrice(reliscName);
		                // Tính toán tổng tiền và hiển thị nó trong totalTicketPriceTextField
		                int totalPrice = personQuantity * relicsTicketPrice;
		                totalTicketPriceTextField.setText(String.valueOf(totalPrice)+"VND");
		            }
		        } catch (NumberFormatException e) {
		            e.printStackTrace();
		        }
		    });
	}
	public String getPersonQuantity() {
		return personQuantityTextField.getText();
	}
	public String getRelicsName() {
		return relicsNameTextField.getText();
	}
	public Date getVisitDay() {
        String visitDayText = visitDayTextField.getText().trim();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
        dateFormat.setDateFormatSymbols(dateFormatSymbols);
        try {
        	dateFormat.parse(visitDayText);
        	
            java.util.Date visitDate = dateFormat.parse(visitDayText);
            java.sql.Date sqlDate = new java.sql.Date(visitDate.getTime());
            return sqlDate;
        } catch (ParseException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ngày tham quan không hợp lệ. Vui lòng nhập đúng định dạng dd/MM/yyyy.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return null; 
    }
	public JTextField getRelicsNameTextField() {
		return relicsNameTextField;
	}
	public JTextField getVisitDayTextField() {
		return visitDayTextField;
	}
	public JTextField getPersonQuantityTextField() {
		return personQuantityTextField;
	}
	public JTextField getTotalTicketPriceTextField() {
		return totalTicketPriceTextField;
	}
	}