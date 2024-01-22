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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.dangNhap;
import model.sessionManager;

public class signInView extends JFrame {
   
private JLabel title;
private JLabel phoneNumber;
private JLabel password;
private JTextField phoneNumberF;
private JPasswordField passwordF;
private JButton signIn;
	
public signInView()
{
	//set JFrame
	setSize(1200, 700);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setLayout(new BorderLayout());
	//setLogo
	URL url_logo = mainPageView.class.getResource("LogoTPHue (1).png");
	Image img = Toolkit.getDefaultToolkit().createImage(url_logo);
	this.setIconImage(img);
	
	//set Image
	JLabel imageLabel = new JLabel(new ImageIcon(signInView.class.getResource("HueImperialCity (1) (1).jpg")));
	this.add(imageLabel, BorderLayout.WEST);
	//setTitle
	JPanel rightPanel = new JPanel(new BorderLayout()); 
    title = new JLabel("Đăng Nhập Tài Khoản");
    JPanel titlePanel = new JPanel();
    titlePanel.add(title);
    rightPanel.add(titlePanel, BorderLayout.NORTH); 
    //Move title for 30px to bottom
    EmptyBorder eb = new EmptyBorder(50, 0, 0, 0);
    title.setBorder(eb);
    //Set Font for title
    titlePanel.setBackground(new Color(253, 244, 236));
    File fontFile = new File("DancingScript-Regular.ttf");
    try {
		Font DancingScript = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		DancingScript = DancingScript.deriveFont(Font.BOLD, 50);
		title.setFont(DancingScript);
		add(rightPanel, BorderLayout.NORTH);
	} catch (FontFormatException e) {	
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
  //set Text label & TextField label
    phoneNumber = new JLabel("Số Điện Thoại:      ");
    password = new JLabel("Mật Khẩu:            ");
    phoneNumberF = new JTextField();
    passwordF = new JPasswordField();
    
    //set Font textField
    phoneNumberF.setFont(new Font("Arial", Font.PLAIN, 15));

    //set Font textLabel
    try {
		 File JosefontFile = new File("JosefinSans-SemiBold.ttf");
        Font JosefinSans = Font.createFont(Font.TRUETYPE_FONT, JosefontFile);
        JosefinSans = JosefinSans.deriveFont(Font.BOLD, 25);
        
        phoneNumber.setFont(JosefinSans);
        password.setFont(JosefinSans);
        
	} catch (FontFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
    
    JPanel textAndTextField = new JPanel(new GridLayout(2, 1));
    textAndTextField.setBackground(new Color(253, 244, 236));

    JPanel phone_phoneFPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 30)); // Use FlowLayout and LEFT alignment
    phone_phoneFPanel.add(phoneNumber);
    phone_phoneFPanel.add(phoneNumberF);
    EmptyBorder ebph_phF = new EmptyBorder(80, 0, 0, 0);
    phone_phoneFPanel.setBorder(ebph_phF);
    phone_phoneFPanel.setBackground(new Color(253, 244, 236));

    JPanel pass_passFPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 30)); // Use FlowLayout and LEFT alignment
    pass_passFPanel.add(password);
    pass_passFPanel.add(passwordF);
    pass_passFPanel.setBackground(new Color(253, 244, 236));
    textAndTextField.add(phone_phoneFPanel);
    textAndTextField.add(pass_passFPanel);

    rightPanel.add(textAndTextField, BorderLayout.CENTER);
    
   //set Size cho textField
    Dimension size = new Dimension(180, 40);
    phoneNumberF.setPreferredSize(size);
    passwordF.setPreferredSize(size);
   //set SignIn button
    signIn = new JButton("Đăng Nhập");
  //set Font textLabel
    try {
		 File JosefontFile = new File("JosefinSans-SemiBold.ttf");
        Font JosefinSans = Font.createFont(Font.TRUETYPE_FONT, JosefontFile);
        JosefinSans = JosefinSans.deriveFont(Font.BOLD, 18);
        
        signIn.setFont(JosefinSans);
        
	} catch (FontFormatException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
    Dimension buttonSize = new Dimension(150, 38);
    signIn.setPreferredSize(buttonSize);
    signIn.setForeground(new Color(219, 185, 143));
    signIn.setBackground(new Color(150, 53, 30));

    JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,0, 100));
    buttonPanel.setBackground(new Color(253, 244, 236));
    buttonPanel.add(signIn);
    rightPanel.add(buttonPanel, BorderLayout.SOUTH);

    this.add(rightPanel, BorderLayout.CENTER);
    setVisible(true);

 //Add error dialog for passwords under 8 characters and over 16 characters or phone number is not valid
    dangNhap dn = new dangNhap();
    signIn.addActionListener(e -> {
        if (!isPhoneNumberValid()) {
            JOptionPane.showMessageDialog(signInView.this, "Số điện thoại không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else if (!isPasswordValid()) {
            JOptionPane.showMessageDialog(signInView.this, "Mật khẩu ít hơn 6 ký tự hoặc lớn hơn 16 ký tự!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
        	if(dn.checkAccount(this))
        	{
            JOptionPane.showMessageDialog(signInView.this, "Đăng nhập thành công", "", JOptionPane.INFORMATION_MESSAGE);
            performLogin();
        	}else {
        		 JOptionPane.showMessageDialog(signInView.this, "Tài khoản hoặc mật khẩu không đúng", "", JOptionPane.ERROR_MESSAGE);
        	}
        }
    });
    
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
//check password method
private boolean isPasswordValid(){
	int passwordLength = passwordF.getPassword().length;
	return passwordLength >=6 && passwordLength <= 16;
}

//Sign in
private void performLogin() {
    if(isPhoneNumberValid() && isPasswordValid())
    {
    	dangNhap dn = new dangNhap();
    	String userID = dn.getUserID(this);
    	if(userID != null) {
    		sessionManager.setUserID(userID);
    		mainPageView trangchuframe = new mainPageView();
            trangchuframe.setLocationRelativeTo(this);
          	setVisible(true);
          	this.dispose();
          	
    	} else {
    		   JOptionPane.showMessageDialog(this, "Lỗi đăng nhập. Vui lòng kiểm tra lại số điện thoại và mật khẩu.",
                       "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
    	}
    }
}
public String getPhoneNumber()
{
	return phoneNumberF.getText();
}
public String getPassword()
{
	return passwordF.getText();
}
}

