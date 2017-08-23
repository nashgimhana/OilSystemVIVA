/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import m.RouteReg;
import pojo.RouteCredit;
import pojo.RouteDebit;

/**
 *
 * @author User
 */
public class RouteDebitUpdate {

    public void updateRouteDebi(JTextField routeDebitid, JDateChooser routeDebitDate, JTextField routeDebit, JTextField routeIdDebit) {
        try {
            String routeCr = null;
        String routrId = null;
        m.RouteDebit routeCredit1 = new m.RouteDebit();
        if (routeDebitid.getText().isEmpty()) {
            Errormzg.displayerrorMessage("Please enter a valid Route Credit Id");
        } else {

            int byId = routeCredit1.getById(Integer.parseInt(routeDebitid.getText()));

            if (byId == 1) {
                Errormzg.displayerrorMessage("Please enter a valid Route Debit Id");
            } else if (byId == 2) {
                if (routeDebit.getText().isEmpty()) {
                    routeCr = "0";
                } else {
                    routeCr = routeDebit.getText();
                }
                if (routeIdDebit.getText().isEmpty()) {
                    Errormzg.displayerrorMessage("Please enter a Route Id");
                } else {

                    RouteDebit rc = new pojo.RouteDebit();
                    rc.setId(Integer.parseInt(routeDebitid.getText().trim()));
                    rc.setDate(routeDebitDate.getDate());
                    rc.setDebit(Double.parseDouble(routeDebit.getText()));

                    pojo.RouteReg by = new RouteReg().getBy(Integer.parseInt(routeIdDebit.getText().trim()));
                    rc.setRouteReg(by);
                    System.out.println(by.getName());

                    new m.RouteDebit().update(rc);
                }
            } else {

            }

        }
        } catch (Exception e) {
            e.printStackTrace();
        }

//RouteCredit rc = new pojo.RouteCredit();
    }
}
