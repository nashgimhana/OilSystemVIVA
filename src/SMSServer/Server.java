/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMSServer;

/**
 *
 * @author Buddhika Prasanna
 */
import java.net.*;
import java.io.*;
import v.Home;

public class Server {

    private static void createAndShowGUI() {

        v.Home.getInstance().setVisible(true);
    }

    public static final int LISTENING_PORT = 2002;

    static ClientSender clientSender;

    public static void main(String[] args) {

        //Create and set up the window
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        // Open server socket for listening
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(LISTENING_PORT);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
            //System.out.println("Server started on port " + LISTENING_PORT);
        } catch (IOException se) {
            System.err.println("Can not start listening on port " + LISTENING_PORT);
            se.printStackTrace();
            System.exit(-1);
        }

        // Start ServerDispatcher thread
        ServerDispatcher serverDispatcher = new ServerDispatcher();

        // Accept and handle client connections
        //while (true) {
        try {
            Socket socket = serverSocket.accept();
            ClientInfo clientInfo = new ClientInfo();
            clientInfo.mSocket = socket;
            ClientListener clientListener
                    = new ClientListener(clientInfo, serverDispatcher);
            clientSender
                    = new ClientSender(clientInfo, serverDispatcher);
            clientInfo.mClientListener = clientListener;
            clientInfo.mClientSender = clientSender;
            clientListener.start();
            clientSender.start();
            serverDispatcher.addClient(clientInfo);
            //System.out.println("COM9_9600_8_300_300_" + receiverNumber + "_" + message);
            //clientSender.sendMessage("COM9_9600_8_300_300_" + "0711998310" + "_" + "OK");
            //System.out.println("COM9_9600_8_300_300_" + receiverNumber + "_" + message);
        } catch (Exception ioe) {
            ioe.printStackTrace();
        }
        //}
    }

    public static void sendSMS(String receiverNumber, String message) {
        clientSender.sendMessage("COM9_9600_8_300_300_" + receiverNumber + "_" + message);
    }
}
