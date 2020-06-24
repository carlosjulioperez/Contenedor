package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Entity
@View(members="codigo;item;cumple")
class SecoDetalle extends Identifiable{
   
    @ManyToOne
    Seco seco
   
    @Column(length=4) @ReadOnly @Required
    @LabelFormat(LabelFormatType.SMALL)
    String codigo
   
    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList @ReadOnly @Required
    @LabelFormat(LabelFormatType.SMALL)
    Item item

    @Editor(forViews="TipoConRadioButton", value="ValidValuesRadioButton") @Required
    @LabelFormat(LabelFormatType.SMALL)
    Cumple cumple
    enum Cumple { SI, NO, NA }
}

