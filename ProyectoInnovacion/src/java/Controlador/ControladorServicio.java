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
    String editar="./vistas/editarServicios.jsp";
    Servicio servi = new Servicio();
    ServicioDAO daoservi = new ServicioDAO();
    private int id;

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
            String nombre = request.getParameter("nombre");
            String estado = request.getParameter("estado");
            servi.setNombre(nombre);
            servi.setEstado(estado);
            daoservi.agregar(servi);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idservi", request.getParameter("idservicio"));
            acceso = editar;
        }else if (accion.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String estado = request.getParameter("estado");
            servi.setIdservicio(id);
            servi.setNombre(nombre);
            servi.setEstado(estado);
            daoservi.editar(servi);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("idservicio"));
            servi.setIdservicio(id);
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
