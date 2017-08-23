/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.GrnLog;
import pojo.Product;

/**
 *
 * @author shanaka
 */
public class NewClass {

    public static void main(String[] args) {

        String ProName = "mixed";
        double ev = 400;
        Product pro = new NewClass().m(ProName);
        System.out.println("1 sop" + pro.getName());

        ArrayList<GrnLog> glog = new NewClass().getGlog(pro);
        double reqty = 0.0;
        double avlTot = pro.getCurrentStock();
        HashMap<Integer,Double> v = new HashMap<Integer,Double>();
        for (GrnLog gll : glog) {
            v.put(gll.getId(), gll.getRemainingQuantity());
        }
       double kv =00.0;
       for (Integer key : v.keySet()) {
        System.out.println(key + "===" + v.get(key));
        kv = v.get(key);
           if (ev>kv) {
               ev =ev-kv;
               System.out.println("new enter value"+ev);
               System.out.println("key value"+key+"=="+00.0);
           }
           else if (kv>ev) {
               kv=kv-ev;
               System.out.println("new enter value"+00.0);
               System.out.println("new key value"+key+"=="+kv);
               break;
               
           }
    }
        

    }

    private Product m(String ProName) {
        Product proOb = null;
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            proOb = (Product) ses.createCriteria(pojo.Product.class).add(Restrictions.eq("name", ProName)).uniqueResult();

            System.out.println("send Pro Object");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

        return proOb;

    }

    private ArrayList<pojo.GrnLog> getGlog(Product pro) {
        ArrayList<pojo.GrnLog> grnob = null;
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            grnob = (ArrayList<GrnLog>) ses.createCriteria(pojo.GrnLog.class).add(Restrictions.eq("product", pro)).list();
            System.out.println("send GrnLog Object");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

        return grnob;
    }
}
