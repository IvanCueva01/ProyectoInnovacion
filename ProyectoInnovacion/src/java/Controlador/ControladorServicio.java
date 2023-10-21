package Controlador;

import Modelo.Servicio;
import ModeloDAO.ServicioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorServicio extends HttpServlet {
    
    String listar="vistas/listarServicios.jsp";
    String agregar="vistas/agregarServicios.jsp";
    String editar="vistas/editarServicios.jsp";
    Servicio servi = new Servicio();
    ServicioDAO daoservi = new ServicioDAO();
    String id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
            String idservicio = request.getParameter("idservicio") ;
            String nombre = request.getParameter("nombre");
            String estado = request.getParameter("estado");
            servi.setIdservicio(idservicio);
            servi.setNombre(nombre);
            servi.setEstado(estado);
            daoservi.agregar(servi);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idservicio", request.getParameter("idservicio"));
            acceso = editar;
        }else if (accion.equalsIgnoreCase("actualizar")) {
            servi.setIdservicio(request.getParameter("idservicio"));
            servi.setNombre(request.getParameter("nombre"));
            servi.setEstado(request.getParameter("estado"));
            daoservi.editar(servi);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("eliminar")) {
            id = request.getParameter("idservicio");
            daoservi.eliminar(id);
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
