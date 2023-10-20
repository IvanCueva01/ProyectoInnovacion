
<%@page import="Modelo.Usuario"%>
<%@page import="ModeloDAO.UsuarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <%
                UsuarioDAO daousu = new UsuarioDAO();
                int id = Integer.parseInt((String)request.getAttribute("idusu"));
                Usuario usu = (Usuario)daousu.list(id);
            %>
            <h1>Editar Usuarios</h1>
            <form action="ControladorUsuario">
                Usuario:<br>
                <input type="text" name="nombreusu" value="<%=usu.getNombreUsu()%>"><br>
                Contraseña:<br>
                <input type="password" name="contrasenia" value="<%=usu.getContrasenia()%>"><br>
                Cargo:<br>
                <input type="text" name="cargo" value="<%=usu.getCargo()%>"><br><br>
                <input type="hidden" name="id" value="<%=usu.getId()%>">
                <input type="submit" name="accion" value="actualizar"><br>    
                <a href="ControladorUsuario?accion=listar">Regresar</a>
            </form>
        </div>
    </body>
</html>
