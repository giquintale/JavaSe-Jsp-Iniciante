/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Dao;

import br.com.factory.FactoryConnection;
import br.com.model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Huilton
 */
public class PessoaDao {

    FactoryConnection factoryConnection = new FactoryConnection();
    Connection connection;

    public PessoaDao() throws SQLException {
        this.connection = factoryConnection.getConexao();
    }

    public boolean cadastrar(Pessoa pessoa) throws SQLException {

        try {
            String sql = "insert into root.pessoa(nome) VALUES(?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, pessoa.getNome());
            ps.execute();
            ps.close();
            return true;

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao cadastrar Pessoa no Banco de Dados" + ex);
        }
    }

    public ArrayList<Pessoa> listar() throws SQLException {
        String sql = "select * from pessoa";
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setCodigo(rs.getInt("codigo"));
            pessoa.setNome(rs.getString("nome"));
            listaPessoas.add(pessoa);
        }
        return listaPessoas;
    }
}
