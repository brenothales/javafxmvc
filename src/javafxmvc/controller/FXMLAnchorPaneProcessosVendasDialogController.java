/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc.controller;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafxmvc.model.dao.ClienteDAO;
import javafxmvc.model.dao.ProdutoDAO;
import javafxmvc.model.database.Database;
import javafxmvc.model.database.DatabaseFactory;
import javafxmvc.model.domain.Cliente;
import javafxmvc.model.domain.ItemDeVenda;
import javafxmvc.model.domain.Produto;
import javafxmvc.model.domain.Venda;

/**
 * FXML Controller class
 *
 * @author brenothales
 */
public class FXMLAnchorPaneProcessosVendasDialogController implements Initializable {

    @FXML
    private ComboBox comboBoxVendaCliente;
    @FXML
    private DatePicker datePickerVendaData;
    @FXML
    private CheckBox checkBoxVendaPago;
    @FXML
    private ComboBox comboBoxVendaProduto;
    @FXML
    private TableView<ItemDeVenda> tableViewItensDeVenda;
    @FXML
    private TableColumn<ItemDeVenda, Produto> tableColumnItemDeVendaProduto;
    @FXML
    private TableColumn<ItemDeVenda, Integer> tableColumnItemDeVendaQuantidade;
    @FXML
    private TableColumn<ItemDeVenda, Double> tableColumnItemDeVendaValor;
    @FXML
    private TextField textFieldVendaValor;
    @FXML
    private TextField textFieldVendaItemDeVendaQuantidade;
    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;
    @FXML
    private Button buttonAdicionar;

    
    
    private List<Cliente> listClientes;
    private List<Produto> listProdutos;
    private ObservableList<Cliente> observableListClientes;
    private ObservableList<Produto> observableListProdutos;
    private ObservableList<ItemDeVenda> observableListItensDeVenda;
    
   
    //Atributos para manipulação de Banco de Dados
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Venda venda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clienteDAO.setConnection(connection);
        produtoDAO.setConnection(connection);
        carregarComboBoxClientes();
        carregarComboBoxProdutos();
        tableColumnItemDeVendaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        tableColumnItemDeVendaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        tableColumnItemDeVendaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    }
    public void carregarComboBoxClientes() {
        listClientes = clienteDAO.listar();
        observableListClientes = FXCollections.observableArrayList(listClientes);
        comboBoxVendaCliente.setItems(observableListClientes);
    }

    public void carregarComboBoxProdutos() {
        listProdutos = produtoDAO.listar();
        observableListProdutos = FXCollections.observableArrayList(listProdutos);
        comboBoxVendaProduto.setItems(observableListProdutos);
    }
    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Venda getVenda() {
        return this.venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }
