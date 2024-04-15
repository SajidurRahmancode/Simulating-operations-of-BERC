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
 * @author User
 */
public class Consumer extends User implements Serializable{
    
     public static boolean createpro(String fname, String lname, String nid,String presentadd,String permanentadd,LocalDate dob) throws FileNotFoundException, IOException{
       
        Profile newProfile =new Profile(
                    
               fname, 
               lname, 
                nid,       
                 presentadd, 
                   permanentadd,
                 dob
        
        );
   File f = new File("profile.bin");

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

    oos.writeObject(newProfile);
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

    }
     public static ObservableList<Profile> profileinfo(){ 
        //ArrayList<Member> memList = new ArrayList();
        ObservableList<Profile> profileList = FXCollections.observableArrayList();
        //ObservableList<Member> allPeople = FXCollections.observableArrayList();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("profile.bin"))){
            while(true){
                try{
                    Profile pro = (Profile)ois.readObject();
                    profileList.add(pro);
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
        
        return profileList;
    }
     
      public static boolean givecomplain(String sectortype, LocalDate sd, String nid,String complain) throws FileNotFoundException, IOException{
       
        GiveComplain newGiveComplain =new GiveComplain(
             
             sectortype,
             sd,
              nid,
               complain 

            );
   File f = new File("complain.bin");

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

    oos.writeObject( newGiveComplain );
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

    }
        
    public static boolean meetingset(String meetingLocation, String meetingLink, String meetingType, String meetingTime, String setby, LocalDate meetingDate)throws FileNotFoundException, IOException{
       
        SetMeeting newMeeting =new SetMeeting(
                    
               meetingLocation, 
               meetingLink, 
                meetingType, 
                meetingTime, 
                setby,
                meetingDate
                 
        );
   File f = new File("meetingset.bin");

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
    public static ObservableList<SetMeeting> meetinfo(){ 
        //ArrayList<Member> memList = new ArrayList();
        ObservableList<SetMeeting> meetList = FXCollections.observableArrayList();
        //ObservableList<Member> allPeople = FXCollections.observableArrayList();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("meetingset.bin"))){
            while(true){
                try{
                    SetMeeting meet = (SetMeeting)ois.readObject();
                    meetList.add(meet);
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
        
        return meetList;
    }
    
      public static boolean service(String info) throws FileNotFoundException, IOException{
       
        Service newService =new Service(
             
             info
             

            );
   File f = new File("service.bin");

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

    oos.writeObject( newService );
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

    }
 
}
    

      
      
      
 

    

 
 
    
    

