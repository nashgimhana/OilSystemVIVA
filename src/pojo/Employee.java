package pojo;
// Generated Aug 2, 2017 11:22:50 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Employee generated by hbm2java
 */
public class Employee  implements java.io.Serializable {


     private Integer id;
     private EmpType empType;
     private String fname;
     private String mname;
     private String lname;
     private String sname;
     private String nic;
     private String gender;
     private String adressLine1;
     private String adressLine2;
     private String phone1;
     private String phone2;
     private Double currentCredit;
     private Integer status;
     private Set deliveriesForPartner2 = new HashSet(0);
     private Set logins = new HashSet(0);
     private Set basicSaleries = new HashSet(0);
     private Set deliveriesForPartner1 = new HashSet(0);
     private Set deliveriesForDriver = new HashSet(0);
     private Set attenenceLogs = new HashSet(0);
     private Set empCredits = new HashSet(0);
     private Set salaries = new HashSet(0);

    public Employee() {
    }

	
    public Employee(EmpType empType) {
        this.empType = empType;
    }
    public Employee(EmpType empType, String fname, String mname, String lname, String sname, String nic, String gender, String adressLine1, String adressLine2, String phone1, String phone2, Double currentCredit, Integer status, Set deliveriesForPartner2, Set logins, Set basicSaleries, Set deliveriesForPartner1, Set deliveriesForDriver, Set attenenceLogs, Set empCredits, Set salaries) {
       this.empType = empType;
       this.fname = fname;
       this.mname = mname;
       this.lname = lname;
       this.sname = sname;
       this.nic = nic;
       this.gender = gender;
       this.adressLine1 = adressLine1;
       this.adressLine2 = adressLine2;
       this.phone1 = phone1;
       this.phone2 = phone2;
       this.currentCredit = currentCredit;
       this.status = status;
       this.deliveriesForPartner2 = deliveriesForPartner2;
       this.logins = logins;
       this.basicSaleries = basicSaleries;
       this.deliveriesForPartner1 = deliveriesForPartner1;
       this.deliveriesForDriver = deliveriesForDriver;
       this.attenenceLogs = attenenceLogs;
       this.empCredits = empCredits;
       this.salaries = salaries;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public EmpType getEmpType() {
        return this.empType;
    }
    
    public void setEmpType(EmpType empType) {
        this.empType = empType;
    }
    public String getFname() {
        return this.fname;
    }
    
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getMname() {
        return this.mname;
    }
    
    public void setMname(String mname) {
        this.mname = mname;
    }
    public String getLname() {
        return this.lname;
    }
    
    public void setLname(String lname) {
        this.lname = lname;
    }
    public String getSname() {
        return this.sname;
    }
    
    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getNic() {
        return this.nic;
    }
    
    public void setNic(String nic) {
        this.nic = nic;
    }
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAdressLine1() {
        return this.adressLine1;
    }
    
    public void setAdressLine1(String adressLine1) {
        this.adressLine1 = adressLine1;
    }
    public String getAdressLine2() {
        return this.adressLine2;
    }
    
    public void setAdressLine2(String adressLine2) {
        this.adressLine2 = adressLine2;
    }
    public String getPhone1() {
        return this.phone1;
    }
    
    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
    public String getPhone2() {
        return this.phone2;
    }
    
    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
    public Double getCurrentCredit() {
        return this.currentCredit;
    }
    
    public void setCurrentCredit(Double currentCredit) {
        this.currentCredit = currentCredit;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Set getDeliveriesForPartner2() {
        return this.deliveriesForPartner2;
    }
    
    public void setDeliveriesForPartner2(Set deliveriesForPartner2) {
        this.deliveriesForPartner2 = deliveriesForPartner2;
    }
    public Set getLogins() {
        return this.logins;
    }
    
    public void setLogins(Set logins) {
        this.logins = logins;
    }
    public Set getBasicSaleries() {
        return this.basicSaleries;
    }
    
    public void setBasicSaleries(Set basicSaleries) {
        this.basicSaleries = basicSaleries;
    }
    public Set getDeliveriesForPartner1() {
        return this.deliveriesForPartner1;
    }
    
    public void setDeliveriesForPartner1(Set deliveriesForPartner1) {
        this.deliveriesForPartner1 = deliveriesForPartner1;
    }
    public Set getDeliveriesForDriver() {
        return this.deliveriesForDriver;
    }
    
    public void setDeliveriesForDriver(Set deliveriesForDriver) {
        this.deliveriesForDriver = deliveriesForDriver;
    }
    public Set getAttenenceLogs() {
        return this.attenenceLogs;
    }
    
    public void setAttenenceLogs(Set attenenceLogs) {
        this.attenenceLogs = attenenceLogs;
    }
    public Set getEmpCredits() {
        return this.empCredits;
    }
    
    public void setEmpCredits(Set empCredits) {
        this.empCredits = empCredits;
    }
    public Set getSalaries() {
        return this.salaries;
    }
    
    public void setSalaries(Set salaries) {
        this.salaries = salaries;
    }




}


