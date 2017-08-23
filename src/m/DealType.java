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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Me
 */
public class DealType {

    private Session session=null;
    
    public pojo.DealType getBy(int id) {
        session=conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.DealType IncomeType = (pojo.DealType) session.createCriteria(pojo.DealType.class).add(Restrictions.eq("id", id)).uniqueResult();
            return IncomeType;
        } catch (Exception e) {
            return null;
        }finally{
            session.close();
        }
    }
    
    public pojo.DealType getByName(String name) {
        session=conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.DealType IncomeType = (pojo.DealType) session.createCriteria(pojo.DealType.class).add(Restrictions.eq("type", name)).uniqueResult();
            return IncomeType;
        } catch (Exception e) {
            return null;
        }finally{
            session.close();
        }
    }

    public List<pojo.DealType> getAll() {
        session=conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.DealType>  list = session.createCriteria(pojo.DealType.class).list();
            return list;
        } catch (Exception e) {
            return null;
        }finally{
            session.close();
        }
    }
    
    public String save(pojo.DealType DealType) {
        session=conn.NewHibernateUtil.getSessionFactory().openSession();
        Transaction bt = session.beginTransaction();
        try {
            Serializable save = session.save(DealType);
            bt.commit();
            session.flush();
            if(Integer.parseInt(save.toString())>0){
                return "done";
            }else return "not";
        } catch (Exception e) {
            if(bt!=null)bt.rollback();
            return "error";
        }finally{
            session.close();
        }
    }
}
