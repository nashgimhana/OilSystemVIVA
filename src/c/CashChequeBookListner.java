/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import m.AssetStatus;
import m.Customer;
import m.RouteReg;
import m.Supplier;
import pojo.Bank;
import pojo.Cheques;
import pojo.DealCategory;
import pojo.DealType;
import pojo.MoneyBook;
import v.Cash_Check_Book;
import v.ShowBankDetails;

/**
 *
 * @author suhada
 */
public class CashChequeBookListner extends MouseAdapter implements ComponentListener, KeyListener, FocusListener {

    private static CashChequeBookListner CashChequeBookListner = null;

    public static CashChequeBookListner getInstance() {
        if (CashChequeBookListner == null) {
            CashChequeBookListner = new CashChequeBookListner();
        }
        return CashChequeBookListner;
    }

    private v.Cash_Check_Book Cash_Check_Book;

    public boolean setCash_Check_Book(Cash_Check_Book Cash_Check_Book) {
        this.Cash_Check_Book = Cash_Check_Book;
        if (this.Cash_Check_Book != null) {
            return true;
        } else {
            return false;
        }
    }

    private Date cashDealDate = null, chequeDealDate = null, searchDateOn = null, searchDateFrom = null, searchDateTo = null;
    private String cashDescrip = "", chequDescrip = "", chequeNumber = "";
    private double cashAmount = -1, chequeAmount = -1;
    private JTable tbl = null;
    private JList listDealType = null;
    private JList listDealCategory = null;
    private JList listBank = null;
    private JLabel msg = null;
    private DealCategory dealCategory = null;
    private DealType dealType = null;
    private Bank bank = null;

    public void setMsg(JLabel msg) {
        this.msg = msg;
    }

    private JLabel getMsg() {
        return msg;
    }

    public boolean setTbl(JTable tbl) {
        this.tbl = tbl;
        if (this.tbl != null) {
            return true;
        } else {
            return false;
        }
    }

    private JTable getTbl() {
        return tbl;
    }

    public boolean setSearchDateOn(Date date) {
        this.searchDateOn = date;
        if (this.searchDateOn != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setSearchDateFrom(Date date) {
        this.searchDateFrom = date;
        if (this.searchDateFrom != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setSearchDateTo(Date date3) {
        this.searchDateTo = date3;
        if (this.searchDateTo != null) {
            return true;
        } else {
            return false;
        }
    }

    public Date getSearchDateOn() {
        return this.searchDateOn;
    }

    public Date getSearchDateFrom() {
        return this.searchDateFrom;
    }

    public Date getSearchDateTo() {
        return this.searchDateTo;
    }

    public boolean setCashDealDate(Date cashDealDate) {
        this.cashDealDate = cashDealDate;
        if (this.cashDealDate != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setChequeDealDate(Date chequeDealDate) {
        this.chequeDealDate = cashDealDate;
        if (this.chequeDealDate != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setDealCategory(DealCategory dealCategory) {
        this.dealCategory = dealCategory;
        if (this.dealCategory != null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setDealType(DealType dealType) {
        this.dealType = dealType;
        if (this.dealType != null) {
            return true;
        } else {
            return false;
        }
    }

    public void setCashDescrip(String cashDescrip) {
        this.cashDescrip = cashDescrip;
    }

    public void setChequeDescrip(String chequDescrip) {
        this.chequDescrip = chequDescrip;
    }

    public boolean setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
        if (this.cashAmount > -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setChequeAmount(double chequeAmount) {
        this.chequeAmount = chequeAmount;
        if (this.chequeAmount > -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setChequeNumber(String number) {
        this.chequeNumber = number;
        if (!this.chequeNumber.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setBank(Bank bank) {
        this.bank = bank;
        if (this.bank != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            if (this.Cash_Check_Book != null) {
                // Search cash deals by date
                if (e.getSource() == this.Cash_Check_Book.btn_cash_search_bydate) {
                    this.searchDateOn = this.Cash_Check_Book.jdc_cash_date.getDate();
                    boolean cashincome = this.Cash_Check_Book.jcb_income_cash.isSelected();
                    boolean cashexpend = this.Cash_Check_Book.jcb_expend_cash.isSelected();
                    this.msg = this.Cash_Check_Book.lbl_message_cash;
                    this.tbl = this.Cash_Check_Book.tbl_cash;
                    if (this.searchDateOn != null) {
                        if (cashincome && cashexpend) {
                            loadCashExpendByDate(this.searchDateOn);
                        } else if (cashincome) {
                            loadCashIncomeByDate(this.searchDateOn);
                        } else if (cashexpend) {
                            loadCashExpendByDate(this.searchDateOn);
                        }
                    } else {
                        JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Enter Date", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } // Search cash deals by date range
                else if (e.getSource() == this.Cash_Check_Book.btn_cash_search_range) {
                    this.searchDateFrom = this.Cash_Check_Book.jdc_cash_from.getDate();
                    this.searchDateTo = this.Cash_Check_Book.jdc_cash_to.getDate();
                    boolean cashincome = this.Cash_Check_Book.jcb_income_cash.isSelected();
                    boolean cashexpend = this.Cash_Check_Book.jcb_expend_cash.isSelected();
                    this.msg = this.Cash_Check_Book.lbl_message_cash;
                    this.tbl = this.Cash_Check_Book.tbl_cash;
                    if (this.searchDateFrom != null) {
                        if (this.searchDateTo != null) {
                            if (cashincome && cashexpend) {
                                loadCashDealsByDateRange(this.searchDateFrom, this.searchDateTo);
                            } else if (cashincome) {
                                loadCashIncomeByDateRange(this.searchDateFrom, this.searchDateTo);
                            } else if (cashexpend) {
                                loadCashExpendByDateRange(this.searchDateFrom, this.searchDateTo);
                            }
                        } else {
                            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Please Enter Date", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Please Enter Date", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } // Add deal types
                else if (e.getSource() == this.Cash_Check_Book.btn_dealtype) {
                    String type = this.Cash_Check_Book.txt_dealtype.getText();
                    String cate = this.Cash_Check_Book.cmb_dealcategory.getSelectedItem().toString();
                    this.msg = this.Cash_Check_Book.lbl_message_setup;
                    if (!type.isEmpty()) {
                        if (!cate.isEmpty()) {
                            String addToDealType = addToDealType(type, cate);
                            if (addToDealType.equalsIgnoreCase("done")) {
                                loadDealTypeToList(this.Cash_Check_Book.list_dealtype);
                                clearSetup();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this.Cash_Check_Book, "Select a deal category", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this.Cash_Check_Book, "Enter deal type", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } // Add deal category
                else if (e.getSource() == this.Cash_Check_Book.btn_add_dealcategory) {
                    String type = this.Cash_Check_Book.txt_dealcategory.getText();
                    this.msg = this.Cash_Check_Book.lbl_message_setup;
                    if (!type.isEmpty()) {
                        addToDealCategory(type);
                        loadDealCategoryToList(this.Cash_Check_Book.list_dealcategory);
                        loadDealCategoryToCombo(this.Cash_Check_Book.cmb_dealcategory);
                    } else {
                        JOptionPane.showMessageDialog(this.Cash_Check_Book, "Enter deal category", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } // Add cash deals
                else if (e.getSource() == this.Cash_Check_Book.btn_add_cash_deal) {
                    try {
                        if (setCashDealDate(this.Cash_Check_Book.jdc_cash_dealdate.getDate())) {
                            if (setDealType(new m.DealType().getByName(this.Cash_Check_Book.cmb_cash_dealtype.getSelectedItem().toString()))) {
                                if (setCashAmount(Double.parseDouble(m.ValueValidation.getInstance().toDeciaml(Double.parseDouble(this.Cash_Check_Book.txt_cash_amount.getText()), 2)))) {
                                    if (setDealCategory(new m.DealCategory().getByName(this.Cash_Check_Book.cmb_cash_dealcategory.getSelectedItem().toString()))) {

                                        this.cashDescrip = this.Cash_Check_Book.jta_cash_descrip.getText();
                                        addCashDeal();
                                        clearCashDeal();
                                    } else {
                                        JOptionPane.showMessageDialog(this.Cash_Check_Book, "Select deal category", "Warning", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this.Cash_Check_Book, "Please enter amount", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this.Cash_Check_Book, "Select deal type", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this.Cash_Check_Book, "Please enter date", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Please check numbers again", "Warning", JOptionPane.WARNING_MESSAGE);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Somethin went wrong. Try again", "Error", JOptionPane.WARNING_MESSAGE);
                    }
                } // Add cheque deals
                else if (e.getSource() == this.Cash_Check_Book.btn_add_chequedeal) {
                    if (setChequeDealDate(this.Cash_Check_Book.jdc_cheque_dealdate.getDate())) {
                        if (setDealType(new m.DealType().getByName(this.Cash_Check_Book.cmb_cheque_dealtype.getSelectedItem().toString()))) {
                            if (setChequeAmount(Double.parseDouble(m.ValueValidation.getInstance().toDeciaml(Double.parseDouble(this.Cash_Check_Book.txt_cheque_amount.getText()), 2)))) {
                                if (setDealCategory(new m.DealCategory().getByName(this.Cash_Check_Book.cmb_cheque_dealcategory.getSelectedItem().toString()))) {
                                    if (setChequeNumber(this.Cash_Check_Book.txt_cheque_number.getText())) {
                                        if (setBank(new m.Bank().getBy(this.Cash_Check_Book.cmb_bank.getSelectedItem().toString()))) {
                                            setChequeDescrip(this.Cash_Check_Book.jta_cheque_descrip.getText());
                                            if (addChequeDeal().equalsIgnoreCase("done")) {
                                                clearCashDeal();
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(this.Cash_Check_Book, "Select the bank", "Warning", JOptionPane.WARNING_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this.Cash_Check_Book, "Enter cheque type", "Warning", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this.Cash_Check_Book, "Select deal category", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this.Cash_Check_Book, "Please enter amount", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this.Cash_Check_Book, "Select deal type", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this.Cash_Check_Book, "Please enter date", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } // proceed cheque
                else if (e.getSource() == this.Cash_Check_Book.btn_add_chequedeal) {
                    if (setChequeDealDate(this.Cash_Check_Book.jdc_cheque_dealdate.getDate())) {
                        if (setDealType(new m.DealType().getByName(this.Cash_Check_Book.cmb_cheque_dealtype.getSelectedItem().toString()))) {
                            if (setChequeAmount(Double.parseDouble(m.ValueValidation.getInstance().toDeciaml(Double.parseDouble(this.Cash_Check_Book.txt_cheque_amount.getText()), 2)))) {
                                if (setDealCategory(new m.DealCategory().getByName(this.Cash_Check_Book.cmb_cheque_dealcategory.getSelectedItem().toString()))) {
                                    if (setChequeNumber(this.Cash_Check_Book.txt_cheque_number.getText())) {
                                        if (setBank(new m.Bank().getBy(this.Cash_Check_Book.cmb_bank.getSelectedItem().toString()))) {
                                            setChequeDescrip(this.Cash_Check_Book.jta_cheque_descrip.getText());
                                            if (proceedChequeDeal().equalsIgnoreCase("done")) {
                                                clearCashDeal();
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(this.Cash_Check_Book, "Select the bank", "Warning", JOptionPane.WARNING_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(this.Cash_Check_Book, "Enter cheque type", "Warning", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(this.Cash_Check_Book, "Select deal category", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(this.Cash_Check_Book, "Please enter amount", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this.Cash_Check_Book, "Select deal type", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this.Cash_Check_Book, "Please enter date", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } // Add bank
                else if (e.getSource() == this.Cash_Check_Book.btn_add_bank) {
                    try {
                        String name = this.Cash_Check_Book.txt_bank.getText();
                        double amount = Double.parseDouble(this.Cash_Check_Book.txt_bank_amount.getText());
                        String addBank = addBank(name, amount);
                        if (addBank.equalsIgnoreCase("done")) {
                            loadBankToTable(this.Cash_Check_Book.tbl_setup_bank_list);
                            clearSetup();
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this.Cash_Check_Book, "Enter valide number", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (e.getSource() == this.Cash_Check_Book.btn_add_cash_capital) {
                    try {
                        if (!this.Cash_Check_Book.txt_capital_cash.getText().equals("")) {
                            double amount = Double.parseDouble(this.Cash_Check_Book.txt_capital_cash.getText());
                            AssetStatus assetStatus = new m.AssetStatus();
                            System.out.println(amount);
                            pojo.AssetStatus Cash = assetStatus.getById(1);
                            if (amount > 0) {
                                MoneyBook moneyBook = new pojo.MoneyBook();
                                moneyBook.setDate(new Date());
                                if (Cash.getAmount() > amount) {// reduce
                                    moneyBook.setDealType(new m.DealType().getBy(14));
                                    moneyBook.setDealCategory(new m.DealCategory().getBy(2));
                                    moneyBook.setDscription("Reduce money(cash) asset");
                                    moneyBook.setAmount(Cash.getAmount() - amount);
                                    Cash.setAmount(amount);
                                    assetStatus.updateAssetStatus(Cash);
                                    new m.MoneyBook().save(moneyBook);
                                } else if (Cash.getAmount() < amount) {// increase
                                    moneyBook.setDealType(new m.DealType().getBy(15));
                                    moneyBook.setDealCategory(new m.DealCategory().getBy(1));
                                    moneyBook.setDscription("Increase money(cash) asset");
                                    moneyBook.setAmount(amount - Cash.getAmount());
                                    Cash.setAmount(amount);
                                    assetStatus.updateAssetStatus(Cash);
                                    new m.MoneyBook().save(moneyBook);
                                } else if (Cash.getAmount() == amount) {

                                }
                                loadAssetCash(this.Cash_Check_Book.lbl_cash_capital);
                                this.Cash_Check_Book.txt_capital_cash.setText("");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Enter value", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Enter valide number", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } // tranfer money from cash
                else if (e.getSource() == this.Cash_Check_Book.btn_trans_cash_transfer) {
                    try {
                        if (!this.Cash_Check_Book.txt_trans_cash_amount.getText().equals("")) {
                            if (this.Cash_Check_Book.jdc_trans_cash_date.getDate() != null) {
                                if (!this.Cash_Check_Book.cmb_trans_cash_bank.getSelectedItem().toString().equalsIgnoreCase("select")) {
                                    Date date = this.Cash_Check_Book.jdc_trans_cash_date.getDate();
                                    double amount = Double.parseDouble(this.Cash_Check_Book.txt_trans_cash_amount.getText());
                                    String bank = this.Cash_Check_Book.cmb_trans_cash_bank.getSelectedItem().toString();
                                    Bank Bank = new m.Bank().getBy(bank);
                                    if (Bank != null) {
                                        int showConfirmDialog = JOptionPane.showConfirmDialog(this.Cash_Check_Book, "Do you want to transfer money to " + Bank.getBank(), "Transfer", JOptionPane.YES_NO_OPTION);
                                        if (showConfirmDialog == 0) {
                                            MoneyBook moneyBook = new pojo.MoneyBook();
                                            moneyBook.setDate(date);
                                            moneyBook.setAmount(amount);
                                            moneyBook.setDscription("Transfer to " + Bank.getBank());
                                            moneyBook.setDealCategory(new m.DealCategory().getBy(2));
                                            moneyBook.setDealType(new m.DealType().getBy(27));
                                            String save = new m.MoneyBook().save(moneyBook);
                                            if (save.equalsIgnoreCase("done")) {
                                                c.AssetControl.getInstance().updateCashAsset(amount, '-');
                                                MoneyBook moneyBook2 = new pojo.MoneyBook();
                                                moneyBook2.setDate(date);
                                                moneyBook2.setAmount(amount);
                                                moneyBook2.setDscription("Transfered from cash");
                                                moneyBook2.setDealCategory(new m.DealCategory().getBy(1));
                                                moneyBook2.setDealType(new m.DealType().getBy(27));
                                                String save2 = new m.MoneyBook().save(moneyBook2);
                                                if (save2.equalsIgnoreCase("done")) {
                                                    String updateBankAsset = c.AssetControl.getInstance().updateBankAsset(bank, amount, '+');
                                                    if (updateBankAsset.equalsIgnoreCase("done")) {
                                                        JOptionPane.showMessageDialog(null, "Tranfer Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                        this.Cash_Check_Book.txt_trans_cash_amount.setText("");
                                                        this.Cash_Check_Book.cmb_trans_cash_bank.setSelectedItem("Select");
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Transfer Updating Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Transfer Saving Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Transfer Saving Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                                            }
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Not Found Bank", "Warning", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please Select Bank", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Please Select Date", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please Enter Amount", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valide Number", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } // transfer money from bank to bank
                else if (e.getSource() == this.Cash_Check_Book.btn_trans_bank_transfer) {
                    try {
                        if (!this.Cash_Check_Book.txt_trans_bank_amount.getText().equals("")) {
                            if (this.Cash_Check_Book.jdc_trans_bank_date.getDate() != null) {
                                if (!this.Cash_Check_Book.cmb_trans_bank_bankfrom.getSelectedItem().toString().equalsIgnoreCase("select")) {
                                    if (!this.Cash_Check_Book.cmb_trans_bank_bankto.getSelectedItem().toString().equalsIgnoreCase("select")) {
                                        Date date = this.Cash_Check_Book.jdc_trans_bank_date.getDate();
                                        double amount = Double.parseDouble(this.Cash_Check_Book.txt_trans_bank_amount.getText());
                                        String bankF = this.Cash_Check_Book.cmb_trans_bank_bankfrom.getSelectedItem().toString();
                                        String bankT = this.Cash_Check_Book.cmb_trans_bank_bankto.getSelectedItem().toString();
                                        Bank BankFrom = new m.Bank().getBy(bankF);
                                        Bank BankTo = new m.Bank().getBy(bankT);
                                        if (BankFrom != null) {
                                            if (BankTo != null) {
                                                int showConfirmDialog = JOptionPane.showConfirmDialog(this.Cash_Check_Book, "Do you want to transfer money from " + BankFrom.getBank() + " to " + BankTo.getBank(), "Transfer", JOptionPane.YES_NO_OPTION);
                                                if (showConfirmDialog == 0) {
                                                    MoneyBook moneyBook = new pojo.MoneyBook();
                                                    moneyBook.setDate(date);
                                                    moneyBook.setAmount(amount);
                                                    moneyBook.setDscription("Transfer to " + BankTo.getBank());
                                                    moneyBook.setDealCategory(new m.DealCategory().getBy(2));
                                                    moneyBook.setDealType(new m.DealType().getBy(28));
                                                    String save = new m.MoneyBook().save(moneyBook);
                                                    if (save.equalsIgnoreCase("done")) {
                                                        c.AssetControl.getInstance().updateBankAsset(bankF, amount, '-');
                                                        MoneyBook moneyBook2 = new pojo.MoneyBook();
                                                        moneyBook2.setDate(date);
                                                        moneyBook2.setAmount(amount);
                                                        moneyBook2.setDscription("Transfer from " + BankFrom.getBank());
                                                        moneyBook2.setDealCategory(new m.DealCategory().getBy(1));
                                                        moneyBook2.setDealType(new m.DealType().getBy(29));
                                                        String save2 = new m.MoneyBook().save(moneyBook2);
                                                        if (save2.equalsIgnoreCase("done")) {
                                                            String updateBankAsset = c.AssetControl.getInstance().updateBankAsset(bankT, amount, '+');
                                                            if (updateBankAsset.equalsIgnoreCase("done")) {
                                                                JOptionPane.showMessageDialog(null, "Tranfer Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
                                                                this.Cash_Check_Book.txt_trans_bank_amount.setText("");
                                                                this.Cash_Check_Book.cmb_trans_bank_bankfrom.setSelectedItem("Select");
                                                                this.Cash_Check_Book.cmb_trans_bank_bankto.setSelectedItem("Select");
                                                            } else {
                                                                JOptionPane.showMessageDialog(null, "Transfer Updating Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                                                            }
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Bank Transfer Saving Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Bank Transfer Saving Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                                                    }
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Not Found Bank", "Warning", JOptionPane.WARNING_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Not Found Bank", "Warning", JOptionPane.WARNING_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Please Select Bank", "Warning", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please Select Bank", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Please Select Date", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please Enter amount", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please Enter Valide Number", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (e.getSource() == this.Cash_Check_Book.tbl_setup_bank_list) {
                    this.Cash_Check_Book.txt_bank.setText(this.Cash_Check_Book.tbl_setup_bank_list.getValueAt(this.Cash_Check_Book.tbl_setup_bank_list.getSelectedRow(), 0).toString());
                    this.Cash_Check_Book.txt_bank_amount.setText(this.Cash_Check_Book.tbl_setup_bank_list.getValueAt(this.Cash_Check_Book.tbl_setup_bank_list.getSelectedRow(), 1).toString());
                } // proceed cheque
                else if (e.getSource() == this.Cash_Check_Book.btn_proceed) {
                    int selectedRow = this.Cash_Check_Book.tbl_cheque.getSelectedRow();
                    System.out.println(selectedRow);
                    if (selectedRow > -1) {
                        String chequeNo = (String) this.Cash_Check_Book.tbl_cheque.getValueAt(selectedRow, 1);
                        Cheques cheque = new m.Cheques().getByChequeNumber(chequeNo);
                        if (cheque != null) {
                            String[] split = cheque.getDiscription().split("/");
                            Bank Bank = new m.Bank().getBy(this.Cash_Check_Book.cmb_chequebook_bank.getSelectedItem().toString());
                            if (Bank != null) {
                                int val = 0;
                                if (split[0].equalsIgnoreCase("routereg")) {
                                    val =new c.RouteDebitMoneyBook().routeCheckProceed(Integer.parseInt(split[1]), chequeNo, cheque.getChequeAmount(), Bank.getId());
                                } else if (split[0].equalsIgnoreCase("supplier")) {
                                    val =new c.grncashcontroller().supliercheckproceed(Integer.parseInt(split[1]), chequeNo, cheque.getChequeAmount(), Bank.getId());
                                } else if (split[0].equalsIgnoreCase("cash")) {
                                    val =c.CashChequeBookListner.getInstance().proceedCheque(chequeNo, Bank.getId());
                                } else if (split[0].equalsIgnoreCase("customer")) {
                                    val =new c.invpayment().customercheckproceed(Integer.parseInt(split[1]), chequeNo, cheque.getChequeAmount(), Bank.getId());
                                }
                                if (val == 1) {
                                    JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Cheque Proceed Success", "Message", JOptionPane.INFORMATION_MESSAGE);
                                    if(this.Cash_Check_Book.tbl_cheque.getRowCount()==1){
                                        ((DefaultTableModel)this.Cash_Check_Book.tbl_cheque.getModel()).setRowCount(0);
                                    }else
                                        loadPendingCheques(this.Cash_Check_Book.tbl_cheque);
                                } else {
                                    JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Cheque Proceed Fail", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Please select bank", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Not Found Cheque", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Please Select a Cheque", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else if (e.getSource() == this.Cash_Check_Book.btn_returncheque) {
                    int selectedRow = this.Cash_Check_Book.tbl_cheque.getSelectedRow();
                    if (selectedRow > -1) {
                        String chequeNumber = (String) this.Cash_Check_Book.tbl_cheque.getValueAt(selectedRow, 1);
                        if (this.returnCheque(chequeNumber).equalsIgnoreCase("done")) {
                            if(this.Cash_Check_Book.tbl_cheque.getRowCount()==1){
                               ((DefaultTableModel)this.Cash_Check_Book.tbl_cheque.getModel()).setRowCount(0);
                            }else
                                loadPendingCheques(this.Cash_Check_Book.tbl_cheque);
                        }
                    } else if (e.getSource() == this.Cash_Check_Book.tbl_bank_current_status) {
                        int selectedBank = this.Cash_Check_Book.tbl_bank_current_status.getSelectedRow();
                        if(selectedBank>-1){
                            String bankName = this.Cash_Check_Book.tbl_bank_current_status.getValueAt(selectedBank, 1).toString();
                            ShowBankDetails ShowBankDetails = v.ShowBankDetails.getInstance();
                            ShowBankDetails.bankName=bankName;
                            ShowBankDetails.setVisible(true);
                        }
                    }else {
                        JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Please Select a Cheque", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Somethin went wrong. Try again.", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Bot Found View", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Something went wrong. Try again.");
            ex.printStackTrace();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == this.Cash_Check_Book.txt_cash_amount) {
            if (!m.ValueValidation.getInstance().isPrice(e.getKeyChar(), ((JTextField) e.getSource()).getText())) {
                e.consume();
            }
        } else if (e.getSource() == this.Cash_Check_Book.txt_cheque_amount) {
            if (!m.ValueValidation.getInstance().isPrice(e.getKeyChar(), ((JTextField) e.getSource()).getText())) {
                e.consume();
            }
        } else if (e.getSource() == this.Cash_Check_Book.txt_capital_cash) {
            m.ValueValidation.getInstance().onlyNumber(e);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {
        if (this.Cash_Check_Book != null) {
            // cash tab
            if (e.getSource() == this.Cash_Check_Book.tab_cash) {
                this.msg = this.Cash_Check_Book.lbl_message_cash;
                this.tbl = this.Cash_Check_Book.tbl_cash;
                loadCashBookWithInMonth();
            } // cheque tab
            else if (e.getSource() == this.Cash_Check_Book.tab_cheque) {
                loadPendingCheques(this.Cash_Check_Book.tbl_cheque);
                loadBankToCombo(this.Cash_Check_Book.cmb_chequebook_bank);
            } // setup tab
            else if (e.getSource() == this.Cash_Check_Book.tab_setup) {
                this.msg = this.Cash_Check_Book.lbl_message_setup;
                loadDealTypeToList(this.Cash_Check_Book.list_dealtype);
                loadDealCategoryToList(this.Cash_Check_Book.list_dealcategory);
                loadDealCategoryToCombo(this.Cash_Check_Book.cmb_dealcategory);
                loadBankToTable(this.Cash_Check_Book.tbl_setup_bank_list);
                loadAssetCash(this.Cash_Check_Book.lbl_cash_capital);
            } // cash deal tab
            else if (e.getSource() == this.Cash_Check_Book.tab_cashdeal) {
                loadDealTypeToCombo(this.Cash_Check_Book.cmb_cash_dealtype);
                loadDealCategoryToCombo(this.Cash_Check_Book.cmb_cash_dealcategory);
            } // cheque deal tab
            else if (e.getSource() == this.Cash_Check_Book.tab_chequedeal) {
                loadDealTypeToCombo(this.Cash_Check_Book.cmb_cheque_dealtype);
                loadDealCategoryToCombo(this.Cash_Check_Book.cmb_cheque_dealcategory);
                loadBankToCombo(this.Cash_Check_Book.cmb_bank);
            } // summory tab
            else if (e.getSource() == this.Cash_Check_Book.tab_summory) {
                this.tbl = this.Cash_Check_Book.tbl_summory;
                //loadBalanceSheet(this.Cash_Check_Book.tbl_balance_sheet);
                loadCashSummory();
                loadSummoryOfLast7();
                loadSupplierSummory();
                loadCustomerSummory();
                loadRouteSummory();
                loadBankSummory();
                loadFinalizedStatus();
            } // deal log tab
            else if (e.getSource() == this.Cash_Check_Book.tab_deallog) {
                loadDealTypeToCombo(this.Cash_Check_Book.cmb_cash_dealtype);
                loadDealCategoryToCombo(this.Cash_Check_Book.cmb_cash_dealcategory);
                loadDealTypeToCombo(this.Cash_Check_Book.cmb_cheque_dealtype);
                loadDealCategoryToCombo(this.Cash_Check_Book.cmb_cheque_dealcategory);
                loadBankToCombo(this.Cash_Check_Book.cmb_bank);
            } // deal types transfer
            else if (e.getSource() == this.Cash_Check_Book.tab_transfer) {
                loadBankToCombo(this.Cash_Check_Book.cmb_trans_bank_bankfrom);
                loadBankToCombo(this.Cash_Check_Book.cmb_trans_bank_bankto);
                loadBankToCombo(this.Cash_Check_Book.cmb_trans_cash_bank);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e.getSource() == this.Cash_Check_Book.jdc_cash_date) {
            this.Cash_Check_Book.jdc_cash_from.setDate(null);
            this.Cash_Check_Book.jdc_cash_to.setDate(null);
        } else if (e.getSource() == this.Cash_Check_Book.jdc_cash_from || e.getSource() == this.Cash_Check_Book.jdc_cash_to) {
            this.Cash_Check_Book.jdc_cash_date.setDate(null);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    private void clearCashDeal() {
        this.Cash_Check_Book.jdc_cash_dealdate.setDate(null);
        this.Cash_Check_Book.cmb_cash_dealtype.setSelectedIndex(0);
        this.Cash_Check_Book.jta_cash_descrip.setText("");
        this.Cash_Check_Book.txt_cash_amount.setText("");
        this.Cash_Check_Book.cmb_cash_dealcategory.setSelectedIndex(0);
    }

    private void clearChequeDeal() {
        this.Cash_Check_Book.jdc_cheque_dealdate.setDate(null);
        this.Cash_Check_Book.cmb_cheque_dealtype.setSelectedIndex(0);
        this.Cash_Check_Book.jta_cheque_descrip.setText("");
        this.Cash_Check_Book.txt_cheque_amount.setText("");
        this.Cash_Check_Book.cmb_cheque_dealcategory.setSelectedIndex(0);
        this.Cash_Check_Book.txt_cheque_number.setText("");
    }

    private void clearSetup() {
        this.Cash_Check_Book.txt_dealcategory.setText("");
        this.Cash_Check_Book.txt_dealtype.setText("");
        this.Cash_Check_Book.txt_bank.setText("");
        this.Cash_Check_Book.txt_bank_amount.setText("");
    }

    private void showMessage(boolean status, JLabel lbl, String msg, int width, int height, Color color) {
        if (color == null) {
            color = Color.BLACK;
        }
        if (lbl != null) {
            if (status) {
                lbl.setText(msg);
                lbl.setForeground(color);
                lbl.setSize(width, height);
                lbl.repaint();
            } else {
                lbl.setText("");
                lbl.setSize(0, 0);
                lbl.setForeground(Color.BLACK);
            }
        }
    }

    private void loadSummoryOfLast7() {
        if (this.Cash_Check_Book != null) {
            DefaultTableModel dtm = (DefaultTableModel) this.Cash_Check_Book.tbl_summory.getModel();
            dtm.setRowCount(0);
            dtm.setColumnCount(0);
            m.MoneyBook moneyBook = new m.MoneyBook();
            dtm.addColumn("");
            Vector v1 = new Vector();
            Vector v2 = new Vector();
            v1.add("Income");
            v2.add("Expend");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date today = new Date();
            for (int i = 0; i < 7; i++) {
                Date date = new Date(today.getTime() - (1000 * 60 * 60 * 24 * i));
                dtm.addColumn(sdf.format(date));
                v1.add(m.ValueValidation.getInstance().toDeciaml(moneyBook.getTotalIncomeBy(date), 2));
                v2.add(m.ValueValidation.getInstance().toDeciaml(moneyBook.getTotalExpendBy(date), 2));
            }
            dtm.addRow(v1);
            dtm.addRow(v2);
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCashBookWithInMonth() {
        try {
            Cash_Check_Book instance = v.Cash_Check_Book.getInstance();
            if (instance != null) {
                showMessage(true, this.msg, "Please wait...", 350, 22, Color.BLACK);
                Date today = new Date();
                List<pojo.MoneyBook> list = new m.MoneyBook().getAllBy(new Date(today.getTime() - (1000 * 60 * 60 * 60 * 24 * 30)), today);
                if (list != null && !list.isEmpty()) {
                    DefaultTableModel dtm = (DefaultTableModel) this.tbl.getModel();
                    dtm.setRowCount(0);
                    m.DealType DealType = new m.DealType();
                    for (pojo.MoneyBook MoneyBook : list) {
                        Vector v = new Vector();
                        v.add(MoneyBook.getId());
                        v.add(MoneyBook.getDate());
                        v.add(DealType.getBy(MoneyBook.getDealType().getId()).getType());
                        v.add(MoneyBook.getDscription());
                        if (MoneyBook.getDealCategory().getId() == 1) {
                            v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                            v.add("");
                        } else if (MoneyBook.getDealCategory().getId() == 2) {
                            v.add("");
                            v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                        }
                        dtm.addRow(v);
                    }
                    showMessage(false, this.msg, "", 350, 0, Color.BLACK);
                } else {
                    showMessage(true, this.msg, "Not Found Any Cash Deals", 350, 22, Color.RED);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not Found Cash/Cheque Book", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadPendingCheques(JTable tbl) {
        try {
            List<Cheques> list_pendingCheques = new m.Cheques().getByStatus(0);
            if (list_pendingCheques != null && !list_pendingCheques.isEmpty()) {
                DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
                tbl.setRowHeight(22);
                tbl.setShowVerticalLines(false);
                tbl.setGridColor(c.View.getInstance().colorTheme);
                dtm.setRowCount(0);
                m.Bank bank = new m.Bank();
                m.DealType dealType = new m.DealType();
                DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
                Date today = new Date();
                for (Cheques Cheques : list_pendingCheques) {
                    Vector v = new Vector();
                    v.add(Cheques.getType());
                    v.add(Cheques.getCheckno());
                    v.add(bank.getBy(Cheques.getBank().getId()).getBank());
                    String des = "";
                    if (Cheques.getDiscription() != null) {
                        String[] split = Cheques.getDiscription().split("/");
                        des += split[0];
                    }
                    v.add(des);
                    v.add(Cheques.getChequeAmount());
                    v.add(Cheques.getChequeDate());
                    if (Cheques.getChequeDate() != null) {
                        v.add(today.compareTo(Cheques.getChequeDate()) == 0 ? "Must Proceed" : today.compareTo(Cheques.getChequeDate()) > 0 ? "Date Passed" : today.compareTo(Cheques.getChequeDate()) < 0 ? "Pending" : "");
                    } else {
                        v.add("Not Dated");
                    }
                    dtm.addRow(v);
                }
                colorizeTable(tbl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void colorizeTable(JTable tbl) {
        Color gl = new Color(102, 255, 153);
        Color gd = new Color(0, 204, 68);
        Color rl = new Color(255, 102, 102);
        Color ol = new Color(255, 163, 102);
        Color od = new Color(255, 117, 26);
        tbl.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component Component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                Component.setForeground(Color.WHITE);
                Component.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
                Date today = new Date();
                Date chequeDate = (Date) table.getValueAt(row, 5);
                if (((String) table.getValueAt(row, 0)).equalsIgnoreCase("+")) {
                    if (chequeDate.getTime() > today.getTime() && chequeDate.getTime() <= (today.getTime() + (1000 * 60 * 60 * 24 * 3))) {
                        Component.setBackground(gd);
                    } else if (chequeDate.getTime() < today.getTime()) {
                        Component.setBackground(rl);
                    } else {
                        Component.setBackground(gl);
                    }
                } else if (((String) table.getValueAt(row, 0)).equalsIgnoreCase("-")) {
                    if (chequeDate.getTime() > today.getTime() && chequeDate.getTime() <= (today.getTime() + (1000 * 60 * 60 * 24 * 3))) {
                        Component.setBackground(od);
                    } else if (chequeDate.getTime() < today.getTime()) {
                        Component.setBackground(rl);
                    } else {
                        Component.setBackground(ol);
                    }
                } else {
                    Component.setBackground(Color.black);
                }
                table.setSelectionForeground(Color.blue);
                return Component;
            }
        });
    }

    private String returnCheque(String chequeNo) {
        if (!chequeNo.equals("")) {
            m.Cheques cheques = new m.Cheques();
            Cheques cheque = cheques.getByChequeNumber(chequeNo);
            if (cheque != null) {
                cheque.setStatus(-1);
                String update = cheques.update(cheque);
                if (update.equalsIgnoreCase("done")) {
                    JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Return Success", "Message", JOptionPane.INFORMATION_MESSAGE);
                    return "done";
                } else {
                    JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Return Fail", "Message", JOptionPane.INFORMATION_MESSAGE);
                    return "not";
                }
            } else {
                JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Not Found Cheque", "Warning", JOptionPane.WARNING_MESSAGE);
                return "not";
            }
        } else {
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Not Found Cheque number", "Warning", JOptionPane.WARNING_MESSAGE);
            return "not";
        }
    }

    private void loadCashDealsByDate(Date date) {
        try {
            Cash_Check_Book instance = v.Cash_Check_Book.getInstance();
            if (instance != null) {
                showMessage(true, this.msg, "Please wait...", 350, 22, Color.RED);
                List<pojo.MoneyBook> list = new m.MoneyBook().getAllBy(date);
                if (list != null && !list.isEmpty()) {
                    DefaultTableModel dtm = (DefaultTableModel) this.tbl.getModel();
                    dtm.setRowCount(0);
                    m.DealType DealType = new m.DealType();
                    for (pojo.MoneyBook MoneyBook : list) {
                        Vector v = new Vector();
                        v.add(MoneyBook.getId());
                        v.add(MoneyBook.getDate());
                        v.add(DealType.getBy(MoneyBook.getDealType().getId()).getType());
                        v.add(MoneyBook.getDscription());
                        if (MoneyBook.getDealCategory().getId() == 1) {
                            v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                            v.add("");
                        } else if (MoneyBook.getDealCategory().getId() == 2) {
                            v.add("");
                            v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                        }
                        dtm.addRow(v);
                    }
                    showMessage(false, this.msg, "", 0, 0, null);
                } else {
                    showMessage(true, this.msg, "Not Found Any Cash Deals", 350, 22, Color.RED);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not Found Cash/Cheque Book", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCashIncomeByDate(Date date) {
        try {
            Cash_Check_Book instance = v.Cash_Check_Book.getInstance();
            if (instance != null) {
                showMessage(true, this.msg, "Please wait...", 350, 22, Color.BLACK);
                DealCategory DealCategory = new m.DealCategory().getBy(1);
                List<pojo.MoneyBook> list = new m.MoneyBook().getAllBy(date, DealCategory);
                if (list != null && !list.isEmpty()) {
                    DefaultTableModel dtm = (DefaultTableModel) this.tbl.getModel();
                    dtm.setRowCount(0);
                    m.DealType DealType = new m.DealType();
                    for (pojo.MoneyBook MoneyBook : list) {
                        Vector v = new Vector();
                        v.add(MoneyBook.getId());
                        v.add(MoneyBook.getDate());
                        v.add(DealType.getBy(MoneyBook.getDealType().getId()).getType());
                        v.add(MoneyBook.getDscription());
                        v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                        v.add("");
                        dtm.addRow(v);
                    }
                    showMessage(false, this.msg, "", 0, 0, null);
                } else {
                    showMessage(true, this.msg, "Not Found Any Cash Deals", 350, 22, Color.RED);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not Found Cash/Cheque Book", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCashExpendByDate(Date date) {
        try {
            Cash_Check_Book instance = v.Cash_Check_Book.getInstance();
            if (instance != null) {
                showMessage(true, this.msg, "Please wait...", 350, 22, Color.black);
                DealCategory DealCategory = new m.DealCategory().getBy(2);
                List<pojo.MoneyBook> list = new m.MoneyBook().getAllBy(date, DealCategory);
                if (list != null && !list.isEmpty()) {
                    DefaultTableModel dtm = (DefaultTableModel) this.tbl.getModel();
                    dtm.setRowCount(0);
                    m.DealType DealType = new m.DealType();
                    for (pojo.MoneyBook MoneyBook : list) {
                        Vector v = new Vector();
                        v.add(MoneyBook.getId());
                        v.add(MoneyBook.getDate());
                        v.add(DealType.getBy(MoneyBook.getDealType().getId()).getType());
                        v.add(MoneyBook.getDscription());
                        v.add("");
                        v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                        dtm.addRow(v);
                    }
                } else {
                    showMessage(true, this.msg, "Not Found Any Cash Deals", 350, 22, Color.RED);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not Found Cash/Cheque Book", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFinalizedStatus() {
        pojo.AssetStatus Cash = new m.AssetStatus().getById(1);
        //String print=
    }

    private void loadCashDealsByDateRange(Date from, Date to) {
        try {
            Cash_Check_Book instance = v.Cash_Check_Book.getInstance();
            if (instance != null) {
                showMessage(true, msg, "Please wait...", 350, 22, Color.RED);
                List<pojo.MoneyBook> list = new m.MoneyBook().getAllBy(from, to);
                if (list != null && !list.isEmpty()) {
                    DefaultTableModel dtm = (DefaultTableModel) this.tbl.getModel();
                    dtm.setRowCount(0);
                    m.DealType DealType = new m.DealType();
                    for (pojo.MoneyBook MoneyBook : list) {
                        Vector v = new Vector();
                        v.add(MoneyBook.getId());
                        v.add(MoneyBook.getDate());
                        v.add(DealType.getBy(MoneyBook.getDealType().getId()).getType());
                        v.add(MoneyBook.getDscription());
                        if (MoneyBook.getDealCategory().getId() == 1) {
                            v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                            v.add("");
                        } else if (MoneyBook.getDealCategory().getId() == 2) {
                            v.add("");
                            v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                        }
                        dtm.addRow(v);
                    }
                    showMessage(false, msg, "", 0, 0, null);
                } else {
                    showMessage(true, msg, "Not Found Any Cash Deals", 350, 22, Color.RED);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not Found Cash/Cheque Book", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCashIncomeByDateRange(Date from, Date to) {
        try {
            Cash_Check_Book instance = v.Cash_Check_Book.getInstance();
            if (instance != null) {
                showMessage(true, this.msg, "Please wait...", 350, 22, Color.BLACK);
                DealCategory DealCategory = new m.DealCategory().getBy(1);
                List<pojo.MoneyBook> list = new m.MoneyBook().getAllBy(from, to, DealCategory);
                if (list != null && !list.isEmpty()) {
                    DefaultTableModel dtm = (DefaultTableModel) this.tbl.getModel();
                    dtm.setRowCount(0);
                    m.DealType DealType = new m.DealType();
                    for (pojo.MoneyBook MoneyBook : list) {
                        Vector v = new Vector();
                        v.add(MoneyBook.getId());
                        v.add(MoneyBook.getDate());
                        v.add(DealType.getBy(MoneyBook.getDealType().getId()).getType());
                        v.add(MoneyBook.getDscription());
                        v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                        v.add("");
                        dtm.addRow(v);
                    }
                    showMessage(false, this.msg, "", 0, 0, null);
                } else {
                    showMessage(true, this.msg, "Not Found Any Cash Deals", 350, 22, Color.RED);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not Found Cash/Cheque Book", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCashExpendByDateRange(Date from, Date to) {
        try {
            Cash_Check_Book instance = v.Cash_Check_Book.getInstance();
            if (instance != null) {
                showMessage(true, this.msg, "Please wait...", 350, 22, Color.BLACK);
                DealCategory DealCategory = new m.DealCategory().getBy(2);
                List<pojo.MoneyBook> list = new m.MoneyBook().getAllBy(from, to, DealCategory);
                if (list != null && !list.isEmpty()) {
                    DefaultTableModel dtm = (DefaultTableModel) this.tbl.getModel();
                    dtm.setRowCount(0);
                    m.DealType DealType = new m.DealType();
                    for (pojo.MoneyBook MoneyBook : list) {
                        Vector v = new Vector();
                        v.add(MoneyBook.getId());
                        v.add(MoneyBook.getDate());
                        v.add(DealType.getBy(MoneyBook.getDealType().getId()).getType());
                        v.add(MoneyBook.getDscription());
                        v.add("");
                        v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                        dtm.addRow(v);
                    }
                    showMessage(false, this.msg, "", 0, 0, null);
                } else {
                    showMessage(true, this.msg, "Not Found Any Cash Deals", 350, 22, Color.RED);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not Found Cash/Cheque Book", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadDealTypeToList(JList jli) {
        List<pojo.DealType> list = new m.DealType().getAll();
        Vector vec = new Vector();
        if (list != null && !list.isEmpty()) {
            for (pojo.DealType DealType : list) {
                vec.add(DealType.getType());
            }
        } else {
            vec.add("Not Found");
        }
        jli.setListData(vec);
    }

    private void loadDealCategoryToList(JList jli) {
        List<pojo.DealCategory> list = new m.DealCategory().getAll();
        Vector v = new Vector();
        if (list != null && !list.isEmpty()) {
            for (pojo.DealCategory DealCategory : list) {
                v.add(DealCategory.getCategory());
            }
        } else {
            v.add("Not Found");
        }
        jli.setListData(v);
    }

    private void loadBankToTable(JTable tbl) {
        List<pojo.Bank> list = new m.Bank().getAll();
        DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
        dtm.setRowCount(0);
        if (list != null && !list.isEmpty()) {
            for (pojo.Bank Bank : list) {
                Vector v = new Vector();
                v.add(Bank.getBank());
                v.add(m.ValueValidation.getInstance().toDeciaml(Bank.getAmount(), 2));
                dtm.addRow(v);
            }
        }
    }

    private void loadDealCategoryToCombo(JComboBox cmb) {
        List<pojo.DealCategory> list = new m.DealCategory().getAll();
        cmb.removeAllItems();
        if (list != null && !list.isEmpty()) {
            cmb.addItem("Select");
            for (pojo.DealCategory DealCategory : list) {
                cmb.addItem(DealCategory.getCategory());
            }
        } else {
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Not Found Any Deal Category.\n Please Add Deal Categories before begin process", "Error", JOptionPane.ERROR_MESSAGE);
            cmb.addItem("Not Found");
        }
    }

    private void loadDealTypeToCombo(JComboBox cmb) {
        List<pojo.DealType> list = new m.DealType().getAll();
        cmb.removeAllItems();
        if (list != null && !list.isEmpty()) {
            cmb.addItem("Select");
            for (pojo.DealType DealType : list) {
                cmb.addItem(DealType.getType());
            }
        } else {
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Not Found Any Deal Types.\n Please Add Deal types before begin process", "Error", JOptionPane.ERROR_MESSAGE);
            cmb.addItem("Not Found");
        }
    }

    public void loadBankToCombo(JComboBox cmb) {
        List<pojo.Bank> list = new m.Bank().getAll();
        cmb.removeAllItems();
        if (list != null && !list.isEmpty()) {
            cmb.addItem("Select");
            for (pojo.Bank Bank : list) {
                cmb.addItem(Bank.getBank());
            }
        } else {
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Not Found Any Banks.\n Please Add bank list before begin process", "Error", JOptionPane.ERROR_MESSAGE);
            cmb.addItem("Not Found");
        }
    }

    private void loadSupplierSummory() {
        if (this.Cash_Check_Book != null) {
            Supplier supplier = new m.Supplier();
            this.Cash_Check_Book.lbl_supplier_total_credit.setText(m.ValueValidation.getInstance().toDeciaml(supplier.getTotalCredit(), 2));
            ArrayList<pojo.Supplier> viewAllSuppliers = supplier.viewAllSuppliers();
            if (viewAllSuppliers != null && !viewAllSuppliers.isEmpty()) {
                DefaultTableModel dtm = (DefaultTableModel) this.Cash_Check_Book.tbl_supplier_current_credit.getModel();
                dtm.setRowCount(0);
                dtm.setColumnCount(0);
                dtm.addColumn("");
                dtm.addColumn("");
                this.Cash_Check_Book.tbl_supplier_current_credit.getColumnModel().getColumn(1).setCellRenderer(c.View.getInstance().getTableCellRender("r"));
                for (pojo.Supplier Supplier : viewAllSuppliers) {
                    Vector v = new Vector();
                    v.add(Supplier.getName());
                    v.add(m.ValueValidation.getInstance().toDeciaml(Supplier.getCurrentCredit(), 2));
                    dtm.addRow(v);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCustomerSummory() {
        if (this.Cash_Check_Book != null) {
            Customer customer = new m.Customer();
            this.Cash_Check_Book.lbl_customer_total_credit.setText(customer.getTotalCredit() + "");
            List<pojo.Customer> list = customer.getAll();
            if (list != null && !list.isEmpty()) {
                DefaultTableModel dtm = (DefaultTableModel) this.Cash_Check_Book.tbl_customer_current_credit.getModel();
                dtm.setRowCount(0);
                dtm.setColumnCount(0);
                dtm.addColumn("");
                dtm.addColumn("");
                this.Cash_Check_Book.tbl_customer_current_credit.getColumnModel().getColumn(1).setCellRenderer(c.View.getInstance().getTableCellRender("r"));
                for (pojo.Customer Customer : list) {
                    Vector v = new Vector();
                    v.add(Customer.getFname() + " " + Customer.getLname());
                    v.add(m.ValueValidation.getInstance().toDeciaml(Customer.getCredit(), 2));
                    dtm.addRow(v);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadRouteSummory() {
        if (this.Cash_Check_Book != null) {
            RouteReg routeReg = new m.RouteReg();
            this.Cash_Check_Book.lbl_route_total_credit.setText(routeReg.getTotalCredit() + "");
            ArrayList<pojo.RouteReg> list = routeReg.viewAllRoute();
            if (list != null && !list.isEmpty()) {
                DefaultTableModel dtm = (DefaultTableModel) this.Cash_Check_Book.tbl_route_current_credit.getModel();
                dtm.setRowCount(0);
                dtm.setColumnCount(0);
                dtm.addColumn("");
                dtm.addColumn("");
                this.Cash_Check_Book.tbl_route_current_credit.getColumnModel().getColumn(1).setCellRenderer(c.View.getInstance().getTableCellRender("r"));
                for (pojo.RouteReg RouteReg : list) {
                    Vector v = new Vector();
                    v.add(RouteReg.getName());
                    v.add(m.ValueValidation.getInstance().toDeciaml(RouteReg.getCurrentCredit(), 2));
                    dtm.addRow(v);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadBankSummory() {
        if (this.Cash_Check_Book != null) {
            m.Bank bank = new m.Bank();
            this.Cash_Check_Book.lbl_bank_total.setText(m.ValueValidation.getInstance().toDeciaml(bank.getTotal(), 2));
            List<pojo.Bank> list = bank.getAll();
            if (list != null && !list.isEmpty()) {
                DefaultTableModel dtm = (DefaultTableModel) this.Cash_Check_Book.tbl_bank_current_status.getModel();
                dtm.setRowCount(0);
                dtm.setColumnCount(0);
                dtm.addColumn("");
                dtm.addColumn("");
                this.Cash_Check_Book.tbl_bank_current_status.getColumnModel().getColumn(1).setCellRenderer(c.View.getInstance().getTableCellRender("r"));
                for (pojo.Bank Bank : list) {
                    Vector v = new Vector();
                    v.add(Bank.getBank());
                    v.add(m.ValueValidation.getInstance().toDeciaml(Bank.getAmount(), 2));
                    dtm.addRow(v);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCashSummory() {
        if (this.Cash_Check_Book != null) {
            pojo.AssetStatus Cash = new m.AssetStatus().getById(1);
            this.Cash_Check_Book.lbl_cash_current_status.setText(m.ValueValidation.getInstance().toDeciaml(Cash.getAmount(), 2));
            List<pojo.MoneyBook> list = new m.MoneyBook().getLastCashDeals(7);
            if (list != null && !list.isEmpty()) {
                DefaultTableModel dtm = (DefaultTableModel) this.Cash_Check_Book.tbl_cash_last_status.getModel();
                dtm.setRowCount(0);
                dtm.setColumnCount(0);
                dtm.addColumn("");
                dtm.addColumn("");
                this.Cash_Check_Book.tbl_cash_last_status.getColumnModel().getColumn(1).setCellRenderer(c.View.getInstance().getTableCellRender("r"));
                m.DealType dealType = new m.DealType();
                for (pojo.MoneyBook MoneyBook : list) {
                    Vector v = new Vector();
                    v.add(dealType.getBy(MoneyBook.getDealType().getId()).getType());
                    v.add(m.ValueValidation.getInstance().toDeciaml(MoneyBook.getAmount(), 2));
                    dtm.addRow(v);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadAssetCash(JLabel lbl) {
        lbl.setText("Rs. " + new m.AssetStatus().getById(1).getAmount() + "");
    }

//    private void loadBalanceSheet(JTable tbl) {
//        DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
//        tbl.setRowHeight(20);
//        tbl.setShowVerticalLines(false);
//        tbl.setGridColor(c.View.getInstance().colorTheme);
//        dtm.setRowCount(0);
//        dtm.setColumnCount(0);
//        dtm.addColumn("");
//        dtm.addColumn("");
//        dtm.addColumn("");
//        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
//        rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
//        tbl.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
//        tbl.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
//
//        double cashTotal = 0;
//        cashTotal = new m.AssetStatus().getById(1).getAmount();
//        Vector rowCash = new Vector();
//        rowCash.add("Cash");
//        rowCash.add("");
//        rowCash.add(m.ValueValidation.getInstance().toDeciaml(cashTotal, 2));
//        dtm.addRow(rowCash);
//
//        double bankTotal = 0;
//        List<Bank> listBank = new m.Bank().getAll();
//        if (listBank != null && !listBank.isEmpty()) {
//            for (int i = 0; i < listBank.size(); i++) {
//                pojo.Bank bank = listBank.get(i);
//                Vector rowBank = new Vector();
//                if (i == 0) {
//                    rowBank.add("Banks " + bank.getBank());
//                } else {
//                    rowBank.add("          " + bank.getBank());
//                }
//                rowBank.add(m.ValueValidation.getInstance().toDeciaml(bank.getAmount(), 2));
//                rowBank.add("");
//                bankTotal += bank.getAmount();
//                dtm.addRow(rowBank);
//            }
//            Vector rowBankTotal = new Vector();
//            rowBankTotal.add("Banks Total");
//            rowBankTotal.add("");
//            rowBankTotal.add(m.ValueValidation.getInstance().toDeciaml(bankTotal, 2));
//            dtm.addRow(rowBankTotal);
//        }
//        Vector rowTotal = new Vector();
//        rowTotal.add("Money Status");
//        rowTotal.add("");
//        rowTotal.add(m.ValueValidation.getInstance().toDeciaml(bankTotal + cashTotal, 2));
//        dtm.addRow(rowTotal);
//    }

    private String addBank(String name, double amount) {
        if (!name.isEmpty()) {
            m.Bank bank = new m.Bank();
            Bank Bank = bank.getBy(name);
            String save = "";
            MoneyBook moneyBook = new pojo.MoneyBook();
            moneyBook.setDate(new Date());
            if (Bank == null) {
                Bank = new pojo.Bank();
                Bank.setBank(name);
                Bank.setAmount(amount);
                moneyBook.setDealType(new m.DealType().getBy(17));
                moneyBook.setDealCategory(new m.DealCategory().getBy(1));
                moneyBook.setDscription("Increase money(" + name + ") asset");
                moneyBook.setAmount(amount);
                save = bank.saveOrUpdate(Bank);
                new m.MoneyBook().save(moneyBook);
            } else {
                if (Bank.getAmount() > amount) {
                    moneyBook.setDealType(new m.DealType().getBy(16));
                    moneyBook.setDealCategory(new m.DealCategory().getBy(2));
                    moneyBook.setDscription("Reduce money(" + name + ") asset");
                    moneyBook.setAmount(Bank.getAmount() - amount);
                } else if (Bank.getAmount() < amount) {
                    moneyBook.setDealType(new m.DealType().getBy(17));
                    moneyBook.setDealCategory(new m.DealCategory().getBy(1));
                    moneyBook.setDscription("Increase money(" + name + ") asset");
                    moneyBook.setAmount(amount - Bank.getAmount());
                }
                Bank.setAmount(amount);
                new m.MoneyBook().save(moneyBook);
                save = bank.saveOrUpdate(Bank);
            }
            if (save.equalsIgnoreCase("done")) {
                JOptionPane.showMessageDialog(null, "Bank Added Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                return "done";
            } else {
                JOptionPane.showMessageDialog(null, "Bank Adding Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                return "not";
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter Bank Name", "Warning", JOptionPane.WARNING_MESSAGE);
            return "error";
        }
    }

    private String addToDealType(String type, String cate) {
        if (!type.isEmpty()) {
            if (!cate.isEmpty() && !cate.equalsIgnoreCase("Select") && !cate.equalsIgnoreCase("Not Found")) {
                DealCategory DealCategory = new m.DealCategory().getByName(cate);
                if (DealCategory != null) {
                    pojo.DealType DealType = new pojo.DealType();
                    DealType.setType(type);
                    DealType.setDealCategory(DealCategory);
                    String save = new m.DealType().save(DealType);
                    if (save.equalsIgnoreCase("done")) {
                        JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Added Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                        return "done";
                    } else if (save.equalsIgnoreCase("not")) {
                        JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Adding Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                        return "not";
                    } else if (save.equalsIgnoreCase("error")) {
                        JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Somethin went wrong.Try again", "Error", JOptionPane.ERROR_MESSAGE);
                        return "error";
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not Found Deal Category", "Warning", JOptionPane.WARNING_MESSAGE);
                    return "error";
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please Select Category", "Warning", JOptionPane.WARNING_MESSAGE);
                return "error";
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter Type Name", "Warning", JOptionPane.WARNING_MESSAGE);
            return "error";
        }
        return "not";
    }

    private void addToDealCategory(String type) {
        if (!type.isEmpty()) {
            pojo.DealCategory DealCategory = new pojo.DealCategory();
            DealCategory.setCategory(type);
            String save = new m.DealCategory().save(DealCategory);
            if (save.equalsIgnoreCase("done")) {
                JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Added Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
            } else if (save.equalsIgnoreCase("not")) {
                JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Adding Failed", "Warning", JOptionPane.WARNING_MESSAGE);
            } else if (save.equalsIgnoreCase("error")) {
                JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Somethin went wrong.Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please Enter Category Name", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    public pojo.MoneyBook addCashDeal() {
        try {
            MoneyBook MoneyBook = new pojo.MoneyBook();
            MoneyBook.setDate(this.cashDealDate);
            MoneyBook.setDealCategory(this.dealCategory);
            MoneyBook.setDealType(this.dealType);
            MoneyBook.setDscription(this.cashDescrip);
            MoneyBook.setAmount(this.cashAmount);
            String save = new m.MoneyBook().save(MoneyBook);
            if (save.equalsIgnoreCase("done")) {
                c.AssetControl.getInstance().updateCashAsset(this.cashAmount, '-');
                JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Deal added Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                return MoneyBook;
            } else {
                JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Deal Saving Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Somethin went wrong. Try again.", "Error", JOptionPane.ERROR);
            return null;
        }
    }

    public String addChequeDeal() {
        try {
            Cheques Cheques = new pojo.Cheques();
            Cheques.setChequeDate(this.chequeDealDate);
            Cheques.setDate(new Date());
            if (this.dealType.getId() == 1) {
                Cheques.setType("+");
            } else if (this.dealType.getId() == 2) {
                Cheques.setType("-");
            } else {
                Cheques.setType("-");
            }
            Cheques.setDiscription("cash/ /" + this.dealType.getType());
            Cheques.setChequeAmount(this.chequeAmount);
            Cheques.setCheckno(this.chequeNumber);
            Cheques.setBank(this.bank);
            Cheques.setStatus(0);
            String save = new m.Cheques().save(Cheques);
            if (save.equalsIgnoreCase("done")) {
                JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Cheque Added Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                return "done";
            } else {
                JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Deal Saving Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                return "not";
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Please check numbers again", "Warning", JOptionPane.WARNING_MESSAGE);
            return "error";
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Somethin went wrong. Try again.", "Error", JOptionPane.ERROR);
            return "error";
        }
    }

    public String proceedChequeDeal() {
        try {
            Cheques Cheques = new pojo.Cheques();
            Cheques.setChequeDate(this.chequeDealDate);
            Cheques.setDate(new Date());
            if (this.dealType.getId() == 1) {
                Cheques.setType("+");
            } else if (this.dealType.getId() == 2) {
                Cheques.setType("-");
            } else {
                Cheques.setType("-");
            }
            Cheques.setDiscription("cash/ /" + this.dealType.getType());
            Cheques.setChequeAmount(this.chequeAmount);
            Cheques.setCheckno(this.chequeNumber);
            Cheques.setBank(this.bank);
            Cheques.setStatus(1);
            String save = new m.Cheques().save(Cheques);
            if (save.equalsIgnoreCase("done")) {
                if (this.dealCategory.getId() == 1) {
                    this.bank.setAmount(this.bank.getAmount() + this.chequeAmount);
                } else if (this.dealCategory.getId() == 2) {
                    this.bank.setAmount(this.bank.getAmount() - this.chequeAmount);
                }
                String updateBank = new m.Bank().updateBank(bank);
                if (updateBank.equalsIgnoreCase("done")) {
                    JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Cheque Proceed Successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                    return "done";
                } else {
                    JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Cheque Proceed Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                    return "not";
                }
                }else{JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Deal Saving Failed","Warning",JOptionPane.WARNING_MESSAGE);return "not";}
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Please check numbers again","Warning",JOptionPane.WARNING_MESSAGE);
            return "error";
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Somethin went wrong. Try again.","Error",JOptionPane.ERROR);
            return "error";
        }
    }
    public int proceedCheque(String chequeNumber,int bankId){
        try {
                Cheques Cheques = new m.Cheques().getByChequeNumber(chequeNumber);
                Cheques.setStatus(1);
                String save = new m.Cheques().update(Cheques);
                if(save.equalsIgnoreCase("done")){
                    Bank bank = new m.Bank().getBy(bankId);
                    if(Cheques.getType().equals("+")){
                        bank.setAmount(bank.getAmount()+Cheques.getChequeAmount());
                    }else if(Cheques.getType().equals("+")){
                        bank.setAmount(bank.getAmount()-Cheques.getChequeAmount());
                    }
                    String updateBank = new m.Bank().updateBank(bank);
                    if(updateBank.equalsIgnoreCase("done")){
                    JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Cheque Proceed Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
                    return 1;
                    }else{
                    JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Cheque Proceed Failed","Warning",JOptionPane.WARNING_MESSAGE);
                return 0;
            }
                }else{JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Deal Saving Failed","Warning",JOptionPane.WARNING_MESSAGE);return 0;}
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Please check numbers again", "Warning", JOptionPane.WARNING_MESSAGE);
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(v.Cash_Check_Book.getInstance(), "Somethin went wrong. Try again.", "Error", JOptionPane.ERROR);
            return 0;
        }
    }
}
