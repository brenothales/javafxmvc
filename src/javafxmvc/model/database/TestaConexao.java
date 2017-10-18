/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxmvc.model.database;

import java.sql.Connection; 
import java.sql.SQLException;

/**
 *
 * @author brenothales
 */
public class TestaConexao {     
    public static void main(String[] args) throws SQLException {
        try (Connection connection = new DatabaseMySQL().conectar()) {
            System.out.println("Conexão aberta!");
        }
     }
}