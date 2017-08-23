/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.jsource.swing.combobox.suggest.SuggestComboBox;
import com.jsource.swing.combobox.suggest.SuggestComboBoxModel;
import com.mxrck.autocompleter.TextAutoCompleter;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import m.Customer;
import m.Employee;
import m.Product;
import m.RouteCredit;
import m.RouteDebit;
import m.RouteReg;
import m.Supplier;
import m.Vehicle;

/**
 *
 * @author Me
 */
public class AutoComplete {

    private static AutoComplete AutoComplete = null;

    public static AutoComplete getInstance() {
        if (AutoComplete == null) {
            AutoComplete = new AutoComplete();
        }
        return AutoComplete;
    }

    public void autocompleteRegNm1(JTextField num1) {
        try {
            Vehicle vehicle = new Vehicle();
            TextAutoCompleter autoCompleter = new TextAutoCompleter(num1);
            if (autoCompleter.getItems() != null) {
                autoCompleter.removeAllItems();
            }
            //TextAutoCompleter autoCompleter1 = new TextAutoCompleter(num2);
            ArrayList<pojo.Vehicle> viewAllVehicle = vehicle.acRegNumber1();
            for (pojo.Vehicle vehicle1 : viewAllVehicle) {
                autoCompleter.addItem(vehicle1.getNumber1());
                //autoCompleter.addItem(vehicle1.getId());
                //autoCompleter1.addItem(vehicle1.getNumber2());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillRegNm2(JTextField num1, JTextField id) {
        try {
            Vehicle vehicle = new Vehicle();
            //pojo.Vehicle byRegnm1 = vehicle.getByRegnm1(box.getSelectedItem().toString().trim());
            pojo.Vehicle byRegnm1 = vehicle.getByRegnm1(num1.getText());
            num1.setText(byRegnm1.getNumber1());
            //num2.setText(byRegnm1.getNumber2());
            id.setText(byRegnm1.getId().toString());
            //String num2 = byRegnm1.getNumber2();
            //int id = byRegnm1.getId();
            //return num2+""+id;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autocompleteRouteRegNam(JTextField routeName) {
        try {
            TextAutoCompleter autoCompleter = new TextAutoCompleter(routeName);
            if (autoCompleter.getItems() != null) {
                autoCompleter.removeAllItems();
            }
            RouteReg routeReg = new RouteReg();
            ArrayList<pojo.RouteReg> viewAllRoute = routeReg.viewAllRoute();
            for (pojo.RouteReg routeReg1 : viewAllRoute) {
                autoCompleter.addItem(routeReg1.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autoCompleteVehicleNumber(JTextField vehicleNumber) {
        try {
            TextAutoCompleter autoCompleter = new TextAutoCompleter(vehicleNumber);
            if (autoCompleter.getItems() != null) {
                autoCompleter.removeAllItems();
            }
            RouteReg routeReg = new RouteReg();
            ArrayList<pojo.Vehicle> viewAllRoute = routeReg.viewAllVehicle();
            for (pojo.Vehicle vehicle : viewAllRoute) {
                autoCompleter.addItem(vehicle.getNumber1());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autoCompleteBankName(JTextField txtBank) {
        try {
            TextAutoCompleter autoCompleter = new TextAutoCompleter(txtBank);
            if (autoCompleter.getItems() != null) {
                autoCompleter.removeAllItems();
            }
            RouteReg routeReg = new RouteReg();
            ArrayList<pojo.Bank> viewAllRoute = routeReg.viewAllBank();
            for (pojo.Bank bank : viewAllRoute) {
                autoCompleter.addItem(bank.getBank());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillRouteDeatails(JTextField routeId, JTextField routeName, JTextArea routeDescription, JTextField routeCredit) {
        try {
            RouteReg routeReg = new RouteReg();
            pojo.RouteReg byName = routeReg.getByName(routeName.getText());
            routeId.setText(String.valueOf(byName.getId()));
            routeName.setText(byName.getName());
            routeDescription.setText(byName.getDiscription());
            //routeCredit.setText(String.valueOf(byName.getCurrentCredit()));
            routeCredit.setText(String.valueOf(0.00));
        } catch (Exception e) {
        }
    }

    public void fillRouteDeatailsForCrerdit(JTextField routeId, JTextField routeName,JTextField routeDebit) {
        try {
            RouteReg routeReg = new RouteReg();
            pojo.RouteReg byName = routeReg.getByName(routeName.getText());
            routeId.setText(String.valueOf(byName.getId()));
            routeName.setText(byName.getName());
            routeDebit.setText(String.valueOf(routeReg.getTotalCredit()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autocompleteRouteRegId(JTextField routeRedId) {
        try {
            TextAutoCompleter autoCompleter = new TextAutoCompleter(routeRedId);
            if (autoCompleter.getItems() != null) {
                autoCompleter.removeAllItems();
            }
            RouteReg routeReg = new RouteReg();
            ArrayList<pojo.RouteReg> viewAllRoute = routeReg.viewAllRoute();
            for (pojo.RouteReg routeReg1 : viewAllRoute) {
                autoCompleter.addItem(routeReg1.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillRouteDeatailsForCrerditFromRouteId(JTextField routeId, JTextField routeName, JTextField routeCredit) {
        try {
            RouteReg routeReg = new RouteReg();
            pojo.RouteReg byName = routeReg.getBy(Integer.parseInt(routeId.getText()));
            routeId.setText(String.valueOf(byName.getId()));
            routeName.setText(byName.getName());
            routeCredit.setText(byName.getCurrentCredit().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autoCompleteRouteCredit(JTextField routeCreditId) {
        try {
            TextAutoCompleter autoCompleter = new TextAutoCompleter(routeCreditId);
            if (autoCompleter.getItems() != null) {
                autoCompleter.removeAllItems();
            }
            ArrayList<pojo.RouteCredit> viewRouteCreditAllData = new RouteCredit().viewRouteCreditAllData();
            for (pojo.RouteCredit routeCredit : viewRouteCreditAllData) {
                autoCompleter.addItem(routeCredit.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillRouteCreditDetails(JTextField routeCreditId, JDateChooser routeDate, JTextField routeCredit, JTextField routeIdCredit, JTextField routeNameCredit) {
        try {
            pojo.RouteCredit by = new m.RouteCredit().getBy(Integer.parseInt(routeCreditId.getText()));
            routeCreditId.setText(String.valueOf(by.getId()));
            routeDate.setDate(by.getDate());
            routeCredit.setText(String.valueOf(by.getCredit()));
            routeIdCredit.setText(by.getRouteReg().getId().toString());
            routeNameCredit.setText(by.getRouteReg().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void autoCompleteRouteDebit(JTextField routeCreditId) {
        try {
            TextAutoCompleter autoCompleter = new TextAutoCompleter(routeCreditId);
            autoCompleter.removeAllItems();
            //ArrayList<pojo.RouteCredit> viewRouteCreditAllData = new RouteCredit().viewRouteCreditAllData();
            ArrayList<pojo.RouteDebit> viewRouteDebitAllData = new RouteDebit().viewRouteDebitAllData();
            for (pojo.RouteDebit routeCredit : viewRouteDebitAllData) {
                autoCompleter.addItem(routeCredit.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fillRouteDebitDetails(JTextField routeDebittId, JDateChooser routeDate, JTextField routeDebit, JTextField routeIdDebit, JTextField routeNameDebit) {
        try {
            //pojo.RouteCredit by = new m.RouteCredit().getBy(Integer.parseInt(routeCreditId.getText()));
            pojo.RouteDebit by = new m.RouteDebit().getBy(Integer.parseInt(routeDebittId.getText()));
            routeDebittId.setText(String.valueOf(by.getId()));
            routeDate.setDate(by.getDate());
            routeDebit.setText(String.valueOf(by.getDebit()));
            routeIdDebit.setText(by.getRouteReg().getId().toString());
            routeNameDebit.setText(by.getRouteReg().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//##############################################################################
    //Stock nash
    public void acProductNameAndId(JTextField prName) {
        try {
            TextAutoCompleter autoCompleter = new TextAutoCompleter(prName);
            if (autoCompleter.getItems() != null) {
                autoCompleter.removeAllItems();
            }
            Product pr = new Product();
            ArrayList<pojo.Product> viewallproducts = pr.getAll();
            for (pojo.Product p : viewallproducts) {
                autoCompleter.addItem(p.getId());
                autoCompleter.addItem(p.getName());
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public void acProductName(JTextField prName) {
        try {
            TextAutoCompleter autoCompleter = new TextAutoCompleter(prName);
            if (autoCompleter.getItems() != null) {
                autoCompleter.removeAllItems();
            }
            Product pr = new Product();
            ArrayList<pojo.Product> viewallproducts = pr.getAll();
            for (pojo.Product p : viewallproducts) {
                autoCompleter.addItem(p.getName());
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public void acSupllierName(JTextField supName) {
        try {
            TextAutoCompleter autoCompleter = new TextAutoCompleter(supName);
            if (autoCompleter.getItems() != null) {
                autoCompleter.removeAllItems();
            }
            Supplier s = new Supplier();
            ArrayList<pojo.Supplier> suppliers = s.viewAllSuppliers();
            for (pojo.Supplier s1 : suppliers) {
                autoCompleter.addItem(s1.getName());
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        }
    }

    public void acEmployeeName(JTextField empName) {
        try {
            TextAutoCompleter autoCompleter = new TextAutoCompleter(empName);
            if (autoCompleter.getItems() != null) {
                autoCompleter.removeAllItems();
            }
            autoCompleter.removeAllItems();
            Employee emp = new Employee();
            ArrayList<pojo.Employee> employers = emp.viewAllEmployers();
            for (pojo.Employee s1 : employers) {
                autoCompleter.addItem(s1.getFname() + " " + s1.getMname());
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        }
    }
//##############################################################################
//shanaka

    public void autoCompleteCustomerNic(JTextField tfCustomer) {

        try {
            TextAutoCompleter textAutoCompleter = new TextAutoCompleter(tfCustomer);
            textAutoCompleter.removeAllItems();

            Customer customer = new m.Customer();

            List<pojo.Customer> viewAllVehicle = customer.getAll();
            for (pojo.Customer customer1 : viewAllVehicle) {
                textAutoCompleter.addItem(customer1.getFname());

            }
        } catch (Exception e) {
        }
    }

    public void autoCompleteCustomerName(JTextField tfCustomer) {

        try {
            TextAutoCompleter textAutoCompleter = new TextAutoCompleter(tfCustomer);
            if (textAutoCompleter.getItems() != null) {
                textAutoCompleter.removeAllItems();
            }

            Customer customer = new m.Customer();

            List<pojo.Customer> viewAllVehicle = customer.getAll();
            for (pojo.Customer cusList : viewAllVehicle) {
                textAutoCompleter.addItem(cusList.getFname() + " " + cusList.getMname());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//shanaka

}
