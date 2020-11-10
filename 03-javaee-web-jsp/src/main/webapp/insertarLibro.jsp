<%@ page import="pe.BookDao" %>
<%@ page import="pe.DaoFactory" %>
<%@ page import="pe.Book" %>
<%@ page import="pe.isil.model.dao.BookDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%

    String isbn = request.getParameter("isbn");
    String titulo = request.getParameter("titulo");
    String categoria = request.getParameter("categoria");

    BookDao bookDao = DaoFactory.createBookDao();
    bookDao.insert(new Book(isbn, titulo, categoria));


    response.sendRedirect("mostrarLibros.jsp");


%>