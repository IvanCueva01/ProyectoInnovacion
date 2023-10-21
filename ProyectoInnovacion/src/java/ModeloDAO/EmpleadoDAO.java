package ModeloDAO;

import Config.Conexion;
import Interfaces.CRUDempleado;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO implements CRUDempleado {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empleado emple = new Empleado();

    @Override
    public List listar() {
        ArrayList<Empleado> list = new ArrayList<>();
        String sql = "select * from empleado where ESTADO='1'";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emple = new Empleado();
                emple.setIdemple(rs.getInt("IDEMPLE"));
                emple.setDni(rs.getString("DNI"));
                emple.setNombre(rs.getString("NOMBRES"));
                emple.setApellido(rs.getString("APELLIDOS"));
                emple.setTelefono(rs.getString("TELEFONO"));
                emple.setEstado(rs.getString("ESTADO"));
                emple.setCorreo(rs.getString("CORREO"));
                list.add(emple);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Empleado list(int idemple) {
        String sql = "select * from empleado where IDEMPLE=" + idemple;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                emple.setIdemple(rs.getInt("IDEMPLE"));
                emple.setDni(rs.getString("DNI"));
                emple.setNombre(rs.getString("NOMBRES"));
                emple.setApellido(rs.getString("APELLIDOS"));
                emple.setTelefono(rs.getString("TELEFONO"));
                emple.setEstado(rs.getString("ESTADO"));
                emple.setCorreo(rs.getString("CORREO"));
            }
        } catch (Exception e) {
        }
        return emple;
    }

    @Override
    public boolean agregar(Empleado emple) {
        String sql = "insert into empleado(DNI,NOMBRES,APELLIDOS,TELEFONO,ESTADO,CORREO) values "
                + "('"+emple.getDni()+"','"+emple.getNombre()+"','"+emple.getApellido()+"','"+emple.getTelefono()+"','"+emple.getEstado()+"','"+emple.getCorreo()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean editar(Empleado emple) {
        String sql = "update empleado set DNI='"+emple.getDni()+"',NOMBRES='"+emple.getNombre()+"',"
                +"APELLIDOS='"+emple.getApellido()+"',TELEFONO='"+emple.getTelefono()+"',ESTADO='"+emple.getEstado()+"',"
                +"CORREO='"+emple.getCorreo()+"' where IDEMPLE="+ emple.getIdemple();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int idemple) {
       String sql = "update empleado set ESTADO='0' where IDEMPLE="+idemple;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
