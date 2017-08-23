/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author suhada
 */
public class BankDeals {

    private Session session = null;

    public String save(pojo.BankDeals BankDeals) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        try {
            Serializable save = session.save(BankDeals);
            bt.commit();
            session.flush();
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
            session.close();
        }
    }

    public List<pojo.BankDeals> getByDate(Date date) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.BankDeals> list = session.createCriteria(pojo.BankDeals.class).add(Restrictions.eq("date", date)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<pojo.BankDeals> getByDateRange(Date from, Date to) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.BankDeals> list = session.createCriteria(pojo.BankDeals.class).add(Restrictions.between("date", from, to)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<pojo.BankDeals> getByDateRange(int status) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.BankDeals> list = session.createCriteria(pojo.BankDeals.class).add(Restrictions.eq("status", status)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<pojo.BankDeals> getByCheque(pojo.Cheques Cheques) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.BankDeals> list = session.createCriteria(pojo.BankDeals.class).createAlias("dealCheques", "dc").add(Restrictions.eq("dc.cheques", Cheques)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public pojo.BankDeals getBy(int id) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.BankDeals bankDeals = null;
        try {
            bankDeals = (pojo.BankDeals) ses.createCriteria(pojo.BankDeals.class).add(Restrictions.eq("id", id)).uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
        return bankDeals;
    }

    public int saveint(pojo.BankDeals bankDeals) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = s.beginTransaction();
            int i = (int) s.save(bankDeals);
            System.out.println("Bank Deal Id" + i);
            beginTransaction.commit();
            s.flush();
            return i;
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            return 0;

        } finally {
            s.close();
        }
    }
}
