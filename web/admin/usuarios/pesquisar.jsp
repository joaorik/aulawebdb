<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@include file="../../layout/header.jsp" %>

<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">

    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        <h1 class="h2">Admin</h1>
    </div>

    <h5>Pesquisar usuário</h5>
    <br>
    <form class="needs-validation" action="<c:url value="/admin/pesquisar" />" name="pesquisar" method="POST">

        <div class="row">
            
        <div class="col-md-4 mb-3">
            <label for="nome">Nome</label>
            <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome">
        </div>
        <div class="col-md-4 mb-3">
            <label for="email">E-mail</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="E-mail">
        </div>

        </div>
        <hr class="mb-4">

        <button class="btn btn-success" type="submit">Pesquisar</button>
    </form>

    <h5>Usuários encontrados</h5>
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
                <%
                    int count = 0;
                    String color = "#F9EBB3";
                    if (request.getAttribute("usuarios") != null) {
                        ArrayList al = (ArrayList) request.getAttribute("usuarios");
                        System.out.println(al);
                        Iterator itr = al.iterator();
                        while (itr.hasNext()) {

                            if ((count % 2) == 0) {
                                color = "#eeffee";
                            }
                            count++;
                            ArrayList pList = (ArrayList) itr.next();
                %>
                <tr>
                    <td> <%=pList.get(0)%> </td>
                    <td> <%=pList.get(1)%> </td>
                    <td> <%=pList.get(2)%> </td>
                    <td>
                        <a href="<c:url value="/admin/usuarios/update?Id=" /><%=pList.get(0)%>">Editar</a>
                        <a href="<c:url value="/admin/usuarios/deletar?Id=" /><%=pList.get(0)%>">Deletar</a>
                    </td>
                </tr>
                <%
                        }
                    }
                    if (count == 0) {
                %>
                <tr>
                    <td colspan=4 align="center"
                        style="background-color:#eeffee"><b>Nenhum Registro Encontrado..</b></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>

</main>

<%@include file="../../layout/footer.jsp" %>
