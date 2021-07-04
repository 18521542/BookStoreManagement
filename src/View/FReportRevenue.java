
package View;

import Controller.ReportRevenueController;


public class FReportRevenue extends javax.swing.JPanel {

    
    public FReportRevenue() {
        initComponents();
        this.setSize(790, 630);
    }

    ReportRevenueController Controller=new ReportRevenueController();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Revenue = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        sp_Year = new javax.swing.JSpinner();
        sp_Month = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Báo cáo doanh thu");
        jLabel1.setOpaque(true);
        add(jLabel1);
        jLabel1.setBounds(0, 20, 790, 40);

        jLabel2.setText("Tháng");
        add(jLabel2);
        jLabel2.setBounds(20, 100, 40, 30);

        jLabel3.setText("Năm");
        add(jLabel3);
        jLabel3.setBounds(180, 100, 40, 30);

        jScrollPane1.setForeground(new java.awt.Color(232, 57, 95));
        jScrollPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Table_Revenue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Table_Revenue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sách", "Tên sách", "Số lượng bán", "Tổng tiền"
            }
        ));
        Table_Revenue.setRowHeight(40);
        Table_Revenue.setSelectionForeground(new java.awt.Color(232, 57, 95));
        jScrollPane1.setViewportView(Table_Revenue);
        if (Table_Revenue.getColumnModel().getColumnCount() > 0) {
            Table_Revenue.getColumnModel().getColumn(0).setMaxWidth(45);
            Table_Revenue.getColumnModel().getColumn(1).setMaxWidth(45);
        }

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 162, 790, 410);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/reportAdd.png"))); // NOI18N
        jButton1.setText("Xem");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(660, 590, 110, 30);

        sp_Year.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sp_YearStateChanged(evt);
            }
        });
        add(sp_Year);
        sp_Year.setBounds(220, 100, 70, 29);

        sp_Month.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sp_MonthStateChanged(evt);
            }
        });
        add(sp_Month);
        sp_Month.setBounds(60, 100, 70, 29);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Rev_Background.jpg"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(0, 0, 790, 630);

        jButton2.setText("jButton2");
        add(jButton2);
        jButton2.setBounds(540, 590, 90, 25);
    }// </editor-fold>//GEN-END:initComponents

    private void sp_MonthStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sp_MonthStateChanged
        // TODO add your handling code here:
        if(Integer.parseInt(sp_Month.getValue().toString())>12)
            sp_Month.setValue(12);
        else 
            if(Integer.parseInt(sp_Month.getValue().toString())<1)
                sp_Month.setValue(1);
    }//GEN-LAST:event_sp_MonthStateChanged

    private void sp_YearStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sp_YearStateChanged
        // TODO add your handling code here:
        if(Integer.parseInt(sp_Year.getValue().toString())<0)
            sp_Year.setValue(1);
    }//GEN-LAST:event_sp_YearStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Controller.loadRevenue(Table_Revenue,Integer.parseInt(sp_Month.getValue().toString())
                ,Integer.parseInt(sp_Year.getValue().toString()));

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_Revenue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner sp_Month;
    private javax.swing.JSpinner sp_Year;
    // End of variables declaration//GEN-END:variables
}
