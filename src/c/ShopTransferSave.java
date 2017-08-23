/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import javax.swing.JTextField;
import pojo.AssetLog;
import pojo.AssetStatus;
//import pojo.CashType;
import pojo.DealCategory;
import pojo.DealType;
import pojo.Grn;
import pojo.GrnLog;
import pojo.MoneyBook;
import pojo.Product;
import pojo.ShopTransfer;
import pojo.ShopTransferLog;

/**
 *
 * @author User
 */
public class ShopTransferSave {
//
//    public void saveShopTransfer(JDateChooser dateChooser, JTable jTable, JTextField quantity) {
//        if (quantity.getText().isEmpty()) {
//            Errormzg.displayerrorMessage("Please enter a Quantity value");
//        } else {
//
//            Double q = Double.parseDouble(quantity.getText());
//            ShopTransfer shopTransfer = new pojo.ShopTransfer();
//            shopTransfer.setDate(dateChooser.getDate());
//
//            int rowCount = jTable.getRowCount();
//            Double tableTotal = new c.GrnLogTableView().getTableTotal(jTable);
//            double quantityD = Double.parseDouble(quantity.getText());
//            //System.out.println("Quantitty by tf "+quantityD);
//            Double newRemainingQuantity = 0.0;
//            if (tableTotal >= quantityD) {
//                for (int i = 0; i < rowCount; i++) {
//                    double rowValue = Double.parseDouble(jTable.getValueAt(i, 3).toString());
//                    int grnId = Integer.parseInt(jTable.getValueAt(i, 0).toString());
//                    String productName = jTable.getValueAt(i, 1).toString();
//
//                    Product byprName = new m.Product().getByprName(productName);
//                    System.out.println("Product name " + byprName.getName());
//                    System.out.println("Product id " + byprName.getId());
//                    System.out.println("Product Quantity "+ byprName.getCurrentStock());
//                    Double currentStock = byprName.getCurrentStock();
//                    System.out.println("Product "+ byprName.getCurrentPrice());
//
//                    System.out.println(rowValue);
//
//                    if (rowValue < quantityD) {
//                        System.out.println("Should subract from next row");
//
//                        quantityD = quantityD - rowValue;
//                        newRemainingQuantity = 0.0;
//
//                        System.out.println(newRemainingQuantity);
//                        System.out.println("GRn log id " + grnId);
//
//                        GrnLog by = new m.GrnLog().getBy(grnId);
//                        System.out.println("GRn log id from db " + by.getId());
//                        System.out.println("grnlog quantity " + by.getQuantity());
//                        System.out.println("grnlog buying price" + by.getBuyingPrice());
//                        System.out.println("grnlo remain quantity " + by.getRemainingQuantity());
//                        System.out.println("Grn id" + by.getGrn().getId());
//
//                        Grn grn = new m.Grn().getBy(by.getGrn().getId());
//
//                        GrnLog grnLog = new pojo.GrnLog();
//                        grnLog.setId(by.getId());
//                        grnLog.setGrn(grn);
//                        grnLog.setProduct(byprName);
//                        grnLog.setBuyingPrice(by.getBuyingPrice());
//                        grnLog.setQuantity(by.getQuantity());
//                        grnLog.setRemainingQuantity(newRemainingQuantity);
//                        //grnLog.setTotal(newRemainingQuantity * by.getBuyingPrice());
//                        grnLog.setTotal(by.getTotal());
////                    
//                        new m.GrnLog().update(grnLog);
//
//                    } else {
//                        System.out.println("Can be done from this row");
//                        newRemainingQuantity = rowValue - quantityD;
//
//                        System.out.println(newRemainingQuantity);
//                        System.out.println("GRn log id " + grnId);
//
//                        GrnLog by = new m.GrnLog().getBy(grnId);
//                        System.out.println("GRn log id from db " + by.getId());
//                        System.out.println("grnlog quantity " + by.getQuantity());
//                        System.out.println("grnlog buying price" + by.getBuyingPrice());
//                        System.out.println("grnlo remain quantity " + by.getRemainingQuantity());
//                        System.out.println("Grn id" + by.getGrn().getId());
//
//                        Grn grn = new m.Grn().getBy(by.getGrn().getId());
//
//                        GrnLog grnLog = new pojo.GrnLog();
//                        grnLog.setId(by.getId());
//                        grnLog.setGrn(grn);
//                        grnLog.setProduct(byprName);
//                        grnLog.setBuyingPrice(by.getBuyingPrice());
//                        grnLog.setQuantity(by.getQuantity());
//                        grnLog.setRemainingQuantity(newRemainingQuantity);
//                        //grnLog.setTotal(newRemainingQuantity * by.getBuyingPrice());
//                        grnLog.setTotal(by.getTotal());
////                    
//                        new m.GrnLog().update(grnLog);
//
//                        ShopTransferLog shopTransferLog = new pojo.ShopTransferLog();
//                        shopTransferLog.setQuantity(q);
//                        shopTransferLog.setGrnLog(grnLog);
//                        shopTransferLog.setShopTransfer(shopTransfer);
//
//                        //shopTransfer.setShopTransferLogs(shopTransferLog);
//                        new m.ShopTransfer().save(shopTransfer);
//                        new m.ShopTrasnferLog().save(shopTransferLog);
//                        byprName.setCurrentStock(currentStock - q);
//                        new m.Product().update(byprName);
//                        System.out.println("Quantity stl ##################################################" + q);
//                        System.out.println("Quantity stl ##################################################" + quantityD);
//                        break;
//                    }
//                }
//            } else {
//                System.out.println("Fuck off");
//                Errormzg.displayerrorMessage("Please enter a Quantity less or equal to Total Quantity");
//            }
//        }
//
//    }

    public void saveShopTransfer(JDateChooser dateChooser, JTable jTable, JTextField quantity) {
        try {
            if (quantity.getText().isEmpty()) {
                Errormzg.displayerrorMessage("Please enter a Quantity value");
            } else {

                Double q = Double.parseDouble(quantity.getText());
                q = (Math.round(q * 100.0) / 100.0);
                ShopTransfer shopTransfer = new pojo.ShopTransfer();
                shopTransfer.setDate(dateChooser.getDate());

                int rowCount = jTable.getRowCount();
                Double tableTotal = new c.GrnLogTableView().getTableTotal(jTable);
                tableTotal = (Math.round(tableTotal * 100.0) / 100.0);
                double quantityD = Double.parseDouble(quantity.getText());
                quantityD = (Math.round(quantityD * 100.0) / 100.0);
                //System.out.println("Quantitty by tf "+quantityD);
                Double newRemainingQuantity = 0.00;
                newRemainingQuantity = (Math.round(newRemainingQuantity * 100.0) / 100.0);
                if (tableTotal >= quantityD) {

                    for (int i = 0; i < rowCount; i++) {

                        double rowValue = Double.parseDouble(jTable.getValueAt(i, 3).toString());
                        rowValue = (Math.round(rowValue * 100.0) / 100.0);
                        int grnId = Integer.parseInt(jTable.getValueAt(i, 0).toString());
                        String productName = jTable.getValueAt(i, 1).toString();

                        Product byprName = new m.Product().getByprName(productName);
                        //System.out.println("Product name " + byprName.getName());
                        //System.out.println("Product id " + byprName.getId());
                        //System.out.println("Product Quantity " + byprName.getCurrentStock());
                        Double currentStock = byprName.getCurrentStock();
                        currentStock = (Math.round(currentStock * 100.0) / 100.0);
                        //System.out.println("Product " + byprName.getCurrentPrice());

                        //System.out.println(rowValue);
                        if (rowValue < quantityD) {
                            System.out.println("Should subract from next row");

                            quantityD = quantityD - rowValue;
                            newRemainingQuantity = 0.00;
                            newRemainingQuantity = (Math.round(newRemainingQuantity * 100.0) / 100.0);

                            //System.out.println(newRemainingQuantity);
                            //System.out.println("GRn log id " + grnId);
                            GrnLog grnLog = new m.GrnLog().getBy(grnId);
                            //System.out.println("GRn log id from db " + by.getId());
                            //System.out.println("grnlog quantity " + by.getQuantity());
                            //System.out.println("grnlog buying price" + by.getBuyingPrice());
                            //System.out.println("grnlo remain quantity " + by.getRemainingQuantity());
                            //System.out.println("Grn id" + by.getGrn().getId());

                            //Grn grn = new m.Grn().getBy(by.getGrn().getId());
                            //GrnLog grnLog = new pojo.GrnLog();
                            //grnLog.setId(by.getId());
                            //grnLog.setGrn(grn);
                            //grnLog.setProduct(byprName);
                            //grnLog.setBuyingPrice(by.getBuyingPrice());
                            //grnLog.setQuantity(by.getQuantity());
                            //grnLog.setRemainingQuantity(newRemainingQuantity);
                            //grnLog.setTotal(newRemainingQuantity * by.getBuyingPrice());
                            //grnLog.setTotal(by.getTotal());
//                    
                            //new m.GrnLog().update(grnLog);
                            System.out.println("new Remain Quantity : " + newRemainingQuantity);
                            grnLog.setRemainingQuantity(newRemainingQuantity);
                            new m.GrnLog().update(grnLog);

                            DealCategory dealCategory = new m.DealCategory().getBy(1);
                            DealType dealType = new m.DealType().getBy(1);
//                            CashType cashType = new m.CashType().getBY(1);

                            MoneyBook moneyBook = new pojo.MoneyBook();
                            moneyBook.setDate(dateChooser.getDate());
                            moneyBook.setDscription("Shop Transfer Log");
                            Double buyingPrice = grnLog.getBuyingPrice();
                            buyingPrice = (Math.round(buyingPrice * 100.0) / 100.0);

                            moneyBook.setAmount(rowValue * buyingPrice);
                            moneyBook.setDealCategory(dealCategory);
                            moneyBook.setDealType(dealType);
//                            moneyBook.setCashType(cashType);

                            new m.MoneyBook().save(moneyBook);

                            new m.ShopTransfer().save(shopTransfer);

                            ShopTransferLog shopTransferLog = new pojo.ShopTransferLog();
                            shopTransferLog.setShopTransfer(shopTransfer);
                            shopTransferLog.setGrnLog(grnLog);
                            shopTransferLog.setQuantity(rowValue);
                            shopTransferLog.setMoneyBook(moneyBook);

                            new m.ShopTrasnferLog().save(shopTransferLog);

                            double quantityDD = Double.parseDouble(quantity.getText());

                            Double total = buyingPrice * quantityDD;

                            total = (Math.round(total * 100.0) / 100.0);

                            AssetStatus assetStatus = new m.AssetStatus().getById(1);

                            AssetLog assetLog = new AssetLog();
                            assetLog.setAssetStatus(assetStatus);
                            assetLog.setDate(dateChooser.getDate());
                            assetLog.setDesceiption("Shop Transfer");
                            new m.AssetLog().saveAssetLog(assetLog);

                            Double assetStatusAmount = assetStatus.getAmount();
                            System.out.println("AssetAmount : " + assetStatusAmount);

                            assetStatusAmount = (assetStatusAmount + total);
                            assetStatusAmount = (Math.round(assetStatusAmount * 100.0) / 100.0);
                            System.out.println("AssetAmount : " + assetStatusAmount);
                            assetStatus.setAmount(assetStatusAmount);
                            new m.AssetStatus().updateAssetStatusMe(assetStatus);

                        } else {
                            System.out.println("Can be done from this row");

                            rowValue = (Math.round(rowValue * 100.0) / 100.0);
                            quantityD = (Math.round(quantityD * 100.0) / 100.0);
                            newRemainingQuantity = rowValue - quantityD;
                            newRemainingQuantity = (Math.round(newRemainingQuantity * 100.0) / 100.0);

                            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@new Remain final row" + newRemainingQuantity);
                            System.out.println("GRn log id " + grnId);

                            GrnLog grnLog = new m.GrnLog().getBy(grnId);
                            //System.out.println("GRn log id from db " + by.getId());
                            //System.out.println("grnlog quantity " + by.getQuantity());
                            //System.out.println("grnlog buying price" + by.getBuyingPrice());
                            //System.out.println("grnlo remain quantity " + by.getRemainingQuantity());
                            //System.out.println("Grn id" + by.getGrn().getId());

                            //Grn grn = new m.Grn().getBy(by.getGrn().getId());
                            //GrnLog grnLog = new pojo.GrnLog();
                            //grnLog.setId(by.getId());
                            //grnLog.setGrn(grn);
                            //grnLog.setProduct(byprName);
                            //grnLog.setBuyingPrice(by.getBuyingPrice());
                            //grnLog.setQuantity(by.getQuantity());
                            //grnLog.setRemainingQuantity(newRemainingQuantity);
                            //grnLog.setTotal(newRemainingQuantity * by.getBuyingPrice());
                            //grnLog.setTotal(by.getTotal());
//                    
                            //new m.GrnLog().update(grnLog);
                            grnLog.setRemainingQuantity(newRemainingQuantity);
                            new m.GrnLog().update(grnLog);

                            DealCategory dealCategory = new m.DealCategory().getBy(1);
                            DealType dealType = new m.DealType().getBy(1);
//                            CashType cashType = new m.CashType().getBY(1);

                            MoneyBook moneyBook = new pojo.MoneyBook();
                            moneyBook.setDate(dateChooser.getDate());
                            moneyBook.setDscription("Shop Transfer Log");
                            Double buyingPrice = grnLog.getBuyingPrice();
                            buyingPrice = (Math.round(buyingPrice * 100.0) / 100.0);
                            double name = quantityD * buyingPrice;
                            name = (Math.round(name * 100.0) / 100.0);
                            moneyBook.setAmount(name);
                            moneyBook.setDealCategory(dealCategory);
                            moneyBook.setDealType(dealType);
//                            moneyBook.setCashType(cashType);

                            new m.MoneyBook().save(moneyBook);

                            new m.ShopTransfer().save(shopTransfer);

                            ShopTransferLog shopTransferLog = new pojo.ShopTransferLog();
                            quantityD = (Math.round(quantityD * 100.0) / 100.0);
                            shopTransferLog.setQuantity(quantityD);
                            shopTransferLog.setGrnLog(grnLog);
                            shopTransferLog.setShopTransfer(shopTransfer);
                            shopTransferLog.setMoneyBook(moneyBook);
                            //shopTransfer.setShopTransferLogs(shopTransferLog);
                            new m.ShopTrasnferLog().save(shopTransferLog);

                            byprName.setCurrentStock(currentStock - q);
                            new m.Product().update(byprName);
                            System.out.println("Quantity stl q ##################################################" + q);
                            System.out.println("Quantity stl quantityD ##################################################" + quantityD);

                            //GrnLog grnLog = new m.GrnLog().getBy(grnId);
                            //Double buyingPrice = grnLog.getBuyingPrice();
                            double quantityDD = Double.parseDouble(quantity.getText());

                            Double total = buyingPrice * quantityDD;

                            total = (Math.round(total * 100.0) / 100.0);

                            AssetStatus assetStatus = new m.AssetStatus().getById(1);

                            AssetLog assetLog = new AssetLog();
                            assetLog.setAssetStatus(assetStatus);
                            assetLog.setDate(dateChooser.getDate());
                            assetLog.setDesceiption("Shop Transfer");
                            new m.AssetLog().saveAssetLog(assetLog);

                            Double assetStatusAmount = assetStatus.getAmount();
                            System.out.println("AssetAmount : " + assetStatusAmount);

                            assetStatusAmount = (assetStatusAmount + total);
                            assetStatusAmount = (Math.round(assetStatusAmount * 100.0) / 100.0);
                            System.out.println("AssetAmount : " + assetStatusAmount);
                            assetStatus.setAmount(assetStatusAmount);
                            new m.AssetStatus().updateAssetStatusMe(assetStatus);
                            break;
                        }
//                        GrnLog grnLog = new m.GrnLog().getBy(grnId);
//                        Double buyingPrice = grnLog.getBuyingPrice();
//
//                        double quantityDD = Double.parseDouble(quantity.getText());
//
//                        Double total = buyingPrice * quantityDD;
//
//                        total = (Math.round(total * 100.0) / 100.0);
//
//                        AssetStatus assetStatus = new m.AssetStatus().getById(1);
//
//                        AssetLog assetLog = new AssetLog();
//                        assetLog.setAssetStatus(assetStatus);
//                        assetLog.setDate(dateChooser.getDate());
//                        assetLog.setDesceiption("Shop Transfer");
//                        //new m.AssetLog().saveAssetLog(assetLog);
//
//                        Double assetStatusAmount = assetStatus.getAmount();
//                        System.out.println("AssetAmount : " + assetStatusAmount);
//
//                        assetStatusAmount = (assetStatusAmount + total);
//                        assetStatusAmount = (Math.round(assetStatusAmount * 100.0) / 100.0);
//                        System.out.println("AssetAmount : " + assetStatusAmount);
//                        assetStatus.setAmount(assetStatusAmount);
//                        //new m.AssetStatus().updateAssetStatusMe(assetStatus);

                    }
                } else {
                    System.out.println("off");
                    Errormzg.displayerrorMessage("Please enter a Quantity less or equal to Total Quantity");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
