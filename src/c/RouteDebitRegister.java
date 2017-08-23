/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import m.RouteReg;
import pojo.RouteCredit;
import pojo.RouteDebit;
import v.DebitCash;

/**
 *
 * @author User
 */
public class RouteDebitRegister {

    public int saveRouteDebit(JDateChooser chocser, JTextField routeDebit, JTextField routeRegisterId, JPanel jPanel) {
        String routeDeb = null;
        int i = 0;
        try {
            //if (routeDebitId.getText().isEmpty()) {
            // Errormzg.displayerrorMessage("Please click Clear button to active Id");
            // } else {
            if (routeDebit.getText().isEmpty()) {
                routeDeb = "0";
            } else {
                routeDeb = routeDebit.getText();
            }

            if (routeRegisterId.getText().isEmpty()) {
                Errormzg.displayerrorMessage("Please enter a valid Route Id");
            } else {

//                RouteCredit routeCredit1 = new pojo.RouteCredit();
//                RouteDebit routeDebit1 = new pojo.RouteDebit();
//                routeDebit1.setDate(chooser.getDate());
//                routeDebit1.setDebit(Double.parseDouble(routeDebit.getText()));
//
//                pojo.RouteReg by = new RouteReg().getBy(Integer.parseInt(routeRegisterId.getText().trim()));
//                routeDebit1.setRouteReg(by);
//                System.out.println(by.getName());
//
//                String save = new m.RouteDebit().save(routeDebit1, routeDebitId.getText().trim());
                DebitCash debitCash = new DebitCash(chocser, routeRegisterId, jPanel);
                debitCash.setDelivery(jPanel);
                debitCash.setVisible(true);
//                String save = "done";
//                if (save.equals("done")) {
//                    JOptionPane.showConfirmDialog(jPanel, "Data saved Route Debit", "Confirm", 2);
//                    i = 1;
//                } else if (save.equals("error")) {
//                    JOptionPane.showConfirmDialog(jPanel, "Data error", "Confirm", 2);
//                    i = 2;
//                } else if (save.equals("not")) {
//                    JOptionPane.showConfirmDialog(jPanel, "Already contains data and you are trying to update", "Confirm", 2);
//                    i = 3;
//
//                } else {
//                    JOptionPane.showConfirmDialog(jPanel, "Serious Error, restart the software and check data", "Confirm", 2);
//                }

            }
            //}
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }
}
