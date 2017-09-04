/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
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
public class ShowBankDetailsListner implements ComponentListener{
    private ShowBankDetailsListner(){}
    private static ShowBankDetailsListner ShowBankDetailsListner;
    public static ShowBankDetailsListner getInstance(){
        if(ShowBankDetailsListner==null)ShowBankDetailsListner=new ShowBankDetailsListner();
        return ShowBankDetailsListner;
    }
    private v.ShowBankDetails ShowBankDetails;
    private v.ShowBankDetails getShowBankDetailsView(){
        if(ShowBankDetails==null)ShowBankDetails=v.ShowBankDetails.getInstance();
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
        if(e.getComponent()==this.getShowBankDetailsView()){
            this.loadDetails();
        }
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        
    }
    private pojo.Bank bank=null;
    private void loadBank(){
        if(!this.getShowBankDetailsView().bankName.equals("")){
            if(bank==null)
                bank = new m.Bank().getBy(this.getShowBankDetailsView().bankName);
            this.getShowBankDetailsView().lbl_amount.setText("Rs. "+bank.getAmount());
        }else{
            JOptionPane.showMessageDialog(this.getShowBankDetailsView(), "Not Found Bank Name");
        }
    }
    private void loadDetailsByDateRange(Date f, Date t){
        this.loadBank();
        List<BankDeals> bankDealsList = new m.BankDeals().getByDateRange(f, t);
        if(bankDealsList!=null&&!bankDealsList.isEmpty()){
            JTable tbl = this.getShowBankDetailsView().tbl_bank_details;
            DefaultTableModel dtm=(DefaultTableModel) tbl.getModel();
            dtm.setColumnCount(0);
            dtm.setRowCount(0);
            dtm.addColumn("Date");
            dtm.addColumn("Cheque No");
            dtm.addColumn("Desciption");
            dtm.addColumn("Amount");
            Cheques cheques = new m.Cheques();
            for (BankDeals bankDeals : bankDealsList) {
                List<pojo.Cheques> chequeslist = cheques.getByBankDeal(bankDeals);
                Vector v = new Vector();
                v.add(bankDeals.getDate());
                if(chequeslist!=null&&!chequeslist.isEmpty()&&(chequeslist.size()==1)){
                    pojo.Cheques get = chequeslist.get(0);
                    v.add(get.getCheckno());
                }else{
                    v.add("");
                }
                v.add(bankDeals.getDescription());
                v.add(bankDeals.getAmount());
                dtm.addRow(v);
                if(chequeslist!=null&&!chequeslist.isEmpty()){
                    Vector v2 = new Vector();
                    
                }
            }
        }else{
            JOptionPane.showMessageDialog(this.getShowBankDetailsView(), "Not Found Bank Deals");
        }
    }
}
