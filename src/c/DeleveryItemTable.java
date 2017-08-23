/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Buddhika Prasanna
 */
public class DeleveryItemTable {

    public void addItem(JTextField productName, JTextField unit, JTextField loadQty, JTable itemTable) {
        DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();
        Vector v = new Vector();
        v.add(productName.getText());
        v.add(unit.getText());
        v.add(loadQty.getText());
        v.add(getGrnLogId(productName));
        dtm.addRow(v);
        productName.setText("");
        unit.setText("");
        loadQty.setText("");
        productName.requestFocus();

    }

    public int getGrnLogId(JTextField txtPname) {
        int logId = 0;
        try {
            m.GrnLog grnLog = new m.GrnLog();
            List<pojo.GrnLog> itemlist = grnLog.getAllAvailabelStocksByProductId(new m.Product().getByName(txtPname.getText()));
            for (pojo.GrnLog log : itemlist) {
                logId = log.getId();
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        }
        return logId;
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
