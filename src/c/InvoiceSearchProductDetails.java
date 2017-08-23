/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.GrnLog;
import pojo.Product;
import pojo.Units;

/**
 *
 * @author shanaka
 */
public class InvoiceSearchProductDetails {

    Product ProductOb;

    double ftot = 0.0;

    public void getProductDetals(JTable jTable1, JTable jTable2, JComboBox<String> cmbProductList, JLabel lblCurrentStock, JTextField tfSellingPrice, JTextField tfQty) {
        try {
            pojo.Product product = new pojo.Product();
            String productName = cmbProductList.getSelectedItem().toString();
            product.setName(productName);

            pojo.Product probyName = new m.Product().getByName(product);

            pojo.GrnLog grnLog = new pojo.GrnLog();
            grnLog.setProduct(probyName);
            ArrayList<GrnLog> atg = new m.GrnLog().allTestGrnL(grnLog);
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);

            for (GrnLog grnLog1 : atg) {
                if (grnLog1.getRemainingQuantity() != 0.0) {
                    Vector v = new Vector();
                    v.add(grnLog1.getId());
                    v.add(grnLog1.getRemainingQuantity());
                    dtm.addRow(v);
                }
            }
            try {
                int rc = jTable1.getRowCount();
                ftot = 0;
                for (int i = 0; i < rc; i++) {
                    ftot += Double.parseDouble(jTable1.getValueAt(i, 1).toString());
                }

                lblCurrentStock.setText(Double.toString(ftot));
                String crp = String.valueOf(probyName.getCurrentPrice());
                tfSellingPrice.setText(crp);
            } catch (NullPointerException e) {
                //e.printStackTrace();
            }
        } catch (Exception e) {
            c.Errormzg.displayerrorMessage("error");
            e.printStackTrace();
        }
    }

    public void getProductDet(JComboBox<String> cmbProductList, JLabel lblCurrentStock, JTextField tfSellingPrice) {
        try {
            if (cmbProductList.getSelectedIndex() != 0) {
                String ProductName = (String) cmbProductList.getSelectedItem();
                ProductOb = new m.Product().getByName(ProductName);
                lblCurrentStock.setText(v.Employee.getRound(ProductOb.getCurrentStock()));
                tfSellingPrice.setText(v.Employee.getRound(ProductOb.getCurrentPrice()));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
