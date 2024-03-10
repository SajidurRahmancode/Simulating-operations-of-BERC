package modelclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
//sajid
public abstract class User {
    protected String username, password, userType;

    public boolean authenticateUser(String username, String password, String userType) {
    try (Scanner sc = new Scanner(new File("userAccounts.txt"))) {
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] userInfo = line.split(",");
            if (username.equals(userInfo[0].trim()) && password.equals(userInfo[1].trim())
                    && userType.equals(userInfo[2].trim())) {
                return true; 
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false; 
}

    private void setUserScene(String type, ActionEvent event) throws IOException {
        Parent userSceneParent;
        switch (type) {
            case "chairman":
                userSceneParent = FXMLLoader.load(getClass().getResource("landOwnerHomeScene.fxml"));
                break;
            case "Employee":
                userSceneParent = FXMLLoader.load(getClass().getResource("employeeHomeScene.fxml"));
                break;
            case "Lawyer":
                userSceneParent = FXMLLoader.load(getClass().getResource("lawyerHomeScene.fxml"));
                break;
            case "Tariff officer":
                userSceneParent = FXMLLoader.load(getClass().getResource("tarriffofficerhomescene.fxml"));
                break;
            case "consumer":
                userSceneParent = FXMLLoader.load(getClass().getResource("governmentAuthHomeScene.fxml"));
                break;
            case "Finance officer":
                userSceneParent = FXMLLoader.load(getClass().getResource("LawyerHomeScene.fxml"));
                break;
            case "District Manager":
                userSceneParent = FXMLLoader.load(getClass().getResource("LandBuyerhomescene.fxml"));
                break;
            case "Government Authorities":
                userSceneParent = FXMLLoader.load(getClass().getResource("LandRegistrationAdministrative.fxml"));
                break;
            default:
                throw new IOException("Invalid user type");
        }
        Scene scene2 = new Scene(userSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene2);
        window.show();

       
        
    }

    public void login(String user, String password, String uType, ActionEvent event) {
    Alert a = new Alert(Alert.AlertType.INFORMATION);
    File f = null;
    Scanner sc = null;

    try {
        f = new File("userAccounts.txt");
        if (!f.exists()) {
            a.setTitle("Login Issue");
            a.setHeaderText("Issue found");
            a.setContentText("The login information file is not present!");
            a.showAndWait();
        } else {
            sc = new Scanner(new FileReader(f));
            String line;
            boolean loggedIn = false;

            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] userInfo = line.split(",");
                if (user.equals(userInfo[0].trim()) && password.equals(userInfo[1].trim())
                        && uType.equals(userInfo[2].trim())) {
                    loggedIn = true;
                    setUserScene(uType, event);
                    sc.close();
                    break;
                }
            }

            if (!loggedIn) {
                a.setTitle("Login Issue");
                a.setHeaderText("Invalid login");
                a.setContentText("Invalid login credentials, please try again!");
                a.showAndWait();
            }
        }
    } catch (IOException e) {
    }
}
//sajid
    public void register(String name, String password, String userType) throws FileNotFoundException {
            this.username = name;
            this.password = password;
            this.userType = userType;

            try (Scanner sc = new Scanner(new File("userAccounts.txt"))) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] userInfo = line.split(",");
                    if (username.equals(userInfo[0].trim())) {
                        return; 
                    }
                }
            }

            try (FileWriter fw = new FileWriter("userAccounts.txt", true)) {
               fw.write(username + "," + password + "," + userType + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
    public boolean isUsernameRegistered(String username) {
                    try (Scanner sc = new Scanner(new File("userAccounts.txt"))) {
                    while (sc.hasNextLine()) {
                        String line = sc.nextLine();
                        String[] userInfo = line.split(",");
                        if (username.equals(userInfo[0].trim())) {
                            return true; // Username already exists
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return false;
            }
}
