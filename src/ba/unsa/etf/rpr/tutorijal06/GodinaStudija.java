package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.SimpleStringProperty;

public class GodinaStudija {
    private SimpleStringProperty godinaStudija = new SimpleStringProperty("");

    public GodinaStudija(String godinaStudija) {
        this.godinaStudija = new SimpleStringProperty (godinaStudija);
    }

    public GodinaStudija() {
    }

    public String getGodinaStudija() {
        return godinaStudija.get();
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija.set(godinaStudija);
    }

    public SimpleStringProperty godinaStudijaProperty() {
        return godinaStudija;
    }

    @Override
    public String toString() {
        return godinaStudija.get();
    }
}
