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
public class GiveInfo implements Serializable {
    private String department;
    private LocalDate sd;
    private String text;

    public GiveInfo(String department, LocalDate sd, String text) {
        this.department = department;
        this.sd = sd;
        this.text = text;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getSd() {
        return sd;
    }

    public void setSd(LocalDate sd) {
        this.sd = sd;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "GiveInfo{" + "department=" + department + ", sd=" + sd + ", text=" + text + '}';
    }
    
}
