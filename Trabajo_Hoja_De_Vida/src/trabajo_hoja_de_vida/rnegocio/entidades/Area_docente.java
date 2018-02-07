/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.entidades;

/**
 *
 * @author Segovia
 */
public class Area_docente {
    private Docente docente;
    //private Area area; 

    public Area_docente() {
    }

    public Area_docente(Docente docente/*,Area area*/) {
        this.docente = docente;
      //  this.area = area;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
/*
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
  */  
}
