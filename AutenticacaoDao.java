/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newdesign.gestaovenda.modelo.dao;

import com.newdesign.gestaovenda.modelo.dominio.Perfil;
import com.newdesign.gestaovenda.modelo.dominio.Usuario;
import com.newdesign.gestaovenda.modelo.exception.NegocioException;
import com.newdesign.gestaovenda.view.modelo.LoginDto;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author vinic
 */
public class AutenticacaoDao {
    
    private final UsuarioDao usuarioDao;

    public AutenticacaoDao() {
        this.usuarioDao = new UsuarioDao();
    }
    
    public boolean temPermissao(Usuario usuario){
        try {
            permisao(usuario);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Usuario sem permissao", 0);
            return false;
        }
    }
    
    private void permisao(Usuario usuario){
        if(!Perfil.ADMIN.equals(usuario.getPerfil())){
            throw new NegocioException("Sem permissao para realizar essa acao");
        }
    }
    
    
    public Usuario login(LoginDto login){
        Usuario usuario = usuarioDao.buscarUsuarioPeloUsuario(login.getUsuario());
        
        if(usuario == null || !usuario.isEstado())
            return null;
        
        if(usuario.isEstado() && validaSenha(usuario.getSenha(), login.getSenha())){
            return usuario;
        }
        
        return null;
    }

    private boolean validaSenha(String senhaUsuario, String senhaLogin) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        
        return passwordEncoder.matches(senhaLogin, senhaUsuario);
    }
    
}
