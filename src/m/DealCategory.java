/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Me
 */
public class DealCategory {

    private Session session = null;

    public pojo.DealCategory getBy(int id) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.DealCategory ExpenditureType =null;
        try {
            ExpenditureType = (pojo.DealCategory) session.createCriteria(pojo.DealCategory.class).add(Restrictions.eq("id", id)).uniqueResult();
            return ExpenditureType;
        } catch (Exception e) {
            return ExpenditureType;
        } finally {
            session.close();
        }
    }

    public pojo.DealCategory getByName(String name) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.DealCategory ExpenditureType = (pojo.DealCategory) session.createCriteria(pojo.DealCategory.class).add(Restrictions.eq("category", name)).uniqueResult();
            return ExpenditureType;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    public List<pojo.DealCategory> getAll() {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.DealCategory> list = session.createCriteria(pojo.DealCategory.class).list();
            return list;
        } catch (Exception e) {
            return null;
        } finally {
            session.close();
        }
    }

    public String save(pojo.DealCategory DealCategory) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        try {
            Serializable save = session.save(DealCategory);
            bt.commit();
            session.flush();
            if (Integer.parseInt(save.toString()) > 0) {
                return "done";
            } else {
                return "not";
            }
        } catch (Exception e) {
            if (bt != null) {
                bt.rollback();
            }
            return "error";
        } finally {
            session.close();
        }
    }
}
