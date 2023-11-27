/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newdesign.gestaovenda.modelo.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinic
 */
public class ConnectionFactory {
    
    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/gestao_venda1?useTimezone=true&serverTimezone=America/Rio_de_Janeiro";
    private static String USER = "root";
    private static String PASS = "password";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection("jdbc:mysql://localhost/gestao_venda1", USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
           throw new RuntimeException("Erro na conexão:",ex);
        }
    }
    
    public static void closeConnection (Connection con){
        try {
            if(con!=null){
                con.close();
            }    
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection (Connection con, PreparedStatement stmt){
        
        closeConnection(con);
        
        try {
              
            if(stmt !=null){
                stmt.close();
            }
            
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void closeConnection (Connection con, PreparedStatement stmt, ResultSet rs){
        
        closeConnection(con, stmt);
        
        try {
              
            if(rs !=null){
                rs.close();
            }
            
        } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
