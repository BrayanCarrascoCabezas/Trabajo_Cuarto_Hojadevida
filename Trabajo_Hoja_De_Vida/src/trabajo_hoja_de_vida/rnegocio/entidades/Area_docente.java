/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.entidades;

import java.awt.geom.Area;

/**
 *
 * @author Segovia
 */
public class Area_docente {
    private Docente docente;
    private AreaGeneral areageneral; 

    public Area_docente() {
    }

    public Area_docente(Docente docente, AreaGeneral areageneral) {
        this.docente = docente;
        this.areageneral = areageneral;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public AreaGeneral getAreageneral() {
        return areageneral;
    }

    public void setAreageneral(AreaGeneral areageneral) {
        this.areageneral = areageneral;
    }

   
    

    
   
}
