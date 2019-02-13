
import java.util.ArrayList;
import java.util.List;
import obj.Ficha;
//import obj.Filtro//
import org.hibernate.Query;
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
public class CantPartidos extends Filtro{

    private int cantPartidos;
    

    public void setCantPartidos(int cantPartidos) {
        this.cantPartidos = cantPartidos;
    }
    
    public int getCantPartidos(){
        return cantPartidos;
    }

    public CantPartidos() {
    }
    

    @Override
    public List<Ficha> filtrar() {
        List<Ficha> list =new ArrayList<Ficha>();
       int partidos = 0;
          /*Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
         String query1 = " from Ficha where jugador = "+dniJugador+" Order by partido DESC";
         Query query = s.createQuery(query1);
         List<Ficha> list = (List<Ficha>) query.list();*/
          
          
          
          
          
          
         for (Ficha f:fichas){
             if (cantPartidos >partidos){
                 list.add(f);
                 partidos++;
                }
         }
        System.out.println("luego de filtrar por cantPartidos el tamaño de la lsita de de "+list.size());
        return list;
    }

   

    
    
    
    
    
}
