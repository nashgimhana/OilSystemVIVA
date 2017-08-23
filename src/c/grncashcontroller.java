/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.swing.JTable;
import m.Bank;
//import m.CashType;
import m.CusCredit;
import m.DealType;
import m.SupplierCredit;
import m.SupplierPay;
import pojo.BankDeals;
import pojo.Cheques;
//import pojo.ChequeDetails;
import pojo.DealCategory;
import pojo.DealCheque;
import pojo.MoneyBook;
import pojo.Supplier;

/**
 *
 * @author User
 */
public class grncashcontroller {

    m.MoneyBook mb;
    pojo.MoneyBook mbpojo;
    pojo.SupplierPay suppaypojo;
    pojo.SupplierCredit supplierCredit;
//    ChequeDetails chequeDetails;

    public int saveMoneyBook(int cashtype, double total, Date date, double crntvalue, Supplier sup) {
        int success = 0;
        try {
            pojo.DealType dtpojo = new DealType().getBy(3);
            DealCategory dcpojo = new m.DealCategory().getBy(2);
            total = (Math.round(total * 100.0) / 100.0);
            crntvalue = (Math.round(crntvalue * 100.0) / 100.0);
            if (crntvalue == total) {
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

                    MoneyBook mbreturnid = mb.getBy(save);
                    suppaypojo = new pojo.SupplierPay();
                    suppaypojo.setMoneyBook(mbreturnid);
                    suppaypojo.setSupplier(sup);
                    pojo.AssetStatus as = new m.AssetStatus().getById(1);
                    as.setAmount(as.getAmount() - total);
                    new m.AssetStatus().update(as);

                    success = new SupplierPay().saveint(suppaypojo);

                } else {
                    Errormzg.displayerrorMessage("unable to save moneybook");
                }

            } else if (crntvalue < total && sup.getCurrentCredit() > 0) {

                double billtot = total - crntvalue;
                double paycredit = sup.getCurrentCredit() - billtot;
                paycredit = (Math.round(paycredit * 100.0) / 100.0);
                sup.setCurrentCredit(paycredit);
                billtot = (Math.round(billtot * 100.0) / 100.0);

                int i = new m.Supplier().update(sup);
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
                    suppaypojo = new pojo.SupplierPay();
                    suppaypojo.setMoneyBook(mbreturnid);
                    suppaypojo.setSupplier(sup);
                    System.out.println(success);
                    pojo.AssetStatus as = new m.AssetStatus().getById(1);
                    as.setAmount(as.getAmount() - total);
                    new m.AssetStatus().update(as);
                    success = new SupplierPay().saveint(suppaypojo);

                } else {
                    Errormzg.displayerrorMessage("unable to save moneybook");
                }

            } else if (total < crntvalue && total > 0) {

                double dueamount = crntvalue - total;
                dueamount = (Math.round(dueamount * 100.0) / 100.0);
                System.out.println(dueamount);

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
                    suppaypojo = new pojo.SupplierPay();
                    suppaypojo.setMoneyBook(mbreturnid);
                    suppaypojo.setSupplier(sup);

                    new SupplierPay().saveint(suppaypojo);
                    pojo.AssetStatus as = new m.AssetStatus().getById(1);
                    as.setAmount(as.getAmount() - total);
                    new m.AssetStatus().update(as);

                    supplierCredit = new pojo.SupplierCredit();
                    supplierCredit.setSupplier(sup);
                    supplierCredit.setAmount(dueamount);
                    supplierCredit.setDate(date);
                    new SupplierCredit().save(supplierCredit);

                    sup.setCurrentCredit(sup.getCurrentCredit() + dueamount);

                    success = new m.Supplier().update(sup);
                    if (success != 0) {
                        Errormzg.displayconfirmMessage(dueamount + "  amount added as credit");
                    } else {
                        Errormzg.displayerrorMessage("unable to paid credit");
                    }

                } else {
                    Errormzg.displayerrorMessage("unable to save moneybook");
                }

            } else if (total == 0) {
                supplierCredit = new pojo.SupplierCredit();
                supplierCredit.setSupplier(sup);
                supplierCredit.setAmount(crntvalue);
                supplierCredit.setDate(date);
                new SupplierCredit().save(supplierCredit);

                sup.setCurrentCredit(sup.getCurrentCredit() + crntvalue);

                success = new m.Supplier().update(sup);
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

    public int saveMoneyBook(int cashtype, double total, Date date, double crntvalue, Supplier sup, JTable tblchque) {
        total = (Math.round(total * 100.0) / 100.0);
        crntvalue = (Math.round(crntvalue * 100.0) / 100.0);
        try {
            if (total != 0) {
                supplierCredit = new pojo.SupplierCredit();
                supplierCredit.setSupplier(sup);
                supplierCredit.setAmount(crntvalue);
                supplierCredit.setDate(date);
                new SupplierCredit().save(supplierCredit);

                sup.setCurrentCredit(sup.getCurrentCredit() + crntvalue);

                int done = new m.Supplier().update(sup);

                if (done != 0) {
                    Cheques cheques = new Cheques();

                    for (int j = 0; j < tblchque.getRowCount(); j++) {
                        System.out.println("cheque table ekta awa");
                        cheques.setCheckno(tblchque.getValueAt(j, 0).toString());
                        pojo.Bank bnk = new Bank().getBy(tblchque.getValueAt(j, 1).toString());
                        cheques.setBank(bnk);
                        cheques.setChequeAmount(Double.parseDouble(tblchque.getValueAt(j, 2).toString()));
                        cheques.setDate(date);
                        cheques.setChequeDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblchque.getValueAt(j, 3).toString()));
                        cheques.setStatus(0);
                        cheques.setDiscription("Supplier/" + sup.getId());
                        cheques.setType("-");
                        new m.Cheques().saveint(cheques);

                    }
                } else {
                    Errormzg.displayerrorMessage("unable to pay supplier");
                }
            } else {
                supplierCredit = new pojo.SupplierCredit();
                supplierCredit.setSupplier(sup);
                supplierCredit.setAmount(crntvalue);
                supplierCredit.setDate(date);
                new SupplierCredit().save(supplierCredit);

                sup.setCurrentCredit(sup.getCurrentCredit() + crntvalue);

                int done = new m.Supplier().update(sup);
                if (done != 0) {
                    Errormzg.displayconfirmMessage(crntvalue + " amount added as credit");
                } else {
                    Errormzg.displayerrorMessage("unable to paid credit");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

    public int supliercheckproceed(int supid, String chequeid, double amount, int bnkid) {
        try {
            System.out.println("method ekta awa");
            Supplier supplier = new m.Supplier().getBy(supid);
            Cheques cheques = new m.Cheques().getByChequeNumber(chequeid);
            pojo.Bank bank = new m.Bank().getBy(bnkid);
            amount = (Math.round(amount * 100.0) / 100.0);

            if ((supplier.getCurrentCredit() - amount) >= 0) {
                System.out.println(amount);
                System.out.println(supplier.getCurrentCredit());
                System.out.println(supplier.getCurrentCredit() - amount+"supplier");
                supplier.setCurrentCredit(supplier.getCurrentCredit() - amount);
                int done = new m.Supplier().update(supplier);
                if (done != 0) {
                    bank.setAmount(bank.getAmount() - amount);
                    new m.Bank().updateBank(bank);

                    pojo.BankDeals bankDeals = new BankDeals();
                    bankDeals.setAmount(amount);
                    bankDeals.setBank(bank);
                    bankDeals.setDate(new Date());
                    bankDeals.setDescription(supplier.getName() + " cheque number " + cheques.getCheckno());

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
                Errormzg.displayerrorMessage("unable to pay check supplier credit");
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
            return 0;
        }

    }

}
