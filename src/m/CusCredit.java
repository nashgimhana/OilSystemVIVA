/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pojo.Customer;

/**
 *
 * @author Me
 */
public class CusCredit {

    public pojo.CusCredit getBy(int id) {
        return null;
    }

    public List<pojo.CusCredit> getBy(Date date) {
        return null;
    }

    /**
     *
     * @param cusCredit
     * @return return a String object, values as "not", "done", "error"
     */
    public String save(pojo.CusCredit cusCredit) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction bt = ses.beginTransaction();
            int save = (int) ses.save(cusCredit);
            bt.commit();
            ses.flush();
            if(save>0)return "done";
            else return "not";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        } finally {
            ses.close();
        }
    }

    public List<pojo.CusCredit> getAll() {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        List<pojo.CusCredit> ll = null;
        try {
            ll = ses.createCriteria(pojo.CusCredit.class).list();
        } catch (Exception e) {
        } finally {
            ses.close();
        }
        return ll;
    }

    public pojo.CusCredit getByCus(pojo.CusCredit cusCredit) {
        pojo.CusCredit cusCre = null;

        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            cusCre = (pojo.CusCredit) ses.createCriteria(pojo.CusCredit.class).add(Restrictions.eq("customer", cusCredit.getCustomer())).uniqueResult();

        } catch (Exception e) {
        } finally {
            ses.close();
        }
        return cusCre;

    }

    public List<pojo.CusCredit> getByCredit(pojo.CusCredit cusCredit) {
    Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        List<pojo.CusCredit> ll = null;
        try {
            ll = ses.createCriteria(pojo.CusCredit.class).add(Restrictions.eq("customer", cusCredit.getCustomer())).list();
        } catch (Exception e) {
        } finally {
            ses.close();
        }
        return ll;  
    }

    public double getTotalCredit(){
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            double credit=0,debit=0;
            
            List listc = ses.createCriteria(pojo.CusCredit.class).add(Restrictions.eq("type", 1)).setProjection(Projections.sum("amount")).list();
            if(listc!=null&&!listc.isEmpty()){
                if(listc.get(0)!=null)
                credit=(double)listc.get(0);
                else credit= 0;
            }else{
                credit= 0;
            }
            
            List listd = ses.createCriteria(pojo.CusCredit.class).add(Restrictions.eq("type", 2)).setProjection(Projections.sum("amount")).list();
            if(listd!=null&&!listc.isEmpty()){
                if(listd.get(0)!=null)
                debit=(double)listd.get(0);
                else debit= 0;
            }else{
                debit= 0;
            }
            return (double)(credit-debit);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            ses.close();
        }
    }
   
}
