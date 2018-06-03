<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="br">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Admin</title>

    <!-- CSS -->
    <link href="<c:url value="/css/admin.css" />" rel="stylesheet" type="text/css">
</head>

<body>

    <nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0">
        <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="<c:url value="/admin" />">Admin</a>
        <ul class="navbar-nav px-3">
            <li class="nav-item text-nowrap">
                <a class="nav-link" href="<c:url value="/logout" />">Logout</a>
            </li>
        </ul>
    </nav>

    <div class="container-fluid">
        <div class="row">
            <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                <div class="sidebar-sticky">
                    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                        <span>Menu</span>
                    </h6>
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin" />">
                                <span data-feather="home"></span> Admin
                            </a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/usuarios" />">
                                <span data-feather="user-check"></span> Usuários
                            </a>
                        </li>
                        
                         <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/admin/pesquisar" />">
                                <span data-feather="user-check"></span> Pesquisar Usuários
                            </a>
                        </li>
                    </ul>
                    <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                        <span>Opção</span>
                    </h6>
                    <ul class="nav flex-column mb-2">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/logout" />">
                                <span data-feather="log-out"></span> Logout
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>