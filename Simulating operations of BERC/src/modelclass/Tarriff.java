/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelclass;

import java.time.LocalDate;

/**
 *
 * @author Reaper
 */
<<<<<<< Updated upstream:Simulating operations of BERC/src/modelclass/Tarriff_officer.java
public class Tarriff_officer {
    
        Float  amountinvested,profit,tarriff_percentage;
         LocalDate         startpicker;
       LocalDate      endpicker;
           String     deptcombo;
=======
public class Tarriff extends User implements Serializable {
       private String     deptcombo;
       private int  amountinvested,profit;
       private float tarriff_percentage;
        
        private LocalDate         startpicker;
        private    LocalDate      endpicker;
           
       private float tarriff;
>>>>>>> Stashed changes:Simulating operations of BERC/src/modelclass/Tarriff.java

    public Tarriff_officer(Float amountinvested, Float profit, Float tarriff_percentage, LocalDate startpicker, LocalDate endpicker, String deptcombo) {
        this.amountinvested = amountinvested;
        this.profit = profit;
        this.tarriff_percentage = tarriff_percentage;
        this.startpicker = startpicker;
        this.endpicker = endpicker;
        this.deptcombo = deptcombo;
    }

    public Float getAmountinvested() {
        return amountinvested;
    }

    public void setAmountinvested(Float amountinvested) {
        this.amountinvested = amountinvested;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
    }

    public Float getTarriff_percentage() {
        return tarriff_percentage;
    }

    public void setTarriff_percentage(Float tarriff_percentage) {
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
