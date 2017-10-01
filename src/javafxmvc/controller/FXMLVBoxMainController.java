/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;


/**
 * FXML Controller class
 *
 * @author brenothales
 */
public class FXMLVBoxMainController implements Initializable {
    
    @FXML
    private MenuItem menuItemCadastroClientes;
    @FXML
    private MenuItem menuItemProcessosVendas;
    @FXML
    private MenuItem menuItemGraficosVendasporMes;
    
    @FXML
    private MenuItem anchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
