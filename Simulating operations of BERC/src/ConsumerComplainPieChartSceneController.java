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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import modelclass.Budget;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsumerComplainPieChartSceneController implements Initializable {

    @FXML
    private PieChart piechart;
    private ObservableList <PieChart.Data> list 
            = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        File f = null;
        FileInputStream fis = null;      
        ObjectInputStream ois = null;
        int a = 0;
        int b = 0;
        int c = 0;
        try {
            f = new File("budget.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            Budget emp;
            try{
                //"Land Owner", "Employee", "H.R", "Finance Department", "Legal Advisor","Land Buyer"
                while(true){
                    emp = (Budget)ois.readObject();
                    if(emp.getDepartment().equals("chairman")) {                      
                        a++;
                    }
                    else if(emp.getDepartment().equals("Employee")){
                        b++;
                    }
                     else if(emp.getDepartment().equals("Lawyer")){
                        c++;
                     }
                    
                }
                
             
            }//end of nested try
        catch(Exception e){
                //
            }//nested catch     
                   
        } catch (IOException ex) { } 
        finally {
            try {
                if(ois != null) ois.close();
            } catch (IOException ex) { }
        }
        list.add( new PieChart.Data("Water",a) );
        list.add( new PieChart.Data("Electricity",b) );
        list.add( new PieChart.Data("Gas",c) );
         piechart.setData(list);
        
        for(PieChart.Data data: piechart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    
                   
                }
            }
            );
            
        }
        // TODO
    }
    


    @FXML
    private void backButton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("ConsumerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();       
         window.setScene(scene2);
         window.show();
    }
    
}
