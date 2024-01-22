package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class startView extends JFrame {
      private JLabel imageLabel;
      private JButton SignInButton;
	  private JButton SignUpButton;
public startView()
{
   setLayout(null);
   setSize(1200, 700);
   setLocationRelativeTo(null);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
   setResizable(false);
   setVisible(true);
 
   setBackground();
   setButton();
   repaint();
   
 //setLogo
 	URL url_logo = mainPageView.class.getResource("LogoTPHue (1).png");
 	Image img = Toolkit.getDefaultToolkit().createImage(url_logo);
 	this.setIconImage(img);
   
   try {
		    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		    e.printStackTrace();
		}
 }

//Set SignIn and SignUp Button for controller

public JButton getSignUpButton() {
	return SignUpButton;
}

public JButton getSignInButton() {
	return SignInButton;
}

public void setBackground() {
	imageLabel = new JLabel(new ImageIcon(startView.class.getResource("Start.png")));
	imageLabel.setBounds(0, 0, getWidth(), getHeight());
	add(imageLabel);
}
public void setButton() {
	JPanel buttonPanel = new JPanel(null);
	buttonPanel.setOpaque(false);
	SignInButton = new JButton("Đăng Nhập");
	SignUpButton = new JButton("Đăng Ký");
	SignInButton.setForeground(Color.black);
	SignInButton.setBackground(new Color(219, 185, 143));
	SignUpButton.setForeground(Color.black);
	SignUpButton.setBackground(new Color(219, 185, 143));
	SignInButton.setBounds(428, 350, 138, 50);
	SignUpButton.setBounds(644, 350, 138, 50);
	//setFont button 
	File fontFile = new File("JosefinSans-SemiBold.ttf");
    try {
		Font JosefinSans = Font.createFont(Font.TRUETYPE_FONT, fontFile);
		JosefinSans = JosefinSans.deriveFont(Font.BOLD, 17);
		SignInButton.setFont(JosefinSans);
		SignUpButton.setFont(JosefinSans);
	} catch (FontFormatException e) {	
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	buttonPanel.setBounds(0, 0, getWidth(), getHeight());
	buttonPanel.add(SignInButton);
	buttonPanel.add(SignUpButton);
	imageLabel.add(buttonPanel);
}
}
