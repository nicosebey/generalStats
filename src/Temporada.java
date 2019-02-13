
import java.util.ArrayList;
import java.util.List;
import obj.Ficha;
//import obj.Filtro;
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
public class Temporada  extends Filtro{
    private int temporada;

    
    public void setTemporada(int año){
        temporada = año;
    }
    @Override
    public List<Ficha> filtrar() {
         List<Ficha> lista = new ArrayList<>();
       int partidos = 0;
          Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
         String query1 = " from Ficha where jugador = "+dniJugador+" Order by partido DESC";
         Query query = s.createQuery(query1);
         List<Ficha> list = (List<Ficha>) query.list();  
         for (Ficha f:list){
             if (f.getAnio().intValue()==temporada){
                 lista.add(f);
         }
         }
        s.close();
        return lista;
    }
    
    
}
