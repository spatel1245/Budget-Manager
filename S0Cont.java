package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class S0Cont {
    @FXML
    private Button continueBtn;

    @FXML
    private TextField Income;

    public void quit(ActionEvent event){
        if(Income.getText().trim().equals("") || Income.getText().matches("^[0-9]*$") ==false ){
            Validate();
        }else{
            income();
            Main.set_pane(1);
        }
    }

    public void income(){
        if (Income.getText().trim().equals("") || Income.getText().matches("^[0-9]*$") ==false ){
            Validate();
        }else{
            Main.setIncome(Integer.parseInt(Income.getText()));
        }
    }

    public void Validate(){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Validate Input");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a number in the field");
        alert.showAndWait();
    }
}
