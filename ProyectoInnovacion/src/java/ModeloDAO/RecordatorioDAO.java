package ModeloDAO;

import Modelo.Recordatorio;
import Interfaces.CRUDrecordatorio;
import Config.Conexion;
import java.sql.*;
import java.util.*;

public class RecordatorioDAO implements CRUDrecordatorio {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Recordatorio rec = new Recordatorio();

    @Override
    public List listar() {
        ArrayList<Recordatorio> mensajes = new ArrayList<>();
        String sql = "select * from recordatorio";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Recordatorio rec = new Recordatorio();
                rec.setId(rs.getInt("id_mensaje"));
                rec.setMensaje(rs.getString("mensaje"));
                rec.setAutor(rs.getString("autor"));
                rec.setFecha(rs.getString("fecha"));
                mensajes.add(rec);
            }
        } catch (Exception e) {
        }
        return mensajes;
    }

    @Override
    public Recordatorio list(int id) {
        String sql = "select * from recordatorio where id_mensaje="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                rec.setId(rs.getInt("id_mensaje"));
                rec.setMensaje(rs.getString("mensaje"));
                rec.setAutor(rs.getString("autor"));
                rec.setFecha(rs.getString("fecha"));
            }
        } catch (Exception e) {
        }
        return rec;
    }

    @Override
    public boolean agregar(Recordatorio rec) {
        String sql = "insert into recordatorio(mensaje,autor,fecha) values (?,?,CURRENT_TIME())";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, rec.getMensaje());
            ps.setString(2, rec.getAutor());
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean editar(Recordatorio rec) {
        String sql = "update recordatorio set mensaje=?,autor=? where id_mensaje=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, rec.getMensaje());
            ps.setString(2, rec.getAutor());
            ps.setInt(3, rec.getId());
            ps.executeUpdate();

        } catch (Exception e) {

        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from recordatorio where id_mensaje="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }
}
