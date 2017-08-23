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
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import m.NotificationCreater;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Bank;
import pojo.Cheques;
//import pojo.ChequeDetails;
import pojo.Delivery;
import pojo.DeliveryItemLog;
import pojo.Grn;
import pojo.MoneyBook;
import pojo.Product;

/**
 *
 * @author Buddhika Prasanna
 */
public class VehicleReturn {

    public VehicleReturn() {
        notifyCreater = new NotificationCreater();
    }

    private SessionFactory sessionFactory;
    NotificationCreater notifyCreater;

    public void addItem(JTextField productName, JTextField unit, JComboBox cmbItemStatus, JTextField loadQty, JTable itemTable) {
        DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();
        Vector v = new Vector();
        v.add(productName.getText());
        v.add(unit.getText());
        v.add(cmbItemStatus.getSelectedItem().toString());
        v.add(loadQty.getText());
        dtm.addRow(v);
        productName.setText("");
        unit.setText("");
        loadQty.setText("");
        productName.requestFocus();

    }

    public int getGrnLogId(JTextField txtPname) {
        int logId = 0;
        try {
            m.GrnLog grnLog = new m.GrnLog();
            List<pojo.GrnLog> itemlist = grnLog.getAllAvailabelStocksByProductId(new m.Product().getByName(txtPname.getText()));
            for (pojo.GrnLog log : itemlist) {
                logId = log.getId();
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        }
        return logId;
    }

    DeliveryItemLog diLog;
    Delivery delever = null;

    public void getDelevery(JTextField txtVehicleId, JTextField txtRouteId, JDateChooser dcDeleverDate) {
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
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
            //return delever;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        //return null;
    }

    public void getDelevery(String vehicleId, String routeId, Date deleverDate) {
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.Vehicle vehicle = new pojo.Vehicle();
            vehicle.setId(Integer.parseInt(vehicleId));
            pojo.RouteReg route = new pojo.RouteReg();
            route.setId(Integer.parseInt(routeId));

            Criteria cr = ses.createCriteria(pojo.Delivery.class);
            cr.add(Restrictions.eq("vehicle", vehicle));
            cr.add(Restrictions.eq("routeReg", route));
            cr.add(Restrictions.eq("date", deleverDate));
            delever = (pojo.Delivery) cr.uniqueResult();
            //return delever;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        //return null;
    }

    ArrayList<pojo.DeliveryItemLog> deliveryItemList;

    public ArrayList<pojo.DeliveryItemLog> getDeleveryItem(JTextField txtVehicleId, JTextField txtRouteId, JDateChooser dcDeleverDate) {
        getDelevery(txtVehicleId, txtRouteId, dcDeleverDate);
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {

            Criteria cr = ses.createCriteria(pojo.DeliveryItemLog.class);
            cr.add(Restrictions.eq("delivery", delever));
            cr.add(Restrictions.gt("quantity", 0.0));
            deliveryItemList = (ArrayList<DeliveryItemLog>) cr.list();
            return deliveryItemList;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            //ses.close();
        }
        return deliveryItemList;
    }
    ArrayList<pojo.DeliveryItemLog> list;

    public void addItem(JTextField txtVehicleId, JTextField txtRouteId, JDateChooser dcDeleverDate, JTable item) {
        try {
            list = getDeleveryItem(txtVehicleId, txtRouteId, dcDeleverDate);
            //closeSession();
            DefaultTableModel dtm = (DefaultTableModel) item.getModel();
            dtm.setRowCount(0);
            for (DeliveryItemLog itemList : list) {
                Vector v = new Vector();
                v.add(itemList.getGrnLog().getProduct().getName());
                v.add(itemList.getUnits().getUnitName());
                v.add("RETURN");
                v.add(itemList.getQuantity());
                v.add("");
                v.add(itemList.getGrnLog().getId());
                v.add(itemList.getId());
                dtm.addRow(v);
            }
            closeSession();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public String getByItemLogId(int logId) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.GrnLog grnLog = null;
        String pName = null;
        try {
            grnLog = (pojo.GrnLog) ses.createCriteria(pojo.GrnLog.class).add(Restrictions.eq("id", logId)).uniqueResult();
            pName = grnLog.getProduct().getName();
            return pName;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return null;
    }

    public String getByUnitId(int unitId) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.GrnLog grnLog = null;
        String uName = null;
        try {
            grnLog = (pojo.GrnLog) ses.createCriteria(pojo.GrnLog.class).add(Restrictions.eq("id", unitId)).uniqueResult();
            uName = grnLog.getProduct().getName();
            return uName;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return null;
    }

    public int getRouteByName(String routeName) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.RouteReg routeReg = null;
        int id = 0;
        try {
            routeReg = (pojo.RouteReg) ses.createCriteria(pojo.RouteReg.class).add(Restrictions.eq("name", routeName)).uniqueResult();
            id = routeReg.getId();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return 0;
    }

    public int getVehicleByNumber(String routeName) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Vehicle vehicle = null;
        int id = 0;
        try {
            vehicle = (pojo.Vehicle) ses.createCriteria(pojo.Vehicle.class).add(Restrictions.eq("number1", routeName)).uniqueResult();
            id = vehicle.getId();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return 0;
    }

    public void getByProductName(String productName) {
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = ses.createCriteria(pojo.Product.class);
            cr.add(Restrictions.eq("name", productName));
            product = (Product) cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
    }

    Session ses;

    public void closeSession() {
        if (ses.isOpen()) {
            ses.close();
        }
    }

    public void addReturnCD(JComboBox cmbCategory, JComboBox cmbType, JTextField txtAmount, JTextField txtRemark, JTable itemTable) {
        DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();
        Vector v = new Vector();
        v.add(cmbCategory.getSelectedItem().toString());
        v.add(cmbType.getSelectedItem().toString());
        v.add(txtAmount.getText());
        v.add(txtRemark.getText());
        dtm.addRow(v);
        cmbCategory.setSelectedIndex(0);
        cmbType.setSelectedIndex(0);
        txtAmount.setText("0");
        txtRemark.setText("NONE");
        txtAmount.requestFocus();
    }

    public void addCheck(JTextField txtCequeNUmber, JTextField txtBankName, JTextField txtAmount, JDateChooser dcReturnDateCH, JTextField txtDescrip, JTable itemTable) {
        DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();
        Vector v = new Vector();
        v.add(txtCequeNUmber.getText());
        v.add(txtBankName.getText());
        v.add(txtAmount.getText());
        v.add(((JTextField) dcReturnDateCH.getDateEditor().getUiComponent()).getText());
        v.add(txtDescrip.getText());
        dtm.addRow(v);
        txtCequeNUmber.setText("");
        txtBankName.setText("");
        txtAmount.setText("0");
        txtCequeNUmber.requestFocus();
    }

    pojo.GrnLog grnLog = null;
    pojo.Product product;

    public String getGrnDetail(int Id) {
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = ses.createCriteria(pojo.GrnLog.class);
            cr.add(Restrictions.eq("id", Id));
            grnLog = (pojo.GrnLog) cr.uniqueResult();
            int grnId = grnLog.getGrn().getId();
            int productId = grnLog.getProduct().getId();
            double currentQty = grnLog.getProduct().getCurrentStock();
            product = grnLog.getProduct();
            int unitId = grnLog.getProduct().getUnits().getId();
            double qty = grnLog.getQuantity();
            double remainqty = grnLog.getRemainingQuantity();
            return grnId + "/" + productId + "/" + qty + "/" + remainqty + "/" + currentQty + "/" + unitId;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return null;
    }

    public int updateQty(JTable itemTable, JTable cashTable, JDateChooser dcReturnDate) {
        int done = 0;

        try {
            for (int i = 0; i < itemTable.getRowCount(); i++) {
                pojo.Grn grn = new Grn();
                String Id = getGrnDetail(Integer.parseInt(itemTable.getValueAt(i, 5).toString()));

                grn.setId(Integer.parseInt(Id.split("/")[0]));
                grnLog.setQuantity(Double.parseDouble(Id.split("/")[2]) + Double.parseDouble(itemTable.getValueAt(i, 4).toString()));
                grnLog.setRemainingQuantity(Double.parseDouble(Id.split("/")[3]) + Double.parseDouble(itemTable.getValueAt(i, 4).toString()));

                ses = conn.NewHibernateUtil.getSessionFactory().openSession();
                Transaction bt = ses.beginTransaction();
                ses.update(grnLog);
                bt.commit();
                ses.flush();

                product.setId(Integer.parseInt(Id.split("/")[1]));
                System.out.println("Return Qty" + Double.parseDouble(Id.split("/")[4]) + Double.parseDouble(itemTable.getValueAt(i, 4).toString()));
                product.setCurrentStock(Double.parseDouble(Id.split("/")[4]) + Double.parseDouble(itemTable.getValueAt(i, 4).toString()));
                ses = conn.NewHibernateUtil.getSessionFactory().openSession();
                Transaction bt0 = ses.beginTransaction();
                ses.update(product);
                bt0.commit();
                ses.flush();
                done = updateLoadQty(itemTable, i);
            }
            if (done == 1) {
                notifyCreater.getNotificationPopup("Quantity update done", 2000, NotificationIcon.information);
                saveCashTable(cashTable, dcReturnDate);
            }
        } catch (NumberFormatException | HibernateException e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            //ses.close();
            DefaultTableModel dtm = (DefaultTableModel) itemTable.getModel();
            dtm.setRowCount(0);
        }
        return done;
    }

    public int updateLoadQty(JTable itemTable, int i) {
        int done = 0;
        try {
            deliveryItemLog = getDeleverItemLog(itemTable, i);
            ses = conn.NewHibernateUtil.getSessionFactory().openSession();
            Transaction bt0 = ses.beginTransaction();
            double qty = deliveryItemLog.getQuantity();
            deliveryItemLog.setQuantity(qty - Double.parseDouble(itemTable.getValueAt(i, 3).toString()));

            ses.update(deliveryItemLog);
            bt0.commit();
            ses.flush();
            done = 1;
        } catch (Exception e) {
            e.printStackTrace();
            done = 0;
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return done;
    }
    pojo.DeliveryItemLog deliveryItemLog;

    public pojo.DeliveryItemLog getDeleverItemLog(JTable itemTable, int i) {
        try {
            deliveryItemLog = new DeliveryItemLog();

            ses = conn.NewHibernateUtil.getSessionFactory().openSession();
            Criteria cr = ses.createCriteria(pojo.DeliveryItemLog.class);
            cr.add(Restrictions.eq("id", Integer.parseInt(itemTable.getValueAt(i, 6).toString())));
            deliveryItemLog = (pojo.DeliveryItemLog) cr.uniqueResult();
            return deliveryItemLog;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return null;
    }

    public void saveCashTable(JTable cashTable, JDateChooser dcReturnDate) {
        try {
            if (cashTable.getRowCount() > 0) {
                for (int i = 0; i < cashTable.getRowCount(); i++) {
                    pojo.MoneyBook moneyBook = new MoneyBook();
                    moneyBook.setDate(dcReturnDate.getDate());
                    moneyBook.setDscription(cashTable.getValueAt(i, 3).toString());
                    moneyBook.setAmount(Double.parseDouble(cashTable.getValueAt(i, 2).toString()));
//                    moneyBook.setCashType(getCashType("Cash"));
                    moneyBook.setDealType(getDealType(cashTable.getValueAt(i, 0).toString()));
                    moneyBook.setDealCategory(getDealCategory(cashTable.getValueAt(i, 1).toString()));

                    ses = conn.NewHibernateUtil.getSessionFactory().openSession();
                    Transaction bt = ses.beginTransaction();
                    ses.save(moneyBook);
                    bt.commit();
                    ses.flush();
                    notifyCreater.getNotificationPopup("Cash save done", 2000, NotificationIcon.information);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }
    pojo.MoneyBook moneyBook;

    public pojo.MoneyBook saveMoneyBook(JDateChooser dcReturnDate, String description, double amount, String cashType, String dealType, String dealCategory) {
        try {
            moneyBook = new MoneyBook();
            moneyBook.setDate(dcReturnDate.getDate());
            moneyBook.setDscription(description);
            moneyBook.setAmount(amount);
//            moneyBook.setCashType(getCashType(cashType));
            moneyBook.setDealType(getDealType(dealType));
            moneyBook.setDealCategory(getDealCategory(dealCategory));

            ses = conn.NewHibernateUtil.getSessionFactory().openSession();
            Transaction bt = ses.beginTransaction();
            ses.save(moneyBook);
            bt.commit();
            ses.flush();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
        return moneyBook;
    }

    public void saveRouteDebit(JDateChooser dcReturnDate, String description, double amount, String cashType, String dealType, String dealCategory, JTextField txtRouteId) {
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
            notifyCreater.getNotificationPopup("Route debit save done", 2000, NotificationIcon.information);
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
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

    public void saveCheck(JDateChooser dcReturnDate, JTextField txtRouteId, JTable tblChecks) {
        try {
            for (int i = 0; i < tblChecks.getRowCount(); i++) {
                saveRouteDebit(dcReturnDate, "Deliver Cheque", Double.parseDouble(tblChecks.getValueAt(i, 2).toString()), "Cheque", "Deliver Cheque", "Income", txtRouteId);

                //saveRouteDebit(dcReturnDate, description, i, cashType, dealType, dealCategory, txtRouteId);
                Cheques chequeDetails = new Cheques();
                chequeDetails.setCheckno(tblChecks.getValueAt(i, 0).toString());
                chequeDetails.setChequeAmount(Double.parseDouble(tblChecks.getValueAt(i, 2).toString()));
                chequeDetails.setDate(new Date());
                chequeDetails.setDiscription("RouteReg/" + txtRouteId.getText() + "/" + tblChecks.getValueAt(i, 2).toString());
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
                notifyCreater.getNotificationPopup("Cheque save done", 2000, NotificationIcon.information);
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

    public void saveRouteCredit(JDateChooser dcReturnDate, double amount, JTextField txtRouteId) {
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
            notifyCreater.getNotificationPopup("Route credit save done", 2000, NotificationIcon.information);
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public void saveChecks(JDateChooser dcReturnDate, double amount, JTextField txtRouteId) {
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
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }

//    public pojo.CashType getCashType(String Type) {
//        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
//        pojo.CashType cashType = null;
//        try {
//            cashType = (pojo.CashType) ses.createCriteria(pojo.CashType.class).add(Restrictions.eq("type", Type)).uniqueResult();
//            return cashType;
//        } catch (Exception e) {
//            e.printStackTrace();
//            Errormzg.displayerrorMessage(e.toString());
//        } finally {
//            ses.close();
//        }
//        return null;
//    }
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

    public void calProductCost(JTable tblItemVR, JTextField txtProductionCost) {
        try {
            double cost = 0.0, totalCost = 0.0;
            for (int i = 0; i < tblItemVR.getRowCount(); i++) {
                getByProductName(tblItemVR.getValueAt(i, 0).toString());
                double buyingPrice = product.getCurrentPrice();
                //System.out.println("Buying Price" + buyingPrice);
                //System.out.println(product.getCurrentPrice());
                double saleQuantity = Double.parseDouble(tblItemVR.getValueAt(i, 3).toString()) - Double.parseDouble(tblItemVR.getValueAt(i, 4).toString());
                //System.out.println("Sale Quantity : " + saleQuantity);
                cost = buyingPrice * saleQuantity;
                //SSystem.out.println("Cost" + cost);
                totalCost += cost;
                //System.out.println("Total Cost" + totalCost);
            }
            txtProductionCost.setText(String.valueOf(Math.round(totalCost * 100.0) / 100.0));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void calDeleverCost(String deliverInfo, Date deliverDate, JTextField txtDeleverCost) {

        String[] split = deliverInfo.split("/");
        getDelevery(split[1], split[0], deliverDate);
        ArrayList<pojo.MoneyBook> list;
        double totalCost = 0.0;
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cr = ses.createCriteria(MoneyBook.class);
            cr.add(Restrictions.eq("dscription", delever.getId() + "/VehicleLoadExpend/None"));
            list = (ArrayList<MoneyBook>) cr.list();
            for (MoneyBook moneyBookItem : list) {
                double cost = moneyBookItem.getAmount();
                totalCost += cost;
            }
            txtDeleverCost.setText(String.valueOf(Math.round(totalCost * 100.0) / 100.0));
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            ses.close();
        }
    }

}
