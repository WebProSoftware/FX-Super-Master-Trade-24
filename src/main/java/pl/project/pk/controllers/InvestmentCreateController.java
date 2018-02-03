package pl.project.pk.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.omg.CORBA.portable.ApplicationException;
import pl.project.pk.mapper.ClientMapper;
import pl.project.pk.models.ClientModel;
import pl.project.pk.models.InvestmentModel;
import pl.project.pk.utils.FxmlUtils;
import pl.project.pk.utils.ModalUtils;
import pl.project.pk.utils.factory.InvestmentFactoryMethod;
import pl.project.pk.utils.investment.InvestmentBase;

import java.util.ResourceBundle;

public class InvestmentCreateController {

    private static final String FXML_STORE_INVESTMENTS_FXML = "/fxml/store/Investments.fxml";

    @FXML
    public ComboBox <ClientMapper> clientList;

    @FXML
    public TextField typeMutual;

    @FXML
    public TextField amount;

    @FXML
    public TextField clientSalary;

    @FXML
    public Button saveButton;

    private ClientModel clientModel;
    private InvestmentModel investmentModel;

    private static ResourceBundle bundle = FxmlUtils.getResourceBundle();

    @FXML
    private void initialize() throws ApplicationException {
        this.clientModel = new ClientModel();
        this.investmentModel = new InvestmentModel();
        try {
            this.clientModel.init();
            this.investmentModel.init();
        } catch (ApplicationException e) {
            e.printStackTrace();
        };

        this.clientList.setItems(clientModel.getClientMapperObservableList());
    }

    public void saveButton(ActionEvent actionEvent) throws ApplicationException {
        if (this.isValid()) {
            this.investmentModel.saveInvestmentInDataBase(
                    this.clientList.getSelectionModel().getSelectedItem(),
                    this.typeMutual.getText(),
                    this.amount.getText()
            );
        }
        this.clearAll();
    }

    private void clearAll() {
        this.clientList.getSelectionModel().clearSelection();
        this.typeMutual.clear();
        this.amount.clear();
        this.clientSalary.clear();
    }

    public void onActionComboBox(ActionEvent actionEvent) {
        if(this.clientList.getSelectionModel().getSelectedItem() != null){
            this.clientModel.setClientMapperObjectProperty(this.clientList.getSelectionModel().getSelectedItem());
            Integer salary = Integer.parseInt(this.clientList.getSelectionModel().getSelectedItem().getSalary());
            InvestmentBase investment = null;

        /* FactoryMethod, Decorator desing pattern */
            InvestmentFactoryMethod investmentFactoryMethod = new InvestmentFactoryMethod();

            if(salary > 0 && salary <= 1500) {
                investment =  investmentFactoryMethod.makeLokata();
            }

            if(salary > 1500 && salary <= 3000) {
                investment = investmentFactoryMethod.makeFundusz();
            }

            if(salary > 3000) {
                investment = investmentFactoryMethod.makeForex();
            }

            this.clientSalary.setText( Integer.toString(salary) );
            this.typeMutual.setText(investment.nazwaInwestycji());
        }
    }

    private boolean isValid(){
        Integer clientAmout = 0;
        Integer amountMutal = 0;

        if (this.clientSalary.getText().length() != 0 ){
            clientAmout = Integer.parseInt(this.clientSalary.getText());
        }

        if (this.amount.getText().length() != 0) {
            amountMutal = Integer.parseInt(this.amount.getText());
        }

        if (clientAmout == 0){
            ModalUtils.modalError(bundle.getString("error.client.none"));
            return false;
        }

        if (amountMutal == 0){
            ModalUtils.modalError(bundle.getString("error.amountNull"));
            return false;
        }

        if (amountMutal > clientAmout){
            ModalUtils.modalError(bundle.getString("error.amountBad"));
            return false;
        }

        return true;
    }
}
