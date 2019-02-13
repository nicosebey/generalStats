
import java.util.ArrayList;
import java.util.List;
import obj.Ficha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public class FiltroRival extends Filtro{
    private String rival;
    private String dniJugador;
    public FiltroRival() {
        this.setDniJugador(dniJugador);
        
        
    }

    @Override
    public List<Ficha> filtrar() {
        List<Ficha> list =new ArrayList<Ficha>();
        System.out.println(rival);
        for (Ficha f : fichas){
            System.out.println(f.getRival());
            if (f.getRival().equals(rival))
                list.add(f);
            
        }
        return list;
    }
   
    public void setRival(String rival){
        this.rival = rival;
    }

    public String getRival() {
        return rival;
    }
    
}
