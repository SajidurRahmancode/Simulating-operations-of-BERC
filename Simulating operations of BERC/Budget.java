/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelclass;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Budget implements Serializable{
    private String department;
    private String budget;
    private String income;
    private String expense;
    private LocalDate sd;

    public Budget(String department, String budget, String income, String expense, LocalDate sd) {
        this.department = department;
        this.budget = budget;
        this.income = income;
        this.expense = expense;
        this.sd = sd;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public LocalDate getSd() {
        return sd;
    }

    public void setSd(LocalDate sd) {
        this.sd = sd;
    }

    @Override
    public String toString() {
        return "Budget{" + "department=" + department + ", budget=" + budget + ", income=" + income + ", expense=" + expense + ", sd=" + sd + '}';
    }
   
    
    
}
