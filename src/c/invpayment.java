/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import m.Bank;
//import m.CashType;
import m.DealType;
import m.SupplierCredit;
import m.SupplierPay;
import pojo.AssetStatus;
import pojo.BankDeals;
import pojo.Cheques;
//import pojo.ChequeDetails;
import pojo.CusCredit;
import pojo.Customer;
import pojo.CustomerPay;
import pojo.DealCategory;
import pojo.DealCheque;
import pojo.MoneyBook;
import pojo.Supplier;

/**
 *
 * @author User
 */
public class invpayment {

    m.MoneyBook mb;
    pojo.MoneyBook mbpojo;
    pojo.CustomerPay cuspay;
    pojo.CusCredit cuscredit;
    pojo.SupplierPay suppaypojo;
    pojo.SupplierCredit supplierCredit;
//    ChequeDetails chequeDetails;

    public int saveMoneyBook(int cashtype, double total, Date date, double crntvalue, Customer cus) {
        int success = 0;
        try {
//            pojo.CashType ctpojo = new CashType().getBY(cashtype);
            pojo.DealType dtpojo = new DealType().getBy(12);
            DealCategory dcpojo = new m.DealCategory().getBy(1);
            total = (Math.round(total * 100.0) / 100.0);
            crntvalue = (Math.round(crntvalue * 100.0) / 100.0);
            if (crntvalue == total) {
                mbpojo = new pojo.MoneyBook();
                mb = new m.MoneyBook();
                mbpojo.setDate(date);
                mbpojo.setDscription("Customer payment");
                mbpojo.setAmount(total);
                mbpojo.setDealCategory(dcpojo);
                mbpojo.setDealType(dtpojo);
//                mbpojo.setCashType(ctpojo);
                int save = mb.saveint(mbpojo);
                if (save != 0) {

                    MoneyBook mbreturnid = mb.getBy(save);
                    cuspay = new CustomerPay();
                    cuspay.setMoneyBook(mbreturnid);
                    cuspay.setCustomer(cus);

                    new m.CustomerPay().add(cuspay);

                    pojo.AssetStatus as = new m.AssetStatus().getById(1);
                    as.setAmount(as.getAmount() + total);
                    new m.AssetStatus().update(as);
                    return 1;

                } else {
                    Errormzg.displayerrorMessage("unable to save moneybook");
                }

            } else if (crntvalue < total && cus.getCredit() > 0) {

                double billtot = total - crntvalue;
                double paycredit = cus.getCredit() - billtot;
                paycredit = (Math.round(paycredit * 100.0) / 100.0);
                cus.setCredit(paycredit);
                billtot = (Math.round(billtot * 100.0) / 100.0);

                int i = new m.Customer().updatecus(cus);
                if (i == 1) {

                    Errormzg.displayconfirmMessage(billtot + " amount of money paid as credit");
                } else {
                    Errormzg.displayerrorMessage("unable to paid credit");
                }

                mbpojo = new pojo.MoneyBook();
                mb = new m.MoneyBook();
                mbpojo.setDate(date);
                mbpojo.setAmount(total);
                mbpojo.setDscription("nothing special");
                mbpojo.setDealCategory(dcpojo);
                mbpojo.setDealType(dtpojo);
//                mbpojo.setCashType(ctpojo);
                int save = mb.saveint(mbpojo);
                if (save != 0) {

//                    System.out.println("money book save una");
                    MoneyBook mbreturnid = mb.getBy(save);
                    cuspay = new CustomerPay();
                    cuspay.setMoneyBook(mbreturnid);
                    cuspay.setCustomer(cus);

                    new m.CustomerPay().add(cuspay);
                    pojo.AssetStatus as = new m.AssetStatus().getById(1);
                    as.setAmount(as.getAmount() + total);
                    new m.AssetStatus().update(as);
                    return 1;
                } else {
                    Errormzg.displayerrorMessage("unable to save moneybook");
                }

            } else if (total < crntvalue && total > 0) {

                double dueamount = crntvalue - total;
                dueamount = (Math.round(dueamount * 100.0) / 100.0);
//                System.out.println(dueamount);

                mbpojo = new pojo.MoneyBook();
                mb = new m.MoneyBook();
                mbpojo.setDate(date);
                mbpojo.setDscription("nothing special");
                mbpojo.setAmount(total);
                mbpojo.setDealCategory(dcpojo);
                mbpojo.setDealType(dtpojo);
//                mbpojo.setCashType(ctpojo);
                int save = mb.saveint(mbpojo);
                if (save != 0) {
//                    System.out.println("money book save una");
                    MoneyBook mbreturnid = mb.getBy(save);
                    cuspay = new CustomerPay();
                    cuspay.setMoneyBook(mbreturnid);
                    cuspay.setCustomer(cus);

                    new m.CustomerPay().add(cuspay);
                    pojo.AssetStatus as = new m.AssetStatus().getById(1);
                    as.setAmount(as.getAmount() + total);
                    new m.AssetStatus().update(as);

                    cuscredit = new CusCredit();
                    cuscredit.setCustomer(cus);
                    cuscredit.setAmount(dueamount);
                    cuscredit.setDate(date);
                    cuscredit.setType(1);
                    new m.CusCredit().save(cuscredit);

                    cus.setCredit(cus.getCredit() + dueamount);

                    success = new m.Customer().updatecus(cus);
                    if (success != 0) {
                        Errormzg.displayconfirmMessage(dueamount + "  amount added as credit");
                    } else {
                        Errormzg.displayerrorMessage("unable to paid credit");
                    }

                } else {
                    Errormzg.displayerrorMessage("unable to save moneybook");
                }

            } else if (total == 0) {
                cuscredit = new CusCredit();
                cuscredit.setCustomer(cus);
                cuscredit.setAmount(crntvalue);
                cuscredit.setDate(date);
                cuscredit.setType(1);
                new m.CusCredit().save(cuscredit);

                cus.setCredit(cus.getCredit() + crntvalue);

                success = new m.Customer().updatecus(cus);
                if (success != 0) {
                    Errormzg.displayconfirmMessage(crntvalue + " amount added as credit");
                } else {
                    Errormzg.displayerrorMessage("unable to paid credit");
                }

            } else {
                Errormzg.displayerrorMessage("Please check again.somthing went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
        return success;
    }

    public int saveMoneyBook(int cashtype, double total, Date date, double crntvalue, Customer cus, JTable tblchque) {

        try {
            total = (Math.round(total * 100.0) / 100.0);
            crntvalue = (Math.round(crntvalue * 100.0) / 100.0);
            if (total != 0) {

                cuscredit = new CusCredit();
                cuscredit.setCustomer(cus);
                cuscredit.setAmount(crntvalue);
                cuscredit.setDate(date);
                cuscredit.setType(1);
                new m.CusCredit().save(cuscredit);

                cus.setCredit(cus.getCredit() + crntvalue);

                int done = new m.Customer().updatecus(cus);

                if (done != 0) {
                    Cheques cheques = new Cheques();

                    for (int j = 0; j < tblchque.getRowCount(); j++) {
                        cheques.setCheckno(tblchque.getValueAt(j, 0).toString());
                        pojo.Bank bnk = new Bank().getBy(tblchque.getValueAt(j, 1).toString());
                        cheques.setBank(bnk);
                        cheques.setChequeAmount(Double.parseDouble(tblchque.getValueAt(j, 2).toString()));
                        cheques.setDate(date);
                        cheques.setChequeDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblchque.getValueAt(j, 3).toString()));
                        cheques.setStatus(0);
                        cheques.setDiscription("Customer/" + cus.getId());
                        cheques.setType("+");
                        new m.Cheques().saveint(cheques);

                    }
                    return 1;
                } else {
                    Errormzg.displayerrorMessage("unable to pay Innvoice");
                    return 0;
                }
            } else {
                cuscredit = new CusCredit();
                cuscredit.setCustomer(cus);
                cuscredit.setAmount(crntvalue);
                cuscredit.setDate(date);
                cuscredit.setType(1);
                new m.CusCredit().save(cuscredit);

                cus.setCredit(cus.getCredit() + crntvalue);

                new m.Customer().updatecus(cus);
                return 1;
            }
        } catch (Exception e) {

            e.printStackTrace();
            return 0;
        }

    }

    public int customercheckproceed(int cusid, String chequeid, double amount, int bnkid) {
        try {
            Customer customer = new m.Customer().getById(cusid);
            Cheques cheques = new m.Cheques().getByChequeNumber(chequeid);
            pojo.Bank bank = new m.Bank().getBy(bnkid);
            amount = (Math.round(amount * 100.0) / 100.0);

            if ((customer.getCredit() - amount) >= 0) {
                customer.setCredit(customer.getCredit() - amount);
                int done = new m.Customer().updatecus(customer);
                if (done != 0) {
                    bank.setAmount(bank.getAmount() + amount);
                    new m.Bank().updateBank(bank);

                    pojo.BankDeals bankDeals = new BankDeals();
                    bankDeals.setAmount(amount);
                    bankDeals.setBank(bank);
                    bankDeals.setDate(new Date());
                    bankDeals.setDescription(customer.getFname() + " cheque number " + cheques.getCheckno());

                    int bnkdealid = new m.BankDeals().saveint(bankDeals);

                    pojo.BankDeals bd = new m.BankDeals().getBy(bnkdealid);

                    DealCheque dealCheque = new DealCheque();
                    dealCheque.setBankDeals(bd);
                    dealCheque.setCheques(cheques);
                    new m.DealCheques().save(dealCheque);

                    cheques.setStatus(1);
                    new m.Cheques().update(cheques);

                    return 1;

                } else {
                    Errormzg.displayerrorMessage("Somthing went wrong");
                    return 0;
                }

            } else {
                Errormzg.displayerrorMessage("unable to pay check customer credit");
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
            return 0;
        }

    }

}
