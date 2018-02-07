/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.util.ArrayList;
import java.util.List;

public class FrmListaTitulo_Pregado extends JInternalFrame{
JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jacTabla;
    
    public FrmListaTitulo_Pregado(){    
        this.setSize(800, 600);
        setTitle("Titulo_Pregado....");
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo=new JLabel("Listado de Titulo_Pregado.");
        tabla=new JTable();
        jacTabla=new JScrollPane(tabla);
        this.add(lblTitulo,BorderLayout.NORTH);
        this.add(jacTabla,BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
           modelo=new DefaultTableModel();
           modelo.addColumn("Codigo_Pregado");
         //  modelo.addColumn("Codigo_Docente");
           modelo.addColumn("Pais");
           modelo.addColumn("Titulo_Pregrado");
           modelo.addColumn("Universidad");

          
           List<Titulo_Pregado> lista=new ArrayList<>();
           try{
               ITitulo_Pregado tpDao=new Titulo_PregadoImpl();
               lista=tpDao.obtener();
           }catch(Exception e){
        JOptionPane.showMessageDialog(this,e.getMessage(),"Error",
                JOptionPane.ERROR_MESSAGE);
    }
            
           for(Titulo_Pregado est:lista){
              modelo.addRow(new Object[]{est.getCodTituloPre(),est.getPais(),
              est.getTitulo_pregado(),est.getUniversidad()});
      
    }
           tabla.setModel(modelo);
    }
    
}
