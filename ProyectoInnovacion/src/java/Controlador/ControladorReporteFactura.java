/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

/**
 *
 * @author Ivan
 */
public class ControladorReporteFactura extends HttpServlet {

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
                "attachment;filename=\"reporte-facturas.pdf\"");

        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3307/proyectoinnovacion", "root", "");
            PreparedStatement ps = cn.prepareStatement("SELECT detallesfactura.*, cliente.NOMBRES as nombre_cliente, servicios.nombre as servicio FROM detallesfactura "
                    + "INNER JOIN cliente ON detallesfactura.ClienteID = cliente.IDCLIENTE "
                    + "INNER JOIN servicios ON detallesfactura.ServicioID = servicios.idservicio" );
            ResultSet rs = ps.executeQuery();
            Document documento = new Document();
            PdfWriter.getInstance(documento, response.getOutputStream());
            documento.open();
            documento.add(new Paragraph("LISTA DE FACTURACIONES"));
            documento.add(new Paragraph(" "));
            PdfPTable tabla = new PdfPTable(8);
            tabla.addCell("ID FACTURA");
            tabla.addCell("nombre_cliente");
            tabla.addCell("FECHA");
            tabla.addCell("servicio");
            tabla.addCell("CANTIDAD");
            tabla.addCell("PRECIO UNITARIO");
            tabla.addCell("TOTAL");
            tabla.addCell("IGV");
            if (rs.next()) {
                do {
                    tabla.addCell(rs.getString(1));               
                    tabla.addCell(rs.getString(9));               
                    tabla.addCell(rs.getString(3));
                    tabla.addCell(rs.getString(10));
                    tabla.addCell(rs.getString(5));
                    tabla.addCell(rs.getString(6));
                    tabla.addCell(rs.getString(7));
                    tabla.addCell(rs.getString(8));
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
