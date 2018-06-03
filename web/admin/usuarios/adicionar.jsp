
<%@include file="../../layout/header.jsp" %>


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Admin</h1>
    </div>

    <h5>Adicionar usuário</h5>
    <p class="error"><c:out value="${error}" /></p>
    <br>
    <form class="needs-validation" action="<c:url value="/admin/usuarios/adicionar" />" name="adicionar" method="POST">
        <div class="col-md-4 mb-3">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" minlength="3" maxlength="45">
        </div>
        <div class="col-md-4 mb-3">
            <label for="email">E-mail</label>
            <input type="text" class="form-control" id="email" name="email" maxlength="120">
        </div>
        <div class="col-md-4 mb-3">
            <label for="senha">Senha</label>
            <input type="password" class="form-control" id="senha" name="senha" minlength="6" maxlength="16">
        </div>

        <hr class="mb-4">

        <button class="btn btn-success" type="submit">Cadastrar</button>
    </form>

</main>

<%@include file="../../layout/footer.jsp" %>
