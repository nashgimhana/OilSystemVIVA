/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 *
 * @author suhada
 */
public class ValueValidation {

    private static ValueValidation ValueValidation = null;

    public static ValueValidation getInstance() {
        if (ValueValidation == null) {
            ValueValidation = new ValueValidation();
        }
        return ValueValidation;
    }

    /**
     * This method is for check nic
     *
     * @param value The Value that need to check
     * @return will return a boolean value if values is valid will return
     * 'true'. else 'false';
     */
    public boolean isNIC(String value) {
        if (!value.isEmpty()) {
            return Pattern.matches("^[0-9]{9}[VvXx]{1}$", value);
        } else {
            return false;
        }
    }

    /**
     * This method is for check number
     *
     * @param value The Value that need to check
     * @return will return a boolean value if values is valid will return
     * 'true'. else 'false';
     */
    public boolean isNumber(char value) {
        if (value >= '0' && value <= '9') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPrice(char ch, String value) {
        if (ch != '.') {
            if (ch >= '0' && ch <= '9') {
                return true;
            } else {
                return false;
            }
        } else {
            if (value.contains(".")) {
                return false;
            } else {
                return true;
            }
        }
    }

    public boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isDigit(char c){
        if(Character.isDigit(c))return true;
        else return false;
    }
    
    private boolean isLetter(char c){
        if(Character.isLetter(c))return true;
        else return false;
    }
    
    public boolean isDouble(String value) {
        try {
            System.out.println("value");
            Double.parseDouble(value);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String toDeciaml(double number, int poinTo) {
        String to = "0.";
        for (int i = 0; i < poinTo; i++) {
            to += "0";
        }
        DecimalFormat decimalFormat = new DecimalFormat(to);
        return decimalFormat.format(number);
    }

    /**
     * This method is for check text
     *
     * @param value The Value that need to check
     * @return will return a boolean value if values is valid will return
     * 'true'. else 'false';
     */
    public boolean isText(String value) {
        if (!value.isEmpty()) {
            return Pattern.matches("^\\w+[A-Za-z]$", value);
        } else {
            return false;
        }
    }

    /**
     * This method is for check email
     *
     * @param value The Value that need to check
     * @return will return a boolean value if values is valid will return
     * 'true'. else 'false';
     */
    public boolean isEmail(String value) {
        if (!value.isEmpty()) {
            return Pattern.matches("^\\w+@\\w+.\\w+$", value);
        } else {
            return false;
        }
    }

    /**
     * This method is for check contact number sri lankan form
     *
     * @param value The Value that need to check
     * @return will return a boolean value if values is valid will return
     * 'true'. else 'false';
     */
    public boolean isContactNumber(String value) {
        if (!value.isEmpty()) {
            return Pattern.matches("^\\d{10}$", value);
        } else {
            return false;
        }
    }

    public void onlyNumber(KeyEvent evt) {
        char keyChar = evt.getKeyChar();
        if (!Character.isDigit(keyChar)) {
            evt.consume();
        }
    }
}
