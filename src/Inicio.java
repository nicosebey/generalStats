
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import obj.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public class Inicio extends javax.swing.JFrame {

    
    
    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(480, 370);
        jLabel3.setSize(480, 370);
        this.setResizable(false);
        this.setTitle("General stats");
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        nuevoEquipo = new javax.swing.JButton();
        nuevoPartido = new javax.swing.JButton();
        jJugador = new javax.swing.JButton();
        estadisticasBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sin título-1.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        nuevoEquipo.setText("Crear Equipo");
        nuevoEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(nuevoEquipo);
        nuevoEquipo.setBounds(30, 220, 107, 25);

        nuevoPartido.setText("Nuevo Partido");
        nuevoPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoPartidoActionPerformed(evt);
            }
        });
        getContentPane().add(nuevoPartido);
        nuevoPartido.setBounds(250, 220, 121, 25);

        jJugador.setText("Añadir jugador");
        jJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jJugadorActionPerformed(evt);
            }
        });
        getContentPane().add(jJugador);
        jJugador.setBounds(30, 150, 120, 25);

        estadisticasBtn.setText("ver estadisticas");
        estadisticasBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadisticasBtnActionPerformed(evt);
            }
        });
        getContentPane().add(estadisticasBtn);
        estadisticasBtn.setBounds(240, 150, 121, 25);

        jLabel1.setFont(new java.awt.Font("Sitka Small", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(61, 11, 102));
        jLabel1.setText("General Stats");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(90, 20, 270, 60);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Sin título-1.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 430, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoEquipoActionPerformed
        // TODO add your handling code here:
        EquipoView nuevo = new EquipoView(this);
        nuevo.setVisible(true);
        this.setVisible(false);
       
    }//GEN-LAST:event_nuevoEquipoActionPerformed

    private void nuevoPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoPartidoActionPerformed
        // TODO add your handling code here:
        NuevoPartidoView nuevo = new NuevoPartidoView();
        nuevo.setInicio(this);
        nuevo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_nuevoPartidoActionPerformed

    private void jJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jJugadorActionPerformed
        // TODO add your handling code here:
        newJugView ventana = new newJugView();
        ventana.setInicio(this);
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jJugadorActionPerformed

    private void estadisticasBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadisticasBtnActionPerformed
        Estadistica nueva = new Estadistica();
        nueva.setVisible(true);
        
    }//GEN-LAST:event_estadisticasBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
       
        });
        
        
        
        
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton estadisticasBtn;
    private javax.swing.JButton jJugador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton nuevoEquipo;
    private javax.swing.JButton nuevoPartido;
    // End of variables declaration//GEN-END:variables

}