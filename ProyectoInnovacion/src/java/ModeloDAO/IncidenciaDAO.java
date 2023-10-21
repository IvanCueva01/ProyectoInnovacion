package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDincidencia;
import Modelo.Incidencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class IncidenciaDAO implements CRUDincidencia {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Incidencia inci = new Incidencia();

    @Override
    public List listar() {
        ArrayList<Incidencia> list = new ArrayList<>();
        String sql = "select * from incidencias";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Incidencia inci = new Incidencia();
                inci.setIdinci(rs.getInt("idinci"));
                inci.setIdcliente(rs.getInt("idcliente"));
                inci.setIdempleado(rs.getInt("idempleado"));
                inci.setAsunto(rs.getString("asunto"));
                inci.setDetalle(rs.getString("detalle"));
                inci.setFecharegistro(rs.getString("fecharegistro"));
                inci.setEstado(rs.getString("estado"));
                list.add(inci);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Incidencia list(int idinci) {
        String sql = "select * from incidencias where idinci=" + idinci;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                inci.setIdinci(rs.getInt("idinci"));
                inci.setIdcliente(rs.getInt("idcliente"));
                inci.setIdempleado(rs.getInt("idempleado"));
                inci.setAsunto(rs.getString("asunto"));
                inci.setDetalle(rs.getString("detalle"));
                inci.setFecharegistro(rs.getString("fecharegistro"));
                inci.setEstado(rs.getString("estado"));
            }
        } catch (Exception e) {
        }
        return inci;
    }

    @Override
    public boolean agregar(Incidencia inci) {
        String sql = "insert into incidencias(idcliente,idempleado,asunto,detalle,fecharegistro,estado) values "
                + "('" + inci.getIdcliente() + "','" + inci.getIdempleado() + "','" + inci.getAsunto() + "',"
                + "'" + inci.getDetalle() + "','" + inci.getFecharegistro() + "','" + inci.getEstado() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Incidencia inci) {
        String sql = "update incidencias set idcliente='" + inci.getIdcliente()+ "',idempleado='" + inci.getIdempleado()+ "',"
                + "asunto='" + inci.getAsunto()+ "',detalle='" + inci.getDetalle()+ "',fecharegistro='" + inci.getFecharegistro()+ "',"
                + "estado='" + inci.getEstado()+ "' where idinci=" + inci.getIdinci();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idinci) {
        String sql = "update incidencias set estado='Atendido' where idinci=" + idinci;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
