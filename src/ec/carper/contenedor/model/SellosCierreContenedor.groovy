package ec.carper.contenedor.model

import java.time.LocalDate
import javax.persistence.*

import org.openxava.annotations.*
import org.openxava.calculators.*
import org.openxava.model.*

@Entity
@Tab(properties="""fecha, cliente.descripcion, contenedor.descripcion, factura""")
@View(members="""#
    fecha, cliente, contenedor, factura;
    fechaIni, horaIni, fechaFin, horaFin;

    titSelColCieCon { detalle1 }
    titBitSel { detalle2 }
    titPerInv { detalle3 }

""")
class SellosCierreContenedor extends Identifiable{
    
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fecha
    
    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList
    Cliente cliente 
    
    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList
    Contenedor contenedor
    
    @Column(length=15)
    String factura 
    
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fechaIni

    @Stereotype("TIME") @Column(length=5)
    String horaIni
    
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fechaFin

    @Stereotype("TIME") @Column(length=5)
    String horaFin
    
    @ElementCollection
    Collection<SellosCierreContenedorDetalle1> detalle1

    @ElementCollection
    Collection<SellosCierreContenedorDetalle2> detalle2

    @ElementCollection
    Collection<SellosCierreContenedorDetalle3> detalle3

}
