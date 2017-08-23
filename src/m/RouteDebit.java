/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import com.toedter.calendar.JDateChooser;
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
public class RouteDebit {

    public pojo.RouteDebit getBy(int id) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.RouteDebit name = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteDebit.class);
            createCriteria.add(Restrictions.eq("id", id));
            name = (pojo.RouteDebit) createCriteria.uniqueResult();

        } catch (Exception e) {
        }
        return name;
    }
    
    public int getById(int id) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        int i = 0 ;
        pojo.RouteDebit name = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteDebit.class);
            Criteria add = createCriteria.add(Restrictions.eq("id", id));
            //name = (pojo.RouteDebit) createCriteria.uniqueResult();
            if (add.uniqueResult() == null) {
                i = 1;
            } else {
                i = 2;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    public List<pojo.RouteDebit> getBy(Date date) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        List<pojo.RouteDebit> name = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteDebit.class);
            createCriteria.add(Restrictions.eq("date", date));
            name = (List<pojo.RouteDebit>) createCriteria.list();
            System.out.println("Got date results");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return name;
    }

    /**
     *
     * @param routeDebit
     * @return return a String object, values as "not", "done", "error"
     */
    public String save(pojo.RouteDebit routeDebit) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        String data = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteDebit.class);
            //createCriteria.add(Restrictions.eq("id", Integer.parseInt(id)));
            //if (createCriteria.uniqueResult() == null) {
                System.out.println("NO unique result for RouteCreditSave");
                openSession.save(routeDebit);
                beginTransaction.commit();
                openSession.flush();
                data = "done";
            //} else {
               // System.out.println("unique result for RouteCreditSave");
               // data = "not";
            //}

        } catch (Exception e) {
            e.printStackTrace();
            data = "error";
        } finally {
            openSession.close();
        }
        return data;
    }

    /**
     *
     * @param routeDebit
     * @return return a String object, values as "not", "done", "error"
     */
    public String update(pojo.RouteDebit routeDebit) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteDebit.class);
            openSession.update(routeDebit);
            beginTransaction.commit();
            openSession.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return "not";
    }

    public ArrayList<pojo.RouteDebit> viewRouteDebitAllData() {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.RouteDebit> name = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteDebit.class);
            //createCriteria.add(Restrictions.eq("date", chooser.getDate()));
            name = (ArrayList<pojo.RouteDebit>) createCriteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return name;
    }
    
     public ArrayList<pojo.RouteDebit> viewRouteDebitAllData1(JDateChooser chooser) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.RouteDebit> name = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteDebit.class);
            createCriteria.add(Restrictions.eq("date", chooser.getDate()));
            name = (ArrayList<pojo.RouteDebit>) createCriteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return name;
    }
}
