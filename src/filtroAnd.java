
import java.util.ArrayList;
import java.util.List;
import obj.Ficha;
//import obj.Filtro;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nicol
 */
public class filtroAnd extends Filtro{
    
    private Filtro uno;
    private Filtro dos;

    public filtroAnd(Filtro uno, Filtro dos) {
        this.uno = uno;
        this.dos = dos;
    }

    @Override
    public List<Ficha> filtrar() {
        List<Ficha> list =new ArrayList<Ficha>();
        list.addAll(uno.filtrar());
        list.addAll(dos.filtrar());
        return list;
    }
    
    
}
