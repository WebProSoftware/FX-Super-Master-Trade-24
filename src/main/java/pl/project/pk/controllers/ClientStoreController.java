package pl.project.pk.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.omg.CORBA.portable.ApplicationException;
import pl.project.pk.mapper.ClientMapper;
import pl.project.pk.models.ClientModel;

public class ClientStoreController {

    @FXML
    private TableView<ClientMapper> clientTableView;

    @FXML
    private TableColumn<ClientMapper, String> firstNameColumn;

    @FXML
    private TableColumn<ClientMapper, String> lastNameColumn;

    @FXML
    private TableColumn<ClientMapper, String> addressColumn;

    @FXML
    private TableColumn<ClientMapper, String> salaryColumn;

    @FXML
    private TableColumn<ClientMapper, String> emailColumn;

    @FXML
    private TableColumn<ClientMapper, String> phoneColumn;

    private ClientModel clientModel;


    public void initialize(){
        this.clientModel = new ClientModel();

        try {
            this.clientModel.init();

        } catch (ApplicationException e) {
            e.printStackTrace();
            //TODO klasa z wlasnymi wyjatkami
        }

        bindingsTableView();
    }

    private void bindingsTableView() {
        this.clientTableView.setItems(this.clientModel.getClientMapperObservableList());

        this.firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        this.lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastnameProperty());
        this.addressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
        this.salaryColumn.setCellValueFactory(cellData -> cellData.getValue().salaryProperty());
        this.emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        this.phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

    }

}
