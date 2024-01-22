package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class mainPageView extends JFrame {
    private JButton cacDiTichButton;
    private JButton datLichThamQuanButton;
    private JButton lichDaTaoButton;
    private JLabel infoLabel;
    private JLabel title;

    public mainPageView() {
    	
    	 try {
 		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
 		} catch (Exception e) {
 		    e.printStackTrace();
 		}
    	
        setTitleAndFont();
        setButtons();
        setInfoLabel();
        setupMainFrame();
    }

    private void setTitleAndFont() {
        String fontFilePath = "DancingScript-Regular.ttf";
   
        try {
        	URL url_logo = mainPageView.class.getResource("LogoTPHue (1).png");
        	Image img = Toolkit.getDefaultToolkit().createImage(url_logo);
        	this.setIconImage(img);
        	//Set font cho title
            File fontFile = new File(fontFilePath);
            Font dancingScriptFont = Font.createFont(Font.TRUETYPE_FONT, fontFile);
            dancingScriptFont = dancingScriptFont.deriveFont(Font.BOLD, 100);
            //khởi tạo titel
            title = new JLabel("Hue City Travel");
            title.setForeground(new Color(251, 214, 95));
            title.setFont(dancingScriptFont);
            title.setHorizontalAlignment(SwingConstants.CENTER);
            
            EmptyBorder eb = new EmptyBorder(0, 0, 0, 140);
            title.setBorder(eb);
            
            // Thêm JLabel cho logo
            JLabel logoLabel = new JLabel(new ImageIcon(mainPageView.class.getResource("LogoTPHue (1).png")));
            logoLabel.setHorizontalAlignment(SwingConstants.CENTER);

            // Tạo JPanel chứa tiêu đề và logo
            JPanel titleAndLogoPanel = new JPanel(new BorderLayout());
            titleAndLogoPanel.add(logoLabel, BorderLayout.WEST);
            titleAndLogoPanel.add(title, BorderLayout.CENTER);
            titleAndLogoPanel.setBackground(new Color(112, 33, 32));
            
            // Thêm JPanel này vào JFrame
            add(titleAndLogoPanel, BorderLayout.NORTH);
         
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    private void setButtons() {
        cacDiTichButton = createButton("Các Di Tích", "JosefinSans-SemiBold.ttf", 300, 135,
                new Color(255, 214, 124), new Dimension(350, 100));
        cacDiTichButton.addActionListener( e -> {
        	openRelicsView();
        });
        lichDaTaoButton = createButton("Vé Của Tôi", "JosefinSans-SemiBold.ttf", 300, 135,
                new Color(212, 163, 160), new Dimension(280, 70));
        lichDaTaoButton.addActionListener(e -> {
        	openMyTicketView();
        });
        datLichThamQuanButton = createButton("Đặt Vé Tham Quan", "JosefinSans-SemiBold.ttf", 300, 135,
                new Color(255, 214, 124), new Dimension(350, 100));
        datLichThamQuanButton.addActionListener(e -> {
        	openBookingView();
        });
    }
    private void openMyTicketView()
    {
    	myTicketView myTicketView = new myTicketView();
    	myTicketView.setVisible(true);
    }
    private void openRelicsView()
    {
    	relicsView cacDiTichView = new relicsView();
    	cacDiTichView.setVisible(true);
    }
    private void openBookingView()
    {
    	bookingView booking = new bookingView();
    	booking.setVisible(true);
    }

    private JButton createButton(String label, String fontFile, int width, int height, Color backgroundColor,
                                 Dimension preferredSize) {
        try {
            JButton button = new JButton(label);
            Font buttonFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontFile))
                    .deriveFont(Font.BOLD, 20);
            button.setFont(buttonFont);
            button.setBackground(backgroundColor);
            button.setPreferredSize(preferredSize);

            return button;
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            // Handle font loading error
            JOptionPane.showMessageDialog(this, "Error loading custom font", "Font Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private void setInfoLabel() {
        infoLabel = new JLabel("*Thông tin ứng dụng");
        Font infoFont = new Font(infoLabel.getFont().getName(), Font.ITALIC, infoLabel.getFont().getSize() + 8);
        
        infoLabel.setForeground(new Color(251, 214, 95));
        infoLabel.setBackground(new Color(112, 33, 32));
        infoLabel.setFont(infoFont);
        infoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        infoLabel.setOpaque(true);

        infoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showAppInfo();
            }
        });
    }
    
    private void showAppInfo() {
        JOptionPane.showMessageDialog(this, "Hue City Travel App\nPhiên bản 1.0\nHuế City Travel được tạo ra nhằm mục đích giúp cho các du khách dễ dàng\n"
        		+ "tiếp cận và tham quan nền du lịch lịch sử của xứ Thừa Thiên",
                "Thông tin ứng dụng", JOptionPane.INFORMATION_MESSAGE);
    }
    

    private void setupMainFrame() {
    
    //3 nút giữa
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 60));
        buttonPanel.add(cacDiTichButton);
        buttonPanel.add(lichDaTaoButton);
        buttonPanel.add(datLichThamQuanButton);
        buttonPanel.setBackground(new Color(112, 33, 32));

        JPanel mainPanel = new JPanel(new BorderLayout());    
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        add(mainPanel);
        
     // Tăng cỡ chữ cho tất cả các nút trong buttonPanel
        Font currentFont = cacDiTichButton.getFont();
        Font newFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize() + 5);

        Component[] components = buttonPanel.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                ((JButton) component).setFont(newFont);
            }
        }
        
     //Thêm label thông tin ứng dụng
        add(infoLabel, BorderLayout.SOUTH);
  
     //Setup Frame
     setSize(1200, 700);
     setLocationRelativeTo(null);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     setVisible(true);
    }
}
