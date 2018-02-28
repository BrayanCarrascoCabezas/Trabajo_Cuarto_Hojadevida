
package trabajo_hoja_de_vida.rnegocio.entidades;

import java.sql.Date;
public class Exp_Directiva {
    private int CodigoExp_D;  
    private Experiencia experiencia;
    private String Empresa_Institucion;
    private String Entidades;
    private Date Fecha_Inicio;
    private Date Fecha_Final;

    public Exp_Directiva() {
    }

    public Exp_Directiva(int CodigoExp_D, Experiencia experiencia, String Empresa_Institucion, String Entidades, Date Fecha_Inicio, Date Fecha_Final) {
        this.CodigoExp_D = CodigoExp_D;
        this.experiencia = experiencia;
        this.Empresa_Institucion = Empresa_Institucion;
        this.Entidades = Entidades;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Final = Fecha_Final;
    }

    public int getCodigoExp_D() {
        return CodigoExp_D;
    }

    public void setCodigoExp_D(int CodigoExp_D) {
        this.CodigoExp_D = CodigoExp_D;
    }

    public Experiencia getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Experiencia experiencia) {
        this.experiencia = experiencia;
    }

    public String getEmpresa_Institucion() {
        return Empresa_Institucion;
    }

    public void setEmpresa_Institucion(String Empresa_Institucion) {
        this.Empresa_Institucion = Empresa_Institucion;
    }

    public String getEntidades() {
        return Entidades;
    }

    public void setEntidades(String Entidades) {
        this.Entidades = Entidades;
    }

    public Date getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(Date Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public Date getFecha_Final() {
        return Fecha_Final;
    }

    public void setFecha_Final(Date Fecha_Final) {
        this.Fecha_Final = Fecha_Final;
    }

}
