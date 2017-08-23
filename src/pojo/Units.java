package pojo;
// Generated Aug 2, 2017 11:22:50 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Units generated by hbm2java
 */
public class Units  implements java.io.Serializable {


     private Integer id;
     private String unitName;
     private Set deliveryItemLogs = new HashSet(0);
     private Set products = new HashSet(0);

    public Units() {
    }

    public Units(String unitName, Set deliveryItemLogs, Set products) {
       this.unitName = unitName;
       this.deliveryItemLogs = deliveryItemLogs;
       this.products = products;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUnitName() {
        return this.unitName;
    }
    
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
    public Set getDeliveryItemLogs() {
        return this.deliveryItemLogs;
    }
    
    public void setDeliveryItemLogs(Set deliveryItemLogs) {
        this.deliveryItemLogs = deliveryItemLogs;
    }
    public Set getProducts() {
        return this.products;
    }
    
    public void setProducts(Set products) {
        this.products = products;
    }




}


