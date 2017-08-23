/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import pojo.Vehicle;

/**
 *
 * @author User
 */
public class VehicleUpdate {

    m.Vehicle vehiclem = null;

    public void updateVehicle(JTextField id, JTextField num1, JPanel panel) {
        try {
            vehiclem = new m.Vehicle();
            int byId = vehiclem.getById(Integer.parseInt(id.getText()));

            if (byId == 1) {
                JOptionPane.showConfirmDialog(panel, "No such data record found to be updated", "Check Update Data", 2);
            } else if (byId == 2) {
                if (num1.getText().isEmpty()) {
                    //JOptionPane.showConfirmDialog(panel, "Please enter a Vehicle Registration Number", "Confirm", 2);
                    Errormzg.displayerrorMessage("Please enter a Vehicle Registration Number");
                } else {
                    Vehicle vehicle = new pojo.Vehicle();
                    vehicle.setId(Integer.parseInt(id.getText()));
                    vehicle.setNumber1(num1.getText());
                    //vehicle.setNumber2(num2.getText());

                    vehiclem.updateVehicle(vehicle);
                }

            } else {
                JOptionPane.showConfirmDialog(panel, "Critical error", "Error", 2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
