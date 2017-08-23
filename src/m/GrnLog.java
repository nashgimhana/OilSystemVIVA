/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Me
 */
public class GrnLog {

    private Session session = null;

    public pojo.GrnLog getById(int grnLogId) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.GrnLog grnLid = null;
        try {
            grnLid = (pojo.GrnLog) ses.createCriteria(pojo.GrnLog.class).add(Restrictions.eq("id", grnLogId)).uniqueResult();
        } catch (Exception e) {
        } finally {
            ses.close();
        }
        return grnLid;
    }

    public pojo.GrnLog getByGrnId(pojo.Grn grn) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.GrnLog grnLid = null;
        try {
            grnLid = (pojo.GrnLog) ses.createCriteria(pojo.GrnLog.class).add(Restrictions.eq("grn", grn)).uniqueResult();
        } catch (Exception e) {
        } finally {
            ses.close();
        }
        return grnLid;
    }

    public pojo.GrnLog getBy(int id) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.GrnLog name = null;
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.GrnLog.class);
            Criteria add = createCriteria.add(Restrictions.eq("id", id));
            name = (pojo.GrnLog) add.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return name;
    }

    public List<pojo.GrnLog> getBy(pojo.GrnLog grnLog) {
        return null;
    }

    public List<pojo.GrnLog> getAllAvailabelStocks() {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.GrnLog> list = session.createCriteria(pojo.GrnLog.class).add(Restrictions.gt("remainingQuantity", 0.0)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<pojo.GrnLog> getAllAvailabelStocksByProductId(pojo.Product product) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = session.createCriteria(pojo.GrnLog.class);
            cr.add(Restrictions.gt("remainingQuantity", 0.0));
            cr.add(Restrictions.eq("product", product));
            List<pojo.GrnLog> list = cr.list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    /**
     *
     * @param grnLog
     * @return will return an String object, values as "done", "not" or "error"
     */
    public int save(pojo.GrnLog grnLog) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        int grnlgid = 0;
        try {
            Transaction beginTransaction = s.beginTransaction();
            grnlgid = (int) s.save(grnLog);
            System.out.println(grnlgid + "grn id eka");
//            Errormzg.displayconfirmMessage("done");
            beginTransaction.commit();
            s.flush();
            return grnlgid;
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            e.printStackTrace();
            return 0;

        } finally {
            s.close();
        }

    }

    /**
     *
     * @param grnLog
     * @return will return an String object, values as "done", "not" or "error"
     */
    public String update(pojo.GrnLog grnLog) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.GrnLog.class);
            openSession.update(grnLog);
            beginTransaction.commit();
            openSession.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return "grnLog Updated";
    }

    public ArrayList<pojo.GrnLog> getProduct(pojo.GrnLog grnLog) {

        return null;
    }

    public ArrayList<pojo.GrnLog> viewAllGrnLog() {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.GrnLog> name = null;

        try {
            Criteria createCriteria = openSession.createCriteria(pojo.GrnLog.class);
            name = (ArrayList<pojo.GrnLog>) createCriteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return name;
    }

    public ArrayList<pojo.GrnLog> grn(pojo.Product product) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(pojo.GrnLog.class).add(Restrictions.eq("product", product));
        ArrayList<pojo.GrnLog> grl = (ArrayList<pojo.GrnLog>) cr.list();

        ses.close();
        return grl;
    }

    public ArrayList<pojo.GrnLog> grn1(pojo.Product product) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.GrnLog> al = null;
        //Criteria cr = ses.createCriteria(pojo.GrnLog.class).add(Restrictions.eq("product", product));
//        ArrayList<pojo.GrnLog> grl = (ArrayList<pojo.GrnLog>) cr.list();
        //ses.close();
        //return grl;
        try {
            Criteria createCriteria = ses.createCriteria(pojo.GrnLog.class);
            createCriteria.add(Restrictions.eq("product", product));
            createCriteria.add(Restrictions.gt("remainingQuantity", 0.0));
            al = (ArrayList<pojo.GrnLog>) createCriteria.list();
        } catch (Exception e) {
        } finally {
            ses.close();
        }

        //ses.close();
        return al;
    }

    public ArrayList<pojo.GrnLog> allTestGrnL(pojo.GrnLog log) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.GrnLog> grl = null;
        try {
            Criteria cr = ses.createCriteria(pojo.GrnLog.class).add(Restrictions.eq("product", log.getProduct()));
            grl = (ArrayList<pojo.GrnLog>) cr.list();

            ses.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return grl;
    }

    //nash 
    public ArrayList<pojo.GrnLog> loadNotEmptyProductByName(pojo.Product prid) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.GrnLog> grnload = null;
        try {
            Criteria c = s.createCriteria(pojo.GrnLog.class);
            c.add(Restrictions.and(Restrictions.eq("product", prid), Restrictions.gt("remainingQuantity", new Double(0))));
            grnload = (ArrayList<pojo.GrnLog>) c.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }

        return grnload;
    }

    public ArrayList<pojo.GrnLog> loadNotEmptyProductById(int prid) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.GrnLog> grnload = null;
        try {
            Criteria c = s.createCriteria(pojo.GrnLog.class);
            c.add(Restrictions.and(Restrictions.eq("product", prid), Restrictions.gt("remainingQuantity", new Double(0))));
            grnload = (ArrayList<pojo.GrnLog>) c.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            s.close();
        }

        return grnload;
    }

}
