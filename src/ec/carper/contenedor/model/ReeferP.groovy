package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Entity
@View(members="codigo,descripcion;detalle")
class ReeferP{
    @Id
    int codigo
    
    @Column(length=100) @Required
    String descripcion 

    @OneToMany (mappedBy="reeferP", cascade=CascadeType.ALL) @XOrderBy("codigo")
    Collection<ReeferPDetalle>detalle
}
