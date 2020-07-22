
package View;

import Controller.BookController;
import Model.Book;
import controller.ImportBookController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FImportBook extends javax.swing.JPanel {
    BookController bookController = new BookController();
    ImportBookController importBookController = new ImportBookController();
    private Book bookChosen = null;
   
    public FImportBook() {
        initComponents();
        reload();
        loadTable();
        this.setSize(790, 630);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Txf_Date = new javax.swing.JTextField();
        Button_Add = new javax.swing.JButton();
        Button_Search = new javax.swing.JButton();
        Button_Remove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Book = new javax.swing.JTable();
        Txf_Value = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Button_Save = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_ImportBook = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        sp_Number = new javax.swing.JSpinner();
        sp_Price = new javax.swing.JSpinner();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        Txf_BookChosen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Txf_Total = new javax.swing.JTextField();
        Button_New = new javax.swing.JButton();
        Label_Background = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 255, 102));
        setPreferredSize(new java.awt.Dimension(790, 630));
        setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lập phiếu nhập sách");
        add(jLabel1);
        jLabel1.setBounds(260, 0, 240, 40);

        jLabel4.setText("Ngày nhập");
        add(jLabel4);
        jLabel4.setBounds(10, 60, 70, 40);

        Txf_Date.setEditable(false);
        add(Txf_Date);
        Txf_Date.setBounds(80, 60, 230, 40);

        Button_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bookAdd.png"))); // NOI18N
        Button_Add.setText("Thêm");
        Button_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AddActionPerformed(evt);
            }
        });
        add(Button_Add);
        Button_Add.setBounds(670, 550, 110, 30);

        Button_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon_Search.png"))); // NOI18N
        Button_Search.setText("Tìm kiếm");
        add(Button_Search);
        Button_Search.setBounds(670, 290, 109, 32);

        Button_Remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        Button_Remove.setText("Xóa");
        Button_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RemoveActionPerformed(evt);
            }
        });
        add(Button_Remove);
        Button_Remove.setBounds(680, 200, 100, 30);

        Table_Book.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên sách", "Thể loại", "Tác giả", "Nhà xuất bản", "Năm xuất bản"
            }
        ));
        Table_Book.setRowHeight(40);
        Table_Book.setSelectionBackground(new java.awt.Color(232, 57, 95));
        Table_Book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_BookMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Table_Book);
        if (Table_Book.getColumnModel().getColumnCount() > 0) {
            Table_Book.getColumnModel().getColumn(0).setMaxWidth(40);
            Table_Book.getColumnModel().getColumn(1).setMaxWidth(40);
            Table_Book.getColumnModel().getColumn(5).setMaxWidth(40);
        }

        add(jScrollPane2);
        jScrollPane2.setBounds(10, 330, 770, 210);

        Txf_Value.setEditable(false);
        add(Txf_Value);
        Txf_Value.setBounds(80, 150, 230, 40);

        jLabel8.setText("Nhập đơn giá");
        add(jLabel8);
        jLabel8.setBounds(10, 590, 90, 30);

        jLabel13.setBackground(new java.awt.Color(255, 204, 51));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Chọn sách");
        jLabel13.setOpaque(true);
        add(jLabel13);
        jLabel13.setBounds(10, 250, 238, 30);

        Button_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/importAdd.png"))); // NOI18N
        Button_Save.setText("Lưu");
        Button_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SaveActionPerformed(evt);
            }
        });
        add(Button_Save);
        Button_Save.setBounds(210, 200, 100, 30);

        Table_ImportBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên sách", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ));
        Table_ImportBook.setGridColor(new java.awt.Color(51, 255, 255));
        Table_ImportBook.setSelectionBackground(new java.awt.Color(232, 57, 95));
        jScrollPane1.setViewportView(Table_ImportBook);

        add(jScrollPane1);
        jScrollPane1.setBounds(330, 60, 450, 130);

        jLabel9.setText("Tổng tiền");
        add(jLabel9);
        jLabel9.setBounds(20, 150, 60, 40);

        jLabel10.setText("Nhập số lượng");
        add(jLabel10);
        jLabel10.setBounds(230, 590, 78, 30);
        add(jTextField1);
        jTextField1.setBounds(10, 290, 650, 30);

        sp_Number.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sp_NumberStateChanged(evt);
            }
        });
        add(sp_Number);
        sp_Number.setBounds(320, 590, 110, 30);

        sp_Price.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sp_PriceStateChanged(evt);
            }
        });
        add(sp_Price);
        sp_Price.setBounds(100, 590, 110, 30);

        jSeparator1.setBackground(new java.awt.Color(204, 204, 0));
        jSeparator1.setForeground(new java.awt.Color(204, 204, 0));
        jSeparator1.setOpaque(true);
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        add(jSeparator1);
        jSeparator1.setBounds(10, 240, 770, 5);

        jLabel2.setText("Sách đã chọn");
        add(jLabel2);
        jLabel2.setBounds(10, 550, 90, 30);
        add(Txf_BookChosen);
        Txf_BookChosen.setBounds(100, 550, 560, 30);

        jLabel3.setText("Thành tiền");
        add(jLabel3);
        jLabel3.setBounds(460, 590, 60, 30);
        add(Txf_Total);
        Txf_Total.setBounds(530, 590, 130, 30);

        Button_New.setText("Tạo mới");
        Button_New.setMaximumSize(new java.awt.Dimension(84, 36));
        Button_New.setMinimumSize(new java.awt.Dimension(84, 36));
        Button_New.setPreferredSize(new java.awt.Dimension(84, 36));
        Button_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_NewActionPerformed(evt);
            }
        });
        add(Button_New);
        Button_New.setBounds(80, 200, 100, 30);

        Label_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Import_Background.jpg"))); // NOI18N
        add(Label_Background);
        Label_Background.setBounds(0, 0, 790, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void Button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AddActionPerformed
        // TODO add your handling code here:
        String name=bookChosen.name();
        String id=bookChosen.id();
        int count= (int)sp_Number.getValue();
        int price=(int)sp_Price.getValue();
        int total=Integer.parseInt(Txf_Total.getText());
        if(checkContain()==-1)
        {
            Object[] row=new Object[]{
            String.valueOf(Table_ImportBook.getRowCount()+1),
            id,
            name,
            count,
            price,
            total
            };
            DefaultTableModel model = (DefaultTableModel) Table_ImportBook.getModel();
            model.addRow(row);
        }
        else
        {
            int rowIndex=checkContain();
            int countTable=Integer.parseInt(Table_ImportBook.getModel().getValueAt(rowIndex, 3).toString())+(int)sp_Number.getValue();
            int priceTable=(int)sp_Price.getValue();
            int totalTable=countTable*priceTable;
            Table_ImportBook.getModel().setValueAt(countTable, rowIndex, 3);
            Table_ImportBook.getModel().setValueAt(priceTable, rowIndex, 4);
            Table_ImportBook.getModel().setValueAt(totalTable, rowIndex, 5);
        }
        
        int value=0;
        for(int i=0;i<Table_ImportBook.getRowCount();i++)
            value+=Integer.parseInt(Table_ImportBook.getModel().getValueAt(i, 5).toString());
        Txf_Value.setText(String.valueOf(value));
    }//GEN-LAST:event_Button_AddActionPerformed

    private void Table_BookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_BookMouseClicked
        // TODO add your handling code here:
        bookChosen = bookController.getBookByID(Table_Book.getModel().getValueAt(Table_Book.getSelectedRow(), 1).toString());
        Txf_BookChosen.setText(bookChosen.name());
    }//GEN-LAST:event_Table_BookMouseClicked

    private void sp_PriceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sp_PriceStateChanged
        // TODO add your handling code here:
        if((int)sp_Price.getValue()<0)
            sp_Price.setValue(0);
        int total=(int)sp_Number.getValue()*(int)sp_Price.getValue();
        Txf_Total.setText(String.valueOf(total));
    }//GEN-LAST:event_sp_PriceStateChanged

    private void sp_NumberStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sp_NumberStateChanged
        // TODO add your handling code here:
        if((int)sp_Number.getValue()<0)
            sp_Number.setValue(0);
        int total=(int)sp_Number.getValue()*(int)sp_Price.getValue();
        Txf_Total.setText(String.valueOf(total));
    }//GEN-LAST:event_sp_NumberStateChanged

    private void Button_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RemoveActionPerformed
        // TODO add your handling code here:
        try{
            ((DefaultTableModel)Table_ImportBook.getModel()).removeRow(Table_ImportBook.getSelectedRow());
            for(int i=0;i<Table_ImportBook.getRowCount();i++)
                Table_ImportBook.getModel().setValueAt(i+1,i,0);
        }catch(Exception e){           
        }
        
        int value=0;
        for(int i=0;i<Table_ImportBook.getRowCount();i++)
            value+=Integer.parseInt(Table_ImportBook.getModel().getValueAt(i, 5).toString());
        Txf_Value.setText(String.valueOf(value));
    }//GEN-LAST:event_Button_RemoveActionPerformed

    private void Button_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SaveActionPerformed
        // TODO add your handling code here:
        int rowCount=Table_ImportBook.getRowCount();
        String[][]data=new String[rowCount][4];
        for(int i=0;i<rowCount;i++)
        {
            data[i][0]=Table_ImportBook.getModel().getValueAt(i, 1).toString();
            data[i][1]=Table_ImportBook.getModel().getValueAt(i, 3).toString();
            data[i][2]=Table_ImportBook.getModel().getValueAt(i, 4).toString();
            data[i][3]=Table_ImportBook.getModel().getValueAt(i, 5).toString();
        }
        String date=Txf_Date.getText();
        String value=Txf_Value.getText();
        try {
            if(importBookController.AddImportBook(data,date,value))
            {
                JOptionPane.showMessageDialog(null, "Lưu phiếu nhập thành công !","Thông báo", JOptionPane.OK_OPTION);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Lưu phiếu nhập thất bại !","Thông báo", JOptionPane.OK_OPTION);
                
            }
        } catch (ParseException ex) {
            Logger.getLogger(FImportBook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FImportBook.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_Button_SaveActionPerformed

    private void Button_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_NewActionPerformed
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_Button_NewActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Add;
    private javax.swing.JButton Button_New;
    private javax.swing.JButton Button_Remove;
    private javax.swing.JButton Button_Save;
    private javax.swing.JButton Button_Search;
    private javax.swing.JLabel Label_Background;
    private javax.swing.JTable Table_Book;
    private javax.swing.JTable Table_ImportBook;
    private javax.swing.JTextField Txf_BookChosen;
    private javax.swing.JTextField Txf_Date;
    private javax.swing.JTextField Txf_Total;
    private javax.swing.JTextField Txf_Value;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JSpinner sp_Number;
    private javax.swing.JSpinner sp_Price;
    // End of variables declaration//GEN-END:variables

    private void reload() {
        sp_Number.setValue(0);
        sp_Price.setValue(0);
        Txf_Total.setText("0");
        Txf_Value.setText("0");
        loadDate(Txf_Date);
        Table_ImportBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"STT", "Mã sách", "Tên sách", "Số lượng", "Đơn giá", "Thành tiền"}
        )
        {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_ImportBook);
        loadTable();
    }
    private void loadTable() {
        bookController.loadTable(Table_Book);
    }
    private void loadDate(JTextField txfDate) {
        SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date();
        date.getTime();
        txfDate.setText(df.format(date));
    }
    private int checkContain(){
        String id=bookChosen.id();
        for(int i=0;i<Table_ImportBook.getRowCount();i++)
        {
            //String k = Table_ImportBook.getModel().getValueAt(i, 1).toString();
            if(Table_ImportBook.getModel().getValueAt(i, 1).toString().equals(id))
                return i;
        }
        return -1;
    }
}
