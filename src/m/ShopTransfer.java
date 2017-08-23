/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Me
 */
public class ShopTransfer {

    public pojo.ShopTransfer getBy(int id) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.ShopTransfer name = null;
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.ShopTransfer.class);
            Criteria add = createCriteria.add(Restrictions.eq("id", id));
            name = (pojo.ShopTransfer) add.uniqueResult();
        } catch (Exception e) {
        } finally {
            openSession.close();
        }

        return null;
    }

    public List<pojo.ShopTransfer> getBy(Date date) {
        return null;
    }

    public ArrayList<pojo.ShopTransfer> getShopTransferByDate(Date date) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.ShopTransfer> name = null;
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.ShopTransfer.class);
            Criteria add = createCriteria.add(Restrictions.eq("date", date));
            
            name = (ArrayList<pojo.ShopTransfer>) add.list();
        } catch (Exception e) {
        } finally {
            openSession.close();
        }
        return name;
    }
    
    public int getShopTransferByDateCheck(Date date) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        int i = 0;
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.ShopTransfer.class);
            Criteria add = createCriteria.add(Restrictions.eq("date", date));
            
            if (add.list().isEmpty()) {
                i = 1;
                System.out.println("No unique result for date");
            }else{
                i = 2;
                System.out.println("unique result for date");
            }
        } catch (Exception e) {
        } finally {
            openSession.close();
        }
        return i;
    }

    /**
     *
     * @param shopTransfer
     * @return will return an String object, values as "done", "not" or "error"
     */
    public String save(pojo.ShopTransfer shopTransfer) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();

        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.ShopTransfer.class);
            openSession.save(shopTransfer);
            beginTransaction.commit();
            openSession.flush();
        } catch (Exception e) {
        } finally {
            openSession.close();
        }
        return "not";
    }

    public ArrayList<pojo.ShopTransfer> viewAllShopTransfer() {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.ShopTransfer> name = null;
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.ShopTransfer.class);
            name = (ArrayList<pojo.ShopTransfer>) createCriteria.list();
        } catch (Exception e) {
        } finally {
            openSession.close();
        }
        return name;
    }

}
