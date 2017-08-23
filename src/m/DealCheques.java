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
 * @author suhada
 */
public class DealCheques {
    private Session session = null;
    
    public String save(pojo.DealCheque DealCheque) {
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        try {
            Serializable save = session.save(DealCheque);
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
    
    public List<pojo.DealCheque> getByBankDeal(pojo.BankDeals BankDeals){
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.DealCheque> list = session.createCriteria(pojo.DealCheque.class).add(Restrictions.eq("bankDeals", BankDeals)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    public List<pojo.DealCheque> getByCheque(pojo.Cheques Cheques){
        session = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.DealCheque> list = session.createCriteria(pojo.DealCheque.class).add(Restrictions.eq("cheques", Cheques)).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}
