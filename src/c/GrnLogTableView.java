/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pojo.GrnLog;
import pojo.Product;
import pojo.Units;

/**
 *
 * @author User
 */
public class GrnLogTableView {

    public void setGrnLogTableData(JTable jTable, JComboBox comboBox) {
        try {
            String name = (String) comboBox.getSelectedItem();
            Product byprName = new m.Product().getByprName(name);

//            Units unit1 = new m.Units().getBy(byprName.getUnits().getId());
//            unit.setText(unit1.getUnitName());
//        GrnLog grnLog = new pojo.GrnLog();
//        grnLog.setProduct(byprName);
//        ArrayList<GrnLog> product = new m.GrnLog().allTestGrnL(grnLog);
//        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
//        dtm.setRowCount(0);
//        for (GrnLog grnLog1 : product) {
//            Vector v = new Vector();
//            v.add(grnLog1.getId());
//            v.add(byprName.getName());
//            v.add(grnLog1.getQuantity());
//            v.add(grnLog1.getRemainingQuantity());
//            dtm.addRow(v);
//        }
            ArrayList<GrnLog> grn = new m.GrnLog().grn1(byprName);
            DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
            dtm.setRowCount(0);

            for (GrnLog grnLog : grn) {
                Vector v = new Vector();
                //v.add(grnLog.getId());
                v.add(grnLog.getId());
                v.add(byprName.getName());
//                Units unit = new m.Units().getBy(byprName.getUnits().getId());
//                v.add(unit.getUnitName());
//            v.add(byprName.getUnits().getUnitName());
                Double quantity = grnLog.getQuantity();
                quantity = (Math.round(quantity * 100.0) / 100.0);

                v.add(quantity);
                Double remainingQuantity = grnLog.getRemainingQuantity();
                remainingQuantity = (Math.round(remainingQuantity * 100.0) / 100.0);
                v.add(remainingQuantity);

                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Double getTableTotal(JTable jTable) {
        Double sum = 0.00;
        sum = (Math.round(sum * 100.0) / 100.0);
        try {
            for (int i = 0; i < jTable.getRowCount(); i++) {
                sum = sum + Double.parseDouble(jTable.getValueAt(i, 3).toString());
                sum = (Math.round(sum * 100.0) / 100.0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sum;
    }
    
    public void getUnit(JTable jTable,JTextField unit){
        String pname = null;
        try {
            if (jTable.getRowCount() == 0) {
                unit.setText(null);
            }else{
            for (int i = 0; i < jTable.getRowCount(); i++) {
                pname = jTable.getValueAt(i, 1).toString();
            }
            System.out.println("Pname : "+pname);
            
            Product product = new m.Product().getByName(pname);
            Units unit1 = new m.Units().getBy(product.getUnits().getId());
            unit.setText(unit1.getUnitName());}
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
