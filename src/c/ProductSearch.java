/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pojo.Product;

/**
 *
 * @author Buddhika Prasanna
 */
public class ProductSearch {

    public void getProductData(JTextField txtPname, JTextField txtUnit, JTextField txtUnitPrice) {
        m.Product product = new m.Product();
        Product byprName = product.getByProductName(txtPname.getText());
        try {
            txtUnit.setText(byprName.getUnits().getUnitName());
            txtUnitPrice.setText(String.valueOf(byprName.getCurrentPrice()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            product.closeSession();
        }
    }

    public void getProductData(JTextField txtPname, JTextField txtUnit) {
        m.Product product = new m.Product();
        Product byprName = product.getByProductName(txtPname.getText());
        try {
            txtUnit.setText(byprName.getUnits().getUnitName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            product.closeSession();
        }
    }

    public void getCurrentQty(JTextField txtPname, JTextField txtQty) {
        m.Product product = new m.Product();
        Product byprName = product.getByProductName(txtPname.getText());
        try {
            if (Double.parseDouble(txtQty.getText()) > byprName.getCurrentStock()) {
                txtQty.setText(String.valueOf(byprName.getCurrentStock()));
                JOptionPane.showMessageDialog(null, "Your requid quantity is less than remain quantity", "Stock Status", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            product.closeSession();
        }

    }

    public void getLoadQty(JTextField txtPname, JTextField txtQty) {
        m.Product product = new m.Product();
        Product byprName = product.getByProductName(txtPname.getText());
        try {
            if (Double.parseDouble(txtQty.getText()) > byprName.getCurrentStock()) {
                txtQty.setText(String.valueOf(byprName.getCurrentStock()));
                JOptionPane.showMessageDialog(null, "Your requid quantity is less than remain quantity", "Stock Status", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            product.closeSession();
        }

    }

}
