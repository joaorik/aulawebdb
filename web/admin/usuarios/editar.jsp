<%@include file="../../layout/header.jsp" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Admin</h1>
    </div>

    <h5>Editar usuário</h5>
    <br>
    <form class="needs-validation" action="<c:url value="/admin/usuarios/update" />" name="update" method="POST">
        <input type="hidden" name="id" value="${usuario.id}">

        <div class="col-md-4 mb-3">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" value="${usuario.nome}">
        </div>
        <div class="col-md-4 mb-3">
            <label for="email">E-mail</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="E-mail" value="${usuario.email}">
        </div>
        <div class="col-md-4 mb-3">
            <label for="senha">Senha</label>
            <input type="text" class="form-control" id="senha" name="senha" placeholder="Senha" value="${usuario.senha}">
        </div>

        <hr class="mb-4">

        <button class="btn btn-success" type="submit">Atualizar</button>
    </form>

</main>

<%@include file="../../layout/footer.jsp" %>
