/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Me
 */
public class ProductionLogBottle {

    public pojo.ProductionLogBottle getBy(int id) {
        return null;
    }

    public List<pojo.ProductionLogBottle> getBy(Date date) {
        return null;
    }

    public int save(pojo.ProductionLogBottle productionLogBottle) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = s.beginTransaction();
            int i = (int) s.save(productionLogBottle);
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

    public String update(pojo.ProductionLogBottle productionLogBottle) {
        return "not";
    }
}
