import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Home extends javax.swing.JFrame {

    private javax.swing.JButton buybtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton sellbtn;
    private String uname;

    public Home(String name) {
        uname = name;
        initComponents();
        setVisible(true);
        displayBought();
        displayAvailable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(130, 130, 130))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(buybtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(sellbtn)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buybtn)
                    .addComponent(sellbtn))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

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
            ResultSet rs=pstmt.executeQuery(sql);  //obj contains the count table
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
        new Buy(uname);
    }                                      

    private void sellbtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        this.dispose();
        new Sell(uname);
    }            
}
