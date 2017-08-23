/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import pojo.Product;

/**
 *
 * @author shanaka
 */
public class InvoiceProductNameLord {

    public void getAllProduct(JComboBox<String> jComboBox1) {

        pojo.Product product = new pojo.Product();
        ArrayList<Product> all = new m.Product().getAll();
        for (Product prl : all) {
            jComboBox1.addItem(prl.getName());
        }
    }

}
