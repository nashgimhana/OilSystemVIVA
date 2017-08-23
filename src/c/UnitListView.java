/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import m.Supplier;
import m.Units;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author User
 */
public class UnitListView {

    private SessionFactory sessionFactory;

    public UnitListView() {
        sessionFactory = conn.NewHibernateUtil.getSessionFactory();
    }

    public void setTableData(JList<String> jList) {
        try {
            System.out.println("1");

            Units units = new Units();
            ArrayList<pojo.Units> unitslist = units.viewAllUnits();

            DefaultListModel<String> listModel = new DefaultListModel<String>();

            listModel.removeAllElements();
            listModel.addElement("" + "Id" + "          " + "Name");
            for (pojo.Units u : unitslist) {
                listModel.addElement("" + u.getId() + "           " + u.getUnitName());
                jList.setModel(listModel);
            }
        } catch (Exception e) {
        }

    }

    public void setComboData(JComboBox combo_unit) {
//        System.out.println("1");

        Units units = new Units();
        ArrayList<pojo.Units> unitslist = units.viewAllUnits();
        for (pojo.Units un : unitslist) {
            combo_unit.addItem(un.getUnitName());

        }
    }

    public int getIdByName(String name) {
        Session ses = sessionFactory.openSession();
        pojo.Units unit = null;
        try {
            Transaction bt = ses.beginTransaction();
            Criteria cr = ses.createCriteria(pojo.Units.class);
            cr.add(Restrictions.eq("unit_name", name));
            if (cr.uniqueResult() == null) {
                System.out.println("no Pojo.Units uniqueResult");

            } else {
                System.out.println(" yes Pojo.Units  uniqueResult ");
                unit = (pojo.Units) cr.uniqueResult();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return unit.getId();
    }

}
