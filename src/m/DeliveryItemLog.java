/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Me
 */
public class DeliveryItemLog {

    Session ses;

    public pojo.DeliveryItemLog getById(int id) {
        return null;
    }

    public List<pojo.DeliveryItemLog> getByDelivery(pojo.Delivery delivery) {
        return null;
    }

    public pojo.DeliveryItemLog getByProductName(String product) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.DeliveryItemLog pro = null;
        try {
            pro = (pojo.DeliveryItemLog) ses.createCriteria(pojo.DeliveryItemLog.class).add(Restrictions.eq("name", product)).uniqueResult();
            return pro;
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
}
