/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.DeliveryItemLog;
import pojo.Grn;
import pojo.GrnLog;
import pojo.MoneyBook;
import pojo.Product;
import pojo.Supplier;
import pojo.Units;

/**
 *
 * @author Buddhika Prasanna
 */
public class DeleverySelfProduct {

    Session ses;
    private SessionFactory sessionFactory;

    public DeleverySelfProduct() {
        sessionFactory = conn.NewHibernateUtil.getSessionFactory();
    }
    pojo.Delivery deliveryNew;

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
            deliveryNew = delever;
            return delever;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            //ses.close();
        }
        return null;
    }

    public void closeSession() {
        if (ses.isOpen()) {
            ses.close();
        }
    }
    int DlogId, GrnLogId, productId;

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
            un = (ArrayList<DeliveryItemLog>) cr.list();
            //diLog = (pojo.DeliveryItemLog) cr.uniqueResult();
            //System.out.println(diLog.getId());
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

    public void addItem(JTextField txtVehicleId, JTextField txtRouteId, JDateChooser dcDeleverDate, JTable item) {
        try {
            list = getDeleveryItem(txtVehicleId, txtRouteId, dcDeleverDate);
            //closeSession();
            DefaultTableModel dtm = (DefaultTableModel) item.getModel();
            dtm.setRowCount(0);
            for (DeliveryItemLog itemList : list) {
                if (!itemList.getUnits().getUnitName().contains("bottle")) {
                    Vector v = new Vector();
                    v.add(itemList.getGrnLog().getProduct().getName());
                    v.add(itemList.getUnits().getUnitName());
                    v.add("RETURN");
                    v.add(itemList.getQuantity());
                    v.add(itemList.getGrnLog().getId());
                    v.add(itemList.getId());
                    dtm.addRow(v);
                }

            }
            closeSession();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public double getBuyingPrice(JTable tblItem) {
        pojo.GrnLog grnLog = null;
        double price = 0.0;

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = ses.createCriteria(pojo.GrnLog.class);
            cr.add(Restrictions.eq("id", Integer.parseInt(tblItem.getValueAt(tblItem.getSelectedRow(), 4).toString())));
            grnLog = (pojo.GrnLog) cr.uniqueResult();
            return grnLog.getBuyingPrice();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            //ses.close();
        }
        return 0.0;
    }

    Grn grnNew;
    Product productNew;
    GrnLog grnLogNew;
    Units unitsNew;
    DeliveryItemLog deliveryItemLogNew;

    public int saveGRN(JDateChooser dcDelever, JTable tblItem) {
        Grn grn = new Grn();
        Supplier supplier = new Supplier();

        supplier.setId(1);
        grn.setSupplier(supplier);
        grn.setDate(dcDelever.getDate());
        grnNew = grn;
        ses = sessionFactory.openSession();

        int done = 0;
        try {
            Transaction t = ses.beginTransaction();
            ses.save(grn);
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

    public void saveGRNLog(JDateChooser dcDelever, JTextField txtTPP, JTextField txtTQty, JTextField txtTPName, JTable tblItem) {
        int done = saveGRN(dcDelever, tblItem);
        if (done == 1) {
            GrnLog grnLog = new GrnLog();

            grnLog.setGrn(grnNew);

            getByProductName(txtTPName.getText());
            grnLog.setProduct(productNew);
            grnLog.setBuyingPrice(Double.parseDouble(txtTPP.getText()));
            grnLog.setQuantity(0.0);
            grnLog.setRemainingQuantity(0.0);
            grnLog.setTotal(0.0);
            grnLogNew = grnLog;
            ses = sessionFactory.openSession();

            try {
                Transaction t = ses.beginTransaction();
                ses.save(grnLog);
                t.commit();
                ses.flush();
                done = 1;
            } catch (Exception e) {
                done = 0;
                e.printStackTrace();
            } finally {
                ses.close();
            }
        }
    }

    public void getByProductName(String productName) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        Product product = null;
        try {
            product = (pojo.Product) ses.createCriteria(Product.class).add(Restrictions.eq("name", productName)).uniqueResult();
            productNew = product;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
    }

    public int saveDeleverItemLog(JDateChooser dcDeleverDate1, JTable tblItemVR1, JTextField txtVehicleId1, JTextField txtRouteId1, JTextField txtTPUnit, JTextField txtTQty) {
        DeliveryItemLog deliveryItemLog = new DeliveryItemLog();

        deliveryItemLog.setGrnLog(grnLogNew);

        getDelevery(txtVehicleId1, txtRouteId1, dcDeleverDate1);
        deliveryItemLog.setDelivery(deliveryNew);

        getByUnitName(txtTPUnit.getText());
        deliveryItemLog.setUnits(unitsNew);
        deliveryItemLog.setQuantity(Double.parseDouble(txtTQty.getText()));

        ses = sessionFactory.openSession();

        int done = 0;
        try {
            Transaction t = ses.beginTransaction();
            ses.save(deliveryItemLog);
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

    public void getByUnitName(String unitName) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        Units unit = null;
        try {
            unit = (Units) ses.createCriteria(Units.class).add(Restrictions.eq("unitName", unitName)).uniqueResult();
            unitsNew = unit;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
    }

    public void getByLogId(int id) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        DeliveryItemLog deliveryItemLog = null;
        try {
            deliveryItemLog = (DeliveryItemLog) ses.createCriteria(DeliveryItemLog.class).add(Restrictions.eq("id", id)).uniqueResult();
            deliveryItemLogNew = deliveryItemLog;
            deliveryItemLogNew.getQuantity();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
    }
    MoneyBook moneyBook;

    public pojo.MoneyBook saveMoneyBook(JDateChooser dcReturnDate, String description, double amount, String cashType, String dealType, String dealCategory) {
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
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        }
        return moneyBook;
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

    public int updateQty(double Qty) {
        ses = sessionFactory.openSession();

        int done = 0;
        try {
            Transaction t = ses.beginTransaction();
            deliveryItemLogNew.setQuantity(Qty);
            ses.update(deliveryItemLogNew);
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
    
    public int updateProduct(double price) {
        ses = sessionFactory.openSession();

        int done = 0;
        try {
            Transaction t = ses.beginTransaction();
            productNew.setCurrentPrice(price);
            ses.update(productNew);
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

}
