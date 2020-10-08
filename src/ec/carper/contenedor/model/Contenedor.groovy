package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Entity
class Contenedor extends Identifiable{

    @Column(length=50) @Required
    String descripcion

}

