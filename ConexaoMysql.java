/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newdesign.gestaovenda.modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public class ConexaoMysql implements Conexao{
    
    private final String DRIVE = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/gestao_venda1?useTimezone=true&serverTimezone=America/Rio_de_Janeiro";
    private final String USUARIO = "root";
    private final String SENHA = "password";
   
    private Connection conectar;
    
    @Override
    public Connection obterConexao() throws SQLException {
        if(conectar == null) {
            conectar = DriverManager.getConnection("jdbc:mysql://localhost/gestao_venda1", USUARIO, SENHA);
        }
        return conectar;
    }
    
}
