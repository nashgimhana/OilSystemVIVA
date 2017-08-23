/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author suhada
 */
public class MenuStyler implements MouseListener{

    public static MenuStyler MenuStyler=null;
    public static MenuStyler getInstance(){
        if(MenuStyler==null)MenuStyler=new MenuStyler();return MenuStyler;
    }
    private v.Home home=null;
    public void setHome(v.Home home){
        this.home=home;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        Component comp = e.getComponent();
        Container parent = comp.getParent();
        Component[] components = parent.getComponents();
        if(components.length>0){
            int clen=components.length;
            for (int i = 0; i < clen; i++) {
                components[i].setBackground(Color.WHITE);
            }
            comp.setBackground(c.View.getInstance().colorMenuSelet);
        }
        if(e.getSource()==this.home.lbl_status){
            c.View.getInstance().setStatusViewToDPane(v.Home.getInstance().dpnl_contain);
        }else if(e.getSource()==this.home.lbl_stock){
            c.View.getInstance().setStockViewToDPane(v.Home.getInstance().dpnl_contain);
        }else if(e.getSource()==this.home.lbl_employee){
            c.View.getInstance().setEmployeeViewToDPane(v.Home.getInstance().dpnl_contain);
        }else if(e.getSource()==this.home.lbl_cashcheck){
            c.View.getInstance().setCashCheckBookViewToDPane(v.Home.getInstance().dpnl_contain);
        }else if(e.getSource()==this.home.lbl_vehicle){
            c.View.getInstance().setDeliveryViewToDPane(v.Home.getInstance().dpnl_contain);
        }else if(e.getSource()==this.home.lbl_supplier){
            c.View.getInstance().setSupplierView(v.Home.getInstance().dpnl_contain);
        }else if(e.getSource()==this.home.lbl_Customer){
            c.View.getInstance().setCutomerViewToDPane(v.Home.getInstance().dpnl_contain);
        }else if(e.getSource()==this.home.lbl_Invoice){
            c.View.getInstance().setInvoiceToDPane(v.Home.getInstance().dpnl_contain);
        }else if(e.getSource()==this.home.lbl_selfproduct){
            c.View.getInstance().setSelfproducttodPane(v.Home.getInstance().dpnl_contain);
        }else if(e.getSource()==this.home.lbl_backup){
            c.View.getInstance().setBackupPane(v.Home.getInstance().dpnl_contain);
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
        Component component = e.getComponent();
        if(component.getBackground()!=c.View.getInstance().colorMenuSelet)
        component.setBackground(c.View.getInstance().colorMenuOver);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Component component = e.getComponent();
        if(component.getBackground()!=c.View.getInstance().colorMenuSelet)
        component.setBackground(Color.WHITE);
    }
    
}
