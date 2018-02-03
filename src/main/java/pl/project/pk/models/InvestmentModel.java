package pl.project.pk.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.omg.CORBA.portable.ApplicationException;
import pl.project.pk.database.dao.ClientDao;
import pl.project.pk.database.dao.InvestmentDao;
import pl.project.pk.database.dbutils.DbManager;
import pl.project.pk.database.models.Client;
import pl.project.pk.database.models.Investment;
import pl.project.pk.mapper.ClientMapper;
import pl.project.pk.mapper.InvestmentMapper;
import pl.project.pk.utils.converters.ConventerClient;
import pl.project.pk.utils.converters.ConventerInvestition;

import java.util.List;

public class InvestmentModel {

    private ObservableList<ClientMapper> clientMapperObservableList = FXCollections.observableArrayList();
    private ObservableList<InvestmentMapper> investmentMapperObservableList = FXCollections.observableArrayList();

    public void initStore() throws ApplicationException {
        InvestmentDao investmentDao = new InvestmentDao(DbManager.getConnectionSource());
        List<Investment> investments = investmentDao.queryForAll(Investment.class);
        investments.forEach(investment -> {
            InvestmentMapper investmentMapper = ConventerInvestition.converToInvestmentMapper(investment);
            this.investmentMapperObservableList.add(investmentMapper);
        });

        DbManager.closeConnectionDB();
    }

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

    public ObservableList<InvestmentMapper> getInvestmentMapperObservableList() {
        return investmentMapperObservableList;
    }

    public void setInvestmentMapperObservableList(ObservableList<InvestmentMapper> investmentMapperObservableList) {
        this.investmentMapperObservableList = investmentMapperObservableList;
    }
}
