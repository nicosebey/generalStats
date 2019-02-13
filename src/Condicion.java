
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
public class Condicion  extends Filtro{
    private String condicion;
    public void setCondicion(String condicion){
        this.condicion = condicion;
        this.setDniJugador(dniJugador);
        
    }
    
            
    @Override
    public List<Ficha> filtrar() {
        List<Ficha> lista = new ArrayList<>();
        
        /*Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        String query1 = " from Ficha where jugador = "+dniJugador+" Order by partido DESC";
        Query query = s.createQuery(query1);
        List<Ficha> list = (List<Ficha>) query.list(); */
       
        if((condicion.equals("indiferente")))
            lista = fichas;
        else
            for (Ficha f:fichas){
                System.out.println(fichas.get(0).getEquipo());
                if (f.getCondicion().equals(condicion)){
                    lista.add(f);
                
        }         }
                System.out.println("luego de filtrar por condicion el tamaño de la lsita de de "+lista.size());

        return lista;
    
    }
    
    
}
