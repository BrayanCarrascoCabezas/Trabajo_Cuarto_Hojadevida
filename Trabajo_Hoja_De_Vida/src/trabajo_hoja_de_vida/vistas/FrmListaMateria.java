package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabajo_hoja_de_vida.rnegocio.dao.IMateria;
import trabajo_hoja_de_vida.rnegocio.entidades.Materia;
import trabajo_hoja_de_vida.rnegocio.impl.MateriaImpl;

/**
 *
 * @author JOSEPH RAMOS
 */
public class FrmListaMateria extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmListaMateria(){
    this.setSize(600,400);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo=new JLabel("Listado de Materias");
    tabla = new JTable();
    this.add(lblTitulo,BorderLayout.NORTH);
    this.add(tabla,BorderLayout.CENTER);
    cargarTabla();
    }
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        
        List<Materia> lista = new ArrayList<>();
        try {
            IMateria materiaDao= new MateriaImpl();
            lista = materiaDao.obtener();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR"+e.getMessage(),JOptionPane.ERROR_MESSAGE);
        }
        
        for(Materia est:lista){
            modelo.addRow(new Object[]{est.getCodigo(),est.getNombre().toString()});
        }
        tabla.setModel(modelo);
    }
    
}
