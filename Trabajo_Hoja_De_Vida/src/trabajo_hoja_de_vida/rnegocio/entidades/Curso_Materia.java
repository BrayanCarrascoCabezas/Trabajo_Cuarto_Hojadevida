/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.rnegocio.entidades;

/**
 *
 * @author Usuario
 */
public class Curso_Materia {
    private int Curso_Materia;
    private int CodigoC;
    private int CodigoM;

    public Curso_Materia() {
    }

    public Curso_Materia(int Curso_Materia, int CodigoC, int CodigoM) {
        this.Curso_Materia = Curso_Materia;
        this.CodigoC = CodigoC;
        this.CodigoM = CodigoM;
    }

    public int getCurso_Materia() {
        return Curso_Materia;
    }

    public void setCurso_Materia(int Curso_Materia) {
        this.Curso_Materia = Curso_Materia;
    }

    public int getCodigoC() {
        return CodigoC;
    }

    public void setCodigoC(int CodigoC) {
        this.CodigoC = CodigoC;
    }

    public int getCodigoM() {
        return CodigoM;
    }

    public void setCodigoM(int CodigoM) {
        this.CodigoM = CodigoM;
    }
    
    
    
}
