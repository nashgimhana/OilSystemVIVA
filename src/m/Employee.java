/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.Errormzg;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import javax.swing.JButton;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pojo.AttenenceLog;
import pojo.BasicSalery;

import pojo.EmpType;

/**
 *
 * @author Me
 */
public class Employee {

    pojo.Employee employee;

    public void setEmployee(pojo.Employee employee) {
        this.employee = employee;
    }

    public pojo.Employee getEmployee() {
        return employee;
    }

    SessionFactory sessionFactory;

    public Employee() {
        sessionFactory = conn.NewHibernateUtil.getSessionFactory();
    }

    public pojo.Employee getBy(int id) {
        return null;
    }

    public pojo.Employee getBySelectedRow(JTable emp_table) {
        return null;
    }

    public pojo.Employee getByFname(String fname) {
        return null;
    }

   

    public pojo.Employee getByFnameandMname(String fname, String mname) {
        Session ses = sessionFactory.openSession();
        pojo.Employee idd = null;
        try {
            Transaction bt = ses.beginTransaction();
            Criteria cr = ses.createCriteria(pojo.Employee.class);
            cr.add(Restrictions.eq("fname", fname));
            cr.add(Restrictions.eq("mname", mname));
            if (cr.uniqueResult() == null) {
                System.out.println("no Pojo.Employee uniqueResult");

            } else {
                System.out.println(" yes Pojo.Employee  uniqueResult ");
                idd = (pojo.Employee) cr.uniqueResult();
                //System.err.println(idd.getFname());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return idd;
    }

    public long getEmployeeCount() {
        Session ses = sessionFactory.openSession();
        try {
            List list = ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("status", 1)).setProjection(Projections.count("id")).list();
            if (list != null && !list.isEmpty()) {
                if (list.get(0) != null) {
                    return (long) list.get(0);
                } else {
                    return -1;
                }
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            ses.close();
        }
    }

    public pojo.Employee getByMname(String mname) {
        return null;
    }

    public pojo.Employee getByLname(String lname) {
        return null;
    }

    public pojo.Employee getBySname(String sname) {
        return null;
    }

    public pojo.Employee geByNic(String nic) {
        return null;
    }

    public List<pojo.Employee> getBy(pojo.EmpType type) {
        return null;
    }

    /**
     *
     * @param employee
     * @return return a String object, values as "not", "done", "error"
     */
    public static void validateNumber(JTextField tf, java.awt.event.KeyEvent evt) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }

    public static void validateDouble(JTextField tf, java.awt.event.KeyEvent evt) {
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == evt.VK_BACK_SPACE) || (vChar == evt.VK_DELETE) || vChar == evt.VK_PERIOD || vChar == evt.VK_ENTER)) {
            evt.consume();
            java.awt.Toolkit.getDefaultToolkit().beep();
        }
    }

    public String save(JLabel lbl_empid, JComboBox emp_type, JTextField sname, JTextField fname, JTextField mname, JTextField lname, JTextField nic, JComboBox gender, JTextField addressline1, JTextField addressline2, JTextField phonenumber1, JTextField phonenumber2) {

        int id = 0;
        try {
            id = Integer.parseInt(lbl_empid.getText());
        } catch (Exception e) {
            System.out.println("");
        }
        if (!fname.getText().equals("")) {
            if (emp_type.getSelectedIndex() > 0) {
                System.out.println(emp_type.getSelectedIndex());

                Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
                try {
                    pojo.Employee emp = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
                    if (emp == null) {
                        pojo.Employee employee = new pojo.Employee();
                        employee.setSname(sname.getText());
                        employee.setFname(fname.getText());
                        employee.setMname(mname.getText());
                        employee.setLname(lname.getText());
                        employee.setNic(nic.getText());
                        employee.setGender(gender.getSelectedItem().toString());
                        employee.setAdressLine1(addressline1.getText());
                        employee.setAdressLine2(addressline2.getText());
                        employee.setPhone1(phonenumber1.getText());
                        employee.setPhone2(phonenumber2.getText());
                        employee.setStatus(1);
                        employee.setCurrentCredit(0.00);
                        EmpType emptype = (pojo.EmpType) ses.createCriteria(pojo.EmpType.class).add(Restrictions.eq("type", emp_type.getSelectedItem().toString())).uniqueResult();

                        employee.setEmpType(emptype);
                        ses.save(employee);
                        ses.beginTransaction().commit();
                    } else {

                        emp.setSname(sname.getText());
                        emp.setFname(fname.getText());
                        emp.setMname(mname.getText());
                        emp.setLname(lname.getText());
                        emp.setNic(nic.getText());
                        emp.setGender(gender.getSelectedItem().toString());
                        emp.setAdressLine1(addressline1.getText());
                        emp.setAdressLine2(addressline2.getText());
                        emp.setPhone1(phonenumber1.getText());
                        emp.setPhone2(phonenumber2.getText());
                        emp.setStatus(1);
                        EmpType emptype = (pojo.EmpType) ses.createCriteria(pojo.EmpType.class).add(Restrictions.eq("type", emp_type.getSelectedItem().toString())).uniqueResult();
                        emp.setEmpType(emptype);
                        ses.update(emp);
                        ses.beginTransaction().commit();

                    }

                    c.Errormzg.displayconfirmMessage("Employe Saved");
                    lbl_empid.setText("XX");
                    sname.setText("");
                    fname.setText("");
                    mname.setText("");
                    lname.setText("");
                    nic.setText("");
                    gender.setSelectedIndex(1);
                    addressline1.setText("");
                    addressline2.setText("");
                    phonenumber1.setText("");
                    phonenumber2.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    ses.close();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Select Employee Type");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Fill The Content");
        }

        return "Save";
    }

    public void clear(JLabel lbl_empid, JComboBox emp_type, JTextField sname, JTextField fname, JTextField mname, JTextField lname, JTextField nic, JComboBox gender, JTextField addressline1, JTextField addressline2, JTextField phonenumber1, JTextField phonenumber2) {
        lbl_empid.setText("00");
        sname.setText("");
        fname.setText("");
        mname.setText("");
        lname.setText("");
        nic.setText("");
        gender.setSelectedIndex(1);
        addressline1.setText("");
        addressline2.setText("");
        phonenumber1.setText("");
        phonenumber2.setText("");
        emp_type.setSelectedIndex(1);
        gender.setSelectedIndex(1);
    }

    public void loadEmpTable(JTable tbl_emp) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        DefaultTableModel dtm = (DefaultTableModel) tbl_emp.getModel();
        dtm.setRowCount(0);
        tbl_emp.setRowHeight(25);

        try {
            List<pojo.Employee> emp = ses.createCriteria(pojo.Employee.class).add(Restrictions.ne("status", 0)).list();

            for (pojo.Employee employee : emp) {
                Vector v = new Vector();
                v.add(employee.getId().toString());
                v.add(employee.getSname() + " " + employee.getFname() + " " + employee.getMname() + " " + employee.getLname());
                v.add(employee.getNic());
                v.add(employee.getPhone1());
                v.add(employee.getPhone2());
                v.add(employee.getEmpType().getType());

                if (employee.getStatus() == 5) {
                    v.add("Deactive");
                } else {
                    v.add("Active");
                }

                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

    }

    public void loadEmcTable(JTable tbl_emc) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        DefaultTableModel dtm = (DefaultTableModel) tbl_emc.getModel();
        dtm.setRowCount(0);
        EmpType etype = (pojo.EmpType) ses.load(pojo.EmpType.class, 1);

        try {
            List<pojo.Employee> emp = ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("status", 1)).add(Restrictions.eq("empType", etype)).list();

            for (pojo.Employee employee : emp) {
                Vector v = new Vector();
                v.add(employee.getId().toString());
                v.add(employee.getSname() + " " + employee.getFname() + " " + employee.getMname() + " " + employee.getLname());
                v.add(employee.getNic());
                v.add(employee.getCurrentCredit().toString());

                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

    }

    public void loadSalTable(JTable tbl_emp) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        DefaultTableModel dtm = (DefaultTableModel) tbl_emp.getModel();
        dtm.setRowCount(0);
        EmpType etype = (pojo.EmpType) ses.load(pojo.EmpType.class, 1);

        try {
            List<pojo.Employee> emp = ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("status", 1)).add(Restrictions.eq("empType", etype)).list();

            for (pojo.Employee employee : emp) {
                Vector v = new Vector();
                v.add(employee.getId().toString());
                v.add(employee.getSname() + " " + employee.getFname() + " " + employee.getMname() + " " + employee.getLname());
                v.add(employee.getNic());
                v.add(employee.getCurrentCredit().toString());

                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

    }

    public void loadSalTableTemp(JTable tbl_temp) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        DefaultTableModel dtm = (DefaultTableModel) tbl_temp.getModel();
        dtm.setRowCount(0);
        EmpType etype = (pojo.EmpType) ses.load(pojo.EmpType.class, 2);
        try {
            List<pojo.Employee> emp = ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("status", 1)).add(Restrictions.eq("empType", etype)).list();

            for (pojo.Employee employee : emp) {
                Vector v = new Vector();
                v.add(employee.getId().toString());
                v.add(employee.getSname() + " " + employee.getFname() + " " + employee.getMname() + " " + employee.getLname());
                v.add(employee.getNic());
                //   v.add(employee.getCurrentCredit().toString());

                dtm.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

    }

    public void loadForSalery(JTable tbl_salary, JLabel lb_empid, JLabel lb_empfullname, JLabel lb_empnic, JLabel lbl_currentcredit) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        int id = Integer.parseInt(tbl_salary.getValueAt(tbl_salary.getSelectedRow(), 0).toString());
        try {
            pojo.Employee empo = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
            setEmployee(empo);

            lb_empid.setText(empo.getId().toString());
            lb_empfullname.setText(empo.getSname() + " " + empo.getFname() + " " + empo.getMname() + " " + empo.getLname());
            lb_empnic.setText(empo.getNic());
            lbl_currentcredit.setText(empo.getCurrentCredit().toString());
        } catch (Exception e) {
        } finally {
            ses.close();
        }
    }

    public void loadForTempSalery(JTable tbl_temp, JLabel lb_tid, JTable tbl_ap) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        int id = Integer.parseInt(tbl_temp.getValueAt(tbl_temp.getSelectedRow(), 0).toString());
        try {
            pojo.Employee empo = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
            setEmployee(empo);

            lb_tid.setText(empo.getId().toString());
            loadAttendanceAndPay(tbl_temp, tbl_ap);
        } catch (Exception e) {
        } finally {
            ses.close();
        }
    }

    public void loadAttendanceAndPay(JTable tbl_temp, JTable tbl_ap) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        int id = Integer.parseInt(tbl_temp.getValueAt(tbl_temp.getSelectedRow(), 0).toString());

        try {
            pojo.Employee empo = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
            Set<AttenenceLog> attenenceLogs = empo.getAttenenceLogs();
            TreeMap<String, String> hm = new TreeMap<String, String>();
            for (AttenenceLog attenenceLog : attenenceLogs) {
                if (attenenceLog.getStatus().equals("1")) {
                    Date date = attenenceLog.getAttendence().getDate();
                    hm.put(date + "", "Attend");
                }
            }
            Set<BasicSalery> basicSaleries = empo.getBasicSaleries();
            for (BasicSalery basicSalery : basicSaleries) {

                Date date = basicSalery.getUpdateday();

                String get = hm.get(date + "");
                if (get == null) {
                    hm.put(date + "", "Paid :" + basicSalery.getPay());
                } else {
                    hm.put(date + "", get + " - " + "paid  :" + basicSalery.getPay());
                }

            }

            DefaultTableModel dtm = (DefaultTableModel) tbl_ap.getModel();
            dtm.setRowCount(0);

            int i = 0;

            System.out.println(hm.keySet());
            System.out.println(hm.keySet().size());
            int size = hm.keySet().size();

            for (int j = size; j > (size - 32); j--) {
                Vector v = new Vector();
                String lastKey = hm.lastKey();
                v.add(lastKey);
                String remove1 = hm.remove(hm.lastKey());
                v.add(remove1);
                dtm.addRow(v);

            }

        } catch (Exception e) {
        } finally {
            ses.close();
        }

    }

    public void deleteEmploy(JLabel lbl_empid) {
        if (lbl_empid.getText() != "00") {
            int confermcode = JOptionPane.showConfirmDialog(null, "Are You Wont To Delete");
            if (confermcode == 0) {
                String input = JOptionPane.showInputDialog(null, "Enter Password : ");
                if (input.equals("admin")) {
                    Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
                    try {
                        pojo.Employee emp = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", Integer.parseInt(lbl_empid.getText().toString()))).uniqueResult();
                        if (emp.getStatus() == 5) {
                            emp.setStatus(1);
                        } else if (emp.getStatus() == 1) {
                            emp.setStatus(5);
                        }
                        ses.update(emp);
                        ses.beginTransaction().commit();
                    } catch (Exception e) {
                    } finally {
                        ses.close();
                    }
                }

            }
        }

    }

    /**
     *
     * @param employee
     * @return return a String object, values as "not", "done", "error"
     */
    public String update(pojo.Employee employee) {
        return "not";
    }

    public List<pojo.Employee> getStatusBy(int status) {
        return null;
    }

    public void LoadEmployee(JTable tbl_emp, JLabel lb_etype, JLabel lb_eid, JLabel lb_efullname, JLabel lb_enic, JLabel lb_eaddress1, JLabel lb_eaddress2, JLabel lbl_cucredit) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        int id = Integer.parseInt(tbl_emp.getValueAt(tbl_emp.getSelectedRow(), 0).toString());

        try {
            pojo.Employee empo = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
            setEmployee(empo);
            lb_etype.setText(empo.getEmpType().getType());
            lb_eid.setText(empo.getId().toString());
            lb_efullname.setText(empo.getSname() + " " + empo.getFname() + " " + empo.getMname() + " " + empo.getLname());
            lb_enic.setText(empo.getNic());
            lb_eaddress1.setText(empo.getAdressLine1());
            lb_eaddress2.setText(empo.getAdressLine2());
            lbl_cucredit.setText(v.Employee.getRound(empo.getCurrentCredit()));
        } catch (Exception e) {
        } finally {
            ses.close();
        }

    }

    public void loadToUpdateEmp(JLabel lb_id, JComboBox emp_type, JTextField sname, JTextField fname, JTextField mname, JTextField lname, JTextField nic, JComboBox gender, JTextField addressline1, JTextField addressline2, JTextField phonenumber1, JTextField phonenumber2, JLabel lbl_empid, JButton btn_active) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        int id = Integer.parseInt(lb_id.getText());

        try {
            pojo.Employee empo = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
            emp_type.setSelectedItem(empo.getEmpType().getType());
            sname.setText(empo.getSname());
            fname.setText(empo.getFname());
            mname.setText(empo.getMname());
            lname.setText(empo.getLname());
            nic.setText(empo.getNic());
            gender.setSelectedItem(empo.getGender());
            addressline1.setText(empo.getAdressLine1());
            addressline2.setText(empo.getAdressLine2());
            phonenumber1.setText(empo.getPhone1());
            phonenumber2.setText(empo.getPhone2());
            lbl_empid.setText(empo.getId().toString());

            if (empo.getStatus() == 5) {
                btn_active.setText("Active");
            } else if (empo.getStatus() == 1) {
                btn_active.setText("Deactive");
            }

        } catch (Exception e) {

        } finally {
            ses.close();
        }

    }

    public ArrayList<pojo.Employee> viewAllEmployers() {
        Session s = conn.NewHibernateUtil.getSessionFactory().openSession();
        ArrayList<pojo.Employee> emp = null;

        try {
            Criteria createCriteria = s.createCriteria(pojo.Employee.class
            );
            emp = (ArrayList<pojo.Employee>) createCriteria.list();
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        } finally {
            s.close();
        }
        return emp;
    }

}
