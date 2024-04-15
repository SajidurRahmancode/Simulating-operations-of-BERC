/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelclass;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Reaper
 */
public class Tarriff {
    String     deptcombo;
        Float  amountinvested,profit;
                           Float tarriff_percentage;

         LocalDate         startpicker;
       LocalDate      endpicker;
       Float tarriff;

    public Tarriff(String deptcombo, Float amountinvested, Float profit, Float tarriff_percentage, LocalDate startpicker, LocalDate endpicker, Float tarriff) {
        this.deptcombo = deptcombo;
        this.amountinvested = amountinvested;
        this.profit = profit;
        this.tarriff_percentage = tarriff_percentage;
        this.startpicker = startpicker;
        this.endpicker = endpicker;
        this.tarriff = tarriff;
    }

    public String getDeptcombo() {
        return deptcombo;
    }

    public void setDeptcombo(String deptcombo) {
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

    public Float getTarriff() {
        return tarriff;
    }

    public void setTarriff(Float tarriff) {
        this.tarriff = tarriff;
    }

    @Override
    public String toString() {
        return "Tarriff{" + "deptcombo=" + deptcombo + ", amountinvested=" + amountinvested + ", profit=" + profit + ", tarriff_percentage=" + tarriff_percentage + ", startpicker=" + startpicker + ", endpicker=" + endpicker + ", tarriff=" + tarriff + '}';
    }

    
    public static float calctarriff(float tarriff_percentage, int amountinvested, int profit) {
        float tariffAmount = (tarriff_percentage / 100) * profit;
        return tariffAmount;


     }
}
