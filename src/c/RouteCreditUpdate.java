/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.JTextField;
import m.RouteReg;
import pojo.RouteCredit;

/**
 *
 * @author User
 */
public class RouteCreditUpdate {

    public void updateRouteCredit(JTextField routeCreditid, JDateChooser routeCreditDate, JTextField routeCredit, JTextField routeIdCredit) {
        try {
            String routeCr = null;
        String routrId = null;
        m.RouteCredit routeCredit1 = new m.RouteCredit();
        if (routeCreditid.getText().isEmpty()) {
            Errormzg.displayerrorMessage("Please enter a valid Route Credit Id");
        } else {

            int byId = routeCredit1.getById(Integer.parseInt(routeCreditid.getText()));

            if (byId == 1) {
                Errormzg.displayerrorMessage("Please enter a valid Route Credit Id");
            } else if (byId == 2) {
                if (routeCredit.getText().isEmpty()) {
                    routeCr = "0";
                } else {
                    routeCr = routeCredit.getText();
                }
                if (routeIdCredit.getText().isEmpty()) {
                    Errormzg.displayerrorMessage("Please enter a Route Id");
                } else {

                    RouteCredit rc = new pojo.RouteCredit();
                    rc.setId(Integer.parseInt(routeCreditid.getText().trim()));
                    rc.setDate(routeCreditDate.getDate());
                    rc.setCredit(Double.parseDouble(routeCr));

                    pojo.RouteReg by = new RouteReg().getBy(Integer.parseInt(routeIdCredit.getText().trim()));
                    rc.setRouteReg(by);
                    System.out.println(by.getName());

                    routeCredit1.update(rc);
                }
            } else {

            }

        }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
