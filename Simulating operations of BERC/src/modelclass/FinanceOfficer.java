
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
import modelclass.Budget;
import modelclass.EmployeeSalary;
import modelclass.GiveInfo;
import modelclass.Member;
import modelclass.User;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class FinanceOfficer extends User implements Serializable{
    
     public static boolean givebudget(String department, String budget, String income,String expense, LocalDate sd) throws FileNotFoundException, IOException{
       
        Budget newBudget =new Budget(
                    
               department, 
               budget, 
                income,       
                 expense, 
                   sd
        
        );
   File f = new File("budget.bin");

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

    oos.writeObject(newBudget);
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

    }
    
    public static boolean givenSalary(String salary, String bonusAmount, String employeeid, LocalDate sd) throws FileNotFoundException, IOException{
     
       
        EmployeeSalary newemployeesalary =new EmployeeSalary(
                    
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

    oos.writeObject( newemployeesalary);
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

    }
    public static ObservableList<Budget> ShowBudget(){ 
        //ArrayList<Member> memList = new ArrayList();
        ObservableList<Budget> budgetList = FXCollections.observableArrayList();
        //ObservableList<Member> allPeople = FXCollections.observableArrayList();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("budget.bin"))){
            while(true){
                try{
                    Budget budg = (Budget)ois.readObject();
                    budgetList.add(budg);
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
        
        return budgetList;
    }
 
 

 public static ObservableList<EmployeeSalary> Salaryinfo(){ 
        //ArrayList<Member> memList = new ArrayList();
        ObservableList<EmployeeSalary> salaryList = FXCollections.observableArrayList();
        //ObservableList<Member> allPeople = FXCollections.observableArrayList();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employeesalary.bin"))){
            while(true){
                try{
                    EmployeeSalary salary = (EmployeeSalary)ois.readObject();
                    salaryList.add(salary);
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
        
        return salaryList;
    }
   public static boolean giveinfo(String department, LocalDate sd, String text) throws FileNotFoundException, IOException{
       
        GiveInfo newGiveInfo =new GiveInfo(
             
             department,
             sd,
              text

            );
   File f = new File("info.bin");

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

    oos.writeObject( newGiveInfo );
    oos.close();
    fos.close();
    
    return true;
} catch (IOException e) {
    return false;
}

    }
 
}
    
