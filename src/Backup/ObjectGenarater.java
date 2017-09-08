/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backup;

/**
 *
 * @author Buddhika Prasanna
 */
public class ObjectGenarater {

    //Classes
    private static BackupData backupData;
    private static ConnectionInfo connectionInfo;
    private static GetData getData;
    private static Backup backup;
    private static Restore restore;
    private static RestoreData restoreData;

    /**
     * @return the backupData
     */
    public static BackupData getBackupData() {
        if (backupData == null) {
            backupData = new BackupData();
        }
        return backupData;
    }

    /**
     * @return the connectionInfo
     */
    public static ConnectionInfo getConnectionInfo() {
        if (connectionInfo == null) {
            connectionInfo = new ConnectionInfo();
        }
        return connectionInfo;
    }

    /**
     * @return the getData
     */
    public static GetData getGetData() {
        if (getData == null) {
            getData = new GetData();
        }
        return getData;
    }

    /**
     * @return the backup
     */
    public static Backup getBackup() {
        if (backup == null) {
            backup = new Backup();
        }
        return backup;
    }

    /**
     * @return the restore_01
     */
    public static Restore getRestoreC() {
        if (restore == null) {
            restore = new Restore();
        }
        return restore;
    }

    /**
     * @return the restoreData
     */
    public static RestoreData getRestoreData() {
        if (restoreData == null) {
            restoreData = new RestoreData();
        }
        return restoreData;
    }
}
