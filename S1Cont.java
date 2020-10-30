package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

public class S1Cont {

    //Below are the connections for all of the different items in scene builder to the Main file to generate them
    @FXML
    private PieChart chart;

    @FXML
    private TextField Tuition;

    @FXML
    private TextField Food;

    @FXML
    private TextField Utilities;

    @FXML
    private TextField Rent;

    @FXML
    private TextField incomeRem;

    @FXML
    private TextField Other;

    //this is an array that will store the user inputs from the 5 Input TextFields above
    int[] values = new int[5];

    //update method changes the values in the array of inputs based on new data from the user.
    public void update(ActionEvent event){
       if(Tuition.getText().trim().equals("") || Tuition.getText().matches("^[0-9]*$") ==false ||
                Food.getText().trim().equals("") || Food.getText().matches("^[0-9]*$") ==false ||
                Utilities.getText().trim().equals("") || Utilities.getText().matches("^[0-9]*$") ==false ||
                Rent.getText().trim().equals("") || Rent.getText().matches("^[0-9]*$") ==false
               || Other.getText().trim().equals("") || Other.getText().matches("^[0-9]*$") ==false
       ){
           Validate();
       }else{
            values = changeT(values);
            values = changeF(values);
            values = changeU(values);
            values = changeR(values);
            values = changeO(values);
            loadData();
            setRemaining();
       }
    }

    // The functions below are called to get the user input from each TextField and assign it to the corresponding array index that will store it.
    public int[] changeT(int[] arr){
        arr[0] = Integer.parseInt(Tuition.getText());
        return arr;
    }
    public int[] changeF(int[] arr){
        arr[1] = Integer.parseInt(Food.getText());
        return arr;
    }
    public int[] changeU(int[] arr){
        arr[2] = Integer.parseInt(Utilities.getText());
        return arr;
    }
    public int[] changeR(int[] arr){
        arr[3] = Integer.parseInt(Rent.getText());
        return arr;
    }
    public int[] changeO(int[] arr){
        arr[4] = Integer.parseInt(Other.getText());
        return arr;
    }

    //quit Method assigned to the quit button to close the program
    public void quit(ActionEvent event){
        System.exit(0);
    }

    public void loadData(){
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
        if(values[0]>0) {
            list.add(new PieChart.Data("Tuition", values[0]));
        }
        if(values[1]>0) {
            list.add(new PieChart.Data("Food", values[1]));
        }
        if(values[2]>0) {
            list.add(new PieChart.Data("Utilities", values[2]));
        }
        if(values[3]>0) {
            list.add(new PieChart.Data("Rent", values[3]));
        }
        if(values[4]>0) {
            list.add(new PieChart.Data("Other", values[4]));
        }
        chart.setData(list);
    }

    public void setRemaining(){
        if ((Main.getIncome()-values[0]-values[1]-values[2]-values[3]-values[4]) <0) {
            incomeRem.setText("-$"+ Math.abs(Main.getIncome()-values[0]-values[1]-values[2]-values[3]-values[4]) );
        }else{
            incomeRem.setText("$"+ (Main.getIncome()-values[0]-values[1]-values[2]-values[3]-values[4]) );
        }
    }

    public void back(ActionEvent event){
        Main.set_pane(0);
    }

    public void Validate(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Validate Input");
        alert.setHeaderText(null);
        alert.setContentText("Please enter only numerical values\nEnter 0 if not applicable");
        alert.showAndWait();
    }
}