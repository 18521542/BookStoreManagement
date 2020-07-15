
package View;

import Controller.BillController;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Fbill extends javax.swing.JPanel {
    BillController Controller=new BillController();
    public Fbill() {
        initComponents();
        this.setSize(790, 630);
        reload();
    }
    
    //Coder defined
    public void reload() {
        loadCustomer();
        loadDate();
        loadBook();
        
        Txf_Total.setText("0");
        Txf_MoneyReceive.setText("0");
        Txf_MoneyChange.setText("0");
        sp_Count.setValue(0);
        Txf_Search.setText("");
        
        Table_Bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Số lượng", "Giá bán", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table_Bill);
    }
    private void loadCustomer() {
        Controller.loadCustomer(Cbb_Customer);
        Cbb_Customer.setSelectedIndex(-1);
    }
    private void loadDate() {
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date();
        date.getTime();
        Txf_Date.setText(df.format(date));
    }
    private int checkContain(){
        String id=Table_BookOpTion.getModel().getValueAt(Table_BookOpTion.getSelectedRow(),1).toString();
        for(int i=0;i<Table_Bill.getRowCount();i++)
        {
            if(Table_Bill.getModel().getValueAt(i, 1).toString().equals(id))
                return i;
        }
        return -1;
    }
    private void loadBook() {
        Controller.loadBook(Table_BookOpTion);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_ChooseBook = new javax.swing.JLabel();
        Label_Customer = new javax.swing.JLabel();
        Cbb_Customer = new javax.swing.JComboBox<>();
        Label_Date = new javax.swing.JLabel();
        Txf_Date = new javax.swing.JTextField();
        Label_Total = new javax.swing.JLabel();
        Txf_Total = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Bill = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Button_Save = new javax.swing.JButton();
        Button_Add = new javax.swing.JButton();
        Txf_Search = new javax.swing.JTextField();
        Button_Search = new javax.swing.JButton();
        Button_Remove = new javax.swing.JButton();
        Txf_MoneyReceive = new javax.swing.JTextField();
        Txf_MoneyChange = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        sp_Count = new javax.swing.JSpinner();
        Button_New = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_BookOpTion = new javax.swing.JTable();
        Label_Background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 153, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        setPreferredSize(new java.awt.Dimension(790, 630));
        setLayout(null);

        Label_ChooseBook.setBackground(new java.awt.Color(255, 102, 153));
        Label_ChooseBook.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Label_ChooseBook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_ChooseBook.setText("Chọn sách");
        Label_ChooseBook.setOpaque(true);
        add(Label_ChooseBook);
        Label_ChooseBook.setBounds(340, 290, 120, 25);

        Label_Customer.setText("Khách hàng");
        add(Label_Customer);
        Label_Customer.setBounds(20, 50, 70, 30);

        Cbb_Customer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(Cbb_Customer);
        Cbb_Customer.setBounds(90, 50, 270, 30);

        Label_Date.setText("Ngày hóa đơn");
        add(Label_Date);
        Label_Date.setBounds(10, 90, 80, 30);

        Txf_Date.setEditable(false);
        add(Txf_Date);
        Txf_Date.setBounds(90, 90, 270, 30);

        Label_Total.setText("Tổng tiền");
        add(Label_Total);
        Label_Total.setBounds(30, 130, 60, 30);

        Txf_Total.setEditable(false);
        add(Txf_Total);
        Txf_Total.setBounds(90, 130, 270, 30);

        jSeparator1.setBackground(new java.awt.Color(0, 51, 255));
        jSeparator1.setForeground(new java.awt.Color(204, 255, 255));
        add(jSeparator1);
        jSeparator1.setBounds(20, 280, 760, 10);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setText("Danh sách sách mua");
        add(jLabel1);
        jLabel1.setBounds(530, 30, 110, 13);

        Table_Bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên", "Đơn giá", "SL", "Thành tiền"
            }
        ));
        jScrollPane2.setViewportView(Table_Bill);
        if (Table_Bill.getColumnModel().getColumnCount() > 0) {
            Table_Bill.getColumnModel().getColumn(0).setMaxWidth(35);
            Table_Bill.getColumnModel().getColumn(1).setMaxWidth(35);
            Table_Bill.getColumnModel().getColumn(4).setMaxWidth(35);
        }

        add(jScrollPane2);
        jScrollPane2.setBounds(370, 50, 410, 190);

        jLabel3.setBackground(new java.awt.Color(255, 204, 204));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Hóa đơn");
        jLabel3.setOpaque(true);
        add(jLabel3);
        jLabel3.setBounds(340, 0, 120, 32);

        jLabel4.setText("Nhập số lượng");
        add(jLabel4);
        jLabel4.setBounds(450, 590, 80, 30);

        Button_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/billAdd.png"))); // NOI18N
        Button_Save.setText("Lưu");
        Button_Save.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        Button_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SaveActionPerformed(evt);
            }
        });
        add(Button_Save);
        Button_Save.setBounds(280, 250, 84, 30);

        Button_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bookAdd.png"))); // NOI18N
        Button_Add.setText("Chọn");
        Button_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AddActionPerformed(evt);
            }
        });
        add(Button_Add);
        Button_Add.setBounds(690, 590, 100, 30);
        add(Txf_Search);
        Txf_Search.setBounds(130, 320, 410, 30);

        Button_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bookSearch.png"))); // NOI18N
        Button_Search.setText("Tìm kiếm");
        Button_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SearchActionPerformed(evt);
            }
        });
        add(Button_Search);
        Button_Search.setBounds(550, 320, 113, 30);

        Button_Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        Button_Remove.setText("Xóa sách");
        Button_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RemoveActionPerformed(evt);
            }
        });
        add(Button_Remove);
        Button_Remove.setBounds(670, 250, 111, 30);

        Txf_MoneyReceive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txf_MoneyReceiveActionPerformed(evt);
            }
        });
        Txf_MoneyReceive.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                Txf_MoneyReceiveKeyTyped(evt);
            }
        });
        add(Txf_MoneyReceive);
        Txf_MoneyReceive.setBounds(90, 170, 270, 30);

        Txf_MoneyChange.setEditable(false);
        add(Txf_MoneyChange);
        Txf_MoneyChange.setBounds(91, 210, 270, 30);

        jLabel2.setText("Số tiền nhận");
        add(jLabel2);
        jLabel2.setBounds(17, 170, 70, 30);

        jLabel5.setText("Còn lại");
        add(jLabel5);
        jLabel5.setBounds(47, 210, 40, 30);
        add(sp_Count);
        sp_Count.setBounds(540, 590, 130, 30);

        Button_New.setText("Tạo mới");
        Button_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_NewActionPerformed(evt);
            }
        });
        add(Button_New);
        Button_New.setBounds(180, 250, 80, 30);

        Table_BookOpTion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane3.setViewportView(Table_BookOpTion);

        add(jScrollPane3);
        jScrollPane3.setBounds(0, 360, 790, 230);

        Label_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Bill_Background.jpg"))); // NOI18N
        add(Label_Background);
        Label_Background.setBounds(0, 0, 790, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void Button_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SearchActionPerformed
        // TODO add your handling code here:
        Controller.searchBook(Txf_Search.getText(),Table_BookOpTion);
    }//GEN-LAST:event_Button_SearchActionPerformed

    
    private void Button_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RemoveActionPerformed
        try{
            ((DefaultTableModel)Table_Bill.getModel()).removeRow(Table_Bill.getSelectedRow());
            for(int i=0;i<Table_Bill.getRowCount();i++)
                Table_Bill.getModel().setValueAt(i+1,i,0);
        }catch(Exception e){           
        }
        
        float value=0;
        for(int i=0;i<Table_Bill.getRowCount();i++)
            value+=Float.parseFloat(Table_Bill.getModel().getValueAt(i, 5).toString());
        Txf_Total.setText(String.valueOf(value));
        
        float moneyReceive=Float.parseFloat(Txf_MoneyReceive.getText());
        Txf_MoneyChange.setText(String.valueOf(Float.parseFloat(Txf_Total.getText())-moneyReceive));
    }//GEN-LAST:event_Button_RemoveActionPerformed

    private void Button_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SaveActionPerformed
        // TODO add your handling code here:
        int rowCount=Table_Bill.getRowCount();
        String[][]data=new String[rowCount][4];
        for(int i=0;i<rowCount;i++)
        {
            data[i][0]=Table_Bill.getModel().getValueAt(i, 1).toString();
            data[i][1]=Table_Bill.getModel().getValueAt(i, 3).toString();
            data[i][2]=Table_Bill.getModel().getValueAt(i, 4).toString();
            data[i][3]=Table_Bill.getModel().getValueAt(i, 5).toString();
        }
        String date=Txf_Date.getText();
        String value=Txf_Total.getText();
        String moneyReceive=Txf_MoneyReceive.getText();
        String moneyChange=Txf_MoneyChange.getText();
        String customerID=Cbb_Customer.getSelectedItem().toString().split(":")[1];
        try {
            if(Controller.AddBill(data,date,value,moneyReceive,moneyChange,customerID))
            {
                JOptionPane.showConfirmDialog(null, "Lưu hóa đơn thành công !","Thông báo", JOptionPane.OK_OPTION);
                loadBook();
            }
            else
            {
                JOptionPane.showConfirmDialog(null, "Lưu hóa đơn thất bại !","Thông báo", JOptionPane.OK_OPTION);
                
            }
        } catch (ParseException ex) {
            //do nothing
        }
    }//GEN-LAST:event_Button_SaveActionPerformed

    private void Button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AddActionPerformed
        // TODO add your handling code here:
        try{
            String name=Table_BookOpTion.getModel().getValueAt(Table_BookOpTion.getSelectedRow(),2).toString();
            String id=Table_BookOpTion.getModel().getValueAt(Table_BookOpTion.getSelectedRow(),1).toString();
            int count= (int)sp_Count.getValue();
            float price=Float.parseFloat(Table_BookOpTion.getModel().getValueAt(Table_BookOpTion.getSelectedRow(),4).toString());
            float total=count*price;
            if(checkContain()==-1)
            {
                Object[] row=new Object[]{
                Table_Bill.getRowCount()+1,
                id,
                name,
                count,
                price,
                total
                };
                DefaultTableModel model = (DefaultTableModel) Table_Bill.getModel();
                model.addRow(row);
            }
            else
            {
                int rowIndex=checkContain();
                int countTable=Integer.parseInt(Table_Bill.getModel().getValueAt(rowIndex, 3).toString())+(int)sp_Count.getValue();
                float priceTable=Float.parseFloat(Table_BookOpTion.getModel().getValueAt(Table_BookOpTion.getSelectedRow(),4).toString());
                float totalTable=countTable*priceTable;
                Table_Bill.getModel().setValueAt(countTable, rowIndex, 3);
                Table_Bill.getModel().setValueAt(priceTable, rowIndex, 4);
                Table_Bill.getModel().setValueAt(totalTable, rowIndex, 5);
            }

            float value=0;
            for(int i=0;i<Table_Bill.getRowCount();i++)
                value+=Float.parseFloat(Table_Bill.getModel().getValueAt(i, 5).toString());
            Txf_Total.setText(String.valueOf(value));
            
            float moneyReceive=Float.parseFloat(Txf_MoneyReceive.getText());
            Txf_MoneyChange.setText(String.valueOf(Float.parseFloat(Txf_Total.getText())- moneyReceive));
        }
        catch(NumberFormatException e){}
    }//GEN-LAST:event_Button_AddActionPerformed

    private void Txf_MoneyReceiveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Txf_MoneyReceiveKeyTyped
        // TODO add your handling code here:
        try{
            float moneyReceive=Float.parseFloat(Txf_MoneyReceive.getText());
            Txf_MoneyChange.setText(String.valueOf(Float.parseFloat(Txf_Total.getText())- moneyReceive));
        }catch(Exception e){
             //do nothing
        }
    }//GEN-LAST:event_Txf_MoneyReceiveKeyTyped

    private void Button_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_NewActionPerformed
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_Button_NewActionPerformed

    private void Txf_MoneyReceiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txf_MoneyReceiveActionPerformed
        
    }//GEN-LAST:event_Txf_MoneyReceiveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Add;
    private javax.swing.JButton Button_New;
    private javax.swing.JButton Button_Remove;
    private javax.swing.JButton Button_Save;
    private javax.swing.JButton Button_Search;
    private javax.swing.JComboBox<String> Cbb_Customer;
    private javax.swing.JLabel Label_Background;
    private javax.swing.JLabel Label_ChooseBook;
    private javax.swing.JLabel Label_Customer;
    private javax.swing.JLabel Label_Date;
    private javax.swing.JLabel Label_Total;
    private javax.swing.JTable Table_Bill;
    private javax.swing.JTable Table_BookOpTion;
    private javax.swing.JTextField Txf_Date;
    private javax.swing.JTextField Txf_MoneyChange;
    private javax.swing.JTextField Txf_MoneyReceive;
    private javax.swing.JTextField Txf_Search;
    private javax.swing.JTextField Txf_Total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner sp_Count;
    // End of variables declaration//GEN-END:variables
}
