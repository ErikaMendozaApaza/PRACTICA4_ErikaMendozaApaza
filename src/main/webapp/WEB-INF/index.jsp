<%@taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>JSP Page</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  <header>
    <h1>Blog de Tecnología</h1>
    <nav>
      <ul>
        <li><a href="#">Inicio</a></li>
        <li><a href="#">Noticias</a></li>
        <li><a href="#">Tutoriales</a></li>
        <li><a href="#">Reseñas</a></li>
        <li><a href="#">Contacto</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section class="articulo">
      <h2>¿Qué depara la próxima generación de procesadores?</h2>
      <p>Fecha: 02/05/2024</p>
      <p>Autor: Zacarios Flores</p>
      <img src="procesador.jpg" alt="Procesador">
      <p>Analizamos las tendencias emergentes en el diseño de procesadores y lo que podemos esperar de la próxima generación de chips. Desde arquitecturas innovadoras hasta avances en la fabricación, exploramos cómo estas nuevas tecnologías están impulsando el rendimiento y la eficiencia en una amplia gama de dispositivos, desde teléfonos inteligentes hasta centros de datos. También discutimos cómo estos avances podrían afectar el futuro de la informática y la tecnología en general.</p>
      <a href="#" class="btn-leer-mas">Leer más</a>
    </section>

    <section class="articulo">
      <h2>Explorando los Lenguajes de Programación del Futuro</h2>
      <p>Fecha: 06/05/2024</p>
      <p>Autor: Zacarios Flores</p>
      <img src="codigo.jpg" alt="Código">
      <p>Exploramos los lenguajes que podrían dominar el panorama tecnológico en los próximos años. Desde los clásicos como Python y Java hasta los recién llegados como Rust y Swift, examinamos las fortalezas y debilidades de cada uno, así como su potencial para enfrentar los desafíos emergentes en el mundo del desarrollo de software.</p>
      <a href="#" class="btn-leer-mas">Leer más</a>
    </section>
  </main>

  <footer>
    <p>&copy; 2024 Blog de Tecnología</p>
  </footer>
</body>
</html>

