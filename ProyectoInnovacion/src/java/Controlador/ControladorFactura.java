package Controlador;

import Modelo.Factura;
import ModeloDAO.FacturaDAO;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControladorFactura extends HttpServlet {

    String listar="vistas/listarFacturas.jsp";
    String agregar="vistas/agregarFacturas.jsp";
    String editar="vistas/editarFacturas.jsp";
    Factura factu = new Factura();
    FacturaDAO daofactu = new FacturaDAO();
    private int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorFactura</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorFactura at " + request.getContextPath() + "</h1>");
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
            String fechafactura = request.getParameter("fechafactura");
            int idservicio = Integer.parseInt(request.getParameter("idservicio")) ;
            int cantidad = Integer.parseInt(request.getParameter("cantidad")) ;
            double precioUnitario = Integer.parseInt(request.getParameter("cantidad")) ;
            double total = Integer.parseInt(request.getParameter("cantidad")) ;
            factu.setIdcliente(idcliente);
            factu.setFechafactura(fechafactura);
            factu.setIdservicio(idservicio);
            factu.setCantidad(cantidad);
            factu.setPrecioUnitario(precioUnitario);
            factu.setTotal(total);
           daofactu.agregar(factu);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idfact", request.getParameter("idfactura"));
            acceso = editar;
        }else if (accion.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            int idfactura = Integer.parseInt(request.getParameter("idfactura")) ;
            int idcliente = Integer.parseInt(request.getParameter("idcliente")) ;
            String fechafactura = request.getParameter("fechafactura");
            int idservicio = Integer.parseInt(request.getParameter("idservicio")) ;
            int cantidad = Integer.parseInt(request.getParameter("cantidad")) ;
            double precioUnitario = Integer.parseInt(request.getParameter("cantidad")) ;
            double total = Integer.parseInt(request.getParameter("cantidad")) ;
            factu.setIdfactura(idfactura);
            factu.setIdcliente(idcliente);
            factu.setFechafactura(fechafactura);
            factu.setIdservicio(idservicio);
            factu.setCantidad(cantidad);
            factu.setPrecioUnitario(precioUnitario);
            factu.setTotal(total);
            daofactu.editar(factu);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("idfactura"));
            factu.setIdfactura(id);
            daofactu.eliminar(id);
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
