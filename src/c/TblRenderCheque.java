/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author suhada
 */
public class TblRenderCheque extends JLabel implements TableCellRenderer {

    Color gl = new Color(102, 255, 153);
    Color gd = new Color(0, 204, 68);
    Color rl = new Color(255, 102, 102);
    Color ol = new Color(255, 163, 102);
    Color od = new Color(255, 117, 26);
    Date today = new Date();

    public TblRenderCheque() {
        this.setOpaque(true);
        this.setForeground(Color.WHITE);
        this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Date chequeDate = (Date) table.getValueAt(row, 5);
        this.setText(value.toString());
        if (((String) table.getValueAt(row, 0)).equalsIgnoreCase("+")) {
            if (chequeDate.getTime() > today.getTime() && chequeDate.getTime() <= (today.getTime() + (1000 * 60 * 60 * 24 * 3))) {
                this.setBackground(gd);
            } else if (chequeDate.getTime() < today.getTime()) {
                this.setBackground(rl);
            } else {
                this.setBackground(gl);
            }
        } else if (((String) table.getValueAt(row, 0)).equalsIgnoreCase("-")) {
            if (chequeDate.getTime() > today.getTime() && chequeDate.getTime() <= (today.getTime() + (1000 * 60 * 60 * 24 * 3))) {
                this.setBackground(od);
            } else if (chequeDate.getTime() < today.getTime()) {
                this.setBackground(rl);
            } else {
                this.setBackground(ol);
            }
        } else {
            this.setBackground(Color.black);
        }
        if (table.getSelectedRow() == row) {
            this.setBackground(Color.CYAN);
        }
        return this;
    }

}
