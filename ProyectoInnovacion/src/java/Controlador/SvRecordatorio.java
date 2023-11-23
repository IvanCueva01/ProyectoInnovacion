
package Controlador;
import Modelo.Recordatorio;
import ModeloDAO.RecordatorioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SvRecordatorio extends HttpServlet {

    String listar="./index.jsp";
    String agregar="vistas/agregarRecordatorio.jsp";
    String editar="vistas/editarRecordatorio.jsp";
    Recordatorio rec = new Recordatorio();
    RecordatorioDAO daorec = new RecordatorioDAO();
    private int id;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvRecordatorio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvRecordatorio at " + request.getContextPath() + "</h1>");
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
            String mensaje = request.getParameter("mensaje");
            String autor = request.getParameter("autor");
            String fecha = request.getParameter("fecha");
            rec.setMensaje(mensaje);
            rec.setAutor(autor);
            rec.setFecha(fecha);
            daorec.agregar(rec);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idrec", request.getParameter("id"));
            acceso = editar;
        }else if (accion.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("id"));
            String mensaje = request.getParameter("mensaje");
            String autor = request.getParameter("autor");
            String fecha = request.getParameter("fecha");
            rec.setId(id);
            rec.setMensaje(mensaje);
            rec.setAutor(autor);
            rec.setFecha(fecha);
            daorec.editar(rec);
            acceso = listar;
        }else if (accion.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            rec.setId(id);
            daorec.eliminar(id);
            acceso = listar;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
