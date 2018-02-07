package trabajo_hoja_de_vida.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.watermark.SubstanceImageWatermark;

public class FrmMenuPrincipal extends JFrame {

    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    
    JMenu mnDocente;
    JMenuItem mniNuevoDocente;
    JMenuItem mniModificaDocente;
    JMenuItem mniEliminaDocente;
    JMenuItem mniBuscaDocente;
    JMenuItem mniListaDocente;
    
    JMenu mnTitulo_Pregado;
    JMenuItem mniNuevoTitulo_Pregado;
    JMenuItem mniModificaTitulo_Pregado;
    JMenuItem mniEliminaTitulo_Pregado;
    JMenuItem mniBuscaTitulo_Pregado;
    JMenuItem mniListaTitulo_Pregado;

    JDesktopPane dkpEscritorio;

    public FrmMenuPrincipal() {
        dkpEscritorio= new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));
        setTitle("HOJA DE VIDA....");
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Sesión");
        mniSalir = new JMenuItem("Salir");
        mniSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
                
        mnDocente= new JMenu("Docente");
        mniNuevoDocente= new JMenuItem("Nuevo");
        mniNuevoDocente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoDocenteActionPerformed(e);
            }
        });
        mniModificaDocente= new JMenuItem("Modifica");
        mniEliminaDocente= new JMenuItem("Elimina");
        mniBuscaDocente= new JMenuItem("Busca");
        mniListaDocente= new JMenuItem("Lista");

        mniListaDocente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaDocenteActionPerformed(e);
            }
        });
        
        mnDocente.add(mniNuevoDocente);
        mnDocente.add(mniModificaDocente);
        mnDocente.add(mniEliminaDocente);
        mnDocente.addSeparator();
        mnDocente.add(mniBuscaDocente);
        mnDocente.add(mniListaDocente);
        
        //
        mnTitulo_Pregado= new JMenu("Titulo_Pregrado");
        mniNuevoTitulo_Pregado= new JMenuItem("Nuevo");
        mniNuevoTitulo_Pregado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoTitulo_PregadoActionPerformed(e);
            }
        });
        mniModificaTitulo_Pregado= new JMenuItem("Modifica");
        mniEliminaTitulo_Pregado= new JMenuItem("Elimina");
        mniEliminaTitulo_Pregado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniEliminaTitulo_PregadoActionPerformed(e);
            }
        });
        mniBuscaTitulo_Pregado= new JMenuItem("Busca");
        mniListaTitulo_Pregado= new JMenuItem("Lista");
        mniListaTitulo_Pregado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaTitulo_PregadoActionPerformed(e);
            }
        });
        
        mnTitulo_Pregado.add(mniNuevoTitulo_Pregado);
        mnTitulo_Pregado.add(mniModificaTitulo_Pregado);
        mnTitulo_Pregado.add(mniEliminaTitulo_Pregado);
        mnTitulo_Pregado.addSeparator();
        mnTitulo_Pregado.add(mniBuscaTitulo_Pregado);
        mnTitulo_Pregado.add(mniListaTitulo_Pregado);
        
               
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnDocente);
        mnbPrincipal.add(mnTitulo_Pregado);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
    }
    
    public void mniEliminaTitulo_PregadoActionPerformed(ActionEvent e){
        FrmEliminaTitulo_Pregado frm = new FrmEliminaTitulo_Pregado();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniNuevoTitulo_PregadoActionPerformed(ActionEvent e){
        FrmNuevoTitulo_Pregado frm = new FrmNuevoTitulo_Pregado();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniListaTitulo_PregadoActionPerformed(ActionEvent e){
    FrmListaTitulo_Pregado frm= new FrmListaTitulo_Pregado();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
    
    
        public void mniNuevoDocenteActionPerformed(ActionEvent e){
        FrmNuevoDocente frm = new FrmNuevoDocente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaDocenteActionPerformed(ActionEvent e)
    {
    FrmListaDocente frm= new FrmListaDocente();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
    
    
    public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
  
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
        SubstanceLookAndFeel.setSkin("org.jvnet.substance.watermark. SubstanceCopperplateEngravingWatermark"); // Setencia que aplica el skin Creme de Substance
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);
    }
}
