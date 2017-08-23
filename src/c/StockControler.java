/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JTable;
//import m.CashType;
import m.DealType;
import m.SupplierCredit;
import m.SupplierPay;
import pojo.Bank;
import pojo.Cheques;
//import pojo.ChequeDetails;
import pojo.DealCategory;
import pojo.Grn;
import pojo.GrnLog;
import pojo.MoneyBook;
import pojo.Product;
import pojo.Supplier;
import pojo.Units;

/**
 *
 * @author User
 */
public class StockControler {

    Units un;
    Product pr;
    m.Units u;
    m.Product mpr;
    pojo.Grn grn;
    pojo.GrnLog grnlg;
    m.GrnLog grnlgm;
    m.Grn grnm;
    Errormzg er = new Errormzg();

    public void unitSave(String uname) {
        un = new Units();
        try {
            if (!uname.toString().trim().equals("")) {
                un.setUnitName(uname);
                u = new m.Units();
                u.save(un);

            } else {
                er.displayerrorMessage("please Enter Unit Name");
            }
        } catch (Exception e) {
            er.displayerrorMessage(e.toString());
        }

    }

    public void productSave(String prname, Units unid) {
        pr = new Product();
        try {
            if (!prname.toString().trim().equals("")) {
                pr.setName(prname);
                pr.setUnits(unid);
                pr.setCurrentStock(0.0);
                pr.setCurrentPrice(0.0);
                mpr = new m.Product();
                mpr.save(pr);

            } else {
                er.displayerrorMessage("please Enter Product Name");
            }
        } catch (Exception e) {
            er.displayerrorMessage(e.toString());
            e.printStackTrace();
        }

    }

    public int grnsave(Supplier supid, Date date) {
        int grnsaveid = 0;
        grn = new Grn();
        try {
            if (!supid.equals(null)) {
                grn.setSupplier(supid);
                if (!date.equals(null)) {
                    grn.setDate(date);
                    grnm = new m.Grn();
                    grnsaveid = grnm.saveGrn(grn);
//                    System.out.println(grnsaveid + "controller");
                    return grnsaveid;
                } else {
                    Errormzg.displayerrorMessage("please set supplier");
                    return 0;
                }
            } else {
                Errormzg.displayerrorMessage("please set date");
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int grnlogsave(Grn grnid, Product prid, double buyingprice, double quantity, double total) {
        int grnlogsaveid = 0;
        grnlg = new GrnLog();
        try {
            if (!grnid.equals(null)) {
                grnlg.setGrn(grnid);
                if (!prid.equals(null)) {
                    grnlg.setProduct(prid);
                    if (total != 0) {
                        buyingprice = (Math.round(buyingprice * 100.0) / 100.0);
                        grnlg.setBuyingPrice(buyingprice);
                        quantity = (Math.round(quantity * 100.0) / 100.0);
                        grnlg.setQuantity(quantity);
                        grnlg.setRemainingQuantity(quantity);
                        grnlg.setTotal(total);
                        grnlgm = new m.GrnLog();
                        grnlogsaveid = grnlgm.save(grnlg);
                        return grnlogsaveid;
                    } else {
                        Errormzg.displayerrorMessage("please set total");
                        return 0;
                    }
                } else {
                    Errormzg.displayerrorMessage("please set product");
                    return 0;
                }
            } else {
                Errormzg.displayerrorMessage("please set grn");
                return 0;
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            e.printStackTrace();
            return 0;
        }

    }

    public Grn setGrnIdToGrnlog(int grnid) {
        Grn byID = null;
        try {
            if (grnid != 0) {
                grnm = new m.Grn();
                byID = grnm.getBy(grnid);

            } else {
                Errormzg.displayerrorMessage("please select unit");
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            e.printStackTrace();
        }
        return byID;
    }

    public Units setunitid(String unitname) {
        Units byName = null;
        try {
            if (!unitname.toString().trim().equals(null)) {
                u = new m.Units();
                byName = u.getByName(unitname);

            } else {
                Errormzg.displayerrorMessage("please select unit");
            }
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            e.printStackTrace();
        }
        return byName;
    }

    public Product findPridByName(String prname) {
        Product byprName = null;
        try {
            mpr = new m.Product();
            byprName = mpr.getByprName(prname);
            return byprName;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int getaverageprice(Product p) {

        grnlgm = new m.GrnLog();
        int i = 0;

        try {
            ArrayList<GrnLog> grn = grnlgm.loadNotEmptyProductByName(p);
            double bsum = 0.0;
            double remqty = 0.0;
            double fullqty = 0.0;
            double tot1 = 0.0;
            int prid = 0;
            Product prpo = null;
            for (GrnLog grnLog : grn) {
//                System.out.println("for ekta awa");
                bsum = grnLog.getBuyingPrice();
                remqty = grnLog.getRemainingQuantity();
                fullqty = fullqty + grnLog.getRemainingQuantity();
                tot1 = tot1 + bsum * remqty;
                prid = grnLog.getProduct().getId();
            }
            prpo = new m.Product().getBy(prid);
            double average = tot1 / fullqty;

            double avreager = Math.round(average * 100.0) / 100.0;
            prpo.setCurrentPrice(avreager);
            fullqty = Math.round(fullqty * 100.0) / 100.0;
            prpo.setCurrentStock(fullqty);

            i = new m.Product().update(prpo);
            return i;

        } catch (Exception e) {
            e.printStackTrace();
            Errormzg.displayerrorMessage(e.toString());
            return 0;
        }

    }
    m.MoneyBook mb;
    pojo.MoneyBook mbpojo;
    pojo.SupplierPay suppaypojo;
    pojo.SupplierCredit supplierCredit;
//    ChequeDetails chequeDetails;

    public int supplierpaycredit1(pojo.Supplier sup, Date date, double crntcredit, double payamount, int cashtype) {
        System.out.println("credit ekta awaaa");
        int success = 0;
        try {
//            pojo.CashType ctpojo = new CashType().getBY(cashtype);
            pojo.DealType dtpojo = new DealType().getBy(3);
            DealCategory dcpojo = new m.DealCategory().getBy(2);
            payamount = (Math.round(payamount * 100.0) / 100.0);
            crntcredit = (Math.round(crntcredit * 100.0) / 100.0);

            if (crntcredit == payamount) {
                mbpojo = new pojo.MoneyBook();
                mb = new m.MoneyBook();
                mbpojo.setDate(date);
                mbpojo.setDscription("nothing special");
                mbpojo.setAmount(payamount);
                mbpojo.setDealCategory(dcpojo);
                mbpojo.setDealType(dtpojo);
//                mbpojo.setCashType(ctpojo);
                int save = mb.saveint(mbpojo);
                if (save != 0) {

                    MoneyBook mbreturnid = mb.getBy(save);
                    suppaypojo = new pojo.SupplierPay();
                    suppaypojo.setMoneyBook(mbreturnid);
                    suppaypojo.setSupplier(sup);

                    int ok = new SupplierPay().saveint(suppaypojo);
                    pojo.AssetStatus as = new m.AssetStatus().getById(1);
                    as.setAmount(as.getAmount() - payamount);
                    new m.AssetStatus().update(as);
                    if (ok != 0) {
                        sup.setCurrentCredit(0.0);
                        success = new m.Supplier().update(sup);
                    } else {
                        Errormzg.displayerrorMessage("unable to save supplierpay");
                    }

                } else {
                    Errormzg.displayerrorMessage("unable to save moneybook");
                }

            } else if (payamount < crntcredit && payamount > 0) {

                double dueamount = crntcredit - payamount;
                dueamount = (Math.round(dueamount * 100.0) / 100.0);

                mbpojo = new pojo.MoneyBook();
                mb = new m.MoneyBook();
                mbpojo.setDate(date);
                mbpojo.setDscription("nothing special");
                mbpojo.setAmount(payamount);
                mbpojo.setDealCategory(dcpojo);
                mbpojo.setDealType(dtpojo);
//                mbpojo.setCashType(ctpojo);
                int save = mb.saveint(mbpojo);
                if (save != 0) {
//                    System.out.println("money book save una");
                    MoneyBook mbreturnid = mb.getBy(save);
                    suppaypojo = new pojo.SupplierPay();
                    suppaypojo.setMoneyBook(mbreturnid);
                    suppaypojo.setSupplier(sup);

                    new SupplierPay().saveint(suppaypojo);
                    pojo.AssetStatus as = new m.AssetStatus().getById(1);
                    as.setAmount(as.getAmount() - payamount);
                    new m.AssetStatus().update(as);

                    sup.setCurrentCredit(dueamount);

                    success = new m.Supplier().update(sup);
                    if (success != 0) {
                        Errormzg.displayconfirmMessage(dueamount + "  amount paid as credit");
                    } else {
                        Errormzg.displayerrorMessage("unable to paid credit");
                    }

                } else {
                    Errormzg.displayerrorMessage("unable to save moneybook");
                }

            } else {
                Errormzg.displayerrorMessage("Please check again.somthing went wrong");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;

        }
        return success;
    }

    public int supplierpaycredit2(pojo.Supplier sup, Date date, double crntcredit, double payamount, int cashtype, JTable tblchque) {
        System.out.println("credit ekta awaaa");

        payamount = (Math.round(payamount * 100.0) / 100.0);
        crntcredit = (Math.round(crntcredit * 100.0) / 100.0);
        try {
            if (payamount != 0) {

                Cheques cheques = new Cheques();

                for (int j = 0; j < tblchque.getRowCount(); j++) {
                    System.out.println("cheque table ekta awa");
                    cheques.setCheckno(tblchque.getValueAt(j, 0).toString());
                    pojo.Bank bnk = new m.Bank().getBy(tblchque.getValueAt(j, 1).toString());
                    cheques.setBank(bnk);
                    cheques.setChequeAmount(Double.parseDouble(tblchque.getValueAt(j, 2).toString()));
                    cheques.setDate(date);
                    cheques.setChequeDate(new SimpleDateFormat("yyyy-MM-dd").parse(tblchque.getValueAt(j, 3).toString()));
                    cheques.setStatus(0);
                    cheques.setDiscription("Supplier/" + sup.getId());
                    cheques.setType("-");
                    new m.Cheques().saveint(cheques);

                }
            } else {
                Errormzg.displayerrorMessage("unable to paid credit");
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

        return 1;
    }

}
