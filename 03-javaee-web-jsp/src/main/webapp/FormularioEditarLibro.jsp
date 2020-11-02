<%@ page import="pe.DaoFactory" %>
<%@ page import="pe.BookDao" %>
<%@ page import="pe.Book" %><%--
  Created by IntelliJ IDEA.
  User: Norvil
  Date: 24/10/2020
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar Libro</title>
</head>
<body>

<%
    String isbn = request.getParameter("isbn");

    BookDao bookDao = DaoFactory.createBookDao();
    Book book = bookDao.findById(isbn);


%>

<form id="miFormulario" action="modificarLibro.jsp" method="post">

    <fieldset>
        <legend>Formulario Modificacion de Libros</legend>

        <p>
            <label for="isbn">ISBN:</label>
            <input type="text" name="isbn" id="isbn" value="<%= book.getIsbn()%>">
        </p>
        <p>
            <label for="titulo">Titulo:</label>
            <input type="text" name="titulo" id="titulo" value="<%=book.getTitulo()%>">
        </p>
        <p>
            <label for="categoria">Categoria:</label>
            <input type="text" name="categoria" id="categoria" value="<%=book.getCategoria()%>">
        </p>
        <p>
            <input type="submit" value="Modificar">
        </p>

    </fieldset>


</form>

</body>
</html>
