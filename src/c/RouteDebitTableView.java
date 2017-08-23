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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.scripts.JO;
import m.RouteCredit;
import pojo.RouteReg;

/**
 *
 * @author User
 */
public class RouteDebitTableView {

    public void setRouteCreditTableData(JTable jTable,JDateChooser chooser) {
        try {
            RouteCredit routeCredit = new m.RouteCredit();
            ArrayList<pojo.RouteDebit> viewRouteDebitAllData = new m.RouteDebit().viewRouteDebitAllData1(chooser);
            DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
            dtm.setRowCount(0);
            for (pojo.RouteDebit routeCredit1 : viewRouteDebitAllData) {
                Vector vector = new Vector();
                vector.add(routeCredit1.getId());
                vector.add(routeCredit1.getDate());
                vector.add(routeCredit1.getDebit());
                vector.add(String.valueOf(routeCredit1.getRouteReg().getId()));
                RouteReg by = new m.RouteReg().getBy(routeCredit1.getRouteReg().getId());
                vector.add(by.getName().toString());
                dtm.addRow(vector);
            }
//            DefaultTableModel dtm = (DefaultTableModel)jTable.getModel();
//            dtm.setRowCount(0);
//            Vector<Object> v = new Vector<Object>();
//            v.add(1);
//            v.add("Name");
//            v.add("debit");
//            dtm.addRow(v);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(jTable, e);
        }

    }

    public void setRouteCreditDataOnTextField(JTextField routeDebitId, JDateChooser routeDateChooser, JTextField routeDebit, JTextField tf_routeIDDebit, JTextField tf_routeNameDebit, JTable routeDebitTable) {
        try {
            int selectedRow = routeDebitTable.getSelectedRow();
        routeDebitId.setText(routeDebitTable.getModel().getValueAt(selectedRow, 0).toString());
        routeDateChooser.setDate((Date) routeDebitTable.getModel().getValueAt(selectedRow, 1));
        routeDebit.setText(routeDebitTable.getModel().getValueAt(selectedRow, 2).toString());
        tf_routeIDDebit.setText(routeDebitTable.getModel().getValueAt(selectedRow, 3).toString());
        RouteReg by = new m.RouteReg().getBy(Integer.parseInt(routeDebitTable.getModel().getValueAt(selectedRow, 3).toString()));
        tf_routeNameDebit.setText(by.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
