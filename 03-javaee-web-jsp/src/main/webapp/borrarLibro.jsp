<%@ page import="pe.BookDao" %>
<%@ page import="pe.DaoFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String isbn = request.getParameter("isbn");

    BookDao bookDao = DaoFactory.createBookDao();
    bookDao.deleteById(isbn);

    response.sendRedirect("mostrarLibros.jsp");
%>
