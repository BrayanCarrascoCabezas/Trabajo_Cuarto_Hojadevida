/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajo_hoja_de_vida.accesodatos.Conexion;
import trabajo_hoja_de_vida.accesodatos.Parametro;
import trabajo_hoja_de_vida.rnegocio.dao.IAreaGeneral;
import trabajo_hoja_de_vida.rnegocio.dao.IArea_docente;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.entidades.Area_docente;
import trabajo_hoja_de_vida.rnegocio.entidades.AreaGeneral;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;

/**
 *
 * @author Segovia
 */
public class Area_docenteImpl implements IArea_docente
{
     @Override
    public int insertar(Area_docente area_docente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into area_docente  values "
                + "(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
 lstPar.add(new Parametro(1, area_docente.getDocente().getCod_docente()));
        lstPar.add(new Parametro(2, area_docente.getAreageneral().getCodigo()));
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
    public int modificar(Area_docente area_docente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE area_docente"
                + "   SET Cod_docente=?, =?,codigo =?, where Codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, area_docente.getDocente().getCod_docente()));
        lstPar.add(new Parametro(2, area_docente.getAreageneral().getCodigo()));
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
    public int eliminar(Area_docente area_docente) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM area_docente  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, area_docente.getDocente().getCod_docente())); 
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
    public Area_docente obtener(int IdProvedor) throws Exception {
        Area_docente area_docente = null;
        String sql = "UPDATE area_docente"
                + "   SET Cod_docente=?, =?,codigo =?, where Codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProvedor));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                   area_docente = new Area_docente();
                IDocente docentedao=new DocenteImpl();
                Docente docente =docentedao.obtener(rst.getInt(1));
                area_docente.setDocente(docente); 
                
                IAreaGeneral areageneraldao=new AreaImpl();
                AreaGeneral areageneral =areageneraldao.obtener(rst.getInt(2));
                area_docente.setAreageneral(areageneral); 
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return area_docente;
    }

    @Override
    public List<Area_docente> obtener() throws Exception {
        List<Area_docente> lista = new ArrayList<>();
         String sql = "UPDATE area_docente"
                + "   SET Cod_docente=?, =?,codigo =?, where Codigo=?";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Area_docente area_docente=null;
            while (rst.next()) {
                area_docente = new Area_docente();
                   IDocente docentedao=new DocenteImpl();
                Docente docente =docentedao.obtener(rst.getInt(1));
                area_docente.setDocente(docente); 
                
                IAreaGeneral areageneraldao=new AreaImpl();
                AreaGeneral areageneral =areageneraldao.obtener(rst.getInt(2));
                area_docente.setAreageneral(areageneral);           
                lista.add(area_docente);
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