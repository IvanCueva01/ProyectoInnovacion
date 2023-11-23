package ModeloDAO;

import Modelo.Recordatorio;
import Config.Conexion;
import java.sql.*;
import java.util.*;

public class RecordatorioDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    private Recordatorio mensaje;

    public List<Recordatorio> Seleccionar() {
        String sql = "select * from recordatorio";
        List<Recordatorio> mensajes = new ArrayList<>();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_mensaje");
                String mensaje = rs.getString("mensaje");
                String autor = rs.getString("autor");
                String fecha = rs.getString("fecha");
                this.mensaje = new Recordatorio(mensaje, autor,fecha);
                mensajes.add(this.mensaje);
            }
        } catch (Exception e) {
            
        }
        return mensajes;
    }
    
    public int Insertar(Recordatorio mensaje) {
        String sql = "insert into recordatorio(mensaje,autor,fecha) values (?,?,CURRENT_TIME())";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutor());                    
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }  
        return 0;
    }
    
     public int Editar(Recordatorio mensaje) {
        String sql = "update recordatorio set mensaje=?,autor=? where id_mensaje=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutor());                    
            ps.setInt(3, mensaje.getId());                    
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }  
        return 0;
    }
     
      public int Eliminar(Recordatorio mensaje) {
        String sql = "delete from recordatorio where id_mensaje=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);                   
            ps.setInt(1, mensaje.getId());                    
            ps.executeUpdate();
        } catch (Exception e) {
            
        }  
        return 0;
    }
}
