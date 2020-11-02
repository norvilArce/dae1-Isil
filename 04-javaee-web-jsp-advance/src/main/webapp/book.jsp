<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New book</title>
</head>
<body>

<form action="BookController" method="POST" name="frmAddBook">
    ISBN : <input type="text" <%--readonly="readonly"--%> name="isbn" value="<c:out value="${book.isbn}"/>"><br/>
    Titulo : <input type="text" name="titulo" value="<c:out value="${book.titulo}"/>"><br/>
    Categoria : <input type="text" name="categoria" value="<c:out value="${book.categoria}"/>"><br/>
    <input type="submit" value="Submit"><br/>
</form>

</body>
</html>
