/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import com.alee.extended.panel.GroupPanel;
import com.alee.laf.optionpane.WebOptionPane;
import com.alee.managers.notification.NotificationIcon;
import com.alee.managers.notification.NotificationManager;
import com.alee.managers.notification.WebNotificationPopup;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import v.Home;

/**
 *
 * @author Buddhika Prasanna
 */
public class NotificationCreater {

    WebNotificationPopup notificationPopup;
    JLabel label;

    public void getNotificationPopup(String mgs, long displayTime, NotificationIcon icon) {
        try {
            if (notificationPopup == null) {
                notificationPopup = new WebNotificationPopup();
                label = new JLabel(mgs);
            }
            notificationPopup.setIcon(icon);
            notificationPopup.setDisplayTime(displayTime);

            notificationPopup.setContent(new GroupPanel(label));

            NotificationManager.showNotification(Home.getInstance(), notificationPopup);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            WebOptionPane.showMessageDialog(Home.getInstance(), e, "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
