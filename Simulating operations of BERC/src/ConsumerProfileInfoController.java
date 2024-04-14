/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import modelclass.Consumer;
import modelclass.Profile;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsumerProfileInfoController implements Initializable {

    @FXML
    private TableView<Profile> tableview;
    @FXML
    private TableColumn<Profile, String> fnamecol;
    @FXML
    private TableColumn<Profile, String> lnamecol;
    @FXML
    private TableColumn<Profile, String> nidcol;
    @FXML
    private TableColumn<Profile, String> presentaddcol;
    @FXML
    private TableColumn<Profile, String> permanentaddcol;
    @FXML
    private TableColumn<Profile, String> dobcol;
   
    private ObservableList<Profile> profileList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        fnamecol.setCellValueFactory(new PropertyValueFactory <Profile, String>("fname"));
        lnamecol.setCellValueFactory(new PropertyValueFactory <Profile, String>("lname"));
        nidcol.setCellValueFactory(new PropertyValueFactory <Profile, String>("nid"));
        presentaddcol.setCellValueFactory(new PropertyValueFactory <Profile, String>("presentadd"));
        permanentaddcol.setCellValueFactory(new PropertyValueFactory <Profile, String>("permanentadd"));
        dobcol.setCellValueFactory(new PropertyValueFactory <Profile, String>("dob"));
       
        
        profileList = Consumer.profileinfo();
        
        for (Profile p: profileList){
            
            tableview.getItems().add(p);
                        
        // TODO
    }
        
        
    }

    @FXML
    private void backbutton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("ConsumerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }
    
}
