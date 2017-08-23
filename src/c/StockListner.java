/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import m.Grn;
import m.Product;
import pojo.GrnLog;
import pojo.Lost;
import v.Stock;

/**
 *
 * @author suhada
 */
public class StockListner implements MouseListener,ComponentListener{
    public static StockListner StockListner=null;
    public static StockListner getInstance(){
        if(StockListner==null)StockListner=new StockListner();
        return StockListner;
    }

    private v.Stock stock;
    public boolean setStock(Stock stock) {
        this.stock = stock;
        if(this.stock!=null)return true;
        else return false;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        try{
        if(v.Stock.getInstance().getBtnMakeLost()==e.getSource()){
            if(this.stock!=null){
            if(this.setTbl(v.Stock.getInstance().getTblLostGrn())){
            if(this.setLost_date(v.Stock.getInstance().getLostDate())){
            if(this.tbl.getSelectedRow()>-1){
            if(this.setProductId((int)this.tbl.getValueAt(this.tbl.getSelectedRow(), 0))){
            if(this.setLost_amount(Double.parseDouble(v.Stock.getInstance().getLostAmount()))){
                int id=(int)this.getTbl().getValueAt(this.getTbl().getSelectedRow(), 0);
                m.GrnLog GRNLog=new m.GrnLog();
                GrnLog grn = new m.GrnLog().getById(id);
                Product Product = new m.Product();
                pojo.Product product = Product.getByGRNLog(grn);
                if(this.lost_amount<=grn.getRemainingQuantity()){
                    Lost Lost = new pojo.Lost();
                    Lost.setAmount(this.lost_amount);
                    Lost.setDate(new Date());
                    Lost.setGrnLog(grn);
                    String add = new m.Lost().add(Lost);
                    if(add.equalsIgnoreCase("done")){
                        product.setCurrentStock(product.getCurrentStock()-this.lost_amount);
                        Product.update(product);
                        DefaultTableModel dtm=(DefaultTableModel) this.tbl.getModel();
                        double remain = grn.getRemainingQuantity()-this.lost_amount;
                        dtm.setValueAt(remain, this.tbl.getSelectedRow(), 4);
                        grn.setRemainingQuantity(remain);
                        GRNLog.update(grn);
                        JOptionPane.showMessageDialog(null, "Added Successful.","Message",JOptionPane.INFORMATION_MESSAGE);
                        setTbl(v.Stock.getInstance().getTblLost());
                        this.loadLost();
                    }else JOptionPane.showMessageDialog(null, "Adding failed.","Fail",JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(stock, "Not enogh quantity.Enter quantity less than or equal \n according to the remain quantity \n reset reduce from another stock");
                }
                product.getCurrentPrice();
            }else{JOptionPane.showMessageDialog(v.Stock.getInstance(), "Please enter lost quantity","Warning",JOptionPane.WARNING_MESSAGE);}
            }else{JOptionPane.showMessageDialog(v.Stock.getInstance(), "Not Found Product ID","Warning",JOptionPane.WARNING_MESSAGE);}
            }else{JOptionPane.showMessageDialog(v.Stock.getInstance(), "Select a product","Warning",JOptionPane.WARNING_MESSAGE);}
            }else{JOptionPane.showMessageDialog(v.Stock.getInstance(), "Not Found Date","Warning",JOptionPane.WARNING_MESSAGE);}
            }else{JOptionPane.showMessageDialog(v.Stock.getInstance(), "Not Found Table","Warning",JOptionPane.WARNING_MESSAGE);}
            }else{JOptionPane.showMessageDialog(v.Stock.getInstance(), "Not Found View","Error",JOptionPane.ERROR_MESSAGE);}
        }else if(v.Stock.getInstance().getTblLostGrn()==e.getSource()){
            if(setTbl(v.Stock.getInstance().getTblLostGrn())){
                int id = (int)this.tbl.getValueAt(this.tbl.getSelectedRow(), 0);
                loadProductDetailsLost(id);
            }
        }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(v.Stock.getInstance(), "Please Check Numbers again","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    @Override
    public void componentResized(ComponentEvent e) {
        
    }
    @Override
    public void componentMoved(ComponentEvent e) {
        
    }
    @Override
    public void componentShown(ComponentEvent e) {
        
        if(e.getComponent().getAccessibleContext().getAccessibleName().equalsIgnoreCase("lost_manage")){
            this.setMsg(v.Stock.getInstance().getLabelMsgLost());
            this.setLost_productname(v.Stock.getInstance().getLabelProductnameLost());
            this.setLost_buyingprice(v.Stock.getInstance().getLabelBuyingPriceLost());
            this.setLost_amount_lbl(v.Stock.getInstance().getLabelAmountLost());
            this.setLost_total(v.Stock.getInstance().getLabelTotalLost());
            if(setTbl(v.Stock.getInstance().getTblLostGrn())){
                this.loadAvailabelStock();
                this.reset();
            }
            if(setTbl(v.Stock.getInstance().getTblLost())){
                this.loadLost();
            }
        }
    }
    @Override
    public void componentHidden(ComponentEvent e) {
        
    }
    
    private JLabel lost_productname=null;
    public void setLost_productname(JLabel lost_productname) {
        this.lost_productname = lost_productname;
    }
    private JLabel lost_buyingprice=null;
    public void setLost_buyingprice(JLabel lost_buyingprice) {
        this.lost_buyingprice = lost_buyingprice;
    }
    private JLabel lost_amount_lbl=null;
    public void setLost_amount_lbl(JLabel lost_amount_lbl) {
        this.lost_amount_lbl = lost_amount_lbl;
    }
    private JLabel lost_total=null;
    public void setLost_total(JLabel lost_total) {
        this.lost_total = lost_total;
    }
    private double lost_amount=-1;
    public boolean setLost_amount(double lost_amount) {
        this.lost_amount = lost_amount;
        if(this.lost_amount>-1)return true;
        else return false;
    }
    public double getLost_amount() {
        return lost_amount;
    }
    private Date lost_date=null;
    public boolean setLost_date(Date lost_date) {
        this.lost_date = lost_date;
        if(this.lost_date!=null)return true;
        else return false;
    }
    public Date getLost_date() {
        return lost_date;
    }
    private JTable tbl=null;
    public boolean setTbl(JTable tbl) {
        this.tbl = tbl;
        if(tbl!=null)
            return true;
        else return false;
    }
    private JTable getTbl() {
        return tbl;
    }
    private int productId=-1;
    public boolean setProductId(int productId) {
        this.productId = productId;
        if(this.productId>0)return true;
        else return false;
    }
    private int getProductId() {
        return productId;
    }
    private JLabel msg_lost=null;
    public void setMsg(JLabel msg) {
        this.msg_lost = msg;
    }
    private JLabel getMsg() {
        return msg_lost;
    }
    
    
    
    public void reset(){
        this.lost_amount=-1;
        this.lost_date=null;
        this.tbl=null;
        this.productId=-1;
        this.msg_lost = null;
    }
    
    private void loadAvailabelStock(){
        List<GrnLog> listAvailabelStock = new m.GrnLog().getAllAvailabelStocks();
        msg_lost.setText("Please wait....");
        msg_lost.setSize(msg_lost.getWidth(), 20);
        if(listAvailabelStock!=null&&!listAvailabelStock.isEmpty()){
            DefaultTableModel dtm= (DefaultTableModel) this.getTbl().getModel();
            dtm.setRowCount(0);
            Grn GRN = new m.Grn();
            Product product = new m.Product();
            int rowVal=0;
            pojo.Product Product=null;
            for (GrnLog grnLog : listAvailabelStock) {
                Vector v=new Vector();
                v.add(grnLog.getId());
                if(Product==null||Product.getId()!=grnLog.getProduct().getId()){
                    Product=product.getBy(grnLog.getProduct().getId());
                    rowVal=0;
                }
                if(rowVal==0){
                    v.add(Product.getName());
                }else{
                    v.add("");
                    v.add("");
                }
                v.add(GRN.getBy(grnLog.getGrn().getId()).getDate());
                v.add(grnLog.getBuyingPrice());
                v.add(grnLog.getRemainingQuantity());
                dtm.addRow(v);
            }
        }else{
            JOptionPane.showMessageDialog(v.Stock.getInstance(), "Not Found Available Stocks","Message",JOptionPane.INFORMATION_MESSAGE);
        }
            msg_lost.setText("");
            msg_lost.setSize(msg_lost.getWidth(), 0);
    }
    private void loadProductDetailsLost(int id){
        pojo.GrnLog GrnLog = new m.GrnLog().getBy(id);
        this.lost_productname.setText(new m.Product().getBy(GrnLog.getProduct().getId()).getName());
        this.lost_buyingprice.setText(GrnLog.getBuyingPrice()+"");
        this.lost_amount_lbl.setText(GrnLog.getRemainingQuantity()+"");
        this.lost_total.setText(m.ValueValidation.getInstance().toDeciaml(GrnLog.getBuyingPrice()*GrnLog.getRemainingQuantity(), 2)+"");
    }
    private void loadLost(){
        DefaultTableModel dtm=(DefaultTableModel) this.tbl.getModel();
        dtm.setRowCount(0);
        List<Lost> list = new m.Lost().getAll();
        if(list!=null&&!list.isEmpty()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Product product = new m.Product();
            m.GrnLog grnLog = new m.GrnLog();
            for (Lost lost : list) {
                Vector v=new Vector();
                v.add(sdf.format(lost.getDate()));
                v.add(product.getByGRNLog(lost.getGrnLog()).getName());
                v.add(lost.getAmount());
                GrnLog Log = grnLog.getById(lost.getGrnLog().getId());
                v.add(m.ValueValidation.getInstance().toDeciaml(Log.getBuyingPrice()*lost.getAmount(), 2));
                dtm.addRow(v);
            }
        }
    }
}
