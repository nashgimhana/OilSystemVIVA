package pojo;
// Generated Aug 2, 2017 11:22:50 AM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * BasicSalery generated by hbm2java
 */
public class BasicSalery  implements java.io.Serializable {


     private Integer id;
     private Employee employee;
     private Double basicSalery;
     private Double bonus;
     private Double perDay;
     private Double perOtHoure;
     private Double houres;
     private Double mainusDebit;
     private Double total;
     private Double pay;
     private Date updateday;
     private Integer status;
     private String basicSalerycol;
     private Set salaries = new HashSet(0);

    public BasicSalery() {
    }

	
    public BasicSalery(Employee employee) {
        this.employee = employee;
    }
    public BasicSalery(Employee employee, Double basicSalery, Double bonus, Double perDay, Double perOtHoure, Double houres, Double mainusDebit, Double total, Double pay, Date updateday, Integer status, String basicSalerycol, Set salaries) {
       this.employee = employee;
       this.basicSalery = basicSalery;
       this.bonus = bonus;
       this.perDay = perDay;
       this.perOtHoure = perOtHoure;
       this.houres = houres;
       this.mainusDebit = mainusDebit;
       this.total = total;
       this.pay = pay;
       this.updateday = updateday;
       this.status = status;
       this.basicSalerycol = basicSalerycol;
       this.salaries = salaries;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Double getBasicSalery() {
        return this.basicSalery;
    }
    
    public void setBasicSalery(Double basicSalery) {
        this.basicSalery = basicSalery;
    }
    public Double getBonus() {
        return this.bonus;
    }
    
    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }
    public Double getPerDay() {
        return this.perDay;
    }
    
    public void setPerDay(Double perDay) {
        this.perDay = perDay;
    }
    public Double getPerOtHoure() {
        return this.perOtHoure;
    }
    
    public void setPerOtHoure(Double perOtHoure) {
        this.perOtHoure = perOtHoure;
    }
    public Double getHoures() {
        return this.houres;
    }
    
    public void setHoures(Double houres) {
        this.houres = houres;
    }
    public Double getMainusDebit() {
        return this.mainusDebit;
    }
    
    public void setMainusDebit(Double mainusDebit) {
        this.mainusDebit = mainusDebit;
    }
    public Double getTotal() {
        return this.total;
    }
    
    public void setTotal(Double total) {
        this.total = total;
    }
    public Double getPay() {
        return this.pay;
    }
    
    public void setPay(Double pay) {
        this.pay = pay;
    }
    public Date getUpdateday() {
        return this.updateday;
    }
    
    public void setUpdateday(Date updateday) {
        this.updateday = updateday;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getBasicSalerycol() {
        return this.basicSalerycol;
    }
    
    public void setBasicSalerycol(String basicSalerycol) {
        this.basicSalerycol = basicSalerycol;
    }
    public Set getSalaries() {
        return this.salaries;
    }
    
    public void setSalaries(Set salaries) {
        this.salaries = salaries;
    }




}


