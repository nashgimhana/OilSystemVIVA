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
import javax.swing.JOptionPane;
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
public class Customer {

    private SessionFactory sessionFactory;

    public Customer() {
        sessionFactory = conn.NewHibernateUtil.getSessionFactory();
    }

    public pojo.Customer getByFname(pojo.Customer customer) {
        Session ses = sessionFactory.openSession();
        pojo.Customer idd = null;
        try {
            Transaction bt = ses.beginTransaction();
            Criteria cr = ses.createCriteria(pojo.Customer.class);
            cr.add(Restrictions.eq("fname", customer.getFname()));
            if (cr.uniqueResult() == null) {
                System.out.println("customer serach wenne ");

            } else {

                idd = (pojo.Customer) cr.uniqueResult();
                System.err.println(idd.getFname());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return idd;
    }

    public pojo.Customer getByNic(String nic) {
        Session ses = sessionFactory.openSession();
        try {
            pojo.Customer cus = (pojo.Customer) ses.createCriteria(pojo.Customer.class).add(Restrictions.eq("nic", nic)).uniqueResult();
            return cus;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ses.close();
        }
    }

    /**
     *
     * @param customer
     * @return return a String object, values as "not", "done", "error"
     */
    public String save(pojo.Customer customer) {
        Session ses = sessionFactory.openSession();
        Transaction bt = ses.beginTransaction();
        try {
            Serializable save = ses.save(customer);
            bt.commit();
            ses.flush();
            if (Integer.parseInt(save.toString()) > 0) {
                return "done";
            } else {
                return "not";
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (bt != null) {
                bt.rollback();
            }
            return "error";
        } finally {
            ses.close();
        }
    }

    /**
     *
     * @param customer
     * @return return a String object, values as "not", "done", "error"
     */
    public String update(pojo.Customer customer) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = ses.beginTransaction();
        try {
            ses.update(customer);
            bt.commit();
            ses.flush();
            return "done";
        } catch (Exception e) {
            e.printStackTrace();
            if (bt != null) {
                bt.rollback();
            }
            return "error";
        } finally {
            ses.close();
        }
    }

    public List<pojo.Customer> getAll() {
        Session ses = sessionFactory.openSession();
        try {
            List<pojo.Customer> list = ses.createCriteria(pojo.Customer.class).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ses.close();
        }
    }

    public pojo.Customer getById(int id) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.Customer Customer = (pojo.Customer) ses.createCriteria(pojo.Customer.class).add(Restrictions.eq("id", id)).uniqueResult();
            return Customer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            ses.close();
        }
    }

    public pojo.Customer getNic(String customerId) {
        Session ses = sessionFactory.openSession();
        pojo.Customer idd = null;
        try {
            Transaction bt = ses.beginTransaction();
            Criteria cr = ses.createCriteria(pojo.Customer.class);
            cr.add(Restrictions.eq("nic", customerId));
            if (cr.uniqueResult() == null) {
                System.out.println("no uni re");

            } else {
                System.out.println("CUSTOMER OBJECT EKA NIC EKEN GATTA YESSS");
                idd = (pojo.Customer) cr.uniqueResult();
                //System.err.println(idd.getFname());
            }

        } catch (Exception e) {
        }

        return idd;
    }

    public pojo.Customer getByFnameS(String customer) {
        Session ses = sessionFactory.openSession();
        pojo.Customer idd = null;
        try {
            Transaction bt = ses.beginTransaction();
            Criteria cr = ses.createCriteria(pojo.Customer.class);
            cr.add(Restrictions.eq("fname", customer));
            if (cr.uniqueResult() == null) {
                System.out.println("no Pojo.customer uniqueResult");

            } else {
                System.out.println(" yes Pojo.customer  uniqueResult ");
                idd = (pojo.Customer) cr.uniqueResult();
                //System.err.println(idd.getFname());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

        return idd;
    }

    public long getCustomerCount() {
        Session ses = sessionFactory.openSession();
        try {
            List list = ses.createCriteria(pojo.Customer.class).setProjection(Projections.count("id")).list();
            if (list != null && !list.isEmpty()) {
                if (list.get(0) != null) {
                    return (long) list.get(0);
                } else {
                    return -1;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            ses.close();
        }
    }

    public int updatecus(pojo.Customer customer) {

        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = s.beginTransaction();
            s.update(customer);

            beginTransaction.commit();
            s.flush();
            return 1;
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            return 0;

        } finally {
            s.close();
        }

    }

    public double getTotalCredit(){
        Session session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List list = session.createCriteria(pojo.Customer.class).setProjection(Projections.sum("credit")).list();
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
