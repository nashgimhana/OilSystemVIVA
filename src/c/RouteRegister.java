/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import pojo.RouteCredit;
import pojo.RouteReg;

/**
 *
 * @author User
 */
public class RouteRegister {

    public int saveRoute(JTextField routeId, JTextField routeName, JTextArea routeDescription, JTextField routeCredit, JPanel jPanel) {
        int i = 0;
        try {
            if (routeName.getText().isEmpty()) {
                //JOptionPane.showConfirmDialog(jPanel, "Please enter a Route Name", "Confirm", 2);
                Errormzg.displayerrorMessage("Please enter a Route Name");

            } else {
                String routeDes = null;
                String routeCr = null;
                if (routeDescription.getText().isEmpty()) {
                    routeDes = "No Description";
                } else {
                    routeDes = routeDescription.getText();
                }
                if (routeCredit.getText().isEmpty()) {
                    routeCr = "0";
                } else {
                    routeCr = routeCredit.getText();
                }

                RouteReg routeReg = new pojo.RouteReg();
                //routeReg.setId(Integer.parseInt(routeId.getText()));
                routeReg.setName(routeName.getText());
                routeReg.setDiscription(routeDes);
                double routeCrD = Double.parseDouble(routeCr);
                routeCrD = (Math.round(routeCrD * 100.0) / 100.0);
                routeReg.setCurrentCredit(routeCrD);

                m.RouteReg routeReg1 = new m.RouteReg();
                String save = routeReg1.saveRoute(routeReg, routeId.getText());
                if (save.equals("done")) {
                    RouteReg routeReg11 = new m.RouteReg().getBy(Integer.parseInt(routeId.getText()));

                    if (!routeCr.equals("0")) {
                        RouteCredit routeCredit1 = new pojo.RouteCredit();
                        routeCredit1.setRouteReg(routeReg11);
                        routeCredit1.setDate(new Date());
                        routeCredit1.setCredit(routeCrD);

                        new m.RouteCredit().save1(routeCredit1);
                    }

                    JOptionPane.showConfirmDialog(jPanel, "Data saved Route = " + routeName.getText(), "Confirm", 2);
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }
}
