
import java.util.ArrayList;
import obj.Equipo;
import org.hibernate.Criteria;
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
public class RivalView extends javax.swing.JFrame {
    private ArrayList<Equipo> equipos =  new ArrayList();
    protected String dniJugador;
    protected Estadistica estadistica;
    /**
     * Creates new form RivalView
     */
    public RivalView() {
        initComponents();
        cargaEquipos();
        this.setLocationRelativeTo(null);
        setSize(300, 250);
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "indiferente" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(90, 60, 100, 22);

        jToggleButton1.setText("Añadir Filtro");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(90, 150, 103, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/INICIO.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 310, 250);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        FiltroRival filtro = new FiltroRival();
        filtro.setRival((String)jComboBox1.getSelectedItem());
        filtro.setDniJugador(dniJugador);
        if(estadistica.existeFiltro()){
             System.out.println("entrea filtro and");
           filtroAnd fAnd = new filtroAnd(estadistica.getFiltro(),filtro);
           estadistica.setFiltro(fAnd);
       }
       else{
           estadistica.setFiltro(filtro);
           filtro.setFichas();
             System.out.println("entre a condicion simple");
          
       }
       estadistica.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed
    public void setDni(String dni){
        this.dniJugador = dni;
    }
    public void setEstadistica(Estadistica estadistica){
        this.estadistica = estadistica;
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
            java.util.logging.Logger.getLogger(RivalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RivalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RivalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RivalView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RivalView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

    private void cargaEquipos() {
          Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Criteria criteria = s.createCriteria(Equipo.class);
        equipos = (ArrayList<Equipo>) criteria.list();
        
        for(Equipo e:equipos){
           jComboBox1.addItem(e.toString());
            
        }
         s.getTransaction().commit();
        s.close();
        
    }
}
