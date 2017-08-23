/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import javax.swing.JTable;
import javax.swing.JTextField;
import pojo.Grn;
import pojo.GrnLog;
import pojo.Product;

/**
 *
 * @author User
 */
public class ShopCalculation {

    public void quantityCalculation(JTable jTable, JTextField quantity) {
        try {
            int rowCount = jTable.getRowCount();
        Double tableTotal = new c.GrnLogTableView().getTableTotal(jTable);
        double quantityD = Double.parseDouble(quantity.getText());
        Double newRemainingQuantity = 0.0;
        if (tableTotal > quantityD) {
            for (int i = 0; i < rowCount; i++) {
                double rowValue = Double.parseDouble(jTable.getValueAt(i, 3).toString());
                int grnId = Integer.parseInt(jTable.getValueAt(i, 0).toString());
                String productName = jTable.getValueAt(i, 1).toString();

                Product byprName = new m.Product().getByprName(productName);
                System.out.println("Product name" + byprName.getName());
                System.out.println("Product id" + byprName.getId());

                System.out.println(rowValue);

                if (rowValue < quantityD) {
                    System.out.println("Should subract from next row");
                    
                    quantityD=quantityD-rowValue;
                    newRemainingQuantity = 0.0;
                    
                    System.out.println(newRemainingQuantity);
                    System.out.println("GRn log id " + grnId);

                    GrnLog by = new m.GrnLog().getBy(grnId);
                    System.out.println("GRn log id from db " + by.getId());
                    System.out.println("grnlog quantity " + by.getQuantity());
                    System.out.println("grnlog buying price" + by.getBuyingPrice());
                    System.out.println("grnlo remain quantity " + by.getRemainingQuantity());
                    System.out.println("Grn id" + by.getGrn().getId());

                    Grn grn = new m.Grn().getBy(by.getGrn().getId());

                    GrnLog grnLog = new pojo.GrnLog();
                    grnLog.setId(by.getId());
                    grnLog.setGrn(grn);
                    grnLog.setProduct(byprName);
                    grnLog.setBuyingPrice(by.getBuyingPrice());
                    grnLog.setQuantity(by.getQuantity());
                    grnLog.setRemainingQuantity(newRemainingQuantity);
                    grnLog.setTotal(newRemainingQuantity * by.getBuyingPrice());
//                    
                    new m.GrnLog().update(grnLog);
                    
                    
                    
                    
                } else {
                    System.out.println("Can be done from this row");
                    newRemainingQuantity = rowValue - quantityD;

                    System.out.println(newRemainingQuantity);
                    System.out.println("GRn log id " + grnId);

                    GrnLog by = new m.GrnLog().getBy(grnId);
                    System.out.println("GRn log id from db " + by.getId());
                    System.out.println("grnlog quantity " + by.getQuantity());
                    System.out.println("grnlog buying price" + by.getBuyingPrice());
                    System.out.println("grnlo remain quantity " + by.getRemainingQuantity());
                    System.out.println("Grn id" + by.getGrn().getId());

                    Grn grn = new m.Grn().getBy(by.getGrn().getId());

                    GrnLog grnLog = new pojo.GrnLog();
                    grnLog.setId(by.getId());
                    grnLog.setGrn(grn);
                    grnLog.setProduct(byprName);
                    grnLog.setBuyingPrice(by.getBuyingPrice());
                    grnLog.setQuantity(by.getQuantity());
                    grnLog.setRemainingQuantity(newRemainingQuantity);
                    grnLog.setTotal(newRemainingQuantity * by.getBuyingPrice());
//                    
                    new m.GrnLog().update(grnLog);
                    break;
                }
            }
        } else {
            System.out.println("Fuck off");
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
