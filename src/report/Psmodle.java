/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.awt.Toolkit;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Punnajee
 */
public class Psmodle {

    public void report(int empid, int bsid) {
        String path = "C:\\Program Files\\Common Files\\Report\\sp.jrxml";
        try {
            JasperReport RI = JasperCompileManager.compileReport(path);
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("empid", empid);
            parameter.put("bsid", bsid);
            JasperPrint printit = JasperFillManager.fillReport(RI, parameter, DB.getConnection());
            new JRViewer(printit);
            //JasperPrintManager.printReport(printit, false);
            JasperViewer.viewReport(printit, false);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // new Psmodle().invoiceReport(2, 350.00);
       //   grn(3);
    }

    public void invoiceReport(int inid, double credit, double payedValue) {

        System.out.println("============================" + inid);
        System.out.println("============================" + credit);

        String path = "C:\\Program Files\\Common Files\\Report\\in.jrxml";
        try {
            JasperReport RI = JasperCompileManager.compileReport(path);
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("inid", inid);
            parameter.put("credit", credit);
            parameter.put("payedValue", payedValue);
            JasperPrint printit = JasperFillManager.fillReport(RI, parameter, DB.getConnection());
            new JRViewer(printit);
            //JasperPrintManager.printReport(printit, false);
            JasperViewer.viewReport(printit, false);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
    }

    public void newInvoice(int invoiceid, double paidamount, double billamount, double paidcredit, double added_credit) {

//        System.out.println("============================"+inid);
//        System.out.println("============================"+credit);
        String path = "C:\\Program Files\\Common Files\\Report\\newinvoice.jrxml"; 
        try {
            JasperReport RI = JasperCompileManager.compileReport(path);
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("invoiceid", invoiceid);
            parameter.put("paidamount", paidamount);
            parameter.put("billamount", billamount);
            parameter.put("paidcredit", paidcredit);
            parameter.put("added_credit", added_credit);
            JasperPrint printit = JasperFillManager.fillReport(RI, parameter, DB.getConnection());
            new JRViewer(printit);
            //JasperPrintManager.printReport(printit, false);
            JasperViewer.viewReport(printit, false);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
    }

    public void grn(int grnid) { //grn report

        String path = "C:\\Program Files\\Common Files\\Report\\GRNreport.jrxml"; // me path eka wenas karaganna
        try {
            JasperReport RI = JasperCompileManager.compileReport(path);
            Map<String, Object> parameter = new HashMap<String, Object>();
            parameter.put("grnid", grnid);
            JasperPrint printit = JasperFillManager.fillReport(RI, parameter, DB.getConnection());
            new JRViewer(printit);
            //JasperPrintManager.printReport(printit, false);
            JasperViewer.viewReport(printit, false);
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            e.printStackTrace();
        }
    }

    
}
