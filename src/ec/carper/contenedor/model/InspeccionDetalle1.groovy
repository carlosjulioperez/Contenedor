package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Embeddable
class InspeccionDetalle1{
   
    enum Lado { 
        IZQUIERDO, DERECHO
    }

    @Required
    Lado lado

    @Column(length=2) @Required
    int palletNo
    
    @Column(length=100) @Required
    String producto
    
    @Column(length=20) @Required
    String palletCodigo
    
    @Column(length=20)
    String loteCalibre
    
    @Column(length=20)
    String variedad
   
    @Column(length=2)
    int temperatura
   
    @Column(length=2)
    int cajasNo

}

