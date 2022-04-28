import java.sql.*;

public class Home extends javax.swing.JFrame {

    private javax.swing.JTextField accbal;
    private javax.swing.JButton balbtn;
    private javax.swing.JButton buybtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JButton sellbtn;
    private String uname;
    private Integer bal;

    public Home(String name, Integer balance) {
        uname = name;
        bal = balance;
        initComponents();
        setVisible(true);
        displayBalance();
        displayBought();
        displayAvailable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        buybtn = new javax.swing.JButton();
        sellbtn = new javax.swing.JButton();
        balbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        accbal = new javax.swing.JTextField();
        logoutbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Rockwell Condensed", 0, 48)); // NOI18N
        jLabel1.setText("FAIR TRADE");
        jLabel1.setToolTipText("");

        jLabel2.setText("Stocks available:");

        jLabel3.setText("Stocks bought:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        buybtn.setText("Buy Cryptos");
        buybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buybtnActionPerformed(evt);
            }
        });

        sellbtn.setText("Sell Cryptos");
        sellbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellbtnActionPerformed(evt);
            }
        });

        balbtn.setText("Add Balance");
        balbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balbtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Account Balance:");

        logoutbtn.setText("Log Out");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(130, 130, 130))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(logoutbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(balbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buybtn)
                        .addGap(12, 12, 12)
                        .addComponent(sellbtn)
                        .addGap(39, 39, 39))))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accbal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(8, 8, 8)
                .addComponent(accbal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buybtn)
                    .addComponent(sellbtn)
                    .addComponent(balbtn)
                    .addComponent(logoutbtn))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>      
    
    private void displayBalance(){
        accbal.setText(Integer.toString(bal));
    }

    private void displayAvailable(){
        try{
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection con = DriverManager.getConnection("jdbc:sqlite:C:/Users/dassa/CRYPTO.db");
            
            java.sql.Statement stmt = con.createStatement();
            String sql = "SELECT cname, cprice FROM available";
            ResultSet rs=stmt.executeQuery(sql);  //obj contains the count table
            String resultText = "Currency Name\t\tCurrency Price\n";
            while(rs.next()){
                String cName = rs.getString("cname");
                Integer cPrice = rs.getInt("cprice");
                resultText += cName + "\t\t" + cPrice + "\n";
            }
            jTextArea1.setText(resultText);
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }

    private void displayBought(){
        try{
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection con = DriverManager.getConnection("jdbc:sqlite:C:/Users/dassa/CRYPTO.db");
            
            String sql = "SELECT cname, cqty, total FROM bought WHERE uname=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, uname);
            ResultSet rs=pstmt.executeQuery();  //obj contains the count table
            String resultText = "Currency Name\t   Quanity\tTotal Price\n";
            while(rs.next()){
                String cName = rs.getString("cname");
                Integer cQty = rs.getInt("cqty");
                Integer total = rs.getInt("total");
                resultText += cName + "\t   " + cQty + "\t" + total + "\n";
            }
            jTextArea2.setText(resultText);
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    
    private void buybtnActionPerformed(java.awt.event.ActionEvent evt) {                                       
        this.dispose();
        new Buy(uname, bal);
    }                                      

    private void sellbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        this.dispose();
        new Sell(uname, bal);
    }         
    
    private void balbtnActionPerformed(java.awt.event.ActionEvent evt) {  
        this.dispose();
        new Balance(uname, bal);
    }

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {
        try{
            Class.forName("org.sqlite.JDBC");
            java.sql.Connection con = DriverManager.getConnection("jdbc:sqlite:C:/Users/dassa/LOGIN.db");
            
            String sql = "UPDATE login SET BAL=? WHERE uname = ?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, bal);
            pstmt.setString(2, uname);
            pstmt.executeUpdate();
            this.dispose();
            con.close();
            System.exit(0);
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }  
        
    }
}
