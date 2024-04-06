/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelclass;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Reaper
 */
public class Tarriffofficer extends User implements Serializable{
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



    
    
    
      
    }   
       