/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newdesign.gestaovenda;

import com.newdesign.gestaovenda.modelo.conexao.Conexao;
import com.newdesign.gestaovenda.modelo.conexao.ConexaoMysql;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class Main {

    public static void main(String[] args)  throws SQLException{
        
        String sql= "Select * from categoria";
        
        Conexao conexao = new ConexaoMysql();
        
        ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
        
        while(result.next()) {
            System.out.println(result.getString("nome"));
        }}
        
        
}
    
