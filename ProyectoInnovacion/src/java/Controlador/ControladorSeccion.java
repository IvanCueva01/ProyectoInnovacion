
package Controlador;

import Modelo.Seccion;
import ModeloDAO.SeccionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorSeccion extends HttpServlet {

    String listar = "vistas/Articulo.jsp";
    String agregar = "vistas/agregarSeccion.jsp";
    String editar = "vistas/editarReceta.jsp";
    Seccion sec = new Seccion();
    SeccionDAO daosec = new SeccionDAO();
    private int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorSeccion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorSeccion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String accion = request.getParameter("accion");
        if (accion.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (accion.equalsIgnoreCase("mostraragregar")) {
            acceso = agregar;
        } else if (accion.equalsIgnoreCase("agregar")) {
            String titulo = request.getParameter("titulo");
            sec.setTitulo(titulo);
            daosec.agregar(sec);
            acceso = listar;
        } else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idsec", request.getParameter("idseccion"));
            acceso = editar;
        } else if (accion.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("id"));
            String titulo = request.getParameter("titulo");
            sec.setIdseccion(id);
            sec.setTitulo(titulo);
            daosec.editar(sec);
            acceso = listar;
        } else if (accion.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("idseccion"));
            sec.setIdseccion(id);
            daosec.eliminar(id);
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
