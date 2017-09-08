/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backup;

//import Modules.ComponentCreater;
import com.alee.laf.text.WebTextField;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Buddhika Prasanna
 */
public class Restore {

    private String database, username, password;
    String path0, subpath, mysqlpath;

    GetData getData;
    //SetData setData;
    ConnectionInfo connectionInfo;
    RestoreData restoreData;
    //ComponentCreater componentCreater;

    public Restore() {
        getData = ObjectGenarater.getGetData();
        connectionInfo = ObjectGenarater.getConnectionInfo();
        //setData = ObjectGenarater.getSetData();
        restoreData = ObjectGenarater.getRestoreData();
    }

    public void getRestore(WebTextField txtPath, JFrame frame) {
        String mgsPath = "Please select the sql backup file.";
        mysqlpath = restoreData.getMysqlPath();
        getData.getConnectionInformation();

        username = connectionInfo.getUsername();
        password = connectionInfo.getPassword();

        if (txtPath.getText().equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(frame, mgsPath, "Databse restore", JOptionPane.WARNING_MESSAGE);
        } else {
            restoreDB(username, password, txtPath.getText().toString(), txtPath, frame);
        }
    }

    public boolean restoreDB(String dbUserName, String dbPassword, String source, WebTextField txtPath, JFrame frame) {
        String mgsSucces = "Backup restore successfull.";
        String mgsBackup = "Backup restore faliure.";
        String[] executeCmd = new String[]{"" + mysqlpath + "", "--user=" + dbUserName, "--password=" + dbPassword, "-e", "source " + source};

        Process runtimeProcess;
        try {

            runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();

            if (processComplete == 0) {
                //lblMessage.setText("<html><font color='green'>Backup restored successfully!</font></html>");
                JOptionPane.showMessageDialog(frame, mgsSucces, "Backup restore", JOptionPane.INFORMATION_MESSAGE);
                txtPath.setText(null);

                return true;
            } else {
                // lblMessage.setText("<html><font color='red'>Could not restore the backup!</font></html>");
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(frame, mgsBackup, "Error", JOptionPane.ERROR_MESSAGE);
                getAction(txtPath, frame);
            }
        } catch (Exception e) {
//            Toolkit.getDefaultToolkit().beep();
//            JOptionPane.showMessageDialog(this, e, "වරදකි", JOptionPane.ERROR_MESSAGE);
            getAction(txtPath, frame);
        }

        return false;

    }

    public void chooseFile(WebTextField txtPath, JFrame frame) {
        try {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.addChoosableFileFilter(new SqlFilter());
            int returnVal = fc.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                txtPath.setText(file.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getAction(WebTextField txtPath, JFrame frame) {
        String mgsError = "Database backup failure.can't find mysql dump ." + "Must be search mysql dump for get database backup.Please search him.";
        Toolkit.getDefaultToolkit().beep();
        int action1 = JOptionPane.showConfirmDialog(frame, mgsError, "Warning", JOptionPane.WARNING_MESSAGE);
        if (action1 == 0) {
            filterMySQL(txtPath, frame);
        } else if (action1 == 1) {
//            this.dispose();
        }
    }

    public void filterMySQL(WebTextField txtPath, JFrame frame) {
        try {
            JFileChooser fc = new JFileChooser();
            fc.addChoosableFileFilter(new ExeFilter());
            int returnVal = fc.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                path0 = file.toString();
                if (!path0.equals(null)) {
                    //setData.updateMysqlDumpPath(path0);
                    getRestore(txtPath, frame);
                }
            }
        } catch (Exception e) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    class ExeFilter extends javax.swing.filechooser.FileFilter {

        public boolean accept(File file) {
            String filename = file.getName();
            return filename.endsWith(".exe");
        }

        public String getDescription() {
            return "*.exe";
        }
    }

    class SqlFilter extends javax.swing.filechooser.FileFilter {

        public boolean accept(File file) {
            String filename = file.getName();
            return filename.endsWith(".sql");
        }

        public String getDescription() {
            return "*.sql";
        }
    }

}
