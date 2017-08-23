
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v;

import c.AssetControl;
import c.AutoComplete;
import c.DeleverySelfProduct;
import c.DeliveryInvoice;
import c.Errormzg;
import c.RouteCreditTableView;
import c.RouteCreditUpdate;
import c.RouteDebitTableView;
import c.RouteDebitUpdate;
import c.RouteRegister;
import c.RouteUpdate;
import c.RouteViewTable;
import c.VehicleRegister;
import c.VehicleReturn;
import c.VehicleUpdate;
import c.VehicleViewTable;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import m.DeliverDetail;
import m.ValueValidation;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import static v.frmDeleverySummery.tpDelivery;

/**
 *
 * @author Me
 */
public class Delivery extends javax.swing.JPanel {

    /**
     * Creates new form Vehicle
     */
    private VehicleViewTable vehicleViewTable = null;
    private RouteViewTable routeViewTable = null;
    private RouteCreditTableView routeCreditTableView = null;
    private RouteDebitTableView routeDebitTableView = null;
    private c.AutoComplete ac;
    ValueValidation validation;

    private void clear() {

        //tf_regNumber2.setText(null);
        tf_regNumber1.setText(null);
        int rowCount = tbl_allVehicles.getRowCount();
        tf_id.setText(String.valueOf(rowCount + 1));
        //autoComplete = new AutoComplete();
    }

    private void clearRoute() {
        tf_routeName.setText(null);
        ta_routeDescription.setText(null);
        tf_currentCredit.setText(null);
        int rowCount = tbl_routeDetails.getRowCount();
        tf_routeId.setText(String.valueOf(rowCount + 1));
        //autoComplete = new AutoComplete();
    }

    private void clearRouteCredit() {

        //dc_routeCreditDate.setDate(new Date());
        //tf_routeCredit.setText(null);
        //tf_routeIDCredit.setText(null);
        //tf_routeNameCredit.setText(null);
        //routeCreditTableView.setRouteCreditTableData(tbl_routeCredit);
        //int rowCount = tbl_routeCredit.getRowCount();
        //tf_routeCreditId.setText(String.valueOf(rowCount + 1));
        //autoComplete = new AutoComplete();
    }

    public void clearRouteDebit() {
        try {

            dc_routeDebitDate.setDate(new Date());
            tf_routeDebit.setText(null);
            tf_routeIdDebit.setText(null);
            tf_routeNameDebit.setText(null);
            routeDebitTableView.setRouteCreditTableData(tbl_routeDebit, dc_routeDebitDate);
            //int rowCount = tbl_routeDebit.getRowCount();
            //tf_routeDebitId.setText(String.valueOf(rowCount + 1));
            //autoComplete = new AutoComplete();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Delivery() {
        initComponents();
        validation = new ValueValidation();

        vehicleViewTable = new VehicleViewTable();
        vehicleViewTable.setTableData(tbl_allVehicles);

        routeViewTable = new RouteViewTable();
        routeViewTable.setrouteTableData(tbl_routeDetails);

        //routeCreditTableView = new RouteCreditTableView();
        //routeCreditTableView.setRouteCreditTableData(tbl_routeCredit);
        routeDebitTableView = new RouteDebitTableView();
        routeDebitTableView.setRouteCreditTableData(tbl_routeDebit, dc_routeDebitDate);

        ac = new AutoComplete();
        ac.acProductName(txtProductName);
        ac.acProductName(txtPnameDI);
        ac.acProductName(txtSPName);
        ac.acProductName(txtTPName);
        ac.autoCompleteBankName(txtCPB);
        ac.autocompleteRouteRegNam(txtRouteNameVR);
        ac.autoCompleteVehicleNumber(txtVehicleNumberVR);
        ac.autocompleteRouteRegNam(txtRouteNameDI);
        ac.autoCompleteVehicleNumber(txtVehicleNumberDI);
        ac.autocompleteRouteRegNam(txtRouteNameSP);
        ac.autoCompleteVehicleNumber(txtVehicleNameSP);
        ac.autocompleteRouteRegNam(txtRouteNameR);
        ac.autoCompleteVehicleNumber(txtVehicleNumberR);
        clear();
        clearRoute();
        //clearRouteCredit();
        clearRouteDebit();

    }
    public static Delivery vehicle = null;

    public static Delivery getInstance() {
        if (vehicle == null) {
            vehicle = new Delivery();
        }
        return vehicle;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        txtProductName = new javax.swing.JTextField();
        txtUnitName = new javax.swing.JTextField();
        txtLQ = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        btnAI = new javax.swing.JButton();
        btnDeal = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        jPanel23 = new javax.swing.JPanel();
        btnRI = new javax.swing.JButton();
        btnRA = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        lblLastDeliverDate = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel39 = new javax.swing.JPanel();
        txtSPName = new javax.swing.JTextField();
        txtSPunit = new javax.swing.JTextField();
        txtTPName = new javax.swing.JTextField();
        txtTPUnit = new javax.swing.JTextField();
        txtCPB = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        txtRemainQty = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        txtCPL = new javax.swing.JTextField();
        txtOC = new javax.swing.JTextField();
        txtTQty = new javax.swing.JTextField();
        txtTC = new javax.swing.JTextField();
        txtTPP = new javax.swing.JTextField();
        jPanel43 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jPanel46 = new javax.swing.JPanel();
        dcDeleverDateSP = new com.toedter.calendar.JDateChooser();
        txtRouteIdSP = new javax.swing.JTextField();
        txtRouteNameSP = new javax.swing.JTextField();
        txtVehicleIdSP = new javax.swing.JTextField();
        txtVehicleNameSP = new javax.swing.JTextField();
        jPanel47 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblItemSP = new javax.swing.JTable();
        jPanel48 = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        dcDeleverDateDI = new com.toedter.calendar.JDateChooser();
        txtRouteIdDI = new javax.swing.JTextField();
        txtRouteNameDI = new javax.swing.JTextField();
        txtVehicleIdDI = new javax.swing.JTextField();
        txtVehicleNumberDI = new javax.swing.JTextField();
        txtPnameDI = new javax.swing.JTextField();
        txtPUnitDI = new javax.swing.JTextField();
        txtUnitPriceDI = new javax.swing.JTextField();
        txtQtyDI = new javax.swing.JTextField();
        txtTVDI = new javax.swing.JTextField();
        jPanel50 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblItemDI = new javax.swing.JTable();
        jPanel55 = new javax.swing.JPanel();
        btnRIVR1 = new javax.swing.JButton();
        btnRAVR1 = new javax.swing.JButton();
        jPanel54 = new javax.swing.JPanel();
        btnAddItem1 = new javax.swing.JButton();
        btnSummeryVR1 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        dcDeleverDateVR = new com.toedter.calendar.JDateChooser();
        txtRouteIdVR = new javax.swing.JTextField();
        txtRouteNameVR = new javax.swing.JTextField();
        txtVehicleIdVR = new javax.swing.JTextField();
        txtVehicleNumberVR = new javax.swing.JTextField();
        jPanel30 = new javax.swing.JPanel();
        btnAddItem = new javax.swing.JButton();
        btnSummeryVR = new javax.swing.JButton();
        jPanel31 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblItemVR = new javax.swing.JTable();
        jPanel32 = new javax.swing.JPanel();
        btnRIVR = new javax.swing.JButton();
        btnRAVR = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tf_regNumber1 = new javax.swing.JTextField();
        btn_vRegister = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        btn_vUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_allVehicles = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf_routeName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ta_routeDescription = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        tf_currentCredit = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tf_routeId = new javax.swing.JTextField();
        btn_saveRoute = new javax.swing.JButton();
        btn_clearRoute = new javax.swing.JButton();
        btn_routeUpdate = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_routeDetails = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        dc_routeDebitDate = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        tf_routeDebit = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        tf_routeIdDebit = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tf_routeNameDebit = new javax.swing.JTextField();
        btn_saveRouteDebit = new javax.swing.JButton();
        btn_clearRouteDebit = new javax.swing.JButton();
        btn_routeDebitSearch = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_routeDebit = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jPanel57 = new javax.swing.JPanel();
        dcDeleverDateR = new com.toedter.calendar.JDateChooser();
        txtRouteIdR = new javax.swing.JTextField();
        txtRouteNameR = new javax.swing.JTextField();
        txtVehicleIdR = new javax.swing.JTextField();
        txtVehicleNumberR = new javax.swing.JTextField();
        jPanel58 = new javax.swing.JPanel();
        btnSummeryVR2 = new javax.swing.JButton();

        setBackground(c.View.getInstance().colorTheme);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(c.View.getInstance().colorTheme);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jTabbedPane1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseMoved(evt);
            }
        });

        jPanel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        jPanel16.setPreferredSize(new java.awt.Dimension(1331, 661));

        jPanel17.setBackground(new java.awt.Color(102, 255, 102));
        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel22.setText("Vehicle Load ");
        jPanel17.add(jLabel22);

        jPanel19.setLayout(new java.awt.GridLayout(3, 0, 5, 5));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel23.setText("Product Name");
        jPanel19.add(jLabel23);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel24.setText("Unit(Kg)");
        jPanel19.add(jLabel24);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel25.setText("Load Qty");
        jPanel19.add(jLabel25);

        jPanel20.setLayout(new java.awt.GridLayout(3, 0, 5, 5));

        txtProductName.setBackground(new java.awt.Color(240, 240, 240));
        txtProductName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtProductName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 102, 255)));
        txtProductName.setNextFocusableComponent(txtLQ);
        txtProductName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtProductNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtProductNameFocusLost(evt);
            }
        });
        txtProductName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProductNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtProductNameKeyTyped(evt);
            }
        });
        jPanel20.add(txtProductName);

        txtUnitName.setEditable(false);
        txtUnitName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtUnitName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 102, 255)));
        jPanel20.add(txtUnitName);

        txtLQ.setBackground(new java.awt.Color(240, 240, 240));
        txtLQ.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtLQ.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtLQ.setText("0");
        txtLQ.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 102, 255)));
        txtLQ.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtLQ.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLQFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLQFocusLost(evt);
            }
        });
        txtLQ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLQKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLQKeyTyped(evt);
            }
        });
        jPanel20.add(txtLQ);

        jPanel21.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnAI.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAI.setText("Add Item");
        btnAI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAIMouseReleased(evt);
            }
        });
        jPanel21.add(btnAI);

        btnDeal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDeal.setText("Summery");
        btnDeal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnDealMouseReleased(evt);
            }
        });
        jPanel21.add(btnDeal);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblItem.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Unit", "Load Qty", "#Log Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItem.getTableHeader().setReorderingAllowed(false);
        tblItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblItemKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(tblItem);
        if (tblItem.getColumnModel().getColumnCount() > 0) {
            tblItem.getColumnModel().getColumn(0).setResizable(false);
            tblItem.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblItem.getColumnModel().getColumn(1).setResizable(false);
            tblItem.getColumnModel().getColumn(1).setPreferredWidth(10);
            tblItem.getColumnModel().getColumn(2).setResizable(false);
            tblItem.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblItem.getColumnModel().getColumn(3).setResizable(false);
            tblItem.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        jPanel23.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnRI.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRI.setText("Remove Item");
        btnRI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRIMouseReleased(evt);
            }
        });
        jPanel23.add(btnRI);

        btnRA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRA.setText("Remove All");
        btnRA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRAMouseReleased(evt);
            }
        });
        jPanel23.add(btnRA);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Last Deliver Date :");

        lblLastDeliverDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblLastDeliverDate.setText("Deliver Date");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLastDeliverDate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(lblLastDeliverDate))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel15.add(jPanel16);

        jTabbedPane1.addTab("Delevery Vehicle", jPanel15);

        jPanel37.setBackground(new java.awt.Color(102, 255, 102));
        jPanel37.setLayout(new java.awt.GridLayout(1, 0));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 102, 102));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Self Product ");
        jPanel37.add(jLabel30);

        jPanel38.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Source Product Unit");
        jPanel38.add(jLabel31);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Source Product Name");
        jPanel38.add(jLabel4);

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Target Product Name");
        jPanel38.add(jLabel33);

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Target Product Unit");
        jPanel38.add(jLabel34);

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Cost per Bottel");
        jPanel38.add(jLabel35);

        jPanel39.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        txtSPName.setBackground(new java.awt.Color(240, 240, 240));
        txtSPName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSPName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        txtSPName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSPNameKeyTyped(evt);
            }
        });
        jPanel39.add(txtSPName);

        txtSPunit.setEditable(false);
        txtSPunit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSPunit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        jPanel39.add(txtSPunit);

        txtTPName.setBackground(new java.awt.Color(240, 240, 240));
        txtTPName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTPName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        txtTPName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTPNameKeyTyped(evt);
            }
        });
        jPanel39.add(txtTPName);

        txtTPUnit.setEditable(false);
        txtTPUnit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTPUnit.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        jPanel39.add(txtTPUnit);

        txtCPB.setBackground(new java.awt.Color(240, 240, 240));
        txtCPB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCPB.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCPB.setText("0");
        txtCPB.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        txtCPB.setNextFocusableComponent(txtCPL);
        txtCPB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCPBFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPBFocusLost(evt);
            }
        });
        txtCPB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPBKeyTyped(evt);
            }
        });
        jPanel39.add(txtCPB);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel44.setText("Max Bottel");

        txtRemainQty.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtRemainQty.setForeground(new java.awt.Color(255, 51, 51));
        txtRemainQty.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtRemainQty.setText("0");
        txtRemainQty.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 102, 255)));

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRemainQty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRemainQty, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel41.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Cost Per Label");
        jPanel41.add(jLabel36);

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Other Cost");
        jPanel41.add(jLabel37);

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Target Quantity");
        jPanel41.add(jLabel32);

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Total Cost ");
        jPanel41.add(jLabel38);

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Target Product Price");
        jPanel41.add(jLabel39);

        jPanel42.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        txtCPL.setBackground(new java.awt.Color(240, 240, 240));
        txtCPL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCPL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtCPL.setText("0");
        txtCPL.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        txtCPL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCPLFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCPLFocusLost(evt);
            }
        });
        txtCPL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCPLKeyTyped(evt);
            }
        });
        jPanel42.add(txtCPL);

        txtOC.setBackground(new java.awt.Color(240, 240, 240));
        txtOC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtOC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtOC.setText("0");
        txtOC.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        txtOC.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtOCFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtOCFocusLost(evt);
            }
        });
        txtOC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOCKeyTyped(evt);
            }
        });
        jPanel42.add(txtOC);

        txtTQty.setBackground(new java.awt.Color(240, 240, 240));
        txtTQty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTQty.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTQty.setText("0");
        txtTQty.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        txtTQty.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTQtyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTQtyFocusLost(evt);
            }
        });
        txtTQty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTQtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTQtyKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTQtyKeyTyped(evt);
            }
        });
        jPanel42.add(txtTQty);

        txtTC.setBackground(new java.awt.Color(240, 240, 240));
        txtTC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTC.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTC.setText("0");
        txtTC.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        jPanel42.add(txtTC);

        txtTPP.setBackground(new java.awt.Color(240, 240, 240));
        txtTPP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTPP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTPP.setText("0");
        txtTPP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 153, 255)));
        txtTPP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTPPKeyTyped(evt);
            }
        });
        jPanel42.add(txtTPP);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel41, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel42, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel42, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel43.setLayout(new java.awt.GridLayout(1, 0, 10, 10));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnSaveMouseReleased(evt);
            }
        });
        jPanel43.add(btnSave);

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnResetMouseReleased(evt);
            }
        });
        jPanel43.add(btnReset);

        jPanel45.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Delevery Date");
        jPanel45.add(jLabel40);

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Route Id ");
        jPanel45.add(jLabel41);

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("Route Name ");
        jPanel45.add(jLabel55);

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Vehicle Id");
        jPanel45.add(jLabel42);

        jLabel56.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel56.setText("Vehicle Num");
        jPanel45.add(jLabel56);

        jPanel46.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        dcDeleverDateSP.setDateFormatString("yyyy-MM-dd");
        dcDeleverDateSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel46.add(dcDeleverDateSP);

        txtRouteIdSP.setBackground(new java.awt.Color(240, 240, 240));
        txtRouteIdSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRouteIdSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        jPanel46.add(txtRouteIdSP);

        txtRouteNameSP.setBackground(new java.awt.Color(240, 240, 240));
        txtRouteNameSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRouteNameSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtRouteNameSP.setNextFocusableComponent(txtVehicleNameSP);
        txtRouteNameSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRouteNameSPKeyTyped(evt);
            }
        });
        jPanel46.add(txtRouteNameSP);

        txtVehicleIdSP.setBackground(new java.awt.Color(240, 240, 240));
        txtVehicleIdSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVehicleIdSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtVehicleIdSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVehicleIdSPKeyTyped(evt);
            }
        });
        jPanel46.add(txtVehicleIdSP);

        txtVehicleNameSP.setBackground(new java.awt.Color(240, 240, 240));
        txtVehicleNameSP.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVehicleNameSP.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtVehicleNameSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVehicleNameSPKeyTyped(evt);
            }
        });
        jPanel46.add(txtVehicleNameSP);

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel46, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel46, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(jPanel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblItemSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Unit", "Item Status", "Quantity", "#Log Id", "#Load Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItemSP.getTableHeader().setReorderingAllowed(false);
        tblItemSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItemSPMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblItemSPMouseReleased(evt);
            }
        });
        tblItemSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblItemSPKeyReleased(evt);
            }
        });
        jScrollPane8.setViewportView(tblItemSP);
        if (tblItemSP.getColumnModel().getColumnCount() > 0) {
            tblItemSP.getColumnModel().getColumn(0).setResizable(false);
            tblItemSP.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblItemSP.getColumnModel().getColumn(1).setResizable(false);
            tblItemSP.getColumnModel().getColumn(1).setPreferredWidth(5);
            tblItemSP.getColumnModel().getColumn(2).setResizable(false);
            tblItemSP.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblItemSP.getColumnModel().getColumn(3).setResizable(false);
            tblItemSP.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblItemSP.getColumnModel().getColumn(4).setResizable(false);
            tblItemSP.getColumnModel().getColumn(4).setPreferredWidth(5);
            tblItemSP.getColumnModel().getColumn(5).setResizable(false);
            tblItemSP.getColumnModel().getColumn(5).setPreferredWidth(5);
        }

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8)
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 1185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel35Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel47, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel35Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(32, 32, 32))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel44, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel47, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Self Products", jPanel35);

        jPanel48.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel48MouseMoved(evt);
            }
        });

        jPanel49.setBackground(new java.awt.Color(102, 255, 102));
        jPanel49.setLayout(new java.awt.GridLayout(1, 0));

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 102, 102));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel46.setText("Item Back ");
        jPanel49.add(jLabel46);

        jPanel52.setLayout(new java.awt.GridLayout(10, 0, 5, 5));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Delevery Date");
        jPanel52.add(jLabel47);

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Route Id ");
        jPanel52.add(jLabel48);

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setText("Route Name");
        jPanel52.add(jLabel49);

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("Vehicle Id");
        jPanel52.add(jLabel50);

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel51.setText("Vehicle Number");
        jPanel52.add(jLabel51);

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel52.setText("Product Name");
        jPanel52.add(jLabel52);

        jLabel53.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel53.setText("Unit");
        jPanel52.add(jLabel53);

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("Unit Price");
        jPanel52.add(jLabel54);

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel58.setText("Qty");
        jPanel52.add(jLabel58);

        jLabel57.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel57.setText("Total Value");
        jPanel52.add(jLabel57);

        jPanel53.setLayout(new java.awt.GridLayout(10, 0, 5, 5));

        dcDeleverDateDI.setDateFormatString("yyyy-MM-dd");
        dcDeleverDateDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dcDeleverDateDI.setNextFocusableComponent(txtRouteNameDI);
        jPanel53.add(dcDeleverDateDI);

        txtRouteIdDI.setBackground(new java.awt.Color(240, 240, 240));
        txtRouteIdDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRouteIdDI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        jPanel53.add(txtRouteIdDI);

        txtRouteNameDI.setBackground(new java.awt.Color(240, 240, 240));
        txtRouteNameDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRouteNameDI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtRouteNameDI.setNextFocusableComponent(txtVehicleNumberDI);
        txtRouteNameDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRouteNameDIKeyTyped(evt);
            }
        });
        jPanel53.add(txtRouteNameDI);

        txtVehicleIdDI.setBackground(new java.awt.Color(240, 240, 240));
        txtVehicleIdDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVehicleIdDI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtVehicleIdDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVehicleIdDIKeyTyped(evt);
            }
        });
        jPanel53.add(txtVehicleIdDI);

        txtVehicleNumberDI.setBackground(new java.awt.Color(240, 240, 240));
        txtVehicleNumberDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVehicleNumberDI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtVehicleNumberDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVehicleNumberDIActionPerformed(evt);
            }
        });
        txtVehicleNumberDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVehicleNumberDIKeyTyped(evt);
            }
        });
        jPanel53.add(txtVehicleNumberDI);

        txtPnameDI.setBackground(new java.awt.Color(240, 240, 240));
        txtPnameDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPnameDI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtPnameDI.setNextFocusableComponent(txtUnitPriceDI);
        txtPnameDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPnameDIKeyTyped(evt);
            }
        });
        jPanel53.add(txtPnameDI);

        txtPUnitDI.setBackground(new java.awt.Color(240, 240, 240));
        txtPUnitDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPUnitDI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtPUnitDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPUnitDIActionPerformed(evt);
            }
        });
        txtPUnitDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPUnitDIKeyTyped(evt);
            }
        });
        jPanel53.add(txtPUnitDI);

        txtUnitPriceDI.setBackground(new java.awt.Color(240, 240, 240));
        txtUnitPriceDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUnitPriceDI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtUnitPriceDI.setText("0");
        txtUnitPriceDI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtUnitPriceDI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUnitPriceDIFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUnitPriceDIFocusLost(evt);
            }
        });
        txtUnitPriceDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUnitPriceDIActionPerformed(evt);
            }
        });
        txtUnitPriceDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnitPriceDIKeyTyped(evt);
            }
        });
        jPanel53.add(txtUnitPriceDI);

        txtQtyDI.setBackground(new java.awt.Color(240, 240, 240));
        txtQtyDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtQtyDI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtQtyDI.setText("0");
        txtQtyDI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtQtyDI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtQtyDIFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtyDIFocusLost(evt);
            }
        });
        txtQtyDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtyDIActionPerformed(evt);
            }
        });
        txtQtyDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQtyDIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtQtyDIKeyTyped(evt);
            }
        });
        jPanel53.add(txtQtyDI);

        txtTVDI.setBackground(new java.awt.Color(240, 240, 240));
        txtTVDI.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTVDI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTVDI.setText("0");
        txtTVDI.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtTVDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTVDIActionPerformed(evt);
            }
        });
        txtTVDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTVDIKeyTyped(evt);
            }
        });
        jPanel53.add(txtTVDI);

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                    .addComponent(jPanel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblItemDI.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Unit", "Unit Price", "Quantity", "Total Value", "#Log Id", "#Load Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItemDI.getTableHeader().setReorderingAllowed(false);
        tblItemDI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblItemDIKeyReleased(evt);
            }
        });
        jScrollPane9.setViewportView(tblItemDI);
        if (tblItemDI.getColumnModel().getColumnCount() > 0) {
            tblItemDI.getColumnModel().getColumn(0).setResizable(false);
            tblItemDI.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblItemDI.getColumnModel().getColumn(1).setResizable(false);
            tblItemDI.getColumnModel().getColumn(1).setPreferredWidth(5);
            tblItemDI.getColumnModel().getColumn(2).setResizable(false);
            tblItemDI.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblItemDI.getColumnModel().getColumn(3).setResizable(false);
            tblItemDI.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblItemDI.getColumnModel().getColumn(4).setResizable(false);
            tblItemDI.getColumnModel().getColumn(4).setPreferredWidth(20);
            tblItemDI.getColumnModel().getColumn(5).setResizable(false);
            tblItemDI.getColumnModel().getColumn(5).setPreferredWidth(5);
            tblItemDI.getColumnModel().getColumn(6).setResizable(false);
            tblItemDI.getColumnModel().getColumn(6).setPreferredWidth(5);
        }

        jPanel55.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnRIVR1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRIVR1.setText("Remove Item");
        btnRIVR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRIVR1MouseReleased(evt);
            }
        });
        jPanel55.add(btnRIVR1);

        btnRAVR1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRAVR1.setText("Remove All");
        btnRAVR1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRAVR1MouseReleased(evt);
            }
        });
        jPanel55.add(btnRAVR1);

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel54.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnAddItem1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAddItem1.setText("Add Item");
        btnAddItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAddItem1MouseReleased(evt);
            }
        });
        jPanel54.add(btnAddItem1);

        btnSummeryVR1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSummeryVR1.setText("Summery");
        btnSummeryVR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummeryVR1ActionPerformed(evt);
            }
        });
        jPanel54.add(btnSummeryVR1);

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel49, javax.swing.GroupLayout.DEFAULT_SIZE, 1187, Short.MAX_VALUE)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                        .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                .addComponent(jPanel49, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel50, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Delivery Invoice", jPanel48);

        jPanel24.setLayout(new java.awt.GridLayout(1, 0));

        jPanel26.setBackground(new java.awt.Color(102, 255, 102));
        jPanel26.setLayout(new java.awt.GridLayout(1, 0));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 102));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel26.setText("Item Back ");
        jPanel26.add(jLabel26);

        jPanel28.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Delevery Date");
        jPanel28.add(jLabel29);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Route Id ");
        jPanel28.add(jLabel27);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Route Name");
        jPanel28.add(jLabel28);

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Vehicle Id");
        jPanel28.add(jLabel43);

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Vehicle Name");
        jPanel28.add(jLabel45);

        jPanel29.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        dcDeleverDateVR.setDateFormatString("yyyy-MM-dd");
        jPanel29.add(dcDeleverDateVR);

        txtRouteIdVR.setBackground(new java.awt.Color(240, 240, 240));
        txtRouteIdVR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRouteIdVR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        jPanel29.add(txtRouteIdVR);

        txtRouteNameVR.setBackground(new java.awt.Color(240, 240, 240));
        txtRouteNameVR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRouteNameVR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtRouteNameVR.setNextFocusableComponent(txtVehicleNumberVR);
        txtRouteNameVR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRouteNameVRKeyTyped(evt);
            }
        });
        jPanel29.add(txtRouteNameVR);

        txtVehicleIdVR.setBackground(new java.awt.Color(240, 240, 240));
        txtVehicleIdVR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVehicleIdVR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtVehicleIdVR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVehicleIdVRKeyTyped(evt);
            }
        });
        jPanel29.add(txtVehicleIdVR);

        txtVehicleNumberVR.setBackground(new java.awt.Color(240, 240, 240));
        txtVehicleNumberVR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVehicleNumberVR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtVehicleNumberVR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVehicleNumberVRActionPerformed(evt);
            }
        });
        txtVehicleNumberVR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVehicleNumberVRKeyTyped(evt);
            }
        });
        jPanel29.add(txtVehicleNumberVR);

        jPanel30.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnAddItem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAddItem.setText("Add Item");
        btnAddItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnAddItemMouseReleased(evt);
            }
        });
        jPanel30.add(btnAddItem);

        btnSummeryVR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSummeryVR.setText("Summery");
        btnSummeryVR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummeryVRActionPerformed(evt);
            }
        });
        jPanel30.add(btnSummeryVR);

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                    .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblItemVR.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblItemVR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Unit", "Item Status", "Quantity", "Return Qty", "#Log Id", "#Load Id"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItemVR.getTableHeader().setReorderingAllowed(false);
        tblItemVR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblItemVRKeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(tblItemVR);
        if (tblItemVR.getColumnModel().getColumnCount() > 0) {
            tblItemVR.getColumnModel().getColumn(0).setResizable(false);
            tblItemVR.getColumnModel().getColumn(0).setPreferredWidth(150);
            tblItemVR.getColumnModel().getColumn(1).setResizable(false);
            tblItemVR.getColumnModel().getColumn(1).setPreferredWidth(5);
            tblItemVR.getColumnModel().getColumn(2).setResizable(false);
            tblItemVR.getColumnModel().getColumn(2).setPreferredWidth(10);
            tblItemVR.getColumnModel().getColumn(3).setResizable(false);
            tblItemVR.getColumnModel().getColumn(3).setPreferredWidth(30);
            tblItemVR.getColumnModel().getColumn(4).setResizable(false);
            tblItemVR.getColumnModel().getColumn(4).setPreferredWidth(30);
            tblItemVR.getColumnModel().getColumn(5).setResizable(false);
            tblItemVR.getColumnModel().getColumn(5).setPreferredWidth(5);
            tblItemVR.getColumnModel().getColumn(6).setResizable(false);
            tblItemVR.getColumnModel().getColumn(6).setPreferredWidth(5);
        }

        jPanel32.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnRIVR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRIVR.setText("Remove Item");
        btnRIVR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRIVRMouseReleased(evt);
            }
        });
        jPanel32.add(btnRIVR);

        btnRAVR.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRAVR.setText("Remove All");
        btnRAVR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRAVRMouseReleased(evt);
            }
        });
        jPanel32.add(btnRAVR);

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel33.setLayout(new java.awt.GridLayout(2, 0, 5, 5));

        jPanel34.setLayout(new java.awt.GridLayout(2, 0, 5, 5));

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(104, 104, 104))))
        );

        jPanel24.add(jPanel25);

        jTabbedPane1.addTab("Vehicle Return", jPanel24);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Vehicle Registration Number");

        tf_regNumber1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_regNumber1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_regNumber1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_regNumber1KeyTyped(evt);
            }
        });

        btn_vRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_vRegister.setText("Save");
        btn_vRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_vRegisterMouseReleased(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_clearMouseReleased(evt);
            }
        });

        btn_vUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_vUpdate.setText("Update");
        btn_vUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_vUpdateMouseReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Id");

        tf_id.setEditable(false);
        tf_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Vehicle Register");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_vUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_regNumber1)
                    .addComponent(btn_vRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_id)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(tf_regNumber1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(btn_vRegister)
                .addGap(18, 18, 18)
                .addComponent(btn_vUpdate)
                .addGap(18, 18, 18)
                .addComponent(btn_clear)
                .addContainerGap(246, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        tbl_allVehicles.setRowHeight(25);
        tbl_allVehicles.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_allVehicles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Vehicle Registration Number "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_allVehicles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_allVehicles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_allVehiclesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_allVehicles);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab("Vehicle Register", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Route Register");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Route Name");

        tf_routeName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_routeName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_routeNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_routeNameKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Route Description");

        ta_routeDescription.setColumns(20);
        ta_routeDescription.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        ta_routeDescription.setRows(5);
        jScrollPane2.setViewportView(ta_routeDescription);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Current Credit");

        tf_currentCredit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_currentCredit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_currentCreditKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Route Id");

        tf_routeId.setEditable(false);
        tf_routeId.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_saveRoute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_saveRoute.setText("Save");
        btn_saveRoute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_saveRouteMouseReleased(evt);
            }
        });

        btn_clearRoute.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_clearRoute.setText("Clear");
        btn_clearRoute.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_clearRouteMouseReleased(evt);
            }
        });

        btn_routeUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_routeUpdate.setText("Update");
        btn_routeUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_routeUpdateMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_routeId)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_routeName)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(tf_currentCredit)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_saveRoute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_routeUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_clearRoute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(tf_routeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(tf_routeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(tf_currentCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_saveRoute)
                .addGap(18, 18, 18)
                .addComponent(btn_routeUpdate)
                .addGap(18, 18, 18)
                .addComponent(btn_clearRoute)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        tbl_routeDetails.setRowHeight(25);
        tbl_routeDetails.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_routeDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Route Id", "Route Name", "Route Description", "Current Credit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_routeDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_routeDetailsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_routeDetails);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Router Register", jPanel6);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel10MouseMoved(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel13MouseMoved(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Route Debit");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Date");

        dc_routeDebitDate.setDateFormatString("yyyy-MM-dd");
        dc_routeDebitDate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dc_routeDebitDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                dc_routeDebitDateFocusGained(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Route Debit");

        tf_routeDebit.setEditable(false);
        tf_routeDebit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Route Register Id");

        tf_routeIdDebit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_routeIdDebit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_routeIdDebitFocusGained(evt);
            }
        });
        tf_routeIdDebit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_routeIdDebitKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_routeIdDebitKeyTyped(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Route Name");

        tf_routeNameDebit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tf_routeNameDebit.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_routeNameDebitFocusGained(evt);
            }
        });
        tf_routeNameDebit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_routeNameDebitKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_routeNameDebitKeyTyped(evt);
            }
        });

        btn_saveRouteDebit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_saveRouteDebit.setText("Save");
        btn_saveRouteDebit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_saveRouteDebitMouseReleased(evt);
            }
        });

        btn_clearRouteDebit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_clearRouteDebit.setText("Clear");
        btn_clearRouteDebit.setPreferredSize(new java.awt.Dimension(65, 25));
        btn_clearRouteDebit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_clearRouteDebitMouseReleased(evt);
            }
        });

        btn_routeDebitSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_routeDebitSearch.setText("Search by date");
        btn_routeDebitSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_routeDebitSearchMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_clearRouteDebit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dc_routeDebitDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_routeDebit)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_routeIdDebit)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_routeNameDebit)
                    .addComponent(btn_saveRouteDebit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_routeDebitSearch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(dc_routeDebitDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addGap(18, 18, 18)
                .addComponent(tf_routeDebit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addGap(18, 18, 18)
                .addComponent(tf_routeIdDebit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addGap(18, 18, 18)
                .addComponent(tf_routeNameDebit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_saveRouteDebit)
                .addGap(18, 18, 18)
                .addComponent(btn_clearRouteDebit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_routeDebitSearch)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        tbl_routeDebit.setRowHeight(25);
        tbl_routeDebit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tbl_routeDebit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Route Debit Id", "Date", "Route Debit", "Route Register Id", "Route Name"
            }
        ));
        tbl_routeDebit.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tbl_routeDebitMouseMoved(evt);
            }
        });
        tbl_routeDebit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_routeDebitMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbl_routeDebit);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5))
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Route Debit", jPanel10);

        jPanel56.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel59.setText("Delevery Date");
        jPanel56.add(jLabel59);

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setText("Route Id ");
        jPanel56.add(jLabel60);

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setText("Route Name");
        jPanel56.add(jLabel61);

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setText("Vehicle Id");
        jPanel56.add(jLabel62);

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setText("Vehicle Name");
        jPanel56.add(jLabel63);

        jPanel57.setLayout(new java.awt.GridLayout(5, 0, 5, 5));

        dcDeleverDateR.setDateFormatString("yyyy-MM-dd");
        dcDeleverDateR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel57.add(dcDeleverDateR);

        txtRouteIdR.setBackground(new java.awt.Color(240, 240, 240));
        txtRouteIdR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRouteIdR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        jPanel57.add(txtRouteIdR);

        txtRouteNameR.setBackground(new java.awt.Color(240, 240, 240));
        txtRouteNameR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRouteNameR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtRouteNameR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRouteNameRKeyTyped(evt);
            }
        });
        jPanel57.add(txtRouteNameR);

        txtVehicleIdR.setBackground(new java.awt.Color(240, 240, 240));
        txtVehicleIdR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVehicleIdR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtVehicleIdR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVehicleIdRKeyTyped(evt);
            }
        });
        jPanel57.add(txtVehicleIdR);

        txtVehicleNumberR.setBackground(new java.awt.Color(240, 240, 240));
        txtVehicleNumberR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtVehicleNumberR.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 153, 255)));
        txtVehicleNumberR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVehicleNumberRActionPerformed(evt);
            }
        });
        txtVehicleNumberR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtVehicleNumberRKeyTyped(evt);
            }
        });
        jPanel57.add(txtVehicleNumberR);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel57, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel56, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel58.setLayout(new java.awt.GridLayout(1, 0, 5, 5));

        btnSummeryVR2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSummeryVR2.setText("Report");
        btnSummeryVR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSummeryVR2ActionPerformed(evt);
            }
        });
        jPanel58.add(btnSummeryVR2);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(392, 392, 392)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(414, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel58, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(235, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delivery Report", jPanel9);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_vRegisterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vRegisterMouseReleased
        // TODO add your handling code here:

        VehicleRegister vehicleRegister = new VehicleRegister();
        int setData = vehicleRegister.setData(tf_regNumber1, tf_id, vehicle);
        if (setData == 3) {
            int confirm = 0;
            confirm = JOptionPane.showConfirmDialog(vehicle, "Do you want to update data", "Data Update", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirm == 0) {
                btn_vUpdateMouseReleased(evt);
            } else {
                System.out.println("Cancel vehicle update");
            }
            //btn_vUpdateMouseReleased(evt);
        }

        vehicleViewTable.setTableData(tbl_allVehicles);
        clear();
        //autoComplete = new AutoComplete();
        //new AutoComplete().autocompleteRegNm1(tf_regNumber1);


    }//GEN-LAST:event_btn_vRegisterMouseReleased

    private void btn_clearMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearMouseReleased
        // TODO add your handling code here:
        clear();

    }//GEN-LAST:event_btn_clearMouseReleased

    private void tbl_allVehiclesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_allVehiclesMouseClicked
        // TODO add your handling code here:
        vehicleViewTable.setTableDataOnTextField(tbl_allVehicles, tf_regNumber1, tf_id);

    }//GEN-LAST:event_tbl_allVehiclesMouseClicked

    private void btn_vUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_vUpdateMouseReleased
        // TODO add your handling code here:
        VehicleUpdate vehicleUpdate = new VehicleUpdate();
        vehicleUpdate.updateVehicle(tf_id, tf_regNumber1, vehicle);
        clear();
        vehicleViewTable.setTableData(tbl_allVehicles);
        //new AutoComplete().autocompleteRegNm1(tf_regNumber1);
        //autoComplete = new AutoComplete();

    }//GEN-LAST:event_btn_vUpdateMouseReleased

    private void tf_regNumber1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_regNumber1KeyTyped
        // TODO add your handling code here:
        new AutoComplete().autocompleteRegNm1(tf_regNumber1);

    }//GEN-LAST:event_tf_regNumber1KeyTyped

    private void tf_regNumber1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_regNumber1KeyReleased
        // TODO add your handling code here:
        //autoComplete = new AutoComplete();
        if (evt.getKeyCode() == evt.VK_ENTER) {
            //JOptionPane.showConfirmDialog(vehicle, tf_regNumber1.getText());
            new AutoComplete().fillRegNm2(tf_regNumber1, tf_id);

            //tf_regNumber2.setText(fillRegNm2);
            //JOptionPane.showConfirmDialog(vehicle, fillRegNm2);
        }
    }//GEN-LAST:event_tf_regNumber1KeyReleased

    private void btn_saveRouteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveRouteMouseReleased
        // TODO add your handling code here:
        int saveRoute = new RouteRegister().saveRoute(tf_routeId, tf_routeName, ta_routeDescription, tf_currentCredit, vehicle);
        if (saveRoute == 3) {
            int showConfirmDialog = JOptionPane.showConfirmDialog(vehicle, "Do you want to update", "title", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (showConfirmDialog == 0) {
                btn_routeUpdateMouseReleased(evt);
            } else {
                System.out.println("Cancel");
            }
        }
        routeViewTable.setrouteTableData(tbl_routeDetails);
        clearRoute();
        //autoComplete = new AutoComplete();
    }//GEN-LAST:event_btn_saveRouteMouseReleased

    private void btn_clearRouteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearRouteMouseReleased
        // TODO add your handling code here:
        clearRoute();
    }//GEN-LAST:event_btn_clearRouteMouseReleased

    private void tbl_routeDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_routeDetailsMouseClicked
        // TODO add your handling code here:
        routeViewTable.serRouteTableDataOnTextField(tf_routeId, tf_routeName, ta_routeDescription, tf_currentCredit, tbl_routeDetails);
    }//GEN-LAST:event_tbl_routeDetailsMouseClicked

    private void tf_routeNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_routeNameKeyReleased
        // TODO add your handling code here:
        //autoComplete = new AutoComplete();
        if (evt.getKeyCode() == evt.VK_ENTER) {
            new AutoComplete().fillRouteDeatails(tf_routeId, tf_routeName, ta_routeDescription, tf_currentCredit);
        }
    }//GEN-LAST:event_tf_routeNameKeyReleased

    private void tf_routeNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_routeNameKeyTyped
        // TODO add your handling code here:
        new AutoComplete().autocompleteRouteRegNam(tf_routeName);
    }//GEN-LAST:event_tf_routeNameKeyTyped

    private void btn_saveRouteDebitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_saveRouteDebitMouseReleased
        // TODO add your handling code here:
        int saveRouteCredit = new c.RouteDebitRegister().saveRouteDebit(dc_routeDebitDate, tf_routeDebit, tf_routeIdDebit, vehicle);
//        if (saveRouteCredit == 3) {
//            int showConfirmDialog = JOptionPane.showConfirmDialog(vehicle, "Do you want to update", "Data Update", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
//            if (showConfirmDialog == 0) {
//                //btn_updateRouteDebitMouseReleased(evt);
//            } else {
//                System.out.println("Cancel");
//            }
//        }
        //routeDebitTableView.setRouteCreditTableData(tbl_routeDebit);
        clearRouteDebit();
    }//GEN-LAST:event_btn_saveRouteDebitMouseReleased

    private void tbl_routeDebitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_routeDebitMouseClicked
        // TODO add your handling code here:
        //new RouteDebitTableView().setRouteCreditDataOnTextField(tf_routeDebitId, dc_routeDebitDate, tf_routeDebit, tf_routeIdDebit, tf_routeNameDebit, tbl_routeDebit);
    }//GEN-LAST:event_tbl_routeDebitMouseClicked

    private void btn_routeDebitSearchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_routeDebitSearchMouseReleased
        // TODO add your handling code here:
        //new c.RouteDebitSearch().searchRouteCreditByDate(tbl_routeDebit, dc_routeDebitDate);
        new v.DebitPayLog().setVisible(true);
    }//GEN-LAST:event_btn_routeDebitSearchMouseReleased

    private void btn_clearRouteDebitMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clearRouteDebitMouseReleased
        // TODO add your handling code here:
        clearRouteDebit();
    }//GEN-LAST:event_btn_clearRouteDebitMouseReleased

    private void tf_routeIdDebitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_routeIdDebitKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        new AutoComplete().autocompleteRouteRegId(tf_routeIdDebit);
    }//GEN-LAST:event_tf_routeIdDebitKeyTyped

    private void tf_routeIdDebitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_routeIdDebitKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            new AutoComplete().fillRouteDeatailsForCrerditFromRouteId(tf_routeIdDebit, tf_routeNameDebit, tf_routeDebit);
        }
    }//GEN-LAST:event_tf_routeIdDebitKeyReleased

    private void tf_routeNameDebitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_routeNameDebitKeyTyped
        // TODO add your handling code here:
        new AutoComplete().autocompleteRouteRegNam(tf_routeNameDebit);
    }//GEN-LAST:event_tf_routeNameDebitKeyTyped

    private void tf_routeNameDebitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_routeNameDebitKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            new AutoComplete().fillRouteDeatailsForCrerdit(tf_routeIdDebit, tf_routeNameDebit, tf_routeDebit);
        }
    }//GEN-LAST:event_tf_routeNameDebitKeyReleased

    private void btnAIMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAIMouseReleased
        // TODO add your handling code here:
        if (!txtProductName.getText().isEmpty()) {
            if (!txtUnitName.getText().isEmpty()) {
                if (!txtLQ.getText().isEmpty()) {
                    new c.DeleveryItemTable().addItem(txtProductName, txtUnitName, txtLQ, tblItem);
                    txtProductName.requestFocus();
                }
            }
        }
        //new c.DeleveryItemTable().addItem(txtProductName, txtUnitName, txtLQ, tblItem);
    }//GEN-LAST:event_btnAIMouseReleased

    private void tblItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblItemKeyReleased
        // TODO add your handling code here:
        if (evt.isControlDown() & evt.getKeyChar() == KeyEvent.VK_DELETE) {
            new c.DeleveryItemTable().removeAllItem(tblItem);
        } else if (evt.getKeyChar() == KeyEvent.VK_DELETE) {
            new c.DeleveryItemTable().removeItem(tblItem);
        }
    }//GEN-LAST:event_tblItemKeyReleased

    private void btnRIMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRIMouseReleased
        // TODO add your handling code here:
        new c.DeleveryItemTable().removeItem(tblItem);
    }//GEN-LAST:event_btnRIMouseReleased

    private void btnRAMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRAMouseReleased
        // TODO add your handling code here:
        new c.DeleveryItemTable().removeAllItem(tblItem);
    }//GEN-LAST:event_btnRAMouseReleased

    private void btnDealMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDealMouseReleased
        // TODO add your handling code here:
        if (tblItem.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter minimum one to the table.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            DeliverDetail.setDcDeleverDateDI(dcDeleverDateDI);
            DeliverDetail.setTxtRouteIdDI(txtRouteIdDI);
            DeliverDetail.setTxtRouteNameDI(txtRouteNameDI);
            DeliverDetail.setTxtVehicleIdDI(txtVehicleIdDI);
            DeliverDetail.setTxtVehicleiNumberDI(txtVehicleNumberDI);

            DeliverDetail.setDcDeleverDateSP(dcDeleverDateSP);
            DeliverDetail.setTxtRouteIdSP(txtRouteIdSP);
            DeliverDetail.setTxtRouteNameSP(txtRouteNameSP);
            DeliverDetail.setTxtVehicleIdSP(txtVehicleIdSP);
            DeliverDetail.setTxtVehicleNameSP(txtVehicleNameSP);
            DeliverDetail.setTblItemSP(tblItemSP);

            DeliverDetail.setDcDeleverDateVR(dcDeleverDateVR);
            DeliverDetail.setTxtRouteIdVR(txtRouteIdVR);
            DeliverDetail.setTxtRouteNameVR(txtRouteNameVR);
            DeliverDetail.setTxtVehicleIdVR(txtVehicleIdVR);
            DeliverDetail.setTxtVehicleNumberVR(txtVehicleNumberVR);
            DeliverDetail.setTblItemVR(tblItemVR);

            new v.frmDeleverySummery(tblItem, jTabbedPane1).setVisible(true);
        }
    }//GEN-LAST:event_btnDealMouseReleased

    private void txtProductNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductNameFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_txtProductNameFocusGained

    private void txtProductNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtProductNameFocusLost
        // TODO add your handling code here:

    }//GEN-LAST:event_txtProductNameFocusLost

    private void txtProductNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductNameKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            new c.ProductSearch().getProductData(txtProductName, txtUnitName);
            txtLQ.requestFocus();
        }
    }//GEN-LAST:event_txtProductNameKeyTyped

    private void txtLQKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLQKeyTyped
        // TODO add your handling code here:char vChar = evt.getKeyChar();
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD || vChar == KeyEvent.VK_ENTER)) {
            evt.consume();
        }

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            //new c.DeleverySummery(tblItem).updateAveQty(txtLQ, txtProductName);
            if (!txtProductName.getText().isEmpty()) {
                if (!txtUnitName.getText().isEmpty()) {
                    if (!txtLQ.getText().isEmpty()) {
                        new c.DeleveryItemTable().addItem(txtProductName, txtUnitName, txtLQ, tblItem);
                        txtProductName.requestFocus();
                    }
                }
            }
        }

    }//GEN-LAST:event_txtLQKeyTyped

    private void txtLQFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLQFocusGained
        // TODO add your handling code here:
        if ("0".equals(txtLQ.getText())) {
            txtLQ.setText("");
        }
    }//GEN-LAST:event_txtLQFocusGained

    private void txtLQFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLQFocusLost
        // TODO add your handling code here:
        if ("".equals(txtLQ.getText())) {
            txtLQ.setText("0");
        }
    }//GEN-LAST:event_txtLQFocusLost

    private void txtProductNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProductNameKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txtProductNameKeyReleased

    private void txtLQKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLQKeyReleased
        // TODO add your handling code here:
        if (!txtLQ.getText().isEmpty()) {
            new c.ProductSearch().getCurrentQty(txtProductName, txtLQ);
        }
    }//GEN-LAST:event_txtLQKeyReleased

    private void btnSummeryVRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummeryVRActionPerformed
        // TODO add your handling code here:
        if (tblItemVR.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter minimum one to the table.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            String deliverInfo = txtRouteIdVR.getText() + "/" + txtVehicleIdVR.getText();
            boolean status = false;
            for (int i = 0; i < tblItemVR.getRowCount(); i++) {
                if (tblItemVR.getValueAt(i, 4).toString().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Item table have a empty return quantity.Please enter '0' or return qty.", "Warning", JOptionPane.WARNING_MESSAGE);
                    status = false;
                    break;
                } else {
                    status = true;
                }
            }
            if (status) {
                new frmVehicleReturn(tblItemVR, txtRouteIdVR, deliverInfo, dcDeleverDateVR.getDate(), jTabbedPane1).setVisible(true);
            }
        }
    }//GEN-LAST:event_btnSummeryVRActionPerformed

    private void btnAddItemMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddItemMouseReleased
        // TODO add your handling code here:
        //new VehicleReturn().addItem(txtProductName1, txtUnitVR, cmbStatus, txtRQ, tblItemVR);
        try {
            int routeByName = new VehicleReturn().getVehicleByNumber(txtVehicleNumberVR.getText());
            txtVehicleIdVR.setText(String.valueOf(routeByName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!((JTextField) dcDeleverDateVR.getDateEditor().getUiComponent()).getText().isEmpty()) {
            if (!txtRouteIdVR.getText().isEmpty()) {
                if (!txtVehicleIdVR.getText().isEmpty()) {
                    new c.VehicleReturn().addItem(txtVehicleIdVR, txtRouteIdVR, dcDeleverDateVR, tblItemVR);
                }
            }
        }

        //new c.VehicleReturn().addItem(txtVehicleId, txtRouteId, dcDeleverDate, tblItemVR);
    }//GEN-LAST:event_btnAddItemMouseReleased

    private void btnRIVRMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRIVRMouseReleased
        // TODO add your handling code here:
        new c.DeleveryItemTable().removeItem(tblItemVR);
    }//GEN-LAST:event_btnRIVRMouseReleased

    private void btnRAVRMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRAVRMouseReleased
        // TODO add your handling code here:
        new c.DeleveryItemTable().removeAllItem(tblItemVR);
    }//GEN-LAST:event_btnRAVRMouseReleased

    private void tblItemVRKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblItemVRKeyReleased
        // TODO add your handling code here:
        if (evt.isControlDown() & evt.getKeyChar() == KeyEvent.VK_DELETE) {
            new c.DeleveryItemTable().removeAllItem(tblItemVR);
        } else if (evt.getKeyChar() == KeyEvent.VK_DELETE) {
            new c.DeleveryItemTable().removeItem(tblItemVR);
        }
    }//GEN-LAST:event_tblItemVRKeyReleased

    private void txtVehicleIdVRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVehicleIdVRKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            new c.VehicleReturn().addItem(txtVehicleIdVR, txtRouteIdVR, dcDeleverDateVR, tblItemVR);
        }
    }//GEN-LAST:event_txtVehicleIdVRKeyTyped

    private void jTabbedPane1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseMoved
        // TODO add your handling code here:
        //JOptionPane.showConfirmDialog(vehicle, "dsafsdf");
        //routeDebitTableView.setRouteCreditTableData(tbl_routeDebit);
        //int rowCount = tbl_routeDebit.getRowCount();
        //tf_routeDebitId.setText(String.valueOf(rowCount + 1));

        routeViewTable.setrouteTableData(tbl_routeDetails);
//        int rowCount1 = tbl_routeDetails.getRowCount();
//        tf_routeId.setText(String.valueOf(rowCount1 + 1));
    }//GEN-LAST:event_jTabbedPane1MouseMoved

    private void btn_routeUpdateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_routeUpdateMouseReleased
        // TODO add your handling code here:
        new RouteUpdate().updateRoute(tf_routeId, tf_routeName, ta_routeDescription, tf_currentCredit);
        routeViewTable.setrouteTableData(tbl_routeDetails);
        //clearRoute();
        //autoComplete = new AutoComplete();
    }//GEN-LAST:event_btn_routeUpdateMouseReleased

    private void tf_currentCreditKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_currentCreditKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar)
                || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_tf_currentCreditKeyTyped

    private void jPanel10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10MouseMoved

    private void dc_routeDebitDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_dc_routeDebitDateFocusGained
        // TODO add your handling code here:
//        routeViewTable.setrouteTableData(tbl_routeDetails);
//        int rowCount = tbl_routeDetails.getRowCount();
//        tf_routeId.setText(String.valueOf(rowCount + 1));
//JOptionPane.showConfirmDialog(vehicle, "efsdf");
    }//GEN-LAST:event_dc_routeDebitDateFocusGained

    private void tf_routeIdDebitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_routeIdDebitFocusGained
        // TODO add your handling code here:
//        routeViewTable.setrouteTableData(tbl_routeDetails);
//        int rowCount = tbl_routeDetails.getRowCount();
//        tf_routeId.setText(String.valueOf(rowCount + 1));
    }//GEN-LAST:event_tf_routeIdDebitFocusGained

    private void tf_routeNameDebitFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_routeNameDebitFocusGained
        // TODO add your handling code here:
//        routeViewTable.setrouteTableData(tbl_routeDetails);
//        int rowCount = tbl_routeDetails.getRowCount();
//        tf_routeId.setText(String.valueOf(rowCount + 1));
    }//GEN-LAST:event_tf_routeNameDebitFocusGained

    private void tbl_routeDebitMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_routeDebitMouseMoved
        // TODO add your handling code here:
//        routeDebitTableView.setRouteCreditTableData(tbl_routeDebit);
//        int rowCount = tbl_routeDebit.getRowCount();
//        tf_routeDebitId.setText(String.valueOf(rowCount + 1));
    }//GEN-LAST:event_tbl_routeDebitMouseMoved

    private void jPanel13MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseMoved
        // TODO add your handling code here:
        //routeDebitTableView.setRouteCreditTableData(tbl_routeDebit);
        //int rowCount = tbl_routeDebit.getRowCount();
        //tf_routeDebitId.setText(String.valueOf(rowCount + 1));
    }//GEN-LAST:event_jPanel13MouseMoved

    private void txtVehicleIdSPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVehicleIdSPKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            new c.DeleverySelfProduct().addItem(txtVehicleIdSP, txtRouteIdSP, dcDeleverDateSP, tblItemSP);
        }
    }//GEN-LAST:event_txtVehicleIdSPKeyTyped

    private void txtSPNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSPNameKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            new c.ProductSearch().getProductData(txtSPName, txtSPunit);
        }
    }//GEN-LAST:event_txtSPNameKeyTyped

    private void txtTPNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTPNameKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            new c.ProductSearch().getProductData(txtTPName, txtTPUnit);
            if (txtTPUnit.getText().contains("750")) {
                double maxBottel = Math.round((Double.parseDouble(tblItemSP.getValueAt(tblItemSP.getSelectedRow(), 3).toString()) / 0.69) * 100.0) / 100.0;
                int maxBottelint = (int) maxBottel;
                txtRemainQty.setText(String.valueOf(maxBottelint));
            } else if (txtTPUnit.getText().contains("375")) {
                double maxBottel = Math.round((Double.parseDouble(tblItemSP.getValueAt(tblItemSP.getSelectedRow(), 3).toString()) / 0.34) * 100.0) / 100.0;
                int maxBottelint = (int) maxBottel;
                txtRemainQty.setText(String.valueOf(maxBottelint));
            } else if (txtTPUnit.getText().contains("360")) {
                double maxBottel = Math.round((Double.parseDouble(tblItemSP.getValueAt(tblItemSP.getSelectedRow(), 3).toString()) / 0.34) * 100.0) / 100.0;
                int maxBottelint = (int) maxBottel;
                txtRemainQty.setText(String.valueOf(maxBottelint));
            }
        }
    }//GEN-LAST:event_txtTPNameKeyTyped

    private void tblItemSPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblItemSPKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblItemSPKeyReleased

    private void tblItemSPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemSPMouseReleased
        // TODO add your handling code here:
        try {
            txtSPName.setText(tblItemSP.getValueAt(tblItemSP.getSelectedRow(), 0).toString());
            txtSPunit.setText(tblItemSP.getValueAt(tblItemSP.getSelectedRow(), 1).toString());
            //txtTPName.requestFocus();
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
        }
    }//GEN-LAST:event_tblItemSPMouseReleased

    private void tblItemSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItemSPMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblItemSPMouseClicked

    private void txtTQtyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTQtyFocusGained
        // TODO add your handling code here:
        if ("0".equals(txtTQty.getText())) {
            txtTQty.setText("");
        }
    }//GEN-LAST:event_txtTQtyFocusGained

    private void txtTQtyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTQtyFocusLost
        // TODO add your handling code here:
        if ("".equals(txtTQty.getText())) {
            txtTQty.setText("0");
        }
    }//GEN-LAST:event_txtTQtyFocusLost

    private void txtTQtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTQtyKeyReleased
        // TODO add your handling code here:
        try {
            if (!txtTQty.getText().isEmpty()) {
                if (txtTPUnit.getText().contains("750")) {
                    double bottelWeight = Double.parseDouble(txtTQty.getText()) * 0.69;
                    bottelWeight = Math.round(bottelWeight * 100.0) / 100.0;
                    double itemQty = Double.parseDouble(tblItemSP.getValueAt(tblItemSP.getSelectedRow(), 4).toString());
                    //txtRemainQty.setText(String.valueOf(itemQty - bottelWeight));

                    double maxbottelCost = Double.parseDouble(txtCPB.getText()) * Double.parseDouble(txtTQty.getText());
                    double maxlabelCost = Double.parseDouble(txtCPL.getText()) * Double.parseDouble(txtTQty.getText());
                    double maxotherCost = Double.parseDouble(txtOC.getText()) * Double.parseDouble(txtTQty.getText());
                    double buyingPrice = new c.DeleverySelfProduct().getBuyingPrice(tblItemSP);
                    double buyingCost = bottelWeight * buyingPrice;

                    double totalCost = maxotherCost + maxbottelCost + maxlabelCost + buyingCost;

                    double price = (totalCost) / Double.parseDouble(txtTQty.getText());

                    txtTC.setText(String.valueOf(Math.round(totalCost * 100.0) / 100.0));
                    txtTPP.setText(String.valueOf(String.valueOf(Math.round(price * 100.0) / 100.0)));
//                    if (itemQty <= bottelWeight) {
//                        evt.consume();
//                        JOptionPane.showMessageDialog(this, "No more Quantity", "Warrning", JOptionPane.WARNING_MESSAGE);
//                    }
                } else if (txtTPUnit.getText().contains("375")) {
                    double bottelWeight = Double.parseDouble(txtTQty.getText()) * 0.34;
                    bottelWeight = Math.round(bottelWeight * 100.0) / 100.0;
                    double itemQty = Double.parseDouble(tblItemSP.getValueAt(tblItemSP.getSelectedRow(), 4).toString());
                    //txtRemainQty.setText(String.valueOf(itemQty - bottelWeight));

                    double maxbottelCost = Double.parseDouble(txtCPB.getText()) * Double.parseDouble(txtTQty.getText());
                    double maxlabelCost = Double.parseDouble(txtCPL.getText()) * Double.parseDouble(txtTQty.getText());
                    double maxotherCost = Double.parseDouble(txtOC.getText()) * Double.parseDouble(txtTQty.getText());
                    double buyingPrice = new c.DeleverySelfProduct().getBuyingPrice(tblItemSP);
                    double buyingCost = bottelWeight * buyingPrice;

                    double totalCost = maxotherCost + maxbottelCost + maxlabelCost + buyingCost;

                    double price = (totalCost) / Double.parseDouble(txtTQty.getText());

                    txtTC.setText(String.valueOf(Math.round(totalCost * 100.0) / 100.0));
                    txtTPP.setText(String.valueOf(String.valueOf(Math.round(price * 100.0) / 100.0)));
//                    if (itemQty <= bottelWeight) {
//                        evt.consume();
//                        JOptionPane.showMessageDialog(this, "No more Quantity", "Warrning", JOptionPane.WARNING_MESSAGE);
//                    }
                } else if (txtTPUnit.getText().contains("360")) {
                    double bottelWeight = Double.parseDouble(txtTQty.getText()) * 0.34;
                    bottelWeight = Math.round(bottelWeight * 100.0) / 100.0;
                    double itemQty = Double.parseDouble(tblItemSP.getValueAt(tblItemSP.getSelectedRow(), 4).toString());
                    //txtRemainQty.setText(String.valueOf(itemQty - bottelWeight));

                    double maxbottelCost = Double.parseDouble(txtCPB.getText()) * Double.parseDouble(txtTQty.getText());
                    double maxlabelCost = Double.parseDouble(txtCPL.getText()) * Double.parseDouble(txtTQty.getText());
                    double maxotherCost = Double.parseDouble(txtOC.getText()) * Double.parseDouble(txtTQty.getText());
                    double buyingPrice = new c.DeleverySelfProduct().getBuyingPrice(tblItemSP);
                    double buyingCost = bottelWeight * buyingPrice;

                    double totalCost = maxotherCost + maxbottelCost + maxlabelCost + buyingCost;

                    double price = (totalCost) / Double.parseDouble(txtTQty.getText());

                    txtTC.setText(String.valueOf(Math.round(totalCost * 100.0) / 100.0));
                    txtTPP.setText(String.valueOf(String.valueOf(Math.round(price * 100.0) / 100.0)));
//                    if (itemQty <= bottelWeight) {
//                        evt.consume();
//                        JOptionPane.showMessageDialog(this, "No more Quantity", "Warrning", JOptionPane.WARNING_MESSAGE);
//                    }
                }
            } else {
                //txtRemainQty.setText(tblItemVR1.getValueAt(tblItemVR1.getSelectedRow(), 3).toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_txtTQtyKeyReleased

    private void txtTQtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTQtyKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTQtyKeyTyped

    private void txtTQtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTQtyKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtTQtyKeyPressed

    private void txtCPBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPBFocusGained
        // TODO add your handling code here:
        if ("0".equals(txtCPB.getText())) {
            txtCPB.setText("");
        }
    }//GEN-LAST:event_txtCPBFocusGained

    private void txtCPBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPBFocusLost
        // TODO add your handling code here:
        if ("".equals(txtCPB.getText())) {
            txtCPB.setText("0");
        }
    }//GEN-LAST:event_txtCPBFocusLost

    private void txtCPLFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPLFocusGained
        // TODO add your handling code here:
        if ("0".equals(txtCPL.getText())) {
            txtCPL.setText("");
        }
    }//GEN-LAST:event_txtCPLFocusGained

    private void txtCPLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCPLFocusLost
        // TODO add your handling code here:
        if ("".equals(txtCPL.getText())) {
            txtCPL.setText("0");
        }
    }//GEN-LAST:event_txtCPLFocusLost

    private void txtOCFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOCFocusGained
        // TODO add your handling code here:
        if ("0".equals(txtOC.getText())) {
            txtOC.setText("");
        }
    }//GEN-LAST:event_txtOCFocusGained

    private void txtOCFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtOCFocusLost
        // TODO add your handling code here:
        if ("".equals(txtOC.getText())) {
            txtOC.setText("0");
        }
    }//GEN-LAST:event_txtOCFocusLost

    public void resetAll() {
        dcDeleverDateSP.setDate(new Date());
        txtRouteIdSP.setText("");
        txtRouteNameSP.setText("");
        txtVehicleNameSP.setText("");
        txtVehicleIdSP.setText("");
        txtSPName.setText("");
        txtSPunit.setText("");
        txtTPName.setText("");
        txtTPUnit.setText("");
        txtCPB.setText("0");
        txtCPL.setText("0");
        txtOC.setText("0");
        txtTQty.setText("0");
        txtTC.setText("0");
        txtTPP.setText("0");
        DefaultTableModel dtm = (DefaultTableModel) tblItemSP.getModel();
        dtm.setRowCount(0);
        txtRouteNameSP.requestFocus();
    }

    private void btnSaveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseReleased
        // TODO add your handling code here:
        DeleverySelfProduct deleverySelfProduct = new c.DeleverySelfProduct();
        deleverySelfProduct.saveGRNLog(dcDeleverDateSP, txtTPP, txtTQty, txtTPName, tblItemSP);
        deleverySelfProduct.saveDeleverItemLog(dcDeleverDateSP, tblItemSP, txtVehicleIdSP, txtRouteIdSP, txtTPUnit, txtTQty);
        double bottelWeight = 0.0;
        if (txtTPUnit.getText().contains("750")) {
            bottelWeight = Double.parseDouble(txtTQty.getText()) * 0.69;
        } else if (txtTPUnit.getText().contains("375")) {
            bottelWeight = Double.parseDouble(txtTQty.getText()) * 0.34;
        } else if (txtTPUnit.getText().contains("360")) {
            bottelWeight = Double.parseDouble(txtTQty.getText()) * 0.34;
        }
        deleverySelfProduct.getByLogId(Integer.parseInt(tblItemSP.getValueAt(tblItemSP.getSelectedRow(), 5).toString()));
        double remainQty = Double.parseDouble(tblItemSP.getValueAt(tblItemSP.getSelectedRow(), 3).toString()) - Math.round(bottelWeight * 100.0) / 100.0;
        //deleverySelfProduct.getByLogId(WIDTH);
        deleverySelfProduct.updateQty(Math.round(remainQty * 100.0) / 100.0);
        deleverySelfProduct.getByProductName(txtTPName.getText());
        deleverySelfProduct.updateProduct(Double.parseDouble(txtTPP.getText()));
        deleverySelfProduct.saveMoneyBook(dcDeleverDateSP, "Self Production Cost", Double.parseDouble(txtTC.getText()), "Cash", "Production Cost", "Expend");
        AssetControl.getInstance().updateCashAsset(Double.parseDouble(txtTC.getText()) * Double.parseDouble(txtTQty.getText()), '-');

        DeliverDetail.setDcDeleverDateDI(dcDeleverDateDI);
        DeliverDetail.setTxtRouteIdDI(txtRouteIdDI);
        DeliverDetail.setTxtRouteNameDI(txtRouteNameDI);
        DeliverDetail.setTxtVehicleIdDI(txtVehicleIdDI);
        DeliverDetail.setTxtVehicleiNumberDI(txtVehicleNumberDI);

        DeliverDetail.setDcDeleverDateSP(dcDeleverDateSP);
        DeliverDetail.setTxtRouteIdSP(txtRouteIdSP);
        DeliverDetail.setTxtRouteNameSP(txtRouteNameSP);
        DeliverDetail.setTxtVehicleIdSP(txtVehicleIdSP);
        DeliverDetail.setTxtVehicleNameSP(txtVehicleNameSP);
        DeliverDetail.setTblItemSP(tblItemSP);

        DeliverDetail.setDcDeleverDateVR(dcDeleverDateVR);
        DeliverDetail.setTxtRouteIdVR(txtRouteIdVR);
        DeliverDetail.setTxtRouteNameVR(txtRouteNameVR);
        DeliverDetail.setTxtVehicleIdVR(txtVehicleIdVR);
        DeliverDetail.setTxtVehicleNumberVR(txtVehicleNumberVR);
        DeliverDetail.setTblItemVR(tblItemVR);

        int conformInvoice = JOptionPane.showConfirmDialog(null, "Do you have any delivery invoice ?", "Deliver Invoice", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (conformInvoice == 0) {
            tpDelivery.setSelectedIndex(2);
            DeliverDetail.getDcDeleverDateDI().setDate(dcDeleverDateSP.getDate());
            DeliverDetail.getTxtRouteIdDI().setText(txtRouteIdSP.getText());
            DeliverDetail.getTxtRouteNameDI().setText(txtRouteNameSP.getText());
            DeliverDetail.getTxtVehicleIdDI().setText(txtVehicleIdSP.getText());
            DeliverDetail.getTxtVehicleiNumberDI().setText(txtVehicleNameSP.getText());
        } else if (conformInvoice == 1) {
            int conformReturn = JOptionPane.showConfirmDialog(null, "Do you return your delivery ?", "Deliver Return", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (conformReturn == 0) {
                tpDelivery.setSelectedIndex(3);
                DeliverDetail.getDcDeleverDateVR().setDate(dcDeleverDateSP.getDate());
                DeliverDetail.getTxtRouteIdVR().setText(txtRouteIdSP.getText());
                DeliverDetail.getTxtRouteNameVR().setText(txtRouteNameSP.getText());
                DeliverDetail.getTxtVehicleIdVR().setText(txtVehicleIdSP.getText());
                DeliverDetail.getTxtVehicleNumberVR().setText(txtVehicleNameSP.getText());
                try {
                    new c.VehicleReturn().addItem(DeliverDetail.getTxtVehicleIdVR(), DeliverDetail.getTxtRouteIdVR(), DeliverDetail.getDcDeleverDateVR(), DeliverDetail.getTblItemVR());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        resetAll();
    }//GEN-LAST:event_btnSaveMouseReleased

    private void btnResetMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMouseReleased
        // TODO add your handling code here:
        resetAll();
        vehicleViewTable = new VehicleViewTable();
        vehicleViewTable.setTableData(tbl_allVehicles);

        routeViewTable = new RouteViewTable();
        routeViewTable.setrouteTableData(tbl_routeDetails);

        routeCreditTableView = new RouteCreditTableView();
        //routeCreditTableView.setRouteCreditTableData(tbl_routeCredit);

        routeDebitTableView = new RouteDebitTableView();
        routeDebitTableView.setRouteCreditTableData(tbl_routeDebit, dc_routeDebitDate);

        ac = new AutoComplete();
        ac.acProductName(txtProductName);
        ac.acProductName(txtSPName);
        ac.acProductName(txtTPName);
        clear();
        clearRoute();
        //clearRouteCredit();
        clearRouteDebit();
    }//GEN-LAST:event_btnResetMouseReleased

    private void txtCPBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPBKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCPBKeyTyped

    private void txtCPLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPLKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCPLKeyTyped

    private void txtOCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOCKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtOCKeyTyped

    private void txtTPPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTPPKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTPPKeyTyped

    private void txtVehicleNumberVRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVehicleNumberVRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVehicleNumberVRActionPerformed

    private void txtVehicleNumberVRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVehicleNumberVRKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                int routeByName = new VehicleReturn().getVehicleByNumber(txtVehicleNumberVR.getText());
                txtVehicleIdVR.setText(String.valueOf(routeByName));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (!((JTextField) dcDeleverDateVR.getDateEditor().getUiComponent()).getText().isEmpty()) {
                if (!txtRouteIdVR.getText().isEmpty()) {
                    if (!txtVehicleIdVR.getText().isEmpty()) {

                        new c.VehicleReturn().addItem(txtVehicleIdVR, txtRouteIdVR, dcDeleverDateVR, tblItemVR);

                    }
                }
            }
        }
    }//GEN-LAST:event_txtVehicleNumberVRKeyTyped

    private void txtRouteNameVRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRouteNameVRKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                int routeByName = new VehicleReturn().getRouteByName(txtRouteNameVR.getText());
                txtRouteIdVR.setText(String.valueOf(routeByName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtRouteNameVRKeyTyped

    private void txtRouteNameDIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRouteNameDIKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                int routeByName = new VehicleReturn().getRouteByName(txtRouteNameDI.getText());
                txtRouteIdDI.setText(String.valueOf(routeByName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtRouteNameDIKeyTyped

    private void txtPnameDIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPnameDIKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            new c.ProductSearch().getProductData(txtPnameDI, txtPUnitDI, txtUnitPriceDI);
            txtUnitPriceDI.requestFocus();
        }
    }//GEN-LAST:event_txtPnameDIKeyTyped

    private void txtVehicleNumberDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVehicleNumberDIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVehicleNumberDIActionPerformed

    private void txtVehicleNumberDIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVehicleNumberDIKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                int routeByName = new VehicleReturn().getVehicleByNumber(txtVehicleNumberDI.getText());
                txtVehicleIdDI.setText(String.valueOf(routeByName));
            } catch (Exception e) {
                e.printStackTrace();
            }
//            
//            new c.VehicleReturn().addItem(txtVehicleId, txtRouteId, dcDeleverDate, tblItemVR);
        }
    }//GEN-LAST:event_txtVehicleNumberDIKeyTyped

    private void btnAddItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddItem1MouseReleased
        // TODO add your handling code here:
        if (!((JTextField) dcDeleverDateDI.getDateEditor().getUiComponent()).getText().isEmpty()) {
            if (!txtRouteIdDI.getText().isEmpty()) {
                if (!txtVehicleIdDI.getText().isEmpty()) {
                    if (!txtPnameDI.getText().isEmpty()) {
                        if (!txtPUnitDI.getText().isEmpty()) {
                            if (!txtUnitPriceDI.getText().isEmpty()) {
                                if (!txtQtyDI.getText().isEmpty()) {
                                    if (!txtTVDI.getText().isEmpty()) {
                                        new DeliveryInvoice().addItem(txtVehicleIdDI, txtRouteIdDI, txtPnameDI, txtQtyDI, txtTVDI, dcDeleverDateDI, tblItemDI);
                                        clearText();
                                        txtPnameDI.requestFocus();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnAddItem1MouseReleased

    private void btnSummeryVR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummeryVR1ActionPerformed
        // TODO add your handling code here:
        if (tblItemDI.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Please enter minimum one to the table.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {

            DeliverDetail.setDcDeleverDateVR(dcDeleverDateVR);
            DeliverDetail.setTxtRouteIdVR(txtRouteIdVR);
            DeliverDetail.setTxtRouteNameVR(txtRouteNameVR);
            DeliverDetail.setTxtVehicleIdVR(txtVehicleIdVR);
            DeliverDetail.setTxtVehicleNumberVR(txtVehicleNumberVR);
            DeliverDetail.setTblItemVR(tblItemVR);

            DeliverDetail.getDcDeleverDateVR().setDate(dcDeleverDateDI.getDate());
            DeliverDetail.getTxtRouteIdVR().setText(txtRouteIdDI.getText());
            DeliverDetail.getTxtRouteNameVR().setText(txtRouteNameDI.getText());
            DeliverDetail.getTxtVehicleIdVR().setText(txtVehicleIdDI.getText());
            DeliverDetail.getTxtVehicleNumberVR().setText(txtVehicleNumberDI.getText());

            new v.frmDeliveryInvoice(tblItemDI, txtRouteIdDI, jTabbedPane1).setVisible(true);
        }

    }//GEN-LAST:event_btnSummeryVR1ActionPerformed

    private void txtPUnitDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPUnitDIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPUnitDIActionPerformed

    private void txtPUnitDIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPUnitDIKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPUnitDIKeyTyped

    private void txtVehicleIdDIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVehicleIdDIKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVehicleIdDIKeyTyped

    private void txtQtyDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtyDIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtyDIActionPerformed

    public void clearText() {
        txtPnameDI.setText("");
        txtPUnitDI.setText("");
        txtUnitPriceDI.setText("0");
        txtQtyDI.setText("0");
        txtTVDI.setText("0");
    }

    private void txtQtyDIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyDIKeyTyped
        // TODO add your handling code here:    
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            if (!((JTextField) dcDeleverDateDI.getDateEditor().getUiComponent()).getText().isEmpty()) {
                if (!txtRouteIdDI.getText().isEmpty()) {
                    if (!txtVehicleIdDI.getText().isEmpty()) {
                        if (!txtPnameDI.getText().isEmpty()) {
                            if (!txtPUnitDI.getText().isEmpty()) {
                                if (!txtUnitPriceDI.getText().isEmpty()) {
                                    if (!txtQtyDI.getText().isEmpty()) {
                                        if (!txtTVDI.getText().isEmpty()) {
                                            new DeliveryInvoice().addItem(txtVehicleIdDI, txtRouteIdDI, txtPnameDI, txtQtyDI, txtTVDI, dcDeleverDateDI, tblItemDI);
                                            clearText();
                                            txtPnameDI.requestFocus();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        //new DeliveryInvoice().addItem(txtVehicleIdDI, txtRouteIdDI, txtPnameDI, txtQtyDI, txtTVDI, dcDeleverDateDI, tblItemDI);
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
        //txtRouteNameDI.requestFocus();
        //clearText();
    }//GEN-LAST:event_txtQtyDIKeyTyped

    private void tblItemDIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblItemDIKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tblItemDIKeyReleased

    private void btnRIVR1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRIVR1MouseReleased
        // TODO add your handling code here:
        new c.DeleveryItemTable().removeItem(tblItemDI);
    }//GEN-LAST:event_btnRIVR1MouseReleased

    private void btnRAVR1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRAVR1MouseReleased
        // TODO add your handling code here:
        new c.DeleveryItemTable().removeAllItem(tblItemDI);
    }//GEN-LAST:event_btnRAVR1MouseReleased

    private void txtQtyDIFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyDIFocusGained
        // TODO add your handling code here:
        if ("0".equals(txtQtyDI.getText())) {
            txtQtyDI.setText("");
        }
    }//GEN-LAST:event_txtQtyDIFocusGained

    private void txtQtyDIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtyDIFocusLost
        // TODO add your handling code here:
        if ("".equals(txtQtyDI.getText())) {
            txtQtyDI.setText("0");
        }
    }//GEN-LAST:event_txtQtyDIFocusLost

    private void txtVehicleNameSPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVehicleNameSPKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                int routeByName = new VehicleReturn().getVehicleByNumber(txtVehicleNameSP.getText());
                txtVehicleIdSP.setText(String.valueOf(routeByName));
                new c.DeleverySelfProduct().addItem(txtVehicleIdSP, txtRouteIdSP, dcDeleverDateSP, tblItemSP);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtVehicleNameSPKeyTyped

    private void txtRouteNameSPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRouteNameSPKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                int routeByName = new VehicleReturn().getRouteByName(txtRouteNameSP.getText());
                txtRouteIdSP.setText(String.valueOf(routeByName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtRouteNameSPKeyTyped

    private void txtTVDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTVDIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTVDIActionPerformed

    private void txtTVDIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTVDIKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtTVDIKeyTyped

    private void txtUnitPriceDIFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUnitPriceDIFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitPriceDIFocusGained

    private void txtUnitPriceDIFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUnitPriceDIFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitPriceDIFocusLost

    private void txtUnitPriceDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUnitPriceDIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUnitPriceDIActionPerformed

    private void txtUnitPriceDIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnitPriceDIKeyTyped
        // TODO add your handling code here:
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE) || vChar == KeyEvent.VK_PERIOD)) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUnitPriceDIKeyTyped

    private void txtQtyDIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQtyDIKeyReleased
        // TODO add your handling code here:
        if (txtQtyDI.getText().isEmpty()) {
            //txtQtyDI.setText("0");
            double unitPrice = Double.parseDouble(txtUnitPriceDI.getText());
            double qty = 0.0;
            double totalValue = unitPrice * qty;
            double tot = Math.round(totalValue * 100.0) / 100.0;
            txtTVDI.setText(String.valueOf(tot));
        } else if (!txtQtyDI.getText().isEmpty()) {
            double unitPrice = Double.parseDouble(txtUnitPriceDI.getText());
            double qty = Double.parseDouble(txtQtyDI.getText());
            double totalValue = unitPrice * qty;
            double tot = Math.round(totalValue * 100.0) / 100.0;
            txtTVDI.setText(String.valueOf(tot));
        }
    }//GEN-LAST:event_txtQtyDIKeyReleased

    private void txtRouteNameRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRouteNameRKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                int routeByName = new VehicleReturn().getRouteByName(txtRouteNameR.getText());
                txtRouteIdR.setText(String.valueOf(routeByName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtRouteNameRKeyTyped

    private void txtVehicleIdRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVehicleIdRKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVehicleIdRKeyTyped

    private void txtVehicleNumberRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVehicleNumberRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVehicleNumberRActionPerformed

    private void txtVehicleNumberRKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVehicleNumberRKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            try {
                int routeByName = new VehicleReturn().getVehicleByNumber(txtVehicleNumberR.getText());
                txtVehicleIdR.setText(String.valueOf(routeByName));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_txtVehicleNumberRKeyTyped

    private String read() {
        BufferedReader br = null;
        String everything = null;
        try {
            String name = ((JTextField) dcDeleverDateR.getDateEditor().getUiComponent()).getText() + "_" + txtRouteIdR.getText() + "_" + txtVehicleIdR.getText() + ".txt";
            br = new BufferedReader(new FileReader("D:\\ReportDocs\\" + name));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                //sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
            //System.out.println(everything);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return everything;
    }

    public void getReport() {
        String read = read();
        String[] data = read.split("/");
        try {
            String path = "C:\\Program Files\\Common Files\\Report\\VehicleReturn.jrxml";
            JasperReport RI = JasperCompileManager.compileReport(path);

            Map<String, Object> parameter = new HashMap<>();
//            System.out.println(data[0]);
//            System.out.println(data[1]);
//            System.out.println(data[2]);
//            System.out.println(data[3]);
//            System.out.println(data[4]);
//            System.out.println(data[5]);
//            System.out.println(data[6]);
//            System.out.println(data[7]);
//            System.out.println(data[8]);
            parameter.put("TotalSale", Double.parseDouble(data[0]));
            parameter.put("CashAmount", Double.parseDouble(data[1]));
            parameter.put("ChequeAmount", Double.parseDouble(data[2]));
            parameter.put("CreditPayAmount", Double.parseDouble(data[3]));
            parameter.put("CreditAmount", Double.parseDouble(data[4]));
            parameter.put("DeliverCost", Double.parseDouble(data[5]));
            parameter.put("ProductCost", Double.parseDouble(data[6]));
            parameter.put("GrossProfit", Double.parseDouble(data[7]));
            parameter.put("NetProfit", Double.parseDouble(data[8]));
            JasperPrint printit = JasperFillManager.fillReport(RI, parameter, new JREmptyDataSource());
            //JasperPrintManager.printReport(printit, false);
            JasperViewer.viewReport(printit, false);
        } catch (Exception e) {
            e.printStackTrace();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void btnSummeryVR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSummeryVR2ActionPerformed
        // TODO add your handling code here:
        getReport();
    }//GEN-LAST:event_btnSummeryVR2ActionPerformed

    private void jPanel48MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel48MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel48MouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAI;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAddItem1;
    private javax.swing.JButton btnDeal;
    private javax.swing.JButton btnRA;
    private javax.swing.JButton btnRAVR;
    private javax.swing.JButton btnRAVR1;
    private javax.swing.JButton btnRI;
    private javax.swing.JButton btnRIVR;
    private javax.swing.JButton btnRIVR1;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSummeryVR;
    private javax.swing.JButton btnSummeryVR1;
    private javax.swing.JButton btnSummeryVR2;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_clearRoute;
    private javax.swing.JButton btn_clearRouteDebit;
    private javax.swing.JButton btn_routeDebitSearch;
    private javax.swing.JButton btn_routeUpdate;
    private javax.swing.JButton btn_saveRoute;
    private javax.swing.JButton btn_saveRouteDebit;
    private javax.swing.JButton btn_vRegister;
    private javax.swing.JButton btn_vUpdate;
    private com.toedter.calendar.JDateChooser dcDeleverDateDI;
    private com.toedter.calendar.JDateChooser dcDeleverDateR;
    private com.toedter.calendar.JDateChooser dcDeleverDateSP;
    private com.toedter.calendar.JDateChooser dcDeleverDateVR;
    private com.toedter.calendar.JDateChooser dc_routeDebitDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
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
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblLastDeliverDate;
    private javax.swing.JTextArea ta_routeDescription;
    private javax.swing.JTable tblItem;
    private javax.swing.JTable tblItemDI;
    private javax.swing.JTable tblItemSP;
    private javax.swing.JTable tblItemVR;
    private javax.swing.JTable tbl_allVehicles;
    private javax.swing.JTable tbl_routeDebit;
    private javax.swing.JTable tbl_routeDetails;
    private javax.swing.JTextField tf_currentCredit;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_regNumber1;
    private javax.swing.JTextField tf_routeDebit;
    private javax.swing.JTextField tf_routeId;
    private javax.swing.JTextField tf_routeIdDebit;
    private javax.swing.JTextField tf_routeName;
    private javax.swing.JTextField tf_routeNameDebit;
    private javax.swing.JTextField txtCPB;
    private javax.swing.JTextField txtCPL;
    private javax.swing.JTextField txtLQ;
    private javax.swing.JTextField txtOC;
    private javax.swing.JTextField txtPUnitDI;
    private javax.swing.JTextField txtPnameDI;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtQtyDI;
    private javax.swing.JLabel txtRemainQty;
    private javax.swing.JTextField txtRouteIdDI;
    private javax.swing.JTextField txtRouteIdR;
    private javax.swing.JTextField txtRouteIdSP;
    private javax.swing.JTextField txtRouteIdVR;
    private javax.swing.JTextField txtRouteNameDI;
    private javax.swing.JTextField txtRouteNameR;
    private javax.swing.JTextField txtRouteNameSP;
    private javax.swing.JTextField txtRouteNameVR;
    private javax.swing.JTextField txtSPName;
    private javax.swing.JTextField txtSPunit;
    private javax.swing.JTextField txtTC;
    private javax.swing.JTextField txtTPName;
    private javax.swing.JTextField txtTPP;
    private javax.swing.JTextField txtTPUnit;
    private javax.swing.JTextField txtTQty;
    private javax.swing.JTextField txtTVDI;
    private javax.swing.JTextField txtUnitName;
    private javax.swing.JTextField txtUnitPriceDI;
    private javax.swing.JTextField txtVehicleIdDI;
    private javax.swing.JTextField txtVehicleIdR;
    private javax.swing.JTextField txtVehicleIdSP;
    private javax.swing.JTextField txtVehicleIdVR;
    private javax.swing.JTextField txtVehicleNameSP;
    private javax.swing.JTextField txtVehicleNumberDI;
    private javax.swing.JTextField txtVehicleNumberR;
    private javax.swing.JTextField txtVehicleNumberVR;
    // End of variables declaration//GEN-END:variables
}
