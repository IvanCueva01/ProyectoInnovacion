package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDservicio;
import Modelo.Servicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicioDAO implements CRUDservicio {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Servicio servi = new Servicio();

    @Override
    public List listar() {
        ArrayList<Servicio> list = new ArrayList<>();
        String sql = "select * from servicios";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Servicio servi = new Servicio();
                servi.setIdservicio(rs.getString("idservicio"));
                servi.setNombre(rs.getString("nombre"));
                servi.setEstado(rs.getString("estado"));
                list.add(servi);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Servicio list(String idservicio) {
        String sql = "select * from servicios where idservicio=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, idservicio);
            rs = ps.executeQuery();
            while (rs.next()) {
                servi.setIdservicio(rs.getString("idservicio"));
                servi.setNombre(rs.getString("nombre"));
                servi.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return servi;
    }

    @Override
    public boolean agregar(Servicio servi) {
        String sql = "insert into servicios values (?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, servi.getIdservicio());
            ps.setString(2, servi.getNombre());
            ps.setString(3, servi.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Servicio servi) {
        String sql = "update servicios set nombre=?,estado=? where idservicio=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, servi.getIdservicio());
            ps.setString(2, servi.getNombre());
            ps.setString(3, servi.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(String idservicio) {
        String sql = "update servicios set estado='0' where idservicio=?" ;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, idservicio);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
