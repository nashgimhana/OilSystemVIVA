/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import pojo.Bank;
import pojo.Cheques;
import pojo.CusCredit;
import pojo.Customer;
import pojo.MoneyBook;

/**
 *
 * @author suhada
 */
public class CustomerListner implements MouseListener, ComponentListener, KeyListener, FocusListener, ActionListener {

    private CustomerListner() {
    }
    private static CustomerListner CustomerListner = null;

    public static CustomerListner getInstance() {
        if (CustomerListner == null) {
            CustomerListner = new CustomerListner();
        }
        return CustomerListner;
    }
    private v.CustomerView CustomerView = null;

    public void setCustomerView(v.CustomerView CustomerView) {
        this.CustomerView = CustomerView;
        if (CustomerView == null) {
            JOptionPane.showMessageDialog(null, "Not Found Customer View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String nic = "", fname = "", mname = "", lname = "", addressl1 = "", addressl2 = "", addressl3 = "", contact1 = "", contact2 = "", gender = "";
    private String chequeNumber = "";
    private pojo.Bank bank = null;
    private double currentCredit = -1, cashAmount = -1, chequeAmount = -1;
    private Date date;

    public boolean setNic(String nic) {
        this.nic = nic;
        if (!this.nic.equals("")) {
//            if(m.ValueValidation.getInstance().isNIC(this.nic))
            return true;
//            else{
//                JOptionPane.showMessageDialog(null, "Please Enter Valide NIC Number","Warningn",JOptionPane.WARNING_MESSAGE);
//                return false;
//            }
        } else {
            return false;
        }
    }

    public boolean setFname(String fname) {
        this.fname = fname;
        if (!this.fname.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public boolean setLname(String lname) {
        this.lname = lname;
        if (!this.lname.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setAddressl1(String addressl1) {
        this.addressl1 = addressl1;
        if (!this.addressl1.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setAddressl2(String addressl2) {
        this.addressl2 = addressl2;
        if (!this.addressl2.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setAddressl3(String addressl3) {
        this.addressl3 = addressl3;
        if (!this.addressl3.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public boolean checkContactNumbers() {
        if (this.contact1.equals("") && this.contact2.equals("")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean setGender(String gender) {
        this.gender = gender;
        if (!this.gender.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setCurrentCredit(double currentCredit) {
        this.currentCredit = currentCredit;
        if (this.currentCredit > -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setCurrentCredit(String currentCredit) {
        try {
            this.currentCredit = Double.parseDouble(currentCredit);
            if (this.currentCredit > -1) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean setDate(Date date) {
        this.date = date;
        if (this.date != null) {
            return true;
        } else {
            return false;
        }
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

    public boolean setChequeNumber(String chequeNumber) {
        this.chequeNumber = chequeNumber;
        if (!this.chequeNumber.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean setBank(String bank) {
        this.bank = new m.Bank().getBy(bank);
        if (this.bank != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.CustomerView != null) {
            // save customer
            if (e.getSource() == this.CustomerView.btn_save) {
                if (this.setNic(this.CustomerView.tf_nic.getText())) {
                    if (this.setFname(this.CustomerView.tf_first_name.getText())) {
                        setMname(this.CustomerView.tf_middle_name.getText());
                        if (this.setLname(this.CustomerView.tf_last_name.getText())) {
                            if (this.setGender(this.CustomerView.Cmb_gender.getSelectedItem().toString())) {
                                if (this.setAddressl1(this.CustomerView.tf_add_1.getText())) {
                                    if (this.setAddressl2(this.CustomerView.tf_add_2.getText())) {
                                        if (this.setAddressl3(this.CustomerView.tf_add_3.getText())) {
                                            this.setContact1(this.CustomerView.tf_mobile.getText());
                                            this.setContact2(this.CustomerView.tf_fixed.getText());
                                            if (this.checkContactNumbers()) {
                                                if (this.setCurrentCredit(this.CustomerView.tf_currentCredit.getText())) {
                                                    String saveCustomer = this.saveCustomer();
                                                    if (saveCustomer.equalsIgnoreCase("done")) {
                                                        this.clearRegisterForm();
                                                        loadCustmers();
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Enter customer credit. If not enter \"0.0\" ", "Warning", JOptionPane.WARNING_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Enter at least one contact number", "Warning", JOptionPane.WARNING_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Complete the address", "Warning", JOptionPane.WARNING_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Complete the address", "Warning", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Enter Address Name", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Select gender", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Enter last Name", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Enter NIC", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } // update customer
            else if (e.getSource() == this.CustomerView.jButton1) {
                if (this.CustomerView != null) {
                    if (this.setNic(this.CustomerView.tf_nic.getText())) {
                        if (this.setFname(this.CustomerView.tf_first_name.getText())) {
                            setMname(this.CustomerView.tf_middle_name.getText());
                            if (this.setLname(this.CustomerView.tf_last_name.getText())) {
                                if (this.setGender(this.CustomerView.Cmb_gender.getSelectedItem().toString())) {
                                    if (this.setAddressl1(this.CustomerView.tf_add_1.getText())) {
                                        if (this.setAddressl2(this.CustomerView.tf_add_2.getText())) {
                                            if (this.setAddressl3(this.CustomerView.tf_add_3.getText())) {
                                                this.setContact1(this.CustomerView.tf_mobile.getText());
                                                this.setContact2(this.CustomerView.tf_fixed.getText());
                                                if (this.checkContactNumbers()) {
                                                    if (this.setCurrentCredit(this.CustomerView.tf_currentCredit.getText())) {
                                                        String saveCustomer = this.updateCustomer();
                                                        if (saveCustomer.equalsIgnoreCase("done")) {
                                                            this.clearRegisterForm();
                                                            loadCustmers();
                                                        }
                                                    } else {
                                                        JOptionPane.showMessageDialog(null, "Enter customer credit. If not enter \"0.0\" ", "Warning", JOptionPane.WARNING_MESSAGE);
                                                    }
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Enter at least one contact number", "Warning", JOptionPane.WARNING_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Complete the address", "Warning", JOptionPane.WARNING_MESSAGE);
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Complete the address", "Warning", JOptionPane.WARNING_MESSAGE);
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Enter Address Name", "Warning", JOptionPane.WARNING_MESSAGE);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Select gender", "Warning", JOptionPane.WARNING_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Enter last Name", "Warning", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Enter First Name", "Warning", JOptionPane.WARNING_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Enter NIC", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } // clear customer
            else if (e.getSource() == this.CustomerView.btn_clear) {
                clearRegisterForm();
            } // load customer details to fields on tbl click
            else if (e.getSource() == this.CustomerView.jTable_customer) {
                int id = (int) this.CustomerView.jTable_customer.getValueAt(this.CustomerView.jTable_customer.getSelectedRow(), 0);
                this.loadCustomerById(id);
            } // credit manage tbl
            else if (e.getSource() == this.CustomerView.tbl_customer_sum) {
                String nic = (String) this.CustomerView.tbl_customer_sum.getValueAt(this.CustomerView.tbl_customer_sum.getSelectedRow(), 1);
                pojo.Customer customer = new m.Customer().getByNic(nic);
                if (customer != null) {
                    this.setToLabels(customer);
                } else {
                    JOptionPane.showMessageDialog(null, "Not Found Customer", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            } // accept cheque payment
            else if (e.getSource() == this.CustomerView.btn_acceptpayment) {
                if (this.CustomerView != null) {
                    String acceptPayment = acceptPayment();
                    if (acceptPayment.equalsIgnoreCase("done")) {
                        JOptionPane.showMessageDialog(null, "Payment Success", "Message", JOptionPane.INFORMATION_MESSAGE);
                        this.loadCustmerSum();
                        this.clearCreditMange();
                    } else {
                        JOptionPane.showMessageDialog(null, "Payment adding failed", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } // add cheque to table
            else if (e.getSource() == this.CustomerView.btn_add_chequeto_table) {
                if (this.CustomerView != null) {
                    try {
                        if (!this.CustomerView.txt_cheque_number.getText().equals("")) {
                            if (!this.CustomerView.cmb_bank_list.getSelectedItem().toString().equalsIgnoreCase("select")) {
                                if (!this.CustomerView.txt_cheque_amount.getText().equals("")) {
                                    Vector v = new Vector();
                                    DefaultTableModel dtm = (DefaultTableModel) this.CustomerView.tbl_cheque.getModel();
                                    double am = Double.parseDouble(this.CustomerView.txt_cheque_amount.getText());
                                    String number = this.CustomerView.txt_cheque_number.getText();
                                    String bank = this.CustomerView.cmb_bank_list.getSelectedItem().toString();
                                    if (this.CustomerView.tbl_cheque.getColumnCount() == 0) {
                                        dtm.addColumn("Cheque No.");
                                        dtm.addColumn("Bank");
                                        dtm.addColumn("Amount");
                                        dtm.addColumn("Date");
                                    }
                                    v.add(number);
                                    v.add(bank);
                                    v.add(am);
                                    v.add(((JTextField) this.CustomerView.jdc_Cheque_date.getDateEditor().getUiComponent()).getText());
                                    dtm.addRow(v);
                                    this.CustomerView.txt_cheque_number.setText("");
                                    this.CustomerView.txt_cheque_amount.setText("");
                                    this.CustomerView.cmb_bank_list.setSelectedItem("Select");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Please enter cheque amount", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Please enter bank", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please enter cheque number", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NumberFormatException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Please enter valid number", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } // reset
            else if (e.getSource() == this.CustomerView.btn_reset) {
                this.clearCreditMange();
            } // remove item from cheque table
            else if (e.getSource() == this.CustomerView.btn_removeselected) {
                ((DefaultTableModel) this.CustomerView.tbl_cheque.getModel()).removeRow(this.CustomerView.tbl_cheque.getSelectedRow());
            } // remove all from cheque table
            else if (e.getSource() == this.CustomerView.btn_removeall) {
                ((DefaultTableModel) this.CustomerView.tbl_cheque.getModel()).setRowCount(0);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
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

    @Override
    public void componentResized(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {
        // register form
        if (e.getSource() == this.CustomerView.jsp_customerregisterform) {
            loadCustmers();
        } // credit manager
        else if (e.getSource() == this.CustomerView.jsp_customercreditmanager) {
            if (this.CustomerView != null) {
                setEnableDiasble();
                loadCustmerSum();
                loadBankToCombo(this.CustomerView.cmb_bank_list);
            }
        }
    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // nic
        if (e.getSource() == this.CustomerView.tf_nic) {
            c.AutoComplete.getInstance().autoCompleteCustomerNic(this.CustomerView.tf_nic);
        } // first name
        else if (e.getSource() == this.CustomerView.tf_first_name) {
            c.AutoComplete.getInstance().autoCompleteCustomerNic(this.CustomerView.tf_first_name);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (this.CustomerView != null) {
            // nic
            if (e.getSource() == this.CustomerView.tf_nic) {
                if (!this.CustomerView.tf_nic.getText().equals("")) {
                    pojo.Customer customer = new m.Customer().getByNic(this.CustomerView.tf_nic.getText());
                    if (customer != null) {
                        int confirm = JOptionPane.showConfirmDialog(this.CustomerView, "NIC already exist. Do you want to load details?", "NIC Validation", JOptionPane.OK_CANCEL_OPTION);
                        if (confirm == 0) {
                            this.setToFields(customer);
                        }
                    }
                }
            } // cheque amoutn released
            else if (e.getSource() == this.CustomerView.tf_nic) {

            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        if (this.CustomerView != null) {
            if (e.getSource() == this.CustomerView.tf_mobile) {
                if (m.ValueValidation.getInstance().isContactNumber(((JTextField) e.getSource()).getText())) {
                    ((JTextField) e.getSource()).setForeground(Color.BLACK);
                } else {
                    ((JTextField) e.getSource()).setForeground(Color.RED);
                }
            } else if (e.getSource() == this.CustomerView.tf_fixed) {
                if (m.ValueValidation.getInstance().isContactNumber(((JTextField) e.getSource()).getText())) {
                    ((JTextField) e.getSource()).setForeground(Color.BLACK);
                } else {
                    ((JTextField) e.getSource()).setForeground(Color.RED);
                }
            } else if (e.getSource() == this.CustomerView.tf_nic) {
//            if(m.ValueValidation.getInstance().isNIC(((JTextField)e.getSource()).getText())){
//                ((JTextField)e.getSource()).setForeground(Color.BLACK);
//            }else{
//                ((JTextField)e.getSource()).setForeground(Color.RED);
//            }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.CustomerView.jcb_cash) {
            if (this.CustomerView.jcb_cash.isSelected()) {
                this.CustomerView.jcb_cash.setBackground(c.View.getInstance().grennlight);
            } else {
                this.CustomerView.jcb_cash.setBackground(c.View.getInstance().grayHilight);
            }
            this.setEnableDiasble();
        } else if (e.getSource() == this.CustomerView.jcb_cheque) {
            if (this.CustomerView.jcb_cheque.isSelected()) {
                this.CustomerView.jcb_cheque.setBackground(c.View.getInstance().grennlight);
            } else {
                this.CustomerView.jcb_cheque.setBackground(c.View.getInstance().grayHilight);
            }
            this.setEnableDiasble();
        }
    }

    private void clearRegisterForm() {
        if (this.CustomerView != null) {
            this.CustomerView.tf_nic.setText("");
            this.CustomerView.tf_first_name.setText("");
            this.CustomerView.tf_middle_name.setText("");
            this.CustomerView.tf_last_name.setText("");
            this.CustomerView.tf_add_1.setText("");
            this.CustomerView.tf_add_2.setText("");
            this.CustomerView.tf_add_3.setText("");
            this.CustomerView.tf_mobile.setText("");
            this.CustomerView.tf_fixed.setText("");
            this.CustomerView.tf_currentCredit.setText("0.0");
        }
    }

    private void clearCreditMange() {
        this.CustomerView.lbl_show_nic.setText("NIC");
        this.CustomerView.lbl_show_name.setText("Name");
        this.CustomerView.lbl_show_current_credit.setText("0.0");
        DefaultTableModel dtm = (DefaultTableModel) this.CustomerView.tbl_cheque.getModel();
        dtm.setRowCount(0);
        dtm.setColumnCount(0);
        this.CustomerView.jcb_cash.setSelected(false);
        this.CustomerView.jcb_cheque.setSelected(false);
        this.CustomerView.txt_cash_amount.setText("");
        this.CustomerView.txt_cheque_amount.setText("");
        this.CustomerView.txt_cheque_number.setText("");
        this.CustomerView.cmb_bank_list.setSelectedItem("Select");
        this.setEnableDiasble();
    }

    private String saveCustomer() {
        Customer customer = new m.Customer().getByNic(this.nic);
        if (customer == null) {
            customer = new pojo.Customer();
            customer.setFname(this.fname);
            customer.setMname(this.mname);
            customer.setLname(this.lname);
            customer.setNic(this.nic);
            customer.setGender(this.gender);
            customer.setAdressLine1(this.addressl1);
            customer.setAdressLine2(this.addressl2);
            customer.setAdressLine3(this.addressl3);
            customer.setPhone1(this.contact1);
            customer.setPhone2(this.contact2);
            customer.setCredit(this.currentCredit);
            String save = new m.Customer().save(customer);
            if (save.equalsIgnoreCase("done")) {
                this.saveCredit(customer, this.currentCredit);
                JOptionPane.showMessageDialog(this.CustomerView, "Addedd Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                return "done";
            } else if (save.equalsIgnoreCase("not")) {
                JOptionPane.showMessageDialog(this.CustomerView, "Addedd Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                return "not";
            } else if (save.equalsIgnoreCase("error")) {
                JOptionPane.showMessageDialog(this.CustomerView, "Something went wrong. Try again", "Error", JOptionPane.ERROR_MESSAGE);
                return "error";
            }
        } else {
            JOptionPane.showMessageDialog(this.CustomerView, "NIC already in the system", "Warning", JOptionPane.WARNING_MESSAGE);
            return "error";
        }
        return "";
    }

    private String updateCustomer() {
        Customer customer = new m.Customer().getByNic(this.nic);
        if (customer != null) {
            double currentCredit = customer.getCredit();
            customer.setFname(this.fname);
            customer.setMname(this.mname);
            customer.setLname(this.lname);
            customer.setNic(this.nic);
            customer.setGender(this.gender);
            customer.setAdressLine1(this.addressl1);
            customer.setAdressLine2(this.addressl2);
            customer.setAdressLine3(this.addressl3);
            customer.setPhone1(this.contact1);
            customer.setPhone2(this.contact2);
            customer.setCredit(this.currentCredit);
            String save = new m.Customer().update(customer);
            if (save.equalsIgnoreCase("done")) {
                this.saveCredit(customer, currentCredit);
                JOptionPane.showMessageDialog(this.CustomerView, "Update Successful", "Message", JOptionPane.INFORMATION_MESSAGE);
                return "done";
            } else if (save.equalsIgnoreCase("not")) {
                JOptionPane.showMessageDialog(this.CustomerView, "Update Failed", "Warning", JOptionPane.WARNING_MESSAGE);
                return "not";
            } else if (save.equalsIgnoreCase("error")) {
                JOptionPane.showMessageDialog(this.CustomerView, "Something went wrong. Try again", "Error", JOptionPane.ERROR_MESSAGE);
                return "error";
            }
        } else {
            JOptionPane.showMessageDialog(this.CustomerView, "Not Found Customer", "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return "";
    }

    private void loadCustmers() {
        if (this.CustomerView != null) {
            DefaultTableModel dtm = (DefaultTableModel) this.CustomerView.jTable_customer.getModel();
            dtm.setRowCount(0);
            List<Customer> listCustomers = new m.Customer().getAll();
            if (listCustomers != null && !listCustomers.isEmpty()) {
                for (Customer customer : listCustomers) {
                    String name = customer.getFname();
                    if (!customer.getMname().equals("")) {
                        name += " " + customer.getMname();
                    }
                    name += " " + customer.getLname();
                    Vector v = new Vector();
                    v.add(customer.getId());
                    v.add(customer.getNic());
                    v.add(name);
                    v.add(customer.getGender());
                    v.add(customer.getAdressLine1() + " " + customer.getAdressLine2() + " " + customer.getAdressLine3());
                    v.add(customer.getPhone1() + " " + customer.getPhone2());
                    v.add(m.ValueValidation.getInstance().toDeciaml(customer.getCredit(), 2));
                    dtm.addRow(v);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not Found Customers", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCustmerSum() {
        if (this.CustomerView != null) {
            DefaultTableModel dtm = (DefaultTableModel) this.CustomerView.tbl_customer_sum.getModel();
            dtm.setRowCount(0);
            List<Customer> listCustomers = new m.Customer().getAll();
            if (listCustomers != null && !listCustomers.isEmpty()) {
                for (Customer customer : listCustomers) {
                    String name = customer.getFname();
                    if (!customer.getMname().equals("")) {
                        name += " " + customer.getMname();
                    }
                    name += " " + customer.getLname();
                    Vector v = new Vector();
                    v.add(customer.getId());
                    v.add(customer.getNic());
                    v.add(name);
                    v.add(m.ValueValidation.getInstance().toDeciaml(customer.getCredit(), 2));
                    dtm.addRow(v);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Not Found Customers", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Not Found View", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String loadCustomerById(int id) {
        try {
            pojo.Customer customer = new m.Customer().getById(id);
            if (customer != null) {
                this.setToFields(customer);
                return "done";
            } else {
                return "not";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this.CustomerView, "Something went wrong. Try again", "Error", JOptionPane.ERROR_MESSAGE);
            return "error";
        }
    }

    private void setToFields(pojo.Customer customer) {
        this.CustomerView.tf_nic.setText(customer.getNic());
        this.CustomerView.tf_first_name.setText(customer.getFname());
        this.CustomerView.tf_middle_name.setText(customer.getMname());
        this.CustomerView.tf_last_name.setText(customer.getLname());
        this.CustomerView.Cmb_gender.setSelectedItem(customer.getGender());
        this.CustomerView.tf_add_1.setText(customer.getAdressLine1());
        this.CustomerView.tf_add_2.setText(customer.getAdressLine2());
        this.CustomerView.tf_add_3.setText(customer.getAdressLine3());
        this.CustomerView.tf_mobile.setText(customer.getPhone1());
        this.CustomerView.tf_fixed.setText(customer.getPhone2());
        this.CustomerView.tf_currentCredit.setText(m.ValueValidation.getInstance().toDeciaml(customer.getCredit(), 2) + "");
    }

    private void setToLabels(pojo.Customer customer) {
        String name = customer.getFname();
        if (!customer.getMname().equals("")) {
            name += " " + customer.getMname() + " ";
        }
        name += customer.getLname();
        this.CustomerView.lbl_show_nic.setText(customer.getNic());
        this.CustomerView.lbl_show_name.setText(name);
        this.CustomerView.lbl_show_current_credit.setText(customer.getCredit() + "");
    }

    private void saveCredit(pojo.Customer customer, double currentCredit) {
        if (this.currentCredit > 0) {
            CusCredit cusCredit = new pojo.CusCredit();
            cusCredit.setDate(new Date());
            cusCredit.setCustomer(customer);
            if (currentCredit > this.currentCredit) {
                cusCredit.setType(2);
                cusCredit.setAmount(currentCredit - this.currentCredit);
            } else if (currentCredit < this.currentCredit) {
                cusCredit.setAmount(this.currentCredit - currentCredit);
                cusCredit.setType(1);
            } else if (currentCredit == this.currentCredit) {
                cusCredit.setAmount(this.currentCredit);
                cusCredit.setType(1);
            } else {
                JOptionPane.showMessageDialog(null, "Could not calculate credit status", "Warning", JOptionPane.WARNING_MESSAGE);
            }
            new m.CusCredit().save(cusCredit);
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

    private void setEnableDiasble() {
        this.CustomerView.txt_cash_amount.setEditable(this.CustomerView.jcb_cash.isSelected());
        this.CustomerView.txt_cheque_amount.setEditable(this.CustomerView.jcb_cheque.isSelected());
        this.CustomerView.txt_cheque_number.setEditable(this.CustomerView.jcb_cheque.isSelected());
        this.CustomerView.cmb_bank_list.setEnabled(this.CustomerView.jcb_cheque.isSelected());
        this.CustomerView.btn_add_chequeto_table.setEnabled(this.CustomerView.jcb_cheque.isSelected());
        this.CustomerView.btn_removeall.setEnabled(this.CustomerView.jcb_cheque.isSelected());
        this.CustomerView.btn_removeselected.setEnabled(this.CustomerView.jcb_cheque.isSelected());
        if (this.CustomerView.jcb_cheque.isSelected() || this.CustomerView.jcb_cash.isSelected()) {
            this.CustomerView.btn_acceptpayment.setEnabled(true);
        } else {
            this.CustomerView.btn_acceptpayment.setEnabled(false);
        }
        if (this.CustomerView.jcb_cash.isSelected()) {
            this.CustomerView.jcb_cash.setBackground(c.View.getInstance().grennlight);
        } else {
            this.CustomerView.jcb_cash.setBackground(c.View.getInstance().grayHilight);
        }
        if (this.CustomerView.jcb_cheque.isSelected()) {
            this.CustomerView.jcb_cheque.setBackground(c.View.getInstance().grennlight);
        } else {
            this.CustomerView.jcb_cheque.setBackground(c.View.getInstance().grayHilight);
        }
    }

    private String acceptPayment() {
        String status = "not";
        if (this.CustomerView.jcb_cash.isSelected() || this.CustomerView.jcb_cheque.isSelected()) {
            if (this.setDate(this.CustomerView.jdc_pay_date.getDate())) {
                m.Customer Customer = new m.Customer();
                Customer customer = Customer.getByNic(this.CustomerView.tbl_customer_sum.getValueAt(this.CustomerView.tbl_customer_sum.getSelectedRow(), 1).toString());
                if (customer != null) {
                    if (customer.getCredit() > 0) {
                        // cash
                        if (this.CustomerView.jcb_cash.isSelected()) {
                            try {
                                if (this.setCashAmount(Double.parseDouble(this.CustomerView.txt_cash_amount.getText()))) {
                                    CusCredit cusCredit = new pojo.CusCredit();
                                    cusCredit.setAmount(this.cashAmount);
                                    cusCredit.setCustomer(customer);
                                    cusCredit.setDate(this.date);
                                    cusCredit.setType(2);
                                    String save = new m.CusCredit().save(cusCredit);
                                    if (save.equalsIgnoreCase("done")) {
                                        MoneyBook moneyBook = new pojo.MoneyBook();
                                        moneyBook.setAmount(this.cashAmount);
                                        moneyBook.setDate(this.date);
                                        moneyBook.setDealCategory(new m.DealCategory().getBy(1));
                                        moneyBook.setDscription("Money received from " + customer.getFname());
                                        moneyBook.setDealType(new m.DealType().getBy(13));
                                        String save1 = new m.MoneyBook().save(moneyBook);
                                        if (save1.equalsIgnoreCase("done")) {
                                            String add = new m.CustomerPay().add(new pojo.CustomerPay(customer, moneyBook));
                                            if (add.equalsIgnoreCase("done")) {
                                                customer.setCredit(customer.getCredit() - this.cashAmount);
                                                String update = Customer.update(customer);
                                                if (update.equalsIgnoreCase("done")) {
                                                    c.AssetControl.getInstance().updateCashAsset(this.cashAmount, '+');
                                                    status = "done";
                                                } else {
                                                    status = "not";
                                                }
                                            } else {
                                                status = "not";
                                            }
                                        } else {
                                            status = "not";
                                        }
                                    } else {
                                        status = "not";
                                    }
                                }
                            } catch (NumberFormatException e) {
                                e.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Please enter valide cash amount", "Warning", JOptionPane.WARNING_MESSAGE);
                                status = "error";
                            }
                            // cheque
                        }
                        if (this.CustomerView.jcb_cheque.isSelected()) {
//                            try {
//                                if (this.CustomerView.tbl_cheque.getRowCount() > 0) {
//                                    if (this.CustomerView.txt_cheque_number.getText().equals("") || this.CustomerView.txt_cheque_amount.getText().equals("")) {
//                                        try {
//                                            int rowCount = this.CustomerView.tbl_cheque.getRowCount();
//                                            for (int i = 0; i < rowCount; i++) {
//                                                if (this.setChequeNumber(this.CustomerView.tbl_cheque.getValueAt(i, 0).toString())) {
//                                                    if (this.setBank(this.CustomerView.tbl_cheque.getValueAt(i, 1).toString())) {
//                                                        if (this.setChequeAmount(Double.parseDouble(this.CustomerView.tbl_cheque.getValueAt(i, 2).toString()))) {
//                                                            CusCredit cusCredit = new pojo.CusCredit();
//                                                            cusCredit.setAmount(this.chequeAmount);
//                                                            cusCredit.setCustomer(customer);
//                                                            cusCredit.setDate(this.date);
//                                                            cusCredit.setType(2);
//                                                            String save = new m.CusCredit().save(cusCredit);
//                                                            if (save.equalsIgnoreCase("done")) {
//                                                                Cheques Cheques = new pojo.Cheques();
//                                                                Cheques.setChequeDate(this.CustomerView.jdc_Cheque_date.getDate());
//                                                                Cheques.setDate(this.CustomerView.jdc_pay_date.getDate());
//                                                                Cheques.setType("-");
//                                                                Cheques.setDiscription("customer/"+customer.getId()+"/"+customer.getFname());
//                                                                Cheques.setChequeAmount(this.chequeAmount);
//                                                                Cheques.setCheckno(this.chequeNumber);
//                                                                Cheques.setBank(this.bank);
//                                                                Cheques.setStatus(0);
//                                                                String savech = new m.Cheques().save(Cheques);
//                                                                if(savech.equalsIgnoreCase("done"))status="done";
//                                                                else status = "not";
//                                                            } else {
//                                                                System.out.println("cus credit save fail");
//                                                                status = "not";
//                                                            }
//                                                        } else {
//                                                            JOptionPane.showMessageDialog(null, "Please enter cheque amount", "Warning", JOptionPane.WARNING_MESSAGE);
//                                                        }
//                                                    } else {
//                                                        JOptionPane.showMessageDialog(null, "Please select bank", "Warning", JOptionPane.WARNING_MESSAGE);
//                                                    }
//                                                } else {
//                                                    JOptionPane.showMessageDialog(null, "Please enter cheque number", "Warning", JOptionPane.WARNING_MESSAGE);
//                                                }
//                                                this.chequeNumber = "";
//                                                this.bank = null;
//                                                this.chequeAmount = -1;
//                                            }
//                                        } catch (NumberFormatException e) {
//                                            JOptionPane.showMessageDialog(null, "Please enter valide cheque amount", "Warning", JOptionPane.WARNING_MESSAGE);
//                                            status = "error;";
//                                        }
//                                    } else {
//                                        JOptionPane.showMessageDialog(null, "Looks like you have pending cheque. Please add it to cheque table.", "Warning", JOptionPane.WARNING_MESSAGE);
//                                    }
//                                } else {
//                                    if (this.setChequeNumber(this.CustomerView.txt_cheque_number.getText())) {
//                                        if (this.setBank(this.CustomerView.cmb_bank_list.getSelectedItem().toString())) {
//                                            if (this.setChequeAmount(Double.parseDouble(this.CustomerView.txt_cheque_amount.getText()))) {
//                                                CusCredit cusCredit = new pojo.CusCredit();
//                                                cusCredit.setAmount(this.chequeAmount);
//                                                cusCredit.setCustomer(customer);
//                                                cusCredit.setDate(this.date);
//                                                cusCredit.setType(2);
//                                                String save = new m.CusCredit().save(cusCredit);
//                                                if (save.equalsIgnoreCase("done")) {
//                                                    Cheques Cheques = new pojo.Cheques();
//                                                    Cheques.setChequeDate(this.CustomerView.jdc_Cheque_date.getDate());
//                                                    Cheques.setDate(this.CustomerView.jdc_pay_date.getDate());
//                                                    Cheques.setType("-");
//                                                    Cheques.setDiscription("customer/"+customer.getId()+"/"+customer.getFname());
//                                                    Cheques.setChequeAmount(this.chequeAmount);
//                                                    Cheques.setCheckno(this.chequeNumber);
//                                                    Cheques.setBank(this.bank);
//                                                    Cheques.setStatus(0);
//                                                    String savech = new m.Cheques().save(Cheques);
//                                                    if(savech.equalsIgnoreCase("done"))status="done";
//                                                    else status = "not";
//                                                } else {
//                                                    status = "not";
//                                                }
//                                            } else {
//                                                JOptionPane.showMessageDialog(null, "Please enter cheque amount", "Warning", JOptionPane.WARNING_MESSAGE);
//                                            }
//                                        } else {
//                                            JOptionPane.showMessageDialog(null, "Please select bank", "Warning", JOptionPane.WARNING_MESSAGE);
//                                        }
//                                    } else {
//                                        JOptionPane.showMessageDialog(null, "Please enter cheque number", "Warning", JOptionPane.WARNING_MESSAGE);
//                                    }
//                                }
//                            } catch (NumberFormatException e) {
//                                e.printStackTrace();
//                                JOptionPane.showMessageDialog(null, "Please enter valide cheque amount", "Warning", JOptionPane.WARNING_MESSAGE);
//                                status = "error";
//                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Not Found Credit on this Customer", "Warning", JOptionPane.WARNING_MESSAGE);
                        status = "not";
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not Found Customer", "Warning", JOptionPane.WARNING_MESSAGE);
                    status = "not";
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select date", "Warning", JOptionPane.WARNING_MESSAGE);
                status = "not";
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select payment method", "Warning", JOptionPane.WARNING_MESSAGE);
            status = "not";
        }
        return status;
    }
}
