/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import trabajo_hoja_de_vida.rnegocio.dao.IAreaGeneral;
import trabajo_hoja_de_vida.rnegocio.dao.IArea_docente;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.entidades.AreaGeneral;
import trabajo_hoja_de_vida.rnegocio.entidades.Area_docente;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import trabajo_hoja_de_vida.rnegocio.impl.AreaImpl;
import trabajo_hoja_de_vida.rnegocio.impl.Area_docenteImpl;
import trabajo_hoja_de_vida.rnegocio.impl.DocenteImpl;

/*
      private Docente docente;
    private AreaGeneral areageneral; 
    */
 
public class FrmNuevoArea_Docente  extends JInternalFrame{
   
    List<Docente> lstDocente;
    JComboBox<Docente> cmbDocente;
    
    List<AreaGeneral> lstAreaGeneral;
    JComboBox<AreaGeneral> cmbAreaGeneral;
    JLabel lblTitulo0;
    JLabel lblDocente;
    JLabel lblAreaGeneral;
        
    
    JTextField txtDocente;
    JTextField txtAreaGeneral;
        
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoArea_Docente () {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Area_Docente");
        
        lblDocente = new JLabel("Id Docente:");
        lblAreaGeneral = new JLabel("ID Areageneral:");
        
        
        cargarDocente();
        cmbDocente = new JComboBox(lstDocente.toArray());
        cargarAreaGeneral();
        cmbAreaGeneral = new JComboBox(lstAreaGeneral.toArray());
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
      
        pnlCentral.add(lblDocente);
        pnlCentral.add(cmbDocente);
        pnlCentral.add(lblAreaGeneral);
        pnlCentral.add(cmbAreaGeneral);
       
        
                
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoArea_Docente  frmMenu= new FrmNuevoArea_Docente ();
        frmMenu.setVisible(true);
    } 
    public void cargarDocente(){
        IDocente docenteDao = new DocenteImpl();
        try {
            lstDocente = docenteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Proveedores!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    
    public void cargarAreaGeneral(){
        IAreaGeneral areageneralDao = new AreaImpl();
        try {
            lstAreaGeneral = areageneralDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los FacturaCompra!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IArea_docente areadocenteDao = new Area_docenteImpl();
        Area_docente areadocente = new Area_docente();
       areadocente.setDocente((Docente) cmbDocente.getSelectedItem());
       areadocente.setAreageneral((AreaGeneral) cmbAreaGeneral.getSelectedItem());
        
        
        try {
            if(areadocenteDao.insertar(areadocente)>0){
                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
}
