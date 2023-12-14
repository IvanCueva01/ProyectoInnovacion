package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDarticulo;
import Modelo.Articulo;
import java.sql.*;
import java.util.*;

public class ArticuloDAO implements CRUDarticulo {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Articulo arti = new Articulo();

    @Override
    public List listar() {
        ArrayList<Articulo> list = new ArrayList<>();
        String sql = "select * from articulo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo arti = new Articulo();
                arti.setId(rs.getInt("id"));
                arti.setTitulo(rs.getString("titulo"));
                arti.setContenido(rs.getString("contenido"));
                arti.setIdseccion(rs.getInt("idseccion"));
                list.add(arti);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Articulo list(int id) {
        String sql = "select * from articulo where id="+id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                arti.setId(rs.getInt("id"));
                arti.setTitulo(rs.getString("titulo"));
                arti.setContenido(rs.getString("contenido"));
                arti.setIdseccion(rs.getInt("idseccion"));
            }
        } catch (Exception e) {
        }
        return arti;
    }

    @Override
    public boolean agregar(Articulo arti) {
        String sql = "insert into articulo(titulo,contenido,idseccion) values "
                + "('" + arti.getTitulo() + "','" + arti.getContenido() + "','" + arti.getIdseccion()+ "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Articulo arti) {
        String sql = "update articulo set titulo='" + arti.getTitulo() + "',contenido='" + arti.getContenido() + "'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from articulo where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {

        }
        return false;
    }
}
