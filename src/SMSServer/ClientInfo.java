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
import java.net.Socket;

public class ClientInfo {

    public int userID = -1;
    public Socket mSocket = null;
    public ClientListener mClientListener = null;
    public ClientSender mClientSender = null;
}
