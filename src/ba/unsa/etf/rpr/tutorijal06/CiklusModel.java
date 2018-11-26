package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CiklusModel {
    private ObservableList<Ciklus> ciklusi = FXCollections.observableArrayList();
    private ObjectProperty<Ciklus> trenutniCiklus = new SimpleObjectProperty<>();

    public void setTrenutniCiklus(Ciklus trenutniCiklus) {
        this.trenutniCiklus.set(trenutniCiklus);
    }

    public ObservableList<Ciklus> getCiklusi() {
        return ciklusi;
    }

    public Ciklus getTrenutniCiklus() {
        return trenutniCiklus.get();
    }

    public ObjectProperty<Ciklus> trenutniCiklusProperty() {
        return trenutniCiklus;
    }

    public void dodajOdsjeke() {
        ciklusi.add(new Ciklus("AE"));
        ciklusi.add(new Ciklus("RI"));
        ciklusi.add(new Ciklus("EE"));
        ciklusi.add(new Ciklus("TK"));
    }
}
