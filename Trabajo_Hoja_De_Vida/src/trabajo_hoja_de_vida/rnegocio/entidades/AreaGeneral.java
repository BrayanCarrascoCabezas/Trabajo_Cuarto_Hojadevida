package trabajo_hoja_de_vida.rnegocio.entidades;

/**
 *
 * @author eddyf
 */
public class AreaGeneral {
    
    private int codigo;
    private String descripcion;

    public AreaGeneral() {
    }
    
    

    public AreaGeneral(int codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
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

     
 
}
