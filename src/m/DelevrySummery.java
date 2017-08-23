/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Buddhika Prasanna
 */
public class DelevrySummery {

    private SessionFactory sessionFactory;

    public DelevrySummery() {
        sessionFactory = conn.NewHibernateUtil.getSessionFactory();
    }

    public int saveLoad(pojo.Delivery delivery) {
        Session ses = sessionFactory.openSession();
        int done = 0;
        try {
            Transaction t = ses.beginTransaction();
            ses.save(delivery);
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

    public int saveLoadItems(pojo.DeliveryItemLog deliveryItemLog) {
        Session ses = sessionFactory.openSession();
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

    public ArrayList<pojo.GrnLog> getAveQty() {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.GrnLog> grnLog = null;
        try {
            Criteria createCriteria = s.createCriteria(pojo.GrnLog.class);
            grnLog = (ArrayList<pojo.GrnLog>) createCriteria.list();
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            s.close();
        }
        return grnLog;
    }

    public int saveMeonyBook(pojo.MoneyBook moneyBook) {
        Session ses = sessionFactory.openSession();
        int done = 0;
        try {
            Transaction t = ses.beginTransaction();
            ses.save(moneyBook);
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

    public pojo.DealType getDealIdByType(String dealType) {
        Session ses = sessionFactory.openSession();
        pojo.DealType type = null;
        try {
            Transaction bt = ses.beginTransaction();
            Criteria cr = ses.createCriteria(pojo.DealType.class);
            cr.add(Restrictions.eq("type", dealType));
            type = (pojo.DealType) cr.uniqueResult();
            return type;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

        return null;
    }

}
