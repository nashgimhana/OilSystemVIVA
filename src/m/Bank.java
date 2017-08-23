/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.io.Serializable;
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
public class Bank {
    private Session session=null;
    public pojo.Bank getBy(int id) {
        session=conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.Bank Bank=(pojo.Bank) session.createCriteria(pojo.Bank.class).add(Restrictions.eq("id", id)).uniqueResult();
            return Bank;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }

    public pojo.Bank getBy(String name) {
        session=conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.Bank Bank=(pojo.Bank) session.createCriteria(pojo.Bank.class).add(Restrictions.eq("bank", name)).uniqueResult();
            return Bank;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }

    public List<pojo.Bank> getAll() {
        session=conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.Bank> list = session.createCriteria(pojo.Bank.class).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }
    
    public String save(pojo.Bank Bank) {
        session=conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        try {
            Serializable save = session.save(Bank);
            bt.commit();
            session.flush();
            if(Integer.parseInt(save.toString())>0){
            return "done";
            }else return "not";
        } catch (Exception e) {
            e.printStackTrace();
            if(bt!=null)bt.rollback();
            return "error";
        }finally{
            session.close();
        }
    }
    public String saveOrUpdate(pojo.Bank Bank) {
        session=conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        try {
            session.saveOrUpdate(Bank);
            bt.commit();
            session.flush();
            return "done";
        } catch (Exception e) {
            e.printStackTrace();
            if(bt!=null)bt.rollback();
            return "error";
        }finally{
            session.close();
        }
    }
    
    public double getTotal(){
        Session session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List list = session.createCriteria(pojo.Bank.class).setProjection(Projections.sum("amount")).list();
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
    
    public String updateBank(pojo.Bank bank) {
        Session session = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction beginTransaction = session.beginTransaction();
        try {
            session.update(bank);
            beginTransaction.commit();
            session.flush();
            return "done";
        } catch (Exception e) {
            e.printStackTrace();
            if(beginTransaction!=null)beginTransaction.rollback();
            return "error";
        } finally {
            session.close();
        }
    }
}
