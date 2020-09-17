package ec.carper.contenedor.model

import javax.persistence.*
import org.openxava.annotations.*
import org.openxava.model.*

@Entity
@View(members="codigo,descripcion;detalle")
class SecoP{
    @Id
    int codigo
    
    @Column(length=100) @Required
    String descripcion 

    @OneToMany (mappedBy="secoP", cascade=CascadeType.ALL) @XOrderBy("codigo")
    Collection<SecoPDetalle>detalle
}
