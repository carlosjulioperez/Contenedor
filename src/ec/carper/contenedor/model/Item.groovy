package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Entity
class Item extends Identifiable{

    @Column(length=150) @Required @DisplaySize(100)
    String descripcion

}

