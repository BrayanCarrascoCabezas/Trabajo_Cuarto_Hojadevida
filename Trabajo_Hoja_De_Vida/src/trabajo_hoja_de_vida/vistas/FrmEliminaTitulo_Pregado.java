/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajo_hoja_de_vida.vistas;


import trabajo_hoja_de_vida.rnegocio.dao.*;
import trabajo_hoja_de_vida.rnegocio.impl.*;
import trabajo_hoja_de_vida.rnegocio.entidades.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javafx.scene.control.ComboBox;
import trabajo_hoja_de_vida.accesodatos.Conexion;
import trabajo_hoja_de_vida.accesodatos.Parametro;

public class FrmEliminaTitulo_Pregado extends JInternalFrame{
    List<Titulo_Pregado> lstTitulo_Pregado;
    JComboBox<Titulo_Pregado> cmbTitulo_Pregado;
    
    JLabel lblCodigo;
    
    JLabel lblTitulo0;
    
    JButton btnLimpiar;
    JButton btnEliminar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmEliminaTitulo_Pregado() {
        this.setSize(300, 300);
        setTitle("Elinacion de Titulo_Pregrado....");
	
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(4, 1, 5, 5));
        pnlPie.setLayout(new GridLayout(2,1,5,5));
        
        lblTitulo0 = new JLabel("Eliminacion  de Titulo_Pregado");
        
        lblCodigo= new JLabel("Código:");
         cargarTitulo_Pregado();
        cmbTitulo_Pregado= new JComboBox(lstTitulo_Pregado.toArray());
        
        
        btnLimpiar= new JButton("Limpiar");
        btnEliminar= new JButton("Eliminar");
        
        pnlCentral.setBackground(Color.YELLOW);
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(cmbTitulo_Pregado);
       
              
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnEliminarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnEliminar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmEliminaTitulo_Pregado frmt= new FrmEliminaTitulo_Pregado();
        frmt.setVisible(true);
    } 
    public void cargarTitulo_Pregado(){
        ITitulo_Pregado tpDao = new Titulo_PregadoImpl();
        try {
            lstTitulo_Pregado = tpDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar  Titulo_Pregrado!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void btnEliminarActionListener(ActionEvent e){
   
    }
}