/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m;

import java.util.List;

/**
 *
 * @author Me
 */
public class Delivery {

    public pojo.Delivery getBy(int id) {
        return null;
    }

    public List<pojo.Delivery> getBy(pojo.RouteReg routeReg) {
        return null;
    }

    public List<pojo.Delivery> getBy(pojo.Vehicle vehicle) {
        return null;
    }

    public List<pojo.Delivery> getBy(pojo.Employee employee) {
        return null;
    }

    public List<pojo.Delivery> getByPartner(pojo.Employee employee) {
        return null;
    }
/**
 * 
 * @param delivery
 * @return return a String object, values as "done", "not", "error"
 */
    public String save(pojo.Delivery delivery) {
        return "not";
    }
    /**
     * 
     * @param delivery
     * @return return a String object, values as "done", "not", "error"
     */
    public String update(pojo.Delivery delivery){
    return "not";}

}
