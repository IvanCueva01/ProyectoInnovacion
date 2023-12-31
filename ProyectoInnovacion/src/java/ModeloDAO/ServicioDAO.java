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
                servi.setIdservicio(rs.getInt("idservicio"));
                servi.setNombre(rs.getString("nombre"));
                servi.setEstado(rs.getString("estado"));
                list.add(servi);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Servicio list(int idservicio) {
        String sql = "select * from servicios where idservicio=" + idservicio;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                servi.setIdservicio(rs.getInt("idservicio"));
                servi.setNombre(rs.getString("nombre"));
                servi.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return servi;
    }

    @Override
    public boolean agregar(Servicio servi) {
        String sql = "insert into servicios(nombre,estado) values ('" + servi.getNombre()+ "','" + servi.getEstado()+ "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Servicio servi) {
        String sql = "update servicios set nombre='" + servi.getNombre()+ "',estado='" + servi.getNombre()+ "' where idservicio="
                + servi.getIdservicio();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idservicio) {
        String sql = "update servicios set estado='0' where idservicio=" + idservicio ;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
