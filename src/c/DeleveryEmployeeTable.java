/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pojo.Employee;

/**
 *
 * @author Buddhika Prasanna
 */
public class DeleveryEmployeeTable {

    public void addItem(JTextField employeeName, JTable itemTable) {
        try {
            DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();
            Vector v = new Vector();
            Employee emp = new m.Employee().getByFnameandMname(employeeName.getText().split(" ")[0], employeeName.getText().split(" ")[1]);
            v.add(emp.getId());
            v.add(employeeName.getText());
            dtm.addRow(v);
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        }

    }

    public void removeItem(JTable employeeTable) {
        DefaultTableModel dtm = (DefaultTableModel) employeeTable.getModel();
        if (employeeTable.getSelectedRow() >= 0) {
            dtm.removeRow(employeeTable.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "No more row selected! Please select.", "Row Remove", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void removeAllItem(JTable employeeTable) {
        DefaultTableModel dtm = (DefaultTableModel) employeeTable.getModel();
        if (employeeTable.getRowCount() > 0) {
            dtm.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(null, "No more row in table! Please add one more.", "Row Remove", JOptionPane.WARNING_MESSAGE);
        }
    }
}
