<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Registro</title>

        <!-- Styles -->
        <link href="<c:url value="/css/login.css" />" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="login-page">
            <div class="form">
                <form class="login-form" action="<c:url value="/registrar" />" method="POST">
                    <input type="nome" name="nome" placeholder="Nome">
                    <input type="email" name="email" placeholder="E-mail">
                    <input type="password" name="senha" placeholder="Senha">
                    <button type="submit">Cadastrar</button>
                    <p class="message">Já possui uma <a href="<c:url value="/login" />">conta</a>?</p>
                    <p class="message">Àrea restrita, voltar para <a href="<c:url value="/" />">Home</a></p>
                </form>
            </div>
        </div>
    </body>
</html>

