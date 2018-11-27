package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;

public class MjestoRodjenja {
    private SimpleStringProperty mjestoRodjenja = new SimpleStringProperty("");

    public MjestoRodjenja(String mjestoRodjenja) {
        this.mjestoRodjenja = new SimpleStringProperty(mjestoRodjenja);
    }

    public MjestoRodjenja() {
    }

    public String getMjestoRodjenja() {
        return mjestoRodjenja.get();
    }

    public void setMjestoRodjenja(String mjestoRodjenja) {
        this.mjestoRodjenja.set(mjestoRodjenja);
    }

    public SimpleStringProperty mjestoRodjenjaProperty() {
        return mjestoRodjenja;
    }

    @Override
    public String toString() {
        return mjestoRodjenja.get();
    }
}
