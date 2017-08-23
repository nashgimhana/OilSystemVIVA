/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
import pojo.GrnLog;
import pojo.InvoiceLog;

/**
 *
 * @author User
 */
public class invoicecontroller {

    public pojo.Customer findCusIdByName(String cusname) {
        pojo.Customer bysupName = null;
        try {

            pojo.Customer cus = new m.Customer().getByFnameS(cusname);
            return cus;
//            System.out.println(bysupName.getName());
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            e.printStackTrace();
            return null;
        }

    }

    public int saveinvoice(pojo.Customer cus, Date date) {
        try {
            pojo.Invoice in = new pojo.Invoice();
            in.setCustomer(cus);
            in.setDate(date);
            in.setPayStatus("ok");
            int inv = new m.Invoice().save(in);
            return inv;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int saveinvoicelog(pojo.Invoice invid, double total, JTable tblinvoice) {
        System.out.println(tblinvoice.getRowCount());
        try {
            for (int i = 0; i < tblinvoice.getRowCount(); i++) {

                System.out.println("for eka athulata awaa  " + i);

                String PrName = tblinvoice.getValueAt(i, 0).toString();
                pojo.Product pr = new m.Product().getByprName(PrName);
                ArrayList<pojo.GrnLog> grnlg = new m.GrnLog().loadNotEmptyProductByName(pr);

                double prqty = Double.parseDouble(tblinvoice.getValueAt(i, 2).toString());
                prqty = (Math.round(prqty * 100.0) / 100.0);
                double qtyforrem = prqty;

                double sellPrice = v.Employee.getRoundDouble(Double.parseDouble(tblinvoice.getValueAt(i, 1).toString()));
                sellPrice = (Math.round(sellPrice * 100.0) / 100.0);

                double prtot = v.Employee.getRoundDouble(Double.parseDouble(tblinvoice.getValueAt(i, 3).toString()));
                prtot = (Math.round(prtot * 100.0) / 100.0);
                double newremqty1 = 0.0;

                for (GrnLog grnLog : grnlg) {

                    if (grnLog.getRemainingQuantity() > prqty) {
                        newremqty1 = grnLog.getRemainingQuantity() - prqty;
                        newremqty1 = (Math.round(newremqty1 * 100.0) / 100.0);
                        grnLog.setRemainingQuantity(newremqty1);
                        new m.GrnLog().update(grnLog);
                        break;

                    } else if (grnLog.getRemainingQuantity() == prqty) {
                        newremqty1 = 0;
                        grnLog.setRemainingQuantity(newremqty1);
                        new m.GrnLog().update(grnLog);
                        break;
                    } else if (grnLog.getRemainingQuantity() < prqty) {
                        prqty = prqty - grnLog.getRemainingQuantity();
                        newremqty1 = 0;
                        grnLog.setRemainingQuantity(newremqty1);
                        new m.GrnLog().update(grnLog);

                    } else {
                        Errormzg.displayerrorMessage("not enough stock");
                    }
                }
                pojo.Product pr1 = new m.Product().getByName(PrName);
                double pr1crntstock = pr1.getCurrentStock() - qtyforrem;
                pr1crntstock = (Math.round(pr1crntstock * 100.0) / 100.0);
                pr1.setCurrentStock(pr1crntstock);

                new m.Product().update(pr1);

                InvoiceLog invoiceLog = new pojo.InvoiceLog();
                invoiceLog.setProduct(pr1);
                invoiceLog.setQty(prqty);
                invoiceLog.setPrice(sellPrice);
                invoiceLog.setInvoice(invid);
                invoiceLog.setTotal(prtot);
                new m.InvoiceLog().saveint(invoiceLog);
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
