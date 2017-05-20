/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Binho
 */
public class FactoryConnection {
    //Atributos de conexão com banco

     //private static final String url = "jdbc:mysql://localhost:3306/javaweb";
    private static final String url = "jdbc:derby://localhost:1527/javaweb";
    private static final String usuario = "root";
    private static final String senha = "root";

    //Método Estático que gera a conexão com o banco
    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }

    FactoryConnection createStatement() {
        throw new UnsupportedOperationException("Erro de conexão"); //To change body of generated methods, choose Tools | Templates.
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Erro de conexão"); //To change body of generated methods, choose Tools | Templates.
    }
}
