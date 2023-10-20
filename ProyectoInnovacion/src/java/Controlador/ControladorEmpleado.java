package Controlador;

import Modelo.Empleado;
import ModeloDAO.EmpleadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorEmpleado extends HttpServlet {

    String listar="vistas/listarEmpleados.jsp";
    String agregar="vistas/agregarEmpleados.jsp";
    String editar="vistas/editarEmpleados.jsp";
    Empleado emple = new Empleado();
    EmpleadoDAO daoemple = new EmpleadoDAO();
    private int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEmpleado at " + request.getContextPath() + "</h1>");
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
            String dni = request.getParameter("dni") ;
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String telefono = request.getParameter("telefono");
            String estado = request.getParameter("estado");
            String correo = request.getParameter("correo");
            emple.setDni(dni);
            emple.setNombre(nombre);
            emple.setApellido(apellido);
            emple.setTelefono(telefono);
            emple.setEstado(estado);
            emple.setCorreo(correo);
            daoemple.agregar(emple);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idemp", request.getParameter("idemple"));
            acceso = editar;
        }else if (accion.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("id"));
            String dni = request.getParameter("dni") ;
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String telefono = request.getParameter("telefono");
            String estado = request.getParameter("estado");
            String correo = request.getParameter("correo");
            emple.setIdemple(id);
            emple.setDni(dni);
            emple.setNombre(nombre);
            emple.setApellido(apellido);
            emple.setTelefono(telefono);
            emple.setCorreo(correo);
            emple.setEstado(estado);
            daoemple.editar(emple);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("idemple"));
            emple.setIdemple(id);
            daoemple.eliminar(id);
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
