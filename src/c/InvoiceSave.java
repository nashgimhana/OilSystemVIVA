/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import static com.alee.laf.filechooser.FileApproveText.save;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Session;
import pojo.CusCredit;
import pojo.Customer;
import pojo.Grn;
import pojo.GrnLog;
import pojo.Invoice;
import pojo.InvoiceLog;
import pojo.Product;

/**
 *
 * @author shanaka
 */
public class InvoiceSave {

    int invId = 0;
    pojo.GrnLog by = null;
    Customer customer;
    pojo.Product probyName;
    Invoice invoice;
    Date date;

    public void saveInvoice(JTable jTable2, JTable jTable1, JDateChooser DateChooser, JTextField tfCustomer, JLabel lblInvId, JLabel lblBalance) {

        int idin = 0;
        try {
//            if (tfCustomer.getText() != null) {
//                String usIdFromLbl = tfCustomer.getText();
//                Customer pojoCus = new pojo.Customer();
//                pojoCus.setFname(usIdFromLbl);
//                customer = new m.Customer().getByFname(pojoCus);
//
//                date = DateChooser.getDate();
            int rc = jTable2.getRowCount();
//                System.out.println("loku table eke  rowcount eka--->" + rc);
//
//                invoice = new pojo.Invoice();
//                invoice.setDate(date);
//                invoice.setCustomer(customer);
//                invoice.setPayStatus("not null");
//
//                int save1 = new m.Invoice().save(invoice);
//
//                Double credtis = Double.parseDouble(lblBalance.getText());
//
//                idin = Integer.parseInt(lblInvId.getText());
//
//                Invoice invoObj = new m.Invoice().getBy(save1);
//
//                Double newRemainQty = 0.0;

            for (int i = 0; i < rc; ++i) {
                System.out.println("eliya" + i);
//                System.out.println("loku table eke  rowcount eka--->" + i);
//                String proName = jTable2.getValueAt(i, 0).toString();
//                double eQty = Double.parseDouble(jTable2.getValueAt(i, 2).toString());
//                double price = Double.parseDouble(jTable2.getValueAt(i, 1).toString());
//                double tot = Double.parseDouble(jTable2.getValueAt(i, 3).toString());
//
//                Product product = new pojo.Product();
//                product.setName(proName);
//                probyName = new m.Product().getByName(product);
//
//                setTable(probyName, jTable1);
//           int rc2 = jTable1.getRowCount();
                int rc2 = 3;
                for (int j = 0; j < rc2; j++) {
//                        System.out.println("podi table eke  rowcount eka--->" + j);
//                        double rv = Double.parseDouble(jTable1.getValueAt(j, 3).toString());
//                        int glog = Integer.parseInt(jTable1.getValueAt(j, 2).toString());
//
//                        if (rv < eQty) {
//                            eQty = eQty - rv;
//                            newRemainQty = 0.0;
//                            GrnLog grnLog = new m.GrnLog().getBy(glog);
//
//                            Double remainingQuantity = grnLog.getRemainingQuantity();
//                            grnLog.setRemainingQuantity(newRemainQty);
//                            new m.GrnLog().update(grnLog);
//
//                            saveInvLog(remainingQuantity, grnLog, price, invoObj, tot);
//
//                            Double currentStock = probyName.getCurrentStock();
//                            Double newCurrentStock = currentStock - remainingQuantity;
//
//                            probyName.setCurrentStock(newCurrentStock);
//                            new m.Product().update(probyName);
//
//                        } else {
//                            newRemainQty = rv - eQty;
//                            GrnLog grnLog = new m.GrnLog().getBy(glog);
//
//                            grnLog.setRemainingQuantity(newRemainQty);
//                            new m.GrnLog().update(grnLog);
//                            saveInvLog(eQty, grnLog, price, invoObj, tot);
//
//                            Double currentStock = probyName.getCurrentStock();
//                            Double newCurrentStock = currentStock - eQty;
//                            probyName.setCurrentStock(newCurrentStock);
//                            new m.Product().update(probyName);
//                            break;
//                        }
//                        System.out.println("loku table eke  rowcount eka--->" + i);
                    System.out.println("ethula" + j);
                }
//                    System.out.println("loku table eke  rowcount eka--->" + i);
//                    clearTable(jTable1);
//
//                    clearTable(jTable2);
            }

//            } else {
//                Errormzg.displayconfirmMessage("Customer Id select plz");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //new report.Psmodle().invoiceReport(idin, 10.0);
    }

    private void setTable(Product probyName, JTable jTable1) {
        pojo.GrnLog grnLog = new pojo.GrnLog();
        grnLog.setProduct(probyName);
        ArrayList<GrnLog> atg = new m.GrnLog().allTestGrnL(grnLog);
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        for (GrnLog grnLog1 : atg) {
            if (grnLog1.getRemainingQuantity() != 0.0) {
                Vector v = new Vector();
                v.add(null);
                v.add(null);
                v.add(grnLog1.getId());
                v.add(grnLog1.getRemainingQuantity());
                dtm.addRow(v);
            }

        }
        System.out.println("facke table added invlog details");
    }

    private void clearTable(JTable jTable1) {
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            while (model.getRowCount() > 0) {
                for (int i = 0; i < model.getRowCount(); i++) {
                    model.removeRow(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void saveInvLog(double ev, GrnLog id, double price, Invoice invObj, double tot) {
        try {

            System.out.print("call InvoiceLog");
            InvoiceLog invoiceLog = new pojo.InvoiceLog();
            invoiceLog.setQty(ev);
//            invoiceLog.setGrnLog(id);
            invoiceLog.setPrice(price);
            invoiceLog.setInvoice(invoice);
            invoiceLog.setTotal(tot);
            new m.InvoiceLog().save(invoiceLog);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int saveInv(String Customer, Date DateChooser) {
        int inv = 0;
        try {
            String usIdFromLbl = Customer;
            Customer pojoCus = new pojo.Customer();
            pojoCus.setFname(usIdFromLbl);
            customer = new m.Customer().getByFname(pojoCus);

            invoice = new pojo.Invoice();
            invoice.setCustomer(customer);
            invoice.setDate(DateChooser);
            invoice.setPayStatus("noy nukk");
            inv = new m.Invoice().save(invoice);
            c.Errormzg.displayconfirmMessage("SAVED");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inv;

    }

    public void saveInvLog(int saveInv, JTable jTable) {
        try {
            int rowCount = jTable.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String ProName = jTable.getValueAt(i, 0).toString();
                double ev = Double.parseDouble(jTable.getValueAt(i, 2).toString());
                double Ev = v.Employee.getRoundDouble(ev);
                Product pro = new m.Product().getByName(ProName);
                double selPrice = v.Employee.getRoundDouble(Double.parseDouble(jTable.getValueAt(i, 1).toString()));
                double tot = v.Employee.getRoundDouble(Double.parseDouble(jTable.getValueAt(i, 3).toString()));
                System.out.println("1 sop" + pro.getName());
                System.out.println(Ev);

                ArrayList<GrnLog> glog = new m.GrnLog().grn(pro);
                double reqty = 0.0;
                double avlTot = pro.getCurrentStock();
                HashMap<Integer, Double> v = new HashMap<Integer, Double>();
                for (GrnLog gll : glog) {
                    v.put(gll.getId(), gll.getRemainingQuantity());
                }
                double kv = 00.0;
                for (Integer key : v.keySet()) {
                    kv = v.get(key);
                    if (kv != 0) {
                        System.out.println(key + "===" + v.get(key));
                        if (Ev > kv) {

                            Ev = Ev - kv;

                            GrnLog grnLogId = new m.GrnLog().getById(key);
                            grnLogId.setRemainingQuantity(00.0);
                            String grnLogUpdated = new m.GrnLog().update(grnLogId);
                            System.out.println(grnLogUpdated);

                            Double currentStock = pro.getCurrentStock();
                            System.out.println("current stock"+currentStock);
                            Double newcurrentStock = currentStock - kv;
                            System.out.println("new current stock"+newcurrentStock);
                            pro.setCurrentStock(newcurrentStock);
                            int update = new m.Product().update(pro);
                            System.out.println(update);
                             
                            double total =selPrice*kv;
                            
                            InvoiceLog invoiceLog = new pojo.InvoiceLog();
                            invoiceLog.setQty(kv);
//                            invoiceLog.setGrnLog(grnLogId);
                            invoiceLog.setPrice(selPrice);
                            invoiceLog.setInvoice(invoice);
                            invoiceLog.setTotal(total);
                            String invLogSaved = new m.InvoiceLog().save(invoiceLog);
                            System.out.println(invLogSaved);

                        } else if (kv > Ev) {

                            kv = kv - Ev;

                            GrnLog grnLogId = new m.GrnLog().getById(key);
                            grnLogId.setRemainingQuantity(kv);
                            String grnLogUpdated = new m.GrnLog().update(grnLogId);
                            System.out.println(grnLogUpdated);

                            Double currentStock = pro.getCurrentStock();
                            System.out.println("current stock"+currentStock);
                            Double newcurrentStock = currentStock - Ev;
                            System.out.println("new current stock"+newcurrentStock);
                            pro.setCurrentStock(newcurrentStock);
                            int update = new m.Product().update(pro);
                            System.out.println(update);
                            
                            double total =selPrice*Ev;
                            
                            InvoiceLog invoiceLog = new pojo.InvoiceLog();
                            invoiceLog.setQty(Ev);
//                            invoiceLog.setGrnLog(grnLogId);
                            invoiceLog.setPrice(selPrice);
                            invoiceLog.setInvoice(invoice);
                            invoiceLog.setTotal(total);
                            String invLogSaved = new m.InvoiceLog().save(invoiceLog);
                            System.out.println(invLogSaved);
                            break;

                        }
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
