/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
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
public class ShopLogControl {
    public void viewShopLog(JDateChooser from,JDateChooser to, JTable table){
        try {
            ArrayList<ShopTransfer> viewDate = new m.ShopLogView().viewDate(from,to);
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setRowCount(0);
        
        
        for (ShopTransfer shopTransfer : viewDate) {
            Vector<Object> v = new Vector<Object>();
            
            System.out.println("Date : "+shopTransfer.getDate().toString());
            
            
            ShopTransferLog shopTransferLog = new m.ShopTrasnferLog().getBy(shopTransfer);
            System.out.println("Product Quantity : "+shopTransferLog.getQuantity().toString());
            
            
            
            
            System.out.println("Grn Log id : "+shopTransferLog.getGrnLog().getId());
            GrnLog grnLog = new m.GrnLog().getById(shopTransferLog.getGrnLog().getId());
            System.out.println("Buying Price : "+grnLog.getBuyingPrice().toString());
            
            
            System.out.println("Product id : "+grnLog.getProduct().getId());
            Product product = new m.Product().getByGRNLog(grnLog);
            System.out.println("Product name : "+product.getName());
            
                Units units = new m.Units().getBy(product.getUnits().getId());
            
            System.out.println("Total : "+shopTransferLog.getQuantity() * grnLog.getBuyingPrice());
            
            
            
            
            v.add(shopTransfer.getDate());
            v.add(product.getName());
            v.add(units.getUnitName());
            v.add(shopTransferLog.getQuantity());
            v.add(grnLog.getBuyingPrice());
            Double Total = shopTransferLog.getQuantity() * grnLog.getBuyingPrice();
            Total = (Math.round(Total * 100.0) / 100.0);
            v.add(Total);
            dtm.addRow(v);
            System.out.println("#############################");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Double getTableTotal(JTable jTable) {
        Double sum = 0.00;
        
        try {
            for (int i = 0; i < jTable.getRowCount(); i++) {
            sum = sum + Double.parseDouble(jTable.getValueAt(i, 5).toString());
        }
        sum = (Math.round(sum * 100.0) / 100.0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sum;
    }
}
