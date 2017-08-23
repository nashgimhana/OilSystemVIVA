/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import java.awt.TextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import m.Bank;
import m.RouteCredit;
import pojo.AssetLog;
import pojo.AssetStatus;
import pojo.BankDeals;
import pojo.Cheques;
//import pojo.CashType;
//import pojo.ChequeDetails;
import pojo.DealCategory;
import pojo.DealCheque;
import pojo.DealType;
import pojo.MoneyBook;
import pojo.RouteDebit;
import pojo.RouteReg;

/**
 *
 * @author User
 */
public class RouteDebitMoneyBook {

    public void routeDebitMoneyBookSave(int cashTpe, JDateChooser dateChooser, JTextField totalDebitPay, RouteReg routeReg, JRootPane jRootPane, JTable jTable, JTextField checkNumber, JComboBox bankName, JTextField checkAmount, JDateChooser checkDate) {
        try {
            DealCategory dealCategory = new m.DealCategory().getBy(1);
            DealType dealType = new m.DealType().getBy(2);

            if (cashTpe == 1) {

                try {
                    if (totalDebitPay.getText().isEmpty()) {
                        Errormzg.displayerrorMessage("Please enter an amount");
                    } else {
                        //CashType cashType = new m.CashType().getBY(cashTpe);

                        MoneyBook moneyBook = new pojo.MoneyBook();
                        moneyBook.setDate(dateChooser.getDate());
                        moneyBook.setDscription("RouteDebit");
                        double totalDebitPay1 = Double.parseDouble(totalDebitPay.getText());
                        totalDebitPay1 = (Math.round(totalDebitPay1 * 100.0) / 100.0);
                        moneyBook.setAmount(totalDebitPay1);
                        //moneyBook.setCashType(cashType);
                        moneyBook.setDealCategory(dealCategory);
                        moneyBook.setDealType(dealType);

                        Integer save = new m.MoneyBook().saveint(moneyBook);
                        MoneyBook moneyBookSaveReturn = new m.MoneyBook().getBy(save);
                        System.out.println(routeReg.getName());

                        RouteDebit routeDebit = new pojo.RouteDebit();
                        routeDebit.setDate(dateChooser.getDate());
                        double totalDebitPay11 = Double.parseDouble(totalDebitPay.getText());
                        totalDebitPay11 = (Math.round(totalDebitPay11 * 100.0) / 100.0);
                        routeDebit.setDebit(totalDebitPay11);
                        routeDebit.setRouteReg(routeReg);
                        routeDebit.setMoneyBook(moneyBookSaveReturn);

                        String save1 = new m.RouteDebit().save(routeDebit);
                        System.out.println(save1);

                        Double d = Double.parseDouble(totalDebitPay.getText());
                        d = (Math.round(d * 100.0) / 100.0);
                        Double currentCredit = routeReg.getCurrentCredit();
                        currentCredit = (Math.round(currentCredit * 100.0) / 100.0);
                        double y = currentCredit - d;
                        y = Math.round(y * 100.0) / 100.0;
                        routeReg.setCurrentCredit(y);
                        //System.out.println(routeReg.getCurrentCredit()"********************************8888");
                        new m.RouteReg().updateRoute(routeReg);

                        AssetStatus assetStatus = new m.AssetStatus().getById(1);

                        AssetLog assetLog = new AssetLog();
                        assetLog.setAssetStatus(assetStatus);
                        assetLog.setDate(dateChooser.getDate());
                        assetLog.setDesceiption("Route Debit Money By Cash");
                        new m.AssetLog().saveAssetLog(assetLog);

                        Double assetStatusAmount = assetStatus.getAmount();
                        System.out.println("AssetAmount : " + assetStatusAmount);
                        double mm = Double.parseDouble(totalDebitPay.getText());
                        assetStatusAmount = (assetStatusAmount + mm);
                        assetStatusAmount = (Math.round(assetStatusAmount * 100.0) / 100.0);
                        System.out.println("AssetAmount : " + assetStatusAmount);
                        assetStatus.setAmount(assetStatusAmount);
                        new m.AssetStatus().updateAssetStatusMe(assetStatus);

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else if (cashTpe == 2) {

                try {
                    if (totalDebitPay.getText().isEmpty()) {
                        Errormzg.displayerrorMessage("Please enter an amount");
                    } else {
                        //CashType cashType = new m.CashType().getBY(cashTpe);
//                        MoneyBook moneyBook = new pojo.MoneyBook();
//                        moneyBook.setDate(dateChooser.getDate());
//                        moneyBook.setDscription("RouteDebit");
//                        double parseDouble = Double.parseDouble(totalDebitPay.getText());
//                        parseDouble = (Math.round(parseDouble * 100.0) / 100.0);
//                        moneyBook.setAmount(parseDouble);
//                        //moneyBook.setCashType(cashType);
//                        moneyBook.setDealCategory(dealCategory);
//                        moneyBook.setDealType(dealType);
//
//                        Integer save = new m.MoneyBook().saveint(moneyBook);
//                        MoneyBook moneyBookSaveReturn = new m.MoneyBook().getBy(save);
//                        System.out.println(routeReg.getName());
//
//                        RouteDebit routeDebit = new pojo.RouteDebit();
//                        routeDebit.setDate(dateChooser.getDate());
//                        double parseDouble1 = Double.parseDouble(totalDebitPay.getText());
//                        parseDouble1 = (Math.round(parseDouble1 * 100.0) / 100.0);
//                        routeDebit.setDebit(parseDouble1);
//                        routeDebit.setRouteReg(routeReg);
//                        routeDebit.setMoneyBook(moneyBookSaveReturn);
//
//                        String save1 = new m.RouteDebit().save(routeDebit);
//                        System.out.println(save1);
//                        Double d = Double.parseDouble(totalDebitPay.getText());
//                        d = (Math.round(d * 100.0) / 100.0);
//                        Double currentCredit = routeReg.getCurrentCredit();
//                        currentCredit = (Math.round(currentCredit * 100.0) / 100.0);
//                        double sdf = currentCredit - d;
//                        sdf = (Math.round(sdf * 100.0) / 100.0);
//                        routeReg.setCurrentCredit(sdf);
//                        new m.RouteReg().updateRoute(routeReg);
//get total value
                        //Double currentCredit = routeReg.getCurrentCredit();
                        //currentCredit = currentCredit + Double.parseDouble(totalDebitPay.getText());
                        //currentCredit = (Math.round(currentCredit * 100.0) / 100.0);
                        //routeReg.setCurrentCredit(currentCredit);
                        //new m.RouteReg().updateRoute(routeReg);

                        pojo.RouteCredit routeCredit = new pojo.RouteCredit();
                        routeCredit.setCredit((Math.round(Double.parseDouble(totalDebitPay.getText()) * 100.0) / 100.0));
                        routeCredit.setRouteReg(routeReg);
                        routeCredit.setDate(dateChooser.getDate());
                        RouteCredit routeCreditSave = new m.RouteCredit();
                        routeCreditSave.save1(routeCredit);

                        DefaultTableModel dtm = (DefaultTableModel) jTable.getModel();
                        for (int i = 0; i < dtm.getRowCount(); i++) {
                            //ChequeDetails chequeDetails = new pojo.ChequeDetails();
//                            Cheques chequeDetails = new pojo.Cheques();
//                            chequeDetails.setCheckno(dtm.getValueAt(i, 0).toString());
//
//                            pojo.Bank bank = new Bank().getBy(dtm.getValueAt(i, 1).toString());
//                            Double bAmount = bank.getAmount();
//                            System.out.println("Bank Amount Curretn :" + bAmount);
//                            bAmount = bAmount + Double.parseDouble(dtm.getValueAt(i, 2).toString());
//                            bAmount = (Math.round(bAmount * 100.0) / 100.0);
//                            bank.setAmount(bAmount);
//                            System.out.println("Bank Amount Curretn :" + bAmount);
//                            new m.Bank().updateBank(bank);
//                            chequeDetails.setBank(bank);
//                            //chequeDetails.setMoneyBook(moneyBookSaveReturn);
//                            double parseDouble2 = Double.parseDouble(dtm.getValueAt(i, 2).toString());
//                            parseDouble2 = (Math.round(parseDouble2 * 100.0) / 100.0);
//                            chequeDetails.setChequeAmount(parseDouble2);
//                            new m.Cheques().save(chequeDetails);
                            Cheques cheques = new pojo.Cheques();
                            cheques.setCheckno(dtm.getValueAt(i, 1).toString());

                            double checkAmmount = Double.parseDouble(dtm.getValueAt(i, 3).toString());
                            checkAmmount = (Math.round(checkAmmount * 100.0) / 100.0);
                            cheques.setChequeAmount(checkAmmount);
                            cheques.setDate(dateChooser.getDate());
                            cheques.setDiscription("RouteReg/" + routeReg.getId()+"/"+routeReg.getName());
                            cheques.setStatus(0);
                            cheques.setChequeDate(new SimpleDateFormat("yyyy-MM-dd").parse(dtm.getValueAt(i, 0).toString()));
                            pojo.Bank bank = new Bank().getBy(dtm.getValueAt(i, 2).toString());
                            cheques.setBank(bank);
                            cheques.setType("+");
                            new m.Cheques().saveint(cheques);

                        }

//                        AssetStatus assetStatus = new m.AssetStatus().getById(1);
//
//                        AssetLog assetLog = new AssetLog();
//                        assetLog.setAssetStatus(assetStatus);
//                        assetLog.setDate(dateChooser.getDate());
//                        assetLog.setDesceiption("Route Debit Money By Cash");
//                        new m.AssetLog().saveAssetLog(assetLog);
//
//                        Double assetStatusAmount = assetStatus.getAmount();
//                        System.out.println("AssetAmount : " + assetStatusAmount);
//                        double mm = Double.parseDouble(totalDebitPay.getText());
//                        assetStatusAmount = (assetStatusAmount + mm);
//                        assetStatusAmount = (Math.round(assetStatusAmount * 100.0) / 100.0);
//                        System.out.println("AssetAmount : " + assetStatusAmount);
//                        assetStatus.setAmount(assetStatusAmount);
//                        new m.AssetStatus().updateAssetStatusMe(assetStatus);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //JOptionPane.showConfirmDialog(jRootPane, "test");
    }

    public int routeCheckProceed(int routeId, String chequeId, double amount, int bnkId) {
        try {
//            DealCategory dealCategory = new m.DealCategory().getBy(1);
//            DealType dealType = new m.DealType().getBy(2);
            RouteReg routeReg = new m.RouteReg().getBy(routeId);
            Cheques cheques = new m.Cheques().getByChequeNumber(chequeId);
            pojo.Bank bank = new m.Bank().getBy(bnkId);
            amount = (Math.round(amount * 100.0) / 100.0);
            double afterProcess = routeReg.getCurrentCredit()-amount;
            if (afterProcess >= 0) {
                System.out.println("Current credit amount : "+routeReg.getCurrentCredit());
                System.out.println("After credit amount : "+(routeReg.getCurrentCredit()-amount));
                
                
                routeReg.setCurrentCredit((Math.round(afterProcess* 100.0) / 100.0));
                int done = new m.RouteReg().updateRouteInt(routeReg);
                if (done != 0) {
                    bank.setAmount(bank.getAmount() + amount);
                    new m.Bank().updateBank(bank);

                    pojo.BankDeals bankDeals = new BankDeals();
                    bankDeals.setAmount(amount);
                    bankDeals.setBank(bank);
                    bankDeals.setDate(new Date());
                    bankDeals.setDescription(routeReg.getName() + " cheque number " + cheques.getCheckno());

                    int bnkdealid = new m.BankDeals().saveint(bankDeals);

                    pojo.BankDeals bd = new m.BankDeals().getBy(bnkdealid);

                    DealCheque dealCheque = new DealCheque();
                    dealCheque.setBankDeals(bd);
                    dealCheque.setCheques(cheques);
                    new m.DealCheques().save(dealCheque);
                    
                    cheques.setStatus(1);
                    new m.Cheques().update(cheques);
//##############################################################################
//                    MoneyBook moneyBook = new pojo.MoneyBook();
//                    moneyBook.setDate(new Date());
//                    moneyBook.setDscription("RouteDebit");
//
//                    moneyBook.setAmount(amount);
//
//                    moneyBook.setDealCategory(dealCategory);
//                    moneyBook.setDealType(dealType);
//
//                    Integer save = new m.MoneyBook().saveint(moneyBook);
//                    MoneyBook moneyBookSaveReturn = new m.MoneyBook().getBy(save);
//                    System.out.println(routeReg.getName());
//
//                    RouteDebit routeDebit = new pojo.RouteDebit();
//                    routeDebit.setDate(new Date());
//
//                    routeDebit.setDebit(amount);
//                    routeDebit.setRouteReg(routeReg);
//                    routeDebit.setMoneyBook(moneyBookSaveReturn);
//
//                    String save1 = new m.RouteDebit().save(routeDebit);
//                    System.out.println(save1);

                    return 1;

                } else {
                    Errormzg.displayerrorMessage("Somthing went wrong");
                    return 0;
                }

            } else {
                Errormzg.displayerrorMessage("unable to pay check route credit");
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
            return 0;
        }

    }
}
