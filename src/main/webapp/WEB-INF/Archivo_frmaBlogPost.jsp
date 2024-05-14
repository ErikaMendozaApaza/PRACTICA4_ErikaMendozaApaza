<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Agregar/Editar Registro</title>
</head>
<body>
  <h1>Agregar/Editar Registro</h1>

  <form action="submit.php" method="post">
    <label for="fecha">Fecha:</label>
    <input type="date" id="fecha" name="fecha" required>

    <label for="titulo">Titulo:</label>
    <input type="text" id="titulo" name="titulo" required>

    <label for="contenido">Contenido:</label>
    <textarea id="contenido" name="contenido" rows="5" required></textarea>

    <button type="submit">Envior</button>
  </form>
</body>
</html>
