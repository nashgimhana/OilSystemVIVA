/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Me
 */
public class Vehicle {

    //private SessionFactory sessionFactory;
    public Vehicle() {

    }

    public int getById(int id) {
        int data = 0;
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.Vehicle.class);
            Criteria add = createCriteria.add(Restrictions.eq("id", id));
            pojo.Vehicle name = (pojo.Vehicle) add.uniqueResult();
            if (add.uniqueResult() == null) {
                data = 1;
            } else {
                data = 2;
            }
        } catch (Exception e) {
        }
        finally{
        openSession.close();
        }

        return data;
    }

    public List<pojo.Vehicle> getByNumOne(String num1) {

        return null;
    }

    public List<pojo.Vehicle> getByNumTwo(String num2) {
        return null;
    }

    /**
     *
     * @param vehicle
     * @return return a String object, values as "not", "done", "error"
     */
    public String save(pojo.Vehicle vehicle, String id) {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        String data = null;
        Session openSession = sessionFactory.openSession();
        try {
            Transaction beginTransaction = openSession.beginTransaction();

            Criteria createCriteria = openSession.createCriteria(pojo.Vehicle.class);
            createCriteria.add(Restrictions.eq("id", Integer.parseInt(id)));
            //pojo.Vehicle vid = (pojo.Vehicle) createCriteria.uniqueResult();
            if (createCriteria.uniqueResult() == null) {
                openSession.save(vehicle);
                beginTransaction.commit();
                openSession.flush();
                data = "done";
                System.out.println("NO Unique Result for Vehicle, Vevicle data save");
            } else {
                System.out.println("Unique Result for Vehicle");
                data = "not";
//            openSession.save(vehicle);
//            beginTransaction.commit();
//            openSession.flush();
            }

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
     * @param vehicle
     * @return return a String object, values as "not", "done", "error"
     */
    public String updateVehicle(pojo.Vehicle vehicle) {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.Vehicle.class);

            System.out.println("update");
            openSession.update(vehicle);
            beginTransaction.commit();
            openSession.flush();

        } catch (Exception e) {
        } finally {
            openSession.close();
        }
        return "done";
    }

    public ArrayList<pojo.Vehicle> viewAllVehicle() {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        ArrayList<pojo.Vehicle> vs = null;
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.Vehicle.class);
            vs = (ArrayList<pojo.Vehicle>) createCriteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return vs;
    }

    public ArrayList<pojo.Vehicle> acRegNumber1() {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        ArrayList<pojo.Vehicle> vs = null;
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.Vehicle.class);
            vs = (ArrayList<pojo.Vehicle>) createCriteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return vs;
    }

    public pojo.Vehicle getByRegnm1(String num1) {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        pojo.Vehicle vehicle = null;
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.Vehicle.class);
            createCriteria.add(Restrictions.eq("number1", num1));
            vehicle = (pojo.Vehicle) createCriteria.uniqueResult();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return vehicle;
    }

    public Integer getId(pojo.Vehicle vehicle) {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        Integer id = null;
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.Vehicle.class);
            createCriteria.add(Restrictions.eq("number1", vehicle.getNumber1()));
            pojo.Vehicle name = (pojo.Vehicle) createCriteria.uniqueResult();
            id = name.getId();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            openSession.close();
        }
        return id;
    }

    public void getByRegnm1(JTextField num1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
