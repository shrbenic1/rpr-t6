package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GodinaStudijaModel {
    private ObservableList<GodinaStudija> godineStudija = FXCollections.observableArrayList();
    private ObjectProperty<GodinaStudija> trenutnaGodina = new SimpleObjectProperty<>();

    public void setTrenutnaGodina(GodinaStudija trenutnaGodina) {
        this.trenutnaGodina.set(trenutnaGodina);
    }

    public ObservableList<GodinaStudija> getGodineStudija() {
        return godineStudija;
    }

    public GodinaStudija getTrenutnaGodina() {
        return trenutnaGodina.get();
    }

    public ObjectProperty<GodinaStudija> trenutnaGodinaProperty() {
        return trenutnaGodina;
    }

    public void dodajGodine() {
        godineStudija.add(new GodinaStudija("Prva"));
        godineStudija.add(new GodinaStudija("Druga"));
        godineStudija.add(new GodinaStudija("Treća"));
    }
}
