<%@ page import="java.util.List" %>
<%@ page import="pe.isil.model.dao.BookDao" %>
<%@ page import="pe.isil.model.dao.DaoFactory" %>
<%@ page import="pe.isil.model.entities.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>Lista de Libros</title>
</head>
<body>

<div class="container">
    <h3>Lista de libros</h3>

    <div class="col-md-12">
        <a href="formularioInsertarLibro.jsp" class="btn btn-primary btn-sm">Insertar</a>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Isbn</th>
            <th scope="col">Titulo</th>
            <th scope="col">Categoria</th>
        </tr>
        </thead>
        <tbody>
        <%
            BookDao bookDao = DaoFactory.createBookDao();
            List<Book> bookList = bookDao.findAll();

            for (Book book : bookList) {%>
        <tr>
            <td><%= book.getIsbn()%>
            </td>
            <td><%= book.getTitulo()%>
            </td>
            <td><%= book.getCategoria()%>
            </td>
            <td class="text-right">
                <div class="btn-group">
                    <a class="btn btn-primary btn-sm" href="FormularioEditarLibro.jsp?isbn=<%= book.getIsbn() %>">Editar</a>
                    <a class="btn btn-danger btn-sm" href="borrarLibro.jsp?isbn=<%= book.getIsbn() %>">Eliminar</a>
                </div>
            </td>
        </tr>
        <%
            }

        %>

        </tbody>
    </table>
</div>

</body>
</html>
