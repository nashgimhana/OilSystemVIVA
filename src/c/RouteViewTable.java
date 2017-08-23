/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pojo.RouteReg;

/**
 *
 * @author User
 */
public class RouteViewTable {
    
    public void setrouteTableData(JTable table){
        try {
            m.RouteReg routeReg = new m.RouteReg();
        ArrayList<RouteReg> viewAllRoute = routeReg.viewAllRoute();
        DefaultTableModel name = (DefaultTableModel) table.getModel();
        name.setRowCount(0);
        for (RouteReg routeReg1 : viewAllRoute) {
            Vector vector = new Vector();
            vector.add(routeReg1.getId());
            vector.add(routeReg1.getName());
            vector.add(routeReg1.getDiscription());
            vector.add(routeReg1.getCurrentCredit());
            name.addRow(vector);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void serRouteTableDataOnTextField(JTextField routeId, JTextField routeName, JTextArea routeDesctription,JTextField routeCredit, JTable routeTable){
        try {
            int selectedRow = routeTable.getSelectedRow();
            routeId.setText(routeTable.getModel().getValueAt(selectedRow, 0).toString());
            routeName.setText(routeTable.getModel().getValueAt(selectedRow, 1).toString());
            routeDesctription.setText(routeTable.getModel().getValueAt(selectedRow, 2).toString());
            //routeCredit.setText(routeTable.getModel().getValueAt(selectedRow, 3).toString());
            routeCredit.setText(String.valueOf(0.00));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
