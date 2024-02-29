/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelclass;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 * @author sajid
 */
public class Lawyer extends User implements Serializable{
    
    public static boolean setMeeting(String meetingLocation, String meetingLink, String meetingType, String meetingTime, String setby, LocalDate meetingDate)throws FileNotFoundException, IOException{
       
        SetMeeting newMeeting =new SetMeeting(
                    
               meetingLocation, 
               meetingLink, 
                meetingType, 
                meetingTime, 
                setby,
                meetingDate
                 
        );
   File f = new File("meeting.bin");

try {
    FileOutputStream fos;
    ObjectOutputStream oos;

    if (f.exists()) {
        fos = new FileOutputStream(f, true); 
        oos = new AppendableObjectOutputStream(fos);
    } else {
        fos = new FileOutputStream(f);
        oos = new ObjectOutputStream(fos);
    }

    oos.writeObject(newMeeting);
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

    }
public static boolean setMeetingg(String meetingLocation, String meetingType, String meetingTime, String setby, LocalDate meetingDate)throws FileNotFoundException, IOException{
       
        SetMeeting newMeeting =new SetMeeting(
                    
               meetingLocation, 
                
                meetingType, 
                meetingTime,
                setby,
                meetingDate
                
        );
   File f = new File("meeting.bin");

try {
    FileOutputStream fos;
    ObjectOutputStream oos;

    if (f.exists()) {
        fos = new FileOutputStream(f, true); // Append mode
        oos = new AppendableObjectOutputStream(fos);
    } else {
        fos = new FileOutputStream(f);
        oos = new ObjectOutputStream(fos);
    }

    oos.writeObject(newMeeting);
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

    }
public static boolean leaverequestsender(String id, String summary, String body)throws FileNotFoundException, IOException{
       
        LeaveRequest leaverequ =new LeaveRequest(
                     
                id,
                summary,
                body 
                );
   File f = new File("LeaveRequests.bin");

try {
    FileOutputStream fos;
    ObjectOutputStream oos;

    if (f.exists()) {
        fos = new FileOutputStream(f, true); // Append mode
        oos = new AppendableObjectOutputStream(fos);
    } else {
        fos = new FileOutputStream(f);
        oos = new ObjectOutputStream(fos);
    }

    oos.writeObject(leaverequ);
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

 }

public static boolean complainfiler(String id, String summary, String body)throws FileNotFoundException, IOException{
       
        Complain leaverequ =new Complain(
                     
                id,
                summary,
                body);
   File f = new File("Complain.bin");

try {
    FileOutputStream fos;
    ObjectOutputStream oos;

    if (f.exists()) {
        fos = new FileOutputStream(f, true); // Append mode
        oos = new AppendableObjectOutputStream(fos);
    } else {
        fos = new FileOutputStream(f);
        oos = new ObjectOutputStream(fos);
    }

    oos.writeObject(leaverequ);
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

 }


public static boolean casefiler(String Name, String Summary)throws FileNotFoundException, IOException{
                String submittedby= "Lawyer";
                Case casefill =new Case(
                        Name,
                        Summary,
                        submittedby);
                        File f = new File("Case.bin");

        try {
            FileOutputStream fos;
            ObjectOutputStream oos;

            if (f.exists()) {
                fos = new FileOutputStream(f, true); // Append mode
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            oos.writeObject(casefill);
            oos.close();
            fos.close();

            return true;
        } catch (IOException e) {
            return false;
        }

 }

public static ObservableList<Case> Showcases(){ 
        ObservableList<Case> caseList = FXCollections.observableArrayList();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Case.bin"))){
            while(true){
                try{
                    Case cas = (Case)ois.readObject();
                    caseList.add(cas);
                }catch(EOFException e){
                    break;
                }catch(ClassNotFoundException e){
                   System.err.println("Class not Found");
                }
            }
        }catch(FileNotFoundException e){
                    System.err.println("File not Found");
        }catch(IOException e){
                    System.err.println("IO exception" + e.getMessage());
        }
        
        return caseList;
    }

    
    
    
      
    }   
       
       
    
    

