/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import m.RouteCredit;
import pojo.RouteReg;

/**
 *
 * @author User
 */
public class RouteCreditTableView {

    public void setRouteCreditTableData(JTable jTable) {
        try {
            RouteCredit routeCredit = new m.RouteCredit();
        ArrayList<pojo.RouteCredit> viewRouteCreditAllData = routeCredit.viewRouteCreditAllData();
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        dtm.setRowCount(0);
        for (pojo.RouteCredit routeCredit1 : viewRouteCreditAllData) {
            Vector vector = new Vector();
            vector.add(routeCredit1.getId());
            vector.add(routeCredit1.getDate());
            vector.add(routeCredit1.getCredit());
            vector.add(String.valueOf(routeCredit1.getRouteReg().getId()));
            RouteReg by = new m.RouteReg().getBy(routeCredit1.getRouteReg().getId());
            vector.add(by.getName().toString());
            dtm.addRow(vector);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRouteCreditDataOnTextField(JTextField routeCreditId, JDateChooser routeDateChooser, JTextField routeCredit, JTextField tf_routeIDCredit, JTextField tf_routeNameCredit, JTable routeCreditTable) {
        int selectedRow = routeCreditTable.getSelectedRow();
        routeCreditId.setText(routeCreditTable.getModel().getValueAt(selectedRow, 0).toString());
        routeDateChooser.setDate((Date) routeCreditTable.getModel().getValueAt(selectedRow, 1));
        routeCredit.setText(routeCreditTable.getModel().getValueAt(selectedRow, 2).toString());
        tf_routeIDCredit.setText(routeCreditTable.getModel().getValueAt(selectedRow, 3).toString());
        RouteReg by = new m.RouteReg().getBy(Integer.parseInt(routeCreditTable.getModel().getValueAt(selectedRow, 3).toString()));
        tf_routeNameCredit.setText(by.getName());

    }

}
