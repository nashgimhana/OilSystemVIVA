///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package c;
//
////import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
//import com.toedter.calendar.JDateChooser;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Vector;
//import javax.swing.JCheckBox;
//import javax.swing.JComboBox;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.table.DefaultTableModel;
//import pojo.Bank;
//import pojo.CashType;
//import pojo.ChequeDetails;
//import pojo.CusCredit;
//import pojo.Customer;
//import pojo.DealCategory;
//import pojo.DealType;
//import pojo.GrnLog;
//import pojo.Invoice;
//import pojo.InvoiceLog;
//import pojo.InvoicePay;
//import pojo.MoneyBook;
//
///**
// *
// * @author shanaka
// */
//public class InvoicePayment {
//
//    int invoice;
//    int saveintCash;
//    int saveintCheque;
//    double CashPayVal;
//    double CequePayVal;
//    double balance;
//    String customer;
//    Date dateObj;
//    pojo.Customer customerObj;
//    pojo.Invoice invoiecObj;
//    pojo.DealType dealtypeObj;
//    pojo.DealCategory dealcatObj;
////    pojo.CashType cachTypeObj_cash;
////    pojo.CashType cachTypeObj_cheque;
//    pojo.MoneyBook moneyBookCash;
//    pojo.MoneyBook moneyBookCheque;
//
//    public static double getRoundDouble(double dd) {
//        double round = Math.round(dd * 100.0) / 100.0;
//        return round;
//    }
//
//    public void getBanks(JComboBox cmbBank) {
//        System.out.println("wada");
//        try {
//            List<Bank> all = new m.Bank().getAll();
//            cmbBank.setSelectedIndex(0);
//            for (Bank bank : all) {
//                cmbBank.addItem(bank.getBank());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void cashpay(Date DateChooser, String Customer, JLabel lblBalance, JLabel lblCashPayTot, int inv) {
//        try {
//            balance = Double.parseDouble(lblBalance.getText());
//            double amount = Double.parseDouble(lblCashPayTot.getText());
//            dealcatObj = new m.DealCategory().getBy(1);
//            dealtypeObj = new m.DealType().getBy(12);
//            cachTypeObj_cash = new m.CashType().getBY(1);
//            cachTypeObj_cheque = new m.CashType().getBY(2);
//            customerObj = new m.Customer().getByFnameS(Customer);
//            Invoice invoiceOb = new m.Invoice().getBy(inv);
//            if (balance == 0) {
//                pojo.MoneyBook moneyBook = new pojo.MoneyBook();
//                moneyBook.setDate(DateChooser);
//                moneyBook.setDscription("Customer Invoice paymet " + Customer);
//                moneyBook.setAmount(amount);
//                moneyBook.setCashType(cachTypeObj_cash);
//                moneyBook.setDealCategory(dealcatObj);
//                moneyBook.setDealType(dealtypeObj);
//                saveintCash = new m.MoneyBook().saveint(moneyBook);
//                System.out.println(saveintCash + "save to money book");
//                moneyBookCash = new m.MoneyBook().getBy(saveintCash);
//
//                InvoicePay invoicePay = new pojo.InvoicePay();
//                invoicePay.setInvoice(invoiceOb);
//                invoicePay.setMoneyBook(moneyBookCash);
//                new m.InvoicePay().save(invoicePay);
//                System.out.println("saved invoice pay");
//
//            } else if (balance > 0) {
//                pojo.MoneyBook moneyBook = new pojo.MoneyBook();
//                moneyBook.setDate(DateChooser);
//                moneyBook.setDscription("Customer Invoice paymet " + Customer);
//                moneyBook.setAmount(amount);
//                moneyBook.setCashType(cachTypeObj_cash);
//                moneyBook.setDealCategory(dealcatObj);
//                moneyBook.setDealType(dealtypeObj);
//                saveintCash = new m.MoneyBook().saveint(moneyBook);
//                System.out.println(saveintCash + "save to money book");
//                moneyBookCash = new m.MoneyBook().getBy(saveintCash);
//
//                InvoicePay invoicePay = new pojo.InvoicePay();
//                invoicePay.setInvoice(invoiceOb);
//                invoicePay.setMoneyBook(moneyBookCash);
//                new m.InvoicePay().save(invoicePay);
//                System.out.println("saved invoice pay");
//
//                CusCredit cusCredit = new pojo.CusCredit();
//                cusCredit.setDate(DateChooser);
//                cusCredit.setAmount(amount);
//                cusCredit.setCustomer(customerObj);
//                cusCredit.setType(2);
//                new m.CusCredit().save(cusCredit);
//                System.out.println("credit saved");
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void chequepay(Date DateChooser, String Customer, JLabel lblBalance, JLabel lblChequePayTot, JTable tblCheque, int inv) {
//        try {
//            balance = Double.parseDouble(lblBalance.getText());
//            double amount = Double.parseDouble(lblChequePayTot.getText());
//            dealcatObj = new m.DealCategory().getBy(1);
//            dealtypeObj = new m.DealType().getBy(12);
//            cachTypeObj_cash = new m.CashType().getBY(1);
//            cachTypeObj_cheque = new m.CashType().getBY(2);
//            customerObj = new m.Customer().getByFnameS(Customer);
//            Invoice invoiceOb = new m.Invoice().getBy(inv);
//            if (balance == 0) {
//                pojo.MoneyBook moneyBook = new pojo.MoneyBook();
//                moneyBook.setDate(DateChooser);
//                moneyBook.setDscription("Customer Invoice paymet " + Customer);
//                moneyBook.setAmount(amount);
//                moneyBook.setCashType(cachTypeObj_cheque);
//                moneyBook.setDealCategory(dealcatObj);
//                moneyBook.setDealType(dealtypeObj);
//                saveintCheque = new m.MoneyBook().saveint(moneyBook);
//                System.out.println(saveintCheque + "save to money book");
//                moneyBookCheque = new m.MoneyBook().getBy(saveintCheque);
//
//                InvoicePay invoicePay = new pojo.InvoicePay();
//                invoicePay.setInvoice(invoiceOb);
//                invoicePay.setMoneyBook(moneyBookCash);
//                new m.InvoicePay().save(invoicePay);
//                System.out.println("saved invoice pay");
//
//                int rc = tblCheque.getRowCount();
//                for (int i = 0; i < rc; i++) {
//                    String bank = tblCheque.getValueAt(i, 0).toString();
//                    pojo.Bank bankObj = new m.Bank().getBy(bank);
//
//                    String cNo = tblCheque.getValueAt(i, 1).toString();
//                    double cAmount = Double.parseDouble(tblCheque.getValueAt(i, 2).toString());
//
//                    ChequeDetails chequeDetails = new pojo.ChequeDetails();
//                    chequeDetails.setCheckno(cNo);
//                    chequeDetails.setBank(bankObj);
//                    chequeDetails.setMoneyBook(moneyBookCheque);
//                    chequeDetails.setChequeAmount(cAmount);
//                    String checksave = new m.Cheques().save(chequeDetails);
//                    System.out.println(checksave + "saved chequesss");
//                }
//
//            } else if (balance > 0) {
//                pojo.MoneyBook moneyBook = new pojo.MoneyBook();
//                moneyBook.setDate(DateChooser);
//                moneyBook.setDscription("Customer Invoice paymet " + Customer);
//                moneyBook.setAmount(amount);
//                moneyBook.setCashType(cachTypeObj_cash);
//                moneyBook.setDealCategory(dealcatObj);
//                moneyBook.setDealType(dealtypeObj);
//                saveintCheque = new m.MoneyBook().saveint(moneyBook);
//                System.out.println(saveintCheque + "save to money book");
//                moneyBookCheque = new m.MoneyBook().getBy(saveintCheque);
//
//                InvoicePay invoicePay = new pojo.InvoicePay();
//                invoicePay.setInvoice(invoiceOb);
//                invoicePay.setMoneyBook(moneyBookCash);
//                new m.InvoicePay().save(invoicePay);
//                System.out.println("saved invoice pay");
//
//                int rc = tblCheque.getRowCount();
//                for (int i = 0; i < rc; i++) {
//                    String bank = tblCheque.getValueAt(i, 0).toString();
//                    pojo.Bank bankObj = new m.Bank().getBy(bank);
//
//                    String cNo = tblCheque.getValueAt(i, 1).toString();
//                    double cAmount = Double.parseDouble(tblCheque.getValueAt(i, 2).toString());
//
//                    ChequeDetails chequeDetails = new pojo.ChequeDetails();
//                    chequeDetails.setCheckno(cNo);
//                    chequeDetails.setBank(bankObj);
//                    chequeDetails.setMoneyBook(moneyBookCheque);
//                    chequeDetails.setChequeAmount(cAmount);
//                    String checksave = new m.Cheques().save(chequeDetails);
//                    System.out.println(checksave + "saved chequesss");
//                }
//
//                CusCredit cusCredit = new pojo.CusCredit();
//                cusCredit.setDate(DateChooser);
//                cusCredit.setAmount(amount);
//                cusCredit.setCustomer(customerObj);
//                cusCredit.setType(2);
//                new m.CusCredit().save(cusCredit);
//                System.out.println("credit saved");
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void credit(Date DateChooser, JLabel lblBalance, String Customer, JLabel lblmsg, JLabel CusCredit) {
//        try {
//
//            customerObj = new m.Customer().getByFnameS(Customer);
//            balance = getRoundDouble(Double.parseDouble(lblBalance.getText()));
//            double cuscredit = getRoundDouble(Double.parseDouble(CusCredit.getText()));
//            if (balance > 0) {
//                CusCredit cusCredit = new pojo.CusCredit();
//                cusCredit.setDate(DateChooser);
//                cusCredit.setAmount(balance);
//                cusCredit.setCustomer(customerObj);
//                cusCredit.setType(1);
//                new m.CusCredit().save(cusCredit);
//                System.out.println("credit saved");
//
//                Double credit = customerObj.getCredit();
//                Double newcredit = credit + balance;
//                customerObj.setCredit(newcredit);
//                String update = new m.Customer().update(customerObj);
//                System.out.println("custone credit update" + update);
//
//            } else if (balance < 0 && cuscredit != 0.0) {
//                System.out.println("-------------" + balance);
//                int confirm = JOptionPane.showConfirmDialog(null, "Do You want to pay customer Credit");
//                System.out.println(confirm);
//                System.out.println("0++" + balance);
//                if (confirm == 0) {
//                    if (balance < cuscredit) {
//                        Double newbalance = -1 * balance;
//                        Double credit = customerObj.getCredit();
//                        Double newcredit = cuscredit - newbalance;
//                        customerObj.setCredit(newcredit);
//                        new m.Customer().update(customerObj);
//                        System.out.println("updeate Customer Credit if hava");
//
//                        CusCredit cusCredit = new pojo.CusCredit();
//                        cusCredit.setDate(DateChooser);
//                        cusCredit.setAmount(newbalance);
//                        cusCredit.setCustomer(customerObj);
//                        cusCredit.setType(1);
//                        new m.CusCredit().save(cusCredit);
//                        System.out.println("credit saved****");
//
//                    }
//                    if (balance > cuscredit) {
//                        Double newbalance = -1 * balance;
//                        Double credit = customerObj.getCredit();
//                        Double newcredit = newbalance - cuscredit;
//                        customerObj.setCredit(newcredit);
//                        new m.Customer().update(customerObj);
//                        System.out.println("updeate Customer Credit if hava");
//
//                        CusCredit cusCredit = new pojo.CusCredit();
//                        cusCredit.setDate(DateChooser);
//                        cusCredit.setAmount(cuscredit);
//                        cusCredit.setCustomer(customerObj);
//                        cusCredit.setType(1);
//                        new m.CusCredit().save(cusCredit);
//                        System.out.println("credit saved+++++");
//                    }
//                } else if (confirm == 1) {
//
//                }
//
//            }
//            {
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    public void addToChequeTbl(JComboBox<String> cmbBank, JTextField tfChequeNo, JTextField tfChequeAmount, JTextField tfChequeNo0, JTable tblCheque, double bill, double cheque, double chequeTot, double balance, JLabel lblChequePayTot, JLabel lblBalance, JTextField tfChequeAmount0) {
//        try {
//            if (cmbBank.getSelectedIndex() != 0) {
//                if (!tfChequeNo.getText().isEmpty()) {
//                    if (!tfChequeAmount.getText().isEmpty()) {
//                        DefaultTableModel dtm = (DefaultTableModel) tblCheque.getModel();
//                        Vector v = new Vector();
//                        v.add(cmbBank.getSelectedItem());
//                        v.add(tfChequeNo.getText());
//                        v.add(tfChequeAmount.getText());
//                        dtm.addRow(v);
//
//                        if (balance == 0.00) {
//                            double newbal = bill - cheque;
//                            double newcashtot = chequeTot + cheque;
//                            lblChequePayTot.setText(String.valueOf(getRoundDouble(newcashtot)));
//                            lblBalance.setText(String.valueOf(getRoundDouble(newbal)));
//                            tfChequeAmount.setText(null);
//
//                        } else if (balance > 0) {
//                            double newbal = balance - cheque;
//                            double newcashtot = chequeTot + cheque;
//                            lblChequePayTot.setText(String.valueOf(getRoundDouble(newcashtot)));
//                            lblBalance.setText(String.valueOf(getRoundDouble(newbal)));
//                            tfChequeAmount.setText(null);
//                        }
//
//                    } else {
//                        c.Errormzg.displayconfirmMessage("OOOPS!.., ENTER CHEQUE AMOUNT");
//                    }
//                } else {
//                    c.Errormzg.displayconfirmMessage("ENTER CHEQUE NO !!!");
//                }
//            } else {
//                c.Errormzg.displayconfirmMessage("SELECT BANK");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
