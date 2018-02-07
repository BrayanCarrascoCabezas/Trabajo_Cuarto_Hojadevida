/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.entidades;

/**
 *
 * @author DiegoPatricio
 */
public class Declaracion {
    
    private Docente docente;
    private String descripcion;

    public Declaracion() {
    }

    public Declaracion(Docente docente, String descripcion) {
        this.docente = docente;
        this.descripcion = descripcion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
