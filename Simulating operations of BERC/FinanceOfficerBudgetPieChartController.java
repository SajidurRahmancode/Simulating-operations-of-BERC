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
public class FinanceOfficerBudgetPieChartController implements Initializable {

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
        int d = 0;
        
        int g = 0;
        int h = 0;
        int i = 0;
        int j = 0;
        
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
                    else if(emp.getDepartment().equals("Tariff officer")){
                        d++;
                     }
                    else if(emp.getDepartment().equals("Consumer")){
                        g++;
                     }
                    else if(emp.getDepartment().equals("Finance officer")){
                        h++;
                     }
                    else if(emp.getDepartment().equals("District Manager")){
                        i++;
                     }
                    else if(emp.getDepartment().equals("Government Authorities")){
                        j++;
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
        
        list.add( new PieChart.Data("chairman",a) );
        list.add( new PieChart.Data("Employee",b) );
        list.add( new PieChart.Data("Lawyer",c) );
        list.add( new PieChart.Data("Tariff officer",d) );
        list.add( new PieChart.Data("Consumer",g) );
        list.add( new PieChart.Data("Finance officer",h) );
        list.add( new PieChart.Data("District Manager",i) );
        list.add( new PieChart.Data("Government Authorities",j) );
        //ObservableList <PieChart.Data> list2 = FXCollections.observableArrayList();
        //list2.add(new PieChart.Data("Java",50));
        //...
        piechart.setData(list);
        
        for(PieChart.Data data: piechart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    
                    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            }
            );
            
        }
        // TODO
    }
    

        // TODO
       

    @FXML
    private void backbutton(ActionEvent event) throws IOException {
         Parent scene2Parent = FXMLLoader.load(getClass().getResource("FinanceOfficerHomeScene.fxml"));
         Scene scene2 = new Scene(scene2Parent);
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
         window.setScene(scene2);
         window.show();
    }
    
}
