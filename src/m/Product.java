/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.util.ArrayList;
import org.hibernate.Criteria;
import c.Errormzg;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Me
 */
public class Product {

    Errormzg er = new Errormzg();

    public pojo.Product getBy(int id) {
        //sesath
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Product name = null;
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.Product.class);
            Criteria add = createCriteria.add(Restrictions.eq("id", id));
            name = (pojo.Product) add.uniqueResult();

        } catch (Exception e) {
        } finally {
            openSession.close();
        }
        return name;
    }

    public pojo.Product getByName(pojo.Product product) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Product pro = null;
        try {
            pro = (pojo.Product) ses.createCriteria(pojo.Product.class).add(Restrictions.eq("name", product.getName())).uniqueResult();
            return pro;
        } catch (Exception e) {
        } finally {
            ses.close();
        }
        return null;
    }
    
    public pojo.Product getByGRNLog(pojo.GrnLog log) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Product pro = null;
        try {
            pro = (pojo.Product) ses.createCriteria(pojo.Product.class).createAlias("grnLogs", "gl").add(Restrictions.eq("gl.id", log.getId())).uniqueResult();
            return pro;
        } catch (Exception e) {
        } finally {
            ses.close();
        }
        return null;
    }

    public pojo.Product getByName(String productName) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Product pro = null;
        try {
            pro = (pojo.Product) ses.createCriteria(pojo.Product.class).add(Restrictions.eq("name", productName)).uniqueResult();
            return pro;
        } catch (Exception e) {
        } finally {
            ses.close();
        }
        return null;
    }

    //nash
    Session ses;

    public pojo.Product getByprName(String product) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Product pro = null;
        try {
            pro = (pojo.Product) ses.createCriteria(pojo.Product.class).add(Restrictions.eq("name", product)).uniqueResult();
            return pro;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return null;
    }
    
    pojo.Product product;
    public pojo.Product getByProductName(String productName) {

        ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        
        try {
            product = (pojo.Product) ses.createCriteria(pojo.Product.class).add(Restrictions.eq("name", productName)).uniqueResult();
            return product;
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

    /**
     *
     * @param product
     * @return will rerun a String object, values will be "done", "not", "error"
     */
    public void save(pojo.Product product) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = s.beginTransaction();
            s.save(product);
            er.displayconfirmMessage("Done");
            beginTransaction.commit();
            s.flush();
        } catch (Exception e) {
            er.displayerrorMessage(e.toString());

        } finally {
            s.close();
        }
    }

    /**
     *
     * @param product
     * @return will return a String object, values will be "done", "not",
     * "error"
     */
//shanaka
    public ArrayList<pojo.Product> getAll() {

        ArrayList<pojo.Product> pro = null;
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cr = s.createCriteria(pojo.Product.class);
            pro = (ArrayList<pojo.Product>) cr.list();
        } catch (Exception e) {
        } finally {
            s.close();
        }
        return pro;
    }
//shanaka

    //nash
    public int update(pojo.Product product) {

        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = s.beginTransaction();
            s.update(product);
            beginTransaction.commit();
            s.flush();
            return 1;
        } catch (Exception e) {
            er.displayerrorMessage(e.toString());
            e.printStackTrace();
            return -1;

        } finally {
            s.close();
        }

    }
}
