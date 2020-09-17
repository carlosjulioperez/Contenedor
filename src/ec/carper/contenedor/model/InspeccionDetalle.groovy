package ec.carper.contenedor.model

import ec.carper.contenedor.actions.*
import ec.carper.contenedor.enums.*

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Embeddable
class InspeccionDetalle{
   
    @Column(length=4) @ReadOnly
    String codigo
   
    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList @ReadOnly
    Item item

    @Editor(value="ValidValuesRadioButton") @OnChange(InspeccionDetalleAction.class)
    OpcionSiNoNa cumple
}

