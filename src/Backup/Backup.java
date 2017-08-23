/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backup;

import com.alee.laf.text.WebTextField;
import java.awt.Toolkit;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Buddhika Prasanna
 */
public class Backup {

    private String database, username, password;
    String path0, subpath, dumppath;

    GetData getData;
    //SetData setData;
    ConnectionInfo connectionInfo;
    BackupData backupData;
    //ComponentCreater componentCreater;

    public Backup() {
        getData = ObjectGenarater.getGetData();
        connectionInfo = ObjectGenarater.getConnectionInfo();
        //setData = ObjectGenarater.getSetData();
        backupData = ObjectGenarater.getBackupData();
    }

    public void getBackup(WebTextField txtPath, JFrame frame) {
        String mgsSucces = "Database backup successful.";
        String mgsPath = "Please select backup path for get database backup.";
        String mgsBackup = "Database backup faliure";

        getData.getSQLDumpPath();
        getData.getConnectionInformation();

        database = connectionInfo.getDatabase();
        username = connectionInfo.getUsername();
        password = connectionInfo.getPassword();
        dumppath = backupData.getMysqlDumpPath();

        if (txtPath.getText().equals("")) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(frame, mgsPath, "Database Backup", JOptionPane.WARNING_MESSAGE);
        } else {
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            String strFilename = dateFormat.format(now);
            System.out.println(txtPath.getText());
            String command = "" + dumppath + " -u" + username + " -p" + password + " --add-drop-database -B " + database + " -r " + "\"" + txtPath.getText() + "\\" + strFilename + ".sql\"";
            Process p = null;
            try {
                Runtime runtime = Runtime.getRuntime();
                p = runtime.exec(command);

                int processComplete = p.waitFor();

                if (processComplete == 0) {
                    JOptionPane.showMessageDialog(frame, mgsSucces + txtPath.getText() + "\\" + strFilename + ".sql", "Database Backup", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                    JOptionPane.showMessageDialog(frame, mgsBackup, "Error", JOptionPane.ERROR_MESSAGE);
                    getAction(txtPath, frame);
                }

            } catch (Exception e) {
//                Toolkit.getDefaultToolkit().beep();
//                JOptionPane.showMessageDialog(this, e, "වරදකි", JOptionPane.ERROR_MESSAGE);
                getAction(txtPath, frame);
            }
        }
    }

    public void chooseFolder(WebTextField txtPath, JFrame frame) {
        try {
            JFileChooser fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

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
            filterDump(txtPath, frame);
        } else if (action1 == 1) {
//            this.dispose();
        }
    }

    public void filterDump(WebTextField txtPath, JFrame frame) {
        try {
            JFileChooser fc = new JFileChooser();
            fc.addChoosableFileFilter(new ExeFilter());
            int returnVal = fc.showOpenDialog(frame);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                path0 = file.toString();
                if (!path0.equals(null)) {
                    //setData.updateMysqlDumpPath(path0);
                    getBackup(txtPath, frame);
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

}
