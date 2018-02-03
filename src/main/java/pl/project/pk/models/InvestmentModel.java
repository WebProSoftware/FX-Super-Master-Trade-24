package pl.project.pk.models;


import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.omg.CORBA.portable.ApplicationException;
import pl.project.pk.database.dao.ClientDao;
import pl.project.pk.database.dao.InvestmentDao;
import pl.project.pk.database.dbutils.DbManager;
import pl.project.pk.database.models.Client;
import pl.project.pk.database.models.Investment;
import pl.project.pk.mapper.ClientMapper;
import pl.project.pk.utils.converters.ConventerClient;

import java.util.List;

public class InvestmentModel {

    private ObservableList<ClientMapper> clientMapperObservableList = FXCollections.observableArrayList();


    public void init() throws ApplicationException {
        ClientDao clientDao = new ClientDao(DbManager.getConnectionSource());
        List<Client> clients = clientDao.queryForAll(Client.class);
        InvestmentDao investmentDao = new InvestmentDao(DbManager.getConnectionSource());

        this.clientMapperObservableList.clear();
        clients.forEach(client -> {
            ClientMapper clientMapper = ConventerClient.convertToClientMapper(client);
            this.clientMapperObservableList.add(clientMapper);
        });
        DbManager.closeConnectionDB();
    }


    public ObservableList<ClientMapper> getClientMapperObservableList() {
        return clientMapperObservableList;
    }

    public void setClientMapperObservableList(ObservableList<ClientMapper> clientMapperObservableList) {
        this.clientMapperObservableList = clientMapperObservableList;
    }

    public void saveInvestmentInDataBase(ClientMapper clientMapper, String typeMutal, String amout) throws ApplicationException {
        Long amoutLong = Long.parseLong(amout);

        ClientDao clientDao = new ClientDao(DbManager.getConnectionSource());
        Client client = clientDao.findById(Client.class, clientMapper.getId());

        InvestmentDao investmentDao = new InvestmentDao(DbManager.getConnectionSource());
        Investment investment = new Investment();

        investment.setClient(client);
        investment.setCategory(typeMutal);
        investment.setAmount(amoutLong);

        investmentDao.createOrUpdate(investment);
        DbManager.closeConnectionDB();

    }
}
