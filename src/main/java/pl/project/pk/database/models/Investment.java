package pl.project.pk.database.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "INVESTMENTS")
public class Investment implements BaseModel {

    public Investment() {

    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(columnName = "client_id", foreign = true, foreignAutoRefresh = true, foreignAutoCreate = true, canBeNull = false)
    private Client client;

    @DatabaseField(columnName = "category", canBeNull = false)
    private String category;

    @DatabaseField(columnName = "amount", canBeNull = false)
    private Long amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
