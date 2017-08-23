/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author suhada
 */
public class Lost {
    
    public String add(pojo.Lost Lost){
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Transaction bt = ses.beginTransaction();
            Serializable save = ses.save(Lost);
            bt.commit();
            ses.flush();
            if(Integer.parseInt(save.toString())>0)return "done";
            else return "not";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        } finally {
            ses.close();
        }
    }
    
    public List<pojo.Lost> getAll(){
        Session session=conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            return session.createCriteria(pojo.Lost.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally{
            session.close();
        }
    }
}
