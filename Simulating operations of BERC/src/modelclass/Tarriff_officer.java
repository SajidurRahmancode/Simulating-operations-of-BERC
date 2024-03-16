/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelclass;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Reaper
 */
public class Tarriff_officer extends User implements Serializable {
    
        int  amountinvested,profit;
        float tarriff_percentage;
        
         LocalDate         startpicker;
            LocalDate      endpicker;
           String     deptcombo;

    public Tarriff_officer(int amountinvested, int profit, float tarriff_percentage, LocalDate startpicker, LocalDate endpicker, String deptcombo) {
        this.amountinvested = amountinvested;
        this.profit = profit;
        this.tarriff_percentage = tarriff_percentage;
        this.startpicker = startpicker;
        this.endpicker = endpicker;
        this.deptcombo = deptcombo;
    }

    public int getAmountinvested() {
        return amountinvested;
    }

    public void setAmountinvested(int amountinvested) {
        this.amountinvested = amountinvested;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public float getTarriff_percentage() {
        return tarriff_percentage;
    }

    public void setTarriff_percentage(float tarriff_percentage) {
        this.tarriff_percentage = tarriff_percentage;
    }

    public LocalDate getStartpicker() {
        return startpicker;
    }

    public void setStartpicker(LocalDate startpicker) {
        this.startpicker = startpicker;
    }

    public LocalDate getEndpicker() {
        return endpicker;
    }

    public void setEndpicker(LocalDate endpicker) {
        this.endpicker = endpicker;
    }

    public String getDeptcombo() {
        return deptcombo;
    }

    public void setDeptcombo(String deptcombo) {
        this.deptcombo = deptcombo;
    }

    @Override
    public String toString() {
        return "Tarriff_officer{" + "amountinvested=" + amountinvested + ", profit=" + profit + ", tarriff_percentage=" + tarriff_percentage + ", startpicker=" + startpicker + ", endpicker=" + endpicker + ", deptcombo=" + deptcombo + '}';
    }


    
    
}
