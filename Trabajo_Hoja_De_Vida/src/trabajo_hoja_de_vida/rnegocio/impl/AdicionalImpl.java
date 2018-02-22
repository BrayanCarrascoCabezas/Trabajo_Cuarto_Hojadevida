/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import trabajo_hoja_de_vida.accesodatos.*;
import trabajo_hoja_de_vida.rnegocio.dao.IAdicional;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.entidades.*;

/**
 *
 * @author WILCXMAC
 */
public class AdicionalImpl implements IAdicional{
    
  @Override
    public int insertar(Adicional adicional) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into adicional  values "
                + "(?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, adicional.getDocente().getCod_docente()));
        lstPar.add(new Parametro(2, adicional.getDescripcion()));
   
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
    public int modificar(Adicional adicional) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE adicional"
                + "   SET cod_docente=?, descripcion=?"
                + " where cod_docente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, adicional.getDocente().getCod_docente()));
        lstPar.add(new Parametro(2, adicional.getDescripcion()));
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
    public int eliminar(Adicional adicional) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM adicional  where cod_docente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, adicional.getDocente().getCod_docente()));       
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
    public Adicional obtener(int cod_adicional) throws Exception {
        Adicional adicional = null;
        String sql = "SELECT * FROM adicional where cod_docente=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cod_adicional));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                adicional = new Adicional();
               IDocente docentedao=new DocenteImpl();
                Docente docente =docentedao.obtener(rst.getInt(1));
                adicional.setDocente(docente);
                adicional.setDescripcion(rst.getString(2));

                   
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return adicional;
    }

    @Override
    public List<Adicional> obtener() throws Exception {
        List<Adicional> lista = new ArrayList<>();
         String sql = "SELECT * FROM adicional ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Adicional adicional=null;
            while (rst.next()) {
                adicional = new Adicional();
               IDocente docentedao=new DocenteImpl();
                Docente docente =docentedao.obtener(rst.getInt(1));
                adicional.setDocente(docente);
                adicional.setDescripcion(rst.getString(2));
                lista.add(adicional);
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

