/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author HT
 */
public class FOptions extends javax.swing.JPanel implements java.beans.Customizer {
    
    private Object bean;

    /**
     * Creates new customizer FOptions
     */
    public FOptions() {
        initComponents();
    }
    
    public void setObject(Object bean) {
        this.bean = bean;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thay đổi quy định");
        add(jLabel1);
        jLabel1.setBounds(288, 21, 206, 32);

        jLabel2.setText("Lượng nhập tối thiểu");
        add(jLabel2);
        jLabel2.setBounds(286, 116, 95, 13);

        jTextField1.setText("150");
        add(jTextField1);
        jTextField1.setBounds(423, 108, 69, 29);

        jLabel3.setText("Lượng tồn tối thiểu (nhập)");
        add(jLabel3);
        jLabel3.setBounds(286, 163, 121, 13);

        jTextField2.setText("300");
        add(jTextField2);
        jTextField2.setBounds(423, 155, 69, 29);

        jLabel4.setText("Nợ tối đa");
        add(jLabel4);
        jLabel4.setBounds(286, 260, 41, 13);

        jTextField3.setText("20000");
        add(jTextField3);
        jTextField3.setBounds(422, 250, 70, 29);

        jLabel5.setText("Lượng tồn tối thiểu (bán)");
        add(jLabel5);
        jLabel5.setBounds(286, 210, 115, 13);

        jTextField4.setText("20");
        add(jTextField4);
        jTextField4.setBounds(423, 202, 69, 29);

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Tiền thu không quá nợ");
        add(jCheckBox1);
        jCheckBox1.setBounds(326, 296, 131, 21);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save.png"))); // NOI18N
        add(jButton1);
        jButton1.setBounds(290, 330, 35, 35);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancel.png"))); // NOI18N
        add(jButton2);
        jButton2.setBounds(370, 330, 35, 35);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/refresh.png"))); // NOI18N
        add(jButton3);
        jButton3.setBounds(450, 330, 35, 35);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Options_Background.jpg"))); // NOI18N
        add(jLabel6);
        jLabel6.setBounds(0, 0, 790, 630);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
