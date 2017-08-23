/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.ShopTransferLog;

/**
 *
 * @author Me
 */
public class ShopTrasnferLog {

    public pojo.ShopTransferLog getBy(int id) {
        pojo.ShopTransferLog log = null;
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.ShopTransferLog.class);
            Criteria add = createCriteria.add(Restrictions.eq("id", id));
            log = (ShopTransferLog) add.uniqueResult();
        } catch (Exception e) {
        } finally {
            openSession.close();
        }
        return log;
    }

    public ShopTransferLog getBy(pojo.ShopTransfer shopTransfer) {
        pojo.ShopTransferLog log = null;
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.ShopTransferLog.class);
            Criteria add = createCriteria.add(Restrictions.eq("shopTransfer", shopTransfer));
            log = (ShopTransferLog) add.uniqueResult();
        } catch (Exception e) {
        } finally {
            openSession.close();
        }
        return log;
    }

    /**
     *
     * @param shopTransfer
     * @return will return an String object, values as "done", "not" or "error"
     */
    public String save(pojo.ShopTransferLog shopTransfer) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();

        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.ShopTransferLog.class);
            openSession.save(shopTransfer);
            beginTransaction.commit();
            openSession.flush();
        } catch (Exception e) {
        } finally {
            openSession.close();
        }
        return "not";

    }

    /**
     *
     * @param shopTransfer
     * @return will return an String object, values as "done", "not" or "error"
     */
    public String update(pojo.ShopTransferLog shopTransfer) {
        return "not";
    }

}
