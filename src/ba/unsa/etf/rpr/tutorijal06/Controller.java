package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.apache.commons.validator.EmailValidator;
import org.controlsfx.validation.Severity;
import org.controlsfx.validation.ValidationMessage;
import org.controlsfx.validation.decoration.GraphicValidationDecoration;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

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
    public Button potvrda;
    public CheckBox boracka;

    public Controller(MjestoRodjenjaModel modelMjestaRodjenja, OdsjekModel modelOdsjeka, GodinaStudijaModel modelGodineStudija, CiklusModel modelCiklusa, StatusModel modelStatusa) {
        mjestoRodjenjaModel = modelMjestaRodjenja;
        odsjekModel = modelOdsjeka;
        godinaStudijaModel = modelGodineStudija;
        ciklusModel = modelCiklusa;
        statusModel = modelStatusa;
    }

    private boolean validnoImePrezime(String n) {
        if (n.length() < 1 || n.length() > 20) {
            return false;
        }
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) < 'A' || n.charAt(i) > 'Ž' && n.charAt(i) < 'a' || n.charAt(i) > 'ž') {
                return false;
            }
        }
        return true;
    }

    private boolean validanIndeks(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) < '0' || n.charAt(i) > '9') {
                return false;
            }
        }
        return n.length() == 5;
    }

    private boolean validanJmbg(String n) {
        if (n.length() != 13) {
            return false;
        }
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) < '0' || n.charAt(i) > '9') {
                return false;
            }
        }
        int L = 11 - ((7 * (n.charAt(0) - '0' + n.charAt(6) - '0') + 6 * (n.charAt(1) - '0' + n.charAt(7) - '0') + 5 * (n.charAt(2) - '0' + n.charAt(8) - '0') + 4 * (n.charAt(3) - '0' + n.charAt(9) - '0') + 3 * (n.charAt(4) - '0' + n.charAt(10) - '0') + 2 * (n.charAt(5) - '0' + n.charAt(11) - '0')) % 11);
        if (L > 9) {
            L = 0;
        }
        return L == (n.charAt(12) - '0');
    }

    private boolean validanKontaktTelefon(String n) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) < '0' || n.charAt(i) > '9') {
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
                    ime.getStyleClass().removeAll("poljeNijeIspravno", "poljeIspravno");
                    ime.getStyleClass().add("poljeIspravno");
                } else {
                    ime.getStyleClass().removeAll("poljeIspravno", "poljeNijeIspravno");
                    ime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        ime.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validnoImePrezime(ime.getCharacters().toString())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Rubrika ne smije biti prazna, smije sadržavati samo slova, maksimalno 20!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return ime;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(ime);
                }
            }
        });


        prezime.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validnoImePrezime(n)) {
                    prezime.getStyleClass().removeAll("poljeNijeIspravno", "poljeIspravno");
                    prezime.getStyleClass().add("poljeIspravno");
                } else {
                    prezime.getStyleClass().removeAll("poljeIspravno", "poljeNijeIspravno");
                    prezime.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        prezime.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validnoImePrezime(prezime.getCharacters().toString())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Rubrika ne smije biti prazna, smije sadržavati samo slova, maksimalno 20!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return prezime;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(prezime);
                }
            }
        });

        indeks.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanIndeks(n)) {
                    indeks.getStyleClass().removeAll("poljeNijeIspravno", "poljeIspravno");
                    indeks.getStyleClass().add("poljeIspravno");
                } else {
                    indeks.getStyleClass().removeAll("poljeIspravno", "poljeNijeIspravno");
                    indeks.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        indeks.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validanIndeks(indeks.getCharacters().toString())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Rubrika ne smije biti prazna, smije sadržavati samo brojeve (jedan petocifreni broj)!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return indeks;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(indeks);
                }
            }
        });

        jmbg.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanJmbg(n)) {
                    jmbg.getStyleClass().removeAll("poljeNijeIspravno", "poljeIspravno");
                    jmbg.getStyleClass().add("poljeIspravno");
                } else {
                    jmbg.getStyleClass().removeAll("poljeIspravno", "poljeNijeIspravno");
                    jmbg.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        jmbg.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validanJmbg(jmbg.getCharacters().toString())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Provjerite jeste li ispravno unijeli vaš JMBG!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return jmbg;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(jmbg);
                }
            }
        });

        datum.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validnostDatuma(datum.getValue())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Odaberite datum u skladu s vašim JMBG-om!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return datum;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(datum);
                }
            }
        });

        kontaktTelefon.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !validanKontaktTelefon(kontaktTelefon.getCharacters().toString())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Broj telefona mora sadržiti iskljčivo cifre u sebi!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return kontaktTelefon;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(kontaktTelefon);
                }
            }
        });

        email.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                EmailValidator validator = EmailValidator.getInstance();
                if (!n && !validator.isValid(email.getText())) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Ispravno unesite vašu e-mail adresu!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return email;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(email);
                }
            }
        });

        kontaktTelefon.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String o, String n) {
                if (validanKontaktTelefon(n)) {
                    kontaktTelefon.getStyleClass().removeAll("poljeNijeIspravno", "poljeIspravno");
                    kontaktTelefon.getStyleClass().add("poljeIspravno");
                } else {
                    kontaktTelefon.getStyleClass().removeAll("poljeIspravno", "poljeNijeIspravno");
                    kontaktTelefon.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        email.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> obs, String o, String n) {
                EmailValidator validator = EmailValidator.getInstance();
                if (validator.isValid(n)) {
                    email.getStyleClass().removeAll("poljeNijeIspravno", "poljeIspravno");
                    email.getStyleClass().add("poljeIspravno");
                } else {
                    email.getStyleClass().removeAll("poljeIspravno", "poljeNijeIspravno");
                    email.getStyleClass().add("poljeNijeIspravno");
                }
            }
        });

        izborMjestaRodjenja.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && (izborMjestaRodjenja.getValue() != null) && izborMjestaRodjenja.getEditor().getText().isEmpty()) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Odaberite izbor odsjeka!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return izborMjestaRodjenja;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(izborMjestaRodjenja);
                }
            }
        });

        izborOdsjeka.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !(izborOdsjeka.getValue() != null)) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Odaberite izbor odsjeka!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return izborOdsjeka;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(izborOdsjeka);
                }
            }
        });

        izborGodineStudija.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !(izborGodineStudija.getValue() != null)) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Odaberite godinu studija!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return izborGodineStudija;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(izborGodineStudija);
                }
            }
        });

        izborCiklusa.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !(izborCiklusa.getValue() != null)) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Odaberite ciklus studija!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return izborCiklusa;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(izborCiklusa);
                }
            }
        });

        izborStatusa.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean o, Boolean n) {
                GraphicValidationDecoration graphicValidationDecoration = new GraphicValidationDecoration();
                if (!n && !(izborStatusa.getValue() != null)) {
                    graphicValidationDecoration.applyValidationDecoration(new ValidationMessage() {
                        @Override
                        public String getText() {
                            return "Odaberite status studenta!";
                        }

                        @Override
                        public Severity getSeverity() {
                            return Severity.ERROR;
                        }

                        @Override
                        public Control getTarget() {
                            return izborStatusa;
                        }
                    });
                } else {
                    graphicValidationDecoration.removeDecorations(izborStatusa);
                }
            }
        });

        datum.getStyleClass().removeAll("poljeIspravno");
        datum.getStyleClass().add("poljeNijeIspravno");
    }


    public void date(ActionEvent actionEvent) {
        LocalDate datum1 = datum.getValue();
        if (validnostDatuma(datum1)) {
            datum.getStyleClass().removeAll("poljeNijeIspravno");
            datum.getStyleClass().add("poljeIspravno");
        } else {
            datum.getStyleClass().removeAll("poljeIspravno");
            datum.getStyleClass().add("poljeNijeIspravno");
        }
    }

    private boolean validnostDatuma(LocalDate datum1) {
        Date date = new Date();
        if (jmbg.getCharacters().toString().isEmpty()) {
            return false;
        }
        if (date.getYear() < datum1.getYear() && date.getMonth() < datum1.getMonth().getValue() && date.getDay() < datum1.getDayOfYear()) {
            return false;
        } else {
            if (Integer.parseInt(jmbg.getCharacters().toString().substring(4, 7)) < 900) {
                if (datum1.getYear() != Integer.parseInt("2" + jmbg.getCharacters().toString().substring(4, 7))) {
                    return false;
                }
            } else {
                if (datum1.getYear() != Integer.parseInt("1" + jmbg.getCharacters().toString().substring(4, 7))) {
                    return false;
                }
            }
            if (datum1.getMonth().getValue() != Integer.parseInt(jmbg.getCharacters().toString().substring(2, 4).replace("0", ""))) {
                return false;
            } else if (datum1.getDayOfMonth() != Integer.parseInt(jmbg.getCharacters().toString().substring(0, 2).replace("0", ""))) {
                return false;
            } else {
                return true;
            }
        }
    }

    public void potvrdi(ActionEvent actionEvent) {
        EmailValidator validator = EmailValidator.getInstance();
        if (validnoImePrezime(ime.getCharacters().toString()) && validnoImePrezime(prezime.getCharacters().toString()) && validanIndeks(indeks.getCharacters().toString()) && validanJmbg(jmbg.getCharacters().toString()) && validnostDatuma(datum.getValue()) && validanKontaktTelefon(kontaktTelefon.getCharacters().toString()) && validator.isValid(email.getText()) && (izborMjestaRodjenja.getValue() != null) && !(izborStatusa.getValue() == null) && !(izborCiklusa.getValue() == null) && !(izborGodineStudija.getValue() == null) && !(izborOdsjeka.getValue() == null)) {
            potvrda.getStyleClass().removeAll("poljeNijeIspravno");
            potvrda.getStyleClass().add("poljeIspravno");
            System.out.print("Ime: " + ime.getCharacters().toString() + "\n");
            System.out.print("Prezime: " + prezime.getCharacters().toString() + "\n");
            System.out.print("Broj indeksa: " + indeks.getCharacters().toString() + "\n");
            System.out.print("JMBG: " + jmbg.getCharacters().toString() + "\n");
            System.out.print("Datum rođenja: " + datum.getValue() + "\n");
            System.out.print("Mjesto rođenja: " + izborMjestaRodjenja.getValue() + "\n");
            if (!kontaktAdresa.getCharacters().toString().isEmpty()) {
                System.out.print("Kontakt adresa: " + kontaktAdresa.getCharacters().toString() + "\n");
            }
            if (!kontaktTelefon.getCharacters().toString().isEmpty()) {
                System.out.print("Kontakt telefon: " + kontaktTelefon.getCharacters().toString() + "\n");
            }
            System.out.print("E-mail adresa: " + email.getCharacters().toString() + "\n");
            System.out.print("Odsjek: " + izborOdsjeka.getValue() + "\n");
            System.out.print("Godina studija: " + izborGodineStudija.getValue() + "\n");
            System.out.print("Ciklus studija: " + izborCiklusa.getValue() + "\n");
            System.out.print("Status: " + izborStatusa.getValue() + "\n");
            if (boracka.isSelected()) {
                System.out.print("Pripada boračkim kategorijama" + "\n");
            } else {
                System.out.print("Ne pripada boračkim kategorijama" + "\n");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Neispravna forma");
            alert.setResizable(false);
            alert.setContentText("Unesite potrebne podatke!");
            Optional<ButtonType> result = alert.showAndWait();
        }
    }

}
