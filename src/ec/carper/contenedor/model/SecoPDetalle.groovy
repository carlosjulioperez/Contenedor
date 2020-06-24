package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Entity
@View(members="codigo; item")
class SecoPDetalle extends Identifiable{
   
    @ManyToOne
    SecoP secoP
   
    @Column(length=4) @Required
    @LabelFormat(LabelFormatType.SMALL)
    String codigo
   
    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList @NoCreate @NoModify @Required
    @LabelFormat(LabelFormatType.SMALL)
    Item item
}

