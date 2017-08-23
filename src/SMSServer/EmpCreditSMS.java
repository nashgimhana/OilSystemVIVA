/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMSServer;

/**
 *
 * @author Punnajee
 */
public class EmpCreditSMS {

    private String number1;
    private String number2;
    private String sms;

    /**
     * @return the number1
     */
    public String getNumber1() {
        return number1;
    }

    /**
     * @param number1 the number1 to set
     */
    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    /**
     * @return the number2
     */
    public String getNumber2() {
        return number2;
    }

    /**
     * @param number2 the number2 to set
     */
    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    /**
     * @return the sms
     */
    public String getSms() {
        return sms;
    }

    /**
     * @param sms the sms to set
     */
    public void setSms(String sms) {
        this.sms = sms;
    }
    
    public boolean send(){
        new SMS().sendSMS(getNumber1(), getSms());
        return true;// Sending Status;
    }

}
