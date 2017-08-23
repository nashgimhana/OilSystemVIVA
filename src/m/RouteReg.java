/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Me
 */
public class RouteReg {

    //private SessionFactory sessionFactory;
    public RouteReg() {

    }

    public pojo.RouteReg getBy(int id) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.RouteReg reg = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteReg.class);
            Criteria add = createCriteria.add(Restrictions.eq("id", id));
            reg = (pojo.RouteReg) add.uniqueResult();
            System.out.println("unique result for id");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return reg;
    }

    public pojo.RouteReg getByName(String name) {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        pojo.RouteReg name1 = null;
        Session openSession = sessionFactory.openSession();
        try {

            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteReg.class);
            createCriteria.add(Restrictions.eq("name", name));
            name1 = (pojo.RouteReg) createCriteria.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }

        return name1;
    }

    /**
     *
     * @param routeReg
     * @return will return a String object, values as "not", "done", "error"
     */
    public String saveRoute(pojo.RouteReg routeReg, String id) {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        String data = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteReg.class);
            createCriteria.add(Restrictions.eq("id", Integer.parseInt(id)));
            if (createCriteria.uniqueResult() == null) {
                //routeReg.setId(null);
                openSession.save(routeReg);
                beginTransaction.commit();
                System.out.println("No unique result for Route Id, Data saved");
                data = "done";
            } else {
                System.out.println("Unique result for Route Id");
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

    public ArrayList<pojo.RouteReg> viewAllRoute() {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        ArrayList<pojo.RouteReg> routeList = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteReg.class);
            routeList = (ArrayList<pojo.RouteReg>) createCriteria.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return routeList;
    }
    
    public ArrayList<pojo.Vehicle> viewAllVehicle() {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        ArrayList<pojo.Vehicle> vehicles = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.Vehicle.class);
            vehicles = (ArrayList<pojo.Vehicle>) createCriteria.list();
            return vehicles;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return null;
    }
    
    public ArrayList<pojo.Bank> viewAllBank() {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        ArrayList<pojo.Bank> banks = null;
        try {
            //Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.Bank.class);
            banks = (ArrayList<pojo.Bank>) createCriteria.list();
            return banks;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return null;
    }

    /**
     *
     * @param routeReg
     * @return will return a String object, values as "not", "done", "error"
     */
    public String updateRoute(pojo.RouteReg routeReg) {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteReg.class);
            openSession.update(routeReg);
            beginTransaction.commit();
            openSession.flush();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage("Did not update");
        }
        return "not";
    }
    
     public int updateRouteInt(pojo.RouteReg routeReg) {
         int i = 0;
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteReg.class);
            openSession.update(routeReg);
            beginTransaction.commit();
            openSession.flush();
            i=1;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage("Did not update");
        }
        return 1;
    }
    
    public double getTotalCredit(){
        Session session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List list = session.createCriteria(pojo.RouteReg.class).setProjection(Projections.sum("currentCredit")).list();
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
