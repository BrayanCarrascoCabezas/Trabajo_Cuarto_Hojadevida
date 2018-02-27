/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabajo_hoja_de_vida.rnegocio.dao.ICursoMateria;
import trabajo_hoja_de_vida.rnegocio.entidades.Curso_Materia;
import trabajo_hoja_de_vida.rnegocio.impl.Curso_MateriaImpl;

/**
 *
 * @author Usuario
 */
public class FrmListaCurso_Materia extends JInternalFrame{
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jacTabla;
    
    public FrmListaCurso_Materia(){    
        this.setSize(300, 300);
        setTitle("curso materia ");
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("Listado de cursos y materia ");
        tabla=new JTable();
        jacTabla=new JScrollPane(tabla);
        this.add(lblTitulo,BorderLayout.NORTH);
        this.add(jacTabla,BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
           modelo=new DefaultTableModel();
           modelo.addColumn("Codigo curso materia ");
           modelo.addColumn("Codigo curso");
           modelo.addColumn("Codigo Materia ");
           

          
           List<Curso_Materia> lista=new ArrayList<>();
           try{
               ICursoMateria cursomateriaDao=new Curso_MateriaImpl();
               lista=cursomateriaDao.obtener();
           }catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"Error",
                JOptionPane.ERROR_MESSAGE);
    }
            
           for(Curso_Materia est:lista){
              modelo.addRow(new Object[]{est.getCurso_Materia(),est.getCodigoC(),
              est.getCodigoM()});
      
    }
           tabla.setModel(modelo);
    }
    
    
}
