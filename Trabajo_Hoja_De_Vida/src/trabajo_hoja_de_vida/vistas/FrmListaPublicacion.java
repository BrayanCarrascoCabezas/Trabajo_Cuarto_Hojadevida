
package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabajo_hoja_de_vida.rnegocio.dao.IPublicacion;
import trabajo_hoja_de_vida.rnegocio.entidades.Publicacion;
import trabajo_hoja_de_vida.rnegocio.impl.PublicacionImpl;

/**
 *
 * @author Francisco
 */
public class FrmListaPublicacion extends JInternalFrame {
   JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmListaPublicacion(){
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo=new JLabel("Listado de Publicaciones");
    tabla = new JTable();
    this.add(lblTitulo,BorderLayout.NORTH);
    this.add(tabla,BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
         modelo.addColumn("Codigo de publicacion");
        modelo.addColumn("Docente");
        modelo.addColumn("Titulo");
        modelo.addColumn("Año de Publicacion");
        modelo.addColumn("Editorial"); 
        List<Publicacion> lista = new ArrayList<>();
        try {
            IPublicacion publicacionDao= new PublicacionImpl();
            lista = publicacionDao.obtener();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        for(Publicacion est:lista){
            modelo.addRow(new Object[]{est.getCod_publicacion(),est.getDocente(),est.getTitulo(),est.getEditorial(),est.getAño()});
        }
        tabla.setModel(modelo);
    }
}
    
    
    
    
    
    

