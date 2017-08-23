/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.oracle.jrockit.jfr.Producer;
import java.util.ArrayList;
import java.util.Date;
import pojo.Grn;
import pojo.GrnLog;
import pojo.MoneyBook;
import pojo.Product;
import pojo.ProductionLogBottle;
import pojo.ProductionLogMix;
import pojo.Supplier;

/**
 *
 * @author User
 */
public class selfproductcontroller {

    Grn grnpojo;

    public Product findPridByName(String prname) {
        Product byprName = null;
        try {
            byprName = new m.Product().getByprName(prname);
            return byprName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int getStockToMix(Product product1, Product product2, double pr1quantity, double pr2quantity) {
        try {
            pr1quantity = (Math.round(pr1quantity * 100.0) / 100.0);
            pr2quantity = (Math.round(pr2quantity * 100.0) / 100.0);
            double productqty1 = pr1quantity;
            double productqty2 = pr2quantity;

            ArrayList<pojo.GrnLog> pgrn1 = new m.GrnLog().loadNotEmptyProductByName(product1);
            ArrayList<pojo.GrnLog> pgrn2 = new m.GrnLog().loadNotEmptyProductByName(product2);
            double newremqty1;
            double newremqty2;
            for (GrnLog grnLog : pgrn1) {

                if (grnLog.getRemainingQuantity() > pr1quantity) {
                    newremqty1 = grnLog.getRemainingQuantity() - pr1quantity;
                    newremqty1 = (Math.round(newremqty1 * 100.0) / 100.0);
                    grnLog.setRemainingQuantity(newremqty1);
                    new m.GrnLog().update(grnLog);
                    break;

                } else if (grnLog.getRemainingQuantity() == pr1quantity) {
                    newremqty1 = 0;
                    grnLog.setRemainingQuantity(newremqty1);
                    new m.GrnLog().update(grnLog);
                    break;
                } else if (grnLog.getRemainingQuantity() < pr1quantity) {
                    pr1quantity = pr1quantity - grnLog.getRemainingQuantity();
                    newremqty1 = 0;
                    grnLog.setRemainingQuantity(newremqty1);
                    new m.GrnLog().update(grnLog);

                } else {
                    Errormzg.displayerrorMessage("not enough stock");
                }
            }
            for (GrnLog grnLog : pgrn2) {

                if (grnLog.getRemainingQuantity() > pr2quantity) {
                    newremqty2 = grnLog.getRemainingQuantity() - pr2quantity;
                    grnLog.setRemainingQuantity(newremqty2);
                    new m.GrnLog().update(grnLog);;
                    break;

                } else if (grnLog.getRemainingQuantity() == pr2quantity) {
                    newremqty2 = 0;
                    grnLog.setRemainingQuantity(newremqty2);
                    new m.GrnLog().update(grnLog);
                    break;
                } else if (grnLog.getRemainingQuantity() < pr2quantity) {
                    pr2quantity = pr2quantity - grnLog.getRemainingQuantity();
                    newremqty2 = 0;
                    grnLog.setRemainingQuantity(newremqty2);
                    new m.GrnLog().update(grnLog);

                } else {
                    Errormzg.displayerrorMessage("not enough stock");
                }

            }
            pojo.Product pr1 = new m.Product().getByName(product1);
            pojo.Product pr2 = new m.Product().getByName(product2);
            double pr1crntstock = pr1.getCurrentStock() - productqty1;
            pr1crntstock = (Math.round(pr1crntstock * 100.0) / 100.0);
            pr1.setCurrentStock(pr1crntstock);
            double pr2crntstock = pr2.getCurrentStock() - productqty2;
            pr2crntstock = (Math.round(pr2crntstock * 100.0) / 100.0);
            pr2.setCurrentStock(pr2crntstock);

            new m.Product().update(pr1);
            new m.Product().update(pr2);
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
            return 0;
        }

    }

    public GrnLog savegrnlog(Date date, double quantity, double price,String targetprname) {
        try {

            Supplier sup = new m.Supplier().getBy(1);
            Grn grnpojo = new Grn();
            grnpojo.setSupplier(sup);
            grnpojo.setDate(date);
            int grnid = new m.Grn().saveGrn(grnpojo);
            Grn grnobj = new m.Grn().getBy(grnid);

            Product prid = new m.Product().getByName(targetprname);

            GrnLog grnlgpojo = new GrnLog();
            grnlgpojo.setGrn(grnobj);
            grnlgpojo.setBuyingPrice(price);
            grnlgpojo.setTotal(0.0);
            grnlgpojo.setQuantity(quantity);
            grnlgpojo.setProduct(prid);
            grnlgpojo.setRemainingQuantity(quantity);

            int grnlgid = new m.GrnLog().save(grnlgpojo);
            GrnLog grnlogidobj = new m.GrnLog().getBy(grnlgid);
            int done = new c.StockControler().getaverageprice(prid);
            if (done != 0) {
                return grnlogidobj;
            } else {
                Errormzg.displayerrorMessage("somthing went wrong");
                return null;

            }

        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            return null;
        }

    }

    public int savemix(Product pr1, Product pr2, double qt1, double qt2, Date date, double quantity, double averageprice, GrnLog grnlog) {

        try {
            qt1 = (Math.round(qt1 * 100.0) / 100.0);
            qt2 = (Math.round(qt2 * 100.0) / 100.0);

            ProductionLogMix plm = new ProductionLogMix();
            plm.setDate(date);
            plm.setAveragePrice(averageprice);
            plm.setProductByProduct1(pr1);
            plm.setProductByProduct2(pr2);
            plm.setProduct1Quantity(qt1);
            plm.setProduct2Quantity(qt2);
            plm.setQuantity(quantity);
            plm.setGrnLog(grnlog);

            int i = new m.ProductionLogMix().save(plm);
            if (i != 0) {
                return i;
            } else {
                Errormzg.displayerrorMessage("somthing went wrong");
                return 0;
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            return 0;
        }

    }

    public int getStockToBottle(Product product, double quantity) {

        try {
            quantity = (Math.round(quantity * 100.0) / 100.0);
            double qtystock = quantity;
            ArrayList<pojo.GrnLog> pgrn1 = new m.GrnLog().loadNotEmptyProductByName(product);
            double newremqty1;
            for (GrnLog grnLog : pgrn1) {

                if (grnLog.getRemainingQuantity() > quantity) {
                    newremqty1 = grnLog.getRemainingQuantity() - quantity;
                    newremqty1 = (Math.round(newremqty1 * 100.0) / 100.0);
                    grnLog.setRemainingQuantity(newremqty1);
                    new m.GrnLog().update(grnLog);
                    break;

                } else if (grnLog.getRemainingQuantity() == quantity) {
                    newremqty1 = 0;
                    grnLog.setRemainingQuantity(newremqty1);
                    new m.GrnLog().update(grnLog);
                    break;

                } else if (grnLog.getRemainingQuantity() < quantity) {
                    quantity = quantity - grnLog.getRemainingQuantity();
                    newremqty1 = 0;
                    grnLog.setRemainingQuantity(newremqty1);
                    new m.GrnLog().update(grnLog);

                } else {
                    Errormzg.displayerrorMessage("not enough stock quantity");
                }

            }
            pojo.Product prid = new m.Product().getByName(product);
            double prcrntstock = prid.getCurrentStock() - qtystock;
            prcrntstock = (Math.round(prcrntstock * 100.0) / 100.0);
            prid.setCurrentStock(prcrntstock);
            new m.Product().update(prid);

            return 1;

        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
            return 0;
        }

    }

    public GrnLog saveBtlGrnLog(Date date, double quantity, double price, Product pr) {
        try {
            Supplier sup = new m.Supplier().getBy(1);
            Grn grnpojo = new Grn();
            grnpojo.setSupplier(sup);
            grnpojo.setDate(date);
            int grnid = new m.Grn().saveGrn(grnpojo);
            Grn grnobj = new m.Grn().getBy(grnid);

            Product prid = new m.Product().getByName(pr);

            GrnLog grnlgpojo = new GrnLog();
            grnlgpojo.setGrn(grnobj);
            grnlgpojo.setBuyingPrice(price);
            grnlgpojo.setTotal(0.0);
            grnlgpojo.setQuantity(quantity);
            grnlgpojo.setProduct(prid);
            grnlgpojo.setRemainingQuantity(quantity);

            int grnlgid = new m.GrnLog().save(grnlgpojo);
            GrnLog grnlogidobj = new m.GrnLog().getBy(grnlgid);
            int done = new c.StockControler().getaverageprice(prid);
            if (done != 0) {
                return grnlogidobj;
            } else {
                Errormzg.displayerrorMessage("somthing went wrong");
                return null;

            }

        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            return null;
        }

    }

    public int saveBottle(Product prbtl, Product pr1, double btlqty, double prqty, Date date, double bottlecost, double labelcost, double othercost, double btlprprice, GrnLog grnlog) {
        try {
            pojo.ProductionLogBottle plb = new ProductionLogBottle();
            plb.setDate(date);
            plb.setBtlQuantity(btlqty);
            plb.setGrnLog(grnlog);
            plb.setCostPerBottle(bottlecost);
            plb.setLabelCost(labelcost);
            plb.setOtherCosts(othercost);
            plb.setProductQty(prqty);
            plb.setProductByBottleProductId(prbtl);
            plb.setProductByProductId(pr1);
            plb.setProductPrice(btlprprice);

            int done = new m.ProductionLogBottle().save(plb);
            if (done != 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int btlExtraCosts(double amount, Date date) {
        try {
            pojo.DealType dt = new m.DealType().getBy(4);
            pojo.DealCategory dc = new m.DealCategory().getBy(2);
//            pojo.CashType ct = new m.CashType().getBY(1);

            pojo.MoneyBook mb = new MoneyBook();
            mb.setAmount(amount);
//            mb.setCashType(ct);
            mb.setDate(date);
            mb.setDealCategory(dc);
            mb.setDealType(dt);
            mb.setDscription("nn");
            int done = new m.MoneyBook().saveint(mb);

            pojo.AssetStatus as = new m.AssetStatus().getById(1);
            as.setAmount(as.getAmount() - amount);
            new m.AssetStatus().update(as);

            return done;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
