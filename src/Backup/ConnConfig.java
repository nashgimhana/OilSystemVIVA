/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backup;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnConfig {

    private static Connection ConfigConn;
    private static ResultSet sereverConfig, path;
    private static String serverIP, port, database, username, password, id = "1";

    public static Connection getServerConfig() {
        if (ConfigConn == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                ConfigConn = DriverManager.getConnection("jdbc:sqlite:C:\\Program Files\\Common Files\\Oil System\\server_connection.db");
            } catch (ClassNotFoundException e) {
                JOptionPane.showMessageDialog(null, "No Database Driver found", "Database Driver Error", JOptionPane.ERROR_MESSAGE);
                Toolkit.getDefaultToolkit().beep();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database Connection fail", "SQL Error", JOptionPane.ERROR_MESSAGE);
                Toolkit.getDefaultToolkit().beep();
            }
        }
        return ConfigConn;
    }

    public static String getSeverIP() {
        try {
            sereverConfig = getServerConfig().createStatement().executeQuery("SELECT server_ip FROM tbl_connection WHERE Id = '1' ");
            while (sereverConfig.next()) {
                serverIP = sereverConfig.getString("server_ip");//sereverConfig.getString("server_ip");
//                sereverConfig.getString("server_ip");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        } finally {
            try {
                sereverConfig.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return serverIP;
    }

    public static String getSeverPort() {
        try {
            sereverConfig = getServerConfig().createStatement().executeQuery("SELECT server_port FROM tbl_connection WHERE Id = '1' ");
            while (sereverConfig.next()) {
                port = sereverConfig.getString("server_port");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        } finally {
            try {
                sereverConfig.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return port;
    }

    public static String getDatabase() {
        try {
            sereverConfig = getServerConfig().createStatement().executeQuery("SELECT database FROM tbl_connection WHERE Id = '1' ");
            while (sereverConfig.next()) {
                database = sereverConfig.getString("database");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        } finally {
            try {
                sereverConfig.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return database;
    }

    public static String getLogUser() {
        try {
            sereverConfig = getServerConfig().createStatement().executeQuery("SELECT user_name FROM tbl_connection WHERE Id = '1' ");
            while (sereverConfig.next()) {
                username = sereverConfig.getString("user_name");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            Toolkit.getDefaultToolkit().beep();
        } finally {
            try {
                sereverConfig.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return username;
    }

    public static String getLogPassword() {
        try {
            sereverConfig = getServerConfig().createStatement().executeQuery("SELECT password FROM tbl_connection WHERE Id = '1' ");
            while (sereverConfig.next()) {
                password = sereverConfig.getString("password");
            }
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                sereverConfig.close();
            } catch (Exception e) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return password;
    }

}
