package ba.unsa.etf.rpr.tutorijal06;

import static org.junit.jupiter.api.Assertions.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class MainTest {

    private TextField ime;

    @Start
    public void start(Stage stage) throws Exception {
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
        Parent mainNode = loader.load();
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void ispravanUnosImena(FxRobot robot) {
        ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn(ime);
        robot.write("Sven");
        assertEquals("Sven", ime.getText());
    }

    @Test
    public void neispravanUnosImena(FxRobot robot) {
        ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn(ime);
        robot.write("96");
        assertEquals("text-input text-field poljeNijeIspravno poljeNijeIspravno poljeNijeIspravno", ime.getStyleClass().toString());
    }
}