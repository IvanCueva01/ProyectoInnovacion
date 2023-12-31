
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.StringReader;
import java.util.Date;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.JOptionPane;

public class ControladorReporteIncidencia extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("application/pdf");
        response.setHeader("Content-Disposition",
                "attachment;filename=\"reporte-incidencias.pdf\"");

            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/proyectoinnovacion", "root", "");
                PreparedStatement ps = cn.prepareStatement("SELECT incidencias.*, empleado.NOMBRES as nombre_empleado, cliente.NOMBRES as nombre_cliente FROM incidencias "
                        + "INNER JOIN empleado ON incidencias.idempleado = empleado.IDEMPLE INNER JOIN cliente ON incidencias.idcliente = cliente.IDCLIENTE");
                ResultSet rs = ps.executeQuery();
                Document documento = new Document();
                PdfWriter.getInstance(documento, response.getOutputStream());
                documento.open();
                documento.add(new Paragraph("LISTA DE INCIDENCIAS"));
                documento.add(new Paragraph(" "));
                PdfPTable tabla = new PdfPTable(7);
                tabla.addCell("ID incidencia");
                tabla.addCell("Asunto");
                tabla.addCell("Detalle");
                tabla.addCell("FechaRegistro");
                tabla.addCell("Estado");
                tabla.addCell("nombre_cliente");
                tabla.addCell("nombre_empleado");
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                        tabla.addCell(rs.getString(8));
                        tabla.addCell(rs.getString(9));
                    } while (rs.next());
                    documento.add(tabla);
                }
                documento.close();
            } catch (DocumentException | SQLException e) {
            }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
