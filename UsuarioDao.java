/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newdesign.gestaovenda.modelo.dao;

import com.newdesign.gestaovenda.modelo.conexao.Conexao;
import com.newdesign.gestaovenda.modelo.conexao.ConexaoMysql;
import com.newdesign.gestaovenda.modelo.dominio.Perfil;
import com.newdesign.gestaovenda.modelo.dominio.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author vinic
 */
public class UsuarioDao {
    
    private final Conexao conexao;

    public UsuarioDao() {
        this.conexao = new ConexaoMysql();
    }
    
    
    public String salvar(Usuario usuario){
        return usuario.getid() == 0 ? adicionar(usuario) : editar(usuario);
    }

    private String adicionar(Usuario usuario) {
       String sql = "INSERT INTO usuario(nome, usuario, senha, perfil, estado)  VALUES(?, ?, ?, ?, ?)"; 
       
       Usuario usuarioTemp = buscarUsuarioPeloUsuario(usuario.getUsuario());
       
       if(usuarioTemp !=null){
           return String.format("Error: usuario %s ja existe no banco de dados", usuario.getUsuario());
       }
       
        try {
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, usuario);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Usuario adicionado com sucesso" : "Nao foi possivel adicionar usuario";
        } catch (SQLException e) {
            return String.format("Error; %s", e.getMessage());
        }
    }

    private String editar(Usuario usuario) {try {
        String sql = "UPDATE usuario SET nome = ?, usuario = ?, senha = ?, perfil = ?, estado = ?  WHERE id = ?";
            PreparedStatement preparedStatement = conexao.obterConexao().prepareStatement(sql);
            
            preencherValoresPreparedStatement(preparedStatement, usuario);
            
            int resultado = preparedStatement.executeUpdate();
            
            return resultado == 1 ? "Usuario editado com sucesso" : "Nao foi possivel editar usuario";
        } catch (SQLException e) {
            return String.format("Error; %s", e.getMessage());
        }
        }

    private void preencherValoresPreparedStatement(PreparedStatement preparedStatement, Usuario usuario) throws SQLException {
        
       BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        String senhaCrypt = passwordEncoder.encode(usuario.getSenha());
        
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getUsuario());
        preparedStatement.setString(3, senhaCrypt);
        preparedStatement.setString(4, usuario.getPerfil().name());
        preparedStatement.setBoolean(5,usuario.isEstado());
        
        if(usuario.getId() != 0L ) {
            preparedStatement.setLong(6, usuario.getId());
        }   
    }
    
    
    
    public List<Usuario> buscarTodosUsuarios(){
        String sql ="SELECT * FROM usuario";
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            while(result.next()){
                usuarios.add(getUsuario(result));
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: ", e.getMessage()));
        }
        return usuarios;
    }
    
    private Usuario getUsuario(ResultSet result) throws SQLException{
        Usuario usuario = new Usuario();
        
        usuario.setId(result.getLong("id"));
        usuario.setNome(result.getString("nome"));
        usuario.setUsuario(result.getString("usuario"));
        usuario.setSenha(result.getString("senha"));
        usuario.setPerfil(Perfil.valueOf(result.getString("perfil")));
        usuario.setEstado(result.getBoolean("estado"));
        usuario.setDataHoraCriacao(result.getObject("data_hora_criacao",LocalDateTime.class));
        usuario.setUltimoLogin(result.getObject("ultimo_login", LocalDateTime.class));
        
        return usuario;
    }
    
    public Usuario buscarUsuarioPeloId(Long id){
        String sql = String.format("SELECT * FROM usuario WHERE id = %d", id);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()){
                return getUsuario(result);
            }
        } catch (SQLException e) {
            System.out.println(String.format("Error: ", e.getMessage()));
        }
        return null;
    }
    
    public Usuario buscarUsuarioPeloUsuario(String usuario){
        String sql = String.format("SELECT * FROM usuario WHERE usuario = '%s'", usuario);
        System.out.println(sql);
        
        try {
            ResultSet result = conexao.obterConexao().prepareStatement(sql).executeQuery();
            
            if(result.next()){
                return getUsuario(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(String.format("Error: ", e.getMessage()));
        }
        return null;
    }
    
}
    

