package ec.carper.contenedor.model

import java.time.LocalDate
import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.calculators.*
import org.openxava.model.*
import org.openxava.jpa.*
import org.openxava.util.*
import org.openxava.validators.*
import static org.openxava.jpa.XPersistence.*

@Entity
@Tab(properties="""fecha,cliente.descripcion,naviera.descripcion""")
@View(members="""#
    fecha, lugar, contenedor;
    cliente, referencia, naviera;
    contenedoresReefers [estandar20, estandar40, highCube40];
    contenedoresReefer [reefer20, reefer40, highCubeReefer40];
    detalle
""")
class Reefer extends Identifiable{

    boolean itemsCargados

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

    @ElementCollection
    @ListProperties("codigo,item.descripcion,cumple") @EditOnly
    Collection<ReeferDetalle>detalle

    void cargarItems() throws ValidationException{
        try{
            this.itemsCargados = true
            cargarDetalles(this)
            getManager().persist(this)
        }catch(Exception ex){
            throw new SystemException("items_no_cargados", ex)
        }
    }

    void cargarDetalles(Reefer reefer){
        try{
            def lista = getManager().createQuery("FROM ReeferPDetalle WHERE reeferP.id = 1 ORDER BY codigo").getResultList()

            this.detalle = new ArrayList()
            lista.each{
                def d = new ReeferDetalle()
                d.codigo = it.codigo
                d.item   = it.item
                this.detalle.add(d)
            }
        }catch(Exception ex){
            throw new SystemException("items_no_cargados", ex)
        }
    }
}

