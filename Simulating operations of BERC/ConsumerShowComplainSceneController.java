/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import modelclass.GiveComplain;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsumerShowComplainSceneController implements Initializable {

    @FXML
    private TextArea textarea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textarea.setText(" ");   
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        
        try {
            f = new File("complain.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            GiveComplain g;
            try{
                
                while(true){
                    g = (GiveComplain)ois.readObject();
                    
                    textarea.appendText(g.toString());
                }
            }//end of nested try
            catch(Exception e){
                //
            }//nested catch     
            textarea.appendText("All objects are loaded successfully...\n");            
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }  
        // TODO
    }   
        // TODO
      

    @FXML
    private void backButton(ActionEvent event) {
    }
    
}
