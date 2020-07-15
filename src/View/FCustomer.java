
package View;

import Controller.CustomerController;
import Model.Customer;
import javax.swing.JOptionPane;


public class FCustomer extends javax.swing.JPanel {
    CustomerController Controller=new CustomerController();
    Customer customerChosen=null;
    private static FCustomer instance=null;
    public static FCustomer getInstance(){
        if(instance==null)
            instance=new FCustomer();
        return instance;
    }
    public FCustomer() {
        initComponents();
        this.setSize(790,630);
        reload();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_Header = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Bill = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Customer = new javax.swing.JTable();
        Txf_Search = new javax.swing.JTextField();
        Button__Search = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Label_Addre = new javax.swing.JLabel();
        Label_debt = new javax.swing.JLabel();
        Txf_debt = new javax.swing.JTextField();
        Txf_Addre = new javax.swing.JTextField();
        Label_Phone = new javax.swing.JLabel();
        Txf_Phone = new javax.swing.JTextField();
        Label_Name = new javax.swing.JLabel();
        Txf_Name = new javax.swing.JTextField();
        Label_Email = new javax.swing.JLabel();
        Txf_Email = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        Button_Update = new javax.swing.JButton();
        Button_Add = new javax.swing.JButton();
        Button_Delete = new javax.swing.JButton();
        Label_Background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 0));
        setPreferredSize(new java.awt.Dimension(790, 552));
        setLayout(null);

        Label_Header.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Label_Header.setForeground(new java.awt.Color(232, 57, 95));
        Label_Header.setText("Quản lý khách hàng");
        add(Label_Header);
        Label_Header.setBounds(280, 10, 250, 32);

        Table_Bill.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Table_Bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Số hóa đơn", "Ngày lập", "Trị giá hóa đơn"
            }
        ));
        Table_Bill.setRowHeight(40);
        Table_Bill.setSelectionBackground(new java.awt.Color(232, 57, 95));
        Table_Bill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_BillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Bill);

        add(jScrollPane1);
        jScrollPane1.setBounds(390, 110, 390, 200);

        jLabel2.setBackground(new java.awt.Color(232, 57, 95));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lịch sử mua hàng");
        jLabel2.setOpaque(true);
        add(jLabel2);
        jLabel2.setBounds(390, 80, 390, 30);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(232, 57, 95));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Danh sách khách hàng");
        add(jLabel3);
        jLabel3.setBounds(270, 340, 250, 30);

        Table_Customer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Table_Customer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã khách hàng", "Tên khách hàng"
            }
        ));
        Table_Customer.setSelectionBackground(new java.awt.Color(232, 57, 95));
        Table_Customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_CustomerMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_Customer);

        add(jScrollPane2);
        jScrollPane2.setBounds(10, 420, 770, 210);
        add(Txf_Search);
        Txf_Search.setBounds(10, 380, 720, 30);

        Button__Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon_Search.png"))); // NOI18N
        Button__Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button__SearchActionPerformed(evt);
            }
        });
        add(Button__Search);
        Button__Search.setBounds(740, 380, 40, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(232, 57, 95));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin khách hàng");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 30));

        Label_Addre.setBackground(new java.awt.Color(255, 255, 255));
        Label_Addre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Label_Addre.setForeground(new java.awt.Color(232, 57, 95));
        Label_Addre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Addre.setText("Địa chỉ");
        Label_Addre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Label_Addre.setOpaque(true);
        Label_Addre.setPreferredSize(new java.awt.Dimension(39, 16));
        jPanel1.add(Label_Addre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 90, 30));

        Label_debt.setBackground(new java.awt.Color(232, 57, 95));
        Label_debt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Label_debt.setForeground(new java.awt.Color(255, 255, 255));
        Label_debt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_debt.setText("Tiền nợ");
        Label_debt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Label_debt.setOpaque(true);
        jPanel1.add(Label_debt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 90, 30));

        Txf_debt.setEditable(false);
        Txf_debt.setBackground(new java.awt.Color(232, 57, 95));
        Txf_debt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txf_debt.setForeground(new java.awt.Color(255, 255, 255));
        Txf_debt.setDisabledTextColor(new java.awt.Color(153, 153, 153));
        jPanel1.add(Txf_debt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 280, 30));

        Txf_Addre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txf_Addre.setForeground(new java.awt.Color(232, 57, 95));
        jPanel1.add(Txf_Addre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 280, 30));

        Label_Phone.setBackground(new java.awt.Color(255, 255, 255));
        Label_Phone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Label_Phone.setForeground(new java.awt.Color(232, 57, 95));
        Label_Phone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Phone.setText("SĐT");
        Label_Phone.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Label_Phone.setOpaque(true);
        jPanel1.add(Label_Phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 90, 30));

        Txf_Phone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txf_Phone.setForeground(new java.awt.Color(232, 57, 95));
        jPanel1.add(Txf_Phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 280, 30));

        Label_Name.setBackground(new java.awt.Color(255, 255, 255));
        Label_Name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Label_Name.setForeground(new java.awt.Color(232, 57, 95));
        Label_Name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Name.setText("Tên KH");
        Label_Name.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Label_Name.setOpaque(true);
        jPanel1.add(Label_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 90, 30));

        Txf_Name.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txf_Name.setForeground(new java.awt.Color(232, 57, 95));
        Txf_Name.setSelectionColor(new java.awt.Color(255, 0, 153));
        jPanel1.add(Txf_Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 280, 30));

        Label_Email.setBackground(new java.awt.Color(232, 57, 95));
        Label_Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Label_Email.setForeground(new java.awt.Color(255, 255, 255));
        Label_Email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Email.setText("Email");
        Label_Email.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Label_Email.setOpaque(true);
        jPanel1.add(Label_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 90, 30));

        Txf_Email.setBackground(new java.awt.Color(232, 57, 95));
        Txf_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Txf_Email.setForeground(new java.awt.Color(255, 255, 255));
        Txf_Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txf_EmailActionPerformed(evt);
            }
        });
        jPanel1.add(Txf_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 280, 30));

        add(jPanel1);
        jPanel1.setBounds(10, 80, 370, 180);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(330, 280, 50, 30);

        Button_Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/customerUpd.png"))); // NOI18N
        Button_Update.setText("Sửa");
        Button_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_UpdateActionPerformed(evt);
            }
        });
        add(Button_Update);
        Button_Update.setBounds(230, 280, 90, 30);

        Button_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/customerAdd.png"))); // NOI18N
        Button_Add.setText("Thêm");
        Button_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AddActionPerformed(evt);
            }
        });
        add(Button_Add);
        Button_Add.setBounds(10, 280, 94, 30);

        Button_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        Button_Delete.setText("Xóa");
        Button_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_DeleteActionPerformed(evt);
            }
        });
        add(Button_Delete);
        Button_Delete.setBounds(120, 280, 94, 30);

        Label_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Genre_Background.jpg"))); // NOI18N
        add(Label_Background);
        Label_Background.setBounds(0, 0, 790, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void Button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AddActionPerformed
        // TODO add your handling code here:
        String name=Txf_Name.getText();
        String phone=Txf_Phone.getText();
        String email=Txf_Email.getText();
        String address=Txf_Addre.getText();
        if(Controller.AddCustomer(name,phone,email,address))
        {
            JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công !","Thông báo", JOptionPane.OK_OPTION);
            reload();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại !","Thông báo", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_Button_AddActionPerformed

    private void Table_CustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_CustomerMouseClicked
        customerChosen = Controller.getCustomerByID(Table_Customer.getModel().getValueAt(Table_Customer.getSelectedRow(), 1).toString());
        Txf_Name.setText(customerChosen.name());
        Txf_Addre.setText(customerChosen.address());
        Txf_Email.setText(customerChosen.email());
        Txf_Phone.setText(customerChosen.phoneNumber());
        String dept = "Failed" ;
        dept = String.valueOf(customerChosen.owe());
        Txf_debt.setText(dept);
        Controller.loadBillByCustomerID(Table_Bill,customerChosen.id());
    }//GEN-LAST:event_Table_CustomerMouseClicked

    private void Button_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_UpdateActionPerformed
        // TODO add your handling code here:
        String id=customerChosen.id();
        String name=Txf_Name.getText();
        String phone=Txf_Phone.getText();
        String email=Txf_Email.getText();
        String address=Txf_Addre.getText();
        if(Controller.UpdateCustomer(id,name,phone,email,address))
        {
            JOptionPane.showMessageDialog(null, "Cập nhật thành công !","Thông báo", JOptionPane.OK_OPTION);
            customerChosen=Controller.getCustomerByID(id);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Cập nhật thất bại !","Thông báo", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_Button_UpdateActionPerformed

    private void Button__SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button__SearchActionPerformed
        Controller.SearchCustomer(Table_Customer,Txf_Search.getText());
    }//GEN-LAST:event_Button__SearchActionPerformed

    private void Button_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_DeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Button_DeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        reload();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Table_BillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_BillMouseClicked
        // TODO add your handling code here:
        FBillInfo.getInstance().setBill(Table_Bill.getModel().getValueAt(Table_Bill.getSelectedRow(), 1).toString());
        FBillInfo.getInstance().setVisible(true);
        FBillInfo.getInstance().reload();
    }//GEN-LAST:event_Table_BillMouseClicked

    private void Txf_EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txf_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txf_EmailActionPerformed

    public void reload() {
        Controller.loadCustomer(Table_Customer);
        Controller.loadBillByCustomerID(Table_Bill, null);
        Txf_Search.setText("");
        Txf_Addre.setText("");
        Txf_Email.setText("");
        Txf_Name.setText("");
        Txf_Phone.setText("");
        Txf_debt.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Add;
    private javax.swing.JButton Button_Delete;
    private javax.swing.JButton Button_Update;
    private javax.swing.JButton Button__Search;
    private javax.swing.JLabel Label_Addre;
    private javax.swing.JLabel Label_Background;
    private javax.swing.JLabel Label_Email;
    private javax.swing.JLabel Label_Header;
    private javax.swing.JLabel Label_Name;
    private javax.swing.JLabel Label_Phone;
    private javax.swing.JLabel Label_debt;
    private javax.swing.JTable Table_Bill;
    private javax.swing.JTable Table_Customer;
    private javax.swing.JTextField Txf_Addre;
    private javax.swing.JTextField Txf_Email;
    private javax.swing.JTextField Txf_Name;
    private javax.swing.JTextField Txf_Phone;
    private javax.swing.JTextField Txf_Search;
    private javax.swing.JTextField Txf_debt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

