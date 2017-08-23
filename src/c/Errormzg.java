/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Errormzg {

    public static void displayerrorMessage(String errormsg) {
        JOptionPane.showMessageDialog(null, errormsg, "Error", JOptionPane.ERROR_MESSAGE);

    }

    public static void displayconfirmMessage(String confirm) {
        JOptionPane.showMessageDialog(null, confirm, "Successfull", JOptionPane.INFORMATION_MESSAGE);

    }

}
