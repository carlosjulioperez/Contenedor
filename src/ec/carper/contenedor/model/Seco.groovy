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
    contenedoresSecos [estandar20, estandar40, highCube40];
    detalle
""")
class Seco extends Identifiable{
    
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

    @ElementCollection
    @ListProperties("codigo,item.descripcion,cumple") @EditOnly
    Collection<SecoDetalle>detalle

    void cargarItems() throws ValidationException{
        try{
            this.itemsCargados = true
            cargarDetalles(this)
            getManager().persist(this)
        }catch(Exception ex){
            throw new SystemException("items_no_cargados", ex)
        }
    }

    void cargarDetalles(Seco seco){
        try{
            def lista = getManager().createQuery("FROM SecoPDetalle WHERE secoP.id = 1 ORDER BY codigo").getResultList()

            this.detalle = new ArrayList()
            lista.each{
                def d = new SecoDetalle()
                d.codigo = it.codigo
                d.item   = it.item
                this.detalle.add(d)
            }
        }catch(Exception ex){
            throw new SystemException("items_no_cargados", ex)
        }
    }
}
