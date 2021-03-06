
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.Timer;
import obj.Equipo;
import obj.EquipoId;
import org.hibernate.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public class EquipoView extends javax.swing.JFrame/*extends EquipoAbs*/ {
    
    static Inicio inicio;
    /**
     * Creates new form Equipo
     */
    public EquipoView(Inicio inicio) {
        this.inicio = inicio;
        initComponents();
        setSize(410, 320);
        this.setTitle("Nuevo Equipo");
        setLocationRelativeTo(null);
        setResizable(false);
        
    }  
  
   
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelEquipo = new javax.swing.JLabel();
        tEquipo = new javax.swing.JTextField();
        buttonAgregarEquipo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tAño = new javax.swing.JTextField();
        buttVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        labelEquipo.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        labelEquipo.setText("Nombre Equipo");
        getContentPane().add(labelEquipo);
        labelEquipo.setBounds(35, 115, 100, 16);
        getContentPane().add(tEquipo);
        tEquipo.setBounds(35, 138, 97, 22);

        buttonAgregarEquipo.setText("Agregar Equipo");
        buttonAgregarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarEquipoActionPerformed(evt);
            }
        });
        getContentPane().add(buttonAgregarEquipo);
        buttonAgregarEquipo.setBounds(129, 219, 121, 25);

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 13)); // NOI18N
        jLabel1.setText("Temporada");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(230, 110, 90, 16);
        getContentPane().add(tAño);
        tAño.setBounds(230, 140, 72, 22);

        buttVolver.setText("volver");
        buttVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttVolverActionPerformed(evt);
            }
        });
        getContentPane().add(buttVolver);
        buttVolver.setBounds(321, 13, 67, 25);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/INICIO.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-100, 0, 500, 310);

        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 400, 300);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAgregarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarEquipoActionPerformed
        // TODO add your handling code 
        
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        EquipoId eid = new EquipoId(tEquipo.getText(),new BigDecimal(tAño.getText()));
        Equipo equipo = new Equipo(eid);
        s.save(equipo);
        s.getTransaction().commit();
        s.close();
        MensajeEquipo nuevo = new MensajeEquipo();
        nuevo.setInicio(inicio);
        nuevo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_buttonAgregarEquipoActionPerformed

    private void buttVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttVolverActionPerformed
            // TODO add your handling code here:
            inicio.setVisible(true);
            setVisible(false);
    }//GEN-LAST:event_buttVolverActionPerformed

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(EquipoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquipoView(inicio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttVolver;
    private javax.swing.JButton buttonAgregarEquipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelEquipo;
    private javax.swing.JTextField tAño;
    private javax.swing.JTextField tEquipo;
    // End of variables declaration//GEN-END:variables
}
