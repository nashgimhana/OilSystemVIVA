/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Me
 */
public class Invoice {

    public pojo.Invoice getBy(int id) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Invoice obInvId = null;
        try {
            obInvId = (pojo.Invoice) ses.createCriteria(pojo.Invoice.class).add(Restrictions.eq("id", id)).uniqueResult();
            return obInvId;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ses.close();
        }
    }

    public List<pojo.Invoice> getBy(Date date) {
        return null;
    }

    /**
     *
     * @param invoice
     * @return return a String object, values as "not", "done", "error"
     */
    /**
     *
     * @param invoice
     * @return return a String object, values as "not", "done", "error"
     */
    public String update(pojo.Invoice invoice) {
        return "not";
    }

    public List<pojo.Invoice> getAll() {
        return null;
    }

    public int save(pojo.Invoice invoice) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        int invObj = 0;
        try {

            invObj = (int) ses.save(invoice);

            ses.beginTransaction().commit();
            System.out.println("invoice saved");
        } catch (Exception e) {
            System.out.println("saved nedda??");
            e.printStackTrace();
        } finally {
            ses.close();
        }
        return invObj;

    }
}
