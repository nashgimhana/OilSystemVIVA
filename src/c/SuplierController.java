/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.Date;
import m.Supplier;
import m.Vehicle;
import pojo.Product;
import pojo.SupplierCredit;

/**
 *
 * @author nadee
 */
public class SuplierController {

    Errormzg er;
    pojo.Supplier m;
    Supplier sm;
    TextAutoCompleter autoCompleter;

    public int savecontroller(int id, String name, String adress1, String adress2, String adress3, String contact1, String contact2, String contact3, String details, double crntcredit) {
        er = new Errormzg();
        m = new pojo.Supplier();
        sm = new Supplier();
        System.out.println(id);
        try {
            if (id == 0) {
                if (!name.trim().equals("")) {
                    m.setName(name);
                    if (!adress1.trim().equals("")) {
                        m.setAdressLine1(adress1);
                        if (!adress2.trim().equals("")) {
                            m.setAdressLine2(adress2);
                            if (!contact1.trim().equals("")) {
                                m.setContact1(contact1);
                                if (!contact1.trim().equals("")) {
                                    m.setContact1(contact1);
                                    if (!contact2.trim().equals("")) {
                                        m.setContact2(contact2);
                                        m.setAdressLine3(adress3);
                                        m.setContact3(contact3);
                                        m.setDetails(details);
                                        crntcredit = Math.round(crntcredit * 100.0) / 100.0;
//                                        System.out.println(crntcredit + "   dan dapu eka yakoo");
                                        m.setCurrentCredit(crntcredit);
                                        m.setStatus(1);
                                        int done = sm.save(m);
                                        pojo.Supplier sup = new m.Supplier().getBy(done);
                                        if (crntcredit != 0) {

                                            pojo.SupplierCredit supcr = new SupplierCredit();
                                            supcr.setSupplier(sup);
                                            supcr.setDate(new Date());
                                            supcr.setAmount(crntcredit);

                                            int savecredit = new m.SupplierCredit().save(supcr);
                                            return savecredit;
                                        } else {
                                            return 1;
                                        }

                                    } else {
                                        er.displayerrorMessage("Please Enter contact");
                                    }
                                } else {
                                    er.displayerrorMessage("Please Enter contact");
                                }
                            } else {
                                er.displayerrorMessage("Please Enter contact");
                            }
                        } else {
                            er.displayerrorMessage("Please Enter Address field 2");
                        }
                    } else {
                        er.displayerrorMessage("Please Enter Address field 1");
                    }
                } else {
                    er.displayerrorMessage("Please Enter Name");
                }
            } else {

                if (!name.trim().equals("")) {
                    m.setId(id);
                    m.setName(name);
                    if (!adress1.trim().equals("")) {
                        m.setAdressLine1(adress1);
                        if (!adress2.trim().equals("")) {
                            m.setAdressLine2(adress2);
                            if (!contact1.trim().equals("")) {
                                m.setContact1(contact1);
                                if (!contact1.trim().equals("")) {
                                    m.setContact1(contact1);
                                    if (!contact2.trim().equals("")) {
                                        m.setContact2(contact2);
                                        m.setAdressLine3(adress3);
                                        m.setContact3(contact3);
                                        m.setDetails(details);
                                        if (crntcredit != 0) {
                                            crntcredit = Math.round(crntcredit * 100.0) / 100.0;
//                                            System.out.println(crntcredit + "   dan dapu eka yakoo update");

                                            pojo.Supplier sup = new m.Supplier().getBy(id);
                                            m.setCurrentCredit(sup.getCurrentCredit() + crntcredit);

                                            m.setStatus(1);
                                            sm.update(m);

                                            pojo.SupplierCredit supc = new SupplierCredit();
                                            supc.setSupplier(sup);
                                            supc.setDate(new Date());
                                            supc.setAmount(crntcredit);
                                            int savecredit = new m.SupplierCredit().save(supc);
                                            return savecredit;
                                        } else {
                                            return 1;
                                        }

                                    } else {
                                        er.displayerrorMessage("Please Enter contact");
                                    }
                                } else {
                                    er.displayerrorMessage("Please Enter contact");
                                }
                            } else {
                                er.displayerrorMessage("Please Enter contact");
                            }
                        } else {
                            er.displayerrorMessage("Please Enter Address field 2");
                        }
                    } else {
                        er.displayerrorMessage("Please Enter Address field 1");
                    }
                } else {
                    er.displayerrorMessage("Please Enter Name");
                }
            }

        } catch (Exception ex) {

            er.displayerrorMessage(ex.toString());
            ex.printStackTrace();
            return 0;

        }
        return 1;
    }

    //stock
    public pojo.Supplier findSupIdByName(String supname) {
        pojo.Supplier bysupName = null;
        try {
            sm = new Supplier();
            bysupName = sm.getByName(supname);
            return bysupName;
//            System.out.println(bysupName.getName());
        } catch (Exception e) {
            Errormzg.displayerrorMessage(e.toString());
            e.printStackTrace();
            return null;
        }

    }

}
