<%@include file="../../layout/header.jsp" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Admin</h1>
    </div>

    <h5>Usuários</h5>
    <p class="success"><c:out value="${success}" /></p>
    <p><a href="<c:url value="/admin/usuarios/adicionar" />">Adicionar usuario</a></p>
    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Usuário</th>
                    <th>E-mail</th>
                    <th colspan="2">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${usuarios}" var="usuario">
                    <tr>
                        <td> <c:out value="${usuario.id}" /> </td>
                        <td> <c:out value="${usuario.nome}" /> </td>
                        <td> <c:out value="${usuario.email}" /> </td>
                        <td>
                            <a href="<c:url value="/admin/usuarios/update?Id=" />${usuario.id}">Editar</a>
                            <a href="<c:url value="/admin/usuarios/deletar?Id=" />${usuario.id}">Deletar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</main>

<%@include file="../../layout/footer.jsp" %>
