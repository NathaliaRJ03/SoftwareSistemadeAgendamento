/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.newdesign.gestaovenda;

import com.newdesign.gestaovenda.modelo.conexao.Conexao;
import com.newdesign.gestaovenda.modelo.conexao.ConexaoMysql;
import com.newdesign.gestaovenda.modelo.dominio.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class GestaoVenda {

    public static void main(String[] args)  throws SQLException{
        
        String sql= "Select * from categoria";
        
        Conexao conexao = new ConexaoMysql();
        
        Categoria categoria = new Categoria(null,"Bebida java01","insercao no netbeans");
        
        String inserirSQL = "INSERT INTO categoria(nome, descricao) VALUES(?, ?)";
        
        PreparedStatement prepareStatement = conexao.obterConexao().prepareStatement(inserirSQL);
        
        prepareStatement.setString(1, categoria.getNome());
        prepareStatement.setString(2, categoria.getDescricao());
        
        
        int resultadoDoCadastro = prepareStatement.executeUpdate();
        
        System.out.println(resultadoDoCadastro);
        
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
        
        while(result.next()) {
            System.out.println(result.getString("nome"));
        }}
        
        
}
