/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oil.company;

import org.hibernate.Session;
import v.Splash;
import v.Home;

/**
 *
 * @author User
 */
public class OilCompany extends Thread{
    Splash splash;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new OilCompany().startOil();
    }
    public void startOil(){
        splash = new v.Splash();
        splash.setVisible(true);
        this.start();
    }
    @Override
    public void run() {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            
            ses.beginTransaction().commit();
            v.Home.getInstance().setVisible(true);
            splash.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
    }
    
}
