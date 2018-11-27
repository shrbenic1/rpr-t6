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
    private TextField prezime;
    private TextField indeks;

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
        assertEquals("text-input text-field poljeIspravno poljeIspravno poljeIspravno poljeIspravno", ime.getStyleClass().toString());
    }

    @Test
    public void neispravanUnosImena(FxRobot robot) {
        ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn(ime);
        robot.write("96");
        assertEquals("text-input text-field poljeNijeIspravno poljeNijeIspravno poljeNijeIspravno", ime.getStyleClass().toString());
    }

    @Test
    public void ispravanUnosPrezimena(FxRobot robot) {
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn(prezime);
        robot.write("Hrbenić");
        assertEquals("Hrbenić", prezime.getText());
        assertEquals("text-input text-field poljeIspravno poljeIspravno poljeIspravno poljeIspravno poljeIspravno poljeIspravno poljeIspravno", prezime.getStyleClass().toString());
    }

    @Test
    public void neispravanUnosPrezimena(FxRobot robot) {
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn(prezime);
        robot.write("96");
        assertEquals("text-input text-field poljeNijeIspravno poljeNijeIspravno poljeNijeIspravno", prezime.getStyleClass().toString());
    }

    @Test
    public void neispravanUnosImena1(FxRobot robot) {
        ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn(ime);
        robot.write("AaAaAaAaAaAaAaAaAaAaA");
        assertEquals("text-input text-field poljeNijeIspravno", ime.getStyleClass().toString());
    }

    @Test
    public void ispravanUnosIndeksa(FxRobot robot) {
        indeks = robot.lookup("#indeks").queryAs(TextField.class);
        robot.clickOn(indeks);
        robot.write("17901");
        assertEquals("17901", indeks.getText());
        assertEquals("text-input text-field poljeIspravno", indeks.getStyleClass().toString());;
    }

    @Test
    public void neispravanUnosIndeksa(FxRobot robot) {
        indeks = robot.lookup("#indeks").queryAs(TextField.class);
        robot.clickOn(indeks);
        robot.write("1790");
        assertEquals("text-input text-field poljeNijeIspravno poljeNijeIspravno poljeNijeIspravno poljeNijeIspravno poljeNijeIspravno", indeks.getStyleClass().toString());;
    }
}