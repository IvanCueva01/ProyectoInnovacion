package Controlador;

import Modelo.Usuario;
import ModeloDAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorUsuario extends HttpServlet {
    
    String listar="vistas/listar.jsp";
    String agregar="vistas/agregar.jsp";
    String editar="vistas/editar.jsp";
    Usuario usu = new Usuario();
    UsuarioDAO daousu = new UsuarioDAO();
    private int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String accion=request.getParameter("accion");
        if (accion.equalsIgnoreCase("listar")) {
            acceso=listar;
        }else if (accion.equalsIgnoreCase("mostraragregar")) {
            acceso = agregar;
        }else if (accion.equalsIgnoreCase("agregar")) {
            String nombreusu = request.getParameter("nombreusu") ;
            String contrasenia = request.getParameter("contrasenia");
            String cargo = request.getParameter("cargo");
            usu.setNombreUsu(nombreusu);
            usu.setContrasenia(contrasenia);
            usu.setCargo(cargo);
            daousu.agregar(usu);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idusu", request.getParameter("id"));
            acceso = editar;
        }else if (accion.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("id"));
            String nombreusu = request.getParameter("nombreusu") ;
            String contrasenia = request.getParameter("contrasenia");
            String cargo = request.getParameter("cargo");
            usu.setId(id);
            usu.setNombreUsu(nombreusu);
            usu.setContrasenia(contrasenia);
            usu.setCargo(cargo);
            daousu.editar(usu);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            usu.setId(id);
            daousu.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
