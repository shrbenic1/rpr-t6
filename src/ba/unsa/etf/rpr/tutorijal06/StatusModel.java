package ba.unsa.etf.rpr.tutorijal06;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StatusModel {
    private ObservableList<Status> statusi = FXCollections.observableArrayList();
    private ObjectProperty<Status> trenutniStatusi = new SimpleObjectProperty<>();

    public void setTrenutniStatusi(Status trenutniStatusi) {
        this.trenutniStatusi.set(trenutniStatusi);
    }

    public ObservableList<Status> getStatusi() {
        return statusi;
    }

    public Status getTrenutniStatusi() {
        return trenutniStatusi.get();
    }

    public ObjectProperty<Status> trenutniStatusiProperty() {
        return trenutniStatusi;
    }

    public void dodajOdsjeke() {
        statusi.add(new Status("Redovan"));
        statusi.add(new Status("Samofinansirajući"));
    }
}
