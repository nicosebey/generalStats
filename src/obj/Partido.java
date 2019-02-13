package obj;
// Generated 16/01/2018 17:51:42 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Partido generated by hbm2java
 */
public class Partido  implements java.io.Serializable {


     private BigDecimal idpartido;
     private String local;
     private String visitante;
     private BigDecimal anio;
     private BigDecimal ptslocal;
     private BigDecimal ptsvisit;

    public Partido() {
    }

	
    public Partido(BigDecimal idpartido, String local, String visitante) {
        this.idpartido = idpartido;
        this.local = local;
        this.visitante = visitante;
    }
    public Partido(BigDecimal idpartido, String local, String visitante, BigDecimal anio, BigDecimal ptslocal, BigDecimal ptsvisit) {
       this.idpartido = idpartido;
       this.local = local;
       this.visitante = visitante;
       this.anio = anio;
       this.ptslocal = ptslocal;
       this.ptsvisit = ptsvisit;
    }
   
    public BigDecimal getIdpartido() {
        return this.idpartido;
    }
    
    public void setIdpartido(BigDecimal idpartido) {
        this.idpartido = idpartido;
    }
    public String getLocal() {
        return this.local;
    }
    
    public void setLocal(String local) {
        this.local = local;
    }
    public String getVisitante() {
        return this.visitante;
    }
    
    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }
    public BigDecimal getAnio() {
        return this.anio;
    }
    
    public void setAnio(BigDecimal anio) {
        this.anio = anio;
    }
    public BigDecimal getPtslocal() {
        return this.ptslocal;
    }
    
    public void setPtslocal(BigDecimal ptslocal) {
        this.ptslocal = ptslocal;
    }
    public BigDecimal getPtsvisit() {
        return this.ptsvisit;
    }
    
    public void setPtsvisit(BigDecimal ptsvisit) {
        this.ptsvisit = ptsvisit;
    }




}


