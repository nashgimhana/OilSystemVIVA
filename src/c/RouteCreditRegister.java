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

/**
 *
 * @author User
 */
public class RouteCreditRegister {

    public int saveRouteCredit(JDateChooser chooser, JTextField routeCredit, JTextField routeRegisterId, JTextField routeCreditId, JPanel jPanel) {
        String routeCr = null;
        int i = 0;
        try {
            if (routeCreditId.getText().isEmpty()) {
            Errormzg.displayerrorMessage("Please click Clear button to active Id");
        } else {
            if (routeCredit.getText().isEmpty()) {
                routeCr = "0";
            } else {
                routeCr = routeCredit.getText();
            }

            if (routeRegisterId.getText().isEmpty()) {
                Errormzg.displayerrorMessage("Please enter a valid Route Id");
            } else {
                RouteCredit routeCredit1 = new pojo.RouteCredit();
                routeCredit1.setDate(chooser.getDate());
                routeCredit1.setCredit(Double.parseDouble(routeCr));

                pojo.RouteReg by = new RouteReg().getBy(Integer.parseInt(routeRegisterId.getText().trim()));
                routeCredit1.setRouteReg(by);
                System.out.println(by.getName());

                String save = new m.RouteCredit().save(routeCredit1, routeCreditId.getText().trim());

                if (save.equals("done")) {
                    JOptionPane.showConfirmDialog(jPanel, "Data saved Route Credit", "Confirm", 2);
                    i = 1;
                } else if (save.equals("error")) {
                    JOptionPane.showConfirmDialog(jPanel, "Data error", "Confirm", 2);
                    i = 2;
                } else if (save.equals("not")) {
                    JOptionPane.showConfirmDialog(jPanel, "Already contains data and you are trying to update", "Confirm", 2);
                    i = 3;

                } else {
                    JOptionPane.showConfirmDialog(jPanel, "Serious Error, restart the software and check data", "Confirm", 2);
                }
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }
}
