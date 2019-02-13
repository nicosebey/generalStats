/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obj;

import java.util.List;

/**
 *
 * @author nicol
 */
public class Calculadora {
    
    public List<Ficha> fichas;

    public Calculadora(List<Ficha> fichas) {
        this.fichas = fichas;
    }
    
    
public float getPorcentajeTriplesA(){
    float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInA3().floatValue();
        out+=f.getOutA3().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
    
}
public float getPorcentajeTriplesb(){
    float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInB3().floatValue();
        out+=f.getOutB3().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
}
public float getPorcentajeTriplesC(){
     float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInC3().floatValue();
        out+=f.getOutC3().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
}
public float getPorcentajeTriplesD(){
     float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInD3().floatValue();
        out+=f.getOutD3().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
}
public float getPorcentajeTriplesE(){
     float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInE3().floatValue();
        out+=f.getOutE3().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
}
public float getPorcentajeDoblesA(){
    float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInA2().floatValue();
        out+=f.getOutA2().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
}
public float getPorcentajeDoblesB(){
     float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInB2().floatValue();
        out+=f.getOutB2().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
}
public float getPorcentajeDoblesC(){
     float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInC2().floatValue();
        out+=f.getOutC2().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
}
public float getPorcentajeDoblesD(){
     float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInD2().floatValue();
        out+=f.getOutD2().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
}
public float getPorcentajeDoblesE(){
    float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInE2().floatValue();
        out+=f.getOutE2().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
}
public float getPorcentajeF(){
       float resultado;
    float in=0;
    float out=0; 
    for( Ficha f : fichas){
        in += f.getInF().floatValue();
        out+=f.getOutF().floatValue();
    }
    resultado = in/(in+out);
    return resultado;
}
public float getPuntos(){
    float partido=0;
    for(Ficha f : fichas){
        partido+=f.getPuntos().floatValue();}
    return partido;
}
public float getPuntosXPartido(){
    float partido=0;
    for(Ficha f : fichas)
        partido+=f.getPuntos().floatValue();
    return partido/fichas.size();
}
public float getAsistenciasXPartido(){
    float asistencias = 0;
    for(Ficha f : fichas)
        asistencias+=f.getAsistencias().floatValue();
    return asistencias/fichas.size();
}
public float getFulesXPartido(){ 
float asistencias = 0;
    for(Ficha f : fichas)
        asistencias+=f.getFules().floatValue();
    return asistencias/fichas.size();
}
public float tapasXPartido(){
    float asistencias = 0;
    for(Ficha f : fichas)
        asistencias+=f.getTapones().floatValue();
    return asistencias/fichas.size();
}
public float robosXPartido(){
    float asistencias = 0;
    for(Ficha f : fichas)
        asistencias+=f.getRobos().floatValue();
    return asistencias/fichas.size();
}
public float rebotesDefXPartido(){
    float asistencias = 0;
    for(Ficha f : fichas)
        asistencias+=f.getRebDefensivos().floatValue();
    return asistencias/fichas.size();
}
public float rebotesOffXpartido(){
    float asistencias = 0;
    for(Ficha f : fichas)
        asistencias+=f.getRebOfensivos().floatValue();
    return asistencias/fichas.size();
}
public float rebotesXPartido(){
    float asistencias = 0;
    for(Ficha f : fichas)
        asistencias+=f.getRebotes().floatValue();
    return asistencias/fichas.size();
}
public float perdidasXPartido(){
    float asistencias = 0;
    for(Ficha f : fichas)
        asistencias+=f.getPerdidas().floatValue();
    return asistencias/fichas.size();
}

}
