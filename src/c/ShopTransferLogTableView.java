/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Set;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pojo.GrnLog;
import pojo.Product;
import pojo.ShopTransfer;
import pojo.ShopTransferLog;
import pojo.Units;

/**
 *
 * @author User
 */
public class ShopTransferLogTableView {

    public void setShopTransferLogTable(JTable jTable) {
        try {
            ArrayList<ShopTransfer> st = new m.ShopTransfer().viewAllShopTransfer();
            DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
            dtm.setRowCount(0);
           
            for (ShopTransfer shopTransfer : st) {
                //System.out.println("id " + shopTransfer.getId());
                //System.out.println("date " + shopTransfer.getDate());
                ShopTransferLog shopTransferLog = new pojo.ShopTransferLog();
                shopTransferLog.setShopTransfer(shopTransfer);

                ShopTransferLog stl = new m.ShopTrasnferLog().getBy(shopTransfer);
                //ShopTransferLog by = new m.ShopTrasnferLog().getBy(shopTransfer.getId());
                //System.out.println("ShopTL " + by.getQuantity());
                //System.out.println("ShopTLGRNLOG " + by.getGrnLog().getId());

                GrnLog gl = new m.GrnLog().getBy(stl.getGrnLog().getId());

                Product p = new m.Product().getBy(gl.getProduct().getId());
                //System.out.println("Product Name " + p.getName());

                //System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^shopTransferLog Detaisl quantity "+stl.getQuantity());
                Vector<Object> vector = new Vector<Object>();
                vector.add(shopTransfer.getId());
                vector.add(shopTransfer.getDate());
                vector.add(p.getName());
                vector.add(stl.getQuantity());
                vector.add(gl.getBuyingPrice() * stl.getQuantity());
                dtm.addRow(vector);
                 

            }
            dtm.setNumRows(20);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int setShopTransferLogTableByDate(JTable jTable, JDateChooser dateChooser) {
        int i = 0;
        try {
            int shopTransferByDateCheck = new m.ShopTransfer().getShopTransferByDateCheck(dateChooser.getDate());

        if (shopTransferByDateCheck == 1) {
            //Errormzg.displayerrorMessage("Please enter a date where Shop Transfer is available");
        } else if (shopTransferByDateCheck == 2) {
            ArrayList<ShopTransfer> st = new m.ShopTransfer().getShopTransferByDate(dateChooser.getDate());
            DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
            dtm.setRowCount(0);
            for (ShopTransfer shopTransfer : st) {
                // System.out.println("id " + shopTransfer.getId());
                //System.out.println("date " + shopTransfer.getDate());

                ShopTransferLog shopTransferLog = new pojo.ShopTransferLog();
                shopTransferLog.setShopTransfer(shopTransfer);

                ShopTransferLog stl = new m.ShopTrasnferLog().getBy(shopTransfer);
                //ShopTransferLog by = new m.ShopTrasnferLog().getBy(shopTransfer.getId());
                //System.out.println("ShopTL " + stl.getQuantity());
                //System.out.println("ShopTLGRNLOG " + stl.getGrnLog().getId());
                //stl.getGrnLog().getId();

                GrnLog grnlo = new m.GrnLog().getBy(stl.getGrnLog().getId());

                GrnLog grnl = new m.GrnLog().getBy(stl.getGrnLog().getId());
                //System.out.println("qty @@@@@@@@@@@" + grnl.getQuantity());
                //System.out.println("price @@@@@@@@@@@@@@@@@@" + grnl.getBuyingPrice());

                Product prdt = new m.Product().getBy(grnl.getProduct().getId());
                //System.out.println("Product Name " + prdt.getName());

                Vector<Object> vector = new Vector<Object>();
                //vector.add(shopTransfer.getId());
                vector.add(shopTransfer.getDate());
                vector.add(prdt.getName());
                Units unit = new m.Units().getBy(prdt.getId());
                vector.add(unit.getUnitName());
                vector.add(stl.getQuantity());
                //vector.add(grnl.getBuyingPrice() * stl.getQuantity());
                //vector.add(grnlo.getBuyingPrice());
                vector.add(grnlo.getBuyingPrice() * stl.getQuantity());
                dtm.addRow(vector);
                i = 1;

            }

        } else {
            Errormzg.displayerrorMessage("Restart the software");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

}
