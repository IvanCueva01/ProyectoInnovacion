package ModeloDAO;

import Interfaces.CRUDseccion;
import Modelo.Seccion;
import java.util.List;
import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SeccionDAO implements CRUDseccion {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Seccion sec = new Seccion();

    @Override
    public List listar() {
        ArrayList<Seccion> list = new ArrayList<>();
        String sql = "select * from seccion";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Seccion sec = new Seccion();
                sec.setIdseccion(rs.getInt("idseccion"));
                sec.setTitulo(rs.getString("titulo"));
                list.add(sec);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Seccion list(int idseccion) {
        String sql = "select * from seccion";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sec.setIdseccion(rs.getInt("idseccion"));
                sec.setTitulo(rs.getString("titulo"));
            }
        } catch (Exception e) {
        }
        return sec;
    }

    @Override
    public boolean agregar(Seccion sec) {
        String sql = "insert into seccion(titulo) values ('" + sec.getTitulo() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Seccion sec) {
        String sql = "update articulo set titulo='"+ sec.getTitulo()+"'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idseccion) {
     String sql = "delete from seccion where idseccion=" + idseccion;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }
}
