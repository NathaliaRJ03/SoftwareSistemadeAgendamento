/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.newdesign.gestaovenda.modelo.conexao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author vinic
 */
public interface Conexao {
    
    public Connection obterConexao() throws SQLException;
}
