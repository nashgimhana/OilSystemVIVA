/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Buddhika Prasanna
 */
public class DeleveryCashTable {

    public void addItem(JComboBox ExpendType, JTextField amount, JTextArea discription, JTable itemTable) {
        DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();
        Vector v = new Vector();
        v.add(ExpendType.getSelectedItem().toString());
        v.add(amount.getText());
        v.add(""+discription.getText());
        dtm.addRow(v);
    }

    public void removeItem(JTable itemTable) {
        DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();
        if (itemTable.getSelectedRow() >= 0) {
            dtm.removeRow(itemTable.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(null, "No more row selected! Please select.", "Row Remove", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void removeAllItem(JTable itemTable) {
        DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();
        if (itemTable.getRowCount() > 0) {
            dtm.setRowCount(0);
        } else {
            JOptionPane.showMessageDialog(null, "No more row in table! Please add one more.", "Row Remove", JOptionPane.WARNING_MESSAGE);
        }
    }
}
