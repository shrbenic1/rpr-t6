package ba.unsa.etf.rpr.tutorijal06;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Controller {
    private MjestoRodjenjaModel mjestoRodjenjaModel;
    public ComboBox<MjestoRodjenja> izborMjestaRodjenja;

    public Controller(MjestoRodjenjaModel modelMjestaRodjenja) {
        mjestoRodjenjaModel=modelMjestaRodjenja;
    }

    @FXML
    public void initialize() {
        izborMjestaRodjenja.setItems(mjestoRodjenjaModel.getMjestaRodjenja());
    }

    public void promjenaKnjige(ActionEvent actionEvent) {
        mjestoRodjenjaModel.setTrenutnoMjestoRodjenja(izborMjestaRodjenja.getValue());
    }
}
