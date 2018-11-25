package ba.unsa.etf.rpr.tutorijal06;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import static javafx.scene.control.PopupControl.USE_COMPUTED_SIZE;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MjestoRodjenjaModel modelMjestaRodjenja = new MjestoRodjenjaModel();
        modelMjestaRodjenja.dodajMjestaRodjenja();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("upis.fxml"));
        loader.setController(new Controller(modelMjestaRodjenja));
        Parent root = loader.load();
        root.getStylesheets().add(getClass().getResource("upis.css").toExternalForm());
        primaryStage.setTitle("Upis");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
