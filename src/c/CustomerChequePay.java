/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pojo.Bank;
import pojo.Cheques;
import pojo.Customer;

/**
 *
 * @author SHANAKA
 */
public class CustomerChequePay {

    public void savePay(JTable tbl_cheque, JPanel pnl_payment_cheque, JDateChooser jdc_pay_date, JLabel lbl_show_nic) {
        try {
            System.out.println("aawa");
            DefaultTableModel dtm = (DefaultTableModel) tbl_cheque.getModel();
            int rc = dtm.getRowCount();
            String nic = lbl_show_nic.getText();
            Customer cusId = new m.Customer().getByNic(nic);
            System.out.println(cusId.getId());
            double ftot = 0;
            for (int i = 0; i < rc; i++) {
                ftot += Double.parseDouble(tbl_cheque.getValueAt(i, 2).toString());
            }
            String fullTotal = v.Employee.getRound(ftot);

            for (int i = 0; i < rc; i++) {
                String cNo = tbl_cheque.getValueAt(i, 0).toString();
                System.out.println(cNo);
                String bank = tbl_cheque.getValueAt(i, 1).toString();

                Bank byBank = new m.Bank().getBy(bank);
                System.out.println(byBank);
                Double amount = Double.parseDouble(tbl_cheque.getValueAt(i, 2).toString());

                pojo.Cheques cheques = new pojo.Cheques();
                cheques.setCheckno(cNo);
                cheques.setChequeAmount(amount);
                cheques.setChequeDate(new SimpleDateFormat("yyyy-MM-dd").parse(dtm.getValueAt(i, 3).toString()));
                // cheques.setChequeDate(new java.util.Date());
                cheques.setBank(byBank);
                
                cheques.setDiscription("Customer/"+cusId.getId()+"/" + cusId.getFname());
                cheques.setType("+");
                cheques.setStatus(1);
                cheques.setDate(jdc_pay_date.getDate());
                new m.Cheques().save(cheques);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    

}
