/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import c.CashChequeBookListner;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import pojo.MoneyBook;

/**
 *
 * @author Me
 */
public class EmpCredit {

    pojo.Employee employee;

    public void setEmployee(pojo.Employee employee) {
        this.employee = employee;
    }

    public pojo.Employee getEmployee() {
        return employee;
    }

    public pojo.EmpCredit getBy(int id) {
        return null;
    }

    public List<pojo.EmpCredit> getBy(pojo.Employee employee) {
        return null;
    }

    /**
     *
     * @param empCredit
     * @return return a String object, values as "not", "done", "error"
     */
    public String save(pojo.EmpCredit empCredit) {
        return "not";
    }

    public void payCredit() {
//        CashChequeBookListner ch = c.CashChequeBookListner.getInstance();
//        ch.setDealCategory(dealCategory);
//        ch.setCashDescrip("bla bla");
//        ch.setCashAmount(amount);
//        ch.setCashDealDate(date);
//        ch.setDealType(dealType);
//        ch.setCashType(cashType);
//        pojo.MoneyBook moneyBook = ch.addCashDeal();
    }

    public pojo.MoneyBook addToMonyBook(Double credit) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        pojo.MoneyBook moneyBook = null;
        CashChequeBookListner ch = c.CashChequeBookListner.getInstance();
        try {
            ch.setDealCategory((pojo.DealCategory) ses.load(pojo.DealCategory.class, 2));
            ch.setCashDescrip("Credit For Employee NIC : " + getEmployee().getNic());
            ch.setCashAmount(credit);
            ch.setCashDealDate(new Date());
            ch.setDealType((pojo.DealType) ses.createCriteria(pojo.DealType.class).add(Restrictions.eq("type", "Employee Credit")).uniqueResult());
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

    public void setLableToDate(JDateChooser dc_credit_date, JLabel lb_credit_date) {
        Date date = dc_credit_date.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(date);
        lb_credit_date.setText(format);
    }

    public void assertUpdate(Double total) {
        pojo.AssetStatus as = new m.AssetStatus().getById(1);
        as.setAmount(as.getAmount() - total);
        new m.AssetStatus().update(as);
    }

    public void pay(JLabel lb_empid, JTextField tf_creditamount, JTextArea tf_sms, JLabel lb_Credit_Date) {

        if (getEmployee().getId() == Integer.parseInt(lb_empid.getText())) {
            Double credit = Double.parseDouble(tf_creditamount.getText());
            MoneyBook monyBook;
            if (credit > 0) {
                monyBook = addToMonyBook(credit);
                Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
                try {

                    Date parse = new SimpleDateFormat("yyyy-MM-dd").parse(lb_Credit_Date.getText());

                    pojo.Employee em = getEmployee();
                    Double currentCredit = em.getCurrentCredit() + Double.parseDouble(tf_creditamount.getText());
                    em.setCurrentCredit(v.Employee.getRoundDouble(currentCredit));

                    pojo.EmpCredit ec = new pojo.EmpCredit();
                    ec.setEmployee(getEmployee());
                    ec.setDate(parse);
                    ec.setCredit(v.Employee.getRoundDouble(Double.parseDouble(tf_creditamount.getText())));
                    ec.setMoneyBook(monyBook);

                    String sms = "Youre Current Credit Is :" + currentCredit + " NIC :" + em.getNic();
                    tf_sms.setText(sms);
                    ec.setSms(sms);

                    ses.save(ec);
                    ses.update(em);
                    ses.beginTransaction().commit();
                    assertUpdate(v.Employee.getRoundDouble(credit));
                } catch (Exception e) {
                    System.out.println("pay credit aulak");
                    e.printStackTrace();
                } finally {
                    ses.close();
                }
            }

        }
    }

    public void sendSMS(JLabel lb_empid, JTextField tf_creditamount, JTextArea tf_sms) {
        pojo.Employee em = getEmployee();
        if (em.getId() == Integer.parseInt(lb_empid.getText())) {
            SMSServer.EmpCreditSMS sms = new SMSServer.EmpCreditSMS();
            sms.setNumber1(em.getPhone1());
            sms.setNumber2(em.getPhone2());
            sms.setSms(tf_sms.getText());
            boolean send = sms.send();//Call To SEND SMS create Method body to send sms
            if (send) {
                JOptionPane.showMessageDialog(null, "SMS SENT");
                tf_sms.setText("");
            }
        }
    }

    public void loadForCredit(JTable tbl_emc, JLabel lb_empid, JLabel lb_empfullname, JLabel lb_empnic, JLabel lbl_currentcredit) {
        Session ses = conn.NewHibernateUtil.getSessionFactory().openSession();
        int id = Integer.parseInt(tbl_emc.getValueAt(tbl_emc.getSelectedRow(), 0).toString());

        try {
            pojo.Employee empo = (pojo.Employee) ses.createCriteria(pojo.Employee.class).add(Restrictions.eq("id", id)).uniqueResult();
            setEmployee(empo);

            lb_empid.setText(empo.getId().toString());
            lb_empfullname.setText(empo.getSname() + " " + empo.getFname() + " " + empo.getMname() + " " + empo.getLname());
            lb_empnic.setText(empo.getNic());
            lbl_currentcredit.setText(v.Employee.getRound(empo.getCurrentCredit()));
        } catch (Exception e) {
        } finally {
            ses.close();
        }
    }

    /**
     *
     * @param empCredit
     * @return return a String object, values as "not", "done", "error"
     */
    public String update(pojo.EmpCredit empCredit) {
        return "not";
    }

    public Long getTotal(Employee employee) {
        return null;
    }
}
