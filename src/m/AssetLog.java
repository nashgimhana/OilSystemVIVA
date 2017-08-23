/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author User
 */
public class AssetLog {
    public String saveAssetLog(pojo.AssetLog assetLog) {
        SessionFactory sessionFactory = conn.NewHibernateUtil.getSessionFactory();
        Session openSession = sessionFactory.openSession();
        try {
            Transaction beginTransaction = openSession.beginTransaction();
            Criteria createCriteria = openSession.createCriteria(pojo.AssetLog.class);

            System.out.println("save");
            openSession.save(assetLog);
            beginTransaction.commit();
            openSession.flush();

        } catch (Exception e) {
        } finally {
            openSession.close();
        }
        return "done";
    }
}
