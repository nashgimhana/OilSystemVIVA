/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DebitCashTable {

    public void setDebitCashTable(JTextField checkNumber, JComboBox bankname, JTextField checkAmount, JTable table, JDateChooser checkDate) {
        try {
            if (!checkNumber.getText().isEmpty()) {
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            Vector v = new Vector();
            v.add(((JTextField)checkDate.getDateEditor().getUiComponent()).getText());
            v.add(checkNumber.getText());
            v.add(bankname.getSelectedItem());
            double chckAmount = Math.round(Double.parseDouble(checkAmount.getText()) * 100.0) / 100.0;
            v.add(chckAmount);
            dtm.addRow(v);
            }else{
                Errormzg.displayerrorMessage("Please enter a cheque number");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void tableTotal(JTextField total, JTable table) {
        try {
            Double sum = 0.0;
        sum = (Math.round(sum * 100.0) / 100.0);
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        if (dtm.getRowCount() > 0) {
            for (int i = 0; i < table.getRowCount(); i++) {
                sum = sum + Double.parseDouble(dtm.getValueAt(i, 3).toString());
            }
            sum = (Math.round(sum * 100.0) / 100.0);
            total.setText(String.valueOf(sum));
        }else{
            total.setText(String.valueOf(sum));
            //Errormzg.displayerrorMessage("No more Rows");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
