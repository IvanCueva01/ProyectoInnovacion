package Controlador;

import Modelo.Incidencia;
import ModeloDAO.IncidenciaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorIncidencias extends HttpServlet {

    String listar="vistas/listarIncidencias.jsp";
    String agregar="vistas/agregarIncidencias.jsp";
        String editar="vistas/editarIncidencias.jsp";
    Incidencia inci = new Incidencia();
    IncidenciaDAO daoinci = new IncidenciaDAO();
    private int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorIncidencia</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorIncidencia at " + request.getContextPath() + "</h1>");
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
            int idcliente = Integer.parseInt(request.getParameter("idcliente")) ;
            int idempleado = Integer.parseInt(request.getParameter("idempleado")) ;
            String asunto = request.getParameter("asunto");
            String detalle = request.getParameter("detalle");
            String fecharegistro = request.getParameter("fecharegistro");
            String estado = request.getParameter("estado");
            inci.setIdcliente(idcliente);
            inci.setIdempleado(idempleado);
            inci.setAsunto(asunto);
            inci.setDetalle(detalle);
            inci.setFecharegistro(fecharegistro);
            inci.setEstado(estado);
            daoinci.agregar(inci);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idinc", request.getParameter("idinci"));
            acceso = editar;
        }else if (accion.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("id"));
            int idcliente = Integer.parseInt(request.getParameter("idcliente")) ;
            int idempleado = Integer.parseInt(request.getParameter("idempleado")) ;
            String asunto = request.getParameter("asunto");
            String detalle = request.getParameter("detalle");
            String fecharegistro = request.getParameter("fecharegistro");
            String estado = request.getParameter("estado");
            inci.setIdinci(id);
            inci.setIdcliente(idcliente);
            inci.setIdempleado(idempleado);
            inci.setAsunto(asunto);
            inci.setDetalle(detalle);
            inci.setFecharegistro(fecharegistro);
            inci.setEstado(estado);
            daoinci.editar(inci);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("idinci"));
            inci.setIdinci(id);
            daoinci.eliminar(id);
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
