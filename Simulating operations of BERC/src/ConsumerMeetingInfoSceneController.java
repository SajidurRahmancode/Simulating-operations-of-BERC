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
import modelclass.EmployeeSalary;
import modelclass.SetMeeting;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsumerMeetingInfoSceneController implements Initializable {

    @FXML
    private TableView<SetMeeting> tableview;
    @FXML
    private TableColumn<SetMeeting, String> meettypecol;
    @FXML
    private TableColumn<SetMeeting, String> loccol;
    @FXML
    private TableColumn<SetMeeting, String> linkcol;
    @FXML
    private TableColumn<SetMeeting, String> setbycol;
    @FXML
    private TableColumn<SetMeeting, String> timecol;
    @FXML
    private TableColumn<SetMeeting, String> datecol;
    private ObservableList<SetMeeting> meetList;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        meettypecol.setCellValueFactory(new PropertyValueFactory <SetMeeting, String>("meetingType"));
        loccol.setCellValueFactory(new PropertyValueFactory <SetMeeting, String>("meetingLocation"));
        linkcol.setCellValueFactory(new PropertyValueFactory <SetMeeting, String>("meetingLink"));
        setbycol.setCellValueFactory(new PropertyValueFactory <SetMeeting, String>("setby"));
        timecol.setCellValueFactory(new PropertyValueFactory <SetMeeting, String>("meetingTime"));
        datecol.setCellValueFactory(new PropertyValueFactory <SetMeeting, String>("meetingDate"));
       
        
       meetList = Consumer.meetinfo();
        
        for (SetMeeting s: meetList){
            
            tableview.getItems().add(s);
                        
            
        }
    }
        
        
        // TODO
        

    @FXML
    private void backbutton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("ConsumerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }
    
}
