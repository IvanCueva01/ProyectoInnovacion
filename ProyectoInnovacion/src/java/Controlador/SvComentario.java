/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;

import Modelo.Comentario;
import ModeloDAO.ComentarioDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
public class SvComentario extends HttpServlet {

    String listar = "./vistas/Articulo.jsp";
    String agregar = "./vistas/agregarComentario.jsp";
    String editar = "./vistas/editarComentario.jsp";
    Comentario com = new Comentario();
    ComentarioDAO daocom = new ComentarioDAO();
    private int id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvComentario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvComentario at " + request.getContextPath() + "</h1>");
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
            String comentario = request.getParameter("comentario");
            String autor = request.getParameter("autor");
            String fecha = request.getParameter("fecha");
            com.setMensaje(comentario);
            com.setAutor(autor);
            com.setFecha(fecha);
            daocom.agregar(com);
            acceso = listar;
        } else if (accion.equalsIgnoreCase("editar")) {
            request.setAttribute("idcom", request.getParameter("id"));
            acceso = editar;
        } else if (accion.equalsIgnoreCase("actualizar")) {
            id = Integer.parseInt(request.getParameter("txtid"));
            String comentario = request.getParameter("comentario");
            String autor = request.getParameter("autor");
            String fecha = request.getParameter("fecha");
            com.setId(id);
            com.setMensaje(comentario);
            com.setAutor(autor);
            com.setFecha(fecha);
            daocom.editar(com);
            acceso = listar;
        } else if (accion.equalsIgnoreCase("eliminar")) {
            id = Integer.parseInt(request.getParameter("id"));
            com.setId(id);
            daocom.eliminar(id);
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
