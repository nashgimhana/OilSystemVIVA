/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.ShopTransfer;

/**
 *
 * @author User
 */
public class ShopLogView {
    public ArrayList<ShopTransfer> viewDate(JDateChooser from,JDateChooser to){
        ArrayList<ShopTransfer> date = null;
        Session openSession  = null;
        try {
            openSession= conn.NewHibernateUtil.getSessionFactory().openSession();
            Criteria createCriteria = openSession.createCriteria(pojo.ShopTransfer.class);
            //createCriteria.add(Restrictions.gt("date", from.getDate()));
            createCriteria.add(Restrictions.ge("date", from.getDate()));
            createCriteria.add(Restrictions.le("date",to.getDate() ));
            date = (ArrayList<pojo.ShopTransfer>) createCriteria.list();
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
//    public static void main(String[] args) {
//        ArrayList<ShopTransfer> viewDate = new ShopLogView().viewDate();
//        for (ShopTransfer shopTransfer : viewDate) {
//            System.out.println("Date : "+shopTransfer.getDate());
//        }
//    }
}
