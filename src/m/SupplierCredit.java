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
 * @author User
 */
public class SupplierCredit {
    
    public pojo.SupplierCredit getBy(int id) {
        return null;
    }
    
    public List<pojo.SupplierCredit> getBy(Date date) {
        return null;
    }
    
    public int save(pojo.SupplierCredit supplierCredit) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        Integer save = 0;
        try {
            Transaction bt = ses.beginTransaction();
            save = (Integer) ses.save(supplierCredit);
            bt.commit();
            ses.flush();
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            ses.close();
        }
        return save;
    }
}
