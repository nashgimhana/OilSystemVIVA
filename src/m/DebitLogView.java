/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author User
 */
public class DebitLogView {
    public ArrayList<pojo.RouteDebit> viewDate(JDateChooser from,JDateChooser to){
        ArrayList<pojo.RouteDebit> date = null;
        Session openSession  = null;
        try {
            openSession= conn.NewHibernateUtil.getSessionFactory().openSession();
            Criteria createCriteria = openSession.createCriteria(pojo.RouteDebit.class);
            //createCriteria.add(Restrictions.gt("date", from.getDate()));
            createCriteria.add(Restrictions.ge("date", from.getDate()));
            createCriteria.add(Restrictions.le("date",to.getDate() ));
            date = (ArrayList<pojo.RouteDebit>) createCriteria.list();
//            for (ShopTransfer shopTransfer : date) {
//                            System.out.println("Something :"+shopTransfer.getDate().toString());
//
//            }
                    
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
        openSession.close();
        }
        return date;
    }
}
