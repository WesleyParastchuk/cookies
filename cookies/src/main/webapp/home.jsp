<%-- 
    Document   : home
    Created on : 11 de dez. de 2024, 11:44:05
    Author     : wesle
--%>

<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Bem-vindo</title>
</head>
<body>
    <h1>Bem-vindo à página inicial!</h1>
    
    <%
        String nome = null;
        Cookie[] cookies = request.getCookies();
        
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("nomeUsuario".equals(cookie.getName())) {
                    nome = cookie.getValue();
                }
            }
        }
        
        if (nome != null) {
    %>
        <p>Olá, <%= nome %>! Seu nome foi salvo.</p>
    <% 
        } else {
    %>
        <p>Você ainda não se cadastrou. Por favor, <a href="index.jsp">faça o cadastro</a>.</p>
    <% 
        }
    %>
</body>
</html>

