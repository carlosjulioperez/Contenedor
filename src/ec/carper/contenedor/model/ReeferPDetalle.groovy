package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Entity
@View(members="orden; codigo; item")
class ReeferPDetalle extends Identifiable{
   
    @ManyToOne
    ReeferP reeferP
   
    @Column(length=3) @Required
    @LabelFormat(LabelFormatType.SMALL)
    int orden

    @Column(length=4) @Required
    @LabelFormat(LabelFormatType.SMALL)
    String codigo
   
    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList @NoCreate @NoModify @Required
    Item item
}

