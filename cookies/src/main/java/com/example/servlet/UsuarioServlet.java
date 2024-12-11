/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author wesle
 */
package com.example.servlet;

import com.example.dao.UsuarioDAO;
import com.example.entity.Usuario;
import jakarta.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public void destroy() {
        usuarioDAO.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");

        // Persistir o nome no banco de dados usando o DAO
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuarioDAO.salvar(usuario);

        // Criar o cookie para lembrar o nome
        Cookie cookie = new Cookie("nomeUsuario", nome);
        cookie.setMaxAge(60 * 60 * 24); // 1 dia
        response.addCookie(cookie);

        // Redirecionar para a página principal
        response.sendRedirect("home.jsp");
    }
}

