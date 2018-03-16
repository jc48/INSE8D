
package inventory;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.*;
import javax.swing.JTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author INSE8D
 */
public class AddClass extends javax.swing.JFrame {
    private final HomeGui home;
    DefaultTableModel model;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDate localDate = LocalDate.now();
    static String itemS = "Item_Storage.txt";
    static String cupS = "Cupboard_Storage.txt";
    static String userS = "User_Storage.txt";
    int count = 0;


    /**
     * Creates new form NewJFrame
     * @param home 
     */
    public AddClass(HomeGui home) {
        initComponents();
        try{
            loadFile();
        } 
        catch (Exception e)
        {
            
        }
        this.home = home;

    }
    
    /**
     * Reads an entire local text document.
     * @throws Exception 
     */
    public void loadFile() throws Exception{
        String storedData;
        try (FileInputStream in = new FileInputStream(itemS)) {
            storedData = "";
            byte buffer [] = new byte [100] ;
            int numBytesRead = in.read(buffer) ;
            while(numBytesRead > 0) {
                storedData += (new String(buffer, 0, numBytesRead)) ;
                numBytesRead = in.read(buffer) ;
            }
        }
          sortLoad(storedData);
    }
    
    /**
     * Splits up the inputed string and places it properly into the table.
     * @param data The raw string of data that needs to be inputed into the table
     */
    public void sortLoad(String data){
        DefaultTableModel table = (DefaultTableModel)itemTable.getModel();
        String[] dataList = data.split("\\\\");
        for (String dataList1 : dataList) {
            String[] dataItem = dataList1.split("\\,");
            table.addRow(new Object[]{dataItem[0], dataItem[1], dataItem[2], dataItem[3], dataItem[4]});
        }
    }
    
    
    /**
     *Returns true if expiry date of an item being added is after the current date
     * 
     * @param date1  current date
     * @param date2  expiry date of item added
     * @return boolean
     */
    public boolean compareYear(String date1, String date2){
        SimpleDateFormat df;      
        df = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date d1 = df.parse(date1);
            Date d2 = df.parse(date2);
            
            if(d1.compareTo(d2)<0){
                return true;
            }
               
        } catch (ParseException e) {
        }   
        return false;
    }
    
    /**
     * Reads all the data in the table and writes it to a local text document.
     * @throws Exception 
     */
    public void saveFile() throws Exception{
        
        int tHeight = itemTable.getRowCount();
        
        try (FileOutputStream out = new FileOutputStream(itemS)) {
            for (int h = 0; h < tHeight; h++){
                String text = readTableRow(h);
                System.out.println(text);
                byte buffer [] = text.getBytes();
                out.write(buffer);
            }
            //Get Item from Row
        }
    }
    
    /**
     * Prepares the data within the table to be properly saved such that it can
     * still be loaded.
     * @param rHeight The height of the row (0 being the top row)
     * @return Returns the selected row as a String Formated for Saving.
     */
    public String readTableRow(int rHeight){
        String itemString = String.valueOf(itemTable.getValueAt(rHeight,0));
        String quantityString = String.valueOf(itemTable.getValueAt(rHeight,1));
        String dateAddedString = String.valueOf(itemTable.getValueAt(rHeight,2));
        String expiryString = String.valueOf(itemTable.getValueAt(rHeight,3));
        String daysLeft = String.valueOf(itemTable.getValueAt(rHeight,4));
        return (itemString+","+quantityString+","+dateAddedString+","+expiryString+", "+daysLeft+"\\");
        
    }

    
    /**
     * Returns the panel
     * @return panel of the AddClass JFrame
     */
    public JPanel getPanel(){
        return bodyPanel;
    }
    
     /**
     * Returns the item Quantity
     * 
     * @return Quantity of added item
     */
    public int getitemQuantity(){
        return Integer.parseInt(itemQuantityTxt.getText());
    }
    
    /**
     * Returns the item name
     * 
     * @return name of added item
     */
    public String getItemName(){
        return itemName.getText();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField2 = new javax.swing.JTextField();
        bodyPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        itemName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        itemQuantityTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        addBtn = new javax.swing.JLabel();
        delBtn = new javax.swing.JLabel();
        saveBtn = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        searchBox = new javax.swing.JTextField();
        backBtn = new javax.swing.JLabel();

        jTextField2.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        bodyPanel.setBackground(new java.awt.Color(44, 62, 80));

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        itemTable.setBackground(new java.awt.Color(231, 76, 60));
        itemTable.setForeground(new java.awt.Color(255, 255, 255));
        itemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Quantity", "Date Added", "Expiry Date", "Days Left"
            }
        ));
        jScrollPane1.setViewportView(itemTable);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Item");

        itemName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemNameMouseClicked(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantity");

        itemQuantityTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemQuantityTxtMouseClicked(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Expiry Date");

        addBtn.setBackground(new java.awt.Color(255, 255, 255));
        addBtn.setText("    add");
        addBtn.setOpaque(true);
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBtnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addBtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addBtnMouseEntered(evt);
            }
        });

        delBtn.setBackground(new java.awt.Color(255, 255, 255));
        delBtn.setText("  delete");
        delBtn.setOpaque(true);
        delBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delBtnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delBtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delBtnMouseEntered(evt);
            }
        });

        saveBtn.setBackground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("    save");
        saveBtn.setOpaque(true);
        saveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveBtnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                saveBtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveBtnMouseEntered(evt);
            }
        });

        jDateChooser1.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(itemQuantityTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(itemName)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(itemName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(itemQuantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        searchBox.setText("Search...");
        searchBox.setToolTipText("");
        searchBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchBoxMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchBoxMouseEntered(evt);
            }
        });
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBoxKeyReleased(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setText("       back");
        backBtn.setOpaque(true);
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout bodyPanelLayout = new javax.swing.GroupLayout(bodyPanel);
        bodyPanel.setLayout(bodyPanelLayout);
        bodyPanelLayout.setHorizontalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bodyPanelLayout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        bodyPanelLayout.setVerticalGroup(
            bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bodyPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    private void searchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyReleased
        search(searchBox.getText());
    }//GEN-LAST:event_searchBoxKeyReleased
    private void search(String itemName){
        DefaultTableModel table = (DefaultTableModel)itemTable.getModel();
        TableRowSorter<DefaultTableModel> tr;
        tr = new TableRowSorter<>(table);
        itemTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(itemName));
    }
    //empties text box 
    private void searchBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoxMouseEntered
        searchBox.setText("");
    }//GEN-LAST:event_searchBoxMouseEntered
    //returns search text on leaving search text box
    private void searchBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoxMouseExited
        searchBox.setText("Search...");
    }//GEN-LAST:event_searchBoxMouseExited

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        home.setVisible(true);
        home.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_backBtnMouseClicked

    /**
     * Returns days left before an item expires
     * 
     * @param date1 item expiry date
     * @param date2 current date
     * @return days left before item expires
     * @throws java.text.ParseException 
     */
    public int daysBetween(String date1, String date2) throws ParseException{
     SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
     String inputString1 = date1;
     String inputString2 = date2;

        Date d1 = myFormat.parse(inputString1);
        Date d2 = myFormat.parse(inputString2);
        long diff = d1.getTime() - d2.getTime();
        
        return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }
    
    //on click events that adds items to the table
    private void addBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseClicked
        String date1 = dtf.format(localDate);
        String date2 = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        try{
            if(compareYear(date1, date2) == true){
            AddToTable(itemName.getText(), Integer.parseInt(itemQuantityTxt.getText()));
             }
            else{
                JOptionPane.showMessageDialog(null,
                "Item expiry date has passed.",
                "Date warning",
                JOptionPane.WARNING_MESSAGE);
               
                }
            }
            
        catch(NumberFormatException e){
                itemName.setBackground(Color.red);
                itemQuantityTxt.setBackground(Color.red);
                jDateChooser1.setBackground(Color.red);
        }
        clearUi();
        
    }//GEN-LAST:event_addBtnMouseClicked
    
    /**
     *enables adding item to the item table
     * 
     * @param itemName name of item being added
     * @param itemQuantity quantity of item being added
     */
    public void AddToTable(String itemName, int itemQuantity){
        DefaultTableModel table = (DefaultTableModel)itemTable.getModel();
        String expiryDate;
        expiryDate = ((JTextField)jDateChooser1.getDateEditor().getUiComponent()).getText();
        String dateAdded = dtf.format(localDate);
        try {
            int daysLeft = daysBetween(expiryDate,dateAdded);
            table.addRow(new Object[]{itemName, itemQuantity, dateAdded, expiryDate, daysLeft});
        } catch (ParseException ex) {
            Logger.getLogger(AddClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
    
    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        hoverBtn(backBtn);
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        backBtn.setBackground(Color.WHITE);
    }//GEN-LAST:event_backBtnMouseExited

    private void addBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseEntered
        hoverBtn(addBtn);
    }//GEN-LAST:event_addBtnMouseEntered

    private void addBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBtnMouseExited
        addBtn.setBackground(Color.white);
    }//GEN-LAST:event_addBtnMouseExited

    private void itemNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemNameMouseClicked
       itemName.setBackground(Color.white);
    }//GEN-LAST:event_itemNameMouseClicked

    private void itemQuantityTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemQuantityTxtMouseClicked
        itemQuantityTxt.setBackground(Color.white);
    }//GEN-LAST:event_itemQuantityTxtMouseClicked
    //deletes a column of item from the table
    private void delBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtnMouseClicked
        int selectedRow = itemTable.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "No items selected");
        } else {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this item?", "Warning", dialogButton);
            if (dialogResult == JOptionPane.YES_OPTION) {

                int numberOfSelectedRows = itemTable.getSelectedRowCount();
                           for (int i = 0; i < numberOfSelectedRows; i++) {
                           selectedRow = itemTable.getSelectedRow();

                ((DefaultTableModel) itemTable.getModel()).removeRow(selectedRow);
                }
            }
        }           
    }//GEN-LAST:event_delBtnMouseClicked

    private void delBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtnMouseEntered
        hoverBtn(delBtn);
    }//GEN-LAST:event_delBtnMouseEntered

    private void delBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delBtnMouseExited
        delBtn.setBackground(Color.white);
    }//GEN-LAST:event_delBtnMouseExited

    private void saveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseClicked
         try{
            saveFile();
        } catch (Exception e){
        }
        
    }//GEN-LAST:event_saveBtnMouseClicked

    private void saveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseEntered
        hoverBtn(saveBtn);
    }//GEN-LAST:event_saveBtnMouseEntered

    private void saveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveBtnMouseExited
        saveBtn.setBackground(Color.white);
    }//GEN-LAST:event_saveBtnMouseExited
    /**
    * Changes the color of a label 
    * 
    * @param label the label object to change color
    */
    private void hoverBtn(JLabel label){
        Color myCustomColor = new Color(231, 76, 60);
        label.setBackground(myCustomColor);

    }
    
    

    /**
     * Empties all textBoxes text after clicking
     */
    public void clearUi(){
        itemName.setText("");
        itemQuantityTxt.setText("");    
    }    
 
   
       /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(AddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel addBtn;
    private javax.swing.JLabel backBtn;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JLabel delBtn;
    public javax.swing.JTextField itemName;
    public javax.swing.JTextField itemQuantityTxt;
    private javax.swing.JTable itemTable;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel saveBtn;
    public javax.swing.JTextField searchBox;
    // End of variables declaration//GEN-END:variables

    private HomeGui HomeGui() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
