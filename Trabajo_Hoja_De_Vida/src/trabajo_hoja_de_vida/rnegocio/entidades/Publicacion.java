
package trabajo_hoja_de_vida.rnegocio.entidades;


public class Publicacion {
    
    private int Codigo_publicacion;
    private Docente docente;
    private String titulo;
    private String editorial;
    private String año; 
    public Publicacion() {
    }

    public Publicacion(int Codigo_publicacion, Docente docente, String titulo, String editorial, String año) {
        this.Codigo_publicacion = Codigo_publicacion;
        this.docente = docente;
        this.titulo = titulo;
        this.editorial = editorial;
        this.año = año;
    }

    public int getCodigo_publicacion() {
        return Codigo_publicacion;
    }

    public void setCodigo_publicacion(int Codigo_publicacion) {
        this.Codigo_publicacion = Codigo_publicacion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }
    
}
