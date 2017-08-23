/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Punnajee
 */
public class Login {

    public void login(String uname, String pass, JFrame frame) {
     
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            Criteria cry = ses.createCriteria(pojo.Login.class);
            cry.add(Restrictions.eq("username", uname));
            cry.add(Restrictions.eq("password", pass));
            pojo.Login log = (pojo.Login) cry.uniqueResult();

            if (log != null) {
                System.out.println("Login Sucsees");
                v.Home.getInstance().setVisible(true);
                frame.dispose();
            } else {
                System.out.println("Try Again");
                JOptionPane.showMessageDialog(frame, "Username or Password is wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

    }
}
