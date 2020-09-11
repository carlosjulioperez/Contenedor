package ec.carper.contenedor.test

import java.time.*
import java.time.format.*

@Singleton
class Aux{
    def getFechaActual() {
        return LocalDate.now().format( DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    }
}
