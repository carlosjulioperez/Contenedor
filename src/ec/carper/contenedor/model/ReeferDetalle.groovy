package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Entity
@View(members="codigo,item,cumple")
class ReeferDetalle extends Identifiable{
   
    @ManyToOne
    Reefer reefer
   
    @Column(length=4) @Required
    @LabelFormat(LabelFormatType.SMALL)
    String codigo
   
    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList @ReadOnly @Required
    Item item

    @Editor(forViews="TipoConRadioButton", value="ValidValuesRadioButton") @Required
    private Cumple cumple
    public enum Cumple { SI, NO };
}

