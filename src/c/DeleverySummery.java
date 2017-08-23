/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.alee.managers.notification.NotificationIcon;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import m.NotificationCreater;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.AssetStatus;
import pojo.DealCategory;
import pojo.Delivery;
import pojo.DeliveryItemLog;
import pojo.Employee;
import pojo.GrnLog;
import pojo.MoneyBook;
import pojo.Product;
import pojo.RouteReg;
import pojo.Units;
import pojo.Vehicle;

/**
 *
 * @author Buddhika Prasanna
 */
public class DeleverySummery {

    JTable itemJTable;

    public DeleverySummery(JTable itemTable) {
        this.itemJTable = itemTable;
    }

    pojo.Delivery delivery;

    public int saveLoad(JDateChooser dcDeliverDate, JTextField txtRouteId, JTextField txtVehicleId, JTable tblEmp, JTable tblExpe) {
        int done = 0;
        delivery = new Delivery();
        pojo.RouteReg routeReg = new RouteReg();
        pojo.Vehicle vehicle = new Vehicle();
        pojo.Employee employee = null;
        try {
            delivery.setDate(dcDeliverDate.getDate());
            routeReg.setId(Integer.parseInt(txtRouteId.getText()));
            delivery.setRouteReg(routeReg);
            vehicle.setId(Integer.parseInt(txtVehicleId.getText()));
            delivery.setVehicle(vehicle);

            employee = new Employee();
            employee.setId(Integer.parseInt(tblEmp.getValueAt(0, 0).toString()));
            delivery.setEmployeeByDriver(employee);

            employee = new Employee();
            employee.setId(Integer.parseInt(tblEmp.getValueAt(1, 0).toString()));
            delivery.setEmployeeByPartner1(employee);

            employee = new Employee();
            employee.setId(Integer.parseInt(tblEmp.getValueAt(2, 0).toString()));
            delivery.setEmployeeByPartner2(employee);

            int saveLoad = new m.DelevrySummery().saveLoad(delivery);
            if (saveLoad == 1) {
                done = saveLoadItem(delivery);
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            e.printStackTrace();
        }
        return done;
    }

    public int saveLoadItem(pojo.Delivery delivery) {
        int done = 0;
        try {
            for (int i = 0; i < itemJTable.getRowCount(); i++) {
                pojo.DeliveryItemLog deliveryItemLog = new DeliveryItemLog();

                pojo.GrnLog grnLog = new GrnLog();
                grnLog.setId(Integer.parseInt(itemJTable.getValueAt(i, 3).toString()));
                deliveryItemLog.setGrnLog(grnLog);

                deliveryItemLog.setDelivery(delivery);

                pojo.Units units = new Units();
                units.setId(new m.Units().getByName01(itemJTable.getValueAt(i, 1).toString()));
                deliveryItemLog.setUnits(units);

                deliveryItemLog.setQuantity(Double.parseDouble(itemJTable.getValueAt(i, 2).toString()));

                int saveLoadItems = new m.DelevrySummery().saveLoadItems(deliveryItemLog);
                if (saveLoadItems == 1) {
                    updateAveQty(i);
                    updateCurrentQty(i);
                    done = 1;
                }
            }
            DefaultTableModel dtm = (DefaultTableModel) itemJTable.getModel();
            dtm.setRowCount(0);
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        }
        return done;
    }

    public void updateAveQty(int i) {
        m.Product product = null;
        try {
            m.GrnLog grnLog = new m.GrnLog();
            product = new m.Product();
            List<pojo.GrnLog> itemlist = grnLog.getAllAvailabelStocksByProductId(product.getByName(itemJTable.getValueAt(i, 0).toString()));

            Double qty = Double.parseDouble(itemJTable.getValueAt(i, 2).toString());

            for (pojo.GrnLog log : itemlist) {
                pojo.GrnLog grnLog01 = new GrnLog();

                System.out.println(log.getProduct().getId() + ": " + log.getRemainingQuantity());
                Double remainQty = log.getRemainingQuantity();
                if (log.getRemainingQuantity() >= qty) {
                    remainQty -= qty;
                    System.out.println(remainQty);
                    log.setRemainingQuantity(remainQty);
                    new m.GrnLog().update(log);
                    break;
                } else if (log.getRemainingQuantity() <= qty) {
                    qty -= remainQty;
                    System.out.println(qty);
                    log.setRemainingQuantity(0.0);
                    new m.GrnLog().update(log);
                }
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            product.closeSession();
        }
    }

    public void updateCurrentQty(int i) {
        try {
            m.Product productm = new m.Product();
            product = productm.getByprName(itemJTable.getValueAt(i, 0).toString());
            double currentQty = product.getCurrentStock();
            currentQty -= Double.parseDouble(itemJTable.getValueAt(i, 2).toString());
            product.setCurrentStock(currentQty);
            productm.closeSession();
            productm.update(product);
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public void saveMoneyBook(JTable moneyBook) {
        for (int i = 0; i < moneyBook.getRowCount(); i++) {

            pojo.DealCategory dealCategory = new DealCategory();
            dealCategory.setId(2);

            pojo.MoneyBook moneyBook1 = new MoneyBook();
            moneyBook1.setDate(new Date());
            moneyBook1.setDscription(delivery.getId() + "/" + "VehicleLoadExpend" + "/" + moneyBook.getValueAt(i, 2).toString());
            moneyBook1.setAmount(Double.parseDouble(moneyBook.getValueAt(i, 1).toString()));
            moneyBook1.setDealType(new m.DelevrySummery().getDealIdByType(moneyBook.getValueAt(i, 0).toString()));
            moneyBook1.setDealCategory(dealCategory);
            int saveMeonyBook = new m.DelevrySummery().saveMeonyBook(moneyBook1);
            if (saveMeonyBook == 1) {
                new NotificationCreater().getNotificationPopup("Vehicle Load Expenditure save done.", 2000, NotificationIcon.information);
            }

            AssetControl.getInstance().updateCashAsset(Double.parseDouble(moneyBook.getValueAt(i, 1).toString()), '-');
        }
    }

    Session ses;
    pojo.Product product;

    public void getByProductName(String productName) {
        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = ses.createCriteria(AssetStatus.class);
            cr.add(Restrictions.eq("name", productName));
            product = (pojo.Product) cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
    }
}
