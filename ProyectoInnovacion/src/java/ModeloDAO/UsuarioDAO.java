package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDusuario;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements CRUDusuario {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuario usu = new Usuario();

    public Usuario Validar(String usuario, String contrasenia) {
        Usuario usu = new Usuario();
        String sql="select * from usuario where NOMBREUSU=? and CLAVE=?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
            while (rs.next()) {       
                usu.setId(rs.getInt("ID"));
                usu.setNombreUsu(rs.getString("NOMBREUSU"));
                usu.setContrasenia(rs.getString("CLAVE"));
                usu.setCargo(rs.getString("CARGO"));
            }
        } catch (Exception e) {
        }
        return usu;
    }

    
    @Override
    public List listar() {
        ArrayList<Usuario> list = new ArrayList<>();
        String sql = "select * from usuario";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt("ID"));
                usu.setNombreUsu(rs.getString("NOMBREUSU"));
                usu.setContrasenia(rs.getString("CLAVE"));
                usu.setCargo(rs.getString("CARGO"));
                list.add(usu);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Usuario list(int id) {
        String sql = "select * from usuario where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                usu.setId(rs.getInt("ID"));
                usu.setNombreUsu(rs.getString("NOMBREUSU"));
                usu.setContrasenia(rs.getString("CLAVE"));
                usu.setCargo(rs.getString("CARGO"));
            }
        } catch (Exception e) {
        }
        return usu;
    }

    @Override
    public boolean agregar(Usuario usu) {
        String sql = "insert into usuario(NOMBREUSU,CLAVE,CARGO) values ('" + usu.getNombreUsu() + "','" + usu.getContrasenia() + "','" + usu.getCargo() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }

        return false;
    }

    @Override
    public boolean editar(Usuario usu) {
        String sql = "update usuario set NOMBREUSU ='" + usu.getNombreUsu() + "',CLAVE='" + usu.getContrasenia() + "',"
                + "CARGO='" + usu.getCargo() + "'where ID=" + usu.getId();
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
        String sql = "delete from usuario where id=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
