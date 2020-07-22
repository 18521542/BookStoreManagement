
package View;

import Controller.CustomerController;
import Controller.PaymentController;
import Model.Customer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class FCashReceive extends javax.swing.JPanel {

    Customer customer = null;
    PaymentController paymentController = new PaymentController();
    CustomerController customerController = new CustomerController();
    private void loadDate() {
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date();
        date.getTime();
        Txf_Date.setText(df.format(date));
    }
    public FCashReceive() {
        initComponents();
        this.setSize(790, 630);
        customerController.loadCustomer(Table_Customer);
        loadDate();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Txf_Money = new javax.swing.JTextField();
        Button_Receive = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Customer = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        Txf_owe = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Button_Refresh = new javax.swing.JButton();
        Txf_Name = new javax.swing.JTextField();
        Txf_Rest = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        Txf_Date = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        Label_Background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 0));
        setPreferredSize(new java.awt.Dimension(790, 630));
        setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lập phiếu thu tiền");
        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(280, 30, 250, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 0, 255));
        jLabel6.setText("Tên khách hàng");
        add(jLabel6);
        jLabel6.setBounds(30, 110, 90, 30);

        Txf_Money.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txf_MoneyKeyTyped(evt);
            }
        });
        add(Txf_Money);
        Txf_Money.setBounds(120, 230, 230, 29);

        Button_Receive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/paymentAdd.png"))); // NOI18N
        Button_Receive.setText("Thu");
        Button_Receive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_ReceiveActionPerformed(evt);
            }
        });
        add(Button_Receive);
        Button_Receive.setBounds(250, 390, 100, 30);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

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
        Table_Customer.setRowHeight(40);
        Table_Customer.setSelectionBackground(new java.awt.Color(232, 57, 95));
        Table_Customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_CustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Customer);
        if (Table_Customer.getColumnModel().getColumnCount() > 0) {
            Table_Customer.getColumnModel().getColumn(0).setMaxWidth(45);
            Table_Customer.getColumnModel().getColumn(1).setMaxWidth(45);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(360, 110, 430, 310);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 0, 255));
        jLabel11.setText("Tiền nợ");
        add(jLabel11);
        jLabel11.setBounds(70, 170, 50, 30);

        Txf_owe.setEditable(false);
        add(Txf_owe);
        Txf_owe.setBounds(120, 170, 230, 29);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 0, 255));
        jLabel12.setText("Ngày lập");
        add(jLabel12);
        jLabel12.setBounds(60, 340, 60, 30);

        Button_Refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        Button_Refresh.setText("Refresh");
        Button_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RefreshActionPerformed(evt);
            }
        });
        add(Button_Refresh);
        Button_Refresh.setBounds(120, 390, 110, 30);
        add(Txf_Name);
        Txf_Name.setBounds(120, 110, 230, 30);

        Txf_Rest.setEditable(false);
        add(Txf_Rest);
        Txf_Rest.setBounds(120, 280, 230, 30);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 0, 255));
        jLabel13.setText("Nhập số tiền thu");
        add(jLabel13);
        jLabel13.setBounds(20, 230, 100, 30);

        Txf_Date.setEditable(false);
        add(Txf_Date);
        Txf_Date.setBounds(120, 340, 230, 30);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 0, 255));
        jLabel14.setText("Còn lại");
        add(jLabel14);
        jLabel14.setBounds(70, 280, 50, 30);

        Label_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Payment_Background.jpg"))); // NOI18N
        add(Label_Background);
        Label_Background.setBounds(0, 0, 790, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void Table_CustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_CustomerMouseClicked
        String id = Table_Customer.getModel().getValueAt(Table_Customer.getSelectedRow(), 1).toString();
        customer = customerController.getCustomerByID(id);
        String money = String.valueOf(customer.owe());
        Txf_Name.setText(customer.name());
        Txf_Rest.setText("");
        Txf_owe.setText(money);
    }//GEN-LAST:event_Table_CustomerMouseClicked

    private void Button_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RefreshActionPerformed
        customerController.loadCustomer(Table_Customer);
        loadDate();
        Txf_Money.setText("");
        Txf_Name.setText("");
        Txf_Rest.setText("");
        Txf_owe.setText("");
        
    }//GEN-LAST:event_Button_RefreshActionPerformed

    private void Txf_MoneyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txf_MoneyKeyTyped
        // rest = own - moneyReceive
        try{
            float moneyReceive=Float.parseFloat(Txf_Money.getText());
            float own = Float.parseFloat(Txf_owe.getText());
            Txf_Rest.setText(String.valueOf(own-moneyReceive));
        }catch(Exception e){
             //do nothing
        }
    }//GEN-LAST:event_Txf_MoneyKeyTyped

    private void Button_ReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_ReceiveActionPerformed
        // TODO add your handling code here:
        String date = Txf_Date.getText();
        String money = Txf_Money.getText();
        String customerID = customer.id();
       try{
            if(paymentController.AddPayment(date, money, customerID)){
                JOptionPane.showMessageDialog(null, "Thêm phiếu thu tiền thành công");
            }
            else{
                JOptionPane.showMessageDialog(null, "Thêm phiếu thu tiền thất bại");
            }
        } catch (ParseException ex) {
            Logger.getLogger(FCashReceive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Button_ReceiveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Receive;
    private javax.swing.JButton Button_Refresh;
    private javax.swing.JLabel Label_Background;
    private javax.swing.JTable Table_Customer;
    private javax.swing.JTextField Txf_Date;
    private javax.swing.JTextField Txf_Money;
    private javax.swing.JTextField Txf_Name;
    private javax.swing.JTextField Txf_Rest;
    private javax.swing.JTextField Txf_owe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
