/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import m.Vehicle;

/**
 *
 * @author Me
 */
public class VehicleRegister {

    /**
     * @return the regNumber1
     */
    public String getRegNumber1() {
        return regNumber1;
    }

    /**
     * @param regNumber1 the regNumber1 to set
     */
    public void setRegNumber1(String regNumber1) {
        this.regNumber1 = regNumber1;
    }

    /**
     * @return the regNumber2
     */
    public String getRegNumber2() {
        return regNumber2;
    }

    /**
     * @param regNumber2 the regNumber2 to set
     */
    public void setRegNumber2(String regNumber2) {
        this.regNumber2 = regNumber2;
    }
    /*This calss is use to register new vehicles*/
    private String regNumber1;
    private String regNumber2;
    private pojo.Vehicle pojoVehicle = null;

    public int setData(JTextField regNumber1, JTextField id, JPanel jPanel) {
        int i = 0;
        try {

            if (!regNumber1.getText().isEmpty()) {
                setRegNumber1(regNumber1.getText().trim());
//            if (!regNumber2.getText().isEmpty()) {
//                setRegNumber2(regNumber2.getText().trim());
//            } else {
//                setRegNumber2("No Trailer");
//            }

                pojoVehicle = new pojo.Vehicle();

                pojoVehicle.setNumber1(getRegNumber1());
                //pojoVehicle.setNumber2(getRegNumber2());

                Vehicle vehicle = new m.Vehicle();
                String save = vehicle.save(pojoVehicle, id.getText().trim());

                if (save.equals("done")) {
                    JOptionPane.showConfirmDialog(jPanel, "Data saved as Vehicle Registration Number = " + getRegNumber1(), "Confirm", 2);
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
            } else {
                //msg = "Pls enter a number 1";
                //JOptionPane.showConfirmDialog(jPanel, "Please enter a Vehicle Registration Number", "Confirm", 2);
                Errormzg.displayerrorMessage("Please enter a Vehicle Registration Number");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
