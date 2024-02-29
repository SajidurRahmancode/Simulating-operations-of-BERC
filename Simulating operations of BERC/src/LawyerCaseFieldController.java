/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import modelclass.Case;
import modelclass.Lawyer;

/**
 * FXML Controller class
 *
 * @author Unknown
 */
public class LawyerCaseFieldController implements Initializable {

    @FXML
    private TableView<Case> casefieldtable;

    @FXML
    private TableColumn<Case,String> casesummarycolumn;
    @FXML
    private TableColumn<Case,String> casenamecolumn;

    private ObservableList<Case> caseList;
    @FXML
    private TableColumn<Case, String> submittedbycolumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
            casesummarycolumn.setCellValueFactory(new PropertyValueFactory<Case, String>("Summary"));
            casenamecolumn.setCellValueFactory(new PropertyValueFactory<Case, String>("Name"));
            submittedbycolumn.setCellValueFactory(new PropertyValueFactory<Case, String>("submittedby"));

            
            caseList = Lawyer.Showcases();
        
        for (Case cas: caseList){
            
            casefieldtable.getItems().add(cas);
                        
            
        }
            
            
            
            
    
    }    

    @FXML
    private void backButtonOnAction(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("lawyerHomeScene.fxml"));
        Scene scene2 = new Scene(scene2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene2);
        window.show();

    }

    @FXML
    private void removecasebtn(ActionEvent event) {
    
        
    }
    

    
    
}
