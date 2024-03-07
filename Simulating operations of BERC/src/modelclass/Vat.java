/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelclass;

/**
 *
 * @author Reaper
 */
public class Vat {
    Integer totalcost,department,calculated_vat;

    public Vat(Integer totalcost, Integer department, Integer calculated_vat) {
        this.totalcost = totalcost;
        this.department = department;
        this.calculated_vat = calculated_vat;
    }

    public Integer getTotalcost() {
        return totalcost;
    }

    public void setTotalcost(Integer totalcost) {
        this.totalcost = totalcost;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getCalculated_vat() {
        return calculated_vat;
    }

    public void setCalculated_vat(Integer calculated_vat) {
        this.calculated_vat = calculated_vat;
    }

    @Override
    public String toString() {
        return "Vat{" + "totalcost=" + totalcost + ", department=" + department + ", calculated_vat=" + calculated_vat + '}';
    }
    
    
}
