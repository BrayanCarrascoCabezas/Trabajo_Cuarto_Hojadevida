
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
public class FrmNuevoTitulo_Pregado extends JInternalFrame{
    List<Docente> lstDocente;
    JComboBox<Docente> cmbDocente;
    
    JLabel lblCodTituloPregado;
    JLabel lblDocente;
    JLabel lblPais;
    JLabel lblTitulo_Pregado;
    JLabel lblUniversidad;
    JLabel lblTitulo0;
    
    JTextField txtCodTituloPregado;
    
    JTextField txtPais;
    JTextField txtTitulo_Pregado;
    JTextField txtUniversidad;
   JComboBox cmbDocentes;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoTitulo_Pregado() {
        this.setSize(300, 300);
        setTitle("Titulo_Pregrado....");
	
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos de Titulo_Pregado");
        
        lblCodTituloPregado= new JLabel("Código:");
        lblDocente= new JLabel("Docente:");
        lblPais= new JLabel("Pais:");
        lblTitulo_Pregado= new JLabel("Titulo_Pregado:");
        lblUniversidad= new JLabel("Universidad:");
        
        
        txtCodTituloPregado = new JTextField(2);
        cargarDocentes();
        cmbDocente= new JComboBox(lstDocente.toArray());
        txtPais= new JTextField(2);
        txtTitulo_Pregado= new JTextField(2);
        txtUniversidad= new JTextField(2);
        
        
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.setBackground(Color.CYAN);
        
        pnlCentral.add(lblCodTituloPregado);
        pnlCentral.add(txtCodTituloPregado);
        pnlCentral.add(lblDocente);
        pnlCentral.add(cmbDocente);
        pnlCentral.add(lblPais);
        pnlCentral.add(txtPais);
        pnlCentral.add(lblTitulo_Pregado);
        pnlCentral.add(txtTitulo_Pregado);
        pnlCentral.add(lblUniversidad);
        pnlCentral.add(txtUniversidad);
        
        
                
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
        FrmNuevoTitulo_Pregado frmt= new FrmNuevoTitulo_Pregado();
        frmt.setVisible(true);
    } 
    public void cargarDocentes(){
        IDocente docenteDao = new DocenteImpl();
        try {
            lstDocente = docenteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los cursos!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void btnAceptarActionListener(ActionEvent e){
        ITitulo_Pregado tpDao=new Titulo_PregadoImpl();
        Titulo_Pregado titulo_pregado =new Titulo_Pregado();

        titulo_pregado.setCodTituloPre(Integer.parseInt(txtCodTituloPregado.getText()));
        titulo_pregado.setDocente((Docente)cmbDocente.getSelectedItem());
        titulo_pregado.setPais(txtPais.getText());
        titulo_pregado.setTitulo_pregado(txtTitulo_Pregado.getText());
        titulo_pregado.setUniversidad(txtUniversidad.getText());
        
        try{
            if(tpDao.insertar(titulo_pregado)>0){
                JOptionPane.showMessageDialog(this,"Guardado correctamente",
                "transaccion", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido",
                "error", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch(Exception ex){
             JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
 