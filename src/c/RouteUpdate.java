/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.util.Date;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import m.RouteReg;
import pojo.RouteCredit;

/**
 *
 * @author User
 */
public class RouteUpdate {

    public void updateRoute(JTextField routeId, JTextField routeName, JTextArea routeDescription, JTextField routeCredit) {
        try {
            String roteDesc = null;
            String roteCred = null;

            pojo.RouteReg routeRegUpdate = new m.RouteReg().getBy(Integer.parseInt(routeId.getText()));
            if (routeId.getText().isEmpty()) {
                Errormzg.displayerrorMessage("Please enter a RouteID");
            } else {
                if (routeName.getText().isEmpty()) {
                    Errormzg.displayerrorMessage("Please enter a Route Name");
                } else {
                    if (routeDescription.getText().isEmpty()) {
                        roteDesc = "No Description";
                    } else {
                        roteDesc = routeDescription.getText();
                    }

                    if (routeCredit.getText().isEmpty()) {
                        roteCred = "0";
                        //roteCred = routeRegUpdate.getCurrentCredit().toString();
                    } else {
                        roteCred = routeCredit.getText();
                    }
                    double routeCrD = Double.parseDouble(roteCred);
                    routeCrD = (Math.round(routeCrD * 100.0) / 100.0);

//                pojo.RouteReg routeReg = new pojo.RouteReg();
//                routeReg.setId(Integer.parseInt(routeId.getText()));
//                routeReg.setName(routeName.getText());
//                routeReg.setDiscription(roteDesc);
//                routeReg.setCurrentCredit(Double.parseDouble(roteCred));
                    routeRegUpdate.setName(routeName.getText());
                    routeRegUpdate.setDiscription(roteDesc);
                    double cr = routeRegUpdate.getCurrentCredit() + routeCrD;
                    cr = (Math.round(cr * 100.0) / 100.0);
                    routeRegUpdate.setCurrentCredit(cr);

                    RouteReg routeReg1 = new m.RouteReg();
//                String updateRoute = routeReg1.updateRoute(routeReg);
                    String updateRoute = routeReg1.updateRoute(routeRegUpdate);

                    RouteCredit routeCredit1 = new pojo.RouteCredit();
                    routeCredit1.setRouteReg(routeRegUpdate);
                    routeCredit1.setDate(new Date());
                    routeCredit1.setCredit(routeCrD);
                    new m.RouteCredit().save1(routeCredit1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
