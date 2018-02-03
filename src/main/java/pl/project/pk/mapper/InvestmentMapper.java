package pl.project.pk.mapper;


import javafx.beans.property.*;

public class InvestmentMapper {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty category = new SimpleStringProperty();
    private ObjectProperty<ClientMapper> clientMapper = new SimpleObjectProperty<>();
    private StringProperty amount = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
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

    public ClientMapper getClientMapper() {
        return clientMapper.get();
    }

    public ObjectProperty<ClientMapper> clientMapperProperty() {
        return clientMapper;
    }

    public void setClientMapper(ClientMapper clientMapper) {
        this.clientMapper.set(clientMapper);
    }

    public String getAmount() {
        return amount.get();
    }

    public StringProperty amountProperty() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }
}
