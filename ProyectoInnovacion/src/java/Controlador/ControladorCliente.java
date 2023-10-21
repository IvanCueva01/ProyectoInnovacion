package Controlador;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorCliente extends HttpServlet {

    String listar="vistas/listarClientes.jsp";
    String agregar="vistas/agregarClientes.jsp";
    String editar="vistas/editarClientes.jsp";
    Cliente clien = new Cliente();
    ClienteDAO daoclien = new ClienteDAO();
    private int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCliente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorCliente at " + request.getContextPath() + "</h1>");
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
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            String fechanac = request.getParameter("fechanac");
            String estado = request.getParameter("estado");
            clien.setDni(dni);
            clien.setNombre(nombre);
            clien.setApellido(apellido);
            clien.setTelefono(telefono);
            clien.setCorreo(correo);
            clien.setDireccion(direccion);
            clien.setFechanac(fechanac);
            clien.setEstado(estado);
            daoclien.agregar(clien);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idcli", request.getParameter("idcliente"));
            acceso = editar;
        }else if (accion.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String dni = request.getParameter("dni") ;
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            String fechanac = request.getParameter("fechanac");
            String estado = request.getParameter("estado");
            clien.setIdcliente(id);
            clien.setDni(dni);
            clien.setNombre(nombre);
            clien.setApellido(apellido);
            clien.setTelefono(telefono);
            clien.setCorreo(correo);
            clien.setDireccion(direccion);
            clien.setFechanac(fechanac);
            clien.setEstado(estado);
            daoclien.editar(clien);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("idcliente"));
            clien.setIdcliente(id);
            daoclien.eliminar(id);
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
