package modelclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LandBuyer extends User implements Serializable{
        
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

    
    public static boolean landbuyergetinfo(String name, String gender, String age, String nid, String phone, String address)throws FileNotFoundException, IOException{

            Landbuyerinformation landbuyerinfo =new Landbuyerinformation(

                      name,gender,age,nid,phone,address
                    );
       File f = new File("Landbuyerinfo.bin");

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

        oos.writeObject(landbuyerinfo);
        oos.close();
        fos.close();

        return true;
    } catch (IOException e) {
        return false;
    }

     }
    
    
    
   public static boolean casefiler(String Name, String Summary)throws FileNotFoundException, IOException{
                String submittedby= "Land Buyer";

                Case casefill =new Case(
                        Name,
                        Summary,
                        submittedby );
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


    
    
    
