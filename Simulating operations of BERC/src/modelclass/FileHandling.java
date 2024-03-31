/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class FileHandling implements Serializable{

    private static String file_name;
    




public static boolean CreateFile(String id, String summary, String message, String file_name)throws FileNotFoundException, IOException{
       
        LeaveRequest newfile =new LeaveRequest(
                    
               id, 
               summary, 
               message 
            );
   File f = new File(file_name);

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

    oos.writeObject(newfile);
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

    }    

    private static class file_name {

        public file_name() {
        }
    }
    
    
}
