/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author suhada
 */
public class Cheques {

    private Session session = null;

    public String save(pojo.Cheques ChequeDetails) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        try {
            Serializable save = session.save(ChequeDetails);
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
    public String update(pojo.Cheques ChequeDetails) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        try {
            session.update(ChequeDetails);
            bt.commit();
            session.flush();
            return "done";
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
    public int saveint(pojo.Cheques ChequeDetails) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        int save;
        try {
            save = (int) session.save(ChequeDetails);
            bt.commit();
            session.flush();

        } catch (Exception e) {
            e.printStackTrace();
            if (bt != null) {
                bt.rollback();
            }
            return 0;
        } finally {
            session.close();
        }
        return save;
    }
    public List<pojo.Cheques> getAll() {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.Cheques> list = session.createCriteria(pojo.Cheques.class).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }

    public List<pojo.Cheques> getByDate(Date date) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.Cheques> list = session.createCriteria(pojo.Cheques.class).add(Restrictions.eq("date", date)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.Cheques> getByDateRange(Date from,Date to) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.Cheques> list = session.createCriteria(pojo.Cheques.class).add(Restrictions.between("date", from,to)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.Cheques> getByChequeDate(Date date) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.Cheques> list = session.createCriteria(pojo.Cheques.class).add(Restrictions.eq("chequeDate", date)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.Cheques> getByChequeDateRange(Date from,Date to) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.Cheques> list = session.createCriteria(pojo.Cheques.class).add(Restrictions.between("chequeDate", from, to)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public pojo.Cheques getBy(int id) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.Cheques ChequeDetails = (pojo.Cheques) session.createCriteria(pojo.Cheques.class).add(Restrictions.eq("id", id)).uniqueResult();
            return ChequeDetails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public pojo.Cheques getByChequeNumber(String number) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.Cheques ChequeDetails = (pojo.Cheques) session.createCriteria(pojo.Cheques.class).add(Restrictions.eq("checkno", number)).uniqueResult();
            return ChequeDetails;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.Cheques> getByChequeNumberLike(String number) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List list = session.createCriteria(pojo.Cheques.class).add(Restrictions.like("checkno", number,MatchMode.ANYWHERE)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.Cheques> getByStatus(int status) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List list = session.createCriteria(pojo.Cheques.class).add(Restrictions.eq("status", status)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
