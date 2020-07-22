
package View;

import Controller.BookController;
import Model.Book;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;


public class FBook extends javax.swing.JPanel {
    BookController Controller=new BookController(); 
    private static FBook instance=null;
    
    private void loadTable() {
        Controller.loadTable(table_book);
    }

    private void loadCBBCategory() {
        Controller.loadCBBCategory(Cbb_Category);
        Cbb_Category.setSelectedIndex(-1);
    }

    private void loadCBBAuthor() {
        Controller.loadCBBAuthor(Cbb_Author);
        Cbb_Author.setSelectedIndex(-1);
        TxA_Authors.setText("");
    }
    
    public void reload(){
        loadCBBCategory();
        loadCBBAuthor();
        loadTable();
    }
    
    public FBook() {
        initComponents();
        reload();
        this.setSize(790, 630);
    }
    public static FBook getInstance(){
        if(instance==null)
            instance=new FBook();
        return instance;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Txf_Bookname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Cbb_Category = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_book = new javax.swing.JTable();
        Button_Delete = new javax.swing.JButton();
        Button_Search = new javax.swing.JButton();
        Cbb_Author = new javax.swing.JComboBox<>();
        Txf_Search = new javax.swing.JTextField();
        Button_Add = new javax.swing.JButton();
        Txf_PublishCompany = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Txf_PublishYear = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxA_Authors = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        Label_Background = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(790, 630));
        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thông tin sách");
        add(jLabel1);
        jLabel1.setBounds(311, 5, 168, 32);
        add(Txf_Bookname);
        Txf_Bookname.setBounds(100, 60, 230, 28);

        jLabel3.setText("Tên sách");
        add(jLabel3);
        jLabel3.setBounds(50, 60, 50, 30);

        Cbb_Category.setEditable(true);
        Cbb_Category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(Cbb_Category);
        Cbb_Category.setBounds(100, 180, 230, 28);

        jLabel2.setText("Thể loại");
        add(jLabel2);
        jLabel2.setBounds(50, 180, 50, 30);

        jLabel4.setText("Chọn tác giả");
        add(jLabel4);
        jLabel4.setBounds(390, 50, 70, 30);

        table_book.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên sách", "Thể loại", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Số lượng tồn", "Đơn giá nhập"
            }
        ));
        table_book.setRowHeight(40);
        table_book.setSelectionBackground(new java.awt.Color(232, 57, 95));
        table_book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bookMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_book);
        if (table_book.getColumnModel().getColumnCount() > 0) {
            table_book.getColumnModel().getColumn(0).setMaxWidth(35);
            table_book.getColumnModel().getColumn(1).setMaxWidth(35);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(20, 300, 740, 330);

        Button_Delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        Button_Delete.setText("Xóa");
        add(Button_Delete);
        Button_Delete.setBounds(570, 190, 90, 30);

        Button_Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon_Search.png"))); // NOI18N
        Button_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_SearchActionPerformed(evt);
            }
        });
        add(Button_Search);
        Button_Search.setBounds(720, 260, 40, 30);

        Cbb_Author.setEditable(true);
        Cbb_Author.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Cbb_Author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cbb_AuthorActionPerformed(evt);
            }
        });
        add(Cbb_Author);
        Cbb_Author.setBounds(460, 50, 170, 29);
        add(Txf_Search);
        Txf_Search.setBounds(20, 260, 690, 30);

        Button_Add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon_Add.png"))); // NOI18N
        Button_Add.setText("Thêm");
        Button_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AddActionPerformed(evt);
            }
        });
        add(Button_Add);
        Button_Add.setBounds(460, 190, 96, 30);
        add(Txf_PublishCompany);
        Txf_PublishCompany.setBounds(100, 100, 230, 30);

        jLabel5.setText("Nhà Xuất bản");
        add(jLabel5);
        jLabel5.setBounds(20, 100, 80, 30);

        Txf_PublishYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txf_PublishYearActionPerformed(evt);
            }
        });
        add(Txf_PublishYear);
        Txf_PublishYear.setBounds(100, 140, 230, 28);

        jLabel6.setText("Năm xuất bản");
        add(jLabel6);
        jLabel6.setBounds(20, 140, 80, 30);

        jLabel7.setText("Danh sách tác giả");
        add(jLabel7);
        jLabel7.setBounds(360, 90, 100, 30);

        TxA_Authors.setColumns(20);
        TxA_Authors.setRows(5);
        jScrollPane2.setViewportView(TxA_Authors);

        add(jScrollPane2);
        jScrollPane2.setBounds(460, 90, 300, 86);

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(670, 190, 90, 30);

        Label_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Book_Background.jpg"))); // NOI18N
        add(Label_Background);
        Label_Background.setBounds(0, 0, 790, 630);
    }// </editor-fold>//GEN-END:initComponents

    private void Button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AddActionPerformed
       try{ // TODO add your handling code here:
        String name=Txf_Bookname.getText();
        String category=Cbb_Category.getSelectedItem().toString();
        String authors=Cbb_Author.getSelectedItem().toString();
        String publishCompany=Txf_PublishCompany.getText();
        if(name.equals("")|| category.equals("")||authors.equals("")||publishCompany.equals(""))
        {
            JOptionPane.showMessageDialog(FBook.getInstance(), "Bạn nhập thiếu thông tin ! !","Thông báo", JOptionPane.OK_OPTION);
            return;
        }
        int publishYear=Integer.parseInt(Txf_PublishYear.getText());
        if(Controller.addBook(name,category,authors,publishCompany,publishYear))
        {
            JOptionPane.showMessageDialog(FBook.getInstance(), "Thêm sách thành công !","Thông báo", JOptionPane.OK_OPTION);
            loadTable();
        }
        else
        {
            JOptionPane.showMessageDialog(FBook.getInstance(), "Thêm sách thất bại !","Thông báo", JOptionPane.OK_OPTION);
        }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(FBook.getInstance(), "Thêm sách thất bại !","Thông báo", JOptionPane.OK_OPTION);
       }
    }//GEN-LAST:event_Button_AddActionPerformed

    private void Txf_PublishYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txf_PublishYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txf_PublishYearActionPerformed

    private void Cbb_AuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cbb_AuthorActionPerformed
        if(Cbb_Author.getSelectedIndex()!=-1)
            if(!TxA_Authors.getText().contains(Cbb_Author.getSelectedItem().toString()))
                TxA_Authors.setText(TxA_Authors.getText()+Cbb_Author.getSelectedItem().toString()+"-");
    }//GEN-LAST:event_Cbb_AuthorActionPerformed

    private void Button_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_SearchActionPerformed
        // TODO add your handling code here:
        Controller.searchBook(Txf_Search.getText(),table_book);
    }//GEN-LAST:event_Button_SearchActionPerformed

    private void table_bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bookMouseClicked
        // TODO add your handling code here:
        Book bookChosen = new Book();
        bookChosen = Controller.getBookByID(table_book.getModel().getValueAt(table_book.getSelectedRow(), 1).toString());
        FBookInfo a = FBookInfo.getInstance();
        a.setBook(bookChosen);
        a.reload();
        a.setVisible(true);
    }//GEN-LAST:event_table_bookMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reload();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_Add;
    private javax.swing.JButton Button_Delete;
    private javax.swing.JButton Button_Search;
    private javax.swing.JComboBox<String> Cbb_Author;
    private javax.swing.JComboBox<String> Cbb_Category;
    private javax.swing.JLabel Label_Background;
    private javax.swing.JTextArea TxA_Authors;
    private javax.swing.JTextField Txf_Bookname;
    private javax.swing.JTextField Txf_PublishCompany;
    private javax.swing.JTextField Txf_PublishYear;
    private javax.swing.JTextField Txf_Search;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable table_book;
    // End of variables declaration//GEN-END:variables
}
