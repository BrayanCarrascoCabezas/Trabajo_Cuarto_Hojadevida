
package trabajo_hoja_de_vida.rnegocio.entidades;
import java.util.*;
public class Exp_Profecional {
private int CodigoExp;
private int CodigoE;
private String empresa_institucion;
private String posicion;
private Date fecha_inicio;
private Date fecha_final;

    public Exp_Profecional() {
    }

    public Exp_Profecional(int CodigoExp, int CodigoE, String empresa_institucion, String posicion, Date fecha_inicio, Date fecha_final) {
        this.CodigoExp = CodigoExp;
        this.CodigoE = CodigoE;
        this.empresa_institucion = empresa_institucion;
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

    public int getCodigoE() {
        return CodigoE;
    }

    public void setCodigoE(int CodigoE) {
        this.CodigoE = CodigoE;
    }

    public String getEmpresa_institucion() {
        return empresa_institucion;
    }

    public void setEmpresa_institucion(String empresa_institucion) {
        this.empresa_institucion = empresa_institucion;
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

    
    
}
