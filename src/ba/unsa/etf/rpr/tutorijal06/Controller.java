package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.apache.commons.validator.EmailValidator;

import java.time.LocalDate;
import java.util.Date;

public class Controller {
    private MjestoRodjenjaModel mjestoRodjenjaModel;
    private OdsjekModel odsjekModel;
    private GodinaStudijaModel godinaStudijaModel;
    private CiklusModel ciklusModel;
    private StatusModel statusModel;
    public ComboBox<MjestoRodjenja> izborMjestaRodjenja;
    public ChoiceBox<Odsjek> izborOdsjeka;
    public ChoiceBox<GodinaStudija> izborGodineStudija;
    public ChoiceBox<Ciklus> izborCiklusa;
    public ChoiceBox<Status> izborStatusa;
    public TextField ime;
    public TextField prezime;
    public TextField indeks;
    public TextField jmbg;
    public TextField kontaktAdresa;
    public TextField kontaktTelefon;
    public TextField email;
    public DatePicker datum;
    public CheckBox boracka;

    public Controller(MjestoRodjenjaModel modelMjestaRodjenja, OdsjekModel modelOdsjeka, GodinaStudijaModel modelGodineStudija, CiklusModel modelCiklusa, StatusModel modelStatusa) {
        mjestoRodjenjaModel = modelMjestaRodjenja;
        odsjekModel = modelOdsjeka;
        godinaStudijaModel = modelGodineStudija;
        ciklusModel = modelCiklusa;
        statusModel = modelStatusa;
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
        for(int i = 0; i < n.length(); i++) {
            if(n.charAt(i) < '0' || n.charAt(i) > '9') {
                return false;
            }
        }
        return n.length() == 5;
    }

    private boolean validanJmbg(String n) {
        if(n.length() != 13) {
            return false;
        }
        for(int i = 0; i < n.length(); i++) {
            if(n.charAt(i) < '0' || n.charAt(i) > '9') {
                return false;
            }
        }
        //int L = 11 - (( 7*(getNumericValue(n.charAt(0))+getNumericValue(n.charAt(6))) + 6*(getNumericValue(n.charAt(1))+getNumericValue(n.charAt(7))) + 5*(getNumericValue(n.charAt(2))+getNumericValue(n.charAt(8))) + 4*(getNumericValue(n.charAt(3))+getNumericValue(n.charAt(9))) + 3*(getNumericValue(n.charAt(4))+getNumericValue(n.charAt(10))) + 2*(getNumericValue(n.charAt(5))+getNumericValue(n.charAt(11))) ) % 11);
        int L = 11 - ((7 * (n.charAt(0) - '0' + n.charAt(6) - '0') + 6 * (n.charAt(1) - '0' + n.charAt(7) - '0') + 5 * (n.charAt(2) - '0' + n.charAt(8) - '0') + 4 * (n.charAt(3) - '0' + n.charAt(9) - '0') + 3 * (n.charAt(4) - '0' + n.charAt(10) - '0') + 2 * (n.charAt(5) - '0' + n.charAt(11) - '0'))%11);
        if(L>9) {
            L = 0;
        }
        return L == (n.charAt(12) - '0');
    }

    private  boolean validanKontaktTelefon(String n) {
        for(int i = 0; i < n.length(); i++) {
            if(n.charAt(i) < '0' || n.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }

    @FXML
    public void initialize() {
        izborMjestaRodjenja.setItems(mjestoRodjenjaModel.getMjestaRodjenja());
        izborOdsjeka.setItems(odsjekModel.getOdsjeci());
        izborGodineStudija.setItems(godinaStudijaModel.getGodineStudija());
        izborCiklusa.setItems(ciklusModel.getCiklusi());
        izborStatusa.setItems(statusModel.getStatusi());
        ime.getStyleClass().add("poljeNijeIspravno");
        prezime.getStyleClass().add("poljeNijeIspravno");
        indeks.getStyleClass().add("poljeNijeIspravno");
        jmbg.getStyleClass().add("poljeNijeIspravno");
        kontaktAdresa.getStyleClass().add("poljeIspravno");
        kontaktTelefon.getStyleClass().add("poljeIspravno");
        email.getStyleClass().add("poljeNijeIspravno");
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

        jmbg.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanJmbg(n)) {
                    jmbg.getStyleClass().removeAll("poljeNijeIspravno");
                    jmbg.getStyleClass().add("poljeIspravno");
                } else {
                    jmbg.getStyleClass().removeAll("poljeIspravno");
                    jmbg.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        kontaktTelefon.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanKontaktTelefon(n)) {
                    kontaktTelefon.getStyleClass().removeAll("poljeNijeIspravno");
                    kontaktTelefon.getStyleClass().add("poljeIspravno");
                } else {
                    kontaktTelefon.getStyleClass().removeAll("poljeIspravno");
                    kontaktTelefon.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        email.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> obs, String o, String n) {
                EmailValidator validator = EmailValidator.getInstance();
                if (validator.isValid(n)) {
                    email.getStyleClass().removeAll("poljeNijeIspravno");
                    email.getStyleClass().add("poljeIspravno");
                } else {
                    email.getStyleClass().removeAll("poljeIspravno");
                    email.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

    }

    public void date(ActionEvent actionEvent) {
        LocalDate datum1 = datum.getValue();
        if(validnostDatuma(datum1)) {
            datum.getStyleClass().removeAll("poljeNijeIspravno");
            datum.getStyleClass().add("poljeIspravno");
        } else {
            datum.getStyleClass().removeAll("poljeIspravno");
            datum.getStyleClass().add("poljeNijeIspravno");
        }
    }

    private boolean validnostDatuma(LocalDate datum1) {
        Date date = new Date();
        if(date.getYear() < datum1.getYear() && date.getMonth() < datum1.getMonth().getValue() && date.getDay() < datum1.getDayOfYear()) {
            return false;
        } else {
            if(Integer.parseInt(jmbg.getCharacters().toString().substring(4, 7)) < 900) {
                if(datum1.getYear() != Integer.parseInt("2" + jmbg.getCharacters().toString().substring(4, 7))) {
                    return false;
                }
            } else {
                if(datum1.getYear() != Integer.parseInt("1"+ jmbg.getCharacters().toString().substring(4, 7))) {
                    return false;
                }
            }
            if(datum1.getMonth().getValue() != Integer.parseInt(jmbg.getCharacters().toString().substring(2, 4).replace("0", ""))) {
                return false;
            } else if(datum1.getDayOfYear() != Integer.parseInt(jmbg.getCharacters().toString().substring(0, 2).replace("0", ""))) {
                return false;
            } else {
                return true;
            }
        }
    }



    public void promjenaKnjige(ActionEvent actionEvent) {
        mjestoRodjenjaModel.setTrenutnoMjestoRodjenja(izborMjestaRodjenja.getValue());
    }

    public void promjenaOdsjeka(ActionEvent actionEvent) {
        odsjekModel.setTrenutniOdsjek(izborOdsjeka.getValue());
    }

    public void promjenaGodineStudija(ActionEvent actionEvent) {
        godinaStudijaModel.setTrenutnaGodina(izborGodineStudija.getValue());
    }


}
