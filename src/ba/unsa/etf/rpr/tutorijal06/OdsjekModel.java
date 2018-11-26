package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OdsjekModel {
    private ObservableList<Odsjek> odsjeci = FXCollections.observableArrayList();
    private ObjectProperty<Odsjek> trenutniOdsjek = new SimpleObjectProperty<>();

    public void setTrenutniOdsjek(Odsjek trenutniOdsjek) {
        this.trenutniOdsjek.set(trenutniOdsjek);
    }

    public ObservableList<Odsjek> getOdsjeci() {
        return odsjeci;
    }

    public Odsjek getTrenutniOdsjek() {
        return trenutniOdsjek.get();
    }

    public ObjectProperty<Odsjek> trenutniOdsjekProperty() {
        return trenutniOdsjek;
    }

    public void dodajOdsjeke() {
        odsjeci.add(new Odsjek("AE"));
        odsjeci.add(new Odsjek("RI"));
        odsjeci.add(new Odsjek("EE"));
        odsjeci.add(new Odsjek("TK"));
    }
}
