/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;

import c.Errormzg;
import c.SuplierController;
import c.SupplierTableView;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author suhada
 */
public class SupplierView extends javax.swing.JPanel {

    /**
     * @return the text
     */
    SuplierController sc = null;
    SupplierTableView tableView = null;

    /**
     * Creates new form Suppllier
     */
    public SupplierView() {
        initComponents();
        tableView = new SupplierTableView();
        tableView.setTableData(jTable1);
    }
    public static SupplierView SupplierView = null;

    public static SupplierView getInstance() {
        if (SupplierView == null) {
            SupplierView = new SupplierView();
        }
        return SupplierView;
    }

    public void displayerrorMessage(String errormsg) {
        JOptionPane.showMessageDialog(this, errormsg, "Error", JOptionPane.ERROR_MESSAGE);

    }

    public void displayconfirmMessage(String confirm) {
        JOptionPane.showMessageDialog(this, confirm, "Successfull", JOptionPane.INFORMATION_MESSAGE);

    }

    public void clear() {

        lblid.setText("");
        txtname.setText("");
        txtadressl1.setText("");
        txtadressl2.setText("");
        txtadressl3.setText("");
        contact1.setText("");
        contact2.setText("");
        contact3.setText("");
        details.setText("");
        txtcrntcrdt.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtname = new javax.swing.JTextField();
        txtadressl1 = new javax.swing.JTextField();
        txtadressl2 = new javax.swing.JTextField();
        txtadressl3 = new javax.swing.JTextField();
        contact1 = new javax.swing.JTextField();
        contact2 = new javax.swing.JTextField();
        contact3 = new javax.swing.JTextField();
        txtcrntcrdt = new javax.swing.JTextField();
        details = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblid = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnsave = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();

        setBackground(c.View.getInstance().colorTheme);

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setMaximumSize(new java.awt.Dimension(400, 32767));
        jPanel4.setPreferredSize(new java.awt.Dimension(400, 426));
        jPanel4.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        jPanel6.setMaximumSize(new java.awt.Dimension(250, 2147483647));
        jPanel6.setMinimumSize(new java.awt.Dimension(200, 205));
        jPanel6.setPreferredSize(new java.awt.Dimension(250, 279));
        jPanel6.setLayout(new java.awt.GridLayout(9, 0, 0, 15));

        txtname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel6.add(txtname);

        txtadressl1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtadressl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel6.add(txtadressl1);

        txtadressl2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtadressl2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel6.add(txtadressl2);

        txtadressl3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtadressl3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        jPanel6.add(txtadressl3);

        contact1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contact1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        contact1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contact1KeyTyped(evt);
            }
        });
        jPanel6.add(contact1);

        contact2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contact2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        contact2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contact2KeyTyped(evt);
            }
        });
        jPanel6.add(contact2);

        contact3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        contact3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        contact3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contact3ActionPerformed(evt);
            }
        });
        contact3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contact3KeyTyped(evt);
            }
        });
        jPanel6.add(contact3);

        txtcrntcrdt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtcrntcrdt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        txtcrntcrdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcrntcrdtActionPerformed(evt);
            }
        });
        txtcrntcrdt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcrntcrdtKeyTyped(evt);
            }
        });
        jPanel6.add(txtcrntcrdt);

        details.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        details.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 0)));
        details.setMaximumSize(new java.awt.Dimension(2147483647, 60));
        details.setMinimumSize(new java.awt.Dimension(6, 100));
        details.setPreferredSize(new java.awt.Dimension(6, 100));
        jPanel6.add(details);

        jPanel4.add(jPanel6);

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 43, 344, 396));

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Address line 1", "Address line 2", "Address line 3", "Contact 1", "Contact 2", "Contact 3", "Status", "Details", "current credit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, 630, 480));

        lblid.setBackground(new java.awt.Color(255, 255, 255));
        lblid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblid.setForeground(new java.awt.Color(255, 51, 0));
        lblid.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.add(lblid, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 160, 26));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setMinimumSize(new java.awt.Dimension(150, 87));
        jPanel5.setPreferredSize(new java.awt.Dimension(150, 100));
        jPanel5.setLayout(new java.awt.GridLayout(9, 0, 0, 15));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Name");
        jLabel2.setMaximumSize(new java.awt.Dimension(150, 36));
        jLabel2.setMinimumSize(new java.awt.Dimension(100, 17));
        jLabel2.setPreferredSize(new java.awt.Dimension(150, 17));
        jPanel5.add(jLabel2);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Adress line 1");
        jLabel1.setMaximumSize(new java.awt.Dimension(150, 36));
        jLabel1.setMinimumSize(new java.awt.Dimension(100, 17));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 17));
        jPanel5.add(jLabel1);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Adress line 2");
        jLabel3.setMaximumSize(new java.awt.Dimension(150, 36));
        jLabel3.setMinimumSize(new java.awt.Dimension(100, 17));
        jLabel3.setPreferredSize(new java.awt.Dimension(150, 17));
        jPanel5.add(jLabel3);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Adress line 3");
        jLabel4.setMaximumSize(new java.awt.Dimension(150, 36));
        jLabel4.setMinimumSize(new java.awt.Dimension(100, 17));
        jLabel4.setPreferredSize(new java.awt.Dimension(150, 17));
        jPanel5.add(jLabel4);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Contact 1");
        jLabel5.setMaximumSize(new java.awt.Dimension(150, 36));
        jLabel5.setMinimumSize(new java.awt.Dimension(100, 17));
        jLabel5.setPreferredSize(new java.awt.Dimension(150, 17));
        jPanel5.add(jLabel5);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Contact 2");
        jLabel6.setMaximumSize(new java.awt.Dimension(150, 36));
        jLabel6.setMinimumSize(new java.awt.Dimension(100, 17));
        jLabel6.setPreferredSize(new java.awt.Dimension(150, 17));
        jPanel5.add(jLabel6);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Contact 3");
        jLabel7.setMaximumSize(new java.awt.Dimension(150, 36));
        jLabel7.setMinimumSize(new java.awt.Dimension(100, 17));
        jLabel7.setPreferredSize(new java.awt.Dimension(150, 17));
        jPanel5.add(jLabel7);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Current credit");
        jLabel9.setMaximumSize(new java.awt.Dimension(150, 36));
        jLabel9.setPreferredSize(new java.awt.Dimension(150, 17));
        jPanel5.add(jLabel9);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("More details");
        jLabel8.setMaximumSize(new java.awt.Dimension(150, 36));
        jLabel8.setMinimumSize(new java.awt.Dimension(100, 17));
        jLabel8.setPreferredSize(new java.awt.Dimension(150, 17));
        jPanel5.add(jLabel8);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 43, 170, 400));

        btnsave.setBackground(new java.awt.Color(255, 255, 255));
        btnsave.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnsave.setText("Add");
        btnsave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsaveMouseClicked(evt);
            }
        });
        btnsave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btnsaveKeyTyped(evt);
            }
        });
        jPanel1.add(btnsave, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 480, 100, 37));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("Clear");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, 90, 40));

        jScrollPane1.setViewportView(jPanel1);

        jTabbedPane1.addTab("Supplier Register", jScrollPane1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1204, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(jPanel3);

        jTabbedPane1.addTab("Supplier Status", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        tableView.setTableDataOnTextField(jTable1, lblid, txtname, txtadressl1, txtadressl2, txtadressl3, contact1, contact2, contact3, details, txtcrntcrdt);
    }//GEN-LAST:event_jTable1MouseClicked

    public int savesupp() {
        try {
            sc = new SuplierController();
            int id;
            if (!lblid.getText().equals("")) {
                id = Integer.parseInt(lblid.getText().split(" ")[1].toString());
                int done = sc.savecontroller(id, txtname.getText(), txtadressl1.getText(), txtadressl2.getText(), txtadressl3.getText(), contact1.getText(), contact2.getText(), contact3.getText(), details.getText(), Double.parseDouble(txtcrntcrdt.getText()));
                if (done != 0) {
                    tableView.setTableData(jTable1);
                    Errormzg.displayconfirmMessage("successfully updated");
                    clear();
                    return 1;
                } else {
                    Errormzg.displayerrorMessage("uanable to complete");
                    return 0;
                }

            } else {
                id = 0;
                int done = sc.savecontroller(id, txtname.getText(), txtadressl1.getText(), txtadressl2.getText(), txtadressl3.getText(), contact1.getText(), contact2.getText(), contact3.getText(), details.getText(), Double.parseDouble(txtcrntcrdt.getText()));
                if (done != 0) {
                    tableView.setTableData(jTable1);
                    Errormzg.displayconfirmMessage("successfully saved");
                    clear();
                    return 1;
                } else {
                    Errormzg.displayerrorMessage("uanable to complete");
                    return 0;
                }

            }
        } catch (Exception e) {
            return 0;
        }
    }
    private void btnsaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsaveMouseClicked

        if (!txtname.getText().trim().isEmpty()) {
            if (!txtadressl1.getText().trim().isEmpty()) {
                if (!txtadressl2.getText().trim().isEmpty()) {
                    if (!contact1.getText().trim().isEmpty()) {
                        if (!contact3.getText().trim().isEmpty()) {
                            if (!txtcrntcrdt.getText().trim().isEmpty()) {
                                savesupp();
                            } else {
                                Errormzg.displayerrorMessage("Empty Fields");
                            }
                        } else {
                            Errormzg.displayerrorMessage("Empty Fields");
                        }
                    } else {
                        Errormzg.displayerrorMessage("Empty Fields");
                    }
                } else {
                    Errormzg.displayerrorMessage("Empty Fields");
                }
            } else {
                Errormzg.displayerrorMessage("Empty Fields");
            }

        } else {
            Errormzg.displayerrorMessage("Empty Fields");
        }
    }//GEN-LAST:event_btnsaveMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        clear();
    }//GEN-LAST:event_jButton1MouseClicked

    private void txtcrntcrdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcrntcrdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcrntcrdtActionPerformed

    private void contact3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contact3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contact3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnsaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnsaveKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!txtname.getText().trim().isEmpty()) {
                if (!txtadressl1.getText().trim().isEmpty()) {
                    if (!txtadressl2.getText().trim().isEmpty()) {
                        if (!contact1.getText().trim().isEmpty()) {
                            if (!contact3.getText().trim().isEmpty()) {
                                if (!txtcrntcrdt.getText().trim().isEmpty()) {
                                    savesupp();
                                } else {
                                    Errormzg.displayerrorMessage("Empty Fields");
                                }
                            } else {
                                Errormzg.displayerrorMessage("Empty Fields");
                            }
                        } else {
                            Errormzg.displayerrorMessage("Empty Fields");
                        }
                    } else {
                        Errormzg.displayerrorMessage("Empty Fields");
                    }
                } else {
                    Errormzg.displayerrorMessage("Empty Fields");
                }

            } else {
                Errormzg.displayerrorMessage("Empty Fields");
            }
        }
    }//GEN-LAST:event_btnsaveKeyTyped

    private void txtcrntcrdtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcrntcrdtKeyTyped
        // TODO add your handling code here:
//        char caracter = evt.getKeyChar();
//        if (((caracter < '0') || (caracter > '9'))
//                && (caracter != '\b')) {
//            evt.consume();
//        } else {
//        }
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtcrntcrdtKeyTyped

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        tableView = new SupplierTableView();
        tableView.setTableData(jTable1);
    }//GEN-LAST:event_jPanel1MouseMoved

    private void contact1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contact1KeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_contact1KeyTyped

    private void contact2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contact2KeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_contact2KeyTyped

    private void contact3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contact3KeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_contact3KeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsave;
    private javax.swing.JTextField contact1;
    private javax.swing.JTextField contact2;
    private javax.swing.JTextField contact3;
    private javax.swing.JTextField details;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblid;
    private javax.swing.JTextField txtadressl1;
    private javax.swing.JTextField txtadressl2;
    private javax.swing.JTextField txtadressl3;
    private javax.swing.JTextField txtcrntcrdt;
    private javax.swing.JTextField txtname;
    // End of variables declaration//GEN-END:variables
}
