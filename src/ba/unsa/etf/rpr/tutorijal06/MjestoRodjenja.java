package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;

public class MjestoRodjenja {
    private SimpleStringProperty mjestoRodjenja;

    public MjestoRodjenja(SimpleStringProperty mjestoRodjenja) {
        this.mjestoRodjenja = mjestoRodjenja;
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
}
