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
public class ProductionLogMix {

    public pojo.ProductionLogBottle getBy(int id) {
        return null;
    }

    public List<pojo.ProductionLogMix> getBy(Date date) {
        return null;
    }

    /**
     *
     * @param productionLogMix
     * @return return a String object, values as "not", "done", "error"
     */
    public int save(pojo.ProductionLogMix productionLogMix) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction beginTransaction = s.beginTransaction();
            int i = (int) s.save(productionLogMix);
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

    /**
     *
     * @param productionLogMix
     * @return return a String object, values as "not", "done", "error"
     */
    public String update(pojo.ProductionLogMix productionLogMix) {
        return "not";
    }

}
