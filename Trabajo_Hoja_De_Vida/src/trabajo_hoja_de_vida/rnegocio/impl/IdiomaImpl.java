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
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.dao.IIdioma;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import trabajo_hoja_de_vida.rnegocio.entidades.Idioma;
import trabajo_hoja_de_vida.rnegocio.entidades.Publicacion;

/**
 *
 * @author SYSTEMarket-pc
 */
public class IdiomaImpl implements IIdioma{

    @Override
    public int insertar(Idioma idioma) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into idioma  values "
                +"(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idioma.getCodigo()));
        lstPar.add(new Parametro(2, idioma.getDescripcion()));
       
        
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
    public int modificar(Idioma idioma) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE idioma"
                + "   SET =?, codigo=?, descripcion=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idioma.getCodigo()));
        lstPar.add(new Parametro(2, idioma.getDescripcion()));
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
    public int eliminar(Idioma idioma) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM idioma  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idioma.getCodigo()));       
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
    public Idioma obtener(int codigo) throws Exception {
        Idioma idioma = null;
        String sql = "SELECT codigo, descripcion FROM idioma where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                idioma = new Idioma();
                idioma.setCodigo(rst.getInt(1));
                idioma.setDescripcion(rst.getString(2));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return idioma;
    }

    @Override
    public List<Idioma> obtener() throws Exception {
        List<Idioma> lista = new ArrayList<>();
         String sql = "SELECT codigo, descripcion FROM idioma ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Idioma idioma=null;
            while (rst.next()) {
                idioma = new Idioma();
                idioma.setCodigo(rst.getInt(1));
                idioma.setDescripcion(rst.getString(2));
                lista.add(idioma);
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
