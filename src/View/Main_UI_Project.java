
package View;

import Model.Account;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Main_UI_Project extends javax.swing.JFrame {

    Controller.AccountController controller;
    private static Main_UI_Project instance = null;
    public Account InstanceUser=null;
    public static Main_UI_Project getInstance()
    {
        if(instance==null)
            instance=new Main_UI_Project();
        return instance;
    }
    
    //coder defined
    public void setAccount(Account Instance_User){
        this.InstanceUser= Instance_User;
        this.setInfoUser();
    }
    private void  execute(){
        MenuPanelMAin.setVisible(false);     
        fWelcome = new FWelcome();
        fCustomer = new FCustomer();
        fbill = new Fbill();
        fCashReceive = new FCashReceive();
        fBookReceive = new FBookReceive();
        fAddStaff = new FAddStaff();
        fBookInventory = new FBookInventory();
        fCategoryAndPublisher = new FCategoryAndPublisher();
        fReportInventory = new FReportInventory();           
        fReportRevenue = new FReportRevenue();
        fStaff = new FStaff();
        ImageIcon iconQLBH = new ImageIcon(getClass().getResource("/Image/Icon_QLBH.png"));
        ImageIcon iconQLKS = new ImageIcon(getClass().getResource("/Image/Icon_QLKS.png"));
        ImageIcon iconQLNS = new ImageIcon(getClass().getResource("/Image/Icon_QLNS.png"));
        ImageIcon iconQLTK = new ImageIcon(getClass().getResource("/Image/Icon_QLTK.png"));
        ImageIcon iconMenu = new ImageIcon(getClass().getResource("/Image/menuChild.png"));

        //Create submenu Quản lý bán hàng
        MenuItem menuQLBH_KH = new MenuItem(iconMenu, "Khách hàng",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               switchPanel(ContentPanel, fCustomer);
               UserPanel.setVisible(false);
            }
        });
        MenuItem menuQLBH_HD = new MenuItem(iconMenu, "Lập hóa đơn",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            switchPanel(ContentPanel, fbill);
            UserPanel.setVisible(false);
            }
        });
        MenuItem menuQLBH_PTT = new MenuItem(iconMenu, "Lập phiếu thu",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            switchPanel(ContentPanel, fCashReceive);
            UserPanel.setVisible(false);
            }
        });
        MenuItem menuQLBH_LPN = new MenuItem(iconMenu, "Lập phiếu nhập",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            switchPanel(ContentPanel, fBookReceive);
            UserPanel.setVisible(false);
            }
        });
        MenuItem menuQLBH = new MenuItem(iconQLBH, "Quản lý bán hàng",null,menuQLBH_KH,menuQLBH_HD,menuQLBH_PTT,menuQLBH_LPN);
        
        //Create submenu Quản lý kho sách
        MenuItem menuQLKS_TCS = new MenuItem(iconMenu, "Sách tồn",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            switchPanel(ContentPanel, fBookInventory);
            UserPanel.setVisible(false);
            }
        });
        MenuItem menuQLKS_TLvNXB = new MenuItem(iconMenu, "Thể loại & NXB",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            switchPanel(ContentPanel, fCategoryAndPublisher);
            UserPanel.setVisible(false);
            }
        });
        MenuItem menuQLKS = new MenuItem(iconQLKS, "Quản lý kho sách",null,menuQLKS_TCS,menuQLKS_TLvNXB);
 
        //Create submenu Quản lý nhân sự
        MenuItem menuQLNS_DSNV = new MenuItem(iconMenu, "DS nhân viên",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(InstanceUser.getType()==0){
                    switchPanel(ContentPanel, fStaff);
                    UserPanel.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null, "You don't have permission to do this");
                }
            }
        });
        MenuItem menuQLNK_TNV = new MenuItem(iconMenu, "Thêm nhân viên",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            switchPanel(ContentPanel, fAddStaff);
            UserPanel.setVisible(false);
            }
        });
        MenuItem menuQLNS = new MenuItem(iconQLNS , "Quản lý nhân sự",null,menuQLNS_DSNV,menuQLNK_TNV);
        
        //Create submenu Lập thống kê
        MenuItem menuQLTK_BCT = new MenuItem(iconMenu, "Báo cáo tồn",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            switchPanel(ContentPanel, fReportInventory);
            UserPanel.setVisible(false);
            }
        });
        MenuItem menuQLTK_BCCN = new MenuItem(iconMenu, "Báo cáo công nợ",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            switchPanel(ContentPanel, fReportRevenue);
            UserPanel.setVisible(false);
            }
        });
        MenuItem menuQLTK = new MenuItem(iconQLTK, "Lập thống kê",null,menuQLTK_BCT,menuQLTK_BCCN);
     
        //Thêm vào menu chính
        addMenu(menuQLBH,menuQLKS,menuQLNS,menuQLTK);
    };
    private void addMenu(MenuItem... menu){
        for(int i=0; i<menu.length;i++){
            MenuPanel.add(menu[i]);
            ArrayList<MenuItem>subMenu=menu[i].getSubMenu();
            for(MenuItem m:subMenu){
                addMenu(m);
            }
        }
            
    }
    public void setInfoUser(){
        //Lấy thông tin user
        if(InstanceUser!=null){
            Name_Info.setText(InstanceUser.getRealName());
            Email_Info.setText(InstanceUser.getEmail());
            String chucvu;
            if(InstanceUser.getType()==0){
                  chucvu="Admin";
            }
            else 
                chucvu="Nhân viên";
            Level_Info.setText(chucvu);
            Phone_Info.setText(InstanceUser.getPhoneNumber());
            Addr_Info.setText(InstanceUser.getAddress());
        }
    }
    private void switchPanel(JPanel parent, JPanel child){
        parent.removeAll();
        parent.add(child);
        parent.repaint();
        parent.revalidate();
    }
    
    //Constructor
    public Main_UI_Project() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(1000, 680);
        this.setBackground(new Color(54,70,70));
        this.execute();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UserPanel = new javax.swing.JPanel();
        UserButton = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        ButtonOut = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        Info_Label = new javax.swing.JLabel();
        PhoneLabel = new javax.swing.JLabel();
        NameLabel = new javax.swing.JLabel();
        LevelLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        AddrLabel = new javax.swing.JLabel();
        Level_Info = new javax.swing.JLabel();
        Name_Info = new javax.swing.JLabel();
        Phone_Info = new javax.swing.JLabel();
        Email_Info = new javax.swing.JLabel();
        Addr_Info = new javax.swing.JLabel();
        ContentPanel = new javax.swing.JPanel();
        HeadPanel = new javax.swing.JPanel();
        Xbutton = new javax.swing.JLabel();
        MinButton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        MenuPanelMAin = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MenuPanel = new javax.swing.JPanel();
        MenuMainButton = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        Background = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(54, 70, 70));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserPanel.setBackground(new java.awt.Color(54, 70, 78));
        UserPanel.setPreferredSize(new java.awt.Dimension(210, 630));
        UserPanel.setLayout(null);

        UserButton.setBackground(new java.awt.Color(54, 70, 78));
        UserButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/MenuButton.PNG"))); // NOI18N
        UserButton.setOpaque(true);
        UserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UserButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                UserButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                UserButtonMouseExited(evt);
            }
        });
        UserPanel.add(UserButton);
        UserButton.setBounds(170, 0, 40, 30);

        UserLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        UserLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        UserLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/UserMenu_Icon.PNG"))); // NOI18N
        UserPanel.add(UserLabel);
        UserLabel.setBounds(50, 50, 110, 120);

        ButtonOut.setBackground(new java.awt.Color(0, 204, 204));
        ButtonOut.setText("ĐĂNG XUẤT");
        ButtonOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonOutActionPerformed(evt);
            }
        });
        UserPanel.add(ButtonOut);
        ButtonOut.setBounds(60, 540, 94, 37);
        UserPanel.add(jSeparator1);
        jSeparator1.setBounds(0, 260, 210, 30);
        UserPanel.add(jSeparator2);
        jSeparator2.setBounds(0, 500, 210, 20);

        Info_Label.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Info_Label.setForeground(new java.awt.Color(102, 255, 255));
        Info_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Info_Label.setText("Thông tin");
        UserPanel.add(Info_Label);
        Info_Label.setBounds(50, 210, 110, 30);

        PhoneLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PhoneLabel.setForeground(new java.awt.Color(255, 0, 102));
        PhoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        PhoneLabel.setText("SĐT:");
        UserPanel.add(PhoneLabel);
        PhoneLabel.setBounds(0, 370, 60, 30);

        NameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        NameLabel.setForeground(new java.awt.Color(255, 0, 102));
        NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NameLabel.setText("Tên:");
        UserPanel.add(NameLabel);
        NameLabel.setBounds(20, 310, 40, 30);

        LevelLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LevelLabel.setForeground(new java.awt.Color(255, 0, 102));
        LevelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LevelLabel.setText("Chức vụ:");
        UserPanel.add(LevelLabel);
        LevelLabel.setBounds(0, 340, 60, 30);

        EmailLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        EmailLabel.setForeground(new java.awt.Color(255, 0, 102));
        EmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        EmailLabel.setText("Email:");
        UserPanel.add(EmailLabel);
        EmailLabel.setBounds(20, 430, 40, 30);

        AddrLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        AddrLabel.setForeground(new java.awt.Color(255, 0, 102));
        AddrLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        AddrLabel.setText("Địa chỉ:");
        UserPanel.add(AddrLabel);
        AddrLabel.setBounds(10, 400, 50, 30);

        Level_Info.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Level_Info.setForeground(new java.awt.Color(102, 255, 0));
        Level_Info.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Level_Info.setText("[Type]");
        UserPanel.add(Level_Info);
        Level_Info.setBounds(70, 340, 140, 30);

        Name_Info.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Name_Info.setForeground(new java.awt.Color(102, 255, 0));
        Name_Info.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Name_Info.setText("[Real name]");
        UserPanel.add(Name_Info);
        Name_Info.setBounds(70, 310, 140, 30);

        Phone_Info.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Phone_Info.setForeground(new java.awt.Color(102, 255, 0));
        Phone_Info.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Phone_Info.setText("[Phone]");
        UserPanel.add(Phone_Info);
        Phone_Info.setBounds(70, 370, 140, 30);

        Email_Info.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Email_Info.setForeground(new java.awt.Color(102, 255, 0));
        Email_Info.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Email_Info.setText("[Email]");
        UserPanel.add(Email_Info);
        Email_Info.setBounds(70, 430, 140, 30);

        Addr_Info.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Addr_Info.setForeground(new java.awt.Color(102, 255, 0));
        Addr_Info.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Addr_Info.setText("[Addres]");
        UserPanel.add(Addr_Info);
        Addr_Info.setBounds(70, 400, 140, 30);

        getContentPane().add(UserPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 630));

        ContentPanel.setBackground(new java.awt.Color(0, 204, 255));
        ContentPanel.setPreferredSize(new java.awt.Dimension(790, 630));
        ContentPanel.setLayout(null);
        getContentPane().add(ContentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 790, 630));

        HeadPanel.setBackground(new java.awt.Color(255, 51, 51));
        HeadPanel.setPreferredSize(new java.awt.Dimension(1000, 73));

        Xbutton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Xbutton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Xbutton.setText("x");
        Xbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Xbutton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        Xbutton.setPreferredSize(new java.awt.Dimension(12, 31));
        Xbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                XbuttonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                XbuttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                XbuttonMouseExited(evt);
            }
        });

        MinButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        MinButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MinButton.setText("-");
        MinButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        MinButton.setMaximumSize(new java.awt.Dimension(13, 24));
        MinButton.setMinimumSize(new java.awt.Dimension(13, 34));
        MinButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MinButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MinButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MinButtonMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BOOK STORE MANAGEMENT");

        javax.swing.GroupLayout HeadPanelLayout = new javax.swing.GroupLayout(HeadPanel);
        HeadPanel.setLayout(HeadPanelLayout);
        HeadPanelLayout.setHorizontalGroup(
            HeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeadPanelLayout.createSequentialGroup()
                .addContainerGap(382, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(307, 307, 307)
                .addComponent(MinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Xbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        HeadPanelLayout.setVerticalGroup(
            HeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(HeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Xbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(HeadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MinButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(HeadPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 50));

        MenuPanelMAin.setBackground(new java.awt.Color(54, 70, 70));
        MenuPanelMAin.setPreferredSize(new java.awt.Dimension(210, 630));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(210, 630));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(210, 630));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(210, 500));

        MenuPanel.setBackground(new java.awt.Color(54, 70, 78));
        MenuPanel.setLayout(new javax.swing.BoxLayout(MenuPanel, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(MenuPanel);

        MenuMainButton.setBackground(new java.awt.Color(54, 70, 78));
        MenuMainButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MenuMainButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/MenuButton.PNG"))); // NOI18N
        MenuMainButton.setOpaque(true);
        MenuMainButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MenuMainButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MenuMainButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MenuMainButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelMAinLayout = new javax.swing.GroupLayout(MenuPanelMAin);
        MenuPanelMAin.setLayout(MenuPanelMAinLayout);
        MenuPanelMAinLayout.setHorizontalGroup(
            MenuPanelMAinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelMAinLayout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(MenuPanelMAinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelMAinLayout.createSequentialGroup()
                        .addComponent(MenuMainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator3)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        MenuPanelMAinLayout.setVerticalGroup(
            MenuPanelMAinLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelMAinLayout.createSequentialGroup()
                .addComponent(MenuMainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(MenuPanelMAin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 210, 630));

        Background.setBackground(new java.awt.Color(54, 70, 70));
        Background.setPreferredSize(new java.awt.Dimension(1000, 680));

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Action in UI.
    //Editor generated
    private void XbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XbuttonMouseClicked
        System.exit(0);
    }//GEN-LAST:event_XbuttonMouseClicked


    private void XbuttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XbuttonMouseEntered
        Border Label_border = BorderFactory.createMatteBorder(1, 1, 1,1, Color.white);
        Xbutton.setBorder(Label_border);
        Xbutton.setForeground(Color.white);
        //done
    }//GEN-LAST:event_XbuttonMouseEntered

    private void XbuttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_XbuttonMouseExited
        Border Label_border = BorderFactory.createMatteBorder(1, 1, 1,1, Color.BLACK);
        Xbutton.setBorder(Label_border);
        Xbutton.setForeground(Color.BLACK);
    }//GEN-LAST:event_XbuttonMouseExited

    private void MinButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinButtonMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_MinButtonMouseClicked

    private void MinButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinButtonMouseEntered
        // TODO add your handling code here:
        Border Label_border = BorderFactory.createMatteBorder(1, 1, 1,1, Color.white);
        MinButton.setBorder(Label_border);
        MinButton.setForeground(Color.white);
        //done
    }//GEN-LAST:event_MinButtonMouseEntered

    private void MinButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MinButtonMouseExited
        // TODO add your handling code here:
        Border Label_border = BorderFactory.createMatteBorder(1, 1, 1,1, Color.BLACK);
        MinButton.setBorder(Label_border);
        MinButton.setForeground(Color.BLACK);
        //done
    }//GEN-LAST:event_MinButtonMouseExited
    int x=210;
    private void UserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseClicked

        if(x==210){
            UserPanel.setSize(210,552);
            Thread th;
            th = new Thread(){
                @Override
                public void run(){
                    try {
                        for(int i= 210; i>=0;i--)
                        {
                            Thread.sleep(1);
                            UserPanel.setSize(i,630);
                        }
                    }catch(Exception e1){
                                JOptionPane.showMessageDialog(null, e1);
                                
                      }
                    }
                };
                th.start();
                x = 0;
                MenuPanelMAin.setVisible(true);
            };
    }//GEN-LAST:event_UserButtonMouseClicked

    private void MenuMainButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMainButtonMouseClicked
        // TODO add your handling code here:
        
        if(x==0)
        {
            UserPanel.show();
            UserPanel.setSize(x,552);
            Thread th = new Thread(){
            @Override
            public void run(){
                try{
                    for(int i=0;i<=x;i++){
                        Thread.sleep(1);
                        UserPanel.setSize(i,630);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            };
            th.start();
            x=210;
            MenuPanelMAin.setVisible(false);
        }
    }//GEN-LAST:event_MenuMainButtonMouseClicked

    private void UserButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseEntered
        // TODO add your handling code here
        UserButton.setBackground(Color.GRAY);
        
    }//GEN-LAST:event_UserButtonMouseEntered

    private void UserButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UserButtonMouseExited
       UserButton.setBackground(new Color(54,70,78));
       
    }//GEN-LAST:event_UserButtonMouseExited

    private void MenuMainButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMainButtonMouseEntered
        // TODO add your handling code here:
        MenuMainButton.setBackground(Color.GRAY);
    }//GEN-LAST:event_MenuMainButtonMouseEntered

    private void MenuMainButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MenuMainButtonMouseExited
        // TODO add your handling code here:
        MenuMainButton.setBackground(new Color(54,70,78));
    }//GEN-LAST:event_MenuMainButtonMouseExited

    private void ButtonOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonOutActionPerformed
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát?", 
                                                            "Confirm",
                                                            JOptionPane.YES_NO_OPTION
                                                           ,JOptionPane.QUESTION_MESSAGE);
        if(response==JOptionPane.YES_OPTION){
            switchPanel(ContentPanel, fWelcome);
            Main_UI_Project.getInstance().setAccount(null);
            Main_UI_Project.getInstance().setVisible(false);
            LoginForm.getInstance().setVisible(true);
        }
        else{
            //Không làm gì cả
        }
    }//GEN-LAST:event_ButtonOutActionPerformed
 
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_UI_Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_UI_Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_UI_Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_UI_Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Main_UI_Project().setVisible(true);
               
            }
        });
    }
    
    private FAddStaff fAddStaff;
    private FBookInventory fBookInventory;
    private FBookReceive fBookReceive;
    private FCashReceive fCashReceive;
    private FCategoryAndPublisher fCategoryAndPublisher;
    private FCustomer fCustomer;
    private FReportInventory fReportInventory;
    private FReportRevenue fReportRevenue;
    private FStaff fStaff;
    private Fbill fbill; 
    private FWelcome fWelcome;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddrLabel;
    private javax.swing.JLabel Addr_Info;
    private javax.swing.JPanel Background;
    private javax.swing.JButton ButtonOut;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel Email_Info;
    private javax.swing.JPanel HeadPanel;
    private javax.swing.JLabel Info_Label;
    private javax.swing.JLabel LevelLabel;
    private javax.swing.JLabel Level_Info;
    private javax.swing.JLabel MenuMainButton;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JPanel MenuPanelMAin;
    private javax.swing.JLabel MinButton;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel Name_Info;
    private javax.swing.JLabel PhoneLabel;
    private javax.swing.JLabel Phone_Info;
    private javax.swing.JLabel UserButton;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JPanel UserPanel;
    private javax.swing.JLabel Xbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
