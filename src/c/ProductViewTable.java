/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.Product;

/**
 *
 * @author User
 */
public class ProductViewTable {
    public void setProductdataOnTable(JTable jTable){
        ArrayList<Product> all = new m.Product().getAll();
        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
        dtm.setRowCount(0);
        
        for (Product product : all) {
            Vector v = new Vector();
            v.add(product.getId());
            v.add(product.getName());
            dtm.addRow(v);
        }
    }
}
