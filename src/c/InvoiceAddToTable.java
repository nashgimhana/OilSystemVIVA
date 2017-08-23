/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import pojo.Customer;


/**
 *
 * @author shanaka
 */
public class InvoiceAddToTable {

    //one ne
    public void setBalance(JTextField tf_full_total, JTextField tf_paymant, JTextField tf_balance) {
        try {

            double ft = Double.parseDouble(tf_full_total.getText());
            double py = Double.parseDouble(tf_paymant.getText());
            double bl = ft - py;
            tf_balance.setText(Double.toString(bl));
        } catch (Exception e) {
        }
    }

    //one ene
    public void setQtyVali(JLabel lbl_CurrentStock, JTextField tf_Qty, JTextField tf_CurrentPrice, JTextField tf_totalPrice, JPanel jPanel1) {
        try {
            double cs = Double.parseDouble(lbl_CurrentStock.getText());
            double cp = Double.parseDouble(tf_CurrentPrice.getText());
            double qty = Double.parseDouble(tf_Qty.getText());

            if (cs > qty) {
                double tot = (cp * qty);
                tf_totalPrice.setText(tot + "");
            } else {
                int i = JOptionPane.showConfirmDialog(jPanel1, "wedi", "title", JOptionPane.OK_OPTION);

                tf_Qty.setText(null);
            }

        } catch (Exception e) {
        }
    }

    public void clearTable(JDateChooser jDateChooser1, JTextField tf_customerId, JTable jTable1, JTextField tf_full_total, JTextField tf_paymant, JTextField tf_balance) {
        jDateChooser1.setDate(null);
        tf_customerId.setText(null);
        tf_balance.setText(null);
        tf_full_total.setText(null);
        tf_paymant.setText(null);
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
            }
        }

    }

    public void setCusIdToLbl(JTextField tfCustomer, JLabel lblCusId) {
        Customer cus = new pojo.Customer();
        cus.setFname(tfCustomer.getText());
        Customer byFname = new m.Customer().getByFname(cus);
        lblCusId.setText(byFname.getNic());

    }

    public void setAddToTable(JTextField tfCustomer, JDateChooser DateChooser, JComboBox<String> cmbProductList, JTextField tfQty, JTextField tfSellingPrice, JTable jTable2, JLabel lblCurrentStock, JLabel lblFullTotal, JPanel base1) {
        try {
            if (DateChooser.getDate() != null) {
                if (!tfCustomer.getText().isEmpty()) {
                    if (!tfQty.getText().isEmpty()) {
                        if (!tfSellingPrice.getText().isEmpty()) {

                            double qty = Double.parseDouble(tfQty.getText());
                            double selPrice = Double.parseDouble(tfSellingPrice.getText());
                            double curStock = Double.parseDouble(lblCurrentStock.getText());

                            double tot = selPrice * qty;
                            DefaultTableModel dtm = (DefaultTableModel) jTable2.getModel();
                            Vector vv = new Vector();
                            vv.add(cmbProductList.getSelectedItem().toString());
                            vv.add(tfSellingPrice.getText());
                            vv.add(tfQty.getText());
                            vv.add(v.Employee.getRound(tot));
                            dtm.addRow(vv);
                        } else {
                            JOptionPane.showConfirmDialog(base1, "PLEASE ENTER SEL PRICE !!", "confirm", 2);
                        }
                    } else {
                        JOptionPane.showConfirmDialog(base1, "PLEASE ENTER QTY !!", "confirm", 2);
                    }
                } else {
                    JOptionPane.showConfirmDialog(base1, "PLEASE ENTER CUSTOMER ?", "confirm", 2);
                }
            } else {
                JOptionPane.showConfirmDialog(base1, "PLEASE SELECT DATE", "confirm", 2);
            }

        } catch (Exception e) {
        }
    }

    public void settot(JTable jTable2, JLabel lblFullTotal) {
        try {
            int rc = jTable2.getRowCount();
            double ftot = 0;
            for (int i = 0; i < rc; i++) {
                ftot += Double.parseDouble(jTable2.getValueAt(i, 3).toString());
            }
            lblFullTotal.setText(v.Employee.getRound(ftot));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
