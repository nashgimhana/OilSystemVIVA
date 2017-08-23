package pojo;
// Generated Aug 2, 2017 11:22:50 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BankDeals generated by hbm2java
 */
public class BankDeals  implements java.io.Serializable {


     private Integer id;
     private Bank bank;
     private Double amount;
     private String description;
     private Date date;
     private Set dealCheques = new HashSet(0);

    public BankDeals() {
    }

	
    public BankDeals(Bank bank) {
        this.bank = bank;
    }
    public BankDeals(Bank bank, Double amount, String description, Date date, Set dealCheques) {
       this.bank = bank;
       this.amount = amount;
       this.description = description;
       this.date = date;
       this.dealCheques = dealCheques;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Bank getBank() {
        return this.bank;
    }
    
    public void setBank(Bank bank) {
        this.bank = bank;
    }
    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public Set getDealCheques() {
        return this.dealCheques;
    }
    
    public void setDealCheques(Set dealCheques) {
        this.dealCheques = dealCheques;
    }




}


