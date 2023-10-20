<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <h1>Agregar Usuarios</h1>
            <form action="ControladorUsuario">
                Usuario:<br>
                <input type="text" name="nombreusu" placeholder="nombre de usuario"><br>
                Contraseña:<br>
                <input type="password" name="contrasenia" placeholder="contraseña"><br>
                Cargo:<br>
                <input type="text" name="cargo" placeholder="cargo"><br><br>
                <input type="submit" name="accion" value="agregar"><br>            
            </form>
        </div>
    </body>
</html>
