package ec.carper.contenedor.model

import javax.persistence.*

import org.openxava.annotations.*
import org.openxava.model.*

@Embeddable
class SellosCierreContenedorDetalle1{
   
    @Column(length=30)
    String tiposSellos
   
    @Column(length=30)
    String numeracion 
   
}

