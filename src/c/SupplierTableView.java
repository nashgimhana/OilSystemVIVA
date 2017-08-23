/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import m.Supplier;
import v.SupplierView;

/**
 *
 * @author User
 */
public class SupplierTableView {
    //settabledata

    public void setTableData(JTable table) {
        try {
//            System.out.println("supplier table viw ekta awa");

            Supplier sup = new Supplier();
            ArrayList<pojo.Supplier> viewAllSuppliers = sup.viewAllSuppliers();
            
            DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
            defaultTableModel.setRowCount(0);
            for (pojo.Supplier supplier : viewAllSuppliers) {
                if (supplier.getStatus().equals(1)) {
                    Vector v = new Vector();
                    v.add(supplier.getId().toString());
//                    System.out.println("supplier table for ekta awa");
                    v.add(supplier.getName().toString());
                    v.add(supplier.getAdressLine1().toString());
                    v.add(supplier.getAdressLine2().toString());
                    v.add(supplier.getAdressLine3().toString());
                    v.add(supplier.getContact1().toString());
                    v.add(supplier.getContact2().toString());
                    v.add(supplier.getContact3().toString());
                    v.add(supplier.getStatus().toString());
                    v.add(supplier.getDetails().toString());
                    v.add(supplier.getCurrentCredit().toString());
                    defaultTableModel.addRow(v);
                } else {
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void setTableDataOnTextField(JTable jTable, JLabel id, JTextField name, JTextField address1, JTextField address2, JTextField address3, JTextField contact1, JTextField contact2, JTextField contact3, JTextField details, JTextField crntcredit) {
        try {
            int row = jTable.getSelectedRow();
            
            id.setText("id " + jTable.getModel().getValueAt(row, 0).toString());
            name.setText(jTable.getModel().getValueAt(row, 1).toString());
            address1.setText(jTable.getModel().getValueAt(row, 2).toString());
            address2.setText(jTable.getModel().getValueAt(row, 3).toString());
            address3.setText(jTable.getModel().getValueAt(row, 4).toString());
            contact1.setText(jTable.getModel().getValueAt(row, 5).toString());
            contact2.setText(jTable.getModel().getValueAt(row, 6).toString());
            contact3.setText(jTable.getModel().getValueAt(row, 7).toString());
            details.setText(jTable.getModel().getValueAt(row, 9).toString());
            crntcredit.setText(String.valueOf(0.0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
