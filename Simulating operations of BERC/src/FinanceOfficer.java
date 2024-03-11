
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class FinanceOfficer {
    
    public static boolean givenSalary(String salary, String bonusAmount, String employeeid, LocalDate sd) throws FileNotFoundException, IOException{
     
       
        Salary newSalary =new Salary(
                    
             salary,
             bonusAmount, 
             employeeid,
             sd
                
           
            );
   File f = new File("employeesalary.bin");

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

    oos.writeObject( newSalary);
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

    }
     
    
}
