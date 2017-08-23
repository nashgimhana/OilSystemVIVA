/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMSServer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Buddhika Prasanna
 */
public class SMS {

    public void sendSMS(String receiverNumber, String message) {
        String[] para = {"COM9_9600_8_300_300_" + receiverNumber + "_" + message};
        try {
            File f = new File("Parameter.txt");
            if (f.exists()) {
                f.delete();
            }

            FileWriter writer = new FileWriter("D:\\Parameter.txt", true);
            writer.write(para[0]);
            writer.close();

            Process p = Runtime.getRuntime().exec("C:\\Program Files\\Common Files\\SMSApp\\SendSMS.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
