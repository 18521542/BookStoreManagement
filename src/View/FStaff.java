/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Controller.AccountController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author ASUS
 */
public class FStaff extends javax.swing.JPanel {

    AccountController controller = new AccountController();
    /**
     * Creates new form FStaff
     */
    public FStaff() {
        initComponents();
        this.setSize(790, 630);
        Table_Account.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        Table_Account.getTableHeader().setOpaque(false);
        Table_Account.getTableHeader().setBackground(new Color(32,136,203));
        Table_Account.getTableHeader().setForeground(new Color(0,0,255));
        Table_Account.setRowHeight(25);
        ShowDataOn_Info_Panel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        List_Panel = new javax.swing.JScrollPane();
        Table_Account = new javax.swing.JTable();
        Panel_Info = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Info_username = new javax.swing.JTextField();
        Info_pass = new javax.swing.JTextField();
        Info_realname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Info_address = new javax.swing.JTextField();
        Info_email = new javax.swing.JTextField();
        Info_phone = new javax.swing.JTextField();
        Info_type = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        Panel_function = new javax.swing.JPanel();
        Button_Add = new javax.swing.JButton();
        Button_Delete = new javax.swing.JButton();
        Button_Update = new javax.swing.JButton();
        Button_Refresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 51));
        setPreferredSize(new java.awt.Dimension(790, 630));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        List_Panel.setBackground(new java.awt.Color(255, 255, 255));
        List_Panel.setBorder(null);

        Table_Account.setFont(new java.awt.Font("Segoe UI", 0, 18));
        Table_Account.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên nhân viên", "Tên tài khoản", "Loại tài khoản"
            }
        ));
        Table_Account.setToolTipText("");
        Table_Account.setFocusable(false);
        Table_Account.setName(""); // NOI18N
        Table_Account.setOpaque(false);
        Table_Account.setRowHeight(25);
        Table_Account.setSelectionBackground(new java.awt.Color(232, 57, 95));
        Table_Account.getTableHeader().setReorderingAllowed(false);
        Table_Account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_AccountMouseClicked(evt);
            }
        });
        List_Panel.setViewportView(Table_Account);

        add(List_Panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 790, 410));

        Panel_Info.setBackground(new java.awt.Color(51, 0, 255));
        Panel_Info.setFocusable(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Password");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Real Name");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Địa chỉ");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Email");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("SĐT");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Info_type.setBackground(new java.awt.Color(204, 204, 255));
        Info_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn loại tài khoản--", "0: Admin", "1: Nhân viên",}));

        jSeparator2.setBackground(new java.awt.Color(255, 0, 102));
        jSeparator2.setForeground(new java.awt.Color(255, 0, 102));
        jSeparator2.setOpaque(true);

        jSeparator1.setBackground(new java.awt.Color(255, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(255, 0, 0));
        jSeparator1.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Thông tin chi tiết");

        javax.swing.GroupLayout Panel_InfoLayout = new javax.swing.GroupLayout(Panel_Info);
        Panel_Info.setLayout(Panel_InfoLayout);
        Panel_InfoLayout.setHorizontalGroup(
            Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_InfoLayout.createSequentialGroup()
                .addGroup(Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_InfoLayout.createSequentialGroup()
                        .addGroup(Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Info_username, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                            .addComponent(Info_pass)
                            .addComponent(Info_realname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(Panel_InfoLayout.createSequentialGroup()
                                .addComponent(Info_phone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Info_type, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Info_email, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Info_address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 27, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
        );
        Panel_InfoLayout.setVerticalGroup(
            Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_InfoLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Info_username, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Info_address, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Info_pass, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Info_email, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_InfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Info_realname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Info_phone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Info_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        add(Panel_Info, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 220));

        Panel_function.setBackground(new java.awt.Color(102, 102, 255));

        Button_Add.setText("Thêm");
        Button_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AddActionPerformed(evt);
            }
        });

        Button_Delete.setText("Xóa");
        Button_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_DeleteActionPerformed(evt);
            }
        });

        Button_Update.setText("Sửa");
        Button_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_UpdateActionPerformed(evt);
            }
        });

        Button_Refresh.setText("Refresh");
        Button_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_functionLayout = new javax.swing.GroupLayout(Panel_function);
        Panel_function.setLayout(Panel_functionLayout);
        Panel_functionLayout.setHorizontalGroup(
            Panel_functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_functionLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addGroup(Panel_functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Button_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Button_Refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        Panel_functionLayout.setVerticalGroup(
            Panel_functionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_functionLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(Button_Add, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_Delete, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_Update, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_Refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        add(Panel_function, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 80, 220));
    }// </editor-fold>//GEN-END:initComponents


    private void Button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AddActionPerformed
        String username = Info_username.getText();
        String pass = Info_pass.getText();
        String email = Info_email.getText();
        String phone = Info_phone.getText();
        int type;
        String TypeInCombobox = (String)Info_type.getSelectedItem();
        if(TypeInCombobox.equals("0: Admin"))
            type=0;
        else
            type=1;
        String name  = Info_realname.getText();
        String addre = Info_address.getText();
        if(controller.AddAccount(username, pass, type, name, phone, email, addre))
        {
            JOptionPane.showMessageDialog(null, "Thêm account thành công !");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Thêm account thất bại !");
        }
    }//GEN-LAST:event_Button_AddActionPerformed

    private void Button_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RefreshActionPerformed
        controller.getAccount(Table_Account);
        Info_address.setText("");
        Info_email.setText("");
        Info_username.setText("");
        Info_pass.setText("");
        Info_phone.setText("");
        Info_realname.setText("");
    }//GEN-LAST:event_Button_RefreshActionPerformed

    private void ShowDataOn_Info_Panel(){
        int row = Table_Account.getSelectedRow();
        if(row!=-1){
            //if row is selected
            String username = String.valueOf(Table_Account.getValueAt(row, 2));
            Info_address.setText(controller.getAccountByUsername(username).getAddress());
            Info_email.setText(controller.getAccountByUsername(username).getEmail());
            Info_pass.setText(controller.getAccountByUsername(username).getPassword());
            Info_phone.setText(controller.getAccountByUsername(username).getPhoneNumber());
            Info_realname.setText(controller.getAccountByUsername(username).getRealName());
            Info_username.setText(controller.getAccountByUsername(username).getUsername());
            int type = controller.getAccountByUsername(username).getType();
            if(type==0){
                //when user is admin
                String admin = Info_type.getItemAt(0);
                
            } else
                Info_type.getItemAt(1);
            
        }
    }
    private void Button_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_DeleteActionPerformed
       int row = Table_Account.getSelectedRow();
       if(row==-1)
           JOptionPane.showMessageDialog(null, "Hãy chọn tài khoản muốn xóa");
       else {
           int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa?");
           if(confirm==JOptionPane.YES_OPTION){
               String username = String.valueOf(Table_Account.getValueAt(row, 2));
               if(controller.DeleteAccountByUsername(username))
                  JOptionPane.showMessageDialog(null, "Xóa thành công");
               else
                   JOptionPane.showMessageDialog(null, "Xóa thất bại");
           }
       }
    }//GEN-LAST:event_Button_DeleteActionPerformed

    private void Table_AccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_AccountMouseClicked
        ShowDataOn_Info_Panel();
    }//GEN-LAST:event_Table_AccountMouseClicked

    private void Button_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_UpdateActionPerformed
        int row = Table_Account.getSelectedRow();
        if(row==-1)
            JOptionPane.showMessageDialog(null, "Hãy chọn tài khoản muốn sửa");
        else {
            int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn sửa?");
            if(confirm==JOptionPane.YES_OPTION){
                String username = Info_username.getText();
                String pass = Info_pass.getText();
                String email = Info_email.getText();
                String phone = Info_phone.getText();
                int type;
                String TypeInCombobox = (String)Info_type.getSelectedItem();
                if(TypeInCombobox.equals("0: Admin"))
                     type=0;
                else
                     type=1;
                String name  = Info_realname.getText();
                String addre = Info_address.getText();
                if(controller.UpdateAccountByUsername(username, pass, type, name, phone, email, addre))
                {
                     JOptionPane.showMessageDialog(null, "Sửa account thành công !");
                }
                else
                {
                     JOptionPane.showMessageDialog(null, "Sửa account thất bại !");
                }
            }
        }
    }//GEN-LAST:event_Button_UpdateActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Add;
    private javax.swing.JButton Button_Delete;
    private javax.swing.JButton Button_Refresh;
    private javax.swing.JButton Button_Update;
    private javax.swing.JTextField Info_address;
    private javax.swing.JTextField Info_email;
    private javax.swing.JTextField Info_pass;
    private javax.swing.JTextField Info_phone;
    private javax.swing.JTextField Info_realname;
    private javax.swing.JComboBox<String> Info_type;
    private javax.swing.JTextField Info_username;
    private javax.swing.JScrollPane List_Panel;
    private javax.swing.JPanel Panel_Info;
    private javax.swing.JPanel Panel_function;
    private javax.swing.JTable Table_Account;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
