package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;

public class Odsjek {
    private SimpleStringProperty odsjek = new SimpleStringProperty("");

    public Odsjek(String odsjek) {
        this.odsjek = new SimpleStringProperty(odsjek);
    }

    public Odsjek() {
    }

    public String getOdsjek() {
        return odsjek.get();
    }

    public void setOdsjek(String odsjek) {
        this.odsjek.set(odsjek);
    }

    public SimpleStringProperty odsjekProperty() {
        return odsjek;
    }

    @Override
    public String toString() {
        return odsjek.get();
    }
}
