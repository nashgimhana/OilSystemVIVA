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
import java.io.*;
import java.net.*;

public class ClientListener extends Thread {

    private ServerDispatcher mServerDispatcher;
    private ClientInfo mClientInfo;
    private BufferedReader mIn;
    private String message;
    private String decoded = null;

    public ClientListener(ClientInfo aClientInfo,
            ServerDispatcher aServerDispatcher) throws IOException {
        mClientInfo = aClientInfo;
        mServerDispatcher = aServerDispatcher;
        Socket socket = aClientInfo.mSocket;
        mIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Until interrupted, reads messages from the client socket, forwards them
     * to the server dispatcher and notifies the server dispatcher.
     */
    public void run() {
        message = "";
        while (!isInterrupted()) {
            try {
                message = mIn.readLine();
                if (message == null) {
                    break;
                }
                try {
                    decoded = URLDecoder.decode(message, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                mServerDispatcher.sendMessage(mClientInfo, decoded);

            } catch (IOException e) {
                break;
            }

        }

        // Communication is broken. Interrupt both listener and sender threads
        mClientInfo.mClientSender.interrupt();
        mServerDispatcher.deleteClient(mClientInfo);
    }

}
