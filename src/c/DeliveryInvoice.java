/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.alee.managers.notification.NotificationIcon;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import m.NotificationCreater;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Bank;
import pojo.Cheques;
//import pojo.ChequeDetails;
import pojo.CusCredit;
import pojo.Customer;
import pojo.DeliveryItemLog;
import pojo.Invoice;
import pojo.InvoiceLog;
import pojo.MoneyBook;

/**
 *
 * @author Buddhika Prasanna
 */
public class DeliveryInvoice {

    NotificationCreater notifyCreater;

    public DeliveryInvoice() {
        notifyCreater = new NotificationCreater();
        sessionFactory = conn.NewHibernateUtil.getSessionFactory();
    }
    Session ses;
    private SessionFactory sessionFactory;

    public void closeSession() {
        if (ses.isOpen()) {
            ses.close();
        }
    }

    public pojo.Delivery getDelevery(JTextField txtVehicleId, JTextField txtRouteId, JDateChooser dcDeleverDate) {
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Delivery delever = null;
        pojo.DeliveryItemLog diLog = null;
        try {
            pojo.Vehicle vehicle = new pojo.Vehicle();
            vehicle.setId(Integer.parseInt(txtVehicleId.getText()));
            pojo.RouteReg route = new pojo.RouteReg();
            route.setId(Integer.parseInt(txtRouteId.getText()));

            Criteria cr = ses.createCriteria(pojo.Delivery.class);
            cr.add(Restrictions.eq("vehicle", vehicle));
            cr.add(Restrictions.eq("routeReg", route));
            cr.add(Restrictions.eq("date", dcDeleverDate.getDate()));
            delever = (pojo.Delivery) cr.uniqueResult();
            return delever;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            //ses.close();
        }
        return null;
    }

    public ArrayList<pojo.DeliveryItemLog> getDeleveryItem(JTextField txtVehicleId, JTextField txtRouteId, JDateChooser dcDeleverDate) {
        pojo.Delivery delever = null;
        pojo.DeliveryItemLog diLog = null;

        delever = getDelevery(txtVehicleId, txtRouteId, dcDeleverDate);
        closeSession();

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.DeliveryItemLog> un = null;
        try {

            Criteria cr = ses.createCriteria(pojo.DeliveryItemLog.class);
            cr.add(Restrictions.eq("delivery", delever));
            cr.add(Restrictions.gt("quantity", 0.0));
            un = (ArrayList<DeliveryItemLog>) cr.list();
            return un;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            //ses.close();
        }
        return null;
    }
    ArrayList<pojo.DeliveryItemLog> list;

    public void addItem(JTextField txtVehicleId, JTextField txtRouteId, JTextField txtProductName, JTextField txtQ, JTextField txttotalValue, JDateChooser dcDeleverDate, JTable item) {
        try {
            System.out.println("Awa DI");
            list = getDeleveryItem(txtVehicleId, txtRouteId, dcDeleverDate);
            double qty = 0.0;
            DefaultTableModel dtm = (DefaultTableModel) item.getModel();
            for (DeliveryItemLog itemList : list) {
                if (itemList.getGrnLog().getProduct().getName().equals(txtProductName.getText())) {
                    if (itemList.getQuantity() >= Double.parseDouble(txtQ.getText())) {
                        Vector v = new Vector();
                        v.add(itemList.getGrnLog().getProduct().getName());
                        v.add(itemList.getUnits().getUnitName());
                        v.add(itemList.getGrnLog().getProduct().getCurrentPrice());
                        v.add(txtQ.getText());
                        qty = itemList.getQuantity();
                        v.add(txttotalValue.getText());
                        v.add(itemList.getGrnLog().getId());
                        v.add(itemList.getId());
                        dtm.addRow(v);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null, "Your requid quantity is less than remain quantity.Remain stock is " + qty + "", "Stock Status", JOptionPane.WARNING_MESSAGE);
                    }
                }
//                
            }
            closeSession();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    Customer customer;

    public Customer getCustomerByCusName(String customerName) {
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();

        try {
            Transaction bt = ses.beginTransaction();
            Criteria cr = ses.createCriteria(pojo.Customer.class);
            cr.add(Restrictions.eq("fname", customerName.split(" ")[0]));
            cr.add(Restrictions.eq("mname", customerName.split(" ")[1]));
            if (cr.uniqueResult() == null) {
                System.out.println("no Pojo.customer uniqueResult");

            } else {
                System.out.println(" yes Pojo.customer  uniqueResult ");
                customer = (pojo.Customer) cr.uniqueResult();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

        return customer;
    }

    public Customer getCustomerByCusId(int customerId) {
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();

        try {
            Transaction bt = ses.beginTransaction();
            Criteria cr = ses.createCriteria(pojo.Customer.class);
            cr.add(Restrictions.eq("id", customerId));
            if (cr.uniqueResult() == null) {
                System.out.println("no Pojo.customer uniqueResult");

            } else {
                System.out.println(" yes Pojo.customer  uniqueResult ");
                customer = (pojo.Customer) cr.uniqueResult();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

        return customer;
    }

    public void addCheck(JTextField txtCequeNUmber, JTextField txtBankName, JTextField txtAmount, JDateChooser dcReturnDate, JTable itemTable) {
        DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();
        Vector v = new Vector();
        v.add(txtCequeNUmber.getText());
        v.add(txtBankName.getText());
        v.add(txtAmount.getText());
        v.add(((JTextField) dcReturnDate.getDateEditor().getUiComponent()).getText());
        dtm.addRow(v);
        txtCequeNUmber.setText("");
        txtBankName.setText("");
        txtAmount.setText("0");
        txtCequeNUmber.requestFocus();
    }

    Invoice invoice;

    public int saveInvoice(JDateChooser dcSaleDate, String payStatus, JTextField txtCusId) {
        ses = sessionFactory.openSession();
        int done = 0;
        try {
            invoice = new Invoice();
            invoice.setDate(dcSaleDate.getDate());
            invoice.setPayStatus(payStatus);
            Customer customer = new Customer();
            customer.setId(Integer.parseInt(txtCusId.getText()));
            invoice.setCustomer(customer);

            Transaction t = ses.beginTransaction();
            ses.save(invoice);
            t.commit();
            ses.flush();
            done = 1;
        } catch (Exception e) {
            done = 0;
            e.printStackTrace();
        } finally {
            ses.close();
        }
        return done;
    }

    InvoiceLog invoiceLog;

    public int saveInvoiceLog(JDateChooser dcSaleDate, String payStatus, JTextField txtCusId, JTable tblDI) {
        int done = 0;
        try {
            int saveInvoice = saveInvoice(dcSaleDate, payStatus, txtCusId);
            if (saveInvoice == 1) {
                for (int i = 0; i < tblDI.getRowCount(); i++) {
                    invoiceLog = new InvoiceLog();

                    invoiceLog.setId(Integer.parseInt(tblDI.getValueAt(i, 5).toString()));
                    getIdByProductName(tblDI.getValueAt(i, 0).toString());
                    invoiceLog.setProduct(product);
                    invoiceLog.setQty(Double.parseDouble(tblDI.getValueAt(i, 3).toString()));
                    invoiceLog.setPrice(Double.parseDouble(tblDI.getValueAt(i, 2).toString()));
                    invoiceLog.setInvoice(invoice);
                    invoiceLog.setTotal(Double.parseDouble(tblDI.getValueAt(i, 3).toString()) * Double.parseDouble(tblDI.getValueAt(i, 2).toString()));

                    ses = sessionFactory.openSession();
                    Transaction t = ses.beginTransaction();
                    ses.save(invoiceLog);
                    t.commit();
                    ses.flush();
                    getDeliveryLog(tblDI, i);
                }
                DefaultTableModel dtm = (DefaultTableModel) tblDI.getModel();
                dtm.setRowCount(0);
                done = 1;
            }

        } catch (Exception e) {
            done = 0;
            e.printStackTrace();
        } finally {
        }
        return done;
    }

    DeliveryItemLog deliveryItemLog;

    public void getDeliveryLog(JTable tblDI, int id) {
        ses = sessionFactory.openSession();
        try {
            Criteria cr = ses.createCriteria(DeliveryItemLog.class);
            cr.add(Restrictions.eq("id", Integer.parseInt(tblDI.getValueAt(id, 6).toString())));
            deliveryItemLog = (DeliveryItemLog) cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
        //updateDeliverQty(tblDI, id);
    }

    public void getUnit(JTable tblDI, int id) {
        ses = sessionFactory.openSession();
        try {
            Criteria cr = ses.createCriteria(DeliveryItemLog.class);
            cr.add(Restrictions.eq("id", Integer.parseInt(tblDI.getValueAt(id, 6).toString())));
            deliveryItemLog = (DeliveryItemLog) cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
    }

    pojo.Product product;

    public int getIdByProductName(String productName) {
        int id = 0;
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            product = (pojo.Product) ses.createCriteria(pojo.Product.class).add(Restrictions.eq("name", productName)).uniqueResult();
            id = product.getId();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return id;
    }

    public void updateDeliverQty(JTable tblDI, int i) {
        try {
            ses = sessionFactory.openSession();
            deliveryItemLog.setQuantity(deliveryItemLog.getQuantity() - Double.parseDouble(tblDI.getValueAt(i, 3).toString()));
            Transaction t = ses.beginTransaction();
            ses.update(deliveryItemLog);
            t.commit();
            ses.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
    }

    pojo.MoneyBook moneyBook;

    public int saveMoneyBook(JDateChooser dcReturnDate, String description, double amount, String cashType, String dealType, String dealCategory) {
        int done = 0;
        try {

            moneyBook = new MoneyBook();
            moneyBook.setDate(dcReturnDate.getDate());
            moneyBook.setDscription(description);
            moneyBook.setAmount(amount);
            moneyBook.setDealType(getDealType(dealType));
            moneyBook.setDealCategory(getDealCategory(dealCategory));

            ses = conn.NewHibernateUtil.getSessionFactory().openSession();
            Transaction bt = ses.beginTransaction();
            ses.save(moneyBook);
            bt.commit();
            ses.flush();
            done = 1;
        } catch (Exception e) {
            done = 1;
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
        return done;
    }

    public void saveRouteDebit(JDateChooser dcReturnDate, String description, double amount, String cashType, String dealType, String dealCategory, JTextField txtRouteId) {
        try {
            int saveMoneyBook = saveMoneyBook(dcReturnDate, description, amount, cashType, dealType, dealCategory);
            if (saveMoneyBook == 1) {
                notifyCreater.getNotificationPopup("Root debit save to Money Book", 1000, NotificationIcon.error);
                pojo.RouteDebit routeDebit = new pojo.RouteDebit();
                routeDebit.setDate(dcReturnDate.getDate());
                routeDebit.setDebit(amount);
                pojo.RouteReg routeReg = new pojo.RouteReg();
                routeReg.setId(Integer.parseInt(txtRouteId.getText()));
                routeDebit.setRouteReg(routeReg);
                routeDebit.setMoneyBook(moneyBook);

                ses = conn.NewHibernateUtil.getSessionFactory().openSession();
                Transaction bt = ses.beginTransaction();
                ses.save(routeDebit);
                bt.commit();
                ses.flush();
            }
            notifyCreater.getNotificationPopup("Root debit save done", 1000, NotificationIcon.information);
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public void saveRouteCreit(JDateChooser dcReturnDate, double amount, JTextField txtRouteId) {
        try {
            pojo.RouteCredit routeCredit = new pojo.RouteCredit();
            routeCredit.setDate(dcReturnDate.getDate());
            routeCredit.setCredit(amount);
            pojo.RouteReg routeReg = new pojo.RouteReg();
            routeReg.setId(Integer.parseInt(txtRouteId.getText()));
            routeCredit.setRouteReg(routeReg);

            ses = conn.NewHibernateUtil.getSessionFactory().openSession();
            Transaction bt = ses.beginTransaction();
            ses.save(routeCredit);
            bt.commit();
            ses.flush();
            notifyCreater.getNotificationPopup("Root credit save done", 1000, NotificationIcon.information);
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public void saveCustomerCreit(JDateChooser dcReturnDate, double amount, JTextField txtCustomerId) {
        try {
            CusCredit cusCredit = new CusCredit();
            cusCredit.setDate(dcReturnDate.getDate());
            cusCredit.setAmount(amount);
            Customer customer = new Customer();
            customer.setId(Integer.parseInt(txtCustomerId.getText()));
            cusCredit.setCustomer(customer);

            ses = conn.NewHibernateUtil.getSessionFactory().openSession();
            Transaction bt = ses.beginTransaction();
            ses.save(cusCredit);
            bt.commit();
            ses.flush();
            notifyCreater.getNotificationPopup("Customer credit save done", 1000, NotificationIcon.information);
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public void updateCustomerCreit(double amount) {
        try {
            ses = sessionFactory.openSession();
            System.out.println(customer.getCredit());
            customer.setCredit(customer.getCredit() + amount);
            Transaction t = ses.beginTransaction();
            ses.update(customer);
            t.commit();
            ses.flush();
            notifyCreater.getNotificationPopup("Customer credit update done", 1000, NotificationIcon.information);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
    }

    public String updateCustomerCreitPay(JDateChooser dcReturnDate, String description, double amount, String cashType, String dealType, String dealCategory) {
        double credit = 0.0;
        try {
            int saveMoneyBook = saveMoneyBook(dcReturnDate, description, amount, cashType, dealType, dealCategory);
            if (saveMoneyBook == 1) {
                ses = sessionFactory.openSession();

                if (customer.getCredit() > amount) {
                    credit = customer.getCredit() - amount;
                    customer.setCredit(credit);
                } else if (amount > customer.getCredit()) {
                    credit = 0.0;
                    customer.setCredit(0.0);
                }
                Transaction t = ses.beginTransaction();
                ses.update(customer);
                t.commit();
                ses.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
        return credit + "";
    }

    public void saveRouteDebit(JDateChooser dcReturnDate, String description, double amount, String cashType, String dealType, String dealCategory, JTextField txtRouteId, JTable tblCheck) {
        try {
            saveMoneyBook(dcReturnDate, description, amount, cashType, dealType, dealCategory);

            pojo.RouteDebit routeDebit = new pojo.RouteDebit();
            routeDebit.setDate(dcReturnDate.getDate());
            routeDebit.setDebit(amount);
            pojo.RouteReg routeReg = new pojo.RouteReg();
            routeReg.setId(Integer.parseInt(txtRouteId.getText()));
            routeDebit.setRouteReg(routeReg);
            routeDebit.setMoneyBook(moneyBook);

            ses = conn.NewHibernateUtil.getSessionFactory().openSession();
            Transaction bt = ses.beginTransaction();
            ses.save(routeDebit);
            bt.commit();
            ses.flush();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public void saveCheck(JDateChooser dcReturnDate, JTextField txtRouteId, JTextField txtCustomerId, JTable tblChecks) {
        try {
            int done = 0;
            for (int i = 0; i < tblChecks.getRowCount(); i++) {
                //saveRouteDebit(dcReturnDate, "Deliver Cheque", Double.parseDouble(tblChecks.getValueAt(i, 2).toString()), "Cheque", "Deliver Cheque", "Income", txtRouteId);
                saveRouteCreit(dcReturnDate, Double.parseDouble(tblChecks.getValueAt(i, 2).toString()), txtRouteId);
                saveCustomerCreit(dcReturnDate, Double.parseDouble(tblChecks.getValueAt(i, 2).toString()), txtCustomerId);
                getCustomerByCusId(Integer.parseInt(txtCustomerId.getText()));
                updateCustomerCreit(Double.parseDouble(tblChecks.getValueAt(i, 2).toString()));
                //saveRouteDebit(dcReturnDate, description, i, cashType, dealType, dealCategory, txtRouteId);
                Cheques chequeDetails = new Cheques();
                chequeDetails.setCheckno(tblChecks.getValueAt(i, 0).toString());
                chequeDetails.setChequeAmount(Double.parseDouble(tblChecks.getValueAt(i, 2).toString()));
                chequeDetails.setDate(new Date());
                chequeDetails.setDiscription("Customer/" + txtCustomerId.getText());
                chequeDetails.setStatus(0);
                chequeDetails.setChequeDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblChecks.getValueAt(i, 3).toString()));
                chequeDetails.setType("+");
                chequeDetails.setBank(getBankByName(tblChecks.getValueAt(i, 1).toString()));

                ses = conn.NewHibernateUtil.getSessionFactory().openSession();
                Transaction bt = ses.beginTransaction();
                ses.save(chequeDetails);
                bt.commit();
                ses.flush();
                AssetControl.getInstance().updateBankAsset(tblChecks.getValueAt(i, 1).toString(), Double.parseDouble(tblChecks.getValueAt(i, 2).toString()), '+');
                done = 1;
            }
            if (done == 1) {
                notifyCreater.getNotificationPopup("Root cheque save done", 1000, NotificationIcon.information);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Bank getBankByName(String bankName) {
        Bank bank;
        try {
            ses = conn.NewHibernateUtil.getSessionFactory().openSession();
            bank = null;
            bank = (Bank) ses.createCriteria(Bank.class).add(Restrictions.eq("bank", bankName)).uniqueResult();
            return bank;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
        return null;
    }

    public pojo.DealType getDealType(String Type) {
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.DealType dealType = null;
        try {
            dealType = (pojo.DealType) ses.createCriteria(pojo.DealType.class).add(Restrictions.eq("type", Type)).uniqueResult();
            return dealType;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return null;
    }

    public pojo.DealCategory getDealCategory(String category) {
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.DealCategory dealCategory = null;
        try {
            dealCategory = (pojo.DealCategory) ses.createCriteria(pojo.DealCategory.class).add(Restrictions.eq("category", category)).uniqueResult();
            System.out.println(dealCategory.getCategory());
            return dealCategory;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return null;
    }

}
