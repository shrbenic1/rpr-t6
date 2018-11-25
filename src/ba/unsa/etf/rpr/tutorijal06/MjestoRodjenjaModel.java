package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MjestoRodjenjaModel {
    private ObservableList<MjestoRodjenja> mjestaRodjenja = FXCollections.observableArrayList();
    private ObjectProperty<MjestoRodjenja> trenutnoMjestoRodjenja = new SimpleObjectProperty<>();

    public void setTrenutnoMjestoRodjenja(MjestoRodjenja trenutnoMjestoRodjenja) {
        this.trenutnoMjestoRodjenja.set(trenutnoMjestoRodjenja);
    }

    public ObservableList<MjestoRodjenja> getMjestaRodjenja() {
        return mjestaRodjenja;
    }

    public MjestoRodjenja getTrenutnoMjestoRodjenja() {
        return trenutnoMjestoRodjenja.get();
    }

    public ObjectProperty<MjestoRodjenja> trenutnoMjestoRodjenjaProperty() {
        return trenutnoMjestoRodjenja;
    }

    public void dodajMjestaRodjenja() {
        mjestaRodjenja.add(new MjestoRodjenja("Sarajevo"));
        mjestaRodjenja.add(new MjestoRodjenja("Banja Luka"));
        mjestaRodjenja.add(new MjestoRodjenja("Tuzla"));
        mjestaRodjenja.add(new MjestoRodjenja("Mostar"));
        mjestaRodjenja.add(new MjestoRodjenja("Zenica"));
        mjestaRodjenja.add(new MjestoRodjenja("Bihać"));
        mjestaRodjenja.add(new MjestoRodjenja("Doboj"));
    }
}
