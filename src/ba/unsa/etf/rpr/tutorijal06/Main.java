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
        OdsjekModel modelOdsjeka = new OdsjekModel();
        GodinaStudijaModel modelGodineStudija = new GodinaStudijaModel();
        CiklusModel modelCiklusa = new CiklusModel();
        StatusModel modelStatusa = new StatusModel();
        modelMjestaRodjenja.dodajMjestaRodjenja();
        modelOdsjeka.dodajOdsjeke();
        modelGodineStudija.dodajGodine();
        modelCiklusa.dodajCikluse();
        modelStatusa.dodajStatuse();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("upis.fxml"));
        loader.setController(new Controller(modelMjestaRodjenja, modelOdsjeka, modelGodineStudija, modelCiklusa, modelStatusa));
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
