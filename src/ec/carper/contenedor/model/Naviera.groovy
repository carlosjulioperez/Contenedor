package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Entity
class Naviera extends Identifiable{

    @Column(length=30) @Required
    String descripcion

}

