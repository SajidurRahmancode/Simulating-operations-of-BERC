/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelclass;

import java.io.Serializable;

/**
 * @author sajid
 */
public class Case implements Serializable{
    private String Name;
    private String Summary;
    private String submittedby;

    public Case(String Name, String Summary, String submittedby) {
        this.Name = Name;
        this.Summary = Summary;
        this.submittedby = submittedby;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String Summary) {
        this.Summary = Summary;
    }

    public String getSubmittedby() {
        return submittedby;
    }

    public void setSubmittedby(String submittedby) {
        this.submittedby = submittedby;
    }

    @Override
    public String toString() {
        return "Case{" + "Name=" + Name + ", Summary=" + Summary + ", submittedby=" + submittedby + '}';
    }
    
    
}
