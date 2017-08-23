/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.util.List;
import javax.swing.JComboBox;
import org.hibernate.Session;

/**
 *
 * @author Me
 */
public class EmpType {

    public pojo.EmpType getBy(int id) {
        return null;
    }

    public void loadEmpTypeToCombo(JComboBox combo_emptype) {

        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            List<pojo.EmpType> emp = ses.createCriteria(pojo.EmpType.class).list();
            for (pojo.EmpType em : emp) {
                combo_emptype.addItem(em.getType());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

    }
}
