/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;

import c.AutoComplete;
import c.VehicleRegister;
import c.VehicleUpdate;
import c.VehicleViewTable;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Me
 */
public class Vehicle extends javax.swing.JPanel {

    /**
     * Creates new form Vehicle
     */
    private VehicleViewTable vehicleViewTable = null;

    private void clear() {

        tf_regNumber2.setText(null);
        tf_regNumber1.setText(null);
        int rowCount = tbl_allVehicles.getRowCount();
        tf_id.setText(String.valueOf(rowCount + 1));

    }

    public Vehicle() {
        initComponents();

        vehicleViewTable = new VehicleViewTable();

        vehicleViewTable.setTableData(tbl_allVehicles);

        new AutoComplete().autocompleteRegNm1(tf_regNumber1);
//        if (scb_regNum1.getItemCount() != 0) {
//            scb_regNum1.removeAllItems();
//        }

        //scb_regNum1.setModel(new AutoComplete().auctoCompleteRegNum1(scb_regNum1));

    }
    public static Vehicle vehicle = null;

    public static Vehicle getInstance() {
        if (vehicle == null) {
            vehicle = new Vehicle();
        }
        return vehicle;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tf_regNumber1 = new javax.swing.JTextField();
        tf_regNumber2 = new javax.swing.JTextField();
        btn_vRegister = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_vUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_allVehicles = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf_routeId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_routeName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setBackground(c.View.getInstance().colorTheme);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(c.View.getInstance().colorTheme);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Vehicle Registration Number");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Vehicle Trailer Number");

        tf_regNumber1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_regNumber1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_regNumber1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_regNumber1KeyTyped(evt);
            }
        });

        tf_regNumber2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_vRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_vRegister.setText("Save");
        btn_vRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_vRegisterMouseReleased(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_clearMouseReleased(evt);
            }
        });

        btn_vUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_vUpdate.setText("Update");
        btn_vUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_vUpdateMouseReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id");

        tf_id.setEditable(false);
        tf_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_vUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_regNumber1)
                    .addComponent(tf_regNumber2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_vRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_id)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_regNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tf_regNumber2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_vRegister)
                .addGap(18, 18, 18)
                .addComponent(btn_vUpdate)
                .addGap(18, 18, 18)
                .addComponent(btn_clear)
                .addContainerGap(196, Short.MAX_VALUE))
        );

        tbl_allVehicles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_allVehicles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Vehicle Registration Number ", "Vehicle Trailer Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_allVehicles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_allVehiclesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_allVehicles);
        if (tbl_allVehicles.getColumnModel().getColumnCount() > 0) {
            tbl_allVehicles.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab1", jPanel4);

        jPanel8.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setText("Route Register");

        tf_routeId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setText("Id");

        jLabel6.setText("Route Name");

        tf_routeName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_routeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_routeNameActionPerformed(evt);
            }
        });

        jLabel7.setText("Route Description");

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2)
                    .addComponent(tf_routeName)
                    .addComponent(tf_routeId))
                .addContainerGap(467, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(10, 10, 10)
                .addComponent(tf_routeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(tf_routeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel6);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_vRegisterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vRegisterMouseReleased
        // TODO add your handling code here:

        VehicleRegister vehicleRegister = new VehicleRegister();

        int setData = vehicleRegister.setData(tf_regNumber1, tf_id,vehicle);
        if (setData == 3) {
            int confirm = 0;
            confirm = JOptionPane.showConfirmDialog(vehicle, "Do u want to update","Title", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == 0) {
                   btn_vUpdateMouseReleased(evt);
                }else{
                System.out.println("Cancel update");
            }
            //btn_vUpdateMouseReleased(evt);
        }
        clear();
        vehicleViewTable.setTableData(tbl_allVehicles);
//         if (scb_regNum1.getItemCount() != 0) {
//            scb_regNum1.removeAllItems();
//        }
        //scb_regNum1.setModel(new AutoComplete().auctoCompleteRegNum1(scb_regNum1));
        //new AutoComplete().autocompleteRegNm1(tf_regNumber1);


    }//GEN-LAST:event_btn_vRegisterMouseReleased

    private void btn_clearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseReleased
        // TODO add your handling code here:
        clear();

    }//GEN-LAST:event_btn_clearMouseReleased

    private void tbl_allVehiclesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_allVehiclesMouseClicked
        // TODO add your handling code here:
        vehicleViewTable.setTableDataOnTextField(tbl_allVehicles, tf_regNumber1, tf_id);

    }//GEN-LAST:event_tbl_allVehiclesMouseClicked

    private void btn_vUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vUpdateMouseReleased
        // TODO add your handling code here:
        VehicleUpdate vehicleUpdate = new VehicleUpdate();
        vehicleUpdate.updateVehicle(tf_id, tf_regNumber1,  vehicle);
        clear();
        vehicleViewTable.setTableData(tbl_allVehicles);
        //new AutoComplete().autocompleteRegNm1(tf_regNumber1);
         //if (scb_regNum1.getItemCount() != 0) {
         //   scb_regNum1.removeAllItems();
        //}
        //scb_regNum1.setModel(new AutoComplete().auctoCompleteRegNum1(scb_regNum1));

    }//GEN-LAST:event_btn_vUpdateMouseReleased

    private void tf_regNumber1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_regNumber1KeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_tf_regNumber1KeyTyped

    private void tf_regNumber1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_regNumber1KeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            //JOptionPane.showConfirmDialog(vehicle, tf_regNumber1.getText());
            new AutoComplete().fillRegNm2(tf_regNumber1, tf_id);

            //tf_regNumber2.setText(fillRegNm2);
            //JOptionPane.showConfirmDialog(vehicle, fillRegNm2);
        }
    }//GEN-LAST:event_tf_regNumber1KeyReleased

    private void tf_routeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_routeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_routeNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_vRegister;
    private javax.swing.JButton btn_vUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tbl_allVehicles;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_regNumber1;
    private javax.swing.JTextField tf_regNumber2;
    private javax.swing.JTextField tf_routeId;
    private javax.swing.JTextField tf_routeName;
    // End of variables declaration//GEN-END:variables
}
