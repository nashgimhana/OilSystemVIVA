/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author K Punnajee Thero < Kurunegala Punnajee Thero at www.hansavila.com >
 */
public class DB {

    static Connection c = null;

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/oildb", "root", "root");
        return c;
    }

    public static int setData(String sql) throws Exception {
        int i = DB.getConnection().createStatement().executeUpdate(sql);
        return i;
    }

    public static ResultSet getData(String sql) throws Exception {
        ResultSet rs = DB.getConnection().createStatement().executeQuery(sql);
        return rs;
    }

}
