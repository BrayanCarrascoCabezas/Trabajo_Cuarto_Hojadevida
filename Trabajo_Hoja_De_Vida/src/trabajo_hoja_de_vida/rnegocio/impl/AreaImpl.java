package trabajo_hoja_de_vida.rnegocio.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;
import trabajo_hoja_de_vida.accesodatos.Conexion;
import trabajo_hoja_de_vida.accesodatos.Parametro;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import trabajo_hoja_de_vida.rnegocio.entidades.AreaGeneral;

import trabajo_hoja_de_vida.rnegocio.entidades.Publicacion;
import trabajo_hoja_de_vida.rnegocio.dao.IAreaGeneral;

public class AreaImpl implements IAreaGeneral {

    @Override
    public int insertar(AreaGeneral areaGeneral) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into area  values "
                + "(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, areaGeneral.getCodigo()));
        lstPar.add(new Parametro(2, areaGeneral.getdescripcion()));

        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(AreaGeneral areaGeneral) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE area"
                + "   SET =?, codigo=?, descripcion=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, areaGeneral.getCodigo()));
        lstPar.add(new Parametro(2, areaGeneral.getdescripcion()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(AreaGeneral areaGeneral) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM area  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, areaGeneral.getCodigo()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public AreaGeneral obtener(int codigo) throws Exception {
        AreaGeneral area = null;
        String sql = "SELECT codigo, descripcion FROM area where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                area = new AreaGeneral();
                area.setCodigo(rst.getInt(1));
                area.setDescripcion(rst.getString(2));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return area;
    }

    @Override
    public ArrayList<AreaGeneral> obtener() throws Exception {
        ArrayList<AreaGeneral> lista = new ArrayList<>();
         String sql = "SELECT codigo, descripcion FROM area ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            AreaGeneral area=null;
            while (rst.next()) {
                area = new AreaGeneral();
                area.setCodigo(rst.getInt(1));
                area.setDescripcion(rst.getString(2));
                lista.add(area);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }

}
