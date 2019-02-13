/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import obj.Ficha;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author nicol
 */
public abstract class Filtro { 
    protected String dniJugador;
    protected List<Ficha> fichas = new ArrayList();
    
    public void setDniJugador(String dniJugador) {
        this.dniJugador = dniJugador;
    }
    public abstract List<Ficha> filtrar();
    public void setFichas(){
         Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
         String query1 = " from Ficha where jugador = "+dniJugador+" Order by partido DESC";
         Query query = s.createQuery(query1);
         List<Ficha> list = (List<Ficha>) query.list(); 
         fichas = list;
         // System.out.println(fichas.get(0).getEquipo());
         s.close();
        
    }
 public List<Ficha> getFichas(){
     return fichas;
 }
}
