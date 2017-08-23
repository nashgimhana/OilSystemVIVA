/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author shanaka
 */
public class InvoicePay {

    public void save(pojo.InvoicePay invoicePay) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Serializable save = ses.save(invoicePay);
            ses.beginTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

    }

}
