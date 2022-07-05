/*
 * Created by JFormDesigner on Fri Apr 22 01:08:01 TRT 2022
 */

package views;

import java.awt.event.*;
import models.UserImpl;
import props.Users;

import java.awt.*;
import java.util.Locale;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class ForgotPassword extends JFrame {
    Users users = new Users();
    UserImpl userImpl = new UserImpl();
    public ForgotPassword() {
        initComponents();
    }

    public Users fncDataValid(){

        String email=txtForgotEmail.getText().trim().toLowerCase(Locale.ROOT);
        String verificationCode=txtverificationCode.getText().trim();
        String password=txtForgotPassword.getText();
        String password2 =txtForgotPassword2.getText();

        if(email.equals("")){
            lblError.setText("Please Enter Email");
            txtForgotEmail.requestFocus();
        }else if(!email.equals(users.getUser_email())){
            lblError.setText("Please Enter a Valid Email Address");
            txtForgotEmail.requestFocus();
        }else if(verificationCode.equals("")){
            lblError.setText("Please Enter Verification Code");
            txtverificationCode.requestFocus();
        }else if(password.equals("")){
            lblError.setText("Please Enter New Password");
            txtForgotPassword.requestFocus();
        }else if(password2.equals("")){
            lblError.setText("Please Enter New Password");
            txtForgotPassword2.requestFocus();
        } else {
            lblError.setText("Password Change Succesfull");
            Users user=new Users(email, password2);

            return user;
        }
        return null;
    }

    private void thisWindowClosing(WindowEvent e) {
        new Login().setVisible(true);
    }

    private void btnNewPassword(ActionEvent e) {
        Users user=fncDataValid();

        if(txtverificationCode.equals(Login.verificationCode)){
            userImpl.usersForgotPassword(user);
        }else{
            lblError.setText("Verification Code is Wrong");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        txtForgotEmail = new JTextField();
        txtForgotPassword2 = new JPasswordField();
        txtForgotPassword = new JPasswordField();
        txtverificationCode = new JTextField();
        lblError = new JLabel();
        label4 = new JLabel();
        btnNewPassword = new JButton();
        label5 = new JLabel();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                thisWindowClosing(e);
            }
        });
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("E-Mail");

        //---- label2 ----
        label2.setText("Confirm Password");

        //---- label3 ----
        label3.setText("New Password");

        //---- lblError ----
        lblError.setText(" ");

        //---- label4 ----
        label4.setText("Code");

        //---- btnNewPassword ----
        btnNewPassword.setText("Change Password");
        btnNewPassword.addActionListener(e -> btnNewPassword(e));

        //---- label5 ----
        label5.setText("FORGOT PASSWORD");
        label5.setFont(new Font("Segoe UI", Font.BOLD, 22));
        label5.setForeground(new Color(0, 153, 153));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label4, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNewPassword)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtForgotEmail)
                                .addComponent(txtForgotPassword)
                                .addComponent(txtForgotPassword2)
                                .addComponent(txtverificationCode, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap(165, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(242, Short.MAX_VALUE)
                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
                    .addGap(218, 218, 218))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(51, Short.MAX_VALUE)
                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1)
                        .addComponent(txtForgotEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(txtForgotPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(txtForgotPassword2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtverificationCode, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label4))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lblError, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnNewPassword)
                    .addGap(56, 56, 56))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField txtForgotEmail;
    private JPasswordField txtForgotPassword2;
    private JPasswordField txtForgotPassword;
    private JTextField txtverificationCode;
    private JLabel lblError;
    private JLabel label4;
    private JButton btnNewPassword;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
