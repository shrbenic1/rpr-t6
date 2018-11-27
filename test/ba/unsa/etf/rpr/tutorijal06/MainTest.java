package ba.unsa.etf.rpr.tutorijal06;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.awt.*;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.security.Key;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

@ExtendWith(ApplicationExtension.class)
class MainTest {

    private TextField ime;
    private TextField prezime;
    private TextField indeks;
    private TextField jmbg;
    private TextField kontaktTelefon;
    private TextField email;
    private ChoiceBox odsjek;
    private ChoiceBox godina;
    private ChoiceBox ciklus;
    private ChoiceBox status;
    private DatePicker datum;
    private ComboBox mjesto;
    private Button potvrdi;

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
        assertEquals("text-input text-field poljeIspravno", ime.getStyleClass().toString());
    }

    @Test
    public void neispravanUnosImena(FxRobot robot) {
        ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn(ime);
        robot.write("96");
        assertEquals("text-input text-field poljeNijeIspravno", ime.getStyleClass().toString());
    }

    @Test
    public void ispravanUnosPrezimena(FxRobot robot) {
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn(prezime);
        robot.write("Hrbenić");
        assertEquals("Hrbenić", prezime.getText());
        assertEquals("text-input text-field poljeIspravno", prezime.getStyleClass().toString());
    }

    @Test
    public void neispravanUnosPrezimena(FxRobot robot) {
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn(prezime);
        robot.write("96");
        assertEquals("text-input text-field poljeNijeIspravno", prezime.getStyleClass().toString());
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
        assertEquals("text-input text-field poljeIspravno", indeks.getStyleClass().toString());
        ;
    }

    @Test
    public void neispravanUnosIndeksa(FxRobot robot) {
        indeks = robot.lookup("#indeks").queryAs(TextField.class);
        robot.clickOn(indeks);
        robot.write("1790");
        assertEquals("text-input text-field poljeNijeIspravno", indeks.getStyleClass().toString());
        ;
    }

    @Test
    public void ispravanUnosJmbga(FxRobot robot) {
        jmbg = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn(jmbg);
        robot.write("0601998172652");
        assertEquals("0601998172652", jmbg.getText());
        assertEquals("text-input text-field poljeIspravno", jmbg.getStyleClass().toString());
    }

    @Test
    public void neispravanUnosJmbga(FxRobot robot) {
        jmbg = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn(jmbg);
        robot.write("0601998172654");
        assertEquals("text-input text-field poljeNijeIspravno", jmbg.getStyleClass().toString());
    }

    @Test
    public void ispravanKontaktTelefon(FxRobot robot) {
        kontaktTelefon = robot.lookup("#kontaktTelefon").queryAs(TextField.class);
        robot.clickOn(kontaktTelefon);
        robot.write("060242343");
        assertEquals("060242343", kontaktTelefon.getText());
        assertEquals("text-input text-field poljeIspravno", kontaktTelefon.getStyleClass().toString());
    }

    @Test
    public void neispravanKontaktTelefon(FxRobot robot) {
        kontaktTelefon = robot.lookup("#kontaktTelefon").queryAs(TextField.class);
        robot.clickOn(kontaktTelefon);
        robot.write("df");
        assertEquals("text-input text-field poljeNijeIspravno", kontaktTelefon.getStyleClass().toString());
    }

    @Test
    public void ispravanEmail(FxRobot robot) {
        email = robot.lookup("#email").queryAs(TextField.class);
        robot.clickOn(email);
        robot.write("shrbenic1@etf.unsa.ba");
        assertEquals("shrbenic1@etf.unsa.ba", email.getText());
        assertEquals("text-input text-field poljeIspravno", email.getStyleClass().toString());
    }

    @Test
    public void neispravanEmail(FxRobot robot) {
        email = robot.lookup("#email").queryAs(TextField.class);
        robot.clickOn(email);
        robot.write("shrbenic1etf.unsa.ba");
        assertEquals("text-input text-field poljeNijeIspravno", email.getStyleClass().toString());
    }

    @Test
    public void ispravanOdsjek(FxRobot robot) {
        odsjek = robot.lookup("#izborOdsjeka").queryAs(ChoiceBox.class);
        robot.clickOn(odsjek);
        robot.type(KeyCode.ENTER);
        assertEquals("AE", odsjek.getValue().toString());
        assertEquals("choice-box", odsjek.getStyleClass().toString());
    }

    @Test
    public void ispravanOdsjek1(FxRobot robot) {
        odsjek = robot.lookup("#izborOdsjeka").queryAs(ChoiceBox.class);
        robot.clickOn(odsjek);
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.ENTER);
        assertEquals("RI", odsjek.getValue().toString());
        assertEquals("choice-box", odsjek.getStyleClass().toString());
    }

    @Test
    public void ispravnaGodina(FxRobot robot) {
        godina = robot.lookup("#izborGodineStudija").queryAs(ChoiceBox.class);
        robot.clickOn(godina);
        robot.type(KeyCode.ENTER);
        assertEquals("Prva", godina.getValue().toString());
        assertEquals("choice-box", godina.getStyleClass().toString());
    }

    @Test
    public void ispravnaGodina1(FxRobot robot) {
        godina = robot.lookup("#izborGodineStudija").queryAs(ChoiceBox.class);
        robot.clickOn(godina);
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.DOWN);
        robot.type(KeyCode.ENTER);
        assertEquals("Treća", godina.getValue().toString());
        assertEquals("choice-box", godina.getStyleClass().toString());
    }

    @Test
    public void ispravanCiklus(FxRobot robot) {
        ciklus = robot.lookup("#izborCiklusa").queryAs(ChoiceBox.class);
        robot.clickOn(ciklus);
        robot.type(KeyCode.ENTER);
        assertEquals("Bachelor", ciklus.getValue().toString());
        assertEquals("choice-box", ciklus.getStyleClass().toString());
    }

    @Test
    public void ispravanStatus(FxRobot robot) {
        status = robot.lookup("#izborStatusa").queryAs(ChoiceBox.class);
        robot.clickOn(status);
        robot.type(KeyCode.ENTER);
        assertEquals("Redovan", status.getValue().toString());
        assertEquals("choice-box", status.getStyleClass().toString());
    }

    @Test
    public void neispravanStatus(FxRobot robot) {
        status = robot.lookup("#izborStatusa").queryAs(ChoiceBox.class);
        robot.clickOn(status);
        ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn(ime);
        assertEquals("choice-box", status.getStyleClass().toString());
    }

    @Test
    public void ispravanDatum(FxRobot robot) {
        jmbg = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn(jmbg);
        robot.write("0601998172652");
        datum = robot.lookup("#datum").queryAs(DatePicker.class);
        robot.clickOn(datum);
        robot.write("1/6/1998");
        robot.type(KeyCode.ENTER);
        assertEquals("1998-01-06", datum.getValue().toString());
    }

    @Test
    public void neispravanDatum(FxRobot robot) {
        jmbg = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn(jmbg);
        robot.write("0601998172652");
        datum = robot.lookup("#datum").queryAs(DatePicker.class);
        robot.clickOn(datum);
        robot.write("1/22/2008");
        robot.type(KeyCode.ENTER);
        assertEquals("2008-01-22", datum.getValue().toString());
    }

    @Test
    public void potvrda(FxRobot robot) {
        ByteArrayOutputStream test = new ByteArrayOutputStream();
        PrintStream PS = new PrintStream(test);
        PrintStream old = System.out;
        System.setOut(PS);
        ime = robot.lookup("#ime").queryAs(TextField.class);
        robot.clickOn(ime);
        robot.write("Sven");
        prezime = robot.lookup("#prezime").queryAs(TextField.class);
        robot.clickOn(prezime);
        robot.write("Hrbenić");
        indeks = robot.lookup("#indeks").queryAs(TextField.class);
        robot.clickOn(indeks);
        robot.write("17901");
        jmbg = robot.lookup("#jmbg").queryAs(TextField.class);
        robot.clickOn(jmbg);
        robot.write("0601998172652");
        datum = robot.lookup("#datum").queryAs(DatePicker.class);
        robot.clickOn(datum);
        robot.write("1/6/1998");
        robot.type(KeyCode.ENTER);
        mjesto = robot.lookup("#izborMjestaRodjenja").queryAs(ComboBox.class);
        robot.clickOn(mjesto);
        mjesto.setValue("Zagreb");
        robot.type(KeyCode.ENTER);
        email = robot.lookup("#email").queryAs(TextField.class);
        robot.clickOn(email);
        robot.write("shrbenic1@etf.unsa.ba");
        odsjek = robot.lookup("#izborOdsjeka").queryAs(ChoiceBox.class);
        robot.clickOn(odsjek);
        robot.type(KeyCode.ENTER);
        godina = robot.lookup("#izborGodineStudija").queryAs(ChoiceBox.class);
        robot.clickOn(godina);
        robot.type(KeyCode.ENTER);
        ciklus = robot.lookup("#izborCiklusa").queryAs(ChoiceBox.class);
        robot.clickOn(ciklus);
        robot.type(KeyCode.ENTER);
        status = robot.lookup("#izborStatusa").queryAs(ChoiceBox.class);
        robot.clickOn(status);
        robot.type(KeyCode.ENTER);
        potvrdi = robot.lookup("#potvrda").queryAs(Button.class);
        robot.clickOn(potvrdi);
        assertEquals("Ime: Sven\nPrezime: Hrbenić\nBroj indeksa: 17901\nJMBG: 0601998172652\nDatum rođenja: 1998-01-06\nMjesto rođenja: Zagreb\nE-mail adresa: shrbenic1@etf.unsa.ba\nOdsjek: AE\nGodina studija: Prva\nCiklus studija: Bachelor\nStatus: Redovan\nNe pripada boračkim kategorijama\n", test.toString());
    }
}