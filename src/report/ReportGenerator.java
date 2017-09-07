/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package report;

import java.awt.Toolkit;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author suhada
 */
public class ReportGenerator {
    private static ReportGenerator ReportGenerator=null;
    private ReportGenerator(){}
    public static ReportGenerator getInstance(){
        if(ReportGenerator==null)ReportGenerator=new ReportGenerator();
        return ReportGenerator;
    }
    public void generate(String reportName,Map<String, Object> parameter){
        try {
            String path="C:\\Program Files\\Common Files\\Report\\"+reportName;
            JasperReport RI = JasperCompileManager.compileReport(path);
            JasperPrint printit = JasperFillManager.fillReport(RI, parameter, DB.getConnection());
            JasperViewer.viewReport(printit, false);
        } catch (JRException ex) {
            Toolkit.getDefaultToolkit().beep();
            ex.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
