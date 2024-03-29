/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelclass.Tarriff_officer;


/**
 * FXML Controller class
 *
 * @author Reaper
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


/**
 * FXML Controller class
 *
 * @author Reaper
 */
public class Tarriff_officer_calculate_tarriffController implements Initializable {

    @FXML
    private TextField amountinvested;
    @FXML
    private TextField profit;
    @FXML
    private TextField tarriff_percentage;
    @FXML
    private DatePicker endpicker;
    @FXML
    private ComboBox<String> deptcombo;
    @FXML
    private TextArea detailedarea;
    @FXML
    private DatePicker startpicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    deptcombo.getItems().addAll("Electrical","Water","Gas");
    
        // TODO
    
    }

    @FXML
    private void savebtn(ActionEvent event) throws IOException {
         File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("tarriffcalc.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Tarriff_officer e = new Tarriff_officer(
                Integer.parseInt(amountinvested.getText()),
                Integer.parseInt(profit.getText()),
                Float.parseFloat(tarriff_percentage.getText()),
                startpicker.getValue(),
                endpicker.getValue(),
                deptcombo.getValue());
            oos.writeObject(e);

        } catch (IOException ex) {
            Logger.getLogger(Tarriff_officer_calculate_tarriffController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(Tarriff_officer_calculate_tarriffController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    
    }

    @FXML
    private void loader(ActionEvent event) {
        
        
        detailedarea.setText("");
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("tarriffcalc.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Tarriff_officer emp;
            try{
                detailedarea.setText("");
                while(true){
                    System.out.println("Printing objects.");
                    emp = (Tarriff_officer)ois.readObject();
                    //Object obj = ois.readObject();
                    //obj.submitReport();
                    System.out.println(emp.toString());
                    detailedarea.appendText(emp.toString());
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            detailedarea.appendText("All objects are loaded successfully...\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }           
        
    }
    


}

    
        
    



  
    

