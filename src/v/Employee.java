/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;

import c.EmploayeeLoad;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import m.EmpCredit;

/**
 *
 * @author suhada
 */
public class Employee extends javax.swing.JPanel {

    m.Employee employee = new m.Employee();
    m.Attendance attendance = new m.Attendance();
    m.EmpCredit empcredit;
    m.Salary salary;

    /**
     * Creates new form Employee
     */
    public Employee() {
        initComponents();
        new m.EmpType().loadEmpTypeToCombo(combo_emtype);
        loadDate();
        loadTables();

    }

    public void loadTables() {
        employee.loadEmpTable(tbl_emp);
        employee.loadEmcTable(tbl_emc);
        employee.loadSalTable(tbl_salary);
        employee.loadSalTableTemp(tbl_temp);
        attendance.loadAtendanceTable(tbl_attend, tbl_absent, label_today);

    }

    public void loadDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat month = new SimpleDateFormat("MM");
        String todaty = sdf.format(new Date());
        label_today.setText(todaty);
        jcomb_month.setSelectedItem(month.format(new Date()));
        lb_Credit_Date.setText(todaty);
    }

    public static String getRound(double dd) {
        double round = Math.round(dd * 100.0) / 100.0;
        return round + "";
    }

    public static double getRoundDouble(double dd) {
        double round = Math.round(dd * 100.0) / 100.0;
        return round;
    }

    public Employee(JButton btn_save, JButton btn_searchdate, JComboBox<String> combo_emtype, JComboBox<String> combo_gender, JDateChooser dc_attendance, JButton jButton1, JLabel jLabel1, JLabel jLabel10, JLabel jLabel11, JLabel jLabel12, JLabel jLabel14, JLabel jLabel15, JLabel jLabel2, JLabel jLabel3, JLabel jLabel4, JLabel jLabel5, JLabel jLabel6, JLabel jLabel7, JLabel jLabel8, JLabel jLabel9, JPanel jPanel1, JPanel jPanel10, JPanel jPanel11, JPanel jPanel2, JPanel jPanel3, JPanel jPanel4, JPanel jPanel5, JPanel jPanel6, JPanel jPanel8, JPanel jPanel9, JScrollPane jScrollPane1, JScrollPane jScrollPane2, JScrollPane jScrollPane3, JTabbedPane jTabbedPane1, JLabel label_today, JTable tbl_absent, JTable tbl_attend, JTable tbl_emp, JTextField tf_addressline1, JTextField tf_addressline2, JTextField tf_fname, JTextField tf_lname, JTextField tf_mname, JTextField tf_nic, JTextField tf_nic_search, JTextField tf_phone1, JTextField tf_phone2, JTextField tf_sname) {
        this.btn_save = btn_save;
       // this.btn_searchdate = btn_searchdate;
        this.combo_emtype = combo_emtype;
        this.combo_gender = combo_gender;
        this.dc_attendance = dc_attendance;
        this.jButton1 = jButton1;
        this.jLabel1 = jLabel1;
        this.jLabel10 = jLabel10;
        this.jLabel11 = jLabel11;

        this.jLabel14 = jLabel14;
        this.jLabel15 = jLabel15;
        this.jLabel2 = jLabel2;
        this.jLabel3 = jLabel3;
        this.jLabel4 = jLabel4;
        this.jLabel5 = jLabel5;
        this.jLabel6 = jLabel6;
        this.jLabel7 = jLabel7;
        this.jLabel8 = jLabel8;
        this.jLabel9 = jLabel9;
        this.jPanel1 = jPanel1;
        this.jPanel10 = jPanel10;
        this.jPanel11 = jPanel11;
        this.tab_reg = jPanel2;
        this.tab_all = jPanel3;
        this.jPanel4 = jPanel4;
        this.jPanel5 = jPanel5;
        this.jPanel6 = jPanel6;
        this.tab_attend = jPanel8;
        this.jPanel9 = jPanel9;
        this.jScrollPane1 = jScrollPane1;
        this.jScrollPane2 = jScrollPane2;
        this.jScrollPane3 = jScrollPane3;
        this.Registraion = jTabbedPane1;
        this.label_today = label_today;
        this.tbl_absent = tbl_absent;
        this.tbl_attend = tbl_attend;
        this.tbl_emp = tbl_emp;
        this.tf_addressline1 = tf_addressline1;
        this.tf_addressline2 = tf_addressline2;
        this.tf_fname = tf_fname;
        this.tf_lname = tf_lname;
        this.tf_mname = tf_mname;
        this.tf_nic = tf_nic;

        this.tf_phone1 = tf_phone1;
        this.tf_phone2 = tf_phone2;
        this.tf_sname = tf_sname;
    }

    public static Employee Employee = null;

    public static Employee getInstance() {
        if (Employee == null) {
            Employee = new Employee();
        }
        return Employee;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane8 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        Registraion = new javax.swing.JTabbedPane();
        tab_all = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_emp = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        lb_etype = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lb_eid = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lb_efullname = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lb_enic = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lb_eaddress1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lb_eaddress2 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbl_cucredit = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        btn_update = new javax.swing.JButton();
        tx_year = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        c_month = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        tab_reg = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_sname = new javax.swing.JTextField();
        tf_fname = new javax.swing.JTextField();
        tf_mname = new javax.swing.JTextField();
        tf_lname = new javax.swing.JTextField();
        tf_nic = new javax.swing.JTextField();
        combo_gender = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        combo_emtype = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        lbl_empid = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tf_addressline1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_addressline2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_phone1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tf_phone2 = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        btn_active = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        tab_attend = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_attend = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_absent = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        dc_attendance = new com.toedter.calendar.JDateChooser();
        label_today = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lastdate = new javax.swing.JLabel();
        lastdate1 = new javax.swing.JLabel();
        tab_debit = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        tf_creditamount = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lb_empfullname = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lb_empnic = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lb_empid = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tf_sms = new javax.swing.JTextArea();
        btn_creditPay = new javax.swing.JButton();
        btn_SENSMS = new javax.swing.JButton();
        lb_Credit_Date = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_emc = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lbl_currentcredit = new javax.swing.JLabel();
        dc_credit_date = new com.toedter.calendar.JDateChooser();
        btn_setDate_to_credit = new javax.swing.JButton();
        tab_pay = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        lb_tot = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lb_nic1 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        lb_basic = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        lb_bonus = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        lb_othours = new javax.swing.JLabel();
        lb_otrage = new javax.swing.JLabel();
        lb_ottot = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        lb_days = new javax.swing.JLabel();
        lb_dayrate = new javax.swing.JLabel();
        lb_daytot = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        lb_cutcredit = new javax.swing.JLabel();
        lb_totpay = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        lb_date = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        lb_nic2 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        tf_basic = new javax.swing.JTextField();
        tf_bonas = new javax.swing.JTextField();
        tf_ot_tot = new javax.swing.JTextField();
        tf_day_tot = new javax.swing.JTextField();
        tf_pay_tot = new javax.swing.JTextField();
        tf_total = new javax.swing.JTextField();
        tf_debit = new javax.swing.JTextField();
        tf_day_rate = new javax.swing.JTextField();
        tf_ot_rate = new javax.swing.JTextField();
        tf_ot_hours = new javax.swing.JTextField();
        tf_days = new javax.swing.JTextField();
        btn_pay_salary = new javax.swing.JButton();
        btn_genarate = new javax.swing.JButton();
        jcomb_month = new javax.swing.JComboBox<>();
        jLabel62 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        lb_emtype = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_salary = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_temp = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        tbl_ap = new javax.swing.JTable();
        jPanel25 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        lb_tid = new javax.swing.JLabel();
        tf_temp_tot = new javax.swing.JTextField();
        btn_pay_salary1 = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        dc_tmp_date = new com.toedter.calendar.JDateChooser();
        jLabel81 = new javax.swing.JLabel();

        setBackground(c.View.getInstance().colorTheme);
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 0), 10));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        Registraion.setBackground(new java.awt.Color(255, 255, 255));
        Registraion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Registraion.setMaximumSize(new java.awt.Dimension(32767, 600));
        Registraion.setOpaque(true);
        Registraion.setPreferredSize(new java.awt.Dimension(1084, 600));

        tab_all.setBackground(new java.awt.Color(255, 255, 255));
        tab_all.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tab_allComponentShown(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbl_emp.setRowHeight(25);
        tbl_emp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_emp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Full Name", "Nic", "Phone 1", "Phone 2", "Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_emp.getTableHeader().setReorderingAllowed(false);
        tbl_emp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_empMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_emp);
        if (tbl_emp.getColumnModel().getColumnCount() > 0) {
            tbl_emp.getColumnModel().getColumn(0).setHeaderValue("#");
            tbl_emp.getColumnModel().getColumn(1).setHeaderValue("Full Name");
            tbl_emp.getColumnModel().getColumn(2).setHeaderValue("Nic");
            tbl_emp.getColumnModel().getColumn(3).setHeaderValue("Phone 1");
            tbl_emp.getColumnModel().getColumn(4).setHeaderValue("Phone 2");
            tbl_emp.getColumnModel().getColumn(5).setHeaderValue("Type");
            tbl_emp.getColumnModel().getColumn(6).setHeaderValue("Status");
        }

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("Profile Details ");

        jLabel37.setBackground(new java.awt.Color(255, 255, 255));
        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(102, 102, 255));
        jLabel37.setText("Employe type :");

        lb_etype.setBackground(new java.awt.Color(255, 255, 255));
        lb_etype.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_etype.setForeground(new java.awt.Color(102, 102, 255));
        lb_etype.setText("xxxx");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 255));
        jLabel13.setText("Employe id :");

        lb_eid.setBackground(new java.awt.Color(255, 255, 255));
        lb_eid.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_eid.setForeground(new java.awt.Color(102, 102, 255));
        lb_eid.setText("00");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 255));
        jLabel17.setText("Full Name  :");

        lb_efullname.setBackground(new java.awt.Color(255, 255, 255));
        lb_efullname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_efullname.setForeground(new java.awt.Color(102, 102, 255));
        lb_efullname.setText("xxxx");

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 255));
        jLabel19.setText("NIC  :");

        lb_enic.setBackground(new java.awt.Color(255, 255, 255));
        lb_enic.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_enic.setForeground(new java.awt.Color(102, 102, 255));
        lb_enic.setText("xxxxx");

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 255));
        jLabel21.setText("Address Line 1  :");

        lb_eaddress1.setBackground(new java.awt.Color(255, 255, 255));
        lb_eaddress1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_eaddress1.setForeground(new java.awt.Color(102, 102, 255));
        lb_eaddress1.setText("xxxxxx");

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 255));
        jLabel22.setText("Address Line 2  :");

        lb_eaddress2.setBackground(new java.awt.Color(255, 255, 255));
        lb_eaddress2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_eaddress2.setForeground(new java.awt.Color(102, 102, 255));
        lb_eaddress2.setText("xxxxxx");

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 102, 102));
        jLabel24.setText("Current Debit :");

        lbl_cucredit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_cucredit.setForeground(new java.awt.Color(255, 102, 102));
        lbl_cucredit.setText("00.00");

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        btn_update.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_update.setForeground(new java.awt.Color(0, 102, 255));
        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        tx_year.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tx_year.setForeground(new java.awt.Color(0, 153, 51));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 153, 51));
        jLabel27.setText("Year :");

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 153, 51));
        jLabel28.setText("Month :");

        c_month.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        c_month.setForeground(new java.awt.Color(0, 153, 51));
        c_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 153, 51));
        jButton3.setText("Cheack Attendance   &   Paymant");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(tx_year, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(c_month, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_update)
                .addGap(33, 33, 33)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(tx_year)
                    .addComponent(c_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel24)
                            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22))
                                .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel37, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_etype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_eid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_efullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_enic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_eaddress1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(lb_eaddress2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_cucredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(22, 22, 22))))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(21, 21, 21)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(lb_etype))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lb_eid))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(lb_efullname))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(lb_enic))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(lb_eaddress1))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(lb_eaddress2))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(lbl_cucredit))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tab_allLayout = new javax.swing.GroupLayout(tab_all);
        tab_all.setLayout(tab_allLayout);
        tab_allLayout.setHorizontalGroup(
            tab_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_allLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        tab_allLayout.setVerticalGroup(
            tab_allLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_allLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Registraion.addTab("Employee", tab_all);

        tab_reg.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("First Name :");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Surname :");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Middle Name :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Last Name :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("NIC :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Gender :");

        tf_sname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tf_fname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tf_mname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tf_lname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tf_nic.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        combo_gender.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Type  :");

        combo_emtype.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_emtype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel16.setText("ID :");

        lbl_empid.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_empid.setText("XX");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_sname)
                    .addComponent(tf_fname)
                    .addComponent(tf_mname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_lname, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_nic, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(combo_gender, 0, 398, Short.MAX_VALUE)
                    .addComponent(combo_emtype, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_empid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbl_empid))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_emtype, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_sname, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_mname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nic, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo_gender, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(65, 65, 65))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Address Line 1 :");

        tf_addressline1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Address Line 2 :");

        tf_addressline2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Phone Number 1  :");

        tf_phone1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_phone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_phone1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_phone1KeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Phone Number 2  :");

        tf_phone2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_phone2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_phone2KeyTyped(evt);
            }
        });

        btn_save.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_save.setForeground(new java.awt.Color(0, 153, 51));
        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_active.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_active.setForeground(new java.awt.Color(204, 0, 0));
        btn_active.setText("Deactivate");
        btn_active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activeActionPerformed(evt);
            }
        });

        jLabel26.setText("Deactivate Employee");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_addressline1)
                            .addComponent(tf_addressline2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_phone2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tf_phone1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addGap(0, 284, Short.MAX_VALUE)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_active)))))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tf_addressline1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_addressline2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_phone1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_phone2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_active)
                    .addComponent(jLabel26))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        tab_reg.add(jPanel4, java.awt.BorderLayout.CENTER);

        Registraion.addTab("Register", tab_reg);

        tab_attend.setBackground(new java.awt.Color(255, 255, 255));
        tab_attend.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tab_attendComponentShown(evt);
            }
        });
        tab_attend.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(204, 255, 204));

        tbl_attend.setRowHeight(25);
        tbl_attend.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_attend.setForeground(new java.awt.Color(0, 153, 51));
        tbl_attend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "NIC", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_attend.getTableHeader().setReorderingAllowed(false);
        tbl_attend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_attendMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_attend);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Prasent");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 204, 204));

        tbl_absent.setRowHeight(25);
        tbl_absent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_absent.setForeground(new java.awt.Color(255, 102, 0));
        tbl_absent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Full Name", "NIC", "Type"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_absent.getTableHeader().setReorderingAllowed(false);
        tbl_absent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_absentMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_absent);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Absent");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dc_attendance.setDateFormatString("yyyy-MM-dd");
        dc_attendance.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dc_attendance.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dc_attendancePropertyChange(evt);
            }
        });

        label_today.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        label_today.setForeground(new java.awt.Color(51, 51, 255));
        label_today.setText("yyyy-MM-dd");

        jButton1.setBackground(new java.awt.Color(0, 102, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 102, 0));
        jButton1.setText("Mark All");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        lastdate.setBackground(new java.awt.Color(204, 204, 204));
        lastdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lastdate.setForeground(new java.awt.Color(153, 153, 153));
        lastdate.setText("yyyy-MM-dd");

        lastdate1.setBackground(new java.awt.Color(204, 204, 204));
        lastdate1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lastdate1.setForeground(new java.awt.Color(153, 153, 153));
        lastdate1.setText("Last Attendance Mark :");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(dc_attendance, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(label_today, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addComponent(lastdate1)
                                .addGap(18, 18, 18)
                                .addComponent(lastdate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_today)
                    .addComponent(dc_attendance, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastdate)
                    .addComponent(lastdate1))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab_attend.add(jPanel9, java.awt.BorderLayout.CENTER);

        Registraion.addTab("Attendance", tab_attend);

        tab_debit.setBackground(new java.awt.Color(255, 255, 255));
        tab_debit.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tab_debitComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tf_creditamount.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_creditamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_creditamountActionPerformed(evt);
            }
        });
        tf_creditamount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_creditamountKeyTyped(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel20.setText("Date :");

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel35.setText("Credit Amount :");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel36.setText("SMS :");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Emp Full Name :");

        lb_empfullname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_empfullname.setText("xxxxxxxxxx");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel38.setText("Emp NIC :");

        lb_empnic.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_empnic.setText("xxxxxxxxxx");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel41.setText("Emp ID :");

        lb_empid.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_empid.setText("xx");

        tf_sms.setColumns(20);
        tf_sms.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tf_sms.setRows(5);
        jScrollPane4.setViewportView(tf_sms);

        btn_creditPay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_creditPay.setForeground(new java.awt.Color(0, 204, 0));
        btn_creditPay.setText("Pay");
        btn_creditPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_creditPayActionPerformed(evt);
            }
        });

        btn_SENSMS.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_SENSMS.setText("Send sms");
        btn_SENSMS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SENSMSActionPerformed(evt);
            }
        });

        lb_Credit_Date.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lb_Credit_Date.setText("YYYY-MM-DD");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel38)
                    .addComponent(jLabel20)
                    .addComponent(jLabel35)
                    .addComponent(jLabel41)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btn_SENSMS)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_empfullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btn_creditPay, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4)
                                    .addComponent(tf_creditamount))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(lb_empid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lb_empnic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lb_Credit_Date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(lb_empid, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_empfullname, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_empnic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(lb_Credit_Date))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(tf_creditamount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(btn_creditPay)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btn_SENSMS)
                .addContainerGap())
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        tbl_emc.setRowHeight(25);
        tbl_emc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_emc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Full Name", "NIC", "Credit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_emc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_emcMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_emc);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("Current Creidt :");

        lbl_currentcredit.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lbl_currentcredit.setForeground(new java.awt.Color(255, 102, 51));
        lbl_currentcredit.setText("00.00");

        dc_credit_date.setDateFormatString("yyyy-MM-dd");
        dc_credit_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dc_credit_date.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                dc_credit_dateAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        dc_credit_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dc_credit_dateMouseClicked(evt);
            }
        });

        btn_setDate_to_credit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_setDate_to_credit.setText("Set Date");
        btn_setDate_to_credit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setDate_to_creditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(lbl_currentcredit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(dc_credit_date, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_setDate_to_credit)
                .addGap(22, 22, 22))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_setDate_to_credit)
                    .addComponent(dc_credit_date, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(lbl_currentcredit))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout tab_debitLayout = new javax.swing.GroupLayout(tab_debit);
        tab_debit.setLayout(tab_debitLayout);
        tab_debitLayout.setHorizontalGroup(
            tab_debitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tab_debitLayout.setVerticalGroup(
            tab_debitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab_debitLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );

        Registraion.addTab("Credit", tab_debit);

        tab_pay.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tab_payComponentShown(evt);
            }
        });
        tab_pay.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(0, 153, 51));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Last Month Details "));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 255));
        jLabel25.setText("Total :");

        lb_tot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_tot.setForeground(new java.awt.Color(51, 51, 255));
        lb_tot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_tot.setText("00");

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Nic :");

        lb_nic1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_nic1.setText("00");

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Basic :");

        lb_basic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_basic.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_basic.setText("00");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Bonus :");

        lb_bonus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_bonus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_bonus.setText("00");

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("OT :");

        lb_othours.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_othours.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_othours.setText("0000");

        lb_otrage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_otrage.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_otrage.setText("0000");

        lb_ottot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_ottot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_ottot.setText("00.00");

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Day :");

        lb_days.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_days.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_days.setText("0000");

        lb_dayrate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_dayrate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_dayrate.setText("0000");

        lb_daytot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_daytot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_daytot.setText("00.00");

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 51, 51));
        jLabel55.setText("Cut For Debit  :");

        lb_cutcredit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_cutcredit.setForeground(new java.awt.Color(255, 51, 51));
        lb_cutcredit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_cutcredit.setText("00");

        lb_totpay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_totpay.setForeground(new java.awt.Color(0, 153, 51));
        lb_totpay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lb_totpay.setText("00");

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 153, 51));
        jLabel58.setText("Total Pay :");

        lb_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_date.setForeground(new java.awt.Color(0, 153, 51));
        lb_date.setText("YYYY-MM-DD");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel58))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel45)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel55)
                                    .addComponent(jLabel43))))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_nic1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(lb_date)
                        .addGap(121, 121, 121))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lb_othours, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(lb_days, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_otrage, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_dayrate, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_bonus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_totpay, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_daytot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_ottot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_tot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_cutcredit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_basic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(5, 5, 5))))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(lb_nic1)
                    .addComponent(lb_date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_basic)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(lb_bonus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(lb_othours)
                    .addComponent(lb_otrage)
                    .addComponent(lb_ottot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_daytot)
                    .addComponent(lb_dayrate)
                    .addComponent(lb_days)
                    .addComponent(jLabel51))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tot)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_cutcredit)
                    .addComponent(jLabel55))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_totpay)
                    .addComponent(jLabel58))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "This Month"));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(51, 51, 255));
        jLabel59.setText("Total :");

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setText("ID :");

        lb_nic2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_nic2.setText("00");

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setText("Basic :");

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setText("Bonus :");

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setText("OT Hours :");

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setText("Working Days :");

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 51, 51));
        jLabel75.setText("Cut For Debit  :");

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(0, 153, 0));
        jLabel78.setText("Total Pay :");

        tf_basic.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_basic.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_basic.setText("0");
        tf_basic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_basicKeyTyped(evt);
            }
        });

        tf_bonas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_bonas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_bonas.setText("0");
        tf_bonas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_bonasKeyTyped(evt);
            }
        });

        tf_ot_tot.setEditable(false);
        tf_ot_tot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ot_tot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        tf_day_tot.setEditable(false);
        tf_day_tot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_day_tot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        tf_pay_tot.setEditable(false);
        tf_pay_tot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_pay_tot.setForeground(new java.awt.Color(0, 153, 0));
        tf_pay_tot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        tf_total.setEditable(false);
        tf_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_total.setForeground(new java.awt.Color(0, 51, 255));
        tf_total.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        tf_debit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_debit.setForeground(new java.awt.Color(255, 0, 51));
        tf_debit.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_debit.setText("0");
        tf_debit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_debitKeyTyped(evt);
            }
        });

        tf_day_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_day_rate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_day_rate.setText("0");
        tf_day_rate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_day_rateKeyTyped(evt);
            }
        });

        tf_ot_rate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ot_rate.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_ot_rate.setText("0");
        tf_ot_rate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_ot_rateKeyTyped(evt);
            }
        });

        tf_ot_hours.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_ot_hours.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tf_ot_hours.setText("0");
        tf_ot_hours.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_ot_hoursKeyTyped(evt);
            }
        });

        tf_days.setEditable(false);
        tf_days.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_days.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btn_pay_salary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_pay_salary.setForeground(new java.awt.Color(0, 153, 51));
        btn_pay_salary.setText("Pay");
        btn_pay_salary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pay_salaryActionPerformed(evt);
            }
        });

        btn_genarate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_genarate.setForeground(new java.awt.Color(51, 51, 255));
        btn_genarate.setText("Calculate");
        btn_genarate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_genarateActionPerformed(evt);
            }
        });

        jcomb_month.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jcomb_month.setForeground(new java.awt.Color(0, 0, 204));
        jcomb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        jcomb_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomb_monthActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(204, 0, 0));
        jLabel62.setText("Select Month :");

        jLabel68.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel68.setText("Per Hour :");

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setText("Per Day :");

        lb_emtype.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_emtype.setText("TYPE");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel61)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lb_nic2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel62))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel65))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                .addComponent(lb_emtype, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel63)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcomb_month, 0, 81, Short.MAX_VALUE)
                            .addComponent(tf_basic)
                            .addComponent(tf_bonas)
                            .addComponent(tf_ot_tot)))
                    .addComponent(btn_pay_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel67, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel71, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tf_ot_hours, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                                    .addComponent(tf_days))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                        .addComponent(jLabel68)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_ot_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel59, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel75, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                                        .addComponent(jLabel69)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tf_day_rate, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel78, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(35, 35, 35))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(btn_genarate, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_pay_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_debit, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                .addComponent(tf_total, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_day_tot)))))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(lb_nic2)
                            .addComponent(jLabel62))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_emtype))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jcomb_month, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel63)
                            .addComponent(tf_basic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_bonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel65))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_ot_tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tf_ot_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel68)
                        .addComponent(tf_ot_hours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel71)
                    .addComponent(tf_day_tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_day_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_days, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel69))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel59))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(tf_debit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tf_pay_tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pay_salary, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_genarate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        tbl_salary.setRowHeight(25);
        tbl_salary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_salary.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Full Name", "NIC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_salary.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_salaryMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbl_salary);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tab_pay.add(jPanel3, java.awt.BorderLayout.CENTER);

        Registraion.addTab("Salery Perment", tab_pay);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel22ComponentShown(evt);
            }
        });

        jPanel23.setLayout(new java.awt.BorderLayout());

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        tbl_temp.setRowHeight(25);
        tbl_temp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_temp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Full Name", "NIC"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_temp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tempMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_temp);

        tbl_ap.setRowHeight(25);
        tbl_ap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_ap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Attandance And Payment"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(tbl_ap);

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                    .addComponent(jScrollPane9))
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setText("ID :");

        lb_tid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_tid.setText("00");

        tf_temp_tot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_temp_tot.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btn_pay_salary1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_pay_salary1.setForeground(new java.awt.Color(0, 153, 51));
        btn_pay_salary1.setText("Pay");
        btn_pay_salary1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pay_salary1ActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(204, 0, 0));
        jLabel74.setText("Select Date :");

        dc_tmp_date.setDateFormatString("yyyy-MM-dd");
        dc_tmp_date.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dc_tmp_date.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                dc_tmp_dateAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        dc_tmp_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dc_tmp_dateMouseClicked(evt);
            }
        });

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setText("Total :");

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(0, 47, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel64)
                        .addGap(34, 34, 34)
                        .addComponent(lb_tid, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addGap(43, 43, 43)
                        .addComponent(dc_tmp_date, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btn_pay_salary1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel25Layout.createSequentialGroup()
                            .addComponent(jLabel81)
                            .addGap(18, 18, 18)
                            .addComponent(tf_temp_tot, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_tid)
                    .addComponent(jLabel64))
                .addGap(27, 27, 27)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dc_tmp_date, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jLabel74, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_temp_tot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel81))
                .addGap(18, 18, 18)
                .addComponent(btn_pay_salary1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        Registraion.addTab("Salery Tempory", jPanel22);

        jPanel1.add(Registraion, java.awt.BorderLayout.PAGE_START);

        jScrollPane8.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:      
        employee.save(lbl_empid, combo_emtype, tf_sname, tf_fname, tf_mname, tf_lname, tf_nic, combo_gender, tf_addressline1, tf_addressline2, tf_phone1, tf_phone2);

        loadTables();

    }//GEN-LAST:event_btn_saveActionPerformed

    private void tbl_attendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_attendMouseClicked
        // TODO add your handling code here:
        attendance.selectAbsent(tbl_attend, tbl_absent);
    }//GEN-LAST:event_tbl_attendMouseClicked

    private void tbl_absentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_absentMouseClicked
        // TODO add your handling code here:
        attendance.selectPresent(tbl_absent, tbl_attend);
    }//GEN-LAST:event_tbl_absentMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        attendance.marckAttendance(tbl_attend, tbl_absent, label_today, dc_attendance);
        attendance.getLastAttendanceMarckDate(lastdate);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // Load employ to update

        employee.loadToUpdateEmp(lb_eid, combo_emtype, tf_sname, tf_fname, tf_mname, tf_lname, tf_nic, combo_gender, tf_addressline1, tf_addressline2, tf_phone1, tf_phone2, lbl_empid, btn_active);

        Registraion.setSelectedComponent(tab_reg);
    }//GEN-LAST:event_btn_updateActionPerformed

    private void tbl_empMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_empMouseClicked

        employee.LoadEmployee(tbl_emp, lb_etype, lb_eid, lb_efullname, lb_enic, lb_eaddress1, lb_eaddress2, lbl_cucredit);


    }//GEN-LAST:event_tbl_empMouseClicked

    private void btn_activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activeActionPerformed
        // TODO add your handling code here:

        employee.deleteEmploy(lbl_empid);

        loadTables();
        employee.clear(lbl_empid, combo_emtype, tf_sname, tf_fname, tf_mname, tf_lname, tf_nic, combo_gender, tf_addressline1, tf_addressline2, tf_phone1, tf_phone2);
    }//GEN-LAST:event_btn_activeActionPerformed

    private void tf_creditamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_creditamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_creditamountActionPerformed

    private void btn_creditPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_creditPayActionPerformed

        empcredit.pay(lb_empid, tf_creditamount, tf_sms, lb_Credit_Date);
        loadTables();


    }//GEN-LAST:event_btn_creditPayActionPerformed

    private void tbl_emcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_emcMouseClicked
        // TODO add your handling code here:
        empcredit = new m.EmpCredit();
        empcredit.loadForCredit(tbl_emc, lb_empid, lb_empfullname, lb_empnic, lbl_currentcredit);
    }//GEN-LAST:event_tbl_emcMouseClicked

    private void tbl_salaryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_salaryMouseClicked
        // TODO add your handling code here:
        salary = new m.Salary();

        salary.loadDetails(tbl_salary, jcomb_month, tf_basic, tf_bonas, tf_ot_hours, tf_ot_rate, tf_ot_tot, tf_days, tf_day_rate, tf_day_tot, tf_total, tf_debit, tf_pay_tot, lb_nic2);
        salary.loadOld(jcomb_month, tbl_salary, lb_date, lb_basic, lb_bonus, lb_ottot, lb_daytot, lb_otrage, lb_othours, lb_dayrate, lb_days, lb_tot, lb_cutcredit, lb_totpay);


    }//GEN-LAST:event_tbl_salaryMouseClicked

    private void btn_pay_salaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pay_salaryActionPerformed
        // TODO add your handling code here:

        salary.paySalary(jcomb_month, lb_nic2, tf_basic, tf_bonas, tf_ot_hours, tf_ot_rate, tf_ot_tot, tf_days, tf_day_rate, tf_day_tot, tf_total, tf_debit, tf_pay_tot);
        loadTables();

    }//GEN-LAST:event_btn_pay_salaryActionPerformed

    private void btn_genarateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_genarateActionPerformed
        // TODO add your handling code here:

        salary.cheackRate(jcomb_month, tf_basic, tf_bonas, tf_ot_hours, tf_ot_rate, tf_ot_tot, tf_days, tf_day_rate, tf_day_tot, tf_total, tf_debit, tf_pay_tot);
    }//GEN-LAST:event_btn_genarateActionPerformed

    private void jcomb_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomb_monthActionPerformed
        // TODO add your handling code here:
        // salary.loadAttend(jcomb_month, tf_days);
    }//GEN-LAST:event_jcomb_monthActionPerformed

    private void btn_SENSMSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SENSMSActionPerformed
        // SEND SMS
        empcredit.sendSMS(lb_empid, tf_creditamount, tf_sms); // SMS SEND
        loadTables();

    }//GEN-LAST:event_btn_SENSMSActionPerformed

    private void tf_phone1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_phone1KeyReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_tf_phone1KeyReleased

    private void tf_phone1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_phone1KeyTyped
        // TODO add your handling code here:
        m.Employee.validateNumber(tf_phone1, evt);

    }//GEN-LAST:event_tf_phone1KeyTyped

    private void tf_phone2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_phone2KeyTyped
        // TODO add your handling code here:
        m.Employee.validateNumber(tf_phone2, evt);
    }//GEN-LAST:event_tf_phone2KeyTyped

    private void tf_creditamountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_creditamountKeyTyped
        // Double Validation
        m.Employee.validateDouble(tf_creditamount, evt);


    }//GEN-LAST:event_tf_creditamountKeyTyped

    private void tf_basicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_basicKeyTyped
        // TODO add your handling code here:
        m.Employee.validateDouble(tf_basic, evt);
    }//GEN-LAST:event_tf_basicKeyTyped

    private void tf_bonasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_bonasKeyTyped
        // TODO add your handling code here:
        m.Employee.validateDouble(tf_bonas, evt);
    }//GEN-LAST:event_tf_bonasKeyTyped

    private void tf_ot_rateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ot_rateKeyTyped
        // TODO add your handling code here:
        m.Employee.validateDouble(tf_ot_rate, evt);
    }//GEN-LAST:event_tf_ot_rateKeyTyped

    private void tf_day_rateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_day_rateKeyTyped
        // TODO add your handling code here:
        m.Employee.validateDouble(tf_day_rate, evt);
    }//GEN-LAST:event_tf_day_rateKeyTyped

    private void tf_ot_hoursKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_ot_hoursKeyTyped
        // TODO add your handling code here:
        m.Employee.validateDouble(tf_ot_hours, evt);
    }//GEN-LAST:event_tf_ot_hoursKeyTyped

    private void tf_debitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_debitKeyTyped
        // TODO add your handling code here:
        m.Employee.validateDouble(tf_debit, evt);
    }//GEN-LAST:event_tf_debitKeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        v.Attendance at = new Attendance(c_month, lb_eid, tx_year);
        at.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void dc_credit_dateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_dc_credit_dateAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dc_credit_dateAncestorAdded

    private void dc_credit_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dc_credit_dateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dc_credit_dateMouseClicked

    private void btn_setDate_to_creditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_setDate_to_creditActionPerformed
        // TODO add your handling code here:
        new m.EmpCredit().setLableToDate(dc_credit_date, lb_Credit_Date);

    }//GEN-LAST:event_btn_setDate_to_creditActionPerformed

    private void tbl_tempMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tempMouseClicked
        // TODO add your handling code here:

        employee.loadForTempSalery(tbl_temp, lb_tid, tbl_ap);


    }//GEN-LAST:event_tbl_tempMouseClicked

    private void dc_tmp_dateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dc_tmp_dateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dc_tmp_dateMouseClicked

    private void dc_tmp_dateAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_dc_tmp_dateAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_dc_tmp_dateAncestorAdded

    private void btn_pay_salary1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pay_salary1ActionPerformed
        // TODO add your handling code here:

        new m.Salary().temPay(lb_tid, dc_tmp_date, tf_temp_tot);
        loadTables();


    }//GEN-LAST:event_btn_pay_salary1ActionPerformed

    private void tab_allComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tab_allComponentShown
        // TODO add your handling code here:
        employee.loadEmpTable(tbl_emp);

    }//GEN-LAST:event_tab_allComponentShown

    private void tab_attendComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tab_attendComponentShown
        // TODO add your handling code here:
        attendance.loadAtendanceTable(tbl_attend, tbl_absent, label_today);
        attendance.getLastAttendanceMarckDate(lastdate);
    }//GEN-LAST:event_tab_attendComponentShown

    private void tab_debitComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tab_debitComponentShown
        // TODO add your handling code here:
        employee.loadEmcTable(tbl_emc);

    }//GEN-LAST:event_tab_debitComponentShown

    private void tab_payComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tab_payComponentShown
        // TODO add your handling code here:
        employee.loadSalTable(tbl_salary);

    }//GEN-LAST:event_tab_payComponentShown

    private void jPanel22ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel22ComponentShown
        // TODO add your handling code here:
        employee.loadSalTableTemp(tbl_temp);
    }//GEN-LAST:event_jPanel22ComponentShown

    private void dc_attendancePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dc_attendancePropertyChange
        // TODO add your handling code here:

        if (dc_attendance.getDate() != null) {  
            Date date = dc_attendance.getDate();
            String format = new SimpleDateFormat("yyyy-MM-dd").format(date);
            label_today.setText(format);
            attendance.loadAtendanceTable(tbl_attend, tbl_absent, label_today);
        }

    }//GEN-LAST:event_dc_attendancePropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Registraion;
    private javax.swing.JButton btn_SENSMS;
    private javax.swing.JButton btn_active;
    private javax.swing.JButton btn_creditPay;
    private javax.swing.JButton btn_genarate;
    private javax.swing.JButton btn_pay_salary;
    private javax.swing.JButton btn_pay_salary1;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_setDate_to_credit;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox<String> c_month;
    private javax.swing.JComboBox<String> combo_emtype;
    private javax.swing.JComboBox<String> combo_gender;
    private com.toedter.calendar.JDateChooser dc_attendance;
    private com.toedter.calendar.JDateChooser dc_credit_date;
    private com.toedter.calendar.JDateChooser dc_tmp_date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> jcomb_month;
    private javax.swing.JLabel label_today;
    private javax.swing.JLabel lastdate;
    private javax.swing.JLabel lastdate1;
    private javax.swing.JLabel lb_Credit_Date;
    private javax.swing.JLabel lb_basic;
    private javax.swing.JLabel lb_bonus;
    private javax.swing.JLabel lb_cutcredit;
    private javax.swing.JLabel lb_date;
    private javax.swing.JLabel lb_dayrate;
    private javax.swing.JLabel lb_days;
    private javax.swing.JLabel lb_daytot;
    private javax.swing.JLabel lb_eaddress1;
    private javax.swing.JLabel lb_eaddress2;
    private javax.swing.JLabel lb_efullname;
    private javax.swing.JLabel lb_eid;
    private javax.swing.JLabel lb_empfullname;
    private javax.swing.JLabel lb_empid;
    private javax.swing.JLabel lb_empnic;
    private javax.swing.JLabel lb_emtype;
    private javax.swing.JLabel lb_enic;
    private javax.swing.JLabel lb_etype;
    private javax.swing.JLabel lb_nic1;
    private javax.swing.JLabel lb_nic2;
    private javax.swing.JLabel lb_othours;
    private javax.swing.JLabel lb_otrage;
    private javax.swing.JLabel lb_ottot;
    private javax.swing.JLabel lb_tid;
    private javax.swing.JLabel lb_tot;
    private javax.swing.JLabel lb_totpay;
    private javax.swing.JLabel lbl_cucredit;
    private javax.swing.JLabel lbl_currentcredit;
    private javax.swing.JLabel lbl_empid;
    private javax.swing.JPanel tab_all;
    private javax.swing.JPanel tab_attend;
    private javax.swing.JPanel tab_debit;
    private javax.swing.JPanel tab_pay;
    private javax.swing.JPanel tab_reg;
    private javax.swing.JTable tbl_absent;
    private javax.swing.JTable tbl_ap;
    private javax.swing.JTable tbl_attend;
    private javax.swing.JTable tbl_emc;
    private javax.swing.JTable tbl_emp;
    private javax.swing.JTable tbl_salary;
    private javax.swing.JTable tbl_temp;
    private javax.swing.JTextField tf_addressline1;
    private javax.swing.JTextField tf_addressline2;
    private javax.swing.JTextField tf_basic;
    private javax.swing.JTextField tf_bonas;
    private javax.swing.JTextField tf_creditamount;
    private javax.swing.JTextField tf_day_rate;
    private javax.swing.JTextField tf_day_tot;
    private javax.swing.JTextField tf_days;
    private javax.swing.JTextField tf_debit;
    private javax.swing.JTextField tf_fname;
    private javax.swing.JTextField tf_lname;
    private javax.swing.JTextField tf_mname;
    private javax.swing.JTextField tf_nic;
    private javax.swing.JTextField tf_ot_hours;
    private javax.swing.JTextField tf_ot_rate;
    private javax.swing.JTextField tf_ot_tot;
    private javax.swing.JTextField tf_pay_tot;
    private javax.swing.JTextField tf_phone1;
    private javax.swing.JTextField tf_phone2;
    private javax.swing.JTextArea tf_sms;
    private javax.swing.JTextField tf_sname;
    private javax.swing.JTextField tf_temp_tot;
    private javax.swing.JTextField tf_total;
    private javax.swing.JTextField tx_year;
    // End of variables declaration//GEN-END:variables

    private void DefaultTableModel(JTable tbl_attend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
