/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Product;

/**
 *
 * @author Me
 */
public class Units {

    Errormzg er = new Errormzg();
   

    public pojo.Units getBy(int id) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Units uni=null;
        try {
            Criteria cr=s.createCriteria(pojo.Units.class);
            cr.add(Restrictions.eq("id", id));
            uni= (pojo.Units) cr.uniqueResult();
        } catch (Exception e) {
        }
        return uni;
    }

    public pojo.Units getByName(String uniName) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Units uni=null;
        try {
            Criteria cr=s.createCriteria(pojo.Units.class);
            cr.add(Restrictions.eq("unitName", uniName));
            uni= (pojo.Units) cr.uniqueResult();
        } catch (Exception e) {
        }
        return uni;
    }
    
    public int getByName01(String uniName) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.Units uni=null;
        try {
            Criteria cr=s.createCriteria(pojo.Units.class);
            cr.add(Restrictions.eq("unitName", uniName));
            uni= (pojo.Units) cr.uniqueResult();
        } catch (Exception e) {
        }
        return uni.getId();
    }


    /**
     *
     * @param units
     * @return will return an String object, values as "done", "not" or "error"
     */
    public void save(pojo.Units units) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = s.beginTransaction();
            s.save(units);
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
     * @param units
     * @return will return an String object, values as "done", "not" or "error"
     */
    public String update(pojo.Units units) {
        return "not";
    }

    public ArrayList<pojo.Units> viewAllUnits() {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.Units> un = null;
        try {
            Criteria createCriteria = s.createCriteria(pojo.Units.class);
            un = (ArrayList<pojo.Units>) createCriteria.list();
        } catch (Exception e) {
            er.displayerrorMessage(e.toString());
        } finally {
            s.close();
        }
        return un;
    }

//    public List<pojo.Units> {
//        List<pojo.Units> uni=null;
//        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
//        try {
//            Criteria creCriteria=s.createCriteria(pojo.Units.class);
//            uni=(List<pojo.Units>) creCriteria.list();
////            List<pojo.Units> uni = s.createCriteria(pojo.Units.class).list();
////            for (pojo.EmpType em : emp) {
////                combo_emptype.addItem(em.getType());
////            }
//
//        } catch (Exception e) {
//            er.displayerrorMessage(e.toString());
//        } finally {
//            s.close();
//        }
//        return uni;
//
//    }

}
