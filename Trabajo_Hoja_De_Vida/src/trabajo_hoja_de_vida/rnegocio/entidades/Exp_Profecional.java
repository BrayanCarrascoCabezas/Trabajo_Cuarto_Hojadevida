
package trabajo_hoja_de_vida.rnegocio.entidades;

import java.util.Date;

public class Exp_Profecional {
    
   private int CodigoExp;
   private Experiencia experiencia;
   private String empresa_nstitucion;
   private String posicion;
   private Date fecha_inicio;
   private Date fecha_final;

    public Exp_Profecional() {
    }

    public Exp_Profecional(int CodigoExp, Experiencia experiencia, String empresa_nstitucion, String posicion, Date fecha_inicio, Date fecha_final) {
        this.CodigoExp = CodigoExp;
        this.experiencia = experiencia;
        this.empresa_nstitucion = empresa_nstitucion;
        this.posicion = posicion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
    }

    public int getCodigoExp() {
        return CodigoExp;
    }

    public void setCodigoExp(int CodigoExp) {
        this.CodigoExp = CodigoExp;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }

    public String getEmpresa_nstitucion() {
        return empresa_nstitucion;
    }

    public void setEmpresa_nstitucion(String empresa_nstitucion) {
        this.empresa_nstitucion = empresa_nstitucion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(Date fecha_final) {
        this.fecha_final = fecha_final;
    }
   
   @Override
   public String toString(){
       return empresa_nstitucion;
   }
   

}
