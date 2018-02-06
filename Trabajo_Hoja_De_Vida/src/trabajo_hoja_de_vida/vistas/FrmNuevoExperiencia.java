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
import javax.swing.*;
import trabajo_hoja_de_vida.rnegocio.dao.IDocente;
import trabajo_hoja_de_vida.rnegocio.dao.IExperiencia;
import trabajo_hoja_de_vida.rnegocio.entidades.Docente;
import trabajo_hoja_de_vida.rnegocio.entidades.Experiencia;
import trabajo_hoja_de_vida.rnegocio.impl.DocenteImpl;
import trabajo_hoja_de_vida.rnegocio.impl.ExperienciaImpl;

/**
 *
 * @author CRISTIAN
 */
public class FrmNuevoExperiencia extends JInternalFrame {
    List<Docente> lstDocente;
    JComboBox<Docente> cmbDocente;
    JLabel lblCodigoE;
    JLabel lblDocente;
    JLabel lblAños;
    JLabel lblLugar;
    JLabel lblDescripcion;
    JLabel lblTitulo0;
    
    JTextField txtCodigoE;
    JTextField txtAños;
    JTextField txtLugar;
    JTextField txtDescripcion;
    
   
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoExperiencia() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Experiencia");
        
        lblCodigoE= new JLabel("Código:");
        lblDocente= new JLabel("Docente:");
        lblAños= new JLabel("Años:");
        lblLugar= new JLabel("Lugar:");
        lblDescripcion= new JLabel("Descripcion:");
        
        txtCodigoE = new JTextField(2);
        cargarDocente();
        cmbDocente= new JComboBox(lstDocente.toArray());
        txtAños= new JTextField(2);
        txtLugar= new JTextField(2);
        txtDescripcion= new JTextField(2);
                
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblCodigoE);
        pnlCentral.add(txtCodigoE);
        pnlCentral.add(lblDocente);
        pnlCentral.add(cmbDocente);
        pnlCentral.add(lblAños);
        pnlCentral.add(txtAños);
        pnlCentral.add(lblLugar);
        pnlCentral.add(txtLugar);
        pnlCentral.add(lblDescripcion);
        pnlCentral.add(txtDescripcion);
        
        
                
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
        FrmNuevoExperiencia frmMenu= new FrmNuevoExperiencia();
        frmMenu.setVisible(true);
    } 
    public void cargarDocente(){
        IDocente docenteDao = new DocenteImpl();
        try {
            lstDocente = docenteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Docentes!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void btnAceptarActionListener(ActionEvent e){
        Experiencia experiencia = new Experiencia();
        IExperiencia experienciaDao = new ExperienciaImpl();
        experiencia.setCodigoE(Integer.parseInt(txtCodigoE.getText()));
        experiencia.setDocente((Docente) cmbDocente.getSelectedItem());
        experiencia.setAños(Integer.parseInt(txtAños.getText()));
        experiencia.setLugar(txtDescripcion.getText());
        experiencia.setDescripcion(txtDescripcion.getText());     

        try {
            if (experienciaDao.insertar(experiencia) > 0) {
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!",
                        "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            } else {
            JOptionPane.showMessageDialog(this,"Error desconocido: ",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
}

