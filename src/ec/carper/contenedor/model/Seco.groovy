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
    observaciones;
    titObservaciones { detalle }
    titBitacoraFirmas {
        inspector {
            inspectorHoraArribo, inspectorFechaArribo;
            inspectorHoraInicio, inspectorFechaInicio;
            inspectorHoraTermino, inspectorFechaTermino
        }
        chofer { 
            chofer; 
            placaCamion 
        }
        sellos { 
            selloArribo; selloSPS; selloCliente; selloNaviera; aptoEmbarque
        }
        responsables {
            inspectorSPSNombre, inspectorSPSCC;
            repCliNombre, repCliCC;
            repArea, repAreaCC
        }
    } 
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
    
    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList
    Cliente cliente 
    
    @Column(length=150) @DisplaySize(20)
    String referencia

    @ManyToOne(fetch=FetchType.LAZY) @DescriptionsList
    Naviera naviera
    
    boolean estandar20
    boolean estandar40
    boolean highCube40

    @Column(length=200)
    String observaciones

    @ElementCollection
    @ListProperties("codigo,item.descripcion,cumple") @EditOnly
    Collection<SecoDetalle> detalle

    @Stereotype("TIME") @Column(length=5)
    String inspectorHoraArribo
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) @LabelFormat(LabelFormatType.NO_LABEL) 
    LocalDate inspectorFechaArribo

    @Stereotype("TIME") @Column(length=5)
    String inspectorHoraInicio
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) @LabelFormat(LabelFormatType.NO_LABEL) 
    LocalDate inspectorFechaInicio

    @Stereotype("TIME") @Column(length=5)
    String inspectorHoraTermino
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) @LabelFormat(LabelFormatType.NO_LABEL) 
    LocalDate inspectorFechaTermino

    @Column(length=50)
    String chofer

    @Column(length=20)
    String placaCamion 

    @Column(length=50)
    String selloArribo 

    @Column(length=50)
    String selloSPS

    @Column(length=50)
    String selloCliente

    @Column(length=50)
    String selloNaviera 

    boolean aptoEmbarque

    @Column(length=50)// @DisplaySize(30)
    String inspectorSPSNombre
    @Column(length=13)
    String inspectorSPSCC

    @Column(length=50)
    String repCliNombre
    @Column(length=13)
    String repCliCC

    @Column(length=50)
    String repArea
    @Column(length=13)
    String repAreaCC

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
