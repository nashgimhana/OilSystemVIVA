/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Me
 */
public class SupplierPay {

    public pojo.SupplierPay getBy(int id) {
        return null;
    }

    public pojo.SupplierPay getBY(pojo.Supplier supplier) {
        return null;
    }

    public pojo.SupplierPay getBy(pojo.MoneyBook moneyExpenditure) {
        return null;
    }

    public List<pojo.SupplierPay> getAll() {
        return null;
    }

    public int saveint(pojo.SupplierPay supplierPay) {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction bt = s.beginTransaction();
            int save = (int) s.save(supplierPay);
            bt.commit();
            s.flush();
            return save;
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
            return 0;
        } finally {
            s.close();
        }
    }

}
