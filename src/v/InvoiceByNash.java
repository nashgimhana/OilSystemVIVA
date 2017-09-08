/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;

import c.AutoComplete;
import c.Errormzg;
//import c.CustomerSearch;
//import c.CustomerTableView;
import c.InvoiceAddToTable;
import c.InvoiceProductNameLord;
import c.InvoiceSave;
import c.InvoiceSearchProductDetails;
import c.invoicecontroller;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import pojo.Product;

/**
 *
 * @author shanaka
 */
public class InvoiceByNash extends javax.swing.JPanel {

    /**
     * Creates new form Invoice
     */
    public static InvoiceByNash invoice = null;

    InvoiceProductNameLord invpLod = null;
    InvoiceSearchProductDetails Searchproduct = null;
    InvoiceAddToTable invAddToTable = null;
    InvoiceSave invSave = null;
//    Invoice_Pay iPay = null;
//    InvoicePayment invoicePayment = null;
    Double currentStock = 00.0;
    invoicecontroller ic;

    //new
    private static CustomerView customerView = null;
    //private CustomerTableView customerTableView = null;

    public InvoiceByNash() {
        initComponents();
        ProductNameLoadCombo();
        cheque();
    }

    public static InvoiceByNash getInstance() {
        if (invoice == null) {
            invoice = new InvoiceByNash();
        }

        return invoice;
    }

    public void ProductNameLoadCombo() {
        invpLod = new InvoiceProductNameLord();
        invpLod.getAllProduct(cmbProductList);
    }

    public void clearTf() {
        cmbProductList.setSelectedIndex(0);
        lblCurrentStock.setText(null);
        tfSellingPrice.setText(null);
        tfQty.setText(null);

    }

    public void clearAll() {
        cmbProductList.setSelectedIndex(0);
        lblCurrentStock.setText(null);
        tfSellingPrice.setText(null);
        tfQty.setText(null);
        tfCustomer.setText(null);

        tfCustomer.setText(null);
        lblFullTotal.setText("");
        findcusidbyname = null;

    }

    public void cleartbl() {
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        String ProductName = null;
        try {
            if (jTable2.getRowCount() > 0) {
                int rc = jTable2.getRowCount();
                for (int i = 0; i < rc; i++) {
                    ProductName = (String) jTable2.getValueAt(i, 0);
                    Product product = new m.Product().getByName(ProductName);
                    double cstk = product.getCurrentStock();
                    double qty = Double.parseDouble((String) jTable2.getValueAt(i, 2));
                    double ncstk = cstk + qty;

                    product.setCurrentStock(ncstk);
                    new m.Product().update(product);

                }
                dtm.setRowCount(0);

                double ftot = 0.00;

                lblFullTotal.setText(v.Employee.getRound(ftot));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void cheque() {
        try {
//            cmbBank.setEnabled(false);
//            tfChequeNo.setEnabled(false);
//            tfChequeAmount.setEnabled(false);
//            tfChequeTot.setEnabled(false);
//            tblCheque.setEnabled(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        base1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tfCustomer = new javax.swing.JTextField();
        DateChooser = new com.toedter.calendar.JDateChooser();
        cmbProductList = new javax.swing.JComboBox<>();
        lblCurrentStock = new javax.swing.JLabel();
        tfSellingPrice = new javax.swing.JTextField();
        tfQty = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        lblunit = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lblFullTotal = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 204, 0));

        base1.setBackground(new java.awt.Color(255, 255, 255));
        base1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.cyan, new java.awt.Color(51, 51, 255), java.awt.Color.cyan, java.awt.Color.blue), "INVOICE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bodoni Bd BT", 1, 18))); // NOI18N
        base1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridLayout(8, 0, 50, 10));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("CUSTOMER");
        jLabel12.setAlignmentX(0.5F);
        jPanel5.add(jLabel12);

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText(" DATE");
        jLabel11.setAlignmentX(0.5F);
        jPanel5.add(jLabel11);

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("PRODUCT");
        jLabel13.setAlignmentX(0.5F);
        jPanel5.add(jLabel13);

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("CURRENT STOCK");
        jLabel15.setAlignmentX(0.5F);
        jPanel5.add(jLabel15);

        jLabel14.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("SELLING PRICE");
        jLabel14.setAlignmentX(0.5F);
        jPanel5.add(jLabel14);

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText(" QTY");
        jLabel16.setAlignmentX(0.5F);
        jPanel5.add(jLabel16);
        jPanel5.add(jLabel10);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(8, 0, 0, 10));

        tfCustomer.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tfCustomer.setNextFocusableComponent(DateChooser);
        tfCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCustomerKeyTyped(evt);
            }
        });
        jPanel4.add(tfCustomer);
        jPanel4.add(DateChooser);

        cmbProductList.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        cmbProductList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "select product" }));
        cmbProductList.setNextFocusableComponent(tfQty);
        cmbProductList.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbProductListItemStateChanged(evt);
            }
        });
        jPanel4.add(cmbProductList);

        lblCurrentStock.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblCurrentStock.setForeground(new java.awt.Color(255, 0, 0));
        lblCurrentStock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCurrentStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(lblCurrentStock);

        tfSellingPrice.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tfSellingPrice.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfSellingPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfSellingPriceKeyTyped(evt);
            }
        });
        jPanel4.add(tfSellingPrice);

        tfQty.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tfQty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfQty.setNextFocusableComponent(cmbProductList);
        tfQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfQtyKeyTyped(evt);
            }
        });
        jPanel4.add(tfQty);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("ADD TO CART");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton4MouseReleased(evt);
            }
        });
        jPanel4.add(jButton4);

        lblunit.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblunit, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(lblunit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        base1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 370, 430));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Remove item");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton6MouseReleased(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, 20));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Remove All");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton7MouseReleased(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, -1, 20));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Products", "Sell Price", "Qty", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 690, 370));

        base1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 720, 430));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setText("FULL TOTAL");
        base1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 140, 30));

        lblFullTotal.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        lblFullTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblFullTotal.setText("00.00   ");
        lblFullTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255), 2));
        base1.add(lblFullTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 510, 200, 30));

        jButton3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jButton3.setText("Save");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton3MouseReleased(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        base1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, 150, 40));

        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jButton1MouseReleased(evt);
            }
        });
        base1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 550, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(base1, javax.swing.GroupLayout.DEFAULT_SIZE, 1147, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(base1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProductListItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbProductListItemStateChanged
        // after selcted item ,loard grnlog data to jTable1:
        try {
            Searchproduct = new InvoiceSearchProductDetails();
            Searchproduct.getProductDet(cmbProductList, lblCurrentStock, tfSellingPrice, lblunit);

            tfQty.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_cmbProductListItemStateChanged

    pojo.Customer findcusidbyname = null;
    private void tfCustomerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCustomerKeyTyped
        // Auto Completer customer Nic :
//        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
//            invAddToTable = new InvoiceAddToTable();
//            // invAddToTable.setCusIdToLbl(tfCustomer, lblCusId);
//            CustomerSearch customerSearch = new c.CustomerSearch();
//            customerSearch.currentCredit(tfCustomer, lblCurrentCreditBal);
//        }
        ic = new invoicecontroller();
        new AutoComplete().autoCompleteCustomerNic(tfCustomer);
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            findcusidbyname = ic.findCusIdByName(tfCustomer.getText());
            if (findcusidbyname != null) {
                tfCustomer.setForeground(Color.blue);
            } else {
                tfCustomer.setForeground(Color.red);
            }
        }
    }//GEN-LAST:event_tfCustomerKeyTyped

    private void tfQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtyKeyReleased
        // Qty ENTER:

    }//GEN-LAST:event_tfQtyKeyReleased

    private void tfSellingPriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSellingPriceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSellingPriceKeyTyped

    private void tfQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQtyKeyTyped
        // TODO add your handling code here:
        m.Employee.validateDouble(tfQty, evt);
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            double cuStk = Double.parseDouble(lblCurrentStock.getText());
            double qty = Double.parseDouble(tfQty.getText());
            if (cuStk >= qty) {
                invAddToTable = new InvoiceAddToTable();
                invAddToTable.setAddToTable(tfCustomer, DateChooser, cmbProductList, tfQty, tfSellingPrice, jTable2, lblCurrentStock, lblFullTotal, base1);
                invAddToTable.settot(jTable2, lblFullTotal);
                cmbProductList.setSelectedIndex(0);
                //lblCurrentStock.setText(null);
                //tfSellingPrice.setText(null);
                tfQty.setText(null);
                cmbProductList.requestFocus();
            } else {
                c.Errormzg.displayconfirmMessage("Please Enter Less Value Than Current Stock");
            }

        }

    }//GEN-LAST:event_tfQtyKeyTyped

    private void jButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseReleased
        // TODO add your handling code here: try
        try {
            double cuStk = Double.parseDouble(lblCurrentStock.getText());
            double qty = Double.parseDouble(tfQty.getText());
            if (cuStk >= qty) {
                invAddToTable = new InvoiceAddToTable();
                invAddToTable.setAddToTable(tfCustomer, DateChooser, cmbProductList, tfQty, tfSellingPrice, jTable2, lblCurrentStock, lblFullTotal, base1);
                invAddToTable.settot(jTable2, lblFullTotal);
                cmbProductList.setSelectedIndex(0);
                // lblCurrentStock.setText(null);
                // tfSellingPrice.setText(null);
                tfQty.setText(null);
                cmbProductList.requestFocus();
            } else {
                c.Errormzg.displayconfirmMessage("Please Enter Less Value Than Current Stock");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton4MouseReleased

    private void jButton6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseReleased
        // TODO add your handling code here:
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
            if (jTable2.getSelectedRow() >= 0) {
                int rw = jTable2.getSelectedRow();
                String ProductName = (String) jTable2.getValueAt(rw, 0);
                Product product = new m.Product().getByName(ProductName);
                double qty = Double.parseDouble((String) jTable2.getValueAt(rw, 2));
                double cstk = product.getCurrentStock();
                double ncstk = cstk + qty;
                product.setCurrentStock(ncstk);
                new m.Product().update(product);

                dtm.removeRow(rw);
                int rc = jTable2.getRowCount();
                double ftot = 0.00;
                for (int i = 0; i < rc; i++) {
                    ftot += Double.parseDouble(jTable2.getValueAt(i, 3).toString());
                }
                lblFullTotal.setText(v.Employee.getRound(ftot));

            } else {
                JOptionPane.showMessageDialog(null, "No Selected Row! Please select.", "Row Remove", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6MouseReleased

    private void jButton7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseReleased
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
        String ProductName = null;
        if (jTable2.getRowCount() > 0) {
            int rc = jTable2.getRowCount();
            for (int i = 0; i < rc; i++) {
                ProductName = (String) jTable2.getValueAt(i, 0);
                Product product = new m.Product().getByName(ProductName);
                double cstk = product.getCurrentStock();
                double qty = Double.parseDouble((String) jTable2.getValueAt(i, 2));
                double ncstk = cstk + qty;

                product.setCurrentStock(ncstk);
                new m.Product().update(product);

            }
            dtm.setRowCount(0);

            double ftot = 0.00;

            lblFullTotal.setText(v.Employee.getRound(ftot));
        } else {
            JOptionPane.showMessageDialog(null, "No Selected Row! Please add one more.", "Row Remove", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton7MouseReleased

    private void jButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseReleased
        // TODO add your handling code here:

        incash in = new incash();
        if (findcusidbyname != null) {
            in.setvalues(findcusidbyname, DateChooser.getDate(), jTable2, Double.parseDouble(lblFullTotal.getText()));
            in.setVisible(true);
        } else {
            Errormzg.displayerrorMessage("Please set suplier and press Enter");
        }

    }//GEN-LAST:event_jButton3MouseReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseReleased
        // TODO add your handling code here:
        cleartbl();
        clearAll();
    }//GEN-LAST:event_jButton1MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JPanel base1;
    private javax.swing.JComboBox<String> cmbProductList;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblCurrentStock;
    private javax.swing.JLabel lblFullTotal;
    private javax.swing.JLabel lblunit;
    private javax.swing.JTextField tfCustomer;
    private javax.swing.JTextField tfQty;
    private javax.swing.JTextField tfSellingPrice;
    // End of variables declaration//GEN-END:variables
}
