package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Controller {
    private MjestoRodjenjaModel mjestoRodjenjaModel;
    private OdsjekModel odsjekModel;
    public ComboBox<MjestoRodjenja> izborMjestaRodjenja;
    public ChoiceBox<Odsjek> izborOdsjeka;
    public TextField ime;
    public TextField prezime;
    public TextField indeks;
    //private TextField jmbg;

    public Controller(MjestoRodjenjaModel modelMjestaRodjenja, OdsjekModel modelOdsjeka) {
        mjestoRodjenjaModel = modelMjestaRodjenja;
        odsjekModel = modelOdsjeka;
    }

    private boolean validnoImePrezime(String n) {
        if(n.length() < 1 || n.length() > 20) {
            return false;
        }
        for(int i = 0; i < n.length(); i++){
            if(n.charAt(i) < 'A' || n.charAt(i) > 'Ž' && n.charAt(i) < 'a' || n.charAt(i) > 'ž') {
                return false;
            }
        }
        return true;
    }

    private boolean validanIndeks(String n) {
        for (int i = 0; i < n.length(); i++) {
            if(n.charAt(i) < '1' || n.charAt(i) > '9') return false;
        }
        return n.length() == 5;
    }

    @FXML
    public void initialize() {
        izborMjestaRodjenja.setItems(mjestoRodjenjaModel.getMjestaRodjenja());
        izborOdsjeka.setItems(odsjekModel.getOdsjeci());
        ime.getStyleClass().add("poljeNijeIspravno");
        prezime.getStyleClass().add("poljeNijeIspravno");
        indeks.getStyleClass().add("poljeNijeIspravno");
        //jmbg.getStyleClass().add("poljeNijeIspravno");
        ime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoImePrezime(n)) {
                    ime.getStyleClass().removeAll("poljeNijeIspravno");
                    ime.getStyleClass().add("poljeIspravno");
                } else {
                    ime.getStyleClass().removeAll("poljeIspravno");
                    ime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        prezime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoImePrezime(n)) {
                    prezime.getStyleClass().removeAll("poljeNijeIspravno");
                    prezime.getStyleClass().add("poljeIspravno");
                } else {
                    prezime.getStyleClass().removeAll("poljeIspravno");
                    prezime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        indeks.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanIndeks(n)) {
                    indeks.getStyleClass().removeAll("poljeNijeIspravno");
                    indeks.getStyleClass().add("poljeIspravno");
                } else {
                    indeks.getStyleClass().removeAll("poljeIspravno");
                    indeks.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });
    }

    public void promjenaKnjige(ActionEvent actionEvent) {
        mjestoRodjenjaModel.setTrenutnoMjestoRodjenja(izborMjestaRodjenja.getValue());
    }

    public void promjenaOdsjeka(ActionEvent actionEvent) {
        odsjekModel.setTrenutniOdsjek(izborOdsjeka.getValue());
    }



}
