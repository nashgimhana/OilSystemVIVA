/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author User
 */
public class AssetStatus {

    public pojo.AssetStatus getById(int assetStatusId) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.AssetStatus as = (pojo.AssetStatus) openSession.createCriteria(pojo.AssetStatus.class).add(Restrictions.eq("id", assetStatusId)).uniqueResult();
            return as;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            openSession.close();
        }
    }

    public pojo.AssetStatus getByName(String name) {
        Session openSession = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.AssetStatus as = (pojo.AssetStatus) openSession.createCriteria(pojo.AssetStatus.class).add(Restrictions.eq("asset", name)).uniqueResult();
            return as;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            openSession.close();
        }
    }

    public String updateAssetStatus(pojo.AssetStatus assetStatus) {
        Session session = conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        try {
            Criteria createCriteria = session.createCriteria(pojo.AssetStatus.class);

            session.update(assetStatus);
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
    /*Atha thiyanna epa mekata, wenas karoth ekama software eka hadaganin*/
    public void updateAssetStatusMe(pojo.AssetStatus assetStatus) {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        try {
            Criteria createCriteria = openSession.createCriteria(pojo.AssetStatus.class);

            openSession.update(assetStatus);
            beginTransaction.commit();
            openSession.flush();
            
        } catch (Exception e) {
            e.printStackTrace();
            
            //return "error";
        } finally {
            openSession.close();
        }
    }
    //bynash
    public int update(pojo.AssetStatus assetStatus) {

        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = s.beginTransaction();
            s.update(assetStatus);

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
}
