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
     /*AREA*/
    
    JMenu mnArea;
    JMenuItem mniNuevoArea;
    JMenuItem mniModificarArea;
    JMenuItem mniEliminaArea;
    JMenuItem mniBuscaArea;
    JMenuItem mniListaArea;
    
    //Area_docnte
    JMenu mnAreadocente;
    JMenuItem mniNuevoAreadocente;
    JMenuItem mniModificarAreadocente;
    JMenuItem mniEliminaAreadcente;
    JMenuItem mniBuscaAreadcente;
    JMenuItem mniListaAreadocente;
    
    
        /*CURSO*/
    JMenu mnCurso;
    JMenuItem mniNuevoCurso;
    JMenuItem mniModificaCurso;
    JMenuItem mniEliminaCurso;
    JMenuItem mniBuscaCurso;
    JMenuItem mniListaCurso;
    
    JMenu mnTitulo_Pregado;
    JMenuItem mniNuevoTitulo_Pregado;
    JMenuItem mniModificaTitulo_Pregado;
    JMenuItem mniEliminaTitulo_Pregado;
    JMenuItem mniBuscaTitulo_Pregado;
    JMenuItem mniListaTitulo_Pregado;
    //PUBLICACIONES
    JMenu mnPublicacion;
    JMenuItem mniNuevoPublicacion;
    JMenuItem mniModificaPublicacion;
    JMenuItem mniEliminaPublicacion;
    JMenuItem mniBuscaPublicacion;
    JMenuItem mniListaPublicacion;
    //EXPERIENCIA_DOCENTE
    JMenu mnExp_Docente;
    JMenuItem mniNuevoExp_Docente;
    JMenuItem mniModificaExp_Docente;
    JMenuItem mniEliminaExp_Docente;
    JMenuItem mniBuscaExp_Docente;
    JMenuItem mniListaExp_Docente;
    
    
        //EXPERIENCIA_DIRECTIVA
    JMenu mnExp_Directiva;
    JMenuItem mniNuevoExp_Directiva;
    JMenuItem mniModificaExp_Directiva;
    JMenuItem mniEliminaExp_Directiva;
    JMenuItem mniBuscaExp_Directiva;
    JMenuItem mniListaExp_Directiva;
    

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
               
        mnArea= new JMenu("Area");
        mniNuevoArea= new JMenuItem("Nuevo");
        mniNuevoArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoAreaActionPerformed(e);
            }
        });
        mniModificarArea= new JMenuItem("Modifica");
        mniEliminaArea= new JMenuItem("Elimina");
        mniBuscaArea= new JMenuItem("Busca");
        mniListaArea= new JMenuItem("Lista");

        mniListaArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaAreaActionPerformed(e);
            }
        });
        
        mnArea.add(mniNuevoArea);
        mnArea.add(mniModificarArea);
        mnArea.add(mniEliminaArea);
        mnArea.addSeparator();
        mnArea.add(mniBuscaArea);
        mnArea.add(mniListaArea);
        
        //Area_docente
        mnAreadocente= new JMenu("Area_Docente");
        mniNuevoAreadocente= new JMenuItem("Nuevo");
        mniNuevoAreadocente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoExp_DocenteActionPerformed(e);
            }
        });
        mniModificarAreadocente= new JMenuItem("Modifica");
        mniEliminaAreadcente= new JMenuItem("Elimina");
        mniBuscaAreadcente= new JMenuItem("Busca");
        mniListaAreadocente= new JMenuItem("Lista");

        mniListaAreadocente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaExp_DocenteActionPerformed(e);
            }
        });
        
        mnAreadocente.add(mniBuscaAreadcente);
        mnAreadocente.add(mniModificarAreadocente);
        mnAreadocente.add(mniEliminaAreadcente);
        mnCurso.addSeparator();
        mnAreadocente.add(mniBuscaAreadcente);
        mnAreadocente.add(mniListaAreadocente);  
        
        //
        
        
        /*CURSO*/        
        mnCurso= new JMenu("Curso");
        mniNuevoCurso= new JMenuItem("Nuevo");
        mniNuevoCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoCursoActionPerformed(e);
            }
        });
        mniModificaCurso= new JMenuItem("Modifica");
        mniEliminaCurso= new JMenuItem("Elimina");
        mniBuscaCurso= new JMenuItem("Busca");
        mniListaCurso= new JMenuItem("Lista");

        mniListaCurso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaCursoActionPerformed(e);
            }
        });
        
        mnCurso.add(mniNuevoCurso);
        mnCurso.addSeparator();
        mnCurso.add(mniModificaCurso);
        mnCurso.addSeparator();
        mnCurso.add(mniEliminaCurso);
        mnCurso.addSeparator();
        mnCurso.add(mniBuscaCurso);
        mnCurso.addSeparator();
        mnCurso.add(mniListaCurso);

        
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
        
         //publicacion
         
        mnPublicacion= new JMenu("PUBLICACION");
        mniNuevoPublicacion= new JMenuItem("Nuevo");
        mniNuevoPublicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoPublicacionActionPerformed(e);

            }
        });
        
        mniModificaPublicacion= new JMenuItem("Modifica");
        mniEliminaPublicacion= new JMenuItem("Elimina");
        mniBuscaPublicacion= new JMenuItem("Busca");
        mniListaPublicacion= new JMenuItem("Lista");
        mniListaPublicacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaDocenteActionPerformed(e);
            }
        });
        
        mnPublicacion.add(mniNuevoPublicacion);
        mnPublicacion.add(mniModificaPublicacion);
        mnPublicacion.add(mniEliminaPublicacion);
        mnPublicacion.addSeparator();
        mnPublicacion.add(mniBuscaPublicacion);
        mnPublicacion.add(mniListaPublicacion);
        
        /*EXPERIENCIA_DOCENTE*/        
        mnExp_Docente= new JMenu("Exp_Docente");
        mniNuevoExp_Docente= new JMenuItem("Nuevo");
        mniNuevoExp_Docente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoExp_DocenteActionPerformed(e);
            }
        });
        mniModificaExp_Docente= new JMenuItem("Modifica");
        mniEliminaExp_Docente= new JMenuItem("Elimina");
        mniBuscaExp_Docente= new JMenuItem("Busca");
        mniListaExp_Docente= new JMenuItem("Lista");

        mniListaExp_Docente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaExp_DocenteActionPerformed(e);
            }
        });
        
        mnCurso.add(mniNuevoExp_Docente);
        mnCurso.add(mniModificaExp_Docente);
        mnCurso.add(mniEliminaExp_Docente);
        mnCurso.addSeparator();
        mnCurso.add(mniBuscaExp_Docente);
        mnCurso.add(mniListaExp_Docente);
           
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnDocente);
        mnbPrincipal.add(mnArea);
        mnbPrincipal.add(mnTitulo_Pregado);
        mnbPrincipal.add(mnPublicacion);
        mnbPrincipal.add(mnExp_Docente);
        mnbPrincipal.add(mnAreadocente);
        
        
        
        //EXP_DIRECTIVA
        mnExp_Directiva= new JMenu("EXPERIENCIA_DIRECTIVA");
        mniNuevoExp_Directiva= new JMenuItem("Nuevo");
        mniNuevoExp_Directiva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoExp_DirectivaActionPerformed(e);

            }

            private void mniNuevoExp_DirectivaActionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        mniModificaExp_Directiva= new JMenuItem("Modifica");
        mniEliminaExp_Directiva= new JMenuItem("Elimina");
        mniBuscaExp_Directiva= new JMenuItem("Busca");
        mniListaExp_Directiva= new JMenuItem("Lista");
        mniListaExp_Directiva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaExp_DirectivaActionPerformed(e);
            }

            private void mniListaExp_DirectivaActionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        mnExp_Directiva.add(mniNuevoExp_Directiva);
        mnExp_Directiva.add(mniModificaExp_Directiva);
        mnExp_Directiva.add(mniEliminaExp_Directiva);
        mnExp_Directiva.addSeparator();
        mnExp_Directiva.add(mniBuscaExp_Directiva);
        mnExp_Directiva.add(mniListaExp_Directiva);
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
    //
    
    public void mniNuevoAreaActionPerformed(ActionEvent e){
        FrmNuevoArea frm = new FrmNuevoArea();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaAreaActionPerformed(ActionEvent e)
    {
    FrmListaArea frm= new FrmListaArea();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
    //Areadocente
      public void mniNuevoArea_DocentePerformed(ActionEvent e){
        FrmNuevoArea_Docente frm = new FrmNuevoArea_Docente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaAreaDocenteActionPerformed(ActionEvent e)
    {
    FrmListaAreaDocente frm= new FrmListaAreaDocente();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
    
    //
    
    	/*CURSO*/
        public void mniNuevoCursoActionPerformed(ActionEvent e){
        FrmCursoNuevo frm = new FrmCursoNuevo();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaCursoActionPerformed(ActionEvent e)
    {
    FrmCursoLista frm= new FrmCursoLista();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
 
    //PUBLICACION
    public void  mniNuevoPublicacionActionPerformed(ActionEvent e){
        FrmNuevoPublicacion frm = new FrmNuevoPublicacion();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaPublicacionActionPerformed(ActionEvent e)
    {
    FrmListaPublicacion frm= new FrmListaPublicacion();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
    //Experiencia_Docente
    public void mniNuevoExp_DocenteActionPerformed(ActionEvent e){
        FrmNuevoExp_Docente frm = new FrmNuevoExp_Docente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    public void mniListaExp_DocenteActionPerformed(ActionEvent e)
    {
    FrmListaExp_Docente frm= new FrmListaExp_Docente();
    dkpEscritorio.add(frm);
    frm.setVisible(true);
    }
    
    
    /// Exp_Directiva
        public void mniNuevoExp_DirectivaActionPerformed(ActionEvent e){
        FrmNuevoExp_Directiva frm = new FrmNuevoExp_Directiva();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    public void mniListaExp_DirectivaActionPerformed(ActionEvent e){
    FrmListaExp_Directiva frm= new FrmListaExp_Directiva();
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
