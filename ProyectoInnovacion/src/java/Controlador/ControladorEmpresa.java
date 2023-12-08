package Controlador;

import Modelo.Empresa;
import ModeloDAO.EmpresaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorEmpresa extends HttpServlet {

    String listar="vistas/listarClientes.jsp";
    String agregar="vistas/agregarEmpresa.jsp";
    String editar="vistas/editarEmpresa.jsp";
    Empresa empre = new Empresa();
    EmpresaDAO daoempre = new EmpresaDAO();
    private int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorEmpresa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorEmpresa at " + request.getContextPath() + "</h1>");
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
            String ruc = request.getParameter("ruc") ;
            String razonsocial = request.getParameter("razonsocial");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            String estado = request.getParameter("estado");
            empre.setRuc(ruc);
            empre.setRazonsocial(razonsocial);
            empre.setTelefono(telefono);
            empre.setCorreo(correo);
            empre.setDireccion(direccion);
            empre.setEstado(estado);
            daoempre.agregar(empre);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idempre", request.getParameter("id"));
            acceso = editar;
        }else if (accion.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String ruc = request.getParameter("ruc") ;
            String razonsocial = request.getParameter("razonsocial");
            String telefono = request.getParameter("telefono");
            String correo = request.getParameter("correo");
            String direccion = request.getParameter("direccion");
            String estado = request.getParameter("estado");
            empre.setId(id);
            empre.setRuc(ruc);
            empre.setRazonsocial(razonsocial);
            empre.setTelefono(telefono);
            empre.setCorreo(correo);
            empre.setDireccion(direccion);
            empre.setEstado(estado);
            daoempre.editar(empre);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            empre.setId(id);
            daoempre.eliminar(id);
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
