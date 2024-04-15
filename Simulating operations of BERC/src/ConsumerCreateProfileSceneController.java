/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelclass.Consumer;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsumerCreateProfileSceneController implements Initializable {

    @FXML
    private TextField presentaddressTF;
    @FXML
    private TextField firstnameTF;
    @FXML
    private TextField lastnameTF;
    @FXML
    private TextField nidTF;
    @FXML
    private TextField permanentaddTF;
    @FXML
    private DatePicker datepicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backbutton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("ConsumerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }

    @FXML
    private void saveButton(ActionEvent event) throws IOException {
        
                          Boolean addstatus= 
                            Consumer.createpro(

                                    firstnameTF.getText(),
                                    lastnameTF.getText(),
                                    nidTF.getText(),                                 
                                    presentaddressTF.getText(), 
                                    permanentaddTF.getText(),
                                    datepicker.getValue()
                            );

                    if(addstatus){

                        Alert a=new Alert(Alert.AlertType.INFORMATION);
                        a.setContentText(" !! Your Profile is Created !!");
                        a.showAndWait();
                    }
                    else{

                        Alert a =new Alert(Alert.AlertType.ERROR);
                        a.setContentText("Error");
                        a.showAndWait();

                }
   
    
    }
    
}
