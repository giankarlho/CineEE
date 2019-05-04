package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Personal;

public class PersonalImpl extends Conexion implements ICRUD<Personal> {
// idPer nomPer apePer dniPer  dirPer tipPer sexPer 
    // usuPer pwdPer codUbi

    @Override
    public void registrar(Personal personal) throws Exception {
        String sql = "insert into personal"
                + " (nomPer,apePer,dniPer,dirPer,tipPer,sexPer,usuPer,pwdPer,ubiPer)"
                + " values (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, personal.getNomPer());
            ps.setString(2, personal.getApePer());
            ps.setString(3, personal.getDniPer());
            ps.setString(4, personal.getDirPer());
            ps.setInt(5, personal.getTipPer());
            ps.setString(6, personal.getSexPer());
            ps.setString(7, personal.getUsuPer());
            ps.setString(8, personal.getPwdPer());
            ps.setString(9, personal.getCodUbi());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en registrarDaoPer " + e.getMessage());
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void modificar(Personal personal) throws Exception {
        String sql = "update personal set nomPer=?,apePer=?,dniPer=?,dirPer=?,"
                + "tipPer=?,sexPer=?,usuPer=?,pwdPer=?,ubiPer=? where idPer=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, personal.getNomPer());
            ps.setString(2, personal.getApePer());
            ps.setString(3, personal.getDniPer());
            ps.setString(4, personal.getDirPer());
            ps.setInt(5, personal.getTipPer());
            ps.setString(6, personal.getSexPer());
            ps.setString(7, personal.getUsuPer());
            ps.setString(8, personal.getPwdPer());
            ps.setString(9, personal.getCodUbi());
            ps.setInt(10, personal.getIdPer());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en modificarPer " + e.getMessage());
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public void eliminar(Personal personal) throws Exception {
        String sql = "delete from personal where idPer=?";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setInt(1, personal.getIdPer());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarPer " + e.getMessage());
            throw e;
        } finally {
            this.cerrar();
        }
    }

    @Override
    public List<Personal> listarPer() throws Exception {
        List<Personal> listado;
        Personal pers;
        String sql = "select * from personal";
        try {
            listado = new ArrayList();
            Statement st = this.conectar().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pers = new Personal();
                pers.setIdPer(rs.getInt("idPer"));
                pers.setNomPer(rs.getString("nomPer"));
                pers.setApePer(rs.getString("apePer"));
                pers.setDniPer(rs.getString("dniPer"));
                pers.setDirPer(rs.getString("dirPer"));
                pers.setTipPer(rs.getInt("tipPer"));
                pers.setSexPer(rs.getString("sexPer"));
                pers.setUsuPer(rs.getString("usuPer"));
                pers.setPwdPer(rs.getString("pwdPer"));
                pers.setCodUbi(rs.getString("ubiPer"));
                listado.add(pers);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.cerrar();
        }
        return listado;
    }

    public List<String> autocompleteUbigeo(String distrito) throws Exception {
        ResultSet rs;
        List<String> Lista;
        try {
            String sql = "SELECT top 15 CONCAT(dptoUbi,  ', ' , provUbi,  ' ,' ,distUbi) as distrito from ubigeo where distUbi like '%?%'";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, distrito);
            Lista = new ArrayList<>();
            rs = ps.executeQuery();
            while (rs.next()) {
                Lista.add(rs.getString("distrito"));
            }
            return Lista;
        } catch (Exception e) {
            throw e;
        }

    }

}
