/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import java.util.List;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.RouteCredit;

/**
 *
 * @author User
 */
public class RouteCreditSearch {

    public void searchRouteCreditByDate(JTable jTable, JDateChooser dateChooser) {
        try {
            DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
            dtm.setRowCount(0);

            List<RouteCredit> by = new m.RouteCredit().getBy(dateChooser.getDate());
            for (RouteCredit routeCredit : by) {
                Vector vector = new Vector();
                vector.add(routeCredit.getId());
                System.out.println(routeCredit.getId());
                vector.add(routeCredit.getDate());
                System.out.println(routeCredit.getDate().toString());
                vector.add(routeCredit.getCredit());
                System.out.println(routeCredit.getCredit());
                vector.add(routeCredit.getRouteReg().getId());
                vector.add(routeCredit.getRouteReg().getName());
                dtm.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
