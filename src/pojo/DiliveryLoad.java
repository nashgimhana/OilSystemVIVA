package pojo;
// Generated Aug 2, 2017 11:22:50 AM by Hibernate Tools 4.3.1



/**
 * DiliveryLoad generated by hbm2java
 */
public class DiliveryLoad  implements java.io.Serializable {


     private int id;
     private Delivery delivery;
     private Product product;
     private Double loadqty;
     private Double crntPrice;
     private Double returnqty;

    public DiliveryLoad() {
    }

	
    public DiliveryLoad(int id, Delivery delivery, Product product) {
        this.id = id;
        this.delivery = delivery;
        this.product = product;
    }
    public DiliveryLoad(int id, Delivery delivery, Product product, Double loadqty, Double crntPrice, Double returnqty) {
       this.id = id;
       this.delivery = delivery;
       this.product = product;
       this.loadqty = loadqty;
       this.crntPrice = crntPrice;
       this.returnqty = returnqty;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Delivery getDelivery() {
        return this.delivery;
    }
    
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
    public Product getProduct() {
        return this.product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    public Double getLoadqty() {
        return this.loadqty;
    }
    
    public void setLoadqty(Double loadqty) {
        this.loadqty = loadqty;
    }
    public Double getCrntPrice() {
        return this.crntPrice;
    }
    
    public void setCrntPrice(Double crntPrice) {
        this.crntPrice = crntPrice;
    }
    public Double getReturnqty() {
        return this.returnqty;
    }
    
    public void setReturnqty(Double returnqty) {
        this.returnqty = returnqty;
    }




}


