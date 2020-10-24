<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/main.js"></script>

    <title>Formulario Libro</title>
</head>
<body>

<form id="miFormulario" action="insertarLibro.jsp" method="post">

    <fieldset>
        <legend>Formulario alta de Libros</legend>

        <p>
            <label for="isbn">ISBN:</label>
            <input type="text" name="isbn" id="isbn">
        </p>
        <p>
            <label for="titulo">Titulo:</label>
            <input type="text" name="titulo" id="titulo">
        </p>
        <p>
            <label for="categoria">Categoria:</label>
            <input type="text" name="categoria" id="categoria">
        </p>
        <p>
        <input type="button" value="Insertar" onclick="validacion()">
        </p>

    </fieldset>


</form>

</body>
</html>