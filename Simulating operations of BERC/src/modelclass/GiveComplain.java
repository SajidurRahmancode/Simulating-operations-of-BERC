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
public class GiveComplain implements Serializable {
    private String sectortype;
    private LocalDate sd;
    private String nid;
    private String complain;

    public GiveComplain(String sectortype, LocalDate sd, String nid, String complain) {
        this.sectortype = sectortype;
        this.sd = sd;
        this.nid = nid;
        this.complain = complain;
    }

    public String getSectortype() {
        return sectortype;
    }

    public void setSectortype(String sectortype) {
        this.sectortype = sectortype;
    }

    public LocalDate getSd() {
        return sd;
    }

    public void setSd(LocalDate sd) {
        this.sd = sd;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getComplain() {
        return complain;
    }

    public void setComplain(String complain) {
        this.complain = complain;
    }

    @Override
    public String toString() {
        return "GiveComplain{" + "sectortype=" + sectortype + ", sd=" + sd + ", nid=" + nid + ", complain=" + complain + '}';
    }
    
      
    
}
