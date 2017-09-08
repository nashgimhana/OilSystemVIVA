/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import m.Cheques;
import pojo.Bank;
import pojo.BankDeals;

/**
 *
 * @author suhada
 */
public class ShowBankDetailsListner implements ComponentListener, MouseListener {

    private ShowBankDetailsListner() {
    }
    private static ShowBankDetailsListner ShowBankDetailsListner;

    public static ShowBankDetailsListner getInstance() {
        if (ShowBankDetailsListner == null) {
            ShowBankDetailsListner = new ShowBankDetailsListner();
        }
        return ShowBankDetailsListner;
    }
    private v.ShowBankDetails ShowBankDetails;

    private v.ShowBankDetails getShowBankDetailsView() {
        if (ShowBankDetails == null) {
            ShowBankDetails = v.ShowBankDetails.getInstance();
        }
        return ShowBankDetails;
    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {
        if (e.getComponent() == this.getShowBankDetailsView()) {
            Date to = new Date();
            this.loadBank();
            Date from = new Date(to.getTime() + (long)(1000 * 60 * 60 * 24 * 30));
            System.out.println(from+"----"+to);
            this.loadDetailsByDateRange(from,to);
        }
    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.getShowBankDetailsView().btn_get) {
            Date datef = this.getShowBankDetailsView().jdc_from.getDate();
            Date datet = this.getShowBankDetailsView().jdc_to.getDate();
            System.out.println(datef + " " + datet);
            loadDetailsByDateRange(datef, datet);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private pojo.Bank bank = null;

    private void loadBank() {
        JTable tbl = this.getShowBankDetailsView().tbl_bank_details;
        DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
        dtm.setRowCount(0);
        if (!this.getShowBankDetailsView().bankName.equals("")) {
            bank = new m.Bank().getBy(this.getShowBankDetailsView().bankName);
            this.getShowBankDetailsView().lbl_bank_name.setText(bank.getBank());
            this.getShowBankDetailsView().lbl_amount.setText("Rs. " + bank.getAmount());
        } else {
            JOptionPane.showMessageDialog(this.getShowBankDetailsView(), "Not Found Bank Name");
        }
    }

    private void loadDetailsByDateRange(Date f, Date t) {
        JTable tbl = this.getShowBankDetailsView().tbl_bank_details;
        DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        dtm.addColumn("Date");
        dtm.addColumn("Cheque No");
        dtm.addColumn("Desciption");
        dtm.addColumn("Amount");
        if (bank == null) {
            this.loadBank();
        }
        List<BankDeals> bankDealsList = null;
        if (f == null && t == null) {
            bankDealsList = new m.BankDeals().getByBank(bank);
        } else if (f != null && t != null) {
            bankDealsList = new m.BankDeals().getByDateRange(bank, f, t);
        } else if (f != null || t != null) {
            if (f != null) {
                bankDealsList = new m.BankDeals().getByBankAndDate(bank, f);
            }
            if (t != null) {
                bankDealsList = new m.BankDeals().getByBankAndDate(bank, t);
            }
        }
        if (bankDealsList != null && !bankDealsList.isEmpty()) {

            Cheques cheques = new m.Cheques();
            for (BankDeals bankDeals : bankDealsList) {
                List<pojo.Cheques> chequeslist = cheques.getByBankDeal(bankDeals);
                Vector v = new Vector();
                v.add(bankDeals.getDate());
                if (chequeslist != null && !chequeslist.isEmpty() && (chequeslist.size() == 1)) {
                    pojo.Cheques get = chequeslist.get(0);
                    v.add(get.getCheckno());
                } else {
                    v.add("");
                }
                v.add(bankDeals.getDescription());
                v.add(bankDeals.getAmount());
                dtm.addRow(v);
                if (chequeslist != null && !chequeslist.isEmpty() && (chequeslist.size() > 1)) {
                    for (pojo.Cheques Cheques : chequeslist) {
                        Vector v2 = new Vector();
                        v.add("");
                        v.add(Cheques.getCheckno());
                        v.add("");
                        v.add(Cheques.getChequeAmount());
                        dtm.addRow(v2);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this.getShowBankDetailsView(), "Not Found Bank Deals");
        }
    }

}
