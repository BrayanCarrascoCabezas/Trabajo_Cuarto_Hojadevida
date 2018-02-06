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
 * @author FabricioConstante
 */
public class CursoImpl implements ICurso {

    @Override
    public int insertar(Curso curso) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into curso (descripcion) values (?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, curso.getDescripcion()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Curso curso) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  curso set descripcion=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, curso.getDescripcion()));
        lstPar.add(new Parametro(2, curso.getCodigo()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Curso curso) throws Exception {
        int numFilasAfectadas = 0;
        return numFilasAfectadas;
    }

    @Override
    public Curso obtener(int codigo) throws Exception {
        Curso curso = null;
         String sql = "select codigo, descripcion from curso where codigo=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                curso= new Curso();
                curso.setCodigo(rst.getInt(1));
                curso.setDescripcion(rst.getString(2));            
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return curso;
    }

    @Override
    public List<Curso> obtener() throws Exception {
        List<Curso> lista = new ArrayList<>();
         String sql = "select codigo, descripcion from curso";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Curso curso= null;
            while(rst.next()){
                curso= new Curso();
                curso.setCodigo(rst.getInt(1));
                curso.setDescripcion(rst.getString(2));
                lista.add(curso);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
