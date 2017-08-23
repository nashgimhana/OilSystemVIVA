/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.RouteDebit;
import pojo.RouteReg;

/**
 *
 * @author User
 */
public class DebitPayLog {
    public void debitPayLog(JDateChooser from, JDateChooser to, JTable table){
        ArrayList<RouteDebit> viewDate = new m.DebitLogView().viewDate(from, to);
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        
        for (RouteDebit routeDebit : viewDate) {
            Vector<Object> v = new Vector<Object>();
            v.add(routeDebit.getDate());
            
            RouteReg routeReg = new m.RouteReg().getBy(routeDebit.getRouteReg().getId());
            v.add(routeReg.getName());
            v.add(routeDebit.getDebit());
            dtm.addRow(v);
            
        }
    
    }
    
    public Double getTableTotal(JTable jTable) {
        Double sum = 0.00;
        
        for (int i = 0; i < jTable.getRowCount(); i++) {
            sum = sum + Double.parseDouble(jTable.getValueAt(i, 2).toString());
        }
        sum = (Math.round(sum * 100.0) / 100.0);
        return sum;
    }
}
