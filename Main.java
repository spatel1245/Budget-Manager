package sample;
import javafx.application.Application;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.*;


public class Main extends Application {

    static AnchorPane root;
    static List<AnchorPane> anchor = new ArrayList<AnchorPane>();
    private static int idx_cur = 0;
    public static int income = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = (AnchorPane)FXMLLoader.load(getClass().getResource("anchor.fxml"));// creates root based off of S1.fxml file. This creates the GUI from scene builder

        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("S0.fxml")));
        anchor.add((AnchorPane)FXMLLoader.load(getClass().getResource("S1.fxml")));

        root.getChildren().add(anchor.get(0));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("Pitt_CSS.css");

        primaryStage.setTitle("Budget Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void set_pane(int idx){
        root.getChildren().remove(anchor.get(idx_cur));
        root.getChildren().add(anchor.get(idx));
        idx_cur = idx;
    }

    public static void setIncome(int x){ income = x;}

    public static AnchorPane get_pane(int idx){
        return anchor.get(idx);
    }

    public static int getIncome(){ return income; }

    public static void main(String[] args) {
        launch(args);
    }
}
