/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

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
public class RouteCredit {

    public pojo.RouteCredit getBy(int id) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.RouteCredit name = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteCredit.class);
            createCriteria.add(Restrictions.eq("id", id));
            name = (pojo.RouteCredit) createCriteria.uniqueResult();

        } catch (Exception e) {
        }
        return name;
    }

    public int getById(int id) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        int i = 0;
        pojo.RouteCredit name = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteCredit.class);
            Criteria add = createCriteria.add(Restrictions.eq("id", id));
            //name = (pojo.RouteCredit) createCriteria.uniqueResult();
            if (add.uniqueResult() == null) {
                i = 1;
            } else {
                i = 2;
            }

        } catch (Exception e) {
        }
        return i;
    }

    public List<pojo.RouteCredit> getBy(Date date) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        List<pojo.RouteCredit> name = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteCredit.class);
            createCriteria.add(Restrictions.eq("date", date));
            name = (List<pojo.RouteCredit>) createCriteria.list();
            System.out.println("Got date results");
        } catch (Exception e) {
        }

        return name;
    }

    /**
     *
     * @param routeCredit
     * @return return a String object, values as "not", "done", "error"
     */
    public String save(pojo.RouteCredit routeCredit, String id) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        String data = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteCredit.class);
            createCriteria.add(Restrictions.eq("id", Integer.parseInt(id)));
            if (createCriteria.uniqueResult() == null) {
                System.out.println("NO unique result for RouteCreditSave");
                openSession.save(routeCredit);
                beginTransaction.commit();
                openSession.flush();
                data = "done";
            } else {
                System.out.println("unique result for RouteCreditSave");
                data = "not";
            }

        } catch (Exception e) {
            e.printStackTrace();
            data = "error";
        } finally {
            openSession.close();
        }
        return data;
    }
    public String save1(pojo.RouteCredit routeCredit) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        String data = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteCredit.class);
            //createCriteria.add(Restrictions.eq("id", Integer.parseInt(id)));
            //if (createCriteria.uniqueResult() == null) {
                //System.out.println("NO unique result for RouteCreditSave");
                openSession.save(routeCredit);
                beginTransaction.commit();
                openSession.flush();
                data = "done";
           // } else {
                //System.out.println("unique result for RouteCreditSave");
                //data = "not";
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
     * @param routeCredit
     * @return return a String object, values as "not", "done", "error"
     */
    public String update(pojo.RouteCredit routeCredit) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteCredit.class);
            openSession.update(routeCredit);
            beginTransaction.commit();
            openSession.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return "not";
    }

    public ArrayList<pojo.RouteCredit> viewRouteCreditAllData() {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.RouteCredit> name = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteCredit.class);
            name = (ArrayList<pojo.RouteCredit>) createCriteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return name;
    }
}
