package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.signUpView;
import view.signInView;
import view.startView;

public class dangNhap_dangKy_control implements ActionListener {
    private startView uiStart;

    public dangNhap_dangKy_control(startView uiStart) {
        this.uiStart = uiStart;

        uiStart.getSignUpButton().addActionListener(this);
        uiStart.getSignInButton().addActionListener(this);
    }

    // Phương thức hiển thị trang Đăng ký
    private void openSignUpPage() {
        signUpView dangKyFrame = new signUpView();
        dangKyFrame.setLocationRelativeTo(null);
        dangKyFrame.setVisible(true);
    }

    // Phương thức hiển thị trang Đăng nhập
    private void openSignInPage() {
        signInView dangNhapFrame = new signInView();
        dangNhapFrame.setLocationRelativeTo(null);
        dangNhapFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == uiStart.getSignUpButton()) {
            openSignUpPage();
        } else if (e.getSource() == uiStart.getSignInButton()) {
            openSignInPage();
        }
    }
}
