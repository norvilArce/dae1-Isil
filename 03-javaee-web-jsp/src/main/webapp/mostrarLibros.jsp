<%@ page import="pe.isil.model.dao.BookDao" %>
<%@ page import="pe.isil.model.dao.DaoFactory" %>
<%@ page import="pe.isil.model.entities.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista de Libros</title>
</head>
<body>

<%

    BookDao bookDao = DaoFactory.createBookDao();
    List<Book> bookList = bookDao.findAll();

    for (Book book : bookList) {%>
        <%= book.getIsbn()%>
        <%= book.getTitulo()%>
        <%= book.getCategoria()%>
        <br/>

<%
    }


%>

<a href="formularioLibro.jsp">Insertar Libro</a>

</body>
</html>
