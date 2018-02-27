package trabajo_hoja_de_vida.rnegocio.entidades;

/**
 *
 * @author eddyf
 */
public class AreaGeneral {
    
    private int codigo;
    private String descripcion;

    public AreaGeneral(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public AreaGeneral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   public int getCodigo() {
        return codigo;
    }

    public String getdescripcion() {
        return descripcion;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setdescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  @Override
    public String toString() {
        return descripcion ;
    }

    public void setDescripcion(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
 
}
