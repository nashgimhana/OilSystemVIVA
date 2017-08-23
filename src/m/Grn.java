/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Me
 */
public class Grn {

    public pojo.Grn getBy(int id) {

        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Grn grn = null;
        try {
            grn = (pojo.Grn) ses.createCriteria(pojo.Grn.class).add(Restrictions.eq("id", id)).uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ses.close();
        }
        return grn;

    }

    public List<pojo.Grn> getBy(Supplier supplier) {
        return null;
    }

    public ArrayList<pojo.Grn> getBy(Date date) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.Grn> grn = null;
        try {
            Criteria c = ses.createCriteria(pojo.Grn.class);
            c.add(Restrictions.eq("date", date));
            grn = (ArrayList<pojo.Grn>) c.list();
            return grn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ses.close();
        }
    }

    /**
     *
     * @param grn
     * @return will return an String object, values as "done", "not" or "error"
     */
    public int saveGrn(pojo.Grn grn) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        int grnidt = 0;
        try {
            Transaction beginTransaction = s.beginTransaction();
            grnidt = (int) s.save(grn);
//            System.out.println(grnidt + "grn id eka");
//            Errormzg.displayconfirmMessage("done");
            beginTransaction.commit();
            s.flush();
            return grnidt;
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
     * @param grn
     * @return will return an String object, values as "done", "not" or "error"
     */
    public String updateGrn(pojo.Grn grn) {
        return "not";
    }

    public List<pojo.Grn> getAl() {
        return null;
    }

    public pojo.Grn getBy(pojo.Grn grnid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
