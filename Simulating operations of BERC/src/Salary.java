
import java.io.Serializable;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Salary implements Serializable
{
    
    private String salary, bonusAmount;    
    private String employeeid;
    private LocalDate sd;

    public Salary(String salary, String bonusAmount, String employeeid, LocalDate sd) {
        this.salary = salary;
        this.bonusAmount = bonusAmount;
        this.employeeid = employeeid;
        this.sd = sd;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getBonusAmount() {
        return bonusAmount;
    }

    public void setBonusAmount(String bonusAmount) {
        this.bonusAmount = bonusAmount;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public LocalDate getSd() {
        return sd;
    }

    public void setSd(LocalDate sd) {
        this.sd = sd;
    }

    @Override
    public String toString() {
        return "Salary{" + "salary=" + salary + ", bonusAmount=" + bonusAmount + ", employeeid=" + employeeid + ", sd=" + sd + '}';
    }

}
