<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Usuario"%>
<%@page import="java.util.List"%>
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
            <h1>Usuarios</h1>
            <a href="ControladorUsuario?accion=mostraragregar">Agregar Usuario</a> 
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Usuario</th>
                        <th>Cargo</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <%
                UsuarioDAO daousu = new UsuarioDAO();
                List<Usuario> list = daousu.listar();
                Iterator<Usuario> iter =list.iterator();
                Usuario usu = null;
                while (iter.hasNext()) {                        
                        usu = iter.next();
                %>
                <tbody>
                    <tr>
                        <td><%=usu.getId()%></td>
                        <td><%=usu.getNombreUsu()%></td>
                        <td><%=usu.getCargo()%></td>
                        <td>
                            <a href="ControladorUsuario?accion=editar&id=<%=usu.getId()%>">Editar</a>
                            <a href="ControladorUsuario?accion=eliminar&id=<%=usu.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
