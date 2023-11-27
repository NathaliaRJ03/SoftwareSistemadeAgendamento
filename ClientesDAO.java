/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newdesign.gestaovenda.modelo.dao;

import com.newdesign.gestaovenda.modelo.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Clientes;

/**
 *
 * @author vinic
 */
public class ClientesDAO {
    
    public void create(Clientes c){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO clientes(nome,telefone,endereco,pedido,data_entrega)VALUES(?,?,?,?,?)");
            stmt.setString(1,c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getPedido());
            stmt.setString(5, c.getData_entrega());
            
            stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error ao salvar:"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }

   public List<Clientes> read(){
       
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Clientes> clientess = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM clientes");
            rs = stmt.executeQuery();
            
            while(rs.next()){
            
                Clientes clientes = new Clientes();
                
                clientes.setId(rs.getInt("id"));
                clientes.setNome(rs.getString("nome"));
                clientes.setTelefone(rs.getString("telefone"));
                clientes.setEndereco(rs.getString("endereco"));
                clientes.setPedido(rs.getString("pedido"));
                clientes.setData_entrega(rs.getString("data_entrega"));
                clientess.add(clientes);
            }
            
        } catch (SQLException ex) {
            
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
   
        return clientess;
         
   }

   public void update(Clientes c){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE clientes SET nome = ?,telefone = ?,endereco = ?,pedido = ?,data_entrega = ? WHERE id = ?");
            stmt.setString(1,c.getNome());
            stmt.setString(2, c.getTelefone());
            stmt.setString(3, c.getEndereco());
            stmt.setString(4, c.getPedido());
            stmt.setString(5, c.getData_entrega());
            stmt.setInt(6, c.getId());
            stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error ao atualizar:"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
   public void delete(Clientes c){
        
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM clientes WHERE id = ?");
            stmt.setInt(1, c.getId());
            stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error ao excluir:"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }

    
   
    

    

    
 
    
}
