package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Embeddable
class SellosCierreContenedorDetalle3{
   
    @Column(length=100) @DisplaySize(30)
    String nombre 
   
    @Column(length=13)
    String cedula 
   
    @Column(length=100) @DisplaySize(30)
    String empresa 
   
    @Column(length=30)
    String cargo
   
}

