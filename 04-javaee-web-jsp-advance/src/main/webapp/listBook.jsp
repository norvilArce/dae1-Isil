<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=UTF-8">
    <title>Show All Books</title>
</head>
<body>

<a href="BookController?action=add">Book add</a>
<table border="1">

    <thead>
    <tr>
        <th>Isbn</th>
        <th>Titulo</th>
        <th>Categoria</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.titulo}"/></td>
            <td><c:out value="${book.categoria}"/></td>
            <td><a href="BookController?action=edit&isbn=<c:out value="${book.isbn}"/>">Update</a></td>
            <td><a href="BookController?action=delete&isbn=<c:out value="${book.isbn}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
