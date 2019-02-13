

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.text.Document;
import obj.Equipo;
import obj.Ficha;
import obj.Jugador;
import obj.Partido;
import org.dom4j.DocumentException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaQuery;
import sun.swing.SwingUtilities2.Section;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public class EnJuego extends javax.swing.JFrame {

   static  Equipo local = new Equipo();
   static  Equipo visitante = new Equipo();
   private Partido partido = new Partido();
   private int PuntosLocal = 0;
   private int PuntosVisit = 0;
   private BigDecimal idPartido;
   
    /**
     * Creates new form EnJuego
     */
    public EnJuego(Equipo local, Equipo visitante) {
        this.local = local;
        this.visitante = visitante;
        initComponents();
        setLocationRelativeTo(null);
        setSize(922, 670);
        setTitle("partido");
        cargarEquipo(local,visitante);
        partido.setLocal(local.toString());
        partido.setVisitante(visitante.toString());
        generarIdPartido();
        partido.setPtslocal(BigDecimal.ZERO);
        partido.setPtsvisit(BigDecimal.ZERO);
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(partido);
        s.getTransaction().commit();
        puntosLocalTf.setText(Integer.toString(PuntosLocal));
        puntosVisitaTf.setText(Integer.toString(PuntosVisit));
        s.close();     
    }
    
    
    
    
    
   public void cargarEquipo(Equipo local,Equipo visitante){
        ArrayList<Jugador> jugadores =  new ArrayList();
        DefaultTableModel tModelLocal = (DefaultTableModel) tableLocal.getModel();
        DefaultTableModel tModelVisit = (DefaultTableModel) tableVisit.getModel();
        tModelVisit.setRowCount(0);
        tModelLocal.setRowCount(0);
        String datos[] = new String[4];
         Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Jugador.class);
        jugadores = (ArrayList<Jugador>) criteria.list();
        for(Jugador j : jugadores){
            if(j.getEquipo().toString().equals(local.toString())){  
                datos[0] = j.getApellido();
                datos[1] = j.getNombre();
                datos[2] = j.getDni().toString();
                datos[3] = j.getDorsal();
                tModelLocal.addRow(datos);}
            if(j.getEquipo().toString().equals(visitante.toString())){
                datos[0] = j.getApellido();
                datos[1] = j.getNombre();
                datos[2] = j.getDni().toString();
                datos[3] = j.getDorsal();
                tModelVisit.addRow(datos);
                 }
        }   
     s.close();
   }
   public void generarIdPartido(){
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        String query1 = "from Partido Order by idPartido DESC";
         Query query = s.createQuery(query1);
         List list = query.list();
         if (list.isEmpty())
             partido.setIdpartido(BigDecimal.ZERO);
         else{
             Partido ultimo = (Partido)list.get(0);
             BigDecimal Valor1 = new BigDecimal(1);
             partido.setIdpartido(ultimo.getIdpartido().add(Valor1));
             idPartido = ultimo.getIdpartido().add(Valor1);
         }
        s.close();
   }
 
   
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableLocal = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableVisit = new javax.swing.JTable();
        buttAsistencia = new javax.swing.JButton();
        fullbtn = new javax.swing.JButton();
        robobtn = new javax.swing.JButton();
        perdidaBtn = new javax.swing.JButton();
        rebOffBtn = new javax.swing.JButton();
        rebDefBtn = new javax.swing.JButton();
        bloqueoBtn = new javax.swing.JButton();
        puntosLocalTf = new java.awt.TextField();
        puntosVisitaTf = new java.awt.TextField();
        jPanel1 = new javax.swing.JPanel();
        tiroBtn = new javax.swing.JButton();
        estadisticasBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        getContentPane().setLayout(null);

        tableLocal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apelllido", "Dni", "Numero"
            }
        ));
        tableLocal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLocalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLocal);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 14, 300, 290);

        tableVisit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Dni", "Numero"
            }
        ));
        jScrollPane2.setViewportView(tableVisit);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(570, 20, 320, 280);

        buttAsistencia.setText("asistencia");
        buttAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttAsistenciaActionPerformed(evt);
            }
        });
        getContentPane().add(buttAsistencia);
        buttAsistencia.setBounds(10, 440, 150, 25);

        fullbtn.setText("foul");
        fullbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullbtnActionPerformed(evt);
            }
        });
        getContentPane().add(fullbtn);
        fullbtn.setBounds(200, 440, 53, 25);

        robobtn.setText("robo");
        robobtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                robobtnActionPerformed(evt);
            }
        });
        getContentPane().add(robobtn);
        robobtn.setBounds(470, 440, 59, 25);

        perdidaBtn.setText("perdida");
        perdidaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perdidaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(perdidaBtn);
        perdidaBtn.setBounds(580, 440, 75, 25);

        rebOffBtn.setText("Reb Off");
        rebOffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rebOffBtnActionPerformed(evt);
            }
        });
        getContentPane().add(rebOffBtn);
        rebOffBtn.setBounds(710, 440, 75, 25);

        rebDefBtn.setText("Reb Def");
        rebDefBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rebDefBtnActionPerformed(evt);
            }
        });
        getContentPane().add(rebDefBtn);
        rebDefBtn.setBounds(820, 440, 79, 25);

        bloqueoBtn.setText("bloqueo");
        bloqueoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloqueoBtnActionPerformed(evt);
            }
        });
        getContentPane().add(bloqueoBtn);
        bloqueoBtn.setBounds(320, 440, 77, 25);

        puntosLocalTf.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        puntosLocalTf.setText("textField1");
        puntosLocalTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                puntosLocalTfActionPerformed(evt);
            }
        });
        getContentPane().add(puntosLocalTf);
        puntosLocalTf.setBounds(330, 150, 80, 60);

        puntosVisitaTf.setFont(new java.awt.Font("Castellar", 1, 48)); // NOI18N
        puntosVisitaTf.setText("textField2");
        getContentPane().add(puntosVisitaTf);
        puntosVisitaTf.setBounds(470, 150, 80, 60);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(null);

        tiroBtn.setText("Tiro");
        tiroBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tiroBtnActionPerformed(evt);
            }
        });
        jPanel1.add(tiroBtn);
        tiroBtn.setBounds(280, 500, 340, 50);

        estadisticasBtn.setText("estadisticas Parciales");
        estadisticasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadisticasBtnActionPerformed(evt);
            }
        });
        jPanel1.add(estadisticasBtn);
        estadisticasBtn.setBounds(330, 280, 190, 25);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 920, 650);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableLocalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLocalMouseClicked
           
    }//GEN-LAST:event_tableLocalMouseClicked

    private void buttAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttAsistenciaActionPerformed
       // TODO add your handling code here:
      String dniJugador = getSelectedJugador();
       String equipo = getEquipoJugador(dniJugador);
       System.out.println(equipo);
       Session s = NewHibernateUtil.getSessionFactory().openSession();
       s.beginTransaction();
       List list = existeFicha(dniJugador);
       if (!(list.isEmpty())){
           Ficha f =(Ficha) list.get(0);
           BigDecimal Valor1 = new BigDecimal(1);//creo un Big decimal que vale 1 para sumarle 1 a las asistencias existentes
           f.setAsistencias(f.getAsistencias().add(Valor1));
           s.update(f);
           s.getTransaction().commit();
       }
         else{
                Ficha f = creaFicha(dniJugador,equipo);
                f.setAsistencias(BigDecimal.ONE);
                s.save(f);
                s.getTransaction().commit();
         }        
       s.close();
       tableVisit.clearSelection();
        tableLocal.clearSelection();
       
    }//GEN-LAST:event_buttAsistenciaActionPerformed

    private void fullbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullbtnActionPerformed
       // TODO add your handling code here:
        String dniJugador = getSelectedJugador();
        String equipo = getEquipoJugador(dniJugador);
        System.out.println(equipo);
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List list = existeFicha(dniJugador);
        if (!(list.isEmpty())){
             Ficha f =(Ficha) list.get(0);
             BigDecimal Valor1 = new BigDecimal(1);//creo un Big decimal que vale 1 para sumarle 1 a las asistencias existentes
             f.setFules(f.getFules().add(Valor1)); 
             s.update(f);
             s.getTransaction().commit();
        }
         else{
                Ficha f = creaFicha(dniJugador,equipo);
                f.setFules(BigDecimal.ONE);
                s.save(f);
                s.getTransaction().commit();     
         }     
       s.close();  
       tableVisit.clearSelection();
        tableLocal.clearSelection();
    }//GEN-LAST:event_fullbtnActionPerformed

    private void bloqueoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloqueoBtnActionPerformed
        // TODO add your handling code here:
        String dniJugador = getSelectedJugador();
        String equipo = getEquipoJugador(dniJugador);
        System.out.println(equipo);
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List list = existeFicha(dniJugador);
        if (!(list.isEmpty())){
             Ficha f =(Ficha) list.get(0);
             BigDecimal Valor1 = new BigDecimal(1);//creo un Big decimal que vale 1 para sumarle 1 a las asistencias existentes
             f.setTapones(f.getTapones().add(Valor1)); 
             s.update(f);
             s.getTransaction().commit();
        }
         else{
                Ficha f = creaFicha(dniJugador,equipo);
                f.setTapones(BigDecimal.ONE);
                s.save(f);
                s.getTransaction().commit();     
         }     
       s.close();
       tableVisit.clearSelection();
        tableLocal.clearSelection();
    }//GEN-LAST:event_bloqueoBtnActionPerformed

    private void perdidaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perdidaBtnActionPerformed
        // TODO add your handling code here:
        String dniJugador = getSelectedJugador();
        System.out.println(dniJugador);
        String equipo = getEquipoJugador(dniJugador);
        System.out.println(equipo);
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List list = existeFicha(dniJugador);
        if (!(list.isEmpty())){
             Ficha f =(Ficha) list.get(0);
             BigDecimal Valor1 = new BigDecimal(1);//creo un Big decimal que vale 1 para sumarle 1 a las asistencias existentes
             f.setPerdidas(f.getPerdidas().add(Valor1)); 
             s.update(f);
             s.getTransaction().commit();
        }
         else{
                Ficha f = creaFicha(dniJugador,equipo);
                f.setPerdidas(BigDecimal.ONE);
                s.save(f);
                s.getTransaction().commit();     
         }     
       s.close();
       tableVisit.clearSelection();
        tableLocal.clearSelection();
    }//GEN-LAST:event_perdidaBtnActionPerformed

    private void robobtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_robobtnActionPerformed
        String dniJugador = getSelectedJugador();
        String equipo = getEquipoJugador(dniJugador);
        System.out.println(equipo);
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List list = existeFicha(dniJugador);
        if (!(list.isEmpty())){
             Ficha f =(Ficha) list.get(0);
             BigDecimal Valor1 = new BigDecimal(1);//creo un Big decimal que vale 1 para sumarle 1 a las asistencias existentes
             f.setRobos(f.getRobos().add(Valor1)); 
             s.update(f);
             s.getTransaction().commit();
        }
         else{
                Ficha f = creaFicha(dniJugador,equipo);
                f.setRobos(BigDecimal.ONE);
                s.save(f);
                s.getTransaction().commit();     
         }     
       s.close();
       tableVisit.clearSelection();
        tableLocal.clearSelection();
    }//GEN-LAST:event_robobtnActionPerformed

    private void rebOffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rebOffBtnActionPerformed
        // TODO add your handling code here:
        String dniJugador = getSelectedJugador();
        String equipo = getEquipoJugador(dniJugador);
        System.out.println(equipo);
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        List list = existeFicha(dniJugador);
        if (!(list.isEmpty())){
             Ficha f =(Ficha) list.get(0);
             BigDecimal Valor1 = new BigDecimal(1);//creo un Big decimal que vale 1 para sumarle 1 a las asistencias existentes
             f.setRebOfensivos(f.getRebOfensivos().add(Valor1));
             f.setRebotes(f.getRebotes().add(Valor1));
             s.update(f);
             s.getTransaction().commit();
        }
         else{
                Ficha f = creaFicha(dniJugador,equipo);
                f.setRebOfensivos(BigDecimal.ONE);
                f.setRebotes(BigDecimal.ONE);
                s.save(f);
                s.getTransaction().commit();     
         }     
       s.close();
       tableVisit.clearSelection();
        tableLocal.clearSelection();
    }//GEN-LAST:event_rebOffBtnActionPerformed

    private void rebDefBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rebDefBtnActionPerformed
        // TODO add your handling code here:
        String dniJugador = getSelectedJugador();
        String equipo = getEquipoJugador(dniJugador);
        System.out.println(equipo);
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
         List list = existeFicha(dniJugador);
        if (!(list.isEmpty())){
             Ficha f =(Ficha) list.get(0);
             BigDecimal Valor1 = new BigDecimal(1);//creo un Big decimal que vale 1 para sumarle 1 a las asistencias existentes
             f.setRebDefensivos(f.getRebDefensivos().add(Valor1)); 
             f.setRebotes(f.getRebotes().add(Valor1));
         s.update(f);
        s.getTransaction().commit();
        }
         else{
                Ficha ficha = creaFicha(dniJugador,equipo);
                ficha.setRebDefensivos(BigDecimal.ONE);
                ficha.setRebotes(BigDecimal.ONE);
                s.save(ficha);
                s.getTransaction().commit();     
         }     
       s.close();
       tableVisit.clearSelection();
        tableLocal.clearSelection();
    }//GEN-LAST:event_rebDefBtnActionPerformed

    private void tiroBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tiroBtnActionPerformed
        CartaDeTiro nueva = new CartaDeTiro();
        nueva.setEnJuego(this);
        String dniJugador = getSelectedJugador();
        String equipo = getEquipoJugador(dniJugador);
        nueva.setDni(dniJugador);
        nueva.setEquipo(equipo);
        nueva.setPartido(this);
        nueva.setVisible(true);
        tableVisit.clearSelection();
        tableLocal.clearSelection();
    }//GEN-LAST:event_tiroBtnActionPerformed

    private void puntosLocalTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_puntosLocalTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_puntosLocalTfActionPerformed

    private void estadisticasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadisticasBtnActionPerformed
       // TODO add your handling code here:
        TablaEstadistica tLocal = new TablaEstadistica();
        TablaEstadistica Tvisitante = new TablaEstadistica();
        Estadistica estlocal = new Estadistica();
        Estadistica estvisit = new Estadistica();
        int JugadoresLocal = tableLocal.getRowCount();
        TablaEstadistica tabla = new TablaEstadistica();
        
        
        
        
        ArrayList<Jugador> jugadores =  new ArrayList();
        DefaultTableModel tModelLocal = (DefaultTableModel) tLocal.getJtable().getModel();
        DefaultTableModel tModelVisit = (DefaultTableModel) Tvisitante.getJtable().getModel();
        
        
        
        
        
        
        TablaLocal locales = new TablaLocal();
        TablaLocal visitantes = new TablaLocal();
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        System.out.println(idPartido);
        String query1 = "from Ficha where partido ="+idPartido;
        Query query = s.createQuery(query1);
        List list = query.list();
        List<Ficha> fichas= (List<Ficha>) list;
        System.out.println(fichas.size()+"fichas");
        for (Ficha f : fichas){
            String datos[] = new String[34];
           
        datos[0] =f.getJugador().toString();
        datos[1] = f.getPuntos().toString();
        datos[2] = f.getAsistencias().toString();
        datos[3] = f.getRebotes().toString();
        datos[4] = f.getRebOfensivos().toString();
        datos[5]  =f.getRebDefensivos().toString();
        datos[6]  =f.getTapones().toString();
        datos[7]  =f.getPerdidas().toString();
        datos[8]  =f.getFules().toString();
        datos[9]  =f.getRobos().toString();
        datos[10]  =f.getInLibres().toString();
        datos[11]  =f.getOutLibres().toString();
        datos[12]  =f.getInA3().toString();
        datos[13]  =f.getOutA3().toString();
        datos[14]  =f.getInA2().toString();
        datos[15]  =f.getOutA2().toString();
        datos[16]  =f.getInB3().toString();
        datos[17]  =f.getInB3().toString();
        datos[18]  =f.getOutB3().toString();
        datos[19]  =f.getOutB2().toString();
        datos[20] = f.getInC3().toString();
        datos[21] = f.getInC2().toString();
        datos[22] = f.getOutC3().toString();
        datos[23] = f.getOutC2().toString();
        datos[24] = f.getInD3().toString();
        datos[25] = f.getInD2().toString();
        datos[26] = f.getOutD3().toString();
        datos[27] = f.getOutD2().toString();
        datos[28] = f.getInE3().toString();
        datos[29] = f.getInE2().toString();
        datos[30] = f.getOutE3().toString();
        datos[31] = f.getOutE2().toString();
        datos[32] = f.getInF().toString();
        datos[33] = f.getOutF().toString();
               
            if(f.getCondicion().equals("local")){
                System.out.println(f.getCondicion());
                locales.agregarFila(datos);
                locales.setBounds(0, 0, 1000, 500);
                locales.setTitle("estadisticas Locales");
            }
            
            else{
                System.out.println(f.getCondicion());
                visitantes.agregarFila(datos);
                visitantes.setBounds(0,505,1000,500);
                visitantes.setTitle("estadisticas Visitantes");
            }
        }
        
       locales.setVisible(true);
       visitantes.setVisible(true);
        
        
        
        
        
        
                s.close();
       /* 
        for (int i= 0 ; i<JugadoresLocal; i++){
            String dni = (String)tableLocal.getValueAt(i, 2);
            CantPartidos filtroPartidos = new CantPartidos();
            filtroPartidos.setCantPartidos(1);
            filtroPartidos.setDniJugador(dni);
            //System.out.println(j.getDni().toString()+"esto lo imprimi ahora");
            estlocal.setFiltro(filtroPartidos);
            filtroPartidos.setFichas();
           
            
            
            
            FiltroRival filtro = new FiltroRival();
            filtro.setDniJugador(dni);
            filtro.setRival(visitante.getId().getNombre().toString());
            filtroAnd fAnd = new filtroAnd(estlocal.getFiltro(),filtroPartidos);
            estlocal.setFiltro(fAnd);
            
            fAnd.setFichas();
            
            List<Ficha> fichas =  fAnd.filtrar();
            if(i==0)
                tabla.setFichas(fichas);
            else
                tabla.addFichas(fichas);
            tabla.cargaDatos();
            
         
            
        }
        
        tabla.setVisible(true);

        */
        
        
        
    }//GEN-LAST:event_estadisticasBtnActionPerformed
       
    public String getSelectedJugador(){//ME QUEDO CON EL DNI DEL JUGADOR SELECCIONADO SEA DEL EQUIPO LOCAL O VISITANTE
       if(tableLocal.getSelectedRow()== -1){
           String primaryKey = (String) tableVisit.getValueAt(tableVisit.getSelectedRow(), 2);
           return primaryKey;
       }
       else{
           String primaryKey = (String) tableLocal.getValueAt(tableLocal.getSelectedRow(), 2);
           return primaryKey;
       }
           
     
    }
    
    public String getEquipoJugador(String dni){ // ME QUEDO CON EL EQUIPO DEL JUGADOR QUE LE MANDO COMO PARAMETRO
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        String query1 = "from Jugador where dni = "+dni;
        Query query = s.createQuery(query1);
        List list = query.list();
        Jugador j = (Jugador) list.get(0);
        String resultado = j.getEquipo().toString();
        s.close();
        return resultado;
    }
    
    public String getRival(String dni){
        if(getEquipoJugador(dni).equals(local.toString()))
            return visitante.toString();
        else 
            return local.toString();
        
    }
    
    public void sumarPuntosLocal(int puntos){
        PuntosLocal+=puntos;
        
        puntosLocalTf.setText(Integer.toString(PuntosLocal));
    }
    
    public void sumarPuntosVisit(int puntos){
        PuntosVisit+=puntos;
        puntosVisitaTf.setText(Integer.toString(PuntosVisit));
    }
    
    public String getLocal(){
        return local.getId().toString();
    } 
    
    public List<Ficha> existeFicha(String dni){
         Session s = NewHibernateUtil.getSessionFactory().openSession();
         s.beginTransaction();
         String query1 = "from Ficha where jugador = "+dni+" and partido = "+partido.getIdpartido();
         System.out.println(query1);
         Query query = s.createQuery(query1);
         List<Ficha> list = (List<Ficha>) query.list();
         s.close();
        return list;
        }
    
    public Ficha creaFicha(String dni,String equipo){
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        BigDecimal zero = BigDecimal.ZERO;
        Ficha f = new Ficha();
        String query1 = "from Ficha Order by idFicha DESC";
        Query query = s.createQuery(query1);
        List list = query.list();
        if (list.isEmpty())
          f.setIdficha(BigDecimal.ZERO);  
            else{
                Ficha ultima =(Ficha) list.get(0);
                BigDecimal Valor1 = new BigDecimal(1);
                f.setIdficha(ultima.getIdficha().add(Valor1));
            }
        BigDecimal match =partido.getIdpartido();
        f.setPartido(match);
        f.setEquipo(equipo);
        f.setRival(getRival(dni));
        String query2 = "from Jugador where dni = "+dni;
        Query querypei = s.createQuery(query2);
        List lista = querypei.list();
        Jugador j = (Jugador) lista.get(0);
        f.setJugador(j.getDni()); 
        f.setAnio(j.getEquipo().getId().getAnio());
        f.setAsistencias(zero);
        f.setFules(zero);
        if(equipo.toString().equals(local.toString()))
            f.setCondicion("local");
        else
            f.setCondicion("visitante");
        f.setInA2(zero);
        f.setInA3(zero);
        f.setInB3(zero);
        f.setInB2(zero);
        f.setInC2(zero);
        f.setInC3(zero);
        f.setInD2(zero);
        f.setInD3(zero);
        f.setInE2(zero);
        f.setInE3(zero);
        f.setInF(zero);
        f.setInLibres(zero);
        f.setOutA2(zero);
        f.setOutA3(zero);
        f.setOutB2(zero);
        f.setOutB3(zero);
        f.setOutC2(zero);
        f.setOutC3(zero);
        f.setOutD2(zero);
        f.setOutD3(zero);
        f.setOutE2(zero);
        f.setOutE3(zero);
        f.setOutF(zero);
        f.setOutLibres(zero);
        f.setPerdidas(zero);
        f.setPuntos(zero);
        f.setRebDefensivos(zero);
        f.setRebOfensivos(zero);
        f.setRebotes(zero);
        f.setRobos(zero);
        f.setTapones(zero);
        s.close();   
        return f;
    }


    
    
    
    
    
    
    
    
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnJuego(local,visitante).setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bloqueoBtn;
    private javax.swing.JButton buttAsistencia;
    private javax.swing.JButton estadisticasBtn;
    private javax.swing.JButton fullbtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton perdidaBtn;
    private java.awt.TextField puntosLocalTf;
    private java.awt.TextField puntosVisitaTf;
    private javax.swing.JButton rebDefBtn;
    private javax.swing.JButton rebOffBtn;
    private javax.swing.JButton robobtn;
    private javax.swing.JTable tableLocal;
    private javax.swing.JTable tableVisit;
    private javax.swing.JButton tiroBtn;
    // End of variables declaration//GEN-END:variables
}
