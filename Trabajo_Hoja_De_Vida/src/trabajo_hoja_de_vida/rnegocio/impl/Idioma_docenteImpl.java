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
import trabajo_hoja_de_vida.rnegocio.dao.Iidioma_Docente;
import trabajo_hoja_de_vida.rnegocio.entidades.Exp_Profecional;
import trabajo_hoja_de_vida.rnegocio.entidades.Idioma_Docente;

/**
 *
 * @author Usuario
 */
public class Idioma_docenteImpl implements Iidioma_Docente {

    @Override
    public int insertar(Idioma_Docente idioma_docente) throws Exception {
     
        int numFilasAfectadas = 0;
        String sql = "insert into Exp_Profecional  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idioma_docente.getDocente()));
        lstPar.add(new Parametro(2, idioma_docente.getIdioma()));
        lstPar.add(new Parametro(3, idioma_docente.getHablado()));
        lstPar.add(new Parametro(4, idioma_docente.getEscrito()));
        lstPar.add(new Parametro(5, idioma_docente.getComprension()));

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
    public int modificar(Idioma_Docente idioma_docente) throws Exception {
      
        int numFilasAfectadas = 0;
        String sql = "UPDATE exp_profecional"
                + "   SET codigoExp=?, codigoE=?, empresa_institucion=?, posicion=?, fecha_inicio=?, fecha_final=? "
                + " where codigoExp=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idioma_docente.getDocente()));
        lstPar.add(new Parametro(2, idioma_docente.getIdioma()));
        lstPar.add(new Parametro(3, idioma_docente.getHablado()));
        lstPar.add(new Parametro(4, idioma_docente.getEscrito()));
        lstPar.add(new Parametro(5, idioma_docente.getComprension()));
       

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
    public int eliminar(Idioma_Docente idioma_docente) throws Exception {
        
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM exp_profecional  where codigoExp=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idioma_docente.getDocente()));       
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
    public Idioma_Docente obtener(int codigo) throws Exception {
        
        Idioma_Docente idioma_docente = null;
        String sql = "SELECT * FROM exp_profecional where codigoExp=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);

            while (rst.next()) {
               
                idioma_docente = new Idioma_Docente();
                idioma_docente.setDocente(rst.getString(1));
                idioma_docente.setIdioma(rst.getString(2));
                idioma_docente.setHablado(rst.getString(3));
                idioma_docente.setEscrito(rst.getString(4));
                idioma_docente.setComprension(rst.getString(5));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return idioma_docente;    
        
    }

    @Override
    public List<Idioma_Docente> obtener() throws Exception {
       
        List<Idioma_Docente> lista = new ArrayList<>();;
        String sql = "SELECT * FROM exp_profecional ";
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Idioma_Docente idioma_docente = null;
            while (rst.next()) {
                idioma_docente = new Idioma_Docente();
                idioma_docente.setDocente(rst.getString(1));
                idioma_docente.setIdioma(rst.getString(2));
                idioma_docente.setHablado(rst.getString(3));
                idioma_docente.setEscrito(rst.getString(4));
                idioma_docente.setComprension(rst.getString(3));
            

                lista.add(idioma_docente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return lista;
        
    }
    
    
    
}
