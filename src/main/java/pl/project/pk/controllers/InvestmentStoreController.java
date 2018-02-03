package pl.project.pk.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.omg.CORBA.portable.ApplicationException;
import pl.project.pk.mapper.ClientMapper;
import pl.project.pk.mapper.InvestmentMapper;
import pl.project.pk.models.InvestmentModel;
import pl.project.pk.utils.ModalUtils;

public class InvestmentStoreController {

    @FXML
    public TableView<InvestmentMapper> investmentTableView;

    @FXML
    public TableColumn<InvestmentMapper, ClientMapper> firstNameClient;

    @FXML
    public TableColumn<InvestmentMapper, String> investmentCategory;

    @FXML
    public TableColumn<InvestmentMapper, String> investmentAmout;

    private InvestmentModel investmentModel;

    @FXML
    void initialize(){
        this.investmentModel = new InvestmentModel();
        try {
            this.investmentModel.initStore();

        } catch (ApplicationException e) {
            System.out.println("dasdaads");
            ModalUtils.modalError(e.getMessage());
        }

        this.bindingToTable();
    }

    private void bindingToTable() {
        this.investmentTableView.setItems(this.investmentModel.getInvestmentMapperObservableList());
        this.firstNameClient.setCellValueFactory(cellData -> cellData.getValue().clientMapperProperty());
        this.investmentCategory.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());
        this.investmentAmout.setCellValueFactory(cellData -> cellData.getValue().amountProperty());
    }
}
