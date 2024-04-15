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
public class Profile implements Serializable{
    private String fname;
    private String lname;
    private String nid;
    private String presentadd;
    private String permanentadd;
    private LocalDate dob;

    public Profile(String fname, String lname, String nid, String presentadd, String permanentadd, LocalDate dob) {
        this.fname = fname;
        this.lname = lname;
        this.nid = nid;
        this.presentadd = presentadd;
        this.permanentadd = permanentadd;
        this.dob = dob;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getPresentadd() {
        return presentadd;
    }

    public void setPresentadd(String presentadd) {
        this.presentadd = presentadd;
    }

    public String getPermanentadd() {
        return permanentadd;
    }

    public void setPermanentadd(String permanentadd) {
        this.permanentadd = permanentadd;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Profile{" + "fname=" + fname + ", lname=" + lname + ", nid=" + nid + ", presentadd=" + presentadd + ", permanentadd=" + permanentadd + ", dob=" + dob + '}';
    }
    
}
