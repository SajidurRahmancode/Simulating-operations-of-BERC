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
import modelclass.EmployeeSalary;

/**
 * FXML Controller class
 *
 * @author User
 */
public class FinanceOfficerSalaryPieChartController implements Initializable {

    @FXML
    private PieChart piechaart;
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
        int k = 0;
        int l = 0;
        int m = 0;
        int n = 0;
        
        try {
            f = new File("employeesalary.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            EmployeeSalary emp;
            try{
               
                while(true){
                    emp = (EmployeeSalary)ois.readObject();
                    if(emp.getEmployeeid().equals("2131001")) {
                        
                        a++;
                         }
                    else if(emp.getEmployeeid().equals("2221001")){
                        b++;
                    }
                     else if(emp.getEmployeeid().equals("2141565")){
                        c++;
                     }
                    else if(emp.getEmployeeid().equals("2459788")){
                        d++;
                     }
                    else if(emp.getEmployeeid().equals("4131221")){
                        g++;
                     }
                    else if(emp.getEmployeeid().equals("9561001")){
                        h++;
                     }
                    else if(emp.getEmployeeid().equals("3361999")){
                        i++;
                     }
                    else if(emp.getEmployeeid().equals("1785779")){
                        j++;
                     }
                    else if(emp.getEmployeeid().equals("1866000")){
                        k++;
                    }
                     else if(emp.getEmployeeid().equals("2061099")){
                        l++;
                    }
                     else if(emp.getEmployeeid().equals("3335009")){
                        m++;
                    }
                     else if(emp.getEmployeeid().equals("1991034")){
                        n++;
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
        
        list.add( new PieChart.Data("2131001",a) );
        list.add( new PieChart.Data("2221001",b) );
        list.add( new PieChart.Data("2141565",c) );
        list.add( new PieChart.Data("2459788",d) );
        list.add( new PieChart.Data("4131221",g) );
        list.add( new PieChart.Data("9561001",h) );
        list.add( new PieChart.Data("3361999",i) );
        list.add( new PieChart.Data("1785779",j) );
        list.add( new PieChart.Data("1866000",k) );
        list.add( new PieChart.Data("2061099",l) );
        list.add( new PieChart.Data("3335009",m) );
        list.add( new PieChart.Data("1991034",n) );   
       
        piechaart.setData(list);
        
        for(PieChart.Data data: piechaart.getData()){
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
