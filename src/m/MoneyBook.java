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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pojo.DealCategory;

/**
 *
 * @author Me
 */
public class MoneyBook {

    private Session session = null;

    public List<pojo.MoneyBook> getAll() {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.MoneyBook> list = session.createCriteria(pojo.MoneyBook.class).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public pojo.MoneyBook getBy(int id) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.MoneyBook MonyIncome = (pojo.MoneyBook) session.createCriteria(pojo.MoneyBook.class).add(Restrictions.eq("id", id)).uniqueResult();
            return MonyIncome;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.MoneyBook> getAllBy(pojo.DealCategory type) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.MoneyBook> list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.eq("dealCategory", type)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.MoneyBook> getAllBy(pojo.DealType type) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.MoneyBook> list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.eq("dealType", type)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.MoneyBook> getAllBy(Date date) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.MoneyBook> list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.eq("date", date)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.MoneyBook> getAllBy(Date date, pojo.DealType dtype) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.MoneyBook> list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.and(Restrictions.eq("date", date), Restrictions.eq("dealType", dtype))).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.MoneyBook> getAllBy(Date date, pojo.DealCategory dctype) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.MoneyBook> list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.and(Restrictions.eq("date", date), Restrictions.eq("dealCategory", dctype))).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.MoneyBook> getAllBy(Date from, Date to) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.MoneyBook> list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.between("date", from, to)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.MoneyBook> getAllBy(Date from, Date to, pojo.DealType type) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.MoneyBook> list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.and(Restrictions.between("date", from, to), Restrictions.eq("dealType", type))).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.MoneyBook> getAllBy(Date from, Date to, pojo.DealCategory type) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.MoneyBook> list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.and(Restrictions.between("date", from, to), Restrictions.eq("dealCategory", type))).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public double getTotalIncomeBy(Date date) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            DealCategory dc = new m.DealCategory().getBy(1);
            List list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.eq("date", date)).add(Restrictions.eq("dealCategory", dc)).setProjection(Projections.sum("amount")).list();
            if (list != null && !list.isEmpty()) {
                if (list.get(0) != null) {
                    return (double) list.get(0);
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            session.close();
        }
    }
    public double getTotalIncomeBy(Date from, Date to) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            DealCategory dc = new m.DealCategory().getBy(1);
            List list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.between("date", from, to)).add(Restrictions.eq("dealCategory", dc)).setProjection(Projections.sum("amount")).list();
            if (list != null && !list.isEmpty()) {
                if (list.get(0) != null) {
                    return (double) list.get(0);
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            session.close();
        }
    }
    public double getTotalExpendBy(Date date) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            DealCategory dtype = new m.DealCategory().getBy(2);
            List list = session.createCriteria(pojo.MoneyBook.class).add(Restrictions.eq("date", date)).add(Restrictions.eq("dealCategory", dtype)).setProjection(Projections.sum("amount")).list();
            if (list != null && !list.isEmpty()) {
                if (list.get(0) != null) {
                    return (double) list.get(0);
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            session.close();
        }
    }
    public List<pojo.MoneyBook> getLastCashDeals(int count){
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.MoneyBook> list = session.createCriteria(pojo.MoneyBook.class).addOrder(Order.desc("id")).setMaxResults(count).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    /**
     *
     * @param monyIncome
     * @return return a String object, values as "not", "done", "error"
     */
    public String save(pojo.MoneyBook monyIncome) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction bt = session.beginTransaction();
            Serializable save = session.save(monyIncome);
            bt.commit();
            session.flush();
            if (Integer.parseInt(save.toString()) > 0) {
                return "done";
            } else {
                return "not";
            }
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
            return "error";
        } finally {
            session.close();
        }
    }

    public int saveint(pojo.MoneyBook monyIncome) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction bt = session.beginTransaction();
            int save = (Integer) session.save(monyIncome);
            bt.commit();
            session.flush();
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
            return 0;
        } finally {
            session.close();
        }
    }

    /**
     *
     * @param monyIncome
     * @return return a String object, values as "not", "done", "error"
     */
    public String update(pojo.MoneyBook monyIncome) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction bt = session.beginTransaction();
            session.update(monyIncome);
            bt.commit();
            session.flush();
            return "done";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        } finally {
            session.close();
        }
    }
}
