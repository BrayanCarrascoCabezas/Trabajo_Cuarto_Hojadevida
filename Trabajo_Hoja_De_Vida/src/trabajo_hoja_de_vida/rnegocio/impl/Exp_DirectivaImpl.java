
package trabajo_hoja_de_vida.rnegocio.impl;
import java.util.*;
import java.sql.*;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.accesodatos.*;

public class Exp_DirectivaImpl implements IExp_Directiva{
    
    @Override
    public int insertar(Exp_Directiva expdirectiva) throws Exception {
        int nFilas = 0;
        String csql = "INSERT INTO Exp_Directiva (CodigoExp_D, Experiencia, Empresa_Institucion, Entidades, Fecha_Inicio,Fecha_Final) VALUES (?,?,?,?,?,?)";
        ArrayList<Parametro> lstP = new ArrayList<>();
        lstP.add(new Parametro(1, expdirectiva.getCodigoExp_D()));
        lstP.add(new Parametro(2, expdirectiva.getExperiencia()));
        lstP.add(new Parametro(3, expdirectiva.getEmpresa_Institucion()));
         lstP.add(new Parametro(4, expdirectiva.getEntidades()));
        lstP.add(new Parametro(5, expdirectiva.getFecha_Inicio()));
        lstP.add(new Parametro(6, expdirectiva.getFecha_Final()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            nFilas = con.ejecutaComando(csql, lstP);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public int modificar(Exp_Directiva expdirectiva) throws Exception {
        int nFilas=0;
        String csql="UPDATE Exp_Directiva SET CodigoExp_D=?,  Experiencia=?, Empresa_Institucion=?,Entidades=?, Fecha_Inicio=?, Fecha_Final=? Where CodigoExp_D=?";
        ArrayList<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, expdirectiva.getCodigoExp_D()));
        lstPar.add(new Parametro(2, expdirectiva.getExperiencia()));
        lstPar.add(new Parametro(3, expdirectiva.getEmpresa_Institucion()));
         lstPar.add(new Parametro(4, expdirectiva.getEntidades()));
        lstPar.add(new Parametro(5, expdirectiva.getFecha_Inicio()));
        lstPar.add(new Parametro(6, expdirectiva.getFecha_Final()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            nFilas=con.ejecutaComando(csql, lstPar); 
        } catch (Exception e) {
            System.out.println("Error de modificacion: "+e.getMessage());
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public int eliminar(Exp_Directiva expdirectiva) throws Exception {
        int nFilas=0;
        String csql="DELETE FROM Exp_Directiva Where CodigoExp_D=?";
        ArrayList<Parametro> lstPar=new ArrayList<>();
        lstPar.add(new Parametro(1, expdirectiva.getCodigoExp_D()));
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            nFilas=con.ejecutaComando(csql, lstPar); 
        } catch (Exception e) {
            System.out.println("Error de Eliminacionn: "+e.getMessage());
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return nFilas;
    }

    @Override
    public Exp_Directiva obtener(int codigo) throws Exception {
        Exp_Directiva expdirectiva = null;
        String csql = "SELECT CodigoExp_D, Experiencia, Empresa_Institucion, Entidades,  Fecha_Inicio,  Fecha_Final FROM Exp_Directiva Where CodigoExp_D=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        IExperiencia expDao=new ExperienciaImpl();
        Experiencia exp=null;
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(csql, lstPar);
            while (rst.next()) {
                expdirectiva=new Exp_Directiva();
                expdirectiva.setCodigoExp_D(rst.getInt(1));
                expdirectiva.setExperiencia(rst.getString(2));
                expdirectiva.setEmpresa_Institucion(rst.getString(3));
                expdirectiva.setEntidades(rst.getString(4));
                expdirectiva.setFecha_Inicio(rst.getDate(5));
                expdirectiva.setFecha_Final(rst.getDate(6));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " " + e.getLocalizedMessage());
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return expdirectiva;
    }

    @Override
    public ArrayList<Exp_Directiva> obtener() throws Exception {
        ArrayList<Exp_Directiva> expdirectivas = new ArrayList<>();
        IExperiencia expDao=new ExperienciaImpl();
        Experiencia exp=null;;
        String csql="SELECT tCodigoExp_D, Experiencia, Empresa_Institucion, Entidades, Fecha_Inicio,Fecha_Final from Exp_Directiva";
        Conexion con=null;
        try {
            con=new Conexion();
            con.conectar();
            ResultSet rst=con.ejecutaQuery(csql, null);
            Exp_Directiva expdirectiva=null;
            while(rst.next()){
                expdirectiva=new Exp_Directiva();
                expdirectiva.setCodigoExp_D(rst.getInt(1));
                expdirectiva.setExperiencia(rst.getString(2));
                expdirectiva.setEmpresa_Institucion(rst.getString(3));
                expdirectiva.setEntidades(rst.getString(4));
                expdirectiva.setFecha_Inicio(rst.getDate(5));
                expdirectiva.setFecha_Final(rst.getDate(6));
                expdirectivas.add(expdirectiva);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            if(con!=null){
                con.desconectar();
            }
        }
        return expdirectivas;
    }
}
