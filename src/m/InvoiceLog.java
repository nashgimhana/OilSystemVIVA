/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Me
 */
public class InvoiceLog {

    public pojo.InvoiceLog getBy(int id) {
        return null;
    }

    public List<pojo.InvoiceLog> getBy(pojo.Invoice invoice) {
        return null;
    }

    /**
     *
     * @param invoiceLog
     * @return return a String object, values as "not", "done", "error"
     */
    public String save(pojo.InvoiceLog invoiceLog) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();

        try {
            ses.save(invoiceLog);
            ses.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

        return "Invoice Log Saved";
    }

    public String update(pojo.InvoiceLog invoiceLog) {
        return "not";
    }

    public int saveint(pojo.InvoiceLog invoiceLog) {
        Session session = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        int save;
        try {
            save = (int) session.save(invoiceLog);
            bt.commit();
            session.flush();

        } catch (Exception e) {
            e.printStackTrace();
            if (bt != null) {
                bt.rollback();
            }
            return 0;
        } finally {
            session.close();
        }
        return save;
    }
}
