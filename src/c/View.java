/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.Color;
import java.awt.Component;
import v.Status;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import v.Cash_Check_Book;
import v.CustomerView;
import v.Employee;
import v.Stock;
import v.Delivery;

import v.SelfProducts;
import v.SupplierView;

/**
 *
 * @author suhada
 */
public class View {
    private View(){}
    public Color colorTheme = new Color(82, 188, 77, 255);
    public Color colorMenuSelet = new Color(82, 188, 77, 255);
    public Color colorMenuOver = new Color(153, 244, 113, 255);
    private static View View = null;
    public Color tableHeaderColor = new Color(124, 218, 113, 255);
    public Color grennlight = new Color(190,240,193);
    public Color grennDark = new Color(34, 145, 39);
    public Color orangelight = new Color(255, 133, 51);
    public Color orangeDark = new Color(179, 71, 0);
    public Color grayHilight = new Color(240,240,240);
    public Color redlight = new Color(251,192,192);
    public Color redDark = new Color(230, 0, 0);

    public static View getInstance() {
        if (View == null) {
            View = new View();
        }
        return View;
    }

    public DefaultTableCellRenderer getTableCellRender(String align){
        DefaultTableCellRenderer dtcr=new DefaultTableCellRenderer();
        if(align.equalsIgnoreCase("r"))
            dtcr.setHorizontalAlignment(JLabel.RIGHT);
        else if(align.equalsIgnoreCase("c"))
            dtcr.setHorizontalAlignment(JLabel.CENTER);
        else if(align.equalsIgnoreCase("l"))
            dtcr.setHorizontalAlignment(JLabel.LEFT);
        return dtcr;
    }
    
    public void setViewToDPane(JDesktopPane comp, Component c) {
        comp.removeAll();
        c.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", c);
        c.setVisible(true);
    }

    public void setStatusViewToDPane(JDesktopPane comp) {
        comp.removeAll();
        Status instance = v.Status.getInstance();
        instance.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", instance);
        instance.setVisible(true);
    }

    public void setCashCheckBookViewToDPane(JDesktopPane comp) {
        comp.removeAll();
        Cash_Check_Book instance = v.Cash_Check_Book.getInstance();
        instance.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", instance);
        instance.setVisible(true);
    }

    public void setEmployeeViewToDPane(JDesktopPane comp) {
        comp.removeAll();
        Employee instance = v.Employee.getInstance();
        instance.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", instance);
        instance.setVisible(true);
    }

    public void setStockViewToDPane(JDesktopPane comp) {
        comp.removeAll();
        Stock instance = v.Stock.getInstance();
        instance.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", instance);
        instance.setVisible(true);
    }

    public void setDeliveryViewToDPane(JDesktopPane comp) {
        comp.removeAll();
        Delivery instance = v.Delivery.getInstance();
        instance.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", instance);
        instance.setVisible(true);
    }

    public void setSupplierView(JDesktopPane comp) {
        comp.removeAll();
        SupplierView instance = v.SupplierView.getInstance();
        instance.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", instance);
        instance.setVisible(true);
    }

    public void setCutomerViewToDPane(JDesktopPane comp) {
        comp.removeAll();
        CustomerView instance = v.CustomerView.getInstance();
        instance.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", instance);
        instance.setVisible(true);
    }

    public void setInvoiceToDPane(JDesktopPane comp) {
        comp.removeAll();
        v.InvoiceByNash instance = v.InvoiceByNash.getInstance();
        instance.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", instance);
        instance.setVisible(true);
    }

    public void setSelfproducttodPane(JDesktopPane comp) {
        comp.removeAll();
        v.SelfProducts instance = v.SelfProducts.getInstance();
        instance.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", instance);
        instance.setVisible(true);
    }
    
    public void setBackupPane(JDesktopPane comp) {
        comp.removeAll();
        v.Backup instance = v.Backup.getInstance();
        instance.setSize(comp.getWidth(), comp.getHeight());
        comp.add("Status", instance);
        instance.setVisible(true);
    }
}
