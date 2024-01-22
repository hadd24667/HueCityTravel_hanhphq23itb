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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.dangKy;

public class signUpView extends JFrame{
	
	private JTextField nameF;
	private JTextField phoneNumberF;
	private JTextField userNameF;
	private JPasswordField passWordF;
	private JButton signUp;
	private JPanel textAndFieldPanel;
     public signUpView()
     {
    	 this.setAlwaysOnTop(true);
    	 this.setSize(630, 670);
    	 this.setResizable(false);
    	 setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	 this.setLocationRelativeTo(null);
    	 
    	//setLogo
    		URL url_logo = signUpView.class.getResource("LogoTPHue (1).png");
    		Image img = Toolkit.getDefaultToolkit().createImage(url_logo);
    		this.setIconImage(img);
    		
        //Set Title
         JLabel title = new JLabel("Đăng ký tài khoản ");
         try {
			 File fontFile = new File("DancingScript-Regular.ttf");
	         Font DancingScript = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	         DancingScript = DancingScript.deriveFont(Font.BOLD, 38);
	         
	         title.setFont(DancingScript);
	         
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
         
         //Add Title
         JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         titlePanel.setBackground(new Color(253, 244, 236));
         titlePanel.add(title);
         
         //Text Panel
         textAndFieldPanel = new JPanel(new GridLayout(4, 2));
         textAndFieldPanel.setBackground(new Color(253, 244, 236));
    	 JLabel name = new JLabel("Họ và tên: ");
    	 JLabel phoneNumber = new JLabel("Số điện thoại: ");
    	 JLabel userName = new JLabel("Tên đăng nhập: ");
    	 JLabel passWord = new JLabel("Mật khẩu:");
    	 
    	 //setFont TextLabel
    	 try {
			 File fontFile = new File("JosefinSans-SemiBold.ttf");
	         Font JosefinSans = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	         JosefinSans = JosefinSans.deriveFont(Font.BOLD, 18);
	         
	         name.setFont(JosefinSans);
	         phoneNumber.setFont(JosefinSans);
	         userName.setFont(JosefinSans);
	         passWord.setFont(JosefinSans);
	         
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	 
    	 //TextField Panel
         nameF = new JTextField();
         phoneNumberF = new JTextField();
         userNameF = new JTextField();
         passWordF = new JPasswordField();
         
         //set Font textField
         nameF.setFont(new Font("Arial", Font.PLAIN, 15));
         phoneNumberF.setFont(new Font("Arial", Font.PLAIN, 15));
         userNameF.setFont(new Font("Arial", Font.PLAIN, 15));
         passWordF.setFont(new Font("Arial", Font.PLAIN, 15));
         
         //add textLabel   	 
    	 textAndFieldPanel.add(name);
    	 textAndFieldPanel.add(nameF);
         textAndFieldPanel.add(phoneNumber);
         textAndFieldPanel.add(phoneNumberF);
         textAndFieldPanel.add(userName);
         textAndFieldPanel.add(userNameF);
         textAndFieldPanel.add(passWord);
         textAndFieldPanel.add(passWordF);
         
         
    	 //SignUp Panel 
    	 signUp = new JButton("Đăng Ký");
    	 signUp.setBackground(new Color(219, 185, 143));
    	 signUp.setForeground(new Color(150, 53, 30));
    	 
    	 try {
			 File fontFile = new File("JosefinSans-SemiBold.ttf");
	         Font JosefinSans = Font.createFont(Font.TRUETYPE_FONT, fontFile);
	         JosefinSans = JosefinSans.deriveFont(Font.ITALIC, 17);
	         
	         signUp.setFont(JosefinSans);
	         
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    	//Add signButton
         JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
         buttonPanel.add(signUp);
         buttonPanel.setBackground(new Color(253, 244, 236));
    	 
    	 //Text label size
    	 Dimension labelSize = new Dimension(150, 30);
         name.setPreferredSize(labelSize);
         phoneNumber.setPreferredSize(labelSize);
         userName.setPreferredSize(labelSize);
         passWord.setPreferredSize(labelSize);
         
         //textField size
         Dimension textFieldSize = new Dimension(200, 30);
         nameF.setPreferredSize(textFieldSize);
         phoneNumberF.setPreferredSize(textFieldSize);
         userNameF.setPreferredSize(textFieldSize);
         passWordF.setPreferredSize(textFieldSize);
         
         //Signbutton size
         Dimension buttonSize = new Dimension(120, 38);
         signUp.setPreferredSize(buttonSize);
         
         JPanel mainJpanle = new JPanel(new BorderLayout());
         mainJpanle.add(titlePanel, BorderLayout.NORTH);
         mainJpanle.add(textAndFieldPanel, BorderLayout.CENTER);
         mainJpanle.add(buttonPanel, BorderLayout.SOUTH);
          
         this.add(mainJpanle);
         this.setVisible(true);
         this.pack();
    	 
         //Add error dialog for passwords under 8 characters and over 16 characters or phone number is not valid
         dangKy dk = new dangKy();
         signUp.addActionListener(e -> {
             if (!isPhoneNumberValid()) {
                 JOptionPane.showMessageDialog(signUpView.this, "Số điện thoại không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
             } else if (!isPasswordValid()) {
                 JOptionPane.showMessageDialog(signUpView.this, "Mật khẩu ít hơn 6 ký tự hoặc lớn hơn 16 ký tự!", "Lỗi", JOptionPane.ERROR_MESSAGE);
             } else {
            	 if(dk.dangKy(this)) {
                 JOptionPane.showMessageDialog(signUpView.this, "Đăng ký thành công", "", JOptionPane.INFORMATION_MESSAGE);
            	 }
           
             }
         });
    	}
     private boolean isPasswordValid(){
	    	int passwordLength = passWordF.getPassword().length;
	    	return passwordLength >=6 && passwordLength <= 16;
	    }
    	//check number method
    	private boolean isPhoneNumberValid() {
    	    try {
    	        Long.parseLong(phoneNumberF.getText());
    	        return true;
    	    } catch (NumberFormatException ex) {
    	        return false;
    	    }
    	}
		public String getNameF() {
			return nameF.getText();
		}
		public String getPhoneNumberF() {
			return phoneNumberF.getText();
		}
		public String getUserNameF() {
			return userNameF.getText();
		}
		public String getPassWordF() {
			return passWordF.getText();
		}
    	
     }
    
