package pl.project.pk.mapper;


import javafx.beans.property.*;

public class InvestmentMapper {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty client_id = new SimpleStringProperty();
    private StringProperty category = new SimpleStringProperty();
    private LongProperty amout = new SimpleLongProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getClient_id() {
        return client_id.get();
    }

    public StringProperty client_idProperty() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id.set(client_id);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public long getAmout() {
        return amout.get();
    }

    public LongProperty amoutProperty() {
        return amout;
    }

    public void setAmout(long amout) {
        this.amout.set(amout);
    }
}
