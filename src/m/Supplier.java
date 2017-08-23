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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import v.SupplierView;

/**
 *
 * @author Me
 */
public class Supplier {

    Errormzg er = new Errormzg();

    public pojo.Supplier getBy(int id) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Supplier supl = null;
        try {
            supl = (pojo.Supplier) ses.createCriteria(pojo.Supplier.class).add(Restrictions.eq("id", id)).uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
        return supl;
    }

    public pojo.Supplier getByName(String name) {

        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Supplier supl = null;

        try {
            supl = (pojo.Supplier) ses.createCriteria(pojo.Supplier.class
            ).add(Restrictions.eq("name", name)).uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
        return supl;
    }

    public List<pojo.Supplier> getByStatus(int id) {
        return null;
    }

    /**
     *
     * @param supplier
     * @return will return String object values will be "done", "not" or "error"
     */
    public int save(pojo.Supplier supplier) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = s.beginTransaction();
            int i = (int) s.save(supplier);
            beginTransaction.commit();
            s.flush();
            return i;
        } catch (Exception e) {
            er.displayerrorMessage(e.toString());
            return 0;

        } finally {
            s.close();
        }
    }

    /**
     *
     * @param supplier
     * @return will return String object value will be "done", "not" or "error";
     */
    public int update(pojo.Supplier supplier) {

        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = s.beginTransaction();
            s.update(supplier);

            beginTransaction.commit();
            s.flush();
            return 1;
        } catch (Exception e) {
            er.displayerrorMessage(e.toString());
            return 0;

        } finally {
            s.close();
        }

    }

    public ArrayList<pojo.Supplier> viewAllSuppliers() {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.Supplier> sup = null;

        try {
            Criteria createCriteria = s.createCriteria(pojo.Supplier.class
            );
            sup = (ArrayList<pojo.Supplier>) createCriteria.list();
        } catch (Exception e) {
            er.displayerrorMessage(e.toString());
        } finally {
            s.close();
        }
        return sup;
    }
    
    public double getTotalCredit(){
        Session session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List list = session.createCriteria(pojo.Supplier.class).add(Restrictions.eq("status", 1)).add(Restrictions.ne("id", 1)).setProjection(Projections.sum("currentCredit")).list();
            if(list!=null&&!list.isEmpty()){
                if(list.get(0)!=null)return (double)list.get(0);
                else return 0;
            }else return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            session.close();
        }
    }
}
