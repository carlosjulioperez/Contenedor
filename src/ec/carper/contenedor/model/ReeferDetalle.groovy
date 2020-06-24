package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Entity
@View(members="codigo,item,cumple")
class ReeferDetalle extends Identifiable{
   
    @ManyToOne
    Reefer reefer
   
    @Column(length=4) @ReadOnly @Required
    @LabelFormat(LabelFormatType.SMALL)
    String codigo
   
    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList @ReadOnly @Required
    @LabelFormat(LabelFormatType.SMALL)
    Item item

    @Editor(forViews="TipoConRadioButton", value="ValidValuesRadioButton") @Required
    @LabelFormat(LabelFormatType.SMALL)
    private Cumple cumple
    public enum Cumple { SI, NO };
}
