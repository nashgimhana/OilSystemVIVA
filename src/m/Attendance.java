/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import com.lowagie.text.pdf.PdfName;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JLocaleChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import pojo.AssetLog;
import pojo.Attendence;
import pojo.AttenenceLog;
import pojo.EmpType;

/**
 *
 * @author Me
 */
public class Attendance {

    public pojo.Attendence getByEmployee(pojo.Employee employee) {
        return null;
    }

    public void loadAtendanceTable(JTable tbl_attend, JTable tbl_absent, JLabel today) {

        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        DefaultTableModel dtm_attend = (DefaultTableModel) tbl_attend.getModel();

        dtm_attend.setRowCount(0);
        DefaultTableModel dtm_absent = (DefaultTableModel) tbl_absent.getModel();

        dtm_absent.setRowCount(0);

        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(today.getText());
            List list = ses.createCriteria(pojo.Attendence.class).add(Restrictions.eq("date", date)).list();
            List<pojo.Attendence> ll = list;
            int lastindex = 0;

            // delete duplicate
            if (ll.size() > 1) {
                System.out.println(ll.size());
                lastindex = ll.size() - 1;
                for (int i = 0; i < lastindex; i++) {
                    Attendence get = ll.get(i);
                    Set<pojo.AttenenceLog> attenenceLogs = get.getAttenenceLogs();
                    int size = attenenceLogs.size();

                    for (pojo.AttenenceLog attenenceLog : attenenceLogs) {
                        ses.delete(attenenceLog);
                    }
                    ses.delete(get);
                    ses.beginTransaction().commit();
                }
            }
            // delete duplicate
            pojo.Attendence exsist = null;
            for (Attendence attendence : ll) {
                //  System.out.println(attendence.getDate());
                exsist = attendence;

            }

            EmpType etype = (pojo.EmpType) ses.load(pojo.EmpType.class, 3);
            if (exsist == null) {
                List<pojo.Employee> emp = ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("status", 1)).list();
                for (pojo.Employee employee : emp) {
                    Vector v = new Vector();
                    v.add(employee.getId().toString());
                    v.add(employee.getSname() + " " + employee.getFname() + " " + employee.getMname() + " " + employee.getLname());
                    v.add(employee.getNic());
                    v.add(employee.getEmpType().getType());
                    dtm_attend.addRow(v);
                }
            } else {

                Set<pojo.AttenenceLog> attenenceLogs = exsist.getAttenenceLogs();
                if (attenenceLogs.size() < 1) {
                    List<pojo.Employee> emp = ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("status", 1)).list();
                    for (pojo.Employee employee : emp) {
                        Vector v = new Vector();
                        v.add(employee.getId().toString());
                        v.add(employee.getSname() + " " + employee.getFname() + " " + employee.getMname() + " " + employee.getLname());
                        v.add(employee.getNic());
                        v.add(employee.getEmpType().getType());
                        dtm_attend.addRow(v);
                    }
                }

                for (AttenenceLog attenenceLog : attenenceLogs) {
                    pojo.Employee employee = attenenceLog.getEmployee();
                    Vector v = new Vector();
                    if (attenenceLog.getStatus().equals("1")) {
                        v.add(employee.getId().toString());
                        v.add(employee.getSname() + " " + employee.getFname() + " " + employee.getMname() + " " + employee.getLname());
                        v.add(employee.getNic());
                        v.add(employee.getEmpType().getType());
                        dtm_attend.addRow(v);
                    } else {
                        v.add(employee.getId().toString());
                        v.add(employee.getSname() + " " + employee.getFname() + " " + employee.getMname() + " " + employee.getLname());
                        v.add(employee.getNic());
                        v.add(employee.getEmpType().getType());
                        dtm_absent.addRow(v);
                    }

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

    }

    public void selectAbsent(JTable tbl_attend, JTable tbl_absent) {
        String ss = tbl_attend.getValueAt(tbl_attend.getSelectedRow(), 0).toString();        // System.out.println(ss);
        DefaultTableModel dtm_atend = (DefaultTableModel) tbl_attend.getModel();
        dtm_atend.removeRow(tbl_attend.getSelectedRow());
        DefaultTableModel dtm_absent = (DefaultTableModel) tbl_absent.getModel();
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.Employee emp = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", Integer.parseInt(ss))).uniqueResult();
            Vector v = new Vector();
            v.add(emp.getId().toString());
            v.add(emp.getSname() + " " + emp.getFname() + " " + emp.getMname() + " " + emp.getLname());
            v.add(emp.getNic());
            dtm_absent.addRow(v);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
    }

    public void selectPresent(JTable tbl_absent, JTable tbl_attend) {
        String ss = tbl_absent.getValueAt(tbl_absent.getSelectedRow(), 0).toString();        // System.out.println(ss);
        DefaultTableModel dtm_atend = (DefaultTableModel) tbl_absent.getModel();
        dtm_atend.removeRow(tbl_absent.getSelectedRow());
        DefaultTableModel dtm_attend = (DefaultTableModel) tbl_attend.getModel();
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            pojo.Employee emp = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", Integer.parseInt(ss))).uniqueResult();
            Vector v = new Vector();
            v.add(emp.getId().toString());
            v.add(emp.getSname() + " " + emp.getFname() + " " + emp.getMname() + " " + emp.getLname());
            v.add(emp.getNic());
            dtm_attend.addRow(v);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }
    }

    public void marckAttendance(JTable tbl_attend, JTable tbl_absent, JLabel lable_today, JDateChooser dc_attendance) {

        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();

        try {
            //attendance date eka

            Attendence attendence = new pojo.Attendence();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(lable_today.getText());

            List<pojo.Attendence> ll = ses.createCriteria(pojo.Attendence.class).add(Restrictions.eq("date", date)).list();
            Attendence exsist = null;
            // exsist = (pojo.Attendence) ses.createCriteria(pojo.Attendence.class).add(Restrictions.eq("date", date)).uniqueResult();

            for (Attendence attendence1 : ll) {
                exsist = attendence1;
            }

            if (exsist == null) {
                attendence.setDate(date);
                ses.save(attendence);

                int atend = tbl_attend.getRowCount();
                for (int i = 0; i < atend; i++) {
                    int empid = Integer.parseInt(tbl_attend.getValueAt(i, 0).toString());
                    AttenenceLog attenenceLog = new pojo.AttenenceLog();
                    attenenceLog.setAttendence(attendence);
                    attenenceLog.setEmployee((pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", empid)).uniqueResult());
                    attenenceLog.setStatus("1");
                    ses.save(attenenceLog);
                    ses.beginTransaction().commit();
                }

                int absent = tbl_absent.getRowCount();
                for (int i = 0; i < absent; i++) {
                    int empid = Integer.parseInt(tbl_absent.getValueAt(i, 0).toString());
                    AttenenceLog attenenceLog = new pojo.AttenenceLog();
                    attenenceLog.setAttendence(attendence);
                    attenenceLog.setEmployee((pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", empid)).uniqueResult());
                    attenenceLog.setStatus("0");
                    ses.save(attenenceLog);
                    ses.beginTransaction().commit();
                }

                JOptionPane.showMessageDialog(null, "Attendance Mark Successfull");

            } else {
                int confermcode = JOptionPane.showConfirmDialog(null, "Are You shuwar to update this");
                if (confermcode == 0) {
                    String input = JOptionPane.showInputDialog(null, "Enter Password :");
                    if (input.equals("admin")) { // methenta dana passwordk eka passe data base eken load karala ganna
                        List<pojo.AttenenceLog> list = ses.createCriteria(pojo.AttenenceLog.class).add(Restrictions.eq("attendence", exsist)).list();
                        for (AttenenceLog attenenceLog : list) {
                            ses.delete(attenenceLog);
                        }
                        ses.beginTransaction().commit();
                        //update attendance

                        int atend = tbl_attend.getRowCount();
                        for (int i = 0; i < atend; i++) {
                            int empid = Integer.parseInt(tbl_attend.getValueAt(i, 0).toString());
                            AttenenceLog attenenceLog = new pojo.AttenenceLog();
                            attenenceLog.setAttendence(exsist);
                            attenenceLog.setEmployee((pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", empid)).uniqueResult());
                            attenenceLog.setStatus("1");
                            ses.save(attenenceLog);
                            ses.beginTransaction().commit();
                        }

                        int absent = tbl_absent.getRowCount();
                        for (int i = 0; i < absent; i++) {
                            int empid = Integer.parseInt(tbl_absent.getValueAt(i, 0).toString());
                            AttenenceLog attenenceLog = new pojo.AttenenceLog();
                            attenenceLog.setAttendence(exsist);
                            attenenceLog.setEmployee((pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", empid)).uniqueResult());
                            attenenceLog.setStatus("0");
                            ses.save(attenenceLog);
                            ses.beginTransaction().commit();
                        }
                        JOptionPane.showMessageDialog(null, "Attendance Update Successfull");
                        //update attendance

                    } else {
                        JOptionPane.showMessageDialog(null, "Wrong Password");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No Change");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

    }

    public void getLastAttendanceMarckDate(JLabel lastdate) {

        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();

        try {
            Criteria cry = ses.createCriteria(pojo.Attendence.class);
            cry.addOrder(Order.desc("id"));
            cry.setMaxResults(1);
            Attendence attend = (pojo.Attendence) cry.uniqueResult();
            Date date = attend.getDate();
            lastdate.setText(date.toString());
            // cry.setProjection(prjctn)
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ses.close();
        }

    }

}
