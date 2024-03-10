/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private void savebtn(ActionEvent event) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f = new File("Tarriff.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            Tarriff_officer e = new Tarriff_officer(
                Float.parseFloat(amountinvested.getText()),
                Float.parseFloat(profit.getText()),
                Float.parseFloat(tarriff_percentage.getText()),
             startpicker.getValue(),
                endpicker.getValue(),
                deptcombo.getValue()

            );
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
    


}

    
        
    



  
    

