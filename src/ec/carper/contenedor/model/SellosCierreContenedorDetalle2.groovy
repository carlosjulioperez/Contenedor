package ec.carper.contenedor.model

import java.time.LocalDate

import javax.persistence.*

import org.openxava.annotations.*
import org.openxava.calculators.*
import org.openxava.model.*

@Embeddable
class SellosCierreContenedorDetalle2{
   
    @Column(length=30)
    String numeroSello
   
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fechaSel

    @Stereotype("TIME") @Column(length=5)
    String horaSel
   
    @DefaultValueCalculator(CurrentLocalDateCalculator.class) // Fecha actual
    LocalDate fechaRup

    @Stereotype("TIME") @Column(length=5)
    String horaRup

}

