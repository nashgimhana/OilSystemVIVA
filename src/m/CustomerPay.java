/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Me
 */
public class CustomerPay {
    private Session session;
    public String add(pojo.CustomerPay customerPay){
        session=conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        try {
            int save = (int) session.save(customerPay);
            bt.commit();
            session.flush();
            if(save>0)return "done";
            else return "not";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }finally{
            session.close();
        }
    }
}
