/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.impl;
import trabajo_hoja_de_vida.accesodatos.*;

import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davidssito Campos
 */
public class Titulo_PregadoImpl implements ITitulo_Pregado{
    @Override
    public int insertar(Titulo_Pregado titulo_pregado) throws Exception {
        int numFilasAfectadas=0;
        String sql="insert into Titulo_Pregado(Cod_Pregrado,cod_docente,pais,Titulo_Pregrado,universidad) values (?),(?),(?),(?),(?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, titulo_pregado.getCodTituloPre()));
        lstPar.add(new Parametro(2, titulo_pregado.getDocente().getCod_docente()));
        lstPar.add(new Parametro(3, titulo_pregado.getPais()));
        lstPar.add(new Parametro(4, titulo_pregado.getTitulo_pregado()));
        lstPar.add(new Parametro(5, titulo_pregado.getUniversidad()));
        
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
    public int modificar(Titulo_Pregado titulo_pregado) throws Exception {
         int numFilasAfectadas = 0;
        String sql = "UPDATE Titulo_Pregado"
                + "   SET Cod_Pregrado=?,cod_docente=?,pais=?,Titulo_Pregrado=?,universidad=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, titulo_pregado.getCodTituloPre()));
        lstPar.add(new Parametro(2, titulo_pregado.getDocente().getCod_docente()));
        lstPar.add(new Parametro(3, titulo_pregado.getPais()));
        lstPar.add(new Parametro(4, titulo_pregado.getTitulo_pregado()));
        lstPar.add(new Parametro(5, titulo_pregado.getUniversidad()));
        lstPar.add(new Parametro(6, titulo_pregado.getCodTituloPre()));
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
    public int eliminar(Titulo_Pregado titulo_pregado) throws Exception {
       int numFilasAfectadas = 0;
         String sql = "DELETE FROM Titulo_Pregado  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, titulo_pregado.getCodTituloPre()));      
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
    public Titulo_Pregado obtener(int codigo) throws Exception {
    Titulo_Pregado titulo_pregado = null;
        String sql = "SELECT Cod_Pregrado,cod_docente,pais,Titulo_Pregrado,universidad FROM Titulo_Pregado where codigo=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                titulo_pregado = new Titulo_Pregado();
                titulo_pregado.setCodTituloPre(rst.getInt(1));
                
                IDocente docenteDao = new DocenteImpl();
                Docente docente = docenteDao.obtener(rst.getInt(2));
                   
                titulo_pregado.setPais(rst.getString(3));
                titulo_pregado.setTitulo_pregado(rst.getString(4));
                titulo_pregado.setUniversidad(rst.getString(5));
                titulo_pregado.setDocente(docente);
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return titulo_pregado;
    }
    
          
    @Override
    public List<Titulo_Pregado> obtener() throws Exception {
         List<Titulo_Pregado> lista = new ArrayList<>();
         String sql = "SELECT Cod_Pregrado,cod_docente,pais,Titulo_Pregrado,universidad FROM Titulo_Pregado ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Titulo_Pregado titulo_pregado=null;
            while (rst.next()) {
                titulo_pregado = new Titulo_Pregado();
                titulo_pregado.setCodTituloPre(rst.getInt(1));
                IDocente docenteDao = new DocenteImpl();
                Docente docente = docenteDao.obtener(rst.getInt(2));
                titulo_pregado.setDocente(docente);
                titulo_pregado.setPais(rst.getString(3));
                titulo_pregado.setTitulo_pregado(rst.getString(4));
                titulo_pregado.setUniversidad(rst.getString(5));
               
                lista.add(titulo_pregado);
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
