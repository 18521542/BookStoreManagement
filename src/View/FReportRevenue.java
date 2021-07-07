
package View;

import Controller.ReportRevenueController;
import Model.Book;
import Model.ReportRevenue;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.ui.TextAnchor;
import org.jfree.data.category.DefaultCategoryDataset;


public class FReportRevenue extends javax.swing.JPanel {

    
    public FReportRevenue() {
        initComponents();
        this.setSize(790, 630);
    }

    ReportRevenueController Controller=new ReportRevenueController();
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Revenue = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        sp_Year = new javax.swing.JSpinner();
        sp_Month = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Rev_Background.jpg"))); // NOI18N

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

        jButton2.setText("Xuất File PDF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(530, 590, 110, 30);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Rev_Background.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        add(jLabel4);
        jLabel4.setBounds(0, 0, 790, 630);
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Document document = new Document(PageSize.A4);
                String filename = "BaoCaoDoanhThu"+sp_Month.getValue().toString()+"-"+sp_Year.getValue().toString();
                 try{
                // Xử lí font chữ tiêu đề, hình, ...
                PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("src/reports/"+filename+".pdf"));
                document.open();
                File filefontTieuDe = new File("src/fonts/vuArialBold.ttf");
                
                BaseFont bfTieuDe=BaseFont.createFont(filefontTieuDe.getAbsolutePath(),BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
                
                
                Font fontTieuDe1= new Font(bfTieuDe,16);
                fontTieuDe1.setColor(BaseColor.BLUE);
                Font fontTieuDe2= new Font(bfTieuDe,13);
                fontTieuDe2.setColor(BaseColor.BLUE);
                Font fontTieuDe3= new Font(bfTieuDe,13);
                Font fontTieuDe4= new Font(bfTieuDe,12);
                
                File fileFontNoiDung= new File("src/fonts//vuArial.ttf");
                BaseFont bfNoiDung = BaseFont.createFont(filefontTieuDe.getAbsolutePath(),BaseFont.IDENTITY_H,BaseFont.EMBEDDED);
                Font fontNoiDung1 = new Font(bfNoiDung,13);
                Font fontNoiDung2 = new Font(bfNoiDung,12);
                
                
                Image logo = Image.getInstance("src/Image/bookstore.png");
                logo.setAbsolutePosition(80, 750);
                logo.scaleAbsolute(50,50);
                document.add(logo);
                
                Paragraph prgTenPK = new Paragraph("Cửa hàng sách UIT NHÓM 1",fontTieuDe2);
                prgTenPK.setIndentationLeft(100);
                document.add(prgTenPK);
                
                Paragraph prgDiaChiPK = new Paragraph("Khu Phố 6, Phường Bình Thọ, Tp.Thủ Đức, Tp. Hồ Chí Minh",fontNoiDung2);
                prgDiaChiPK.setIndentationLeft(100);
                document.add(prgDiaChiPK);
                
                Paragraph prgSDTPK = new Paragraph("Số Điện Thoại: 028 3456 7890",fontNoiDung2);
                prgSDTPK.setIndentationLeft(100);
                document.add(prgSDTPK);
                
                Paragraph prgTieuDe  = new Paragraph("Báo Cáo Doanh Thu Theo Tháng",fontTieuDe1);
                prgTieuDe.setAlignment(Element.ALIGN_CENTER);
                prgTieuDe.setSpacingAfter(10);
                prgTieuDe.setSpacingBefore(10);
                document.add(prgTieuDe);
                
                
               
                
                Paragraph prgTBDoanhThu= new Paragraph("I. Doanh Thu Của Sách",fontTieuDe2);
                prgTBDoanhThu.setSpacingAfter(10);
                prgTBDoanhThu.setSpacingBefore(10);
                document.add(prgTBDoanhThu);
                
                PdfPTable tableDV = new PdfPTable(3);
                        tableDV.setWidthPercentage(80);
                        tableDV.setSpacingAfter(10);
                        tableDV.setSpacingBefore(10);
                        
                        float[] tableDV_columnWidths = {50, 120, 150};
                        tableDV.setWidths(tableDV_columnWidths);

                        PdfPCell cellTDTT = new PdfPCell(new Paragraph("STT", fontTieuDe4));
                        cellTDTT.setBorderColor(BaseColor.BLACK);
                        cellTDTT.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellTDTT.setVerticalAlignment(Element.ALIGN_CENTER);
                        cellTDTT.setMinimumHeight(30);
                        tableDV.addCell(cellTDTT);

                        PdfPCell cellNgay = new PdfPCell(new Paragraph("Tên Sách", fontTieuDe4));
                        cellNgay.setBorderColor(BaseColor.BLACK);
                        cellNgay.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellNgay.setVerticalAlignment(Element.ALIGN_CENTER);
                        tableDV.addCell(cellNgay);


                        PdfPCell cellTDDonGia = new PdfPCell(new Paragraph("Số Tiền", fontTieuDe4));
                        cellTDTT.setBorderColor(BaseColor.BLACK);
                        cellTDTT.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellTDTT.setVerticalAlignment(Element.ALIGN_CENTER);
                        tableDV.addCell(cellTDDonGia);
                        
                
                        
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                        
                 try{
                   
                    ArrayList<ReportRevenue> listReportRevenues=new ArrayList<>();
                    listReportRevenues =  new ReportRevenue().getReportReportRevenue(Integer.parseInt(sp_Month.getValue().toString()), Integer.parseInt(sp_Year.getValue().toString()));

                    float TongTien=0;
                    int TT=1;


                    //while(rs.next())
                    for(ReportRevenue rp : listReportRevenues){  
                        PdfPCell cellTT = new PdfPCell(new Paragraph(String.valueOf(TT), fontNoiDung2));
                        cellTT.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellTT.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        cellTT.setMinimumHeight(20);
                        tableDV.addCell(cellTT);
                        
                        PdfPCell cellBookName = new PdfPCell(new Paragraph((new Book()).getBookByID(rp.bookID()).name(),fontNoiDung2));
                        cellBookName.setHorizontalAlignment(Element.ALIGN_CENTER);
                        cellBookName.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableDV.addCell(cellBookName);


                        PdfPCell cellTongTien = new PdfPCell(new Paragraph(DinhDangTienTe((float)rp.money()), fontNoiDung2));
                        cellTongTien.setPaddingLeft(10);
                        cellTongTien.setHorizontalAlignment(Element.ALIGN_JUSTIFIED);
                        cellTongTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                        tableDV.addCell(cellTongTien);
                        
                        TongTien = TongTien + (float)rp.money();
                        TT=TT+1;
                        
                        dataset.setValue(rp.money(), "DoanhThu", (new Book()).getBookByID(rp.bookID()).name());
                
                        
                    }
                    System.out.println(DinhDangTienTe(TongTien));
                    PdfPCell cellTongCong = new PdfPCell(new Paragraph("TỔNG CỘNG:",fontTieuDe4));
                    cellTongCong.setColspan(2);
                    cellTongCong.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellTongCong.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    cellTongCong.setMinimumHeight(20);
                    tableDV.addCell(cellTongCong);

                    PdfPCell cellTongTien = new PdfPCell(new Paragraph(DinhDangTienTe(TongTien), fontTieuDe4));
                    cellTongTien.setHorizontalAlignment(Element.ALIGN_CENTER);
                    cellTongTien.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    tableDV.addCell(cellTongTien);
                }catch (Exception e){
                    System.out.println(e);
                    System.out.println("Lỗi");
                }  
                document.add(tableDV);
                
                Paragraph prgBieuDoDV= new Paragraph("II/ Biểu Đồ Doanh Thu Theo Tháng",fontTieuDe2);
                prgBieuDoDV.setSpacingAfter(10);
                prgBieuDoDV.setSpacingBefore(10);
                document.add(prgBieuDoDV);
                
                BufferedImage bufferedImageBDDT = CreateBarChart(dataset, sp_Month.getValue().toString(),sp_Year.getValue().toString());
                Image image = Image.getInstance(writer, bufferedImageBDDT, 1.0f);
                image.setAlignment(Element.ALIGN_CENTER);
                image.scaleAbsolute(500,300);
                document.add(image);
                  
                document.close();
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                File file = new File("reporst/"+filename+".pdf");
                if (!Desktop.isDesktopSupported()){
                    System.out.println("not supported");
                    return;
                }
                Desktop desktop=Desktop.getDesktop();
                if (file.exists()){
                    desktop.open(file);
                }
                
                
            } catch (Exception e) {
            }
    }                                        
     public BufferedImage CreateBarChart(DefaultCategoryDataset dataset, String month, String year){
        BufferedImage bufferedImage = null;
        try {
            JFreeChart chart = ChartFactory.createBarChart(
                    "Doanh Thu Của Tháng " + month+ "/"+ year,
                    "Tên Sách ",
                    "Số Tiền",
                    dataset,
                    PlotOrientation.VERTICAL,
                    false,
                    false,
                    false
                    
            );
            
            java.awt.Font fontTieuDe = new java.awt.Font("Tahoma",java.awt.Font.BOLD,120);
            java.awt.Font fontNoiDung1 = new java.awt.Font("Tahoma",java.awt.Font.PLAIN,80);
            java.awt.Font fontNoiDung2 = new java.awt.Font("Tahoma",java.awt.Font.ITALIC,80);
            
            chart.getTitle().setFont(fontTieuDe);
            
            CategoryPlot plot = (CategoryPlot) chart.getPlot();
            ((BarRenderer) plot.getRenderer()).setBarPainter(new StandardBarPainter());
            
            plot.setBackgroundPaint(Color.white);
            plot.setOutlinePaint(null);
            
            CategoryItemRenderer renderer = ((CategoryPlot)chart.getPlot()).getRenderer();
            
            renderer.setDefaultItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setDefaultItemLabelsVisible(true);
            
            ItemLabelPosition position = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.TOP_CENTER);
            renderer.setDefaultPositiveItemLabelPosition(position);
            renderer.setDefaultItemLabelFont(fontNoiDung1);

            
            CategoryAxis DomainAxis = plot.getDomainAxis();
            DomainAxis.setTickLabelFont(fontNoiDung1);
            DomainAxis.setLabelFont(fontNoiDung2);
            
            ValueAxis rangeAxis = plot.getRangeAxis();
            rangeAxis.setTickLabelFont(fontNoiDung1);
            rangeAxis.setLabelFont(fontNoiDung2);
            
            bufferedImage = chart.createBufferedImage(5000, 3000);
            
            
            
        } catch (Exception e) {
        }
        return bufferedImage;
        
    }
    public String DinhDangTienTe(float SoTien){
        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        
        String str = en.format(SoTien);
        return str;
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table_Revenue;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner sp_Month;
    private javax.swing.JSpinner sp_Year;
    // End of variables declaration//GEN-END:variables
}
