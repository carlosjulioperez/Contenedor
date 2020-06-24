package ec.carper.contenedor.model

import java.time.LocalDate
import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.calculators.*
import org.openxava.model.*

@Entity
@View(members="""#
    fecha, lugar, contenedor;
    cliente, referencia, naviera;
    contenedoresSecos [estandar20, estandar40, highCube40];
    contenedoresReefer [reefer20, reefer40, highCubeReefer40]
""")
class Reefer extends Identifiable{

    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    @Required
    LocalDate fecha
    
    @Column(length=150) @DisplaySize(20)
    String lugar
    
    @Column(length=150) @DisplaySize(20)
    String contenedor
    
    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList @NoCreate @NoModify
    Cliente cliente 
    
    @Column(length=150) @DisplaySize(20)
    String referencia

    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList @NoCreate @NoModify
    Naviera naviera
    
    boolean estandar20
    boolean estandar40
    boolean highCube40

    boolean reefer20
    boolean reefer40
    boolean highCubeReefer40

}

