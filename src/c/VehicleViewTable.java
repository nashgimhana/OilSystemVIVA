/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import m.Vehicle;
import static v.Delivery.vehicle;

/**
 *
 * @author Me
 */
public class VehicleViewTable {

    public void setTableData(JTable table) {

        try {
            Vehicle vehicle = new Vehicle();
        ArrayList<pojo.Vehicle> viewAllVehicle = vehicle.viewAllVehicle();

        DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);
        for (pojo.Vehicle vehicle1 : viewAllVehicle) {
            Vector v = new Vector();
            v.add(vehicle1.getId().toString().trim());
            v.add(vehicle1.getNumber1().trim());
            //v.add(vehicle1.getNumber2().trim());
            defaultTableModel.addRow(v);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setTableDataOnTextField(JTable jTable, JTextField regNm1, JTextField id) {
        try {
            int row = jTable.getSelectedRow();
            id.setText(jTable.getModel().getValueAt(row, 0).toString());
            regNm1.setText(jTable.getModel().getValueAt(row, 1).toString());
            //regNm2.setText(jTable.getModel().getValueAt(row, 2).toString());
            //JOptionPane.showConfirmDialog(vehicle, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
