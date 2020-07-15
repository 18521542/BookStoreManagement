
package View;

import Controller.AuthorController;
import Controller.CategoryController;
import java.awt.Color;
import javax.swing.JOptionPane;


public class FCategoryAndAuthor extends javax.swing.JPanel {
    AuthorController authorController=new AuthorController();
    CategoryController categoryController = new CategoryController();
    public FCategoryAndAuthor() {
        initComponents();
        this.setSize(790, 630);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_Head = new javax.swing.JLabel();
        Panel_Author = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Author = new javax.swing.JTable();
        Txf_AddAuthor = new javax.swing.JTextField();
        Txf_SearchAuthor = new javax.swing.JTextField();
        Label_SearchAuthor = new javax.swing.JLabel();
        Button_AddAuthor = new javax.swing.JButton();
        Button_RefreshAuthor = new javax.swing.JButton();
        Panel_Category = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Table_Category = new javax.swing.JTable();
        Txf_AddCategory = new javax.swing.JTextField();
        Txf_SearchCategory = new javax.swing.JTextField();
        Label_SearchCategory = new javax.swing.JLabel();
        Button_AddCategory = new javax.swing.JButton();
        Button_RefreshCategory = new javax.swing.JButton();
        Label_Head1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(790, 630));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Label_Head.setBackground(new java.awt.Color(255, 204, 204));
        Label_Head.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Label_Head.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Head.setText("Tác giả");
        Label_Head.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Label_Head.setOpaque(true);
        add(Label_Head, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 390, 70));

        Panel_Author.setBackground(new java.awt.Color(51, 204, 255));

        Table_Author.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã tác giả", "Tên tác giả"
            }
        ));
        jScrollPane1.setViewportView(Table_Author);

        Txf_AddAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txf_AddAuthorActionPerformed(evt);
            }
        });

        Label_SearchAuthor.setBackground(new java.awt.Color(255, 255, 255));
        Label_SearchAuthor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_SearchAuthor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon_Search.png"))); // NOI18N
        Label_SearchAuthor.setOpaque(true);
        Label_SearchAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_SearchAuthorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label_SearchAuthorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label_SearchAuthorMouseExited(evt);
            }
        });

        Button_AddAuthor.setText("Thêm");
        Button_AddAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AddAuthorActionPerformed(evt);
            }
        });

        Button_RefreshAuthor.setText("Refresh");
        Button_RefreshAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RefreshAuthorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_AuthorLayout = new javax.swing.GroupLayout(Panel_Author);
        Panel_Author.setLayout(Panel_AuthorLayout);
        Panel_AuthorLayout.setHorizontalGroup(
            Panel_AuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_AuthorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_AuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(Panel_AuthorLayout.createSequentialGroup()
                        .addComponent(Txf_AddAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_AddAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                    .addGroup(Panel_AuthorLayout.createSequentialGroup()
                        .addComponent(Txf_SearchAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_SearchAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_AuthorLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Button_RefreshAuthor)))
                .addContainerGap())
        );
        Panel_AuthorLayout.setVerticalGroup(
            Panel_AuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_AuthorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_AuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txf_AddAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_AddAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_AuthorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txf_SearchAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_SearchAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_RefreshAuthor, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(Panel_Author, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 70, 390, 560));

        Panel_Category.setBackground(new java.awt.Color(51, 204, 255));

        Table_Category.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã thể loại", "Tên thể loại"
            }
        ));
        jScrollPane3.setViewportView(Table_Category);

        Txf_AddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txf_AddCategoryActionPerformed(evt);
            }
        });

        Label_SearchCategory.setBackground(new java.awt.Color(255, 255, 255));
        Label_SearchCategory.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_SearchCategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Icon_Search.png"))); // NOI18N
        Label_SearchCategory.setOpaque(true);
        Label_SearchCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_SearchCategoryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Label_SearchCategoryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Label_SearchCategoryMouseExited(evt);
            }
        });

        Button_AddCategory.setText("Thêm");
        Button_AddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AddCategoryActionPerformed(evt);
            }
        });

        Button_RefreshCategory.setText("Refresh");
        Button_RefreshCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_RefreshCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_CategoryLayout = new javax.swing.GroupLayout(Panel_Category);
        Panel_Category.setLayout(Panel_CategoryLayout);
        Panel_CategoryLayout.setHorizontalGroup(
            Panel_CategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_CategoryLayout.createSequentialGroup()
                .addGroup(Panel_CategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_CategoryLayout.createSequentialGroup()
                        .addComponent(Txf_AddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Button_AddCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel_CategoryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(Panel_CategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(Panel_CategoryLayout.createSequentialGroup()
                                .addComponent(Txf_SearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Label_SearchCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_CategoryLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Button_RefreshCategory)))
                .addContainerGap())
        );
        Panel_CategoryLayout.setVerticalGroup(
            Panel_CategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_CategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_CategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Txf_AddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_AddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_CategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Txf_SearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_SearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_RefreshCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(Panel_Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 390, 560));

        Label_Head1.setBackground(new java.awt.Color(255, 51, 51));
        Label_Head1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Label_Head1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Head1.setText("Thể loại");
        Label_Head1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Label_Head1.setOpaque(true);
        add(Label_Head1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 70));
    }// </editor-fold>//GEN-END:initComponents

    //coder defined
    private void loadTableAuthor() {
        authorController.getAuthor(Table_Author);    
    }
    private void loadTableCategory() {
        categoryController.getCategory(Table_Category);    
    }
    private void Txf_AddAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txf_AddAuthorActionPerformed

    }//GEN-LAST:event_Txf_AddAuthorActionPerformed

    private void Txf_AddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txf_AddCategoryActionPerformed
        
    }//GEN-LAST:event_Txf_AddCategoryActionPerformed

    private void Label_SearchCategoryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_SearchCategoryMouseEntered
        Label_SearchCategory.setBackground(Color.GRAY);
    }//GEN-LAST:event_Label_SearchCategoryMouseEntered

    private void Label_SearchAuthorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_SearchAuthorMouseEntered
        Label_SearchAuthor.setBackground(Color.GRAY);
    }//GEN-LAST:event_Label_SearchAuthorMouseEntered

    private void Label_SearchCategoryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_SearchCategoryMouseExited
        Label_SearchCategory.setBackground(Color.WHITE);
    }//GEN-LAST:event_Label_SearchCategoryMouseExited

    private void Label_SearchAuthorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_SearchAuthorMouseExited
        Label_SearchAuthor.setBackground(Color.WHITE);
    }//GEN-LAST:event_Label_SearchAuthorMouseExited

    private void Button_AddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AddCategoryActionPerformed
        String CategoryName = Txf_AddCategory.getText();
        if(categoryController.AddCategory(CategoryName)){
            JOptionPane.showMessageDialog(this, "Thêm thể loại thành công");
            loadTableCategory();
        }
        else {
            JOptionPane.showMessageDialog(this, "Thêm thể loại thất bại");
        }
    }//GEN-LAST:event_Button_AddCategoryActionPerformed

    private void Label_SearchCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_SearchCategoryMouseClicked
        // TODO add your handling code here:
        categoryController.SearchCategory(Table_Category, Txf_SearchCategory.getSelectedText());
    }//GEN-LAST:event_Label_SearchCategoryMouseClicked

    private void Button_AddAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AddAuthorActionPerformed
        String AuthorName = Txf_AddAuthor.getText();
        if(authorController.AddAuthor(AuthorName)){
            JOptionPane.showMessageDialog(this, "Thêm tác giả thành công");
            loadTableAuthor();
        }
        else {
            JOptionPane.showMessageDialog(this, "Thêm tác giả thất bại");
        }
    }//GEN-LAST:event_Button_AddAuthorActionPerformed

    private void Button_RefreshAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RefreshAuthorActionPerformed
        // TODO add your handling code here:
        loadTableAuthor();
    }//GEN-LAST:event_Button_RefreshAuthorActionPerformed

    private void Label_SearchAuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_SearchAuthorMouseClicked
        // TODO add your handling code here:
        authorController.SearchAuthor(Table_Author,Txf_SearchAuthor.getText());
    }//GEN-LAST:event_Label_SearchAuthorMouseClicked

    private void Button_RefreshCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_RefreshCategoryActionPerformed
        // TODO add your handling code here:
        loadTableCategory();
    }//GEN-LAST:event_Button_RefreshCategoryActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_AddAuthor;
    private javax.swing.JButton Button_AddCategory;
    private javax.swing.JButton Button_RefreshAuthor;
    private javax.swing.JButton Button_RefreshCategory;
    private javax.swing.JLabel Label_Head;
    private javax.swing.JLabel Label_Head1;
    private javax.swing.JLabel Label_SearchAuthor;
    private javax.swing.JLabel Label_SearchCategory;
    private javax.swing.JPanel Panel_Author;
    private javax.swing.JPanel Panel_Category;
    private javax.swing.JTable Table_Author;
    private javax.swing.JTable Table_Category;
    private javax.swing.JTextField Txf_AddAuthor;
    private javax.swing.JTextField Txf_AddCategory;
    private javax.swing.JTextField Txf_SearchAuthor;
    private javax.swing.JTextField Txf_SearchCategory;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
