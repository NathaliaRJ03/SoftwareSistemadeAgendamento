/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.newdesign.gestaovenda;

import com.newdesign.gestaovenda.modelo.dao.UsuarioDao;
import com.newdesign.gestaovenda.modelo.dominio.Perfil;
import com.newdesign.gestaovenda.modelo.dominio.Usuario;
import java.time.LocalDateTime;

/**
 *
 * @author vinic
 */
public class UsuarioTest {
    public static void main(String[] args) {
        Usuario usuario = new Usuario(1L, "Vinicius Souza", "1234", "NewDesign", Perfil.PADRAO, null, null);
        
        UsuarioDao usuariodao = new UsuarioDao();
        String mensagem = usuariodao.salvar(usuario);
        System.out.println(mensagem);
    }
    
}
