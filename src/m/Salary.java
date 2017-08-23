/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.CashChequeBookListner;
import com.toedter.calendar.JDateChooser;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Restrictions;
import pojo.Attendence;
import pojo.AttenenceLog;
import pojo.BasicSalery;
import pojo.Employee;
import pojo.MoneyBook;
import report.Psmodle;

/**
 *
 * @author Me
 */
public class Salary {

    pojo.Employee employee;
    String year;
    String month;

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMonth() {
        return month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

//    public void loadForSalary(JTable tbl_salary, JLabel lb_nic1, JLabel lb_nic2, JTextField tf_debit, JLabel lb_emtype, JButton btn_temp) {
//        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
//        int id = Integer.parseInt(tbl_salary.getValueAt(tbl_salary.getSelectedRow(), 0).toString());
//        try {
//            pojo.Employee empo = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
//            setEmployee(empo);
//            lb_nic1.setText(empo.getNic());
//            lb_nic2.setText(empo.getId().toString());
//            tf_debit.setText(v.Employee.getRound(empo.getCurrentCredit()));
//            lb_emtype.setText(empo.getEmpType().getType());
//            if (empo.getEmpType().getId() == 3) {
//                btn_temp.setVisible(true);
//            } else {
//                btn_temp.setVisible(false);
//            }
//
//        } catch (Exception e) {
//        } finally {
//            ses.close();
//        }
//    }
    public pojo.MoneyBook addToMonyBook(Double credit) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.MoneyBook moneyBook = null;
        CashChequeBookListner ch = c.CashChequeBookListner.getInstance();
        try {
            ch.setDealCategory((pojo.DealCategory) ses.load(pojo.DealCategory.class, 2));
            ch.setCashDescrip(" Pay Salary to NIC : " + getEmployee().getNic());
            ch.setCashAmount(credit);
            ch.setCashDealDate(new Date());
            ch.setDealType((pojo.DealType) ses.createCriteria(pojo.DealType.class).add(Restrictions.eq("type", "Employee Salary")).uniqueResult());
            // ch.setCashType((pojo.CashType) ses.load(pojo.CashType.class, 1));
        } catch (Exception e) {
            System.out.println("Monybood add exception");
            e.printStackTrace();
        } finally {
            ses.close();
        }
        moneyBook = ch.addCashDeal();
        return moneyBook;
    }

    public pojo.MoneyBook addToMonyBookTemp(Double credit) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.MoneyBook moneyBook = null;
        CashChequeBookListner ch = c.CashChequeBookListner.getInstance();
        try {
            ch.setDealCategory((pojo.DealCategory) ses.load(pojo.DealCategory.class, 2));
            ch.setCashDescrip("Tempory worker  Pay Salary to NIC : " + getEmployee().getNic());
            ch.setCashAmount(credit);
            ch.setCashDealDate(new Date());
            ch.setDealType((pojo.DealType) ses.createCriteria(pojo.DealType.class).add(Restrictions.eq("type", "Employee Salary")).uniqueResult());
            //ch.setCashType((pojo.CashType) ses.load(pojo.CashType.class, 1));
        } catch (Exception e) {
            System.out.println("Monybood add exception");
            e.printStackTrace();
        } finally {
            ses.close();
        }
        moneyBook = ch.addCashDeal();
        return moneyBook;
    }

    public void loadDetails(JTable tbl_salary, JComboBox jcomb_month, JTextField tf_basic, JTextField tf_bonas, JTextField tf_ot_hours, JTextField tf_ot_rate, JTextField tf_ot_tot, JTextField tf_days, JTextField tf_day_rate, JTextField tf_day_tot, JTextField tf_total, JTextField tf_debit, JTextField tf_pay_tot, JLabel lb_nic2) {

        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        int id = Integer.parseInt(tbl_salary.getValueAt(tbl_salary.getSelectedRow(), 0).toString());
        try {
            pojo.Employee empo = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
            lb_nic2.setText(empo.getId().toString());
            setEmployee(empo);
            Criteria cry = ses.createCriteria(pojo.BasicSalery.class);
            cry.add(Restrictions.eq("employee", empo));
            cry.addOrder(Order.desc("id"));
            cry.setMaxResults(1);
            BasicSalery bc = (pojo.BasicSalery) cry.uniqueResult();
            if (bc != null) {
                tf_debit.setText("00");
                tf_basic.setText(v.Employee.getRound(bc.getBasicSalery()));
                tf_bonas.setText(v.Employee.getRound(bc.getBonus()));
                tf_ot_rate.setText(v.Employee.getRound(bc.getPerOtHoure()));
                tf_day_rate.setText(v.Employee.getRound(bc.getPerDay()));
                tf_debit.setText(v.Employee.getRound(empo.getCurrentCredit()));
            } else {
                tf_basic.setText("00");
                tf_bonas.setText("00");
                tf_ot_rate.setText("00");
                tf_day_rate.setText("00");
                 tf_debit.setText(v.Employee.getRound(empo.getCurrentCredit()));
                
            }

        } catch (Exception e) {
        } finally {
            ses.close();
        }

    }

    public void loadOld(JComboBox jcomb_month, JTable tbl_salary, JLabel lb_date, JLabel lb_basic, JLabel lb_bonus, JLabel lb_ottot, JLabel lb_daytot, JLabel lb_otrage, JLabel lb_othours, JLabel lb_dayrate, JLabel lb_days, JLabel lb_tot, JLabel lb_cutcredit, JLabel lb_totpay) {

        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        int id = Integer.parseInt(tbl_salary.getValueAt(tbl_salary.getSelectedRow(), 0).toString());
        try {
            pojo.Employee empo = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
            setEmployee(empo);
            Criteria cry = ses.createCriteria(pojo.BasicSalery.class);
            cry.add(Restrictions.eq("employee", empo));
            cry.addOrder(Order.desc("id"));
            cry.setMaxResults(1);
            BasicSalery bc = (pojo.BasicSalery) cry.uniqueResult();
            if (bc != null) {

                lb_basic.setText(v.Employee.getRound(bc.getBasicSalery()));
                lb_bonus.setText(v.Employee.getRound(bc.getBonus()));
                lb_ottot.setText(v.Employee.getRound(bc.getHoures() * bc.getPerOtHoure()));
                //month
                Date updateday = bc.getUpdateday();
                SimpleDateFormat smd = new SimpleDateFormat("MM");
                SimpleDateFormat smd2 = new SimpleDateFormat("yyyy-MM-dd");
                String date = smd2.format(updateday);

                String month = smd.format(updateday);
                //month
                lb_date.setText(date);
                lb_daytot.setText(v.Employee.getRound(bc.getPerDay() * getAttendCountByEmpPerMont(month)));
                lb_otrage.setText(v.Employee.getRound(bc.getPerOtHoure()));
                lb_othours.setText(v.Employee.getRound(bc.getHoures()));
                lb_dayrate.setText(v.Employee.getRound(bc.getPerDay()));
                lb_days.setText(getAttendCountByEmpPerMont(month) + "");
                lb_tot.setText(v.Employee.getRound(bc.getTotal()));
                lb_cutcredit.setText(v.Employee.getRound(bc.getMainusDebit()));
                lb_totpay.setText(v.Employee.getRound(bc.getPay()));

            } else {

                lb_basic.setText("00");
                lb_bonus.setText("00");
                lb_ottot.setText("00");
                lb_date.setText("00");
                lb_daytot.setText("00");
                lb_otrage.setText("00");
                lb_othours.setText("00");
                lb_dayrate.setText("00");
                lb_days.setText("00");
                lb_tot.setText("00");
                lb_cutcredit.setText("00");
                lb_totpay.setText("00");
            }

        } catch (Exception e) {
        } finally {
            ses.close();
        }

    }

    public void assertUpdate(Double total) {
        pojo.AssetStatus as = new m.AssetStatus().getById(1);
        as.setAmount(as.getAmount() - total);
        new m.AssetStatus().update(as);
    }
    
    public void paySalary(JComboBox jcomb_month, JLabel tf_nic2, JTextField tf_basic, JTextField tf_bonas, JTextField tf_ot_hours, JTextField tf_ot_rate, JTextField tf_ot_tot, JTextField tf_days, JTextField tf_day_rate, JTextField tf_day_tot, JTextField tf_total, JTextField tf_debit, JTextField tf_pay_tot) {

        String month, year;
        Date in, to;
        pojo.Employee empo = null;
        boolean bb = false;
        Session sess = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {
            month = jcomb_month.getSelectedItem().toString();
            SimpleDateFormat ye = new SimpleDateFormat("yyyy");
            year = ye.format(new Date());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            in = sdf.parse("" + year + "-" + month + "-01");
            to = sdf.parse("" + year + "-" + month + "-31");
            empo = (pojo.Employee) sess.load(pojo.Employee.class, Integer.parseInt(tf_nic2.getText()));

            Criteria cry = sess.createCriteria(pojo.BasicSalery.class);
            cry.add(Restrictions.eq("employee", empo));
            cry.add(Restrictions.between("updateday", in, to));
            List list = cry.list();
            int size = list.size();

            //  System.out.println("List Size is==========  " + size);
            if (size == 0) {
                bb = true;
            } else {
                bb = false;
                JOptionPane.showMessageDialog(null, "Allrady Payed for this month");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sess.close();
        }

        if (bb) {

            double basic = Double.parseDouble(tf_basic.getText());
            double bonas = Double.parseDouble(tf_bonas.getText());
            double day_rate = Double.parseDouble(tf_day_rate.getText());
            double ot_rate = Double.parseDouble(tf_ot_rate.getText());
            double ot_hours = Double.parseDouble(tf_ot_hours.getText());
            double debit = Double.parseDouble(tf_debit.getText());
            double total = Double.parseDouble(tf_total.getText());
            double pay = Double.parseDouble(tf_pay_tot.getText());
            MoneyBook monyBook = addToMonyBook(v.Employee.getRoundDouble(pay));
            assertUpdate(v.Employee.getRoundDouble(pay));

            Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();

            try {

                pojo.BasicSalery bs = new pojo.BasicSalery();
                Employee employee1 = getEmployee();
                bs.setEmployee(employee1);
                bs.setBasicSalery(v.Employee.getRoundDouble(basic));
                bs.setBonus(v.Employee.getRoundDouble(bonas));
                bs.setPerDay(v.Employee.getRoundDouble(day_rate));
                bs.setPerOtHoure(v.Employee.getRoundDouble(ot_rate));
                bs.setHoures(v.Employee.getRoundDouble(ot_hours));
                bs.setMainusDebit(v.Employee.getRoundDouble(debit));
                bs.setTotal(v.Employee.getRoundDouble(total));
                bs.setPay(v.Employee.getRoundDouble(pay));
                bs.setUpdateday(new Date());// meken currnet date eka yanawa one unoth wenas karamu        
                //  String date = sdf.format(new Date());
                bs.setStatus(1);
                double curentcredit = employee1.getCurrentCredit() - debit;
                employee1.setCurrentCredit(v.Employee.getRoundDouble(curentcredit));
                ses.update(employee1);
                ses.save(bs);
                pojo.Salary sal = new pojo.Salary();
                sal.setBasicSalery(bs);
                sal.setMoneyBook(monyBook);
                sal.setTot(v.Employee.getRoundDouble(pay));
                sal.setEmployee(employee1);
                ses.save(sal);
                ses.beginTransaction().commit();

                new report.Psmodle().report(employee1.getId(), bs.getId());

                clear(tf_nic2, tf_basic, tf_bonas, tf_ot_hours, tf_ot_rate, tf_ot_tot, tf_days, tf_day_rate, tf_day_tot, tf_total, tf_debit, tf_pay_tot);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ses.close();
            }
        }
    }

    public void genarateTempDate(JLabel lb_tid, JDateChooser dc_tmp_date, JTextField tf_temp_days, JTextField tf_temp_rate, JTextField tf_temp_tot) {

        System.out.println("Method call");
        int impid = Integer.parseInt(lb_tid.getText());
        System.out.println(impid);
        Date date = dc_tmp_date.getDate();
        System.out.println(date);

        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        try {

            pojo.Employee em = (pojo.Employee) ses.load(pojo.Employee.class, impid);

            Stack<AttenenceLog> attenenceLogs = (Stack<AttenenceLog>) em.getAttenenceLogs();
            AttenenceLog peek = attenenceLogs.peek();
            Date date1 = peek.getAttendence().getDate();

            System.out.println(date1);

            Criteria cry = ses.createCriteria(pojo.AttenenceLog.class).add(Restrictions.eq("employee", em));

        } catch (Exception e) {
        } finally {
            ses.close();
        }

    }

    public void temPay(JLabel lb_tid, JDateChooser dc_tmp_date, JTextField tf_temp_tot) {

        try {
            int eid = Integer.parseInt(lb_tid.getText());
            Date date = dc_tmp_date.getDate();
            double pay = Double.parseDouble(tf_temp_tot.getText());

            if (date == null) {
                JOptionPane.showMessageDialog(null, "Select Date");

            } else {
                Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
                try {
                    Employee emp = (pojo.Employee) ses.load(pojo.Employee.class, eid);
                    setEmployee(emp);
                    BasicSalery bs = new pojo.BasicSalery();
                    pojo.Salary salary = new pojo.Salary();

                    bs.setBasicSalery(0.0);
                    bs.setBonus(0.0);
                    bs.setEmployee(emp);
                    bs.setHoures(0.0);
                    bs.setMainusDebit(0.0);
                    bs.setPay(v.Employee.getRoundDouble(pay));
                    bs.setPerDay(0.0);
                    bs.setPerOtHoure(0.0);
                    bs.setStatus(1);
                    bs.setTotal(v.Employee.getRoundDouble(pay));
                    bs.setUpdateday(date);
                    ses.save(bs);
                    MoneyBook addToMonyBookTemp = addToMonyBookTemp(v.Employee.getRoundDouble(pay));
                    salary.setBasicSalery(bs);
                    salary.setEmployee(emp);
                    salary.setMoneyBook(addToMonyBookTemp);
                    salary.setTot(v.Employee.getRoundDouble(pay));
                    ses.beginTransaction().commit();
                    assertUpdate(v.Employee.getRoundDouble(pay));
                } catch (Exception e) {
                } finally {
                    ses.close();
                }
                tf_temp_tot.setText("");

            }
        } catch (Exception e) {
           // e.printStackTrace();
        }

    }

    public void clear(JLabel tf_nic2, JTextField tf_basic, JTextField tf_bonas, JTextField tf_ot_hours, JTextField tf_ot_rate, JTextField tf_ot_tot, JTextField tf_days, JTextField tf_day_rate, JTextField tf_day_tot, JTextField tf_total, JTextField tf_debit, JTextField tf_pay_tot) {

        tf_basic.setText("");
        tf_bonas.setText("");
        tf_ot_hours.setText("");
        tf_ot_rate.setText("");
        tf_ot_tot.setText("");
        tf_days.setText("");
        tf_day_rate.setText("");
        tf_day_tot.setText("");
        tf_total.setText("");
        tf_debit.setText("");
        tf_pay_tot.setText("");
        tf_nic2.setText("00");

    }

    double attendcount;

    public void setAttendcount(double attendcount) {
        this.attendcount = attendcount;
    }

    public double getAttendcount() {
        return attendcount;
    }

    public int getAttendCountByEmpPerMont(JComboBox jcomb_month) {
        int atcount = 0;
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        String month = jcomb_month.getSelectedItem().toString();
        setMonth(month);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat ye = new SimpleDateFormat("yyyy");
        String year = ye.format(new Date());
        setYear(year);
        try {
            Date in = sdf.parse("" + getYear() + "-" + getMonth() + "-01");
            Date to = sdf.parse("" + getYear() + "-" + getMonth() + "-31");

            List<pojo.Attendence> list = ses.createCriteria(pojo.Attendence.class).add(Restrictions.between("date", in, to)).list();
            for (Attendence attendence : list) {
                List<pojo.AttenenceLog> al = ses.createCriteria(pojo.AttenenceLog.class).add(Restrictions.and(Restrictions.eq("attendence", attendence), Restrictions.eq("employee", getEmployee()), Restrictions.eq("status", "1"))).list();
                for (AttenenceLog attenenceLog : al) {
                    atcount++;
                }
            }
            //  System.out.println(atcount);
        } catch (Exception e) {
            System.out.println("DateFormat error");
            e.printStackTrace();
        } finally {
            ses.close();
        }
        setAttendcount(Double.parseDouble(atcount + ""));
        return atcount;
    }

    public int getAttendCountByEmpPerMont(String mon) {
        int atcount = 0;
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        String month = mon;
        setMonth(month);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat ye = new SimpleDateFormat("yyyy");
        String year = ye.format(new Date());
        setYear(year);
        try {
            Date in = sdf.parse("" + getYear() + "-" + getMonth() + "-01");
            Date to = sdf.parse("" + getYear() + "-" + getMonth() + "-31");

            List<pojo.Attendence> list = ses.createCriteria(pojo.Attendence.class).add(Restrictions.between("date", in, to)).list();
            for (Attendence attendence : list) {
                List<pojo.AttenenceLog> al = ses.createCriteria(pojo.AttenenceLog.class).add(Restrictions.and(Restrictions.eq("attendence", attendence), Restrictions.eq("employee", getEmployee()), Restrictions.eq("status", "1"))).list();
                for (AttenenceLog attenenceLog : al) {
                    atcount++;
                }
            }
            //  System.out.println(atcount);
        } catch (Exception e) {
            System.out.println("DateFormat error");
            e.printStackTrace();
        } finally {
            ses.close();
        }
        return atcount;
    }

    public void loadAttend(JComboBox jcomb_month, JTextField tf_days) {
        int attendcount = getAttendCountByEmpPerMont(jcomb_month);
        tf_days.setText(attendcount + "");
    }

    public void cheackRate(JComboBox jcomb_month, JTextField tf_basic, JTextField tf_bonas, JTextField tf_ot_hours, JTextField tf_ot_rate, JTextField tf_ot_tot, JTextField tf_days, JTextField tf_day_rate, JTextField tf_day_tot, JTextField tf_total, JTextField tf_debit, JTextField tf_pay_tot) {
        int attendcount = getAttendCountByEmpPerMont(jcomb_month);
        tf_days.setText(attendcount + "");

        double basic = Double.parseDouble(tf_basic.getText());
        double bonas = Double.parseDouble(tf_bonas.getText());
        double day_rate = Double.parseDouble(tf_day_rate.getText());
        double ot_rate = Double.parseDouble(tf_ot_rate.getText());
        double ot_hours = Double.parseDouble(tf_ot_hours.getText());
        double debit = Double.parseDouble(tf_debit.getText());

        //double pay = Double.parseDouble(tf_pay_tot.getText());
        double ot_tot = ot_hours * ot_rate;
        tf_ot_tot.setText(v.Employee.getRound(ot_tot));

        double daytot = attendcount * day_rate;
        tf_day_tot.setText(v.Employee.getRound(daytot));

        double tot = basic + bonas + daytot + ot_tot;
        tf_total.setText(v.Employee.getRound(tot));
        // double total = Double.parseDouble(tf_total.getText());

        double payall = tot - debit;
        tf_pay_tot.setText(v.Employee.getRound(payall));

    }

}
