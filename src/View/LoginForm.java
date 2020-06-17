
package View;

import Controller.AccountController;
import Model.Account;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    AccountController Controller=new AccountController();
    private static LoginForm instance = null;
    public static LoginForm getInstance(){
        if(LoginForm.instance==null)
            instance= new LoginForm();
        return instance;
    }
    public LoginForm() {
        initComponents();
        this.setSize(647,442);
        this.setLocationRelativeTo(null);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        LoginLabel = new javax.swing.JLabel();
        Xbutton = new javax.swing.JLabel();
        MinButton = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        PassLabel = new javax.swing.JLabel();
        UserField = new javax.swing.JTextField();
        CancelButton = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        LoginButton1 = new javax.swing.JButton();
        PasswordField = new javax.swing.JPasswordField();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(600, 600));

        Main.setLayout(null);

        LoginLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LoginLabel.setText("Book Store Management");
        Main.add(LoginLabel);
        LoginLabel.setBounds(190, 60, 310, 30);

        Xbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Xbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Xbutton.setText("x");
        Xbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                XbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                XbuttonMouseExited(evt);
            }
        });
        Main.add(Xbutton);
        Xbutton.setBounds(610, 0, 40, 30);

        MinButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        MinButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinButton.setText("-");
        MinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinButtonMouseExited(evt);
            }
        });
        Main.add(MinButton);
        MinButton.setBounds(570, 0, 40, 30);

        UserLabel.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        UserLabel.setText("Username  ");
        Main.add(UserLabel);
        UserLabel.setBounds(130, 160, 100, 40);

        PassLabel.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        PassLabel.setText("Password  ");
        Main.add(PassLabel);
        PassLabel.setBounds(130, 240, 90, 40);

        UserField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        UserField.setForeground(new java.awt.Color(153, 153, 153));
        UserField.setText("Enter username");
        UserField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                UserFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                UserFieldFocusLost(evt);
            }
        });
        UserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserFieldActionPerformed(evt);
            }
        });
        Main.add(UserField);
        UserField.setBounds(240, 160, 280, 40);

        CancelButton.setBackground(new java.awt.Color(102, 102, 0));
        CancelButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        CancelButton.setText("Thoát");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });
        Main.add(CancelButton);
        CancelButton.setBounds(340, 350, 200, 40);
        Main.add(jSeparator3);
        jSeparator3.setBounds(30, 130, 590, 20);
        Main.add(jSeparator1);
        jSeparator1.setBounds(30, 320, 590, 10);

        LoginButton1.setBackground(new java.awt.Color(102, 102, 0));
        LoginButton1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        LoginButton1.setText("Đăng nhập");
        LoginButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButton1ActionPerformed(evt);
            }
        });
        Main.add(LoginButton1);
        LoginButton1.setBounds(130, 350, 200, 40);

        PasswordField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(153, 153, 153));
        PasswordField.setText("dknadnas'dá'");
        PasswordField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PasswordFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFieldFocusLost(evt);
            }
        });
        Main.add(PasswordField);
        PasswordField.setBounds(240, 239, 280, 40);

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Login_Background.jpg"))); // NOI18N
        Background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 153, 0)));
        Main.add(Background);
        Background.setBounds(0, 0, 650, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void XbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XbuttonMouseClicked
        System.exit(0);
        
    }//GEN-LAST:event_XbuttonMouseClicked

    private void MinButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinButtonMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MinButtonMouseClicked

    private void XbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XbuttonMouseEntered
//        Border Label_border = BorderFactory.createMatteBorder(1, 1, 1,1, Color.white);
//        Xbutton.setBorder(Label_border);
        Xbutton.setForeground(Color.white);
        //done
    }//GEN-LAST:event_XbuttonMouseEntered

    private void UserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserFieldActionPerformed

    }//GEN-LAST:event_UserFieldActionPerformed

    private void XbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XbuttonMouseExited
//        Border Label_border = BorderFactory.createMatteBorder(1, 1, 1,1, Color.BLACK);
//        Xbutton.setBorder(Label_border);
        Xbutton.setForeground(Color.BLACK);
    }//GEN-LAST:event_XbuttonMouseExited

    private void MinButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinButtonMouseEntered
        // TODO add your handling code here:
//        Border Label_border = BorderFactory.createMatteBorder(1, 1, 1,1, Color.white);
//        MinButton.setBorder(Label_border);
        MinButton.setForeground(Color.white);
        //done
    }//GEN-LAST:event_MinButtonMouseEntered

    private void MinButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinButtonMouseExited
        // TODO add your handling code here:
//        Border Label_border = BorderFactory.createMatteBorder(1, 1, 1,1, Color.BLACK);
//        MinButton.setBorder(Label_border);
        MinButton.setForeground(Color.BLACK);
        //done
    }//GEN-LAST:event_MinButtonMouseExited

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        int result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?", "Chú ý", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION)
            this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void LoginButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButton1ActionPerformed

        String username=UserField.getText();
        String password=PasswordField.getText();
        if (Controller.Login(username, password)) {
            JOptionPane.showMessageDialog(null, "Login thành công");
            AccountController a = new AccountController();
            a.getAccountByUsername(username);
            Main_UI_Project.getInstance().setAccount(Controller.getAccountByUsername(username));
            Main_UI_Project.getInstance().setVisible(true);
            this.setVisible(false);
        }
        else
            JOptionPane.showMessageDialog(null, "Sai tên tài khoản hoặc mật khẩu");
    }//GEN-LAST:event_LoginButton1ActionPerformed

    private void UserFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserFieldFocusGained
        // Clear textfield nếu trỏ vào dòng enter username
        if(UserField.getText().trim().toLowerCase().equals("enter username")){
            UserField.setText("");
            UserField.setForeground(Color.black);
        }
    }//GEN-LAST:event_UserFieldFocusGained

    private void UserFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_UserFieldFocusLost
        // TODO add your handling code here:
        if(UserField.getText().trim().equals("")|| UserField.getText().trim().toLowerCase().equals("enter username"))
        {
            UserField.setText("Enter username");
            UserField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_UserFieldFocusLost

    private void PasswordFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFieldFocusGained
        // TODO add your handling code here:
        String pass = String.valueOf(PasswordField.getPassword());
         if(pass.trim().equals("dknadnas'dá'")){
            PasswordField.setText("");
            PasswordField.setForeground(Color.black);
        }                    
    }//GEN-LAST:event_PasswordFieldFocusGained

    private void PasswordFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFieldFocusLost
        // TODO add your handling code here:
        String pass = String.valueOf(PasswordField.getPassword());
        if(pass.trim().equals("")|| pass.trim().toLowerCase().equals("dknadnas'dá'"))
        {
            PasswordField.setText("dknadnas'dá'");
            PasswordField.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_PasswordFieldFocusLost

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton LoginButton1;
    private javax.swing.JLabel LoginLabel;
    private javax.swing.JPanel Main;
    private javax.swing.JLabel MinButton;
    private javax.swing.JLabel PassLabel;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JTextField UserField;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JLabel Xbutton;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
