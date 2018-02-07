
package trabajo_hoja_de_vida.rnegocio.entidades;


public class Curso_Seminario {
    
    private Docente docente;
    private int cod_CursoSeminario;
    private String nombreCS;
    private int horas;
    private String ubicacion;
    private String descripcion;

    public Curso_Seminario() {
    }

    public Curso_Seminario(Docente docente, int cod_CursoSeminario, String nombreCS, int horas, String ubicacion, String descripcion) {
        this.docente = docente;
        this.cod_CursoSeminario = cod_CursoSeminario;
        this.nombreCS = nombreCS;
        this.horas = horas;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getCod_CursoSeminario() {
        return cod_CursoSeminario;
    }

    public void setCod_CursoSeminario(int cod_CursoSeminario) {
        this.cod_CursoSeminario = cod_CursoSeminario;
    }

    public String getNombreCS() {
        return nombreCS;
    }

    public void setNombreCS(String nombreCS) {
        this.nombreCS = nombreCS;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
